package com.test.dao;

import com.test.entity.Question;
import com.test.util.JavaUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
    drop table if exists Questions;
    create table Questions (
    num int primary key auto_increment,
    question varchar(100),
    a varchar(100),
    b varchar(100),
    c varchar(100),
    d varchar(100),
    answer varchar(100)
    );
 */
public class QuestionDao {

    JavaUtil util = new JavaUtil();

    //    注意！！！！！！：使用PreparedStatement的时候，executeUpdate的时候不用插入sql语句啦！！！！！！！！！！！！
    public int add(Question question) {
        PreparedStatement ps;
        int result = 0;
        String sql = "insert into questions (question, a, b, c, d, answer) values (?,?,?,?,?,?)";
        ps = util.createstatement(sql);
        try {
            ps.setString(1, question.getQuestion());
            ps.setString(2, question.getA());
            ps.setString(3, question.getB());
            ps.setString(4, question.getC());
            ps.setString(5, question.getD());
            ps.setString(6, question.getAnswer());
//          ！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
//          10月18日  8点到12点一直搜索误操作造成的异常，使用了PreparedStatement 执行sql语句时还在形参列表里插入sql语句！！！！！！！！！！
//          result = ps.executeUpdate(sql);
//          ！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
            result = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            util.close();
        }
        return result;
    }

    public List<Question> findAll() {
        String sql = "select * from Questions";
        ResultSet rs = null;
        PreparedStatement ps;
        List<Question> list = new ArrayList<>();
        ps = util.createstatement(sql);
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                int num = rs.getInt("num");
                String question = rs.getString("question");
                String a = rs.getString("a");
                String b = rs.getString("b");
                String c = rs.getString("c");
                String d = rs.getString("d");
                String answer = rs.getString("answer");
                Question question1 = new Question(num, question, a, b, c, d, answer);
                list.add(question1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            util.close(rs);
        }
        return list;
    }

    public int del(String num) {
        int resutl = 0;
        String sql = "delete from Questions where num =?";
        PreparedStatement ps = util.createstatement(sql);
        try {
            ps.setInt(1, Integer.parseInt(num));
            resutl = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            util.close();
        }
        return resutl;
    }

    public Question findById(String num) {
        String sql = "select * from Questions where num = ?";
        PreparedStatement ps = util.createstatement(sql);
        ResultSet rs = null;
        Question question1 = new Question();
        try {
            ps.setInt(1, Integer.parseInt(num));
            rs = ps.executeQuery();
            while (rs.next()) {
                rs.getInt("num");
                String question = rs.getString("question");
                String a = rs.getString("a");
                String b = rs.getString("b");
                String c = rs.getString("c");
                String d = rs.getString("d");
                String answer = rs.getString("answer");
                question1 = new Question(Integer.valueOf(num), question, a, b, c, d, answer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            util.close(rs);
        }
        return question1;
    }

    public int update(Question question) {
        int result =0 ;
        String sql = "update Questions set question=?,a=?,b=?,c=?,d=?,answer=? where num=?";
        PreparedStatement ps =null;
        ps = util.createstatement(sql);
        try {
            ps.setString(1, question.getQuestion());
            ps.setString(2, question.getA());
            ps.setString(3, question.getB());
            ps.setString(4, question.getC());
            ps.setString(5, question.getD());
            ps.setString(6, question.getAnswer());
            ps.setInt(7, question.getNum());
            result = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            util.close();
        }
        return result;
    }
}


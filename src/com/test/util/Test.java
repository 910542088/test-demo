package com.test.util;

import java.util.*;

public class Test {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        for (int i = 0; i <10 ; i++) {
//            list.add("list:"+i);
//        }
//
//        Iterator<String> it = list.iterator();
//        while (it.hasNext()){
//            System.out.println(it.next());
//        }

        Date starDate = new Date();
        Map<String,String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put("key"+i,"value"+i);
        }

        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry);
        }
        Date endsDate = new Date();
        System.out.println(endsDate.getTime()-starDate.getTime());


    }
}

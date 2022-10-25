package jvm;


import javabase.init.A;

import java.util.HashMap;

public class Demo1 {
    public static void main(String[] args) {
//        // 1024B * 1024 = 1K * 1024 = 1M
//        byte[] array1 = new byte[1024 * 1024];
//        array1 = new byte[1024 * 1024];
//        array1 = new byte[1024 * 1024];
//        array1 = null;
//        byte[] array2 = new byte[2 * 1024 * 1024];
        HashMap<A, String> map = new HashMap<>();
        A a = new A(1);
        map.put(a, "1");
        map.put(new A(2), "2");
        map.put(new A(3), "3");
        System.out.println(map.containsKey(new A(1)));
    }
}

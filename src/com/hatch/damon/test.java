package com.hatch.damon;

import java.util.Arrays;

public class test {

    /**
     * 冒泡排序
     *
     * @param args
     */
    public static int[] descMethod(int[] args) {

        int m;
        for (int i = 0; i < args.length; i++) {
            for (int j = i + 1; j < args.length; j++) {
                if (args[i] >= args[j]) {
                    continue;
                }
                m = args[i];
                args[i] = args[j];
                args[j] = m;
            }
        }
        System.out.println("面额倒序：" + Arrays.toString(args));
        return args;
    }


    /**
     * @param ints  纸币面额
     * @param total 总额
     */
    public static void get(int[] ints, int total) {
        int[] args = descMethod(ints);
        for (int i = 0; i < ints.length; i++) {
            int concur = args[i];
            if (total < concur) {
                continue;
            }
            int a = total / concur;
            total = total % concur;
            System.out.println("需要" + a + "张" + args[i]);
            if (total == 0) {
                return;
            }
        }

    }


    public static void main(String[] args) {
//        int[] ints = {1, 5, 10, 20, 50, 100};
//        get(ints, 163546);



        System.out.println(Integer.toBinaryString(5));
        System.out.println(Integer.toBinaryString(3));


        int a=1;
        a<<=1;
        System.out.println(a);

    }
}

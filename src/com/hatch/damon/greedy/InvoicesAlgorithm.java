package com.hatch.damon.greedy;


/**
 * 发票问题
 */
public class InvoicesAlgorithm {

    private static int[] LIMITS = {10, 10, 10};

    private static int[] INVOICES = {3, 4, 3, 5, 6, 8, 1, 6};

    // 首先定义一个3 * 8
    private static int[][] Checkerboard = new int[INVOICES.length][LIMITS.length];

    private static int COUNT = 0;

    public static void show() {
        System.out.println("第" + (++COUNT) + "次摆法");
        for (int i = 0; i < LIMITS.length; i++) {

            int totalChild;

            for (int j = 0; j < INVOICES.length; j++) {
                if (Checkerboard[j][i] == 1) {
                    totalChild = +INVOICES[j];
                }
            }
        }
    }
//    public static void show() {
//        System.out.println("第" + (++COUNT) + "次摆法");
//        for (int i = 0; i < INVOICES.length; i++) {
//            for (int j = 0; j < LIMITS.length; j++) {
//                System.out.print(Checkerboard[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }

    public static boolean check(int row, int col) {

        //对比行，左边不能有1
        for (int i = col - 1; i >= 0; i--) {
            if (Checkerboard[row][i] == 1)
                return false;
        }

        return true;
    }

    public static void play(int row) {
        for (int i = 0; i < LIMITS.length; i++) {
            if (check(row, i)) {
                Checkerboard[row][i] = 1;
                if (row == INVOICES.length - 1) {
                    show();
                } else {
                    play(row + 1);
                }
                Checkerboard[row][i] = 0;
            }

        }
    }

    public static void main(String[] args) {
        play(0);
    }

}

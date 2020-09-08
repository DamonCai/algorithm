package com.hatch.damon.greedy.invoices;

import java.util.Arrays;

public class InvoicesLoop {

    //每日报销额度
    private static int[] LIMITS = {150, 150, 150, 140};

    //所有发票
    private static int[] INVOICES = {220, 10, 100, 80, 110, 30, 40, 70};

    //矩阵
    private static int[][] MATRIX = new int[INVOICES.length][LIMITS.length];

    private static int COUNT = 0;

    public static boolean isEmpty(final CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    public static void prints() {
        String[] strs = new String[LIMITS.length];
        for (int i = 0; i < LIMITS.length; i++) {
            int totalChild = 0;
            String totalStr = "";
            for (int j = 0; j < INVOICES.length; j++) {
                if (MATRIX[j][i] == 1) {
                    totalChild = totalChild + INVOICES[j];
                    totalStr = totalStr + String.format("%4d", INVOICES[j]);
                }
            }
            if (totalChild < LIMITS[i]) {
                return;
            }
            strs[i] = totalStr;
        }

        if (!isEmpty(strs[LIMITS.length - 1])) {
            System.out.println("第" + (++COUNT) + "种排列");
            System.out.println(Arrays.toString(strs));
        }
    }

    public static boolean check(int row, int col) {
        //对比行，左边不能有1
        for (int i = col - 1; i >= 0; i--) {
            if (MATRIX[row][i] == 1)
                return false;
        }
        return true;
    }

    public static void loop(int row) {
        for (int i = 0; i < LIMITS.length; i++) {
            if (check(row, i)) {
                MATRIX[row][i] = 1;
                if (row == INVOICES.length - 1) {
                    prints();
                } else {
                    loop(row + 1);
                }
                MATRIX[row][i] = 0;
            }

        }
    }

    public static void main(String[] args) {
        loop(0);
    }

}

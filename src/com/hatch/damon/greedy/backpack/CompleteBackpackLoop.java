package com.hatch.damon.greedy.backpack;


/**
 * 完全背包问题
 */
public class CompleteBackpackLoop {


    /**
     * @param values  每个物品价值
     * @param weights 每个物品重量
     * @param max     包最大限制重量
     */
    private static void algorithm(int[] values, int[] weights, int max) {
        int nums = values.length;
        // 前i件物品在重量为j时候，最大价值
        int[][] bagvalue = new int[nums][max + 1];
        System.out.println();
        //循环物品个数
        for (int i = 0; i < nums; i++) {
            // 循环重量
            for (int j = 0; j <= max; j++) {

                if (i == 0 || j == 0) {
                    bagvalue[i][j] = 0;
                    System.out.print(String.format("%5d", bagvalue[i][j]));
                    continue;
                }

                if (weights[i] <= j) {
                    for (int k = 0; k * weights[i] <= j; k++) {
                        // 放入第i件物品后，减去数量1，减去可用重量weights[i]
                        int curr = bagvalue[i - 1][j - k * weights[i]] + k * values[i];
                        bagvalue[i][j] = Math.max(bagvalue[i][j], curr);
                    }
                } else {
                    bagvalue[i][j] = bagvalue[i - 1][j];
                }
                System.out.print(String.format("%5d", bagvalue[i][j]));


            }
            System.out.println();
        }

    }


    public static void main(String[] args) {

        int[] values = {0, 5, 8};
        int[] weights = {0, 5, 7};
        int max = 10;


        algorithm(values, weights, max);
    }


}

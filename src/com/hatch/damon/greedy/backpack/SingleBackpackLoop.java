package com.hatch.damon.greedy.backpack;

/**
 * 0-1背包问题
 */
public class SingleBackpackLoop {


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

                    // 前i-1件物品，重量为j时的价值
                    int last = bagvalue[i - 1][j];
                    // 放入第i件物品后，减去数量1，减去可用重量weights[i]
                    int curr = bagvalue[i - 1][j - weights[i]] + values[i];
                    bagvalue[i][j] = Math.max(last, curr);
                } else {
                    bagvalue[i][j] = bagvalue[i - 1][j];
                }
                System.out.print(String.format("%5d", bagvalue[i][j]));
            }
            System.out.println();
        }

    }

    /**
     * 0-1背包的优化解法
     * 思路：
     * 只用一个一维数组记录状态，dp[i]表示容量为i的背包所能装入物品的最大价值
     * 用逆序来实现
     */
    public static void ZeroOnePack2(int[] values, int[] weights, int max) {
        //动态规划
        int[] dp = new int[max + 1];
        int N = values.length;
        for (int i = 1; i < N + 1; i++) {
            //逆序实现
            for (int j = max; j >= weights[i - 1]; j--) {
                dp[j] = Math.max(dp[j - weights[i - 1]] + values[i - 1], dp[j]);
                System.out.print(String.format("%5d", dp[j]));

            }
            System.out.println();
        }
        System.out.println(String.format("%5d", dp[max]));
    }


    public static void main(String[] args) {

//        int[] values = {0, 3, 4, 5, 6};
//        int[] weights = {0, 2, 3, 4, 5};
//        int max = 8;


        int[] values = {0, 48, 7, 40, 12, 8};
        int[] weights = {0, 6, 1, 5, 2, 1};
        int max = 8;


        algorithm(values, weights, max);
        System.out.println("=======================================");
        ZeroOnePack2(values, weights, max);
    }
}

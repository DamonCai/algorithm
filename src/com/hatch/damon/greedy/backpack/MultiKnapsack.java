package com.hatch.damon.greedy.backpack;

import java.util.Arrays;

public class MultiKnapsack {
    private static int[] P = {2, 3, 4};
    private static int[] V = {3, 4, 5};
    private static int[] M = {4, 3, 2};
    private static int T = 15;

    private static int[] newResults = new int[T + 1];


    private static int ksp(int i, int t) {
        // 开始填表
        for (int m = 0; m < i; m++) {
            // 考虑第m个物品
            // 分两种情况
            // 1： M[m] * V[m] > T 则可以当做完全背包问题来处理
            if (M[m] * V[m] >= T) {
                for (int n = V[m]; n <= t; n++) {
                    newResults[n] = Math.max(newResults[n], newResults[n - V[m]] + P[m]);
                }
            } else {
                // 2： M[m] * V[m] < T 则需要在 newResults[n-V[m]*k] + P[m] * k 中找到最大值，0 <= k <= M[m]
                for (int n = V[m]; n <= t; n++) {
                    int k = 1;
                    while (k < M[m] && n > V[m] * k) {
                        newResults[n] = Math.max(newResults[n], newResults[n - V[m] * k] + P[m] * k);
                        k++;
                    }
                }
            }
            // 可以在这里输出中间结果
            System.out.println(Arrays.toString(newResults));
        }
        return newResults[newResults.length - 1];
    }

    public static void main(String[] args) {
        int result = ksp(P.length, T);
        System.out.println(result);
    }


}
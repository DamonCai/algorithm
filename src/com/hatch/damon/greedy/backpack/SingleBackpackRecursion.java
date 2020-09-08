package com.hatch.damon.greedy.backpack;

/**
 * 01背包问题递归法
 */
public class SingleBackpackRecursion {


    int[] vs = {0, 2, 4, 3, 7};
    int[] ws = {0, 2, 3, 5, 5};


    public void testKnapsack1() {
        int result = ks(4, 10);
        System.out.println(result);
    }

    /**
     *
     * @param i 物品个数
     * @param c 总重量限制
     * @return
     */
    private int ks(int i, int c) {
        int result;
        if (i == 0 || c == 0) {
            // 初始条件
            result = 0;
        } else if (ws[i] > c) {
            // 装不下
            result = ks(i - 1, c);
        } else {
            // 可以装下
            int tmp1 = ks(i - 1, c);
            int tmp2 = ks(i - 1, c - ws[i]) + vs[i];
            result = Math.max(tmp1, tmp2);
        }
        return result;
    }


    public static void main(String[] args) {
        SingleBackpackRecursion singleBackpackRecursion = new SingleBackpackRecursion();
        singleBackpackRecursion.testKnapsack1();
    }
}

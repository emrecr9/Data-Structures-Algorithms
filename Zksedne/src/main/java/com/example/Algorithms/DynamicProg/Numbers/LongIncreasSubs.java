package com.example.Algorithms.DynamicProg.Numbers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongIncreasSubs
{
    int lengthOfLIS(int[] nums)
    {
        int [] LIS = new int[nums.length];

        Arrays.fill(LIS, 1);

        for (int i = nums.length - 1; i > -1; i--)
        {
            for (int j = i + 1; j < nums.length;j++)
            {
                if (nums[i] < nums [j])
                    LIS[i] = Math.max(LIS[i], 1 + LIS[j]);
            }
        }

        return maxArray(LIS, nums.length);
    }

    private int maxArray (int []arr, int n)
    {
        Arrays.sort(arr);
        return arr[n - 1];
    }

    //-Coin change-------------------
    public int coinChange(int[] coins, int amount)
    {
        if (amount == 0)
            return 0;
        if (amount < 0)
            return amount + 1;

        int minCoin = (int) Double.POSITIVE_INFINITY;

        for (int coin : coins)
        {
            int change = coinChange(coins, amount - coin);

            if (change >= 0)
                minCoin = Math.min(change, minCoin);
        }

        if (minCoin != (int) Double.POSITIVE_INFINITY)
            return 1 + minCoin;
        else
            return -1;
    }

    public int coinChangeBotUp(int[] coins, int amount)
    {
        int [] table = new int[amount + 1];

        Arrays.fill(table, amount + 1);
        table[0] = 0;

        for (int i = 0; i <= amount; i++)
        {
            for (int coin : coins)
            {
                if ((i - coin) >= 0)
                    table[i] = Math.min(table[i], 1 + table[i - coin]);
            }
        }

        if (table[amount] != amount + 1)
            return table[amount];
        else
            return  -1;
    }

    public int coinChangeMemo(int[] coins, int amount, Map<Integer, Integer> memo)
    {
        if (memo.containsKey(amount))
            return memo.get(amount);

        if (amount == 0)
            return 0;
        if (amount < 0)
            return -1;

        int minCoin = (int) Double.POSITIVE_INFINITY;

        for (int coin : coins)
        {
            int change = coinChangeMemo(coins, amount - coin, memo);

            if (change >= 0)
                minCoin = Math.min(change, minCoin);
        }

        if (minCoin != (int) Double.POSITIVE_INFINITY)
            minCoin =  1 + minCoin;
        else
            minCoin =  -1;

        memo.put(amount, minCoin);

        return minCoin;
    }
}

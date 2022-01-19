package com.example.Algorithms.DynamicProg.Numbers;

import java.util.Arrays;
import java.util.Map;

public class canSum
{
    public boolean canSum(int targetSum, int [] numbers, Map<Integer, Boolean> memo)
    {
        if (memo.containsKey(targetSum))
            return memo.get(targetSum);

        if (targetSum == 0)
            return true;

        if (targetSum < 0)
            return false;

        for (int num : numbers)
        {
            int remainder = targetSum - num;

            if (canSum(remainder, numbers, memo))
            {
                memo.put(targetSum, true);
                return true;
            }

        }
        memo.put(targetSum, false);
        return false;
    }

    public boolean canSum(int targetSum, int [] numbers)
    {
        boolean table [] = new boolean[targetSum + 1];

        Arrays.fill(table, false);
        table[0] = true;

        for (int i = 0; i <= targetSum ; i++)
        {
            if (table[i])
            {
                for (int num: numbers)
                {
                    if ((i + num) < (targetSum + 1))
                        table[i + num] = true;
                }
            }
        }

        return table[targetSum];
    }
}

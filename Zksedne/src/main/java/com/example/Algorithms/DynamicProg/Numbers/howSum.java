package com.example.Algorithms.DynamicProg.Numbers;

import java.util.Arrays;
import java.util.Map;

public class howSum
{
    int [] howSum (int targetSum, int [] numbers, Map<Integer, int[]> memo)
    {
        if (memo.containsKey(targetSum))
            return memo.get(targetSum);

        if (targetSum == 0)
            return new int [] {};

        if (targetSum < 0)
            return null;

        for (int num : numbers)
        {
            int remainder = targetSum - num;
            int [] remainderResult = howSum(remainder, numbers, memo);

            if ( remainderResult != null)
            {
                memo.put(targetSum, addToArray(num, remainderResult));
                return memo.get(targetSum);
            }
        }

        memo.put(targetSum, null);
        return null;
    }

    private int [] addToArray(int num, int [] numbers)
    {
        int Length = numbers.length;
        int newNumbers [] = new int [Length + 1];

        for(int i = 0; i< Length; i++) {
            newNumbers[i] = numbers[i];
        }
        newNumbers[Length] = num;

        return newNumbers;
    }

    //------------------------------------------------------
    public int [] howSum (int targetSum, int [] numbers)
    {
        int [][] table = new int [targetSum + 1][];
        table[0] = new int []{};

        for (int i = 0; i <= targetSum; i++)
        {
            if (table[i] != null)
            {
                for (int num : numbers)
                {
                    if (i+num < targetSum + 1)
                        table[i+num] = addToArray( num, table[i]);
                }
            }
        }

 //       System.out.println(Arrays.deepToString(table));
        return table[targetSum];
    }
}

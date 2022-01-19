package com.example.Algorithms.DynamicProg.Numbers;

import java.util.Arrays;
import java.util.Map;

public class bestSum
{
    int [] bestSum(int targetSum, int [] numbers, Map<Integer, int[]> memo)
    {
        if (memo.containsKey(targetSum))
            return memo.get(targetSum);

        if (targetSum == 0)
            return new int [] {};

        if (targetSum < 0)
            return null;

        int [] shortestCombination = null;

        for (int num : numbers)
        {
            int remainder = targetSum - num;
            int [] remainderCombination = bestSum(remainder, numbers, memo);

            if (remainderCombination != null)
            {
                int [] combination = addToArray(num, remainderCombination);

                //if the curr combination is shortest than shortest -> update
                if (shortestCombination == null || combination.length < shortestCombination.length)
                {
                    shortestCombination = combination;
           //        System.out.println(Arrays.toString(shortestCombination));

                }
            }
        }

        memo.put(targetSum,shortestCombination);
        return shortestCombination;
    }

    public int [] bestSum (int  targetSum, int [] numbers)
    {
        int [][] table = new int [targetSum + 1][];
        table[0] = new int []{};

        for (int i = 0; i <= targetSum; i++)
        {
            if (table[i] != null)
            {
                for (int num: numbers)
                {
                    if (i+num < targetSum + 1)
                    {
                        int combination[] = addToArray(num, table[i]);

                        if (table[i+ num] == null || table[i+ num].length > combination.length)
                            table[i + num] = combination;
                    }
                }
            }

        }
         return table[targetSum];
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
}

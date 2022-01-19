package com.example.Algorithms.DynamicProg.Strings;

import java.util.Arrays;
import java.util.Map;

public class countConstruct
{
    public int countConstruct(String target, String[] wordkank, Map<String, Integer> memo)
    {
        if (memo.containsKey(target))
            return memo.get(target);

        if (target.equals(""))
            return 1;

        int ans = 0;

        for (String word : wordkank)
        {
            if (target.indexOf(word) == 0)
            {
                String suffix = target.substring(word.length());
                int numWaysForRest = countConstruct(suffix, wordkank, memo);
                ans = ans + numWaysForRest;
            }
        }

        memo.put(target,ans);

        return ans;
    }

    public int countConstruct(String target, String[] wordkank)
    {
        int table [] = new int [target.length() + 1];
        Arrays.fill(table, 0);

        table[0] = 1;

        for (int i = 0; i <= target.length(); i++)
        {
            for (String word: wordkank)
            {
                if (i + word.length() <= target.length())
                {
                    if (target.substring(i, i + word.length()).equals( word))
                    {
                        table[i + word.length()] = table[i + word.length()] + table[i];
                    }
                }
            }
        }

    //          System.out.println(Arrays.toString(table));

        return table[target.length()];
    }
}

package com.example.Algorithms.DynamicProg.Strings;

import java.util.Arrays;
import java.util.Map;

public class canConstruct
{
    public boolean canConstruct(String target, String[] wordkank, Map<String, Boolean> memo)
    {
        if (memo.containsKey(target))
            return memo.get(target);

        if (target.equals(""))
            return true;

        for (String word : wordkank)
        {
            if (target.indexOf(word) == 0)
            {
                String suffix = target.substring(word.length());

                if (canConstruct(suffix, wordkank, memo))
                {
                    memo.put(target, true);
                    return true;
                }
            }
        }

        memo.put(target, false);
        return false;
    }

    public boolean canConstruct(String target, String[] wordkank)
    {
        boolean table [] = new boolean[target.length() + 1];
        Arrays.fill(table, false);

        table[0] = true;

        for (int i = 0; i <= target.length(); i++)
        {
            if (table[i])
            {
                for (String word : wordkank)
                {
                    if (i + word.length() <= target.length())
                    {
                        if (target.substring(i, i + word.length()).equals( word))
                            table[i + word.length()] = true;
                    }
                }
            }
        }

  //      System.out.println(Arrays.toString(table));

        return table[target.length()];
    }
}

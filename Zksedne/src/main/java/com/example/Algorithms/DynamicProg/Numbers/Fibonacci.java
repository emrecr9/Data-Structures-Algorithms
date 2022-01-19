package com.example.Algorithms.DynamicProg.Numbers;

import java.util.Arrays;
import java.util.Map;

public class Fibonacci
{
    //memoization
    //key = arg to function, value will be a return value

    public int fib(int n, Map<Integer, Integer> memo)
    {
        if (memo.containsKey(n))
            return memo.get(n);

        if (n <= 2)
            return 1;

        memo.put(n, fib(n - 1, memo) + fib(n - 2, memo));
        return memo.get(n);
    }

    public int fib (int n)
    {
        int [] table  = new int [n + 1];

        Arrays.fill(table, 0);
        table[1] = 1;

        for (int i = 0; i <= n; i++)
        {
            //pas sur du if - fout peut-etre la merde
            if (i+1 <= n)
                table[i + 1] = table[i] + table [i + 1];

            //pas sur du if - fout peut-etre la merde
            if (i+2 <= n)
                table[i + 2] =  table[i] + table [i + 2];
        }

        return table[n];
    }

}

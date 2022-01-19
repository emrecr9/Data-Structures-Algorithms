package com.example.Algorithms.DynamicProg.Numbers;

import java.util.Arrays;
import java.util.Map;

public class gridTraveler
{
    public int gridTraveler (int m, int n, Map<String, Integer> memo)
    {
        String key =  m + "," + n;

        if (memo.containsKey(key))
            return memo.get(key);

        if (m == 1 && n == 1)
            return 1;
        if (m == 0 || n == 0)
            return 0;

        memo.put(key, gridTraveler(m - 1, n, memo) + gridTraveler (m, n - 1, memo));

        return memo.get(key);
    }

    public int gridTraveler (int m, int n)
    {
        int [][] table = new int [m+1][n+1];

        for (int [] array : table)
            Arrays.fill(array,0);

        table[1][1] = 1;

        for (int i = 0; i <= m; i++)
            for (int j = 0; j <= n; j++)
            {
                int current = table[i][j];

                if (j + 1 <= n)
                    table[i][j+1] = current + table[i][j+1];

                if (i + 1 <= m)
                    table[i+1][j] = current + table[i+1][j];
            }

        return table[m][n];
    }
}

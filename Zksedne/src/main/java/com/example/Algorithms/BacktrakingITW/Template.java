package com.example.Algorithms.BacktrakingITW;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Template
{
    public List<List<String>> solveNQueens(int n)
    {
        List<List<String>> solutions = new ArrayList<>();
        List<List<String>> state = new ArrayList<>();

     //   search(state, solutions, n);

        return solutions;
    }
    //-----------------------------------------
    boolean is_valid_state(List<List<String>> state, int n)
    {
        return state.size() == n;
    }

    List<Integer> get_candidates (List<List<String>> state, int n)
    {
        if (state.isEmpty())
            return range(n);

        int position = state.size();
        Set <Integer> candidates = new HashSet<>(range(n));



        return null;
    }

    public List<Integer> range (int n)
    {
        List<Integer> range = new ArrayList<>();

        for (int i = 0; i < n; i++)
        {
            range.add(i);
        }

        return range;
    }
}

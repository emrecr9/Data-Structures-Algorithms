package com.example.Algorithms.ElementK;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class elementFrequencyK
{
    static int findElement(int arr[], int k)
    {
        if (arr.length == 0)
            return 0;

        Map<Integer, Integer> table = new HashMap<>();

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++)
        {
            if (!table.containsKey(arr[i]))
                table.put(arr[i], 1);
            else
            {
                table.put(arr[i], table.getOrDefault(arr[i], 0) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> e : table.entrySet())
            if (e.getValue() == k)
                return e.getKey();

        return 0;
    }
    public static void main(String [] args)
    {
        int x = 2;
        int arr[] = {1, 2, 2,1,4,5};
        System.out.println(findElement(arr, x));
    }
}

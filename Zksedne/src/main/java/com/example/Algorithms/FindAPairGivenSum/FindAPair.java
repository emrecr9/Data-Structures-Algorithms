package com.example.Algorithms.FindAPairGivenSum;

import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public class FindAPair
{
    static Vector<Integer> findPair(int arr[], int x)
    {
        if (arr.length < 2)
            return null;

        Set<Integer> set = new HashSet<Integer>();

        set.add(arr[0]);

        for(int i = 1; i < arr.length; i++)
        {
            if (set.contains(x - arr[i]))
            {
                Vector<Integer> temp = new Vector<>();
                temp.add(x - arr[i]);
                temp.add(arr[i]);

                return temp;
            }

            set.add(arr[i]);
        }

        return null;
    }

    public static void main(String [] args)
    {
        int x = 5;
        int arr[] = {1,2,3,4};
        System.out.println(findPair(arr, x));
    }
}

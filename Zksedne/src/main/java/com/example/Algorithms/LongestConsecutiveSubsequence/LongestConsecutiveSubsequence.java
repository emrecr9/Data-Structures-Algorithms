package com.example.Algorithms.LongestConsecutiveSubsequence;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSubsequence
{
    static int findSequence(int arr[])
    {
        if (arr.length == 0)
            return 0;

        Set<Integer> set = new HashSet<Integer>();
        int maxL = 0;

        for (int i = 0; i < arr.length; i++)
            set.add(arr[i]);

        for (int i = 0; i < arr.length; i++)
        {
            if (!set.contains(arr[i] - 1))
            {
                int currentL = 1, currentNum = arr[i];

                while (set.contains(currentNum + 1))
                {
                    currentNum++;
                    currentL++;
                }

                if (maxL < currentL)
                    maxL = currentL;
            //    maxL = Math.max(maxL, currentL);
            }
        }

        return maxL;
    }

    static int lengthOfLongestSubstring(String s)
    {
        if (s.length() == 0)
            return 0;

        Map<Character, Integer> set = new HashMap<>();

        int maxL = 0, currentL = 0;

        for (int i = 0; i < s.length(); i++)
        {
            if (!set.containsKey(s.charAt(i)))
            {
                set.put(s.charAt(i), i);
                currentL++;
            }
            else
            {
                int prevDupliPosition = set.get(s.charAt(i));

                // set.clear();
                set = new HashMap<>();
                currentL = i - prevDupliPosition;

                for (int j = 0; j < currentL; j++)
                    set.put(s.charAt(i - j), (i - j));
            }
            maxL = Math.max(maxL, currentL);
        }

        return maxL;

    }


    public static void main(String [] args)
    {
        int x = 2;
        int arr[] = {36, 41, 56, 35, 44, 33, 34, 43, 92, 32, 42};
        System.out.println(findSequence(arr));
    }
}

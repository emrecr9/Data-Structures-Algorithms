package com.example.Algorithms.CommonITWquest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Node<T>
{
    T val;
    Node left;// = null;
    Node right ;//= null;

    Node (T val) { this.val = val;}
}

public class CommonProblems1
{
    //Anagrams--------------------------------
    //----time o(n) - space o(n)
    boolean are_Anagrams(String s1, String s2)
    {
        if (s1.length() != s2.length())
            return false;

        Map<Character, Integer> freq1 = new HashMap();
        Map<Character, Integer> freq2 = new HashMap();

        for (int i = 0; i < s1.length(); i++)
        {
            if (freq1.containsKey(s1.charAt(i)))
                freq1.put(s1.charAt(i), freq1.get(s1.charAt(i)) + 1);
            else
                freq1.put(s1.charAt(i),1);
        }

        for (int i = 0; i < s2.length(); i++)
        {
            if (freq2.containsKey(s2.charAt(i)))
                freq2.put(s2.charAt(i), freq2.get(s2.charAt(i)) + 1);
            else
                freq2.put(s2.charAt(i),1);
        }

        for (Map.Entry<Character, Integer> entry : freq1.entrySet())
        {
            if (!freq2.containsKey(entry.getKey()) || freq1.get(entry.getKey()) != freq2.get(entry.getKey()))
                return false;
        }

        return true;
    }

    //----time o(nlog(n)) - space o(n)
    boolean Are_Anagrams(String s1, String s2)
    {
        if (s1.length() != s2.length())
            return false;

        if (!sort(s1).equals(sort(s2)))
            return false;

        return true;
    }

    private String sort(String s)
    {
        char tempArray[] = s.toCharArray();

        // Sorting temp array using
        Arrays.sort(tempArray);

        // Returning new sorted string
        return new String(tempArray);
    }
    //find Start and end positions in sorted list----------------------------------

    int [] find_Start_Last(int [] arr, int target)
    {
        if (arr.length == 0 || arr[0] > target || arr[arr.length-1] < target)
            return new int [] {-1, -1};

        return new int [] {find_Start(arr, target), find_End(arr, target)};
    }

    private int find_Start(int [] arr, int target)
    {
        if (arr[0] == target)
            return 0;

        int left = 0, right = arr.length - 1;

        while (left < right)
        {
            int mid = (left + right)/2;

            if (arr[mid] == target && arr[mid-1] < target)
                return mid;
            else if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return -1;
    }

    private int find_End(int [] arr, int target)
    {
        if (arr[arr.length-1] == target)
            return arr.length - 1;

        int left = 0, right = arr.length - 1;

        while (left <= right)
        {
            int mid = (left + right)/2;

            if (arr[mid] == target && arr[mid+1] > target)
                return mid;
            else if (arr[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }

        return -1;
    }
    //Find the k-th largest element-------------------------------------------------
    //----time o(nlog(n)) - space o(1)
    int kth_element(int [] arr, int k)
    {
        if (k > arr.length || k < arr.length)
            return -1;
        Arrays.sort(arr);

        return arr[arr.length - 1 - k];
    }

    //if Tree is symetric-------------------------------------------------
    //----time o(n) - space o(n)
    boolean is_Symetric(Node root)
    {
        if (root == null)
            return true;

        return are_Symetric(root.left, root.right);
    }

    boolean are_Symetric(Node root1, Node root2)
    {
        if (root1 == null && root2 == null)
            return true;

        if (root1 == null || root2 == null)
            return false;

        if (root1.val != root2.val)
            return false;

        return are_Symetric(root1.left, root2.right) && are_Symetric(root1.right, root2.left);
    }
}

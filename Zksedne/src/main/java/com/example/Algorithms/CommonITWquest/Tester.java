package com.example.Algorithms.CommonITWquest;

import java.util.Arrays;
import java.util.HashMap;

public class Tester
{
    public static void main (String [] args)
    {
        CommonProblems1 cp1 = new CommonProblems1();

        Node root1 = new Node(1);
        Node b1 = new Node(2);
        Node c1 = new Node(2);
        Node d1 = new Node(3);
        Node e1 = new Node(4);
        Node f1 = new Node(4);
        Node g1 = new Node(3);


        root1.left = b1;
        root1.right = c1;
        b1.left = d1;
        b1.right = e1;
        c1.right = g1;
        c1.left = f1;

        System.out.println(Arrays.toString(cp1.find_Start_Last(new int [] {0,2,4,5,5,5,5,5,7,9,9} , 5)));
        System.out.println(cp1.is_Symetric(root1));


    }
}

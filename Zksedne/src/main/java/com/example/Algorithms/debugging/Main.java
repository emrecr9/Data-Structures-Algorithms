package com.example.Algorithms.debugging;


public class Main {
    public static void main(String[] args)
    {
        ListNode n0 = new ListNode(0);
        System.out.println("Test 1 passed: " + (getLength(n0) == 1));

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        System.out.println("Test 2 passed: " + (getLength(n1) == 2));
    }

    public static int getLength(ListNode node)
    {
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }

        return length;
    }

    public static class ListNode {
        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
        }
    }
}
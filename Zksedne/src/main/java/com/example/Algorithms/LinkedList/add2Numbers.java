package com.example.Algorithms.LinkedList;

class Node
{
    int val;
    Node next;

    Node (int val) { this.val = val;}
}

public class add2Numbers
{
    public static void main(String[] args)
    {
        Node h1 = new Node(2);
        h1.next = new Node(9);
        h1.next.next = new Node(1);

        Node h2 = new Node(5);
        h2.next = new Node(6);
   //     h2.next.next = new Node(4);

        Node r = addNumbers(h1, h2, 0);

        while ( r != null)
        {
            System.out.println(r.val + " ");
            r= r.next;
        }
    }

    public static Node addNumbers(Node h1, Node h2, int rest)
    {
        Node result = null;
  //      int rest = 0;

        {
            int n1, n2;

            if (h1 == null)
                n1 = 0;
            else
            {
                n1 = h1.val;
                h1 = h1.next;
            }

            if (h2 == null)
                n2 = 0;
            else
            {
                n2 = h2.val;
                h2 = h2.next;
            }

            int val;

            if ((n1 + n2 + rest) > 9)
            {
                val = (n1 + n2) - 10;
                rest = 1;
            }
            else
                val = n1 + n2 + rest;

            result = new Node(val);

            if (h1 != null || h2 != null)
                result.next = addNumbers(h1, h2, rest);
        }

        return result;
    }


}

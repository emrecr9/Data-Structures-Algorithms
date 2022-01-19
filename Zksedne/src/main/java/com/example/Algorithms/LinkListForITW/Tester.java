package com.example.Algorithms.LinkListForITW;

public class Tester
{
    public static void main (String [] args) {

        LinkListOperations lk = new LinkListOperations();

        /*Node root = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");

        root.next = b;
        b.next = c;
        c.next = d;

        System.out.println(lk.LListValues(root));*/
        Node root = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");

        root.next = b;
        b.next = c;
        c.next = d;

        Node root1 = new Node(3);
        Node b1 = new Node(11);
        Node c1 = new Node(4);
        Node d1 = new Node(4);
        Node e1 = new Node(2);
        Node f1 = new Node(1);

        root1.next = b1;
        b1.next = c1;
        c1.next = d1;
        d1.next = e1;


        System.out.println(lk.LListValues(root));
        System.out.println(lk.LListValues(lk.zippList(root, root1)));
        System.out.println(lk.LListValues(lk.reverseList(root)));
  //      System.out.println(lk.LListValues(root));
   //     System.out.println(lk.getValueNode(root, 7));
    }
}

package com.example.Algorithms.BinTreeForITW;

public class Tester
{

    public static void main (String [] args)
    {
        /*
        BinaryTreeTraversals bt = new BinaryTreeTraversals();

        Node root = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");
        Node e = new Node("e");
        Node f = new Node("f");

        root.left = b;
        root.right = c;
        b.left = d;
        b.right = e;
        c.right = f;

        System.out.println(bt.depthFirstValuesStack(root));
 //       System.out.println(bt.depthFirstValuesRec(root));
        System.out.println(bt.BreathFirstValues(root));
        System.out.println(bt.treeIncludesBF(root, "e"));
        System.out.println(bt.treeIncludesRecurs(root, "W"));*/

        //------------------------------------------------------
        BinaryOperations bo = new BinaryOperations();

        Node root1 = new Node(3);
        Node b1 = new Node(11);
        Node c1 = new Node(4);
        Node d1 = new Node(4);
        Node e1 = new Node(2);
        Node f1 = new Node(1);

        root1.left = b1;
        root1.right = c1;
        b1.left = d1;
        b1.right = e1;
        c1.right = f1;

        System.out.println(bo.treeSumRecurs(root1));
    //    System.out.println(bo.treeSumIter(root1));
    //    System.out.println(bo.treeMinValItera(root1));
        System.out.println(bo.treeMinValRecurs(root1));
        System.out.println(bo.maxLeafRecurs(root1));
        System.out.println("SLR = " + bo.sumDepthNodes(root1));
    }
}

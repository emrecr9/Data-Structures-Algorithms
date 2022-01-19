package com.example.Algorithms.BinTreeForITW;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryOperations
{
    //-------Tree sum--------------------------------
    int treeSumRecurs(Node root)
    {
        if (root == null)
            return 0;

        return  (int) root.val + treeSumRecurs(root.left) + treeSumRecurs(root.right);
    }

    int treeSumIter(Node root)
    {
        if (root == null)
            return 0;
        String line = "";
        String [] tmpRequisites = line.split(" ");
        List<Integer> requisites = new ArrayList<>();

        for (String s : tmpRequisites)
            requisites.add(Integer.parseInt(s));

        Queue<Node> queue = new LinkedList<Node>();
        int result = 0;

        queue.add(root);

        while(!queue.isEmpty())
        {
            Node current = queue.poll();

            result = result + (int) current.val;

            if (current.left != null)
                queue.add(current.left);

            if (current.right != null)
                queue.add(current.right);
        }
        return  result;
    }

    //-------Min val--------------------------------
    int treeMinValItera(Node root)
    {
        Stack<Node> stack = new Stack<>();
        int result = (int) Double.POSITIVE_INFINITY;

        stack.add(root);

        while (!stack.empty())
        {
            Node current = stack.pop();

            if ((int) current.val < result)
                result = (int) current.val;

            if (current.left != null)
                stack.add(current.left);
            if (current.right != null)
                stack.add(current.right);
        }
        return result;
    }

    int treeMinValRecurs(Node root)
    {
        if (root == null)
            return (int) Double.POSITIVE_INFINITY;

        int minLeft = treeMinValRecurs(root.left);
        int minRight = treeMinValRecurs(root.right);

        return Math.min(Math.min((int) root.val, minLeft), minRight);
    }

    //------Max root ot leaf Path-----------------------
    int maxLeafRecurs(Node root)
    {
        if (root == null)
            return -1* ((int) Double.POSITIVE_INFINITY);;

        if (root.left == null && root.right == null)
            return (int) root.val;//-1* ((int) Double.POSITIVE_INFINITY);

        int leftSum = maxLeafRecurs(root.left);
        int rightSum = maxLeafRecurs(root.right);

        return (int) root.val + Math.max(rightSum, leftSum);
    }
    //------Sum of the depth of the nodes--------------------
    int sumDepthNodes(Node root)
    {
        int ans = 0;

        return ExploreNode(root, ans) + ExploreNode(root.left, ans) + ExploreNode(root.right, ans);
    }

    private int ExploreNode(Node root, int previousLength)
    {
        if (root == null)
            return 0;

        int leftLR = ExploreNode(root.left, previousLength + 1);
        int rightLR = ExploreNode(root.right, previousLength + 1);

        return previousLength + leftLR + rightLR;
    }
    //-------Depth of a node k------------------------
    int depthOfNode(Node root, int k)
    {
        if (root == null)
            return 0;

        int depth = 0;

        if (root.val.equals(k))
            return depth;

        return 1 + depthOfNode(root.left, k) + depthOfNode(root.right, k);
    }
}

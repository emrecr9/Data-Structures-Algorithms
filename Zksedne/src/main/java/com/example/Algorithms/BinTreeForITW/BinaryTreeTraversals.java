package com.example.Algorithms.BinTreeForITW;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class Node<T>
{
    T val;
    Node left;// = null;
    Node right ;//= null;

    Node (T val) { this.val = val;}
}

public class BinaryTreeTraversals<T>
{
    //------preorder traversal ou depthFirstValues-----------------------------------------
    List<T> depthFirstValuesStack(Node root)
    {
        if (root == null)
            return null;

        Stack<Node> stack = new Stack<>();
        List<T> result = new ArrayList<>();

        stack.push(root);

        while (stack.size() > 0)
        {
            Node current = stack.pop();

            result.add((T) current.val);

            if (current.right != null)
                stack.push(current.right);

            if (current.left != null)
                stack.push(current.left);
        }

        return result;
    }

    List<T> depthFirstValuesRec(Node root)
    {
        if (root == null)
            return null;

        List<T> result = new ArrayList<>();

       List<T> leftVals = depthFirstValuesRec(root.left);
       List<T> rightVals = depthFirstValuesRec(root.right);

        result.add((T) root.val);

        result = addValues(result, leftVals);
        result = addValues(result, rightVals);


        return result;
    }

    //------root,then left, then right ou BreathFirstValues---------------------------------

    List<T> BreathFirstValues(Node root)
    {
        if (root == null)
            return null;

        Queue<Node> queue = new LinkedList<>();
        List<T> result = new ArrayList<>();

        queue.add(root);

        while (queue.size() > 0)
        {
            Node current = queue.poll();

            if (current.left != null)
                queue.add(current.left);
            if (current.right != null)
                queue.add(current.right);

            result.add((T) current.val);
        }

        return result;
    }

    //------tree includes-----------------------------------------

    boolean treeIncludesBF (Node root, T target)
    {
        if (root == null)
            return false;

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        while (queue.size() > 0)
        {
            Node current = queue.poll();

            if (current.val.equals(target))
                return true;

            if (current.left != null)
                queue.add(current.left);
            if (current.right != null)
                queue.add(current.right);
        }

        return false;
    }

    boolean treeIncludesRecurs (Node root, T target)
    {
        if (root == null)
            return false;

        if (root.val.equals(target))
            return true;

        return (treeIncludesRecurs(root.left, target) ||treeIncludesRecurs(root.right, target));
    }

    //------help function-----------------------------------------


    List<T> addValues(List<T> result, List<T> values)
    {
        if (values == null)
            return result;

        List<T> newResult = new ArrayList<>();

        for  (T val : result)
            newResult.add(val);

        for (T val : values)
                result.add(val);

        return result;
    }

}

package com.example.Algorithms.LinkListForITW;


import java.util.ArrayList;
import java.util.List;

class Node<T>
{
    T val;
    Node next;// = null;

    Node (T val) { this.val = val;}
}

public class LinkListOperations<T>
{
    //----print Linskedlist---------------------
    void printList(Node head)
    {
        Node current = head;

        while (current != null)
        {
            System.out.println(current.val);
            current = current.next;
        }
    }

    void printListRecurs(Node head)
    {
        if (head == null)
            return;
        System.out.println(head.val);
        printListRecurs(head.next);
    }
    //---return values------------------
    List<T> LListValues(Node head)
    {
        List<T> values = new ArrayList<>();

        if (head == null)
            return null;

        fillValues(head, values);
        return values;
    }

    private void fillValues(Node head, List<T> values)
    {
        if (head == null)
            return;

        values.add((T) head.val);
        fillValues(head.next, values);
    }
    //----sum list--------------------
    int sumList(Node head)
    {
        if (head == null)
            return 0;

        return (int) head.val + sumList(head.next);
    }
    //---find in the list------------

    boolean findList(Node head, T target)
    {
        if (head == null)
            return false;

        if (head.val.equals(target))
            return true;

        return findList(head.next, target);
    }

    boolean findListIter(Node head, T target)
    {

        Node current  = head;

        while (current != null)
        {
            if (current.val.equals(target))
                return true;

            current = current.next;
        }
        return false;
    }

    //---return value-----------
    T getValueNode(Node head, int index)
    {
        Node current = head;
        int count = 0;

        while (current != null)
        {
            if (count == index)
                return (T) current.val;

            current = current.next;
            count++;
        }

        return null;
    }

    T getValueNodeRec(Node head, int index)
    {
        if (head == null)
            return null;

        if (index == 0)
            return (T) head.val;

        return getValueNode(head.next, index-1);
    }
    //---reverse list--------------------------
    Node reverseList(Node head)
    {
        Node prev = null;
        Node current = head;


        while (current != null)
        {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    Node reversListRecurs(Node head, Node prev)
    {
        if (head == null)
            return prev;

        Node next = head.next;
        head.next = prev;

        return reversListRecurs(next, head);
    }

    //---Zipper list-----------------------------------

    Node zippList(Node head1, Node head2)
    {
        if (head1 == null)
            return head2;

        if (head2 == null)
            return head1;

        Node tail = head1;
        int count = 0;

        Node current1 = head1.next;
        Node current2 = head2;

        while (current1 != null && current2 != null)
        {
            if (count % 2 == 0)
            {
                tail.next = current2;
                current2 = current2.next;
            }
            else
            {
                tail.next = current1;
                current1 = current1.next;
            }

            tail = tail.next;
            count++;
        }

        if (current1 != null)
            tail.next = current1;

        if (current2 != null)
            tail.next = current2;

        return head1;
    }

    Node zippListRecurs(Node head1, Node head2)
    {
        if (head1 == null && head2 == null)
            return null;

        if (head1 == null)
            return head2;

        if (head2 == null)
            return head1;

        Node next1 = head1.next;
        Node next2 = head2.next;
        head1.next = head2;
        head2.next = zippListRecurs(next1, next2);

        return head1;
    }
}

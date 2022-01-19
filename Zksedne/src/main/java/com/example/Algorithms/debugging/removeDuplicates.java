package com.example.Algorithms.debugging;

public class removeDuplicates {

    public static void main(String[] args)
    {
        ListNode n1_1 = new ListNode(1);
        System.out.println("Test case 1 passed: " + removeDuplicates(n1_1).equals(n1_1));

        ListNode n2_1a = new ListNode(1);
        ListNode n2_1b = new ListNode(1);
        n2_1a.next = n2_1b;

        ListNode n2_answer = new ListNode(1);

        System.out.println("Test case 2 passed: " + removeDuplicates(n2_1a).equals(n2_answer));

        ListNode n3_1a = new ListNode(1);
        ListNode n3_1b = new ListNode(1);
        ListNode n3_2a = new ListNode(2);
        ListNode n3_2b = new ListNode(4);
        n3_1a.next = n3_1b;
        n3_1b.next = n3_2a;
        n3_2a.next = n3_2b;

        ListNode n3_answer1 = new ListNode(1);
        ListNode n3_answer2 = new ListNode(2);
        n3_answer1.next = n3_answer2;

        System.out.println("Test case 3 passed: " + removeDuplicates(n3_1a).equals(n3_answer1));

/*        ListNode l1 = null, l2 = null;
        System.out.println("is = " + l1.equals(l2));*/
    }

    public static ListNode removeDuplicates(ListNode head)
    {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = head;

        while (dummy != null && dummy.next != null)
        {
            if (dummy.data == dummy.next.data)
                dummy.next = dummy.next.next;
            else
                dummy = dummy.next;
        }
        return head;
    }

    public static class ListNode
    {
        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
        }

      /*  @Override
        public String toString()
        {
            StringBuilder sb = new StringBuilder();
            sb.append(data);
            while (next != null)
            {
                sb.append(data);
            }
            return sb.toString();
        }*/

        public boolean equals(ListNode n)
        {
            if (n == null)
                return false;

            if (data != n.data)
                return false;

            if (next == null)
            {
                if (n.next != null)
                    return false;
                else
                    return true;
            }

            return next.equals(n.next);
        }
    }
}



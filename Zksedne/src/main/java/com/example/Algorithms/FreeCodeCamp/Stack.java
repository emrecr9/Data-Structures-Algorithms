package com.example.Algorithms.FreeCodeCamp;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Stack<T> implements Iterable <T>
{
    private LinkedList<T> list = new LinkedList<T>();

    public Stack() {}
    public Stack(T firstElem) { push(firstElem); }
    public int size() { return list.size();}
    public boolean isEmpty() { return size() == 0;}
    public void push(T elem) { list.addLast(elem); }

    public T pop()
    {
        if (isEmpty())
            throw new EmptyStackException();
        return list.removeLast();
    }

    public T peek()
    {
        if (isEmpty())
            throw new EmptyStackException();
        return list.peekLast();
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        Queue<Integer> Q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        boolean visited[]=new boolean[V];

        Q.add(0);
        visited[0] = true;

        while (!Q.isEmpty())
        {
            int curr = Q.remove();
            ans.add(curr);

            ArrayList<Integer> node = adj.get(curr);

            for (int n: node)
            {
                if (!visited[n])
                {
                    visited[n] = true;
                    Q.add(n);
                }
            }
        }

        return ans;
    }
}

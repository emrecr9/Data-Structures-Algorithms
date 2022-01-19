package com.example.Algorithms.FreeCodeCamp;

import java.util.Iterator;
import java.util.LinkedList;

public class Queue <T> implements Iterable <T>
{
    private LinkedList <T> list = new LinkedList<T>();

    public Queue() {}
    public Queue(T firstElem) { offer (firstElem);}
    public int size() { return list.size();}
    public boolean isEmpty() { return size() == 0;}
    public void offer (T elem) { list.addLast(elem); }

    public T poll()
    {
        if (isEmpty())
            throw new RuntimeException("Queue Empty");
        return list.removeFirst();
    }

    public T peek()
    {
        if (isEmpty())
            throw new RuntimeException("Queue Empty");
        return list.peekFirst();
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}

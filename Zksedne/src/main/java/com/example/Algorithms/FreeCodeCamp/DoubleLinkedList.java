package com.example.Algorithms.FreeCodeCamp;

import java.util.Iterator;

public class DoubleLinkedList
{
    public class DoublyLinkedList <T> implements Iterable <T>
    {
        private int size = 0;
        private Node <T> head = null;
        private Node <T> tail = null;

        //internal class node
        private class Node <T>
        {
            T data;
            Node <T> prev, next;

            public Node (T data, Node <T> prev, Node <T> next)
            {
                this.data = data;
                this.prev =prev;
                this.next = next;
            }

            @Override
            public String toString() { return  data.toString(); }
        }

        //emplty the list , O(n)
        public void clear()
        {
            Node<T> trav = head;

            while (trav != null)
            {
                Node <T> next = trav.next;

                trav.prev = trav.next = null;
                trav.data = null;
                trav = next;
            }

            head = tail = trav = null;
            size = 0;
        }

        public int size() { return size;}
        public boolean isEmpty() { return size() == 0;}
        public void addFirst (T elem)
        {
            if (isEmpty())
                head = tail = new Node<T>(elem, null,null);
            else
            {
                head.prev = new Node <T> (elem, null, head);
                head = head.prev;
            }

            size++;
        }

        public void addLast(T elem)
        {
            if (isEmpty())
                head = tail = new Node<T>(elem, null,null);
            else
            {
                tail.next = new Node <T> (elem, tail, null);
                tail = tail.next;
            }

            size++;
        }

        public T peekFirst()
        {
            if (isEmpty())
                throw new  RuntimeException("Empty List");
            return head.data;
        }

        public T peekLast()
        {
            if (isEmpty())
                throw new  RuntimeException("Empty List");
            return  tail.data;
        }

        public T removeFirst()
        {
            if (isEmpty()) throw new  RuntimeException("Empty List");

            //extract data from head and move head pointer to the next node
            T data = head.data;
            head = head.next;
            --size;

            if (isEmpty()) // if empty set tail to null as erll
                tail = null;
            else
                head.prev = null; // do a memory clean of previou node

            return data;
        }

        public T removeLast()
        {
            if (isEmpty()) throw new  RuntimeException("Empty List");

            //extract data from head and move head pointer to the next node
            T data = tail.data;
            tail = tail.next;
            --size;

            if (isEmpty()) // if empty set tail to null as erll
                head = null;
            else
                tail.next = null; // do a memory clean of previou node

            return data;
        }

        private T remove (Node<T> node)
        {
            if (node.prev == null) return removeFirst();
            if (node.next == null) return removeLast();

            //make pointers of node to skip "node" itself and point tot he adjacent
            node.next.prev = node.prev;
            node.prev.next = node.next;

            //temp storing of the returned data
            T data = node.data;

            //clean memory
            node.data = null;
            node = node.prev = node.next = null;

            --size;

            return data;
        }

        public T removeAt(int index)
        {
            if (index < 0 || index >= size) throw new IllegalArgumentException();

            Node<T> trav;
            int i;

            //search from front
            if (index < size/2)
            {
                for (i = 0, trav = head; i != index; i++)
                    trav = trav.next;
            }
            //search from back
            else
            {
                for (i = size-1, trav = tail; i != index; i--)
                {
                    trav = trav.prev;
                }
            }

            return remove(trav);
        }

        public boolean remove (Object obj)
        {
            Node <T> trav = head;

            //support the search for null
            if (obj == null)
            {
                for (trav = head; trav != null; trav = trav.next)
                {
                    if (trav.data == null)
                    {
                        remove(trav);
                        return true;
                    }
                }
            }
            //for non null objects
            {
                for (trav = head; trav != null; trav = trav.next)
                {
                    if (obj.equals(trav.data))
                    {
                        remove(trav);
                        return true;
                    }
                }
            }
            return false;
        }

        public int indexOf (Object obj)
        {
            Node <T> trav = head;
            int index = 0;

            //support the search for null
            if (obj == null)
            {
                for (trav = head; trav != null; trav = trav.next, index++)
                    if (trav.data == null)
                        return index;
            }
            //for non null
            else
            {
                for (trav = head; trav != null; trav = trav.next, index++)
                    if (obj.equals(trav.data ))
                        return index;
            }

            return -1;
        }

        public boolean contains (Object obj) { return indexOf(obj) != -1; }

        @Override
        public Iterator<T> iterator() {
            return new Iterator<T> ()
            {
                private Node <T> trav = head;

                @Override
                public boolean hasNext() {
                    return trav != null;
                }

                @Override
                public T next()
                {
                    T data = trav.data;
                    trav = trav.next;

                    return data;
                }
            };
        }

        @Override
        public String toString()
        {
            StringBuilder sb = new StringBuilder();
            Node <T> trav = head;
            sb.append("[ ");

            while (trav != null)
            {
                sb.append(trav.data + ", ");
                trav = trav.next;
            }

            sb.append(" ]");
            return  sb.toString();
        }
    }
}

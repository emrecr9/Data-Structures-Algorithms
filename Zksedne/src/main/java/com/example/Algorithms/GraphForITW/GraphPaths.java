package com.example.Algorithms.GraphForITW;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class GraphPaths<T>
{
    //---Graph Traversal------------------------------------
    void depthFirstPrint(Map<String, List<T>> graph, T source)
    {
        Stack<T> stack = new Stack<>();
        stack.add(source);

        while (!stack.empty())
        {
            T current = stack.pop();

            System.out.println(current);

            for (T neighbor: graph.get(current))
            {
                stack.add(neighbor);
            }
        }
    }

    void depthFirstPrintRecur(Map<String, List<T>> graph, T source)
    {
        System.out.println(source);

        for (T neighbor:graph.get(source))
            depthFirstPrint(graph, neighbor);
    }

    void breathFirstPrint (Map<String, List<T>> graph, T source)
    {
        Queue<T> queue = new LinkedList<>();

        queue.add(source);

        while (!queue.isEmpty())
        {
            T current = queue.poll();

            System.out.println(current);

            for (T neighbor : graph.get(current))
                queue.add(neighbor);
        }
    }
    //----has path problem--------------------------------------
    boolean hasPathDFSRecur(Map<String, List<T>> graph, T source, T destination)
    {
        if (source.equals(destination))
            return true;

        for (T neighbor : graph.get(source))
        {
            if (hasPathDFSRecur(graph, neighbor, destination))
                return true;
        }

        return false;
    }

    boolean hasPathDFSRecur(Map<String, List<T>> graph, T source, T destination, Set<T> visited)
    {
        if (visited.contains(source))
            return false;
        if (source.equals(destination))
            return true;

        visited.add(source);

        for (T neighbor : graph.get(source))
        {
            if (hasPathDFSRecur(graph, neighbor, destination, visited))
                return true;
        }

        return false;
    }

    boolean hasPathBFS(Map<String, List<T>> graph, T source, T destination)
    {
        Queue<T> queue = new LinkedList<>();
        queue.add(source);

        while (!queue.isEmpty())
        {
            T current = queue.poll();

            if (current.equals(destination))
                return true;

            for (T neighbor: graph.get(current))
            {
                queue.add(neighbor);
            }
        }

        return false;
    }
    //---Undirected path----------------------------------------

    boolean undirectedPath(List<List<T>> edges, T nodeA, T nodeB)
    {
        Map <String, List<T>> graph = buildGraph(edges);
    //    System.out.println(graph);
        return hasPathDFSRecur(graph, nodeA, nodeB, new HashSet<T>());
    }

    //---Hepler-------------------------------------------------
    private Map<String, List<T>> buildGraph(List<List<T>> edges)
    {
        Map <String, List<T>> graph = new HashMap<>();

        for (List<T> edge : edges)
        {
            T [] ab = (T[]) edge.toArray(new Object [0]);
            String a = (String) ab[0], b = (String) ab[1];

            if (!(graph.containsKey(a)))
                graph.put(a, new ArrayList());

            if (!(graph.containsKey(b)))
                graph.put(b, new ArrayList());

            graph.get(a).add((T) b);
            graph.get(b).add((T) a);


        }

 //       System.out.println(graph);
        return graph;
    }
}

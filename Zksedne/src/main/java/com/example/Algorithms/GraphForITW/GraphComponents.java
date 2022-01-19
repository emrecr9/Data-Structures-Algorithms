package com.example.Algorithms.GraphForITW;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class nodeDistance<T>
{
    T node;
    int distance;

    nodeDistance(T node, int distance)
    {
        this.node = node;
        this.distance = distance;
    }
}
public class GraphComponents<T>
{
    //---Connected component-------------------------
    int connectedCompCount (Map<T, List<T>> graph)
    {
        Set visited = new HashSet<>();
        int count = 0;


        for (Map.Entry<T, List<T>> node : graph.entrySet())
        {
    //        System.out.println(visited);
            if (explore(graph, node.getKey(), visited))
                count++;
        }

        return count;
    }

    //----help-----
    private boolean explore(Map<T, List<T>> graph, T current, Set<T> visited)
    {

        if (visited.contains(current))
            return false;

        visited.add((T) current);

        for (T neighbor: graph.get(current))
        {
            explore(graph, neighbor, visited);
        }

        return true;
    }

    //--Largest component-------------------
    int largestComp (Map<T, List<T>> graph)
    {
        Set visited = new HashSet<>();
        int largest = 0;

        for (Map.Entry<T, List<T>> node : graph.entrySet())
        {
            int count = exploreSize(graph, node.getKey(), visited);

            if (count > largest)
                largest = count;
        }

        return largest;
    }

    private int exploreSize(Map<T, List<T>> graph, T current, Set<T> visited)
    {
        if (visited.contains(current))
            return 0;

        int count = 1;

        visited.add((T) current);

        for (T neighbor: graph.get(current))
        {
            count = count + exploreSize(graph, neighbor, visited);
        }

        return count;
    }
    //---Shortest path-----------------------------
    int shortestPath(List<List<T>> edges, T nodeA, T nodeB)
    {
        Map <T, List<T>> graph = buildGraph(edges);
        Set <T> visited = new HashSet<>();
        Queue<nodeDistance> queue = new LinkedList<>();

        queue.add(new nodeDistance(nodeA, 0));
        visited.add(nodeA);

        while (!queue.isEmpty())
        {
            nodeDistance current = queue.poll();

            if (current.node.equals(nodeB))
                return current.distance;

            for (T neighbor : graph.get(current.node))
            {
                if (!visited.contains(neighbor))
                {
                    queue.add(new nodeDistance(neighbor, current.distance + 1));
                    visited.add(neighbor);
                }
            }
        }

        return -1;
    }
    //---class Schedule----------------------




    //---Helper------------------------------------
    private Map<T, List<T>> buildGraph(List<List<T>> edges)
    {
        Map <T, List<T>> graph = new HashMap<>();

        for (List<T> edge : edges)
        {
            T [] ab = (T[]) edge.toArray(new Object [0]);
            T a =  ab[0], b =  ab[1];

            if (!(graph.containsKey(a)))
                graph.put(a, new ArrayList());

            if (!(graph.containsKey(b)))
                graph.put(b, new ArrayList());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        //       System.out.println(graph);
        return graph;
    }
}

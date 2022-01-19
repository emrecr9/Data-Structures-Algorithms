package com.example.Algorithms.CommonITWquest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class CommonProblems2
{
    //is valid parenthesis combination---------------
    boolean is_valid(String combination)
    {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < combination.length(); i++)
        {
            char c = combination.charAt(i);

            if (c == '(')
                stack.push(c);
            else
            {
                if (stack.isEmpty())
                    return false;
                else
                    stack.pop();
            }
        }

        return stack.size() == 0;
    }

    //Backtracking problem = generate parenthesis---------------------------

    public List<String> generateParenthesis(int n)
    {
        List<String> res = new ArrayList<>();

        findallComb("(",1,0,res,n);

        return res;
    }

    void findallComb(String s, int open, int close,  List<String> res, int n)
    {
        if(s.length() == 2*n)
            res.add(s);

        if(open < n)
            findallComb(s + "(", open+1, close, res, n);

        if(close < open)
            findallComb(s + ")", open, close+1, res, n);
    }

    //Gas station problem---------------------------------------------
    int gasStation(int [] gas, int [] cost)
    {
        int restGas = 0;
        int prevRestGas = 0;
        int candidate = 0;

        for (int i = 0; i < gas.length; i++)
        {
            restGas = restGas + gas[i] - cost[i];

            if (restGas < 0)
            {
                candidate = i + 1;
                prevRestGas = prevRestGas + restGas;
                restGas = 0;
            }
        }

        if (candidate == gas.length || restGas + prevRestGas < 0)
            return  -1;
        else
            return candidate;
    }
    //course schedule---------------------
    //Note: Stack order est inutile. On peut faire sans
    boolean courseSchedule(int numCourses, int[][] prerequisites)
    {
        Map<Integer, List<Integer>> graph = buildCourses(numCourses, prerequisites);
        Set<Integer> visited = new HashSet<>();
        Set<Integer> path = new HashSet<>();
        Stack<Integer> order = new Stack<>();

        for (int i = 0; i < numCourses; i++)
        {
            if (!visited.contains(i))
            {
                visited.add(i);

                if (!dfs(graph,i, path,visited, order))
                    return false;
            }
        }

        return true;
    }
    boolean dfs(Map <Integer, List<Integer>> graph, int course, Set<Integer> path, Set<Integer> visited, Stack<Integer> order)
    {
        path.add(course);

        for (int neighbor: graph.get(course))
        {
            if  (path.contains(neighbor))
                return false;

            if (!visited.contains(neighbor))
            {
                visited.add(neighbor);

                if (!dfs(graph, neighbor, path, visited, order))
                    return false;
            }
        }

        path.remove(course);
        order.push(course);

        return true;
    }
    private Map <Integer, List<Integer>> buildCourses (int numCourses, int[][] prerequisites)
    {
        Map<Integer, List<Integer>> courses = new HashMap<>();

        // Create map of all possible courses. Some courses don't have prereq requirements (empty list).
        for(int i = 0; i < numCourses; i++)
            courses.put(i, new ArrayList<>());

        for(int[] prereq : prerequisites)
            courses.get(prereq[1]).add(prereq[0]);

        return courses;
    }

    //--Kth permutation---------------
    String kth_Permutation(int n, int k)
    {
        List<Integer> permutation = new ArrayList();
        List<Integer> unused = new ArrayList<>();

        int [] factor = factoriel(n);
        k = k-1;

        for (int i = 1; i < n+1; i++)
            unused.add(i);

        while (n > 0)
        {
            int partLength = factor[n]/n;
            int i = k/partLength;

            permutation.add(unused.get(i));
            unused.remove(i);

            n--;
            k = k % partLength;
        }

        String answer = "";

        for (int i : permutation)
            answer = answer + i;
        return answer;
    }

    int [] factoriel (int n)
    {
        int [] factor = new int[n+1];

        factor[0] = 1;

        for (int i = 1; i < n+1; i++)
            factor[i] = i * factor[i-1];

        return factor;
    }

    //CLASS SCHEDULE 2 ----------------
    public int [] findOrder(int numCourses, int[][] prerequisites)
    {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> cycle = new HashSet<>();
        Map<Integer, List<Integer>> prereq;
        List result = new ArrayList<>();

        prereq = buildGraph(prerequisites, numCourses);


        for (int i = 0; i < numCourses; i++)
        {
            if (!dfs(prereq, i, cycle, visited, result))
                return new int[]{};
        }

        System.out.println(result);

        return result.stream().mapToInt(i -> (int) i).toArray();
    }

    boolean  dfs(Map<Integer, List<Integer>> prereq, int course, Set<Integer> cycle, Set<Integer> visited, List result)
    {
        if (cycle.contains(course))
            return false;

        if (visited.contains(course))
            return true;

        cycle.add(course);

        for (int pre : prereq.get(course))
            if (!dfs(prereq, pre, cycle, visited, result))
                return false;

            cycle.remove(course);
            visited.add(course);
            result.add(course);

            return true;
    }

    private Map<Integer, List<Integer>> buildGraph(int[][] prerequisites, int numCourses)
    {
        Map <Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < numCourses; i++)
            graph.put(i, new ArrayList<>());

        for (int [] edge : prerequisites)
        {
            int a  = edge[0], b = edge[1];

            graph.get(a).add(b);
        }

        for (Map.Entry<Integer, List<Integer>> entry: graph.entrySet())
            Collections.sort(entry.getValue());

        return graph;
    }






}

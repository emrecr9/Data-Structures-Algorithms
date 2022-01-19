package com.example.Algorithms.GraphForITW;

import com.example.Algorithms.BacktrakingITW.Template;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Tester
{

    public static void main (String [] args)
    {
        //Map <String, List> graph = new HashMap<>();
        List<List<String>> edges = new ArrayList<>();
        GraphPaths gr = new GraphPaths();
        GraphComponents gc = new GraphComponents();
        GraphGrids gg = new GraphGrids();

        /*
        graph.put("a", Arrays.asList("c", "b"));
        graph.put("b", Arrays.asList("d"));
        graph.put("c", Arrays.asList("e"));
        graph.put("d", Arrays.asList("f"));
        graph.put("e", Arrays.asList());
        graph.put("f", Arrays.asList());

        edges.add(Arrays.asList("i", "j"));
        edges.add(Arrays.asList("k", "i"));
        edges.add(Arrays.asList("m", "k"));
        edges.add(Arrays.asList("k", "l"));
        edges.add(Arrays.asList("o", "n"));

     //   System.out.println(edges);
        //-----------------------------------------

       // gr.breathFirstPrint(graph, "a");
        System.out.println(gr.hasPathBFS(graph, "a", "f"));
        System.out.println(gr.undirectedPath(edges, "j", "n"));*/
       /* Map <Integer, List> graph = new HashMap<>();

        graph.put(0, Arrays.asList(0, 1, 5));
        graph.put(1, Arrays.asList(0));
        graph.put(5, Arrays.asList(0, 8));
        graph.put(8, Arrays.asList(0, 5));
        graph.put(2, Arrays.asList(3, 4));
        graph.put(3, Arrays.asList(2, 4));
        graph.put(4, Arrays.asList(3, 2));

        edges.add(Arrays.asList("w", "x"));
        edges.add(Arrays.asList("x", "y"));
        edges.add(Arrays.asList("y", "z"));
        edges.add(Arrays.asList("z", "v"));
        edges.add(Arrays.asList("v", "w"));

  //      System.out.println(graph);

        System.out.println(gc.shortestPath(edges, "w", "z"));*/
        List<List<Integer>> grid = new ArrayList<>();

       /* grid.add(Arrays.asList('W', 'L', 'W', 'W', 'W' ));
        grid.add(Arrays.asList('W', 'L', 'W', 'W', 'W'));
        grid.add(Arrays.asList('W', 'W', 'W', 'L', 'W'));
        grid.add(Arrays.asList('W', 'W', 'L', 'L', 'W'));
        grid.add(Arrays.asList('L', 'W', 'W', 'L', 'L'));
        grid.add(Arrays.asList('L', 'L', 'W', 'W', 'W'));*/

       /* //case 1
        grid.add(Arrays.asList(1,0,0,0,0,0));
        grid.add(Arrays.asList(0,1,0,1,1,1));
        grid.add(Arrays.asList(0,0,1,0,1,0));
        grid.add(Arrays.asList(1,1,0,0,1,0));
        grid.add(Arrays.asList(1,0,1,1,0,0));
        grid.add(Arrays.asList(1,0,0,0,0,1));*/

        //case 2
        grid.add(Arrays.asList(1,1,0,1,1,1));
        grid.add(Arrays.asList(1,1,0,1,1,1));
        grid.add(Arrays.asList(1,0,1,0,1,1));
        grid.add(Arrays.asList(1,1,0,0,1,1));
        grid.add(Arrays.asList(1,0,1,1,0,1));
        grid.add(Arrays.asList(1,1,1,1,1,1));

      //  System.out.println(gg.removeIsland(grid););
        System.out.println(gg.removeIsland(grid));

        Template t = new Template();

        Set <Integer> candidates = new HashSet<>(t.range(4));

        System.out.println(candidates);
       // int [] [] prerequisites = new int [] [] {{1,0},{2,0},{3,1},{3,2}};
        System.out.println(Arrays.toString(gc.findOrder(1, new int [][]{})));


    }
}

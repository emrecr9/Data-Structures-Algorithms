package com.example.Algorithms.GraphForITW;

import java.util.HashSet;
import java.util.List;
import java.util.Set;



public class GraphGrids<T>
{
    //------------------------------------------------------------------------------------

    int islandCount(List<List<T>> grid)
    {
        Set<String> visited = new HashSet<>();

        int count = 0;

        for (int r = 0; r < grid.size(); r ++)
        {
            for (int c = 0; c < grid.get(0).size(); c++)
            {
                if (explore(grid, r, c, visited))
                    count++;
            }
        }

        return count;
    }

    private boolean explore(List<List<T>> grid, int r, int c, Set<String> visited)
    {
        boolean rowInbounds = (0 <=r && r < grid.size());
        boolean colInbounds = (0 <=c && c < grid.get(0).size());


        if (!rowInbounds || !colInbounds)
            return false;

        if (grid.get(r).get(c).equals('W'))
            return false;

        String pos = r + "," + c;

        if (visited.contains(pos))
            return false;

        visited.add(pos);

        explore(grid, r - 1, c, visited);
        explore(grid, r + 1, c, visited);
        explore(grid, r, c - 1, visited);
        explore(grid, r, c + 1, visited);

        return true;
    }
//------------------------------------------------------------------------------------
    int minimumIsland(List<List<T>> grid)
    {
        Set<String> visited = new HashSet<>();
        int small = (int) Double.POSITIVE_INFINITY;

        for (int r = 0; r < grid.size(); r ++)
        {
            for (int c = 0; c < grid.get(0).size(); c++)
            {
                int size = exploreSize(grid, r, c, visited);

                if (size > 0 && size < small)
                    small = size;
            }
        }

        return small;
    }

    private int exploreSize(List<List<T>> grid, int r, int c, Set<String> visited)
    {
        boolean rowInbounds = (0 <=r && r < grid.size());
        boolean colInbounds = (0 <=c && c < grid.get(0).size());


        if (!rowInbounds || !colInbounds)
            return 0;

        if (grid.get(r).get(c).equals('W'))
            return 0;

        String pos = r + "," + c;

        if (visited.contains(pos))
            return 0;

        int size = 1;

        visited.add(pos);

        size =  size + exploreSize(grid, r - 1, c, visited) + exploreSize(grid, r + 1, c, visited)
        + exploreSize(grid, r, c - 1, visited) + exploreSize(grid, r, c + 1, visited);

        return size;
    }

//--------remove island--------------------------------------------------------
    /*void removeIsland(List<List<Integer>> grid)
    {
        Set<String> visited = new HashSet<>();

        for (int r = 0; r < grid.size(); r ++)
        {
            for (int c = 0; c < grid.get(0).size(); c ++)
            {
                if (r == 0 || r == grid.size() - 1 ||
                        c == 0 ||c == grid.get(0).size() - 1)
                exploreInside(grid, r, c, visited);
            }
        }
        System.out.println(grid);
        Remove1(grid, 1, 1, visited);
        System.out.println(grid);
    }*/

    List<List<Integer>> removeIsland(List<List<Integer>> grid)
    {
        Set<String> visited = new HashSet<>();

        RemoveIslands(grid, 0, 0, visited);

        return grid;
    }
    private void RemoveIslands(List<List<Integer>> grid, int i, int j, Set<String> visited)
    {
        if (i > grid.get(0).size() -j)
            return;

        exploreBorders(grid, i, grid.get(0).size()-j-1, visited);
        exploreBorders(grid, grid.size() -i-1, grid.get(0).size()-j-1, visited);
        exploreBorders(grid, i, j, visited);
        exploreBorders(grid, grid.size()-1-i, j, visited);


        for (int r = i; r < grid.size()-i; r ++)
        {
            for (int c = j; c < grid.get(0).size()-j; c++)
            {
                if (r == i || r == grid.size() - i - 1 ||
                        c == j ||c == grid.get(0).size() - 1 -j)
                exploreBorders(grid, r, c, visited);
            }
        }
        RemoveIslands(grid, i+1, j+1, visited);
    }

    private void exploreBorders(List<List<Integer>> grid, int r, int c, Set<String> visited)
    {
        if (grid.get(r).get(c).equals(0))
            return;

        String pos = r + "," + c;

        if (visited.contains(pos))
            return;

        if (r == grid.size()-1 || r == 0 || c == 0 || c == grid.get(0).size()-1)
        {
            visited.add(pos);
            return;
        }

        String left = (r -1) +"," + c, right = (r + 1) +"," + c;
        String up = r  +"," + (c-1), down = r +"," + (c + 1);

        if (visited.contains(left) || visited.contains(up) || visited.contains(down) || visited.contains(right))
            visited.add(pos);
        else
            grid.get(r).set(c, 0);

    }
}

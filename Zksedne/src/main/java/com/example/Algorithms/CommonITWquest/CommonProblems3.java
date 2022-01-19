package com.example.Algorithms.CommonITWquest;

public class CommonProblems3
{
    //---------------------------------------------
    public int uniquePathsWithObstacles(int[][] obstacleGrid)
    {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int [][] table = new int [m][n];

        boolean flag = false;

        for (int i = 0; i < n; i++)
        {
            if (flag || obstacleGrid[0][i] == 1)
            {
                flag = true;
                table[0][i] = 0;
            }
            else
                table[0][i] = 1;
        }

        flag = false;

        for (int i = 0; i < m; i++)
        {
            if (flag || obstacleGrid[i][0] == 1)
            {
                flag = true;
                table[i][0] = 0;
            }
            else
                table[i][0] = 1;
        }

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
            {
                if (obstacleGrid[i][j] == 1)
                    table[i][j] = 0;
                else
                    table[i][j] = table[i][j-1] + table[i-1][j];
            }

        return table[m-1][n-1];
    }
    //-----------------------------------------

}

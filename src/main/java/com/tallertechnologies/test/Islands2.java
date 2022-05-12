package com.tallertechnologies.test;

import java.util.stream.Stream;

public class Islands2 {

    /**
     * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected
     * 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
     * The area of an island is the number of cells with a value 1 in the island.
     * Return the maximum area of an island in grid. If there is no island, return 0.
     **/

    public static void main(String[] args) {
        int grid1[][] = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0
                , 1, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        int grid2[][] = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1}, {0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                {0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1}, {0, 1, 0, 0
                , 1, 1, 0, 0, 0, 1, 0, 0, 1}, {0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        int grid3[][] = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0
                , 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        System.out.println("Is test case 1 passing? " + (maxAreaOfIsland(grid1) == 6));
        System.out.println("Is test case 2 passing? " + (maxAreaOfIsland(grid2) == 12));
        System.out.println("Is test case 3 passing? " + (maxAreaOfIsland(grid2) == 0));
    }

    /**
     * this method checks whether there is a land in the position sent by the params
     * if so, then it checks the surroundings (above,below,left,right)
     *
     * @param  grid   a set of islands
     * @param  row    horizontal position in the grid array
     * @param  column vertical position in the grid array
     * @return the total amount of slots with land
     */
    public static int checkAround(int[][] grid, int row, int column) {
        int size = 0;

        //validate that we do not surpass the limits of the grid
        if (row >= 0 && column >= 0 && row < grid.length && column < grid[0].length) {
            //check for land
            if (grid[row][column] == 1) {
                //mark the slot as "processed"
                grid[row][column] = -1;

                size++;

                //this is to check above
                size += checkAround(grid, row - 1, column);
                //this is to check right
                size += checkAround(grid, row, column + 1);
                //this is to check below
                size += checkAround(grid, row + 1, column);
                //this is to check left
                size += checkAround(grid, row, column - 1);
            }
        }
        return size;
    }

    /**
     * this method returns the maximum area of an island in grid
     *
     * @param  grid   a set of islands
     * @return the maximum area of an island
     */
    public static int maxAreaOfIsland(int[][] grid) {
        Integer size = 0;
        Integer area = 0;

        // iterate over the set of islands
        Stream yy = Stream.of(grid);
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                if (grid[x][y] == 1) {
                    size = checkAround(grid, x, y);
                    if (size > area) {
                        area = size;
                    }
                    size = 0;
                }
            }
        }
        return area;
    }

}
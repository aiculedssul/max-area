package com.tallertechnologies.test;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.stream.Collectors.toSet;

public class Islands2 {

    /**
     * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected
     * 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
     * The area of an island is the number of cells with a value 1 in the island.
     * Return the maximum area of an island in grid. If there is no island, return 0.
     **/

    public static void main(String[] args) {
        int grid1[][] = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                         {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                         {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                         {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                         {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                         {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
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
    public static int checkAround(int[][] grid, int row, int column, AreaInfo info, int border) {
        int size = 0;

        //validate that we do not surpass the limits of the grid
        if (row >= 0 && column >= 0 && row < grid.length && column < grid[0].length) {
            //check for land
            if (grid[row][column] == 1) {
                //mark the slot as "processed"
                grid[row][column] = -1;

                size++;

                //grid.length - 1 or 0
                if (row == border) {
                    info.borders.add(column);
                }

                //this is to check above
                size += checkAround(grid, row - 1, column, info, border);
                //this is to check right
                size += checkAround(grid, row, column + 1, info, border);
                //this is to check below
                size += checkAround(grid, row + 1, column, info, border);
                //this is to check left
                size += checkAround(grid, row, column - 1, info, border);
            }
        }
        info.size = size;
        return size;
    }

    /**
     * this method returns the maximum area of an island in grid
     * this method needs to be enhanced, since it only uses 2 threads and does not allow configuring more,
     * but ideally it splits the grid in many parts and calculates the area of each island in different threads
     * for those islands that were cut because of the split, then it merges the borders of each array
     *
     * @param  grid   a set of islands
     * @return the maximum area of an island
     */
    public static int maxAreaOfIsland(int[][] grid) {

        CountDownLatch latch = new CountDownLatch(2);

        int[][] firstGrid = Arrays.copyOfRange(grid, 0, grid.length/2);
        final List<AreaInfo> firstAreas = new ArrayList<>();
        Runnable firstRun = () -> {
            firstAreas.addAll(calculateAreas(firstGrid,firstGrid.length-1));
            latch.countDown();
        };

        int[][] secondGrid = Arrays.copyOfRange(grid, grid.length/2, grid.length);
        final List<AreaInfo> secondAreas = new ArrayList<>();
        Runnable secondRun = () -> {
            secondAreas.addAll(calculateAreas(secondGrid,0));
            latch.countDown();
        };

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(firstRun);
        executor.execute(secondRun);
        executor.shutdown();

        try {
            latch.await();
        } catch(InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        int size = mergeAreas(firstAreas,secondAreas);

        return size;
    }

    private static List<AreaInfo> calculateAreas(int[][] grid, int border) {
        List<AreaInfo> areas = new ArrayList<>();
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                if (grid[x][y] == 1) {
                    AreaInfo areaInfo = new AreaInfo();
                    areaInfo.size = checkAround(grid, x, y, areaInfo, border);
                    areas.add(areaInfo);
                }
            }
        }
        return areas;
    }

    private static class AreaInfo {
        public Integer size;
        public List<Integer> borders = new ArrayList<>();

        public boolean areasMatch(AreaInfo area) {
            return this.borders.stream()
                    .anyMatch(area.borders.stream()
                                    .collect(toSet())
                                    ::contains);
        }
    }

    //this method needs to be enhanced because it iterates more than needed
    private static int mergeAreas(List<AreaInfo> firstAreas, List<AreaInfo> secondAreas) {
        Set<AreaInfo> areaInfoSet = new HashSet<>();
        areaInfoSet.addAll(secondAreas);
        areaInfoSet.addAll(firstAreas);
        Map<AreaInfo,AreaInfo> secondAreasToFinalArea = new HashMap<>();
        Map<AreaInfo,AreaInfo> firstAreaToFinalArea = new HashMap<>();
        int size = 0;
        for (AreaInfo first : firstAreas) {
            AreaInfo finalArea = null;
            for (AreaInfo second : secondAreas) {
                if (first.areasMatch(second)) {
                    if (secondAreasToFinalArea.containsKey(second)) {
                        finalArea = secondAreasToFinalArea.get(second);
                        finalArea.size += first.size;
                        finalArea.borders.addAll(first.borders);
                    }
                    if (firstAreaToFinalArea.containsKey(first)) {
                        finalArea = firstAreaToFinalArea.get(first);
                        finalArea.size += second.size;
                        finalArea.borders.addAll(second.borders);
                    }
                    if (finalArea == null) {
                        finalArea = new AreaInfo();
                        finalArea.size = first.size + second.size;
                        finalArea.borders.addAll(second.borders);
                    }
                    areaInfoSet.remove(second);
                    areaInfoSet.remove(first);
                    areaInfoSet.add(finalArea);
                    secondAreasToFinalArea.put(second,finalArea);
                    firstAreaToFinalArea.put(first,finalArea);
                }
                if (second.size > size) {
                    size = second.size;
                }
                if (finalArea != null && finalArea.size > size) {
                    size = finalArea.size;
                }
            }
            if (first.size > size) {
                size = first.size;
            }
        }
        if (firstAreas.isEmpty()) {
            for (AreaInfo second : secondAreas) {
                if (second.size > size) {
                    size = second.size;
                }
            }
        }
        return size;
    }

}
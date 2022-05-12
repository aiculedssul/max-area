package com.tallertechnologies.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Island2Test {
    private static final String SIZE_ERROR_MESSAGE = "expecting area with size %s but got %s";

    @Test
    public void testThereIsNoIsland() {
        int grid[][] = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0
                , 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        int area = Islands2.maxAreaOfIsland(grid);
        assertEquals(0,area,"expecting area with no size but got " + area);
    }

    @Test
    public void testAreaWithSize1AtTopLeft() {
        int grid[][] = {{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0
                , 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        int area = Islands2.maxAreaOfIsland(grid);
        assertEquals(1,area,String.format(SIZE_ERROR_MESSAGE,1,area));
    }

    @Test
    public void testAreaWithSize1AtTopRight() {
        int grid[][] = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0
                , 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        int area = Islands2.maxAreaOfIsland(grid);
        assertEquals(1,area,String.format(SIZE_ERROR_MESSAGE,1,area));
    }

    @Test
    public void testAreaWithSize1AtBottomLeft() {
        int grid[][] = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0
                , 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        int area = Islands2.maxAreaOfIsland(grid);
        assertEquals(1,area,String.format(SIZE_ERROR_MESSAGE,1,area));
    }

    @Test
    public void testAreaWithSize1AtBottomRight() {
        int grid[][] = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0
                , 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1}};
        int area = Islands2.maxAreaOfIsland(grid);
        assertEquals(1,area,String.format(SIZE_ERROR_MESSAGE,1,area));
    }

    @Test
    public void testExamples() {
        int grid1[][] = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0
                , 1, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        int area = Islands2.maxAreaOfIsland(grid1);
        assertEquals(6,area,String.format(SIZE_ERROR_MESSAGE,6,area));

        int grid2[][] = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1}, {0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                {0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1}, {0, 1, 0, 0
                , 1, 1, 0, 0, 0, 1, 0, 0, 1}, {0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        area = Islands2.maxAreaOfIsland(grid2);
        assertEquals(12,area,String.format(SIZE_ERROR_MESSAGE,12,area));
    }

    @Test
    public void testAreaWithAllLand() {
        int grid[][] = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        int area = Islands2.maxAreaOfIsland(grid);
        assertEquals(80,area,String.format(SIZE_ERROR_MESSAGE,80,area));
    }

    @Test
    public void testAreaWithOnlyFirstRow() {
        int grid[][] = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        int area = Islands2.maxAreaOfIsland(grid);
        assertEquals(13,area,String.format(SIZE_ERROR_MESSAGE,10,area));
    }

    @Test
    public void testAreaWithOnlyFirstColumn() {
        int grid[][] = {{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        int area = Islands2.maxAreaOfIsland(grid);
        assertEquals(8,area,String.format(SIZE_ERROR_MESSAGE,8,area));
    }

    @Test
    public void testAreaWithOnlyItsDiagonal() {
        int grid[][] = {{1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1}};
        int area = Islands2.maxAreaOfIsland(grid);
        assertEquals(1,area,String.format(SIZE_ERROR_MESSAGE,1,area));
    }

    @Test
    public void testAreaWithMinCrossIsland() {
        int grid[][] = {{0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 1, 1, 1, 0, 0, 0},
                        {0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0}};
        int area = Islands2.maxAreaOfIsland(grid);
        assertEquals(5,area,String.format(SIZE_ERROR_MESSAGE,5,area));
    }

    @Test
    public void testAreaWithFullCrossIsland() {
        int grid[][] = {{0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {0, 0, 0, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 0, 0, 0, 0}};
        int area = Islands2.maxAreaOfIsland(grid);
        assertEquals(14,area,String.format(SIZE_ERROR_MESSAGE,14,area));
    }

    @Test
    public void testAreaWith7IslandsFromSize1To7() {
        int grid[][] = {{1, 1, 0, 1, 1, 0, 1, 1, 0},
                        {1, 1, 0, 1, 0, 0, 1, 1, 0},
                        {0, 0, 0, 1, 1, 0, 1, 1, 0},
                        {1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 1, 0, 1, 1, 1, 0},
                        {1, 0, 1, 1, 0, 1, 1, 1, 1}};
        int area = Islands2.maxAreaOfIsland(grid);
        assertEquals(7,area,String.format(SIZE_ERROR_MESSAGE,7,area));
    }
}

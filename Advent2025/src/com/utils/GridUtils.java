package com.utils;

public class GridUtils {
	public static final int[][] DIRECTIONS_VEC = new int[][]{ {-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1},{0,-1},{-1,-1} }; // x y
	public static final int LEFT = 0;
	public static final int DOWN_LEFT = 1;
	public static final int DOWN = 2;
	public static final int DOWN_RIGHT = 3;
	public static final int RIGHT = 4;
	public static final int UP_RIGHT = 5;
	public static final int UP= 6;
	public static final int UP_LEFT = 7;
	
	public static char[][] getCharGridFromLines(String[] lines){
		char[][] newGrid = new char[lines.length][lines[0].length()];
		char[] chars;
		for(int i = 0; i < lines.length ;i++) {
			chars = lines[i].toCharArray();
			for(int j = 0; j < lines[i].length() ; j++) {
				newGrid[i][j] = chars[j];
			}
		}
		return newGrid;
	}
	
	
	public static void printGrid(char[][] grid){
        System.out.println();
        for(char[] row: grid){
            for(char c : row){
                System.out.print(c);
            }
            System.out.println();
        }
    }
}

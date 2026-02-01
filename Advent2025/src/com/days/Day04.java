package com.days;

import com.utils.DataGetting;
import com.utils.GridUtils;
import com.utils.OutputMaker;

public class Day04 {
	
	private String full;
	private char[][] grid;
	private int day = 4;
	
	
	public void d4p1(boolean test) {
		full = DataGetting.getFull(test, day, 1);
		grid = GridUtils.getCharGridFromLines(full.split("\n"));
		int part = 1;
		long sum = 0;
		int occupied;
		boolean[][] counted = new boolean[grid.length][grid[0].length];
		for(int i = 0; i < grid.length ; i++) {
			for(int j = 0;j < grid[i].length ; j++) {
				if(grid[i][j] == '@') {
					occupied = 0;
					for(int[] d : GridUtils.DIRECTIONS_VEC) {
						int nextX = i + d[0];
						int nextY = j + d[1];
						if( outOfBounds(nextX,nextY) ) {
							continue;
						}
						else if(grid[nextX][nextY] == '@'){
                            occupied++;
                        }
						if(occupied >=4){
                            break;
                        }
					}
					if(occupied<4){
                        sum++;
                        counted[i][j]= true;
                    }
				}
			}
		}
		
		OutputMaker.outputResult(test, day, part, sum);
	}
	
	private boolean outOfBounds(int x, int y) {
        if(0>x ||0> y|| x >= grid[0].length || y >= grid.length)
            return true;
        else
            return false;
	}
	
}

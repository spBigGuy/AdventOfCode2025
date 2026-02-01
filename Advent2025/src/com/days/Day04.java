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
						if( outOfBounds(grid,nextX,nextY) ) {
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
	
	public void d4p2(boolean test) {
		full = DataGetting.getFull(test, day, 1);
		grid = GridUtils.getCharGridFromLines(full.split("\n"));
		char[][] cGrid = grid.clone();
		int part = 2;
		long sum = 0;
		int occupied;
        boolean[][] counted;
        //int loop = 1;
        
        while(true) {
        	counted = new boolean[cGrid.length][cGrid[0].length];
        	for(int i= 0;i<cGrid.length;i++){
                for(int j = 0;j<cGrid[i].length;j++){
                    
                    if(cGrid[i][j] == '@'){
                        occupied = 0;
                        for(int[] d: GridUtils.DIRECTIONS_VEC){
                            int nextX = i+d[0];
                            int nextY = j+d[1];
                            if(outOfBounds(cGrid, nextX,nextY)){
                                continue;
                            }
                            else if(cGrid[nextX][nextY] == '@'){
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
        	
        	//System.out.println("Loop:" + loop++);
        	//printCountedGrid(grid,counted);
        	//System.out.println();
        	if(nothingCounted(counted)) {
        		break;
        	}
        	
        	for(int i = 0;i< counted.length;i++) {
        		for(int j = 0;j < counted[i].length; j++) {
        			if(counted[i][j]) {
        				cGrid[i][j] = '.';
        			}
        		}
        	}
        	
        }
		
		OutputMaker.outputResult(test, day, part, sum);
	}
	
	@SuppressWarnings("unused")
	private void printCountedGrid(char[][] grid, boolean[][] occ){
        for(int i= 0;i<grid.length;i++){
            for(int j = 0;j<grid[i].length;j++){
                if(occ[i][j]){
                    System.out.print("x");
                } 
                else{
                    System.out.print(grid[i][j]);
                }
                
            }
            System.out.println();
        }
    }
	
	private boolean nothingCounted(boolean[][] counted ) {
    	for(boolean[] row : counted) {
    		for(boolean c : row) {
    			if(c)
    				return false;
    		}
    	}
    	return true;
    }
	
	private boolean outOfBounds(char[][] grid, int x, int y) {
        if(0>x ||0> y|| x >= grid[0].length || y >= grid.length)
            return true;
        else
            return false;
	}
	
}

package com.days;

import com.utils.DataGetting;
import com.utils.OutputMaker;

public class Day01 {
	private String[] lines;
	private int[] instructions;
	private int day = 1;
	
	
	// method for part 1 of day 1
	public void d1p1(boolean test) {
		lines = DataGetting.getFull(test, day, 1).split("\n");
		int part = 1;
		int spot = 50;
		int sum = 0;
		initInstructions();
		for(int instruction : instructions) {
			spot += instruction;
			if(spot > 99) {
				spot = spot%100;
			}
			else if( spot <0  ) {
				while(spot <0 ) {
					spot += 100;
				}
			}
			
			if(spot == 0) {
				sum++;
			}
		}
		OutputMaker.outputResult(test, day, part, sum);
	}
	
	public void d1p2(boolean test) {
		int spot = 50;
		int sum = 0;
		int part = 2;
		lines = DataGetting.getFull(test, day, 1).split("\n");
		
		initInstructions();
		for(int instruction : instructions) {
			spot += instruction;
			boolean counted = false;
			if(spot >99) {
				sum += spot/100;
				spot = spot%100;
				counted = true;
			}
			else if(spot < 0) {
				if(spot - instruction == 0) {
					sum--;
				}
				while(spot < 0) {
					spot += 100;
					sum++;
				}
			}
			if(!counted && spot == 0) {
				sum++;
			}
		}
		OutputMaker.outputResult(test, day, part, sum);
		
		
		
	}
	
	
	private void initInstructions() {
		instructions = new int[lines.length];
		int mult;
		int i = 0;
		for(String line: lines) {
			if(line.charAt(0) == 'R') {
				mult = 1;
			}
			else {
				mult = -1;
			}
			instructions[i] = mult * Integer.parseInt( line.substring(1) );
			i++;
		}
	}
	
	// sets the lines to the lines from the right file for Part 1 depending on if it is the test or not the test 
//	private void setLinesP1(boolean test) {
//		if(test) {
//			lines = DataGetting.getLinesArrayFromFile("Day01T1.txt");
//			
//		}
//		else {
//			lines = DataGetting.getLinesArrayFromFile("Day01P1.txt");
//		}
//	}
}

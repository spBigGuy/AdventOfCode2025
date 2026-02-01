package com.days;

import com.utils.DataGetting;

public class Day01 {
	private String[] lines;
	private int[] instructions;
	
//	private String[] testLinesP1;
//	private String[] fullLinesP1;
	
//	public Day01() {
//		testLinesP1 = DataGetting.getLinesArrayFromFile("Day01T1.txt");
//		fullLinesP1 = DataGetting.getLinesArrayFromFile("Day01P1.txt");
//	}
	
	// method for part 1 of day 1
	public void d1p1(boolean test) {
		setLinesP1(test);
		
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
		String ausgabe = "Sum in Part 1 ";
		if(test) {
			ausgabe = ausgabe + "Test: " + sum;
		}
		else {
			ausgabe = ausgabe + ": " + sum;
		}
		System.out.println(ausgabe);
	}
	
	public void d1p2(boolean test) {
		
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
	private void setLinesP1(boolean test) {
		if(test) {
			lines = DataGetting.getLinesArrayFromFile("Day01T1.txt");
			
		}
		else {
			lines = DataGetting.getLinesArrayFromFile("Day01P1.txt");
		}
	}
}

package com.days;

import com.utils.DataGetting;
import com.utils.OutputMaker;

public class Day06 {
	private String full;
	private int day = 6;
	private long[][] numbers;
	private char[] operations;
	
	public void d6p1(boolean test) {
		int part = 1;
		long sum = 0L;
		full = DataGetting.getFull(test, day, 1);
		String[] lines = full.split("\n");
		for(int i = 0; i < lines.length; i++) {
			lines[i] = lines[i].strip(); 
			while(lines[i].contains("  ")) {
				lines[i] = lines[i].replace("  ", " "); 
			}
		}
		numbers = new long[lines[0].split(" ").length ][  lines.length -1 ]; // col, rows
		operations = new char[ numbers.length ];
		for(int col = 0; col < numbers.length; col++) {
			for(int row = 0; row < numbers[col].length; row++) {
				
				numbers[col][row]= Integer.parseInt( lines[row].split(" ")[col] ); 
				
			}
			operations[col] =  lines[ lines.length -1 ].split(" ")[col].charAt(0);
		}
		
		for(int col = 0; col < operations.length;col++ ) {
			if(operations[col] == '+') {
				for(int row = 0; row < numbers[col].length ; row++) {
					sum += numbers[col][row];
				}
			}
			else {
				long h = 1;
				for(int row = 0; row < numbers[col].length ; row++) {
					h *= numbers[col][row];
				}
				sum += h;
			}
		}
		OutputMaker.outputResult(test, day, part, sum);
	}
	
	
	
	public void printAll() {
		for(int col = 0; col < numbers.length; col++) {
			for(int row = 0; row < numbers[col].length; row++) {
				
				System.out.print( numbers[col][row] + " ");
				
			}
			System.out.println(operations[col]);
		}
	}
}

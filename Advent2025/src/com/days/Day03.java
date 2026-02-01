package com.days;

import com.utils.DataGetting;
import com.utils.OutputMaker;

public class Day03 {
	
	private int day = 3;
	
	private String full;
	
	public void d3p1(boolean test) {
		setFullP1(test);
		int part = 1;
		long sum = 0L;
		String[] lines = full.split("\n");
		char[] lineChars;
		for(String line : lines) {
			char maxL = (char) 0;
			int indexMaxL = -1;
			lineChars = line.toCharArray();
			for(int i = 0; i < lineChars.length - 1 ;i++) {
				if( lineChars[i] > maxL  ) {
					indexMaxL = i;
					maxL = lineChars[i];
					if(maxL == '9') {
						break;
					}
				}
			}
			
			char maxR = (char) 0;
			for(int j = lineChars.length- 1; j > indexMaxL ;j--) {
				
				if( lineChars[j] > maxR ) {
					maxR = lineChars[j];
					if(maxR == '9') {
						break;
					}
				}
				
			}
			String fusedNum = "" + maxL + maxR;
			sum += Integer.parseInt(fusedNum);
		}
		
		
		OutputMaker.outputResult(test, day, part, sum);
	}
	
	private void setFullP1(boolean test) {
		if(test) {
			full = DataGetting.getFullTextFromFile("Day03T1.txt");
			
		}
		else {
			full = DataGetting.getFullTextFromFile("Day03P1.txt");
		}
	}
}

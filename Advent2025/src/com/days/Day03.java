package com.days;

import com.utils.DataGetting;
import com.utils.OutputMaker;

public class Day03 {
	
	private int day = 3;
	
	private String full;
	
	public void d3p1(boolean test) {
		full = DataGetting.getFull(test, day, 1);
		
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

	
	public void d3p2(boolean test) {
		full = DataGetting.getFull(test, day, 1);

		String[] lines = full.split("\n");
		int part = 2;
		long sum = 0L;
		int maxDigits = 12;
		char[] digits;
		int lastIndex;
		char[] lineChars;
		for(String line : lines) {
			digits = new char[maxDigits];
			lastIndex = 0;
			lineChars = line.toCharArray();
			for(int i = 0;i < maxDigits;i++) {
				char max = 0;
				for(int c = lastIndex;c< lineChars.length - maxDigits + i + 1; c++) {
					if( lineChars[c] > max ) {
						max = lineChars[c];
						lastIndex = c;
						if(max == '9') {
							break;
						}
					}
				}
				digits[i] = max;
				lastIndex++;
			}
			String huge = "";
			for(char d : digits) {
				huge = huge + d;
			}
			sum+= Long.parseLong(huge);
		}
		
		OutputMaker.outputResult(test, day, part, sum);
	}
}

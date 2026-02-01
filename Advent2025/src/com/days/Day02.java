package com.days;

import com.utils.DataGetting;
import com.utils.OutputMaker;

public class Day02 {
	private int day = 2;
	
	private String full;
	private String[] lines;
	
	public void d2p1(boolean test) {
		int part = 1;
		setFullP1(test);
		lines = full.split(",");
		long sum = 0;
		String[] parts;
		String a,b;
		for(String line : lines) {
			parts = line.split("-");
			a = parts[0];
			b = parts[1];
			if(a.startsWith("0") || b.startsWith("0")) 
				continue;
			for(long i = Long.parseLong(a );i <= Long.parseLong(b);i++ ) {
				if(!isValid( String.valueOf(i) )) {
					sum+= i;
				}
			}
		}
		
		OutputMaker.outputResult(test, day, part, sum);
		
	}
	
	
	public void d2p2(boolean test) {
		setFullP1(test);
		int part = 2;
		
		lines = full.split(",");
		long sum = 0;
		String[] parts;
		String a,b;
		for(String line : lines ) {
			parts = line.split("-");
			a = parts[0];
			b = parts[1];
			if(a.startsWith("0") || b.startsWith("0")  ) {
				continue;
			}
			for(long i = Long.parseLong(a) ; i <= Long.parseLong(b) ;i++ ) {
				
				if( !isValidP2(String.valueOf(i)) ) {
                    sum += i;
				}
				
			}
			
		}
		
		OutputMaker.outputResult(test, day, part, sum);
		
	}
	
	private boolean isValidP2(String s) {
		char[] chars = s.toCharArray();
		char[] segChars;
		int index;
		Outer:
		for(int delta = 1; delta <= chars.length/2; delta++) {
			index = 0;
			segChars = s.substring(0,delta).toCharArray();
			for(int i = 0; i < chars.length ;i++) {
				if(index >= segChars.length ) {
					index = 0;
				}
				if( chars[i] !=  segChars[index] ) {
					continue Outer;
				}
				index++;
			}
			if(index != segChars.length) {
				continue;
			}
			return false;
		}
		
		return true;
	}
	
	private boolean isValid(String s) {
		if(s.startsWith("0")) {
			return false;
		}
		else if(s.substring(0, s.length()/2).equals(s.substring(s.length()/2)) ) {
			return false;
		}
		return true;
	}
	
	private void setFullP1(boolean test) {
		if(test) {
			full = DataGetting.getFullTextFromFile("Day02T1.txt");
			
		}
		else {
			full = DataGetting.getFullTextFromFile("Day02P1.txt");
		}
	}
}

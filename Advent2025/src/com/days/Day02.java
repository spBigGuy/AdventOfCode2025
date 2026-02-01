package com.days;

import com.utils.DataGetting;
import com.utils.OutputMaker;

public class Day02 {

	private String full;
	private String[] lines;
	
	public void d2p1(boolean test) {
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
		
		OutputMaker.outputResult(test, 2, 1, sum);
		
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

package com.days;

import com.days.day05.RangeList;
import com.utils.DataGetting;
import com.utils.OutputMaker;


public class Day05 {
	private String full;
	private int day = 5;
	
	public void d5p1(boolean test) {
		int part = 1;
		long sum = 0L;
		full = DataGetting.getFull(test, day, 1);
		
		String[] ranges = full.split("\n\n")[0].split("\n");
        String[] ingredients = full.split("\n\n")[1].split("\n");
        long ingred, max, min;
        for(String i : ingredients) {
        	ingred = Long.parseLong(i);
        	for(String range: ranges) {
        		max = Long.parseLong(range.split("-")[1]);
        		min = Long.parseLong(range.split("-")[0]);
        		if(ingred < min) {
        			continue;
        		} 
        		else if(ingred >max) {
        			continue;
        		}
        		else {
        			sum++;
        			break;
        		}
        	}
        }
		OutputMaker.outputResult(test, day, part, sum);
	}
	
	
	public void d5p2(boolean test) {
		int part = 2;
		long sum = 0L;
		full = DataGetting.getFull(test, day, 1);
		String[] ranges = full.split("\n\n")[0].split("\n");
		
		RangeList rangeList = new RangeList();
		rangeList.addAll(ranges);
		rangeList.purgeMultiples();
		rangeList.cleanOverlaps();
		sum = rangeList.getFullFreshCount();
		OutputMaker.outputResult(test, day, part, sum);
	}
	
	
}

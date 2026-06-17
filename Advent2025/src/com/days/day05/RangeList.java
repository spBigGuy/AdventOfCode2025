package com.days.day05;

import java.util.ArrayList;

public class RangeList {
	private ArrayList<long[]> ranges;
	
	public RangeList() {
		ranges = new ArrayList<>();
	}
	
	public void cleanOverlaps() {
		boolean[] merged;
		boolean mergeDone = true; 
		long[] range1, range2;
		while (mergeDone){
			merged = new boolean[ranges.size()];
			mergeDone = false;
			ArrayList<long[]> newRanges = new ArrayList<long[]>();
			
			for(int i = 0; i < ranges.size(); i++) {
				if(merged[i]) {
					continue;
				}
				range1 = ranges.get(i);
				
				for(int j = 0 ; j < ranges.size(); j++) {
					if(merged[j]|| i == j ) {
						continue; 
					}
					range2 = ranges.get(j);
					
					if(isOtherInSelf(range1, range2)) {
						merged[j] = true; 
						mergeDone = true; 
						
					}
					else if (isSelfInOther(range1, range2)) {
						range1 = range2; 
						merged[j] = true; 
						mergeDone = true; 
					}
					else if(isLowerLimitInside(range1, range2)) {
						range1[0] = range2[0];
						merged[j] = true; 
						mergeDone = true; 
					}
					else if (isUpperLimitInside(range1, range2)) {
						range1[1] = range2[1];
						merged[j] = true; 
						mergeDone = true; 
					}
					
				}
				newRanges.add(range1);
				merged[i]= true; 
			}
			ranges = newRanges;
			purgeMultiples();
			
		}
	}
	
	public boolean isOtherInSelf(long[] self, long[] other) {
		return isLowerLimitInside(other, self) && isUpperLimitInside(other, self);
		
	}
	
	public boolean isSelfInOther(long[] self, long[] other) {
		return isLowerLimitInside(self, other) && isUpperLimitInside(self, other);
	}
	
	public boolean isUpperLimitInside(long[] range1, long[] range2) {
		return range1[1] >= range2[0] && range1[1] <= range2[1];
	}
	
	public boolean isLowerLimitInside(long[] range1, long[] range2) {
		return range1[0] >= range2[0] && range1[0] <= range2[1];
	}
	
	
	public void purgeMultiples() {
		while(hasMultiples()) {
			ArrayList<long[]> newRanges = new ArrayList<long[]>();
			for(long[] r : ranges) {
				boolean multiple = false;
				for(long[] nr : newRanges) {
					if(r[0] == nr[0] && r[1] == nr[1]) {
						multiple = true;
						break;
					}
				}
				if(!multiple) {
					newRanges.add(r);
				}
			}
			ranges = newRanges;
			
		}
	}
	
	public boolean hasMultiples() {
		for(int i = 0; i< ranges.size() ;i++) {
			for(int j = 0; j < ranges.size() ; j++) {
				if(i == j) {
					continue;
				} 
				long[] l1 = ranges.get(i);
				long[] l2 = ranges.get(j);
				if(l1[0] == l2[0] && l1[1] == l2[1]) {
					return true;
				}
			}
		}
		return false;
	}
	
	public void addAll(String[] strings) {
		for(String s : strings) {
			String[] parts = s.split("-");
			long x = Long.parseLong( parts[0] );
			long y = Long.parseLong(parts[1]);
			long[] a = new long[] { x,y };
			ranges.add(a);
		}
	}
	
	public void printFullList() {
		for(long[] range: ranges) {
			System.out.println(range[0] + "-" + range[1]);
		}
		
	}
	
	public long getFullFreshCount() {
		long sum = 0L;
		for(long[] r : ranges) {
			sum += r[1] - r[0] +1;
		}
		return sum;
	}
	
}

package com.days;


import com.utils.DataGetting;
import com.utils.OutputMaker;

public class Day07 {

	private String full;
	private int day = 7;
	private char[][] map;
	
	
	public void d7p1(boolean test) {
		int part = 1;
		long sum = 0L; 
		full = DataGetting.getFull(test, day, 1);
		String[] lines = full.split("\n");
		map = new char[ lines.length ][lines[0].length()];
		for(int i = 0; i < lines.length ; i++) {
			map[i] = lines[i].toCharArray();
		}
		int x_start = -1;
		
		for(int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if(map[i][j] == 'S') {
					x_start = j;
				}
			}
		}
		char[] oldBeams = new char[lines[0].length()] ;
		char[] newBeams= new char[lines[0].length()];
		oldBeams = makeStandardCharArray(oldBeams.length);

		
		oldBeams[x_start] = '|';
		for (int i = 2; i < map.length; i++) { 
			newBeams = makeStandardCharArray(newBeams.length);
			for (int j = 0; j < map[i].length; j++) {
				if ( oldBeams[j] == '|' ) {
					if (map[i][j] == '^') {
						newBeams[j-1] = newBeams[j+1] = '|';
						sum++;
					}
					else {
						newBeams[j] = oldBeams[j];
					}
				}
			}
//			printBeamArray(newBeams);
			oldBeams = newBeams;
			
		}

		OutputMaker.outputResult(test, day, part, sum);
	}
	
	// 2always remember to use long instead of integer, because can become big
	
	public void d7p2(boolean test) {
		int part = 2;
		long sum = 0L; 
		full = DataGetting.getFull(test, day, 1);
		String[] lines = full.split("\n");
		map = new char[ lines.length ][lines[0].length()];
		for(int i = 0; i < lines.length ; i++) {
			map[i] = lines[i].toCharArray();
		}
		int x_start = -1;
		
		for(int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if(map[i][j] == 'S') {
					x_start = j;
				}
			}
		}
		long[] oldBeams = new long[lines[0].length()] ;
		long[] newBeams;
		
		oldBeams[x_start] = 1;
		
		for (int i = 2; i < map.length; i++) {
			newBeams = new long[lines[0].length()];
			for (int j = 0; j < map[i].length; j++) {
				if ( oldBeams[j] > 0 ) {
					if (map[i][j] == '^') {
						newBeams[j-1] += oldBeams[j]; 
						newBeams[j+1] += oldBeams[j];
					}
					else {
						newBeams[j] += oldBeams[j];
					}
				}
			}
//			printBeamArray(newBeams);
			oldBeams = newBeams;
			
		}
		
		for(long i: oldBeams) {
			sum += i;
		}
		OutputMaker.outputResult(test, day, part, sum);
	}
	
	
	public char[] makeStandardCharArray(int size) {
		char[] newA =  new char[size];		
		for(int i = 0; i< newA.length; i++) {
			newA[i] = '.';
		}		
		return newA;
	}
	
	
	
	// method to check how 1 beam array looks
	@SuppressWarnings("unused")
	private void printBeamArray(long[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
		}
		System.out.println();
	}
	
	@SuppressWarnings("unused")
	private void printBeamArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
		}
		System.out.println();
	}
	
	@SuppressWarnings("unused")
	private void printBeamArray(char[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
		}
		System.out.println();
	}
	
	public void printMap() {
		for(char[] i : map) {
			for(char j : i) {
				System.out.print(j);
			}
			System.out.println();
		}
	}
}

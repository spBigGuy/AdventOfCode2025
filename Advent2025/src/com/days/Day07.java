package com.days;

import java.util.Iterator;

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
		int y_start = -1;
		
		for(int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if(map[i][j] == 'S') {
					x_start = j;
					y_start = i;
				}
			}
		}
		char[] oldBeams = new char[lines[0].length()] ;
		char[] newBeams= new char[lines[0].length()];
		for(int i = 0; i<oldBeams.length; i++) {
			oldBeams[i] = '.';
			newBeams[i] = '.'; 
		}
		oldBeams[x_start] = '|';
		for (int i = 2; i < map.length; i++) { 
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
			newBeams = makeStandardCharArray(newBeams.length);
			
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

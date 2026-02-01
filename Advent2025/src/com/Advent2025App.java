package com;

import com.days.*;

public class Advent2025App {
	public static void main(String[] args) {
		//int day = Integer.parseInt(args[0]);
		int day = 5;
		
		switch(day) {
			case 1:
				Day01 d1 = new Day01();
				d1.d1p1(true);
				d1.d1p1(false);
				d1.d1p2(true);
				d1.d1p2(false);
				break;
			case 2:
				Day02 d2 = new Day02();
				d2.d2p1(true);
				d2.d2p1(false);
				d2.d2p2(true);
				d2.d2p2(false);
				break;
			case 3:
				Day03 d3 = new Day03();
				d3.d3p1(true);
				d3.d3p1(false);
				d3.d3p2(true);
				d3.d3p2(false);
				break;
			case 4:
				Day04 d4 = new Day04();
				d4.d4p1(true);
				d4.d4p1(false);
				d4.d4p2(true);
				d4.d4p2(false);
				break;
			case 5:
				Day05 d5 = new Day05();
				d5.d5p1(true);
				d5.d5p1(false);
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				break;
			case 9:
				break;
			case 10:
				break;
			case 11:
				break;
			case 12:
				break;
			default:
				System.out.println("Day not included");
		}
		
		System.exit(0);
	}
}

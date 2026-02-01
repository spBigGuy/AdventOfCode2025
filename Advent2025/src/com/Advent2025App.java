package com;

import com.days.Day01;

public class Advent2025App {
	public static void main(String[] args) {
		int day = Integer.parseInt(args[0]);
		
		switch(day) {
			case 1:
				Day01 d1 = new Day01();
				d1.d1p1(true);
				d1.d1p1(false);
				d1.d1p2(true);
				d1.d1p2(false);
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
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

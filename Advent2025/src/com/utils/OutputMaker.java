package com.utils;

public class OutputMaker {
	public static void outputResult(boolean test, int day, int part, long sum) {
		String ausgabe = "Sum in Day " + day + " Part " + part ;
		
		if(test) {
			ausgabe = ausgabe + " Test: " + sum;
		}
		else {
			ausgabe = ausgabe + ": " + sum;
		}
		
		System.out.println(ausgabe);
	}
}

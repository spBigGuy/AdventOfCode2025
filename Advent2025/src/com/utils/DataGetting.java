package com.utils;

import java.io.File;
import java.util.Scanner;

public class DataGetting {
	public static String homePath =  "src" + File.separator +"res";
	
	public static void printFile(String fileName) {
		File file = new File(homePath + File.separator + fileName);
		//System.out.println(file.getAbsolutePath());
		if(file.exists() && file.isFile()) {
			
			try {
				Scanner sc = new Scanner(file);
				while(sc.hasNext()) {
					System.out.println(sc.next());
				}
				sc.close();
			}
			catch(Exception e) {
				e.printStackTrace();
				return;
			}
			
			//System.out.println("This is a file, that exists");
		}
		else {
			System.err.println("This is either not a file or it does not exist");
		}
	}
	
	public static String getFullTextFromFile(String fileName) {
		File file = new File(homePath + File.separator + fileName);
		String full = "";
		if(file.exists() && file.isFile()) {
			
			try {
				Scanner sc = new Scanner(file);
				while(sc.hasNextLine()) {
					full = full + sc.nextLine() + "\n";
				}
				sc.close();
				if(full.endsWith("\n")) {
					full = full.substring(0, full.length() - 1);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
				return "";
			}
			
			//System.out.println("This is a file, that exists");
		}
		else {
			System.err.println("This is either not a file or it does not exist");
		}
		return full;
	}
	
	public static String[] getLinesArrayFromFile(String fileName) {
		String full = getFullTextFromFile(fileName);
		return full.split("\n");
	}
	
	public static String getFull( boolean test, int day, int part ) {
		String fileName = "Day";
		if(day < 10) {
			fileName = fileName + "0" + day;
		}
		else {
			fileName = fileName + day;
		}
		if(test) {
			fileName = fileName + "T" + part + ".txt";
		}
		else {
			fileName = fileName + "P" + part + ".txt";
		}
		return  getFullTextFromFile(fileName) ;
	}
	
}

package com.company;

public class Main {

    public static void main(String[] args) {
        fileHandler fh = new fileHandler("situation transition.txt","");
        History allSituation = fh.readFile();

        System.out.println(allSituation.getHistorySituation().toString());
	// write your code here
    }
}

package com.company;

public class Main {

    public static void main(String[] args) {
        fileHandler fh = new fileHandler("situation transition.txt","");
        History allSituation = fh.readFile();

        TBSL test = new TBSL(allSituation);
        test.startTBLS(0,0,0);
        System.out.println(allSituation.getHistorySituation().toString());
	// write your code here
    }
}

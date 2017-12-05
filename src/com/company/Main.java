package com.company;

public class Main {

    public static void main(String[] args) {
        fileHandler fh = new fileHandler("situation transition.txt","");
        History allSituation = fh.readFile();

        TBSL test = new TBSL(allSituation);

        double[] tmp = test.execTBLS(0,0,0);

        for (int i = 0; i < 10; i++) {
            test.execTBLS(tmp[0], tmp[1], tmp[2]);
        }
    }
}

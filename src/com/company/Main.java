package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        fileHandler fh = new fileHandler("situation transition.txt","result.csv");
        History allSituation = fh.readFile();

        TBSL test = new TBSL(allSituation);

        double[] tmp = test.execTBLS(0,0,0, fh.getOutPath());

        for (int i = 0; i < 10; i++) {
            test.execTBLS(tmp[0], tmp[1], tmp[2], fh.getOutPath());
        }
    }
}

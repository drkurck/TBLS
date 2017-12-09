package com.company;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {
        fileHandler fh = new fileHandler("situation transition.txt");
        History trace = fh.readFile();

        TBSL sim = new TBSL(trace);

        fh.createFile("TBLS02.csv");
        sim.setZ(0.2);
        for (String currentAction: trace.getActionList()) {
            State state = new State(currentAction);
            sim.execTBLS(state, "TBLS02.csv") ;
        }

    }
}

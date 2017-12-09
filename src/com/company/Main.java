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
            sim.execTBSL(state, "TBLS02.csv") ;
        }
        sim.resetVar();

        fh.createFile("TBLS05.csv");
        sim.setZ(0.5);
        for (String currentAction: trace.getActionList()) {
            State state = new State(currentAction);
            sim.execTBSL(state, "TBLS05.csv") ;
        }
        sim.resetVar();

        fh.createFile("TBLS07.csv");
        sim.setZ(0.7);
        for (String currentAction: trace.getActionList()) {
            State state = new State(currentAction);
            sim.execTBSL(state, "TBLS07.csv") ;
        }
        sim.resetVar();

    }
}

package com.company;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {
        fileHandler fh = new fileHandler("situation transition.txt");
        History trace = fh.readFile();

        Simulation sim = new Simulation(trace);
        State state = null;
        fh.createFile("TBLS02.csv");
        for (String currentAction: trace.getActionList()) {
            sim.setZ(0.2);
            state = new State(currentAction);
            sim.execTBSL(state, "TBLS02.csv") ;
            sim.resetVar();
        }

        fh.createFile("TBLS05.csv");
        for (String currentAction: trace.getActionList()) {
            sim.setZ(0.5);
            state = new State(currentAction);
            sim.execTBSL(state, "TBLS05.csv") ;
            sim.resetVar();
        }

        fh.createFile("TBLS07.csv");
        for (String currentAction: trace.getActionList()) {
            sim.setZ(0.7);
            state = new State(currentAction);
            sim.execTBSL(state, "TBLS07.csv") ;
            sim.resetVar();
        }

        fh.createFile("TBLS10.csv");
        for (String currentAction: trace.getActionList()) {
            sim.setZ(1.0);
            state = new State(currentAction);
            sim.execTBSL(state, "TBLS10.csv") ;
            sim.resetVar();
        }


        // x: how certain is the idea
        // z: intuitive feeling in favor of the idea
        double[] testValue = {1.0, 0.5, 0.0};
        for (Double x: testValue) {
            for (Double z: testValue) {
                fh.createFile("guideline"+x.toString()+"_"+z.toString()+".csv");
                sim.setX(x);
                sim.setZ(z);
                for (String currentAction: trace.getActionList()) {
                    state = new State(currentAction);
                    sim.execGuideline(state, "guideline"+x.toString()+"_"+z.toString()+".csv");
                }
            }
        }
    }
}

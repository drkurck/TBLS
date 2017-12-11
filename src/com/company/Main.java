package com.company;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {
        fileHandler fh = new fileHandler("situation transition.txt");
        History trace = fh.readFile();

        Simulation sim = new Simulation(trace);
        State state = null;

        double[] TBSLvalues = {0.0, 0.2, 0.5,0.7,1.0};

        for (double z : TBSLvalues) {
            fh.createFile("TBSL"+z+".csv");
            for (String currentAction: trace.getActionList()) {
                sim.setZ(z);
                state = new State(currentAction);
                sim.execTBSL(state, "TBSL"+z+".csv") ;
                sim.resetVar();
            }
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

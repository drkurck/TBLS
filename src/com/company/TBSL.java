package com.company;


import java.io.IOException;
import java.util.List;

public class TBSL {
    private double a;
    private double b;
    private double d;
    private double u;
    private double r; //positive outcome
    private double s; //negative outcome
    private double x;
    private double y;
    private double z;
    private History trace;

    public TBSL(History h1) {
        this.a = 0;
        this.b = 0;
        this.d = 0;
        this.u = 0;
        this.r = 0;
        this.s = 0;
        this.x = 0;
        this.y = 0;
        this.trace = h1;
    }

    public void execTBSL(State currentState, String fileName) throws IOException {
        for (String nextAction: trace.getActionList()) {
            Situation situation = new Situation(currentState, new State(nextAction));

            if (u == 1 && b == 0 && d == 0) {
                this.computeTBSLAtomicity();
                fileHandler.writeResultInFile(b, d, u, a, fileName);
            } else {
                List<Situation> extractedTrace = trace.searchSimilarSituation(situation);

                double tmp = 0;
                for (Situation tmpSituation: extractedTrace) {
                    tmp += Situation.computeOutcome(tmpSituation);
                }

                if (tmp > 0)
                    this.r++;
                else
                    this.s++;
                this.computeRevelancy();

                //question about intuitive feeling is set in main
                this.computeTBSL();

                fileHandler.writeResultInFile(this.b, this.d, this.u, this.a, fileName);

            }
        }
    }

    private void computeRevelancy() {
        this.x = this.r/(this.r+this.s);
    }

    private void computeTBSL() {
        this.y = 1-this.z;
        this.b = (this.z/this.z + this.y + (1-this.x));
        this.d = (this.y/this.z + this.y + (1-this.x));
        this.u = 1-this.x/(this.z + this.y + (1-this.x));
        this.computeTBSLAtomicity();
    }

    private void computeTBSLAtomicity() {
        this.a = 1/trace.getHistorySituation().size();
    }

    public void computeGuideline(int stateCovered) {
        this.y = 1-this.z;
        this.b = this.z / (this.z + this.y + (1 - this.x));
        this.d = this.y / (this.z + this.y + (1 - this.x));
        this.u = (1 - this.x) / (this.z + this.y + (1 - this.x));
        this.computeGuidelineAtomicity(stateCovered);
    }

    private void computeGuidelineAtomicity(int stateCovered) {
        this.a = stateCovered/trace.getHistorySituation().size();
    }

    public void computeStatistcalEvidence() {
        this.b = this.r / (this.r + this.s + 2);
        this.d = this.s / (this.r + this.s + 2);
        this.u = 2 / (this.r + this.s + 2);
    }

    public void resetVar() {
        this.a = 0;
        this.b = 0;
        this.d = 0;
        this.u = 0;
        this.r = 0;
        this.s = 0;
        this.x = 0;
        this.y = 0;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getD() {
        return d;
    }

    public void setD(double d) {
        this.d = d;
    }

    public double getU() {
        return u;
    }

    public void setU(double u) {
        this.u = u;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getS() {
        return s;
    }

    public void setS(double s) {
        this.s = s;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }
}

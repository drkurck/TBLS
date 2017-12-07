package com.company;


import java.io.IOException;
import java.util.List;
import java.util.Scanner;

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
    //private Situation prevSituation;

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

    // Start calculate TBSL
    /*public double[] execTBLS(double b, double d, double u, String outPath) throws IOException {

        if (u == 1 && b == 0 && d == 0) {
            a = computeA();
            fileHandler.writeResultInFile(b, d, u, a, outPath);
        } else {
            double temp = 0;
            for (Situation record : H.getHistorySituation()) {
                double tempOutcome = Situation.computeOutcome(record);
                if (tempOutcome > 0) {
                    temp += tempOutcome;
                }
            }
            System.out.println(temp);
            if (temp > 0)
                r++;
            else
                s++;


            x = r/(r+s);

            // User enter opinion between 0 and 1
            Scanner reader = new Scanner(System.in);
            System.out.println("revelancy : "+ x);
            System.out.println("Enter a number between 0 and 1 : ");
            z = Double.parseDouble(reader.nextLine());

            y = 1-z;
            b = (z/z + y + (1-x));
            d = (y/z + y + (1-x));
            u = 1-x/(z + y + (1-x));

            a = computeA();
            fileHandler.writeResultInFile(b, d, u, a, outPath);
        }
        double[] result = {b, d, u};
        return result;

    }*/

    public Situation execTBLS(String outPath, Situation prevSituation) throws IOException {
        if (u == 1 && b == 0 && d == 0) {
            a = this.computeA();
            fileHandler.writeResultInFile(b, d, u, a, outPath);
        } else {
            List<Situation> extractedTrace = trace.searchSimilarSituation(prevSituation);
            System.out.println(trace.getHistorySituation().size());
            System.out.println(extractedTrace.size());
            double tmp = 0;
            for (Situation tmpSituation: extractedTrace) {
                tmp += Situation.computeOutcome(tmpSituation);
            }
            if (tmp > 0)
                this.r++;
            else
                this.s++;

            this.computeRevelancy();

            // User enter opinion between 0 and 1
            // TODO: error handling

            System.out.println(prevSituation.toString());
            Scanner reader = new Scanner(System.in);
            System.out.println("Revelancy : "+ this.x);
            System.out.println("Enter a number between 0 and 1 : ");
            this.z = Double.parseDouble(reader.nextLine());

            this.normalizeResult();

            this.a = computeA();
            fileHandler.writeResultInFile(this.b, this.d, this.u, this.a, outPath);

        }

        return null;
    }
    // Compute A
    public double computeA() {
        return (double) 1/trace.getHistorySituation().size();
    }

    public void computeRevelancy() {
        this.x = this.r/(this.r+this.s);
    }

    public void normalizeResult() {
        this.y = 1-this.z;
        this.b = (this.z/this.z + this.y + (1-this.x));
        this.d = (this.y/this.z + this.y + (1-this.x));
        this.u = 1-this.x/(this.z + this.y + (1-this.x));
    }

    public void statisicalEvidence() {
        this.b = (this.r) / (this.r+ this.s+2);
        this.d = (this.s) / (this.r+ this.s+2);
        this.u = 2 / (this.r+this.s+2);
    }
}

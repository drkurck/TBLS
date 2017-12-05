package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Scanner;

public class TBSL {
    private double a;
    private double b;
    private double d;
    private double u;
    private double r;
    private double s;
    private double x;
    private double y;
    private double z;
    private History H;

    public TBSL(History h1) {
        this.a = 0;
        this.b = 0;
        this.d = 0;
        this.u = 0;
        this.r = 0;
        this.s = 0;
        this.x = 0;
        this.y = 0;
        H = h1;
    }

    // Start calculate TBSL
    public double[] execTBLS(double b, double d, double u, String outPath) throws IOException {

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
            if (temp/H.getHistorySituation().size() > 0) {
                r = r+1;
            } else {
                s = s+1;
            }
            System.out.println(r);
            System.out.println(s);
            System.out.println("==============================");
            x = r/(r+s);

            // User enter opinion between 0 and 1
            // TODO error handling
            Scanner reader = new Scanner(System.in);
            System.out.println("revelancy : "+ x);
            System.out.println("Enter a number between 0 and 1 : ");
            z = Double.parseDouble(reader.nextLine());

            y = 1-z;
            b = (z/z + y + (1-x));
            d = (y/z + y + (1-x));
            u = 1-x/(z + y + (1-x));
            System.out.println(y);
            System.out.println(z);
            System.out.println(b);
            System.out.println(d);
            System.out.println(u);
            a = computeA();
            fileHandler.writeResultInFile(b, d, u, a, outPath);
        }
        double[] result = {b, d, u};
        return result;

    }

    // Compute A
    public float computeA() {
        return 1/H.getHistorySituation().size();
    }
}

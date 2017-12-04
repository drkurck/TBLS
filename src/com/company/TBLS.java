package com.company;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class TBLS {
    private float a;
    private float b;
    private float d;
    private float u;
    private float r;
    private float s;
    private float x;
    private float y;
    private Situation S;

    public TBLS(Situation s1) {
        this.a = 0;
        this.b = 0;
        this.d = 0;
        this.u = 0;
        this.r = 0;
        this.s = 0;
        this.x = 0;
        this.y = 0;
        S = s1;
    }

    // Start calculate TBLS
    public void startTBLS(float b, float d, float u) {
        if (u == 1 && b == 0 && d == 0) {
            a = computeA();
            writeResultInFile(b, d, u, a);
        } else {
            // TODO : Get previous situation
            S = getPreviousSituation();
            // TODO : Get records ... all
            for (Situation record : recordList) {
                temp = Cnext - Cprev;
            }
            if (temp/recordList.lenght() > 0) {
                r = r+1;
                s = s+1;
                x = r/(r+s);
            }
            Scanner reader = new Scanner(System.in);
            boolean loop = true;
            while (loop) {
                System.out.println("Enter a number between 0 and 1 : ");
                if (reader.hasNextFloat()) {
                    y = reader.nextFloat();
                    loop = true;
                }
            }
            reader.close();

            z = y-1;
            b = (z/z + y + (1-x));
            d = (y/z + y + (1-x));
            u = 1-x/(z + y + (1-x));

            writeResultInFile(b, d, u, a);
        }
    }

    // Compute A
    public float computeA() {
        // TODO : Get number of situation

        return 1/nbSituation;
    }

    // Write result on a file
    public void writeResultInFile(float b, float d, float u, float a) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("result.txt", "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        writer.println(b + " " + d + " " + u + " " + a + " " );
        writer.close();
    }
}

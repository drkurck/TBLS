package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.StringTokenizer;

public class fileHandler {
    private String statePath;
    private String outPath;

    public fileHandler(String statePath, String outPath) {
        this.statePath = statePath;
        this.outPath = outPath;
    }

    /**
     * Reading the file to save all history state
     */
    public void readFile() {
        Path file = Paths.get(this.statePath);
        try (InputStream in = Files.newInputStream(file);
             BufferedReader reader =
                     new BufferedReader(new InputStreamReader(in))) {
            String line = null;
            // read each line
            while ((line = reader.readLine()) != null) {
                //System.out.println(line);
                StringTokenizer tokens = new StringTokenizer(line," ");
                String[] splitedLine = new String[tokens.countTokens()];
                int index = 0;
                //split by space in array
                while (tokens.hasMoreTokens()) {
                    splitedLine[index] = tokens.nextToken();
                    ++index;
                }
                State current = new State(splitedLine[0], Float.parseFloat(splitedLine[1]),  Float.parseFloat(splitedLine[2]), Float.parseFloat(splitedLine[3]));
                State previous = new State(splitedLine[4], Float.parseFloat(splitedLine[5]),  Float.parseFloat(splitedLine[6]), Float.parseFloat(splitedLine[7]));
                System.out.println(Arrays.toString(splitedLine));
            }
        } catch (IOException x) {
            System.err.println(x);
        }
    }


    public String getStatePath() {
        return this.statePath;
    }

    public void setStatePath(String statePath) {
        this.statePath = statePath;
    }

    public String getOutPath() {
        return outPath;
    }

    public void setOutPath(String outPath) {
        this.outPath = outPath;
    }
}

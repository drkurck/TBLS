package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.StringTokenizer;

public class fileHandler {
    private String statePath;
    private String outPath;

    public fileHandler(String statePath, String outPath) throws IOException {
        this.statePath = statePath;
        this.outPath = outPath;
        File file = new File(outPath);

        file.createNewFile();
    }

    public fileHandler(String statePath) {
        this.statePath = statePath;
    }

    public void createFile(String fileName) throws IOException {
        File file = new File(fileName);
        file.createNewFile();
    }
    /**
     * Reading the file to save all history state
     */
    public History readFile() {
        Path file = Paths.get(this.statePath);
        History h = new History();
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
                State next = new State(splitedLine[4], Float.parseFloat(splitedLine[5]),  Float.parseFloat(splitedLine[6]), Float.parseFloat(splitedLine[7]));

                h.addSituation(new Situation(current, next));
                h.addAction(current.getName());
            }
        } catch (IOException x) {
            System.err.println(x);
        }
        return h;
    }

    // Write result on a file
    static public void writeResultInFile(double b, double d, double u, double a, String fileName) throws IOException {
        String text = b + ";" + d + ";" + u + ";" + a + "\n";
        Files.write(Paths.get(fileName), text.getBytes(), StandardOpenOption.APPEND);
    }

    public String getOutPath() {
        return outPath;
    }

    public void setOutPath(String outPath) {
        this.outPath = outPath;
    }

    public String getStatePath() {
        return this.statePath;
    }

    public void setStatePath(String statePath) {
        this.statePath = statePath;
    }

}

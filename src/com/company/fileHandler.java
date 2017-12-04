package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class fileHandler {
    private String statePath;
    private String outPath;

    public fileHandler(String statePath, String outPath) {
        this.statePath = statePath;
        this.outPath = outPath;
    }

    public void readFile() {
        Path file = Paths.get(this.statePath);
        try (InputStream in = Files.newInputStream(file);
             BufferedReader reader =
                     new BufferedReader(new InputStreamReader(in))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
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

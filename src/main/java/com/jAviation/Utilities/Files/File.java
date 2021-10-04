package com.jAviation.Utilities.Files;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class File {
    private List<String> lines = new ArrayList<String>();

    public File(String filename) throws IOException {
        java.io.File file = new java.io.File(filename);
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while ((st = br.readLine()) != null) {
            this.lines.add(st);
        }
    }

    public List<String> getLines() {
        return lines;
    }
}

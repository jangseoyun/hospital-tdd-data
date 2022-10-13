package com.line.domain.write;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Write {

    public void writeFile(List<String> objs, String filename) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filename));

        for (String obj : objs) {
            bw.write(obj);
        }
    }

    public void createFile(String filename) throws IOException{
        File file = new File(filename);
        file.createNewFile();
    }
}

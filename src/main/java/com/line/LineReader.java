package com.line;

import com.line.parser.Parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LineReader<T> {
//파일 읽어서 List<String> 만들기
    Parser<T> parser;

    public LineReader(Parser<T> parser) {
        this.parser = parser;
    }

    public List<T> readLines(String filename) throws IOException {
        List<T> result = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));

        String str;
        br.readLine();
        while ((str=br.readLine()) != null) {
            result.add(parser.parse(str));
        }

        return result;
    }

}

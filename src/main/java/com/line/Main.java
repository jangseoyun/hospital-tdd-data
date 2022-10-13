package com.line;

import com.line.domain.Hospital;
import com.line.domain.write.Write;
import com.line.parser.HospitalParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String filename = "/Users/seoyun/codeLion/서울시 병의원 위치 정보 .csv";
        LineReader<Hospital> hospitalLineReader = new LineReader<>(new HospitalParser());
        List<Hospital> hospitals = hospitalLineReader.readLines(filename);

        //파일 생성
        String reprocessData = "get-csv-data.sql";
        Write write = new Write();
        //write.createFile(reprocessData);
        //순서 : 기관아이디 0, 주소 1,  구 1, 병원 카테고리 2, 응급 4 int, 기관명10, 세부분과3
        //파일 가공 후 쓰기
        List<String> dbData = new ArrayList<>();
        for (Hospital hospital : hospitals) {
            String makeStr = String.format("(\'%s\',\'%s\',\'%s\',\'%s\',%d,\'%s\',\'%s\'),\n"
                    , hospital.getId()
                    , hospital.getAddress()
                    , hospital.getDistrict()
                    , hospital.getCategory()
                    , hospital.getEmergencyRoom()
                    , hospital.getName()
                    , hospital.getSubdivision());
            dbData.add(makeStr);
        }
        write.writeFile(dbData, reprocessData);



    }
}

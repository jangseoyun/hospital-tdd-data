package com.line.parser;

import com.line.domain.Hospital;

public class HospitalParser implements Parser<Hospital> {
    //순서 : 기관아이디 0, 주소 1,  구 1, 병원 카테고리 2, 응급 6, 기관명10, 세부분과3
    public String replaceAll(String str) {
        str = str.replaceAll("\'", " ");
        return str;
    }

    @Override
    public Hospital parse(String str) {
        //TODO: 라인을 받고 바로 replace하면 메서드를 만들지 않아도 된다
        String[] splitStr = str.split(",");

        String name = splitStr[10];
        String subdivision = getSubdivision(name);

        return new Hospital(splitStr[0]
                , replaceAll(splitStr[1])
                , splitStr[2]
                , splitStr[6]
                , splitStr[10]
                , subdivision);
    }

    private String getSubdivision(String name) {
        String[] subdivisions = {"소아과", "피부과", "성형외과", "정형외과", "산부인과", "관절", "안과", "가정의학과", "비뇨기과", "치과", "내과", "외과"};

        for (String subdivision : subdivisions) {
            if (name.contains(subdivision)) {
                return subdivision;
            }
        }
        return "";
    }


}

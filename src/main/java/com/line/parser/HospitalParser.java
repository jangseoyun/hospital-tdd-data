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
        return new Hospital(splitStr[0], replaceAll(splitStr[1]), splitStr[2], splitStr[6], splitStr[10], splitStr[3]);
    }

    /*this.id =id;
    this.address =address;
    this.district =district;
    this.category =category;
    this.emergencyRoom =emergencyRoom;
    this.name =name;
    this.subdivision =subdivision;*/
}

package com.line.parser;

import com.line.domain.Hospital;

public class HospitalParser implements Parser<Hospital> {
    //순서 : 기관아이디 0, 주소 1,  구 1, 병원 카테고리 2, 응급 4, 기관명10, 세부분과3
   public String replaceAll(String str) {
       str = str.replaceAll("\'", " ");
       return str;
   }

    @Override
    public Hospital parse(String str) {
        String[] splitStr = str.split(",");
        return new Hospital(splitStr[0], splitStr[1], setDistrict(splitStr[1]), splitStr[2], splitStr[6], splitStr[10], splitStr[3]);
    }

    private String setDistrict(String district) {
        String[] splitDistrict = district.split(" ");
        district = splitDistrict[0] + " " + splitDistrict[1];
        return district;
    }

    /*this.id =id;
    this.address =address;
    this.district =district;
    this.category =category;
    this.emergencyRoom =emergencyRoom;
    this.name =name;
    this.subdivision =subdivision;*/
}

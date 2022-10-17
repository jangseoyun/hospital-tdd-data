package com.project.vo;

public class HospitalVo {

    private String id;
    private String address;
    private String district;
    private String category;
    private int emergencyRoom;
    private String name;
    private String subdivision;

    public HospitalVo(String id, String address, String category, String emergencyRoom, String name, String subdivision) {
        this.id = id;
        this.address = address;
        this.district = setDistrict();
        this.category = category;
        this.emergencyRoom = Integer.valueOf(emergencyRoom);
        this.name = name;
        this.subdivision = subdivision;
    }

    public HospitalVo(String id, String address, String category, int emergencyRoom, String name, String subdivision) {
        this.id = id;
        this.address = address;
        this.district = setDistrict();
        this.category = category;
        this.emergencyRoom = emergencyRoom;
        this.name = name;
        this.subdivision = subdivision;
    }

    private String setDistrict() {
        String[] splitDistrict = address.split(" ");
        return this.district = splitDistrict[0] + " " + splitDistrict[1];
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getDistrict() {
        return district;
    }

    public String getCategory() {
        return category;
    }

    public Integer getEmergencyRoom() {
        return emergencyRoom;
    }

    public String getName() {
        return name;
    }

    public String getSubdivision() {
        return subdivision;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "id='" + id + '\'' +
                ", address='" + address + '\'' +
                ", district='" + district + '\'' +
                ", category='" + category + '\'' +
                ", emergencyRoom=" + emergencyRoom +
                ", name='" + name + '\'' +
                ", subdivision='" + subdivision + '\'' +
                '}';
    }
}

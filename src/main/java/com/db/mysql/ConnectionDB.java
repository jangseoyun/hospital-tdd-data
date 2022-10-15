package com.db.mysql;

import com.line.domain.Hospital;

import java.sql.*;

public class ConnectionDB {

    private static String connectionUrl = "jdbc:mysql://ec2-52-79-155-81.ap-northeast-2.compute.amazonaws.com:3306/likelion-db?serverTimezone=UTC";
    private static String dbId = "root";
    private static String dbPw = "password";
    private static Query query = new QueryImpl();

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn  =DriverManager.getConnection(connectionUrl, dbId, dbPw);//java mysql 연결
            pstmt = conn.prepareStatement(query.selectAll());
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String id = rs.getString("id");
                String address = rs.getString("address");
                String district = rs.getString("district");
                String category = rs.getString("category");
                int emergencyRoom = rs.getInt("emergency_room");
                String name = rs.getString("name");
                String subdivision = rs.getString("subdivision");

                Hospital hospital = new Hospital(id, address, category, emergencyRoom, name, subdivision);
                System.out.println(hospital);
            }

        } catch (SQLException e) {
            e.getMessage();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}

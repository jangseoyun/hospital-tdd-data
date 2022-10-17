package com.db.mysql;

import com.line.domain.Hospital;

import java.sql.*;
import java.util.Map;

public class ConnectionDB {

    private static Map<String, String> env = System.getenv();
    private static String dbPw = env.get("DB_PASSWORD");
    private static String dbUser = env.get("DB_USER");
    private static String dbHost = env.get("DB_HOST");
    private static Query query = new QueryImpl();

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(dbHost, dbUser, dbPw);//java mysql 연결
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

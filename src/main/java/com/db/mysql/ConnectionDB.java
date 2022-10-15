package com.db.mysql;

import java.sql.*;

public class ConnectionDB {

    private static String connectionUrl = "jdbc:mysql://ec2-52-79-155-81.ap-northeast-2.compute.amazonaws.com:3306/likelion-db?serverTimezone=UTC";
    private static String sqlSelectAll = "SELECT * FROM `likelion-db`.seoul_hospital";

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(connectionUrl, "root", "password");
            PreparedStatement ps = conn.prepareStatement(sqlSelectAll);
            ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String id = rs.getString("id");
                System.out.println(id);
            }

        } catch (SQLException e) {
            e.getMessage();
        }

    }

}

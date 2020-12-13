package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/compsci_ia", "root", "");
        Statement stmt = con.createStatement();
        int result = stmt.executeUpdate("INSERT INTO garden (datetime, moisture, light_intensity, is_raining) VALUES (\"2020-12-10\", 40, 40, 0)");
        System.out.println("Code executed successfully!");
        con.close();
    } catch (Exception e) {
        System.out.println(e);
    }
    }
}

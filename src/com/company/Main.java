package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.sql.*;

import java.sql.*;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        // Input file
        ArrayList<DataEntry> rows = new ArrayList<>();
        try {
            FileReader file = new FileReader("src/com/company/input.csv");
            BufferedReader reader = new BufferedReader(file);
            String line;
            try {
                while ((line = reader.readLine()) != null) {
                    String[] values = line.split(",");
                    DataEntry data = new DataEntry(new SimpleDateFormat("yyyy-MM-dd").parse(values[0]), Integer.parseInt(values[1]), Integer.parseInt(values[2]), (Integer.parseInt(values[3]) == 1));
                    rows.add(data);
                }
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        // Upload data
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/compsci_ia", "root", "");
            Iterator<DataEntry> iterator = rows.iterator();
            Statement stmt;
            while (iterator.hasNext()) {
                stmt = con.createStatement();
                DataEntry data = iterator.next();
                int result = stmt.executeUpdate("INSERT INTO garden (datetime, moisture, light_intensity, is_raining) VALUES (\"" + data.getDateString() + "\", " + data.getMoisture() +", " + data.getLightIntensity() + ", " + data.getRainingInt() +")");
            }
            System.out.println("Code executed successfully!");
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

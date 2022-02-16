/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.csc311_lab_access_json;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author soblab
 */
public class Main {

    public static void main(String[] args) {
        //System.out.println("Hello World1!");
        String databaseURL = "";
        Connection conn = null;
        try {
            databaseURL = "jdbc:ucanaccess://.//Company.accdb";
            conn = DriverManager.getConnection(databaseURL);

            String tableName = "Employees";
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("select * from " + tableName);
            while (result.next()) {
                int id = result.getInt("ID");
                String first = result.getString("EmployeeName");
                double salary = result.getDouble("Salary");
                System.out.printf("%d %s %s\n", id, first, salary);
            }

        } catch (SQLException ex) {
            //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            ex.getMessage();
        }
    }
}

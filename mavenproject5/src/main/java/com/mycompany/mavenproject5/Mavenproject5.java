/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject5;

import java.sql.*;

public class Mavenproject5 {

    public static void main(String[] args) {
        String name = "Eunice";
        String age = "20";
        try {
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/testest",
                        "root", "poginijem");

                    Statement st = connection.createStatement();

                    st.executeUpdate("insert into testing2 (NAME, AGE)" + "values ('"+name+"','"+age+"')");
                    
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
    }
}

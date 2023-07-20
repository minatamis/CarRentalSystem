package com.mycompany.mavenproject5;

import java.sql.*;

public class InsertInto {

    public static void main(String[] args) {
        String name = "Jem";
        String age = "19";
        try {
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/testest",
                        "root", "poginijem");

                    Statement st = connection.createStatement();

                    st.executeUpdate("insert into testing2 (NAME, AGE)" + "values ('"+name+"','"+age+"')");
                    System.out.println("Tapos na");
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
    }
}

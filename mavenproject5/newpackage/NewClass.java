package com.mycompany.mavenproject5.newpackage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NewClass {
    
    public static void main(String[] args) {
        String High = "Jem";
        String Low = "19";
                try {
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/testest",
                        "root", "poginijem");

                    PreparedStatement st = (PreparedStatement) connection
                        .prepareStatement("Select * from testing2 where Age=? ");
                    
                    st.setString(1, Low);
//                    st.setString(2, Low);
                    
                    ResultSet rs = st.executeQuery();
                   while(rs.next())
                   {
                       System.out.println(rs.getString(1)+" "+rs.getString(2));
                   }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
    }
}

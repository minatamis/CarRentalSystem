package com.mycompany.carrentalsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.*;
import java.awt.event.*;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class CarRentalTable extends JFrame implements ActionListener
{
    
    JFrame table;
    JButton rentButton;
    ListSelectionModel select;
    String Data;

    CarRentalTable() throws SQLException
    {   
        setTitle("Car Availability");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/carrentalsystem","root", "Jem4764?");


        String query = "SELECT * FROM car";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Brand");
        tableModel.addColumn("Model");
        tableModel.addColumn("Transmission");
        tableModel.addColumn("Category");
        tableModel.addColumn("Availability");

        while (resultSet.next()) 
        {
            String Brand = resultSet.getString("Brand"); 
            String Model = resultSet.getString("Model"); 
            String Transmission = resultSet.getString("Transmission"); 
            String Category = resultSet.getString("Category"); 
            String Availability = resultSet.getString("Availability"); 

            tableModel.addRow(new Object[] { Brand, Model, Transmission, Category, Availability});
        }

        resultSet.close();
        statement.close();
        connection.close();

        JTable carTable = new JTable(tableModel);
        add(new JScrollPane(carTable));
        //JScrollPane sp = new JScrollPane(jt);
        //add(sp);
        setSize(800,800);
        setVisible(true);
        setLocationRelativeTo(null);
        //setResizable(false);
    }
    
        @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == rentButton)
        {
//            jt.setCellSelectionEnabled(true);  
//            select = jt.getSelectionModel();  
//            select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
//            select.addListSelectionListener(new ListSelectionListener() {  
//                public void valueChanged(ListSelectionEvent e) {  
//
//            int[] row = jt.getSelectedRows();  
//            int[] columns = jt.getSelectedColumns();  
//            for (int i = 0; i < row.length; i++) {  
//            for (int j = 0; j < columns.length; j++) {  
//              Data = (String) jt.getValueAt(row[i], columns[j]);  
//            } }  
//              System.out.println("Car Rented Successfully: " + Data);    
//            }       
//            });  
            System.out.println("Car Rented Successfully: " + Data);   
        }
    }
}
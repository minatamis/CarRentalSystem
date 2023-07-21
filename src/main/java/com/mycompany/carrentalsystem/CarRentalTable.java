package com.mycompany.carrentalsystem;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.*;
import java.sql.Connection;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class CarRentalTable extends JFrame implements ActionListener
{
    
    JFrame table;
    JButton rentButton, btnNewButton;
    JTable jt;
    ListSelectionModel select;
    String Data;
    
    CarRentalTable()
    {   
        setTitle("Car Availability");
        try 
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
        String[] column = {"Model"};
        String[][] data = {{"Civic"}, {"Vios"}, {"Eon"}, {"Raptor"}};
        
        JTable jt = new JTable(data,column);
        jt.setBounds(30, 40, 200, 300);

            jt.setCellSelectionEnabled(true);  
            ListSelectionModel select= jt.getSelectionModel();  
            select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
            select.addListSelectionListener(new ListSelectionListener() {  
                public void valueChanged(ListSelectionEvent e) {  
            int[] row = jt.getSelectedRows();  
            int[] columns = jt.getSelectedColumns();  
            for (int i = 0; i < row.length; i++) {  
            for (int j = 0; j < columns.length; j++) {  
              Data = (String) jt.getValueAt(row[i], columns[j]);  
            } }  
              //System.out.println("Car Rented Successfully: " + Data);    
            }       
            });  
            
        rentButton = new JButton("RENT");
        rentButton.setBounds(115, 150, 100, 30);
        rentButton.addActionListener(this);
        
        add(rentButton);
        JScrollPane sp = new JScrollPane(jt);
        add(sp);
        setSize(350,350);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
        @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == rentButton)
        {
            System.out.println("Car Rented Successfully: " + Data);
            RentInfo rent = new RentInfo();
            rent.setVisible(true);
            String updateInUserStatement = "UPDATE userinfo SET carInRent=? WHERE userEmail=? and userPassword=?";
            String updateInCarStatement = "UPDATE car SET Availability=? WHERE Model=?";
            
            try 
            {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/carrentalsystem", "root", "Jem4764?");

                PreparedStatement userSt = connection.prepareStatement(updateInUserStatement);
                PreparedStatement carSt = connection.prepareStatement(updateInCarStatement);

                

                int userRowsAffected = userSt.executeUpdate();
                carSt.executeUpdate();
                if (userRowsAffected > 0)
                {
                    dispose();
                    UserLogin logIn = new UserLogin();
                    logIn.setVisible(true);
                    JOptionPane.showMessageDialog(btnNewButton, "You've Rented");
                }
                else
                {
                    JOptionPane.showMessageDialog(btnNewButton, "Please Try Again");
                }
            }
            catch (SQLException sqlException)
            {
                sqlException.printStackTrace();
            }
            
        }
    }
    
}

package com.mycompany.carrentalsystem;

import java.awt.Label;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class CarRentalInterface extends JFrame implements ActionListener {
    
    JFrame carRentWindow;
    JComboBox carBrandCombo, carTransmissionCombo, carModelCombo;
    JButton checkAvailabilityButton;
    Label modelLabel;    
    List<String> carList;
    CarRentalInterface()
    {
        setSize(350,350);  
        setTitle("Rent a Car");
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        //setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try 
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
        
        //for car rental
        Label brandLabel = new Label("Brand:");
        brandLabel.setBounds(50, 20, 40, 30);
        String[] brand = {"Honda", "Toyota", "Hyundai", "Nissan", "Mitsubishi", "Mazda"};
        carBrandCombo = new JComboBox(brand);
        carBrandCombo.setBounds(130, 20, 150, 25);
        
        Label transmissionLabel = new Label("Transmission Type:");
        transmissionLabel.setBounds(25,70,95,30);
        String[] trans = {"Automatic", "Manual"};
        carTransmissionCombo = new JComboBox(trans);
        carTransmissionCombo.setBounds(130,70,150, 25);


        checkAvailabilityButton = new JButton("Check Availability");
        checkAvailabilityButton.setBounds(15, 120, 300,30);
        modelLabel = new Label("Car Model:");
        modelLabel.setBounds(45, 180, 60, 30);
        
        carModelCombo = new JComboBox();
        carModelCombo.setBounds(130, 180, 150, 25);
        modelLabel.setVisible(false);
        carModelCombo.setVisible(false);
        
//        Label user = new Label("User: " + thisUser.name);
//        user.setBounds(10, 200, 200,25);
//        add(user);
            
        add(brandLabel);
        add(carBrandCombo);
        add(transmissionLabel);
        add(carTransmissionCombo);
//      add(modelLabel);
//      add(carModelCombo);
        add(checkAvailabilityButton);
        checkAvailabilityButton.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == checkAvailabilityButton)
        {
            String SelectedModel = carBrandCombo.getSelectedItem().toString();
            String SelectedTransmission = carBrandCombo.getSelectedItem().toString();
            try {
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/carrentalsystem","root", "Jem4764?");

                    PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select Model from car where Brand=? and Transmission=?");
                    
                    st.setString(1, SelectedModel);
                    st.setString(2, SelectedTransmission);
                    
                    ResultSet rs = st.executeQuery();
                    carList = new ArrayList<String>();            

                   while (rs.next())
                   {
//                       carList.add(new CarInfo
//                               [
//                                   String carBrand = rs.getString(1);
//                               
//                               ]);
                       dispose();
                        carList.add(rs.getString(1));
                        CarRentalTable table = new CarRentalTable();
                        table.setVisible(true);

                       
                   }
                                       
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            
            modelLabel.setVisible(true);
            carModelCombo.setVisible(true);
            
            add(modelLabel);
            add(carModelCombo);   
        }

    }
    
}


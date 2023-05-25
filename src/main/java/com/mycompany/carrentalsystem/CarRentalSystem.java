package com.mycompany.carrentalsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CarRentalSystem extends JFrame implements ActionListener
{
    static JFrame carRentWindow;
    static JComboBox carBrand;
    static JComboBox carTransmission;
    static JComboBox carModel;
    public static void main(String[] args)
    {
        carRentWindow = new JFrame("Rent a Car");
        try 
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) 
        {
            System.err.println(e.getMessage());
        }
        
        Label brand = new Label("Brand");
        carBrand = new JComboBox();
        carBrand.setPreferredSize(new Dimension(200, 25));
        Label transmission = new Label("Transmission Type");
        carTransmission = new JComboBox();
        carTransmission.setPreferredSize(new Dimension(200, 25));
        Label model = new Label("Car Model");
        carModel = new JComboBox();
        carModel.setPreferredSize(new Dimension(200, 25));
        
        //panels
        JPanel carRentalPanel = new JPanel();
        JPanel customerInfoPanel = new JPanel();
        
        //add to panel
        carRentalPanel.add(brand);
        carRentalPanel.add(carBrand);
        carRentalPanel.add(transmission);
        carRentalPanel.add(carTransmission);
        carRentalPanel.add(model);
        carRentalPanel.add(carModel);
        
        ///window
        carRentWindow.add(carRentalPanel);
        carRentWindow.setSize(350,350);
        carRentWindow.show();
        carRentWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    public void actionPerformed(ActionEvent e)
    {
        
        
    }
    
}

package carrentalsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CarRentalInterface extends JFrame implements ActionListener {
    
    static JFrame carRentWindow;
    static JComboBox carBrandCombo, carTransmissionCombo, carModelCombo;
    static JButton checkAvailabilityButton;
    static Label modelLabel;
    
    CarRentalInterface()
    {
        setSize(350,350);  
        setTitle("Rent a Car");
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
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
        carBrandCombo = new JComboBox();
        carBrandCombo.setBounds(130, 20, 150, 25);
        Label transmissionLabel = new Label("Transmission Type:");
        transmissionLabel.setBounds(25,70,95,30);
        carTransmissionCombo = new JComboBox();
        carTransmissionCombo.setBounds(130,70,150, 25);
//        Label modelLabel = new Label("Car Model:");
//        modelLabel.setBounds(45, 180, 50, 30);
//        carModelCombo = new JComboBox();
//        carModelCombo.setBounds(130, 180, 150, 25);
        checkAvailabilityButton = new JButton("Check Availability");
        checkAvailabilityButton.setBounds(15, 120, 300,30);
        modelLabel = new Label("Car Model:");
        modelLabel.setBounds(45, 180, 60, 30);
        carModelCombo = new JComboBox();
        carModelCombo.setBounds(130, 180, 150, 25);
        modelLabel.setVisible(false);
        carModelCombo.setVisible(false);
            
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
//            Label modelLabel = new Label("Car Model:");
//            modelLabel.setBounds(45, 180, 60, 30);
//            carModelCombo = new JComboBox();
//            carModelCombo.setBounds(130, 180, 150, 25);
            modelLabel.setVisible(true);
            carModelCombo.setVisible(true);
            add(modelLabel);
            add(carModelCombo);   
        }

    }
    
}


package carrentalsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CarRentalInterface extends JFrame implements ActionListener {
    
    static JFrame carRentWindow;
    static JComboBox carBrandCombo, carTransmissionCombo, carModelCombo;
    static JButton checkAvailabilityButton;
    
    CarRentalInterface()
    {
        setTitle("Rent a Car");
        try 
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
        
        //for car rental
        Label brandLabel = new Label("Brand");
        carBrandCombo = new JComboBox();
        carBrandCombo.setPreferredSize(new Dimension(200, 25));
        Label transmissionLabel = new Label("Transmission Type");
        carTransmissionCombo = new JComboBox();
        carTransmissionCombo.setPreferredSize(new Dimension(200, 25));
        Label modelLabel = new Label("Car Model");
        carModelCombo = new JComboBox();
        carModelCombo.setPreferredSize(new Dimension(200, 25));
        checkAvailabilityButton = new JButton("Check Availability");
        checkAvailabilityButton.setPreferredSize(new Dimension(300, 25));
        
        //panels
        JPanel carRentalPanel = new JPanel();
        
        //add to carRentalPanel
        carRentalPanel.add(brandLabel);
        carRentalPanel.add(carBrandCombo);
        carRentalPanel.add(transmissionLabel);
        carRentalPanel.add(carTransmissionCombo);
        carRentalPanel.add(modelLabel);
        carRentalPanel.add(carModelCombo);
        carRentalPanel.add(checkAvailabilityButton);
        
        //window
        add(carRentalPanel);
        setSize(350,350);        
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        
        
    }
    
}


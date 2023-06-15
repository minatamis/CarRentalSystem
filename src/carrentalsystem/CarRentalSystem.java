package carrentalsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CarRentalSystem extends JFrame implements ActionListener
{
    static JFrame carRentWindow;
    //car info
    static JComboBox carBrandCombo;
    static JComboBox carTransmissionCombo;
    static JComboBox carModelCombo;
    static JButton checkAvailabilityButton;
    
    //user info
    static JTextField userNameTextField;
    static JTextField userAgeTextField;
    static JTextField userEmailTextField;
    static JTextField userNumberTextField;
    static JTextField userAddressTextField;
    static JButton submitInfoButton;
    
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
        
        //for customer info
        Label nameLabel = new Label("Name:");
        userNameTextField = new JTextField(30);
        Label ageLabel = new Label("Age:");
        userAgeTextField = new JTextField(30);
        Label emailLabel = new Label("Email:");
        userEmailTextField = new JTextField(30);
        Label numberLabel = new Label("Mobile:");
        userNumberTextField = new JTextField(30);
        Label adddressLabel = new Label("Adddress:");
        userAddressTextField = new JTextField(30);
        submitInfoButton = new JButton("Submit");
        submitInfoButton.setPreferredSize(new Dimension(100, 25));
        
        //panels
        JPanel carRentalPanel = new JPanel();
        //JPanel customerInfoPanel = new JPanel();
        
        //add to carRentalPanel
        carRentalPanel.add(brandLabel);
        carRentalPanel.add(carBrandCombo);
        carRentalPanel.add(transmissionLabel);
        carRentalPanel.add(carTransmissionCombo);
        carRentalPanel.add(modelLabel);
        carRentalPanel.add(carModelCombo);
        carRentalPanel.add(checkAvailabilityButton);
        
        //add to customerInfoPanel (experiment only)
        carRentalPanel.add(nameLabel);
        carRentalPanel.add(userNameTextField);
        carRentalPanel.add(ageLabel);
        carRentalPanel.add(userAgeTextField);
        carRentalPanel.add(emailLabel);
        carRentalPanel.add(userEmailTextField);
        carRentalPanel.add(numberLabel);
        carRentalPanel.add(userNumberTextField);
        carRentalPanel.add(adddressLabel);
        carRentalPanel.add(userAddressTextField);
        carRentalPanel.add(submitInfoButton);
        
        ///window
        carRentWindow.add(carRentalPanel);
        //carRentWindow.add(customerInfoPanel);
        carRentWindow.setSize(350,350);
        carRentWindow.show();
        carRentWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    public void actionPerformed(ActionEvent e)
    {
        
        
    }
    
}

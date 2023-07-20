package com.mycompany.carrentalsystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UserRegistration extends JFrame implements ActionListener
{
    static JFrame userRegistrationWindow;
    static JTextField userNameTextField, userAgeTextField, userEmailTextField, userNumberTextField, userAddressTextField;
    static JPasswordField clientPasswordTextField;
    static JButton submitInfoButton, backButton;
    
    UserRegistration()
    {
        setTitle("Register");
        setLayout(null);
        setSize(350,250);
        setVisible(true);
        setLocationRelativeTo(null);
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
        
        Label nameLabel = new Label("Name:");
        nameLabel.setBounds(10,10,60,25);
        add(nameLabel);
        userNameTextField = new JTextField();
        userNameTextField.setBounds(70, 10, 250, 25);
        add(userNameTextField);

        
        Label ageLabel = new Label("Age:");
        ageLabel.setBounds(10, 40, 60, 25);
        add(ageLabel);
        userAgeTextField = new JTextField(30);
        userAgeTextField.setBounds(70, 40, 40, 25);
        add(userAgeTextField);

        Label numberLabel = new Label("Mobile:");
        numberLabel.setBounds(120, 40, 40, 25);
        add(numberLabel);
        userNumberTextField = new JTextField(30);
        userNumberTextField.setBounds(170, 40, 150, 25);
        add(userNumberTextField);

        Label adddressLabel = new Label("Adddress:");
        adddressLabel.setBounds(10, 70, 60, 25);
        add(adddressLabel);
        userAddressTextField = new JTextField(30);
        userAddressTextField.setBounds(70, 70, 250, 25);
        add(userAddressTextField);

        Label emailLabel = new Label("Email:");
        emailLabel.setBounds(10, 100, 60, 25);
        add(emailLabel);
        userEmailTextField = new JTextField(30);
        userEmailTextField.setBounds(70, 100, 250, 25);
        add(userEmailTextField);

        Label clientPasswordLabel = new Label("Password:");
        clientPasswordLabel.setBounds(10, 130, 60, 25);
        add(clientPasswordLabel);
        clientPasswordTextField = new JPasswordField(20);
        clientPasswordTextField.setBounds(70, 130, 250, 25);
        add(clientPasswordTextField);

        
        backButton = new JButton("Back");
        backButton.setBounds(69, 160, 100, 25);
        
        submitInfoButton = new JButton("Submit");
        submitInfoButton.setBounds(174, 160, 100, 25);
        
        backButton.addActionListener(this);
        submitInfoButton.addActionListener(this);
        
        
        add(backButton);
        add(submitInfoButton);
        
        //window
                
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == backButton)
        {
            dispose();
            UserLogin userLog = new UserLogin();
            userLog.setVisible(true);
        }
        else if(e.getSource() == submitInfoButton)
        {
            
        }
        
    }
    
}

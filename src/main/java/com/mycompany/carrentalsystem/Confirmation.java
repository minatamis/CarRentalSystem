package com.mycompany.carrentalsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Confirmation extends JFrame implements ActionListener
{
    JFrame userLoginWindow;
    JTextField clientUsernameTextField,clientCarChoiceTxtField;
    JPasswordField clientPasswordTextField;
    JButton rentButton, btnNewButton;
    Confirmation()
    {
        setTitle("Confirm your Rent");
        try 
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
        
        Label clientCarChoice = new Label("Your Choice:");
        clientCarChoiceTxtField = new JTextField(20);
        Label clientUsernameLabel = new Label("Username   :");
        clientUsernameTextField = new JTextField(20);
        Label clientPasswordLabel = new Label("Password   :");
        clientPasswordTextField = new JPasswordField(20);
        rentButton = new JButton("Continue Rent");
        rentButton.setPreferredSize(new Dimension(150, 25));
//        registerButton = new JButton("Register");
//        registerButton.setPreferredSize(new Dimension(100, 25));
        
        rentButton.addActionListener(this);
//        registerButton.addActionListener(this);
        
        //panel
        JPanel userLogInPanel = new JPanel();
        
        userLogInPanel.add(clientCarChoice);
        userLogInPanel.add(clientCarChoiceTxtField);
        userLogInPanel.add(clientUsernameLabel);
        userLogInPanel.add(clientUsernameTextField);
        userLogInPanel.add(clientPasswordLabel);
        userLogInPanel.add(clientPasswordTextField);
        userLogInPanel.add(rentButton);
//        userLogInPanel.add(registerButton);
        
        //window
        add(userLogInPanel);
        setSize(300,200);
        setVisible(false);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        
    }

}

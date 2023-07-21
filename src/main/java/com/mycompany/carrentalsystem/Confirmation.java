package com.mycompany.carrentalsystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

public class Confirmation extends JFrame implements ActionListener
{
    JFrame userLoginWindow;
    JTextField clientUsernameTextField,clientCarChoiceTxtField;
    JPasswordField clientPasswordTextField;
    JButton rentButton, btnNewButton;
    private Connection connection;
    String car, username, password;
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
        username = clientUsernameTextField.getText();
        password = clientPasswordTextField.getText();
        car = clientCarChoiceTxtField.getText();
        
        try
        {
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/carrentalsystem","root", "Jem4764?");
            connection.setAutoCommit(false);
//            PreparedStatement userPrepStatement = (PreparedStatement) connection.prepareStatement(userSt);
//            PreparedStatement carPrepStatement = (PreparedStatement) connection.prepareStatement(carSt);
            if(updateUserTable(connection, username, password, car))
            {
                updateCarTable(connection,car);
            }            
           
            

        }catch (SQLException sqlException) 
        {
            sqlException.printStackTrace();
        }

    }
    public boolean updateUserTable(Connection connection, String email, String pass, String car) throws SQLException 
    {
        String userSt = "UPDATE userinfo SET carInRent=? WHERE userEmail=? and userPassword=?";
        try (PreparedStatement userPrepStatement = connection.prepareStatement(userSt)) 
        {
            userPrepStatement.setString(1, car);
            userPrepStatement.setString(2, email);
            userPrepStatement.setString(3, pass);

            int rowsAffected = userPrepStatement.executeUpdate();
            if(rowsAffected > 0)
            {
                dispose();
                JOptionPane.showMessageDialog(btnNewButton, "You've been Registered Successfully");
                return true;
            }
            return false;
        }

    }
    
    public void updateCarTable(Connection connection, String model) throws SQLException 
    {
        String carSt = "UPDATE car SET Availability=? WHERE Model=? and Availability=?";
        try (PreparedStatement carPrepStatement = connection.prepareStatement(carSt)) 
        {
            carPrepStatement.setString(1, "Unavailable");
            carPrepStatement.setString(2, model);
            carPrepStatement.setString(3, "Available");

            int rowsAffected = carPrepStatement.executeUpdate();
            if(rowsAffected > 0)
            {
                dispose();
                JOptionPane.showMessageDialog(btnNewButton, "You've Rented Successfully");
            }
            else
            {
                JOptionPane.showMessageDialog(btnNewButton, "The Car is Unavailable");
            }
        }

    }

}

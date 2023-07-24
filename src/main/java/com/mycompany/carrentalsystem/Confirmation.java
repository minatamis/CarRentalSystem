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
public void actionPerformed(ActionEvent e) {
    username = clientUsernameTextField.getText();
    password = clientPasswordTextField.getText();
    car = clientCarChoiceTxtField.getText();
    
    
    try {
        connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/carentalsystem", "root", "poginijem");
        connection.setAutoCommit(false);
        CarRentalTable table = new CarRentalTable();
        table.setVisible(false);


        if (updateUserTable(connection, username, password, car)) {
            updateCarTable(connection, car);
            
            connection.commit(); // Commit the changes to the database
            dispose(); // Dispose the frame after successful updates
                        
            
            table.setVisible(true);

            
            
            JOptionPane.showMessageDialog(btnNewButton, "You've been Registered and Rented Successfully");
            Invoice invoice = new Invoice(username, car);
            invoice.setVisible(true);
            
            
        } else {
            connection.rollback(); // Rollback changes if updateUserTable fails
            JOptionPane.showMessageDialog(btnNewButton, "Error: Unable to Register and Rent");
        }
    } catch (SQLException sqlException) {
        sqlException.printStackTrace();
        try {
            connection.rollback(); // Rollback changes in case of SQLException
        } catch (SQLException rollbackException) {
            rollbackException.printStackTrace();
        }
    }
}

public boolean updateUserTable(Connection connection, String email, String pass, String car) throws SQLException {
    String userSt = "UPDATE userinfo SET carInRent=? WHERE userEmail=? and userPassword=?";
    try (PreparedStatement userPrepStatement = connection.prepareStatement(userSt)) {
        userPrepStatement.setString(1, car);
        userPrepStatement.setString(2, email);
        userPrepStatement.setString(3, pass);

        int rowsAffected = userPrepStatement.executeUpdate();
        return rowsAffected > 0;
    }
}

public void updateCarTable(Connection connection, String model) throws SQLException {
    String carSt = "UPDATE cars SET Availability=? WHERE Model=?";
    try (PreparedStatement carPrepStatement = connection.prepareStatement(carSt)) {
        carPrepStatement.setString(1, "Unavailable");
        carPrepStatement.setString(2, model);

        int rowsAffected = carPrepStatement.executeUpdate();
        if (rowsAffected <= 0) {
            JOptionPane.showMessageDialog(btnNewButton, "The Car is Unavailable");
        }
    }
}
}
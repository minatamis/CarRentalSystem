package com.mycompany.carrentalsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UserRegistration extends JFrame implements ActionListener
{
    JFrame userRegistrationWindow;
    JTextField userNameTextField, userAgeTextField, userEmailTextField, userNumberTextField, userAddressTextField;
    JPasswordField clientPasswordTextField;
    JButton submitInfoButton, backButton, btnNewButton;
    
    UserRegistration()
    {
        setTitle("Register");
        setLayout(null);
        setSize(900,600);
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
        
        Label titleLbl = new Label("REGISTER");
        Font titleFont = new Font("Arial", Font.BOLD | Font.BOLD, 40);
        titleLbl.setBounds(340,25,300,40);
        titleLbl.setFont(titleFont);
        add(titleLbl);
        
        Label nameLabel = new Label("Name:");
        Font nameFont = new Font("Arial", Font.PLAIN, 30);
        nameLabel.setFont(nameFont);
        nameLabel.setBounds(70,100,100,35);
        add(nameLabel);
        userNameTextField = new JTextField();
        Font nameTFFont = new Font("Arial", Font.PLAIN, 25);
        userNameTextField.setFont(nameTFFont);
        userNameTextField.setBounds(220, 100, 590, 35);
        add(userNameTextField);

        
        Label ageLabel = new Label("Age:");
        Font ageFont = new Font("Arial", Font.PLAIN, 30);
        ageLabel.setFont(ageFont);
        ageLabel.setBounds(70, 150, 100, 35);
        add(ageLabel);
        userAgeTextField = new JTextField();
        Font ageTFFont = new Font("Arial", Font.PLAIN, 25);
        userAgeTextField.setFont(ageTFFont);
        userAgeTextField.setBounds(220, 150, 80, 35);
        userAgeTextField.setText("0");
        add(userAgeTextField);

        Label numberLabel = new Label("Mobile:");
        Font mobileFont = new Font("Arial", Font.PLAIN, 30);
        numberLabel.setFont(mobileFont);
        numberLabel.setBounds(340, 150, 100, 35);
        add(numberLabel);
        userNumberTextField = new JTextField();
        Font mobileTFFont = new Font("Arial", Font.PLAIN, 25);
        userNumberTextField.setFont(mobileTFFont);
        userNumberTextField.setBounds(470, 150, 340, 35);
        add(userNumberTextField);

        Label adddressLabel = new Label("Address:");
        Font adddressFont = new Font("Arial", Font.PLAIN, 30);
        adddressLabel.setFont(adddressFont);
        adddressLabel.setBounds(70, 200, 150, 35);
        add(adddressLabel);
        userAddressTextField = new JTextField();
        Font adddressTFFont = new Font("Arial", Font.PLAIN, 25);
        userAddressTextField.setFont(adddressTFFont);
        userAddressTextField.setBounds(220, 200, 590, 35);
        add(userAddressTextField);

        Label emailLabel = new Label("Email:");
        Font emailFont = new Font("Arial", Font.PLAIN, 30);
        emailLabel.setFont(emailFont);
        emailLabel.setBounds(70, 250, 100, 35);
        add(emailLabel);
        userEmailTextField = new JTextField();
        Font emailTFFont = new Font("Arial", Font.PLAIN, 25);
        userEmailTextField.setFont(emailTFFont);
        userEmailTextField.setBounds(220, 250, 590, 35);
        add(userEmailTextField);

        Label clientPasswordLabel = new Label("Password:");
        Font clientPasswordFont = new Font("Arial", Font.PLAIN, 30);
        clientPasswordLabel.setFont(clientPasswordFont);
        clientPasswordLabel.setBounds(70, 300, 150, 35);
        add(clientPasswordLabel);
        clientPasswordTextField = new JPasswordField();
        Font clientPasswordTFFont = new Font("Arial", Font.PLAIN, 25);
        clientPasswordTextField.setFont(clientPasswordTFFont);
        clientPasswordTextField.setBounds(220, 300, 590, 35);
        add(clientPasswordTextField);

        
        backButton = new JButton("Back");
        Font backBTNFont = new Font("Arial", Font.PLAIN, 30);
        backButton.setFont(backBTNFont);
        backButton.setBounds(230, 370, 150, 35);
        
        submitInfoButton = new JButton("Submit");
        Font submitBTNFont = new Font("Arial", Font.PLAIN, 30);
        submitInfoButton.setFont(submitBTNFont);
        submitInfoButton.setBounds(500, 370, 150, 35);
        
        backButton.addActionListener(this);
        submitInfoButton.addActionListener(this);
        
        
        add(backButton);
        add(submitInfoButton);
        
        //window
                
  }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String name = userNameTextField.getText();
        int age = Integer.parseInt(userAgeTextField.getText());
        String mobile = userNumberTextField.getText();
        String address = userAddressTextField.getText();
        String email = userEmailTextField.getText();
        String password = clientPasswordTextField.getText();
        String rent = "";
        
        String insertStatement = "INSERT INTO userinfo (userName, userPassword, userAge, userEmail, userNumber, userAddress, carInRent) VALUES (?, ?, ?, ?, ?, ?, ?)";

        if (e.getSource() == backButton)
        {
            dispose();
            UserLogin userLog = new UserLogin();
            userLog.setVisible(true);
        }
        else if (e.getSource() == submitInfoButton)
        {
            try 
            {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/carentalsystem", "root", "poginijem");

                PreparedStatement st = connection.prepareStatement(insertStatement);

                st.setString(1, name);
                st.setString(2, password);
                st.setInt(3, age);
                st.setString(4, email);
                st.setString(5, mobile);
                st.setString(6, address);
                st.setString(7,rent);

                int rowsAffected = st.executeUpdate();
                if (rowsAffected > 0)
                {
                    dispose();
                    UserLogin logIn = new UserLogin();
                    logIn.setVisible(true);
                    JOptionPane.showMessageDialog(btnNewButton, "You've been Registered Successfully");
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

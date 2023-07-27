package com.mycompany.carrentalsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class UserLogin extends JFrame implements ActionListener
{
    
    JTextField clientUsernameTextField;
    JPasswordField clientPasswordTextField;
    JButton logInButton, registerButton, btnNewButton;
    String name, mobile, address, email, pass, carInRent;
    int age;    
    UserLogin()
    {
        setTitle("Log in");
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
        
        Label titleLabel = new Label("LOGIN");
        Font titleFont = new Font("Arial", Font.BOLD | Font.BOLD, 50);
        titleLabel.setBounds(370,60,300,50);
        titleLabel.setFont(titleFont);
        
        
        Label clientUsernameLabel = new Label("Username:");
        Font clientUsernameFont = new Font("Arial", Font.PLAIN, 40);
        clientUsernameLabel.setFont(clientUsernameFont);
        clientUsernameLabel.setBounds(70,190,200,40);
        
        clientUsernameTextField = new JTextField();
        Font clientUsernameTFFont = new Font("Arial", Font.PLAIN, 40);
        clientUsernameTextField.setFont(clientUsernameTFFont);
        clientUsernameTextField.setBounds(290, 190, 520, 40);
        
  
        Label clientPasswordLabel = new Label("Password:");
        Font ageFont = new Font("Arial", Font.PLAIN, 40);
        clientPasswordLabel.setFont(ageFont);
        clientPasswordLabel.setBounds(70, 290, 200, 40);
        
        clientPasswordTextField = new JPasswordField();
        Font ageTFFont = new Font("Arial", Font.PLAIN, 40);
        clientPasswordTextField.setFont(ageTFFont);
        clientPasswordTextField.setBounds(290, 290, 520, 40);
        clientPasswordTextField.setText("0");
        
        
        logInButton = new JButton("Log In");
        Font backBTNFont = new Font("Arial", Font.PLAIN, 40);
        logInButton.setFont(backBTNFont);
        logInButton.setBounds(160, 400, 250, 50);
        
        registerButton = new JButton("Register");
        Font submitBTNFont = new Font("Arial", Font.PLAIN, 40);
        
        registerButton.setFont(submitBTNFont);
        registerButton.setBounds(470, 400, 250, 50);
        
        
        logInButton.addActionListener(this);
        registerButton.addActionListener(this);
        
        
        add(titleLabel);
        add(clientUsernameLabel);
        add(clientUsernameTextField);
        add(clientPasswordLabel);
        add(clientPasswordTextField);
        add(logInButton);
        add(registerButton);
        
        //window
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String username = clientUsernameTextField.getText();
        String password = clientPasswordTextField.getText();
        if(e.getSource() == registerButton)
        {
            dispose();
            UserRegistration userReg = new UserRegistration();
            userReg.setVisible(true);
        }
        else if(e.getSource() == logInButton)
        {
            try {
                Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/carentalsystem","root", "poginijem");

                PreparedStatement st = (PreparedStatement) connection.prepareStatement("SELECT * FROM userinfo WHERE userEmail=? and userPassword=?");

                st.setString(1, username);
                st.setString(2, password);
                ResultSet rs = st.executeQuery();
                if (rs.next()) 
                {
                    dispose();
//                    while(rs.next())
//                    {
//                        name = rs.getString("userName");
//                        age = Integer.parseInt(rs.getString("userAge"));
//                        mobile = rs.getString("userNumber");
//                        address = rs.getString("userAddress");
//                        email = rs.getString("userEmail");
//                        pass = rs.getString("userPassword");
//                        carInRent = rs.getString("carInRent");
//
//                        
//                    }
//                    user.userName = name;
//                    user.userAge = age;
//                    user.userNumber = mobile;
//                    user.userAddress = address;
//                    user.userEmail = email;
//                    user.userPassword = pass;
//                    user.carInRent = carInRent;
                    CarRentalTable home = new CarRentalTable();
                    Confirmation conf = new Confirmation();
                    home.setVisible(true);
                    conf.setVisible(true);
                    
                    JOptionPane.showMessageDialog(btnNewButton, "You have successfully logged in");
                } 
                else 
                {
                    JOptionPane.showMessageDialog(btnNewButton, "Wrong Username & Password");
                }
            } 
            catch (SQLException sqlException) 
            {
                sqlException.printStackTrace();
            }
        }
    }    
}

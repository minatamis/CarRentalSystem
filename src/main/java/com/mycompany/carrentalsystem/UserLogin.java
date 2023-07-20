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
    JFrame userLoginWindow;
    JTextField clientUsernameTextField;
    JPasswordField clientPasswordTextField;
    JButton logInButton, registerButton, btnNewButton;
    
    UserLogin()
    {
        setTitle("Log in");
        try 
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
        
        Label clientUsernameLabel = new Label("Username :");
        clientUsernameTextField = new JTextField(20);
        Label clientPasswordLabel = new Label("Password :");
        clientPasswordTextField = new JPasswordField(20);
        logInButton = new JButton("Log In");
        logInButton.setPreferredSize(new Dimension(100, 25));
        registerButton = new JButton("Register");
        registerButton.setPreferredSize(new Dimension(100, 25));
        
        logInButton.addActionListener(this);
        registerButton.addActionListener(this);
        
        //panel
        JPanel userLogInPanel = new JPanel();
        
        userLogInPanel.add(clientUsernameLabel);
        userLogInPanel.add(clientUsernameTextField);
        userLogInPanel.add(clientPasswordLabel);
        userLogInPanel.add(clientPasswordTextField);
        userLogInPanel.add(logInButton);
        userLogInPanel.add(registerButton);
        
        //window
        add(userLogInPanel);
        setSize(300,150);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
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
                Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/carrentalsystem","root", "Jem4764?");

                PreparedStatement st = (PreparedStatement) connection.prepareStatement("SELECT userEmail, userPassword FROM carrentalsystem.userinfo WHERE userEmail=? and userPassword=?");

                st.setString(1, username);
                st.setString(2, password);
                ResultSet rs = st.executeQuery();
                if (rs.next()) 
                {
                    dispose();
                    CarRentalInterface home = new CarRentalInterface();
                    home.setVisible(true);
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

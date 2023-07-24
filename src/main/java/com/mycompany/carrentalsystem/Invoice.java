package com.mycompany.carrentalsystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import java.sql.*;

public class Invoice extends JFrame implements ActionListener
{
    private JFrame f;
    private JButton okButton;
    private String UserName, email, Number,Address, CarInRent, Brand, model, transmission, category;
    private int Age;
    
    Invoice (String Username, String Model) {
        setTitle("Invoice");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
        
               try 
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
                try {
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/testest",
                        "root", "poginijem");

                    PreparedStatement st = (PreparedStatement) connection
                        .prepareStatement("SELECT * from userinfo WHERE userEmail=?");                   
                    
                    st.setString(1, Username);
                    
                    ResultSet rs = st.executeQuery();
                   while(rs.next())
                   {
                        UserName = rs.getString(1);
                        Age = Integer.parseInt(rs.getString(3));
                        email = rs.getString(4);
                        Number = rs.getString(5);
                        Address = rs.getString(6);
                        CarInRent = rs.getString(7);
                   }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
                
                try {
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/testest",
                        "root", "poginijem");

                    PreparedStatement st = (PreparedStatement) connection
                        .prepareStatement("SELECT * from cars WHERE Model=?");                   
                    
                    st.setString(1, Model);
                    
                    ResultSet rs = st.executeQuery();
                   while(rs.next())
                   {
                        Brand = rs.getString(1);
                        model = rs.getString(2);
                        transmission = rs.getString(3);
                        category = rs.getString(4);
                   }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
                
        JLabel titleLbl = new JLabel("CAR RENTAL INVOICE");
        titleLbl.setBounds(180, 10, 250, 30);
        
        JLabel customerInfoLbl = new JLabel("Customer Information");
        customerInfoLbl.setBounds(130, 35, 250, 30);
        
        JLabel nameLbl = new JLabel("Customer Name: ");
        nameLbl.setBounds(60, 70, 120, 30);
        JLabel nameValue = new JLabel(UserName);
        nameValue.setBounds(150, 70, 250, 30);
        
        JLabel ageLbl = new JLabel("Customer Age: ");
        ageLbl.setBounds(60, 100, 120, 30);
        JLabel ageValue = new JLabel(Integer.toString(Age));
        ageValue.setBounds(150, 100, 100, 30);
        
        JLabel emailLbl = new JLabel("Customer Email: ");
        emailLbl.setBounds(60, 130, 120, 30);
        JLabel emailValue = new JLabel(email);
        emailValue.setBounds(150, 130, 220, 30);

        JLabel contactLbl = new JLabel("Contact No.: ");
        contactLbl.setBounds(60, 170, 120, 30);
        JLabel contactValue = new JLabel(Number);
        contactValue.setBounds(135, 170, 120, 30);
        
        JLabel addressLbl = new JLabel("Customer Address: ");
        addressLbl.setBounds(60, 200, 120, 30);
        JLabel addressValue =  new JLabel(Address);
        addressValue.setBounds(115, 200, 300, 30);
        
        JLabel crlLabel = new JLabel("Car in Rent: ");
        crlLabel.setBounds(60, 230, 120, 30);
        JLabel crlValue =  new JLabel(CarInRent);
        crlValue.setBounds(115, 230, 300, 30);
        
        JLabel carInfoLbl = new JLabel("Car Information");
        carInfoLbl.setBounds(130, 260, 200, 30);
        
        JLabel brandLbl = new JLabel("Car Brand: ");
        brandLbl.setBounds(60, 290, 120, 30);
        JLabel brandValue =  new JLabel(Brand);
        brandValue.setBounds(115, 290, 120, 30);
        
        JLabel transmissionLbl = new JLabel("Car Model: ");
        transmissionLbl.setBounds(60, 320, 120, 30);
        JLabel transmissionValue =  new JLabel(model);
        transmissionValue.setBounds(115, 320, 150, 30);
        
        JLabel modelLbl = new JLabel("Transmission: ");
        modelLbl.setBounds(60, 350, 120, 30);
        JLabel modelValue =  new JLabel(transmission);
        modelValue.setBounds(115, 350, 150, 30);
        
        JLabel catLabel = new JLabel("Category: ");
        catLabel.setBounds(60, 380, 120, 30);
        JLabel catValue =  new JLabel(category);
        catValue.setBounds(115, 380, 150, 30);
        
        okButton = new JButton("OK");
        okButton.setBounds(230, 420, 50, 30);
        
        add(titleLbl);
        
        add(nameLbl);  
        add(customerInfoLbl);
        add(nameValue);       
        add(ageLbl);        
        add(ageValue);
        add(emailLbl);        
        add(emailValue);       
        add(contactLbl);        
        add(contactValue);        
        add(addressLbl);  
        add(addressValue);
        add(crlLabel);
        add(crlValue);
        add(carInfoLbl);
        add(brandLbl);
        add(brandValue);
        add(transmissionLbl);
        add(transmissionValue);
        add(modelLbl);
        add(modelValue);
        add(catLabel);
        add(catValue);
               
        add(okButton);
       
        
    
    okButton.addActionListener(this);

            }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
   
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carrentalsystem;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RentACar extends JFrame implements ActionListener{
    
    private JButton refreshButton, rentButton;
    private JTextField modelTextField, usernameTextField;
    private JPasswordField confirmPasswordTextField;
    RentACar()
    {
        setTitle("Rent a Car");
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
        
        JLabel titleLbl = new JLabel("Rent a Car");
        Font titleFont = new Font("Arial", Font.BOLD | Font.BOLD, 30);
        titleLbl.setBounds(20,15,200,30);
        titleLbl.setFont(titleFont);
        add(titleLbl);
        
        JLabel filterLbl = new JLabel("Filter:");
        Font filterFont = new Font("Arial", Font.BOLD | Font.BOLD, 20);
        filterLbl.setFont(filterFont);
        filterLbl.setBounds(20,60,100,30);
        add(filterLbl);
        
        JLabel brdLbl = new JLabel("BRAND");
        Font brdFont = brdLbl.getFont();
        Font brdNewFont = brdFont.deriveFont (30);
        brdLbl.setFont(brdNewFont);
        brdLbl.setBounds(20,90,100,30);
        add(brdLbl);
        String[] brandOptions = {"Option 1", "Option 2", "Option 3"};
        JComboBox<String> dropdownBrand = new JComboBox<>(brandOptions);
        dropdownBrand.setBounds(20, 115, 150, 35);
        add(dropdownBrand);
    
        
        JLabel transLbl = new JLabel("TRANSMISSION");
        Font transFont = transLbl.getFont();
        Font transNewFont = transFont.deriveFont (30);
        transLbl.setFont(transNewFont);
        transLbl.setBounds(20,150,100,30);
        add(transLbl);
        String[] transOptions = {"Option 1", "Option 2", "Option 3"};
        JComboBox<String> dropdownTrans = new JComboBox<>(transOptions);
        dropdownTrans.setBounds(20, 175, 150, 35);
        add(dropdownTrans);
        
        JLabel availLbl = new JLabel("AVAILABLE");
        Font availFont = availLbl.getFont();
        Font availNewFont = availFont.deriveFont (30);
        availLbl.setFont(availNewFont);
        availLbl.setBounds(20,210,100,30);
        add(availLbl);
        String[] availOptions = {"Option 1", "Option 2", "Option 3"};
        JComboBox<String> dropdownAvail = new JComboBox<>(availOptions);
        dropdownAvail.setBounds(20, 235, 150, 35);
        add(dropdownAvail);
        
        refreshButton = new JButton("REFRESH");
        refreshButton.setBounds(40, 280, 100, 30);
        add(refreshButton);
        refreshButton.addActionListener(this);
        
        JLabel modelLbl = new JLabel("ENTER MODEL");
        Font modelFont = modelLbl.getFont();
        Font modelNewFont = modelFont.deriveFont (30);
        modelLbl.setFont(modelNewFont);
        modelLbl.setBounds(20,320,100,30);
        add(modelLbl);
        modelTextField = new JTextField();
        modelTextField.setBounds(20, 345, 150, 30);
        add(modelTextField);
        
        JLabel usernameLbl = new JLabel("CONFIRM USERNAME");
        Font usernameFont = usernameLbl.getFont();
        Font usernameNewFont = usernameFont.deriveFont (30);
        usernameLbl.setFont(usernameNewFont);
        usernameLbl.setBounds(20,380,150,30);
        add(usernameLbl);
        usernameTextField = new JTextField();
        usernameTextField.setBounds(20, 405, 150, 30);
        add(usernameTextField);
        
        JLabel passwordLbl = new JLabel("CONFIRM PASSWORD");
        Font passwordFont = passwordLbl.getFont();
        Font passwordNewFont = passwordFont.deriveFont (30);
        passwordLbl.setFont(passwordNewFont);
        passwordLbl.setBounds(20,440,150,30);
        add(passwordLbl);
        confirmPasswordTextField = new JPasswordField();
        confirmPasswordTextField.setBounds(20, 465, 150, 30);
        add(confirmPasswordTextField);
        
        rentButton = new JButton("RENT");
        rentButton.setBounds(50, 510, 80, 30);
        add(rentButton);
        rentButton.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
                
package com.mycompany.carrentalsystem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class RentInfo extends JFrame
{
    private JButton okButton;
    private UserInfo customer;
    private CarInfo selectedCar;
    
    public void diplayInvoice () {
        setTitle("Invoice");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 320);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel titleLbl = new JLabel("CAR RENTAL INVOICE");
        titleLbl.setBounds(130, 10, 250, 30);
        
        JLabel customerInfoLbl = new JLabel("Customer Information");
        customerInfoLbl.setBounds(130, 35, 60, 30);
        
        JLabel nameLbl = new JLabel("Name: ");
        nameLbl.setBounds(60, 50, 60, 30);
        JLabel nameValue = new JLabel(customer.userName);
        nameValue.setBounds(100, 50, 250, 30);
        
        JLabel ageLbl = new JLabel("Age: ");
        ageLbl.setBounds(60, 80, 30, 30);
        JLabel ageValue = new JLabel(Integer.toString(customer.userAge));
        ageValue.setBounds(95, 80, 100, 30);
        
        JLabel emailLbl = new JLabel("Email: ");
        emailLbl.setBounds(60, 110, 60, 30);
        JLabel emailValue = new JLabel(customer.userEmail);
        emailValue.setBounds(100, 110, 200, 30);

        JLabel contactLbl = new JLabel("Contact No.: ");
        contactLbl.setBounds(60, 140, 150, 30);
        JLabel contactValue = new JLabel(customer.userNumber);
        contactValue.setBounds(135, 140, 150, 30);
        
        JLabel addressLbl = new JLabel("Address: ");
        addressLbl.setBounds(60, 170, 100, 30);
        JLabel addressValue =  new JLabel(customer.userAddress);
        addressValue.setBounds(115, 170, 300, 30);
        
        JLabel carInfoLbl = new JLabel("Car Information");
        carInfoLbl.setBounds(130, 200, 60, 30);
        
        JLabel brandLbl = new JLabel("Brand: ");
        brandLbl.setBounds(60, 200, 100, 30);
        JLabel brandValue =  new JLabel(selectedCar.carBrand);
        brandValue.setBounds(115, 220, 150, 30);
        
        JLabel transmissionLbl = new JLabel("Transmission: ");
        transmissionLbl.setBounds(60, 250, 100, 30);
        JLabel transmissionValue =  new JLabel(selectedCar.carTransmission);
        transmissionValue.setBounds(115, 250, 150, 30);
        
        JLabel modelLbl = new JLabel("Model: ");
        modelLbl.setBounds(60, 250, 100, 30);
        JLabel modelValue =  new JLabel(selectedCar.carModel);
        modelValue.setBounds(115, 250, 150, 30);
        
        okButton = new JButton("OK");
        okButton.setBounds(170, 280, 50, 30);
        
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
        add(carInfoLbl);
        add(brandLbl);
        add(brandValue);
        add(transmissionLbl);
        add(transmissionValue);
        add(modelLbl);
        add(modelValue);
               
        add(okButton);
       
        setVisible(true);
    
    okButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
       System.exit(0);
    }
    });
}
}
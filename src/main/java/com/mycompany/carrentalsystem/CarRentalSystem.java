package com.mycompany.carrentalsystem;

import java.awt.event.*;
import javax.swing.*;

public class CarRentalSystem extends JFrame implements ActionListener
{
    static JFrame CarRentWindow;
    public static void main(String[] args) 
    {
        CarRentWindow = new JFrame("Rent a Car");
        CarRentWindow.setSize(450,350);
        CarRentWindow.show();
        CarRentWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    public void actionPerformed(ActionEvent e)
    {
        
        
    }
    
}

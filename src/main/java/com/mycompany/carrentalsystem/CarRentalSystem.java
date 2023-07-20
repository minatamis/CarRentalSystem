package com.mycompany.carrentalsystem;

import java.awt.*;
import javax.swing.*;

public class CarRentalSystem
{
    
    public static void main(String[] args)
    {

        EventQueue.invokeLater(new Runnable(){
            @Override
            public void run()
            {
                UserLogin loginPag = new UserLogin();
                loginPag.setVisible(true);
                
            }
        });
    }
}

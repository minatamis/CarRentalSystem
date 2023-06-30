package carrentalsystem;

import java.awt.*;

public class CarRentalSystem
{
//    static JFrame carRentWindow;
//    //car info
//    static JComboBox carBrandCombo;
//    static JComboBox carTransmissionCombo;
//    static JComboBox carModelCombo;
//    static JButton checkAvailabilityButton;
    
    public static void main(String[] args)
    {
//        carRentWindow = new JFrame("Rent a Car");
//        try 
//        {
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        }
//        catch (Exception e)
//        {
//            System.err.println(e.getMessage());
//        }
//        
//        //for car rental
//        Label brandLabel = new Label("Brand");
//        carBrandCombo = new JComboBox();
//        carBrandCombo.setPreferredSize(new Dimension(200, 25));
//        Label transmissionLabel = new Label("Transmission Type");
//        carTransmissionCombo = new JComboBox();
//        carTransmissionCombo.setPreferredSize(new Dimension(200, 25));
//        Label modelLabel = new Label("Car Model");
//        carModelCombo = new JComboBox();
//        carModelCombo.setPreferredSize(new Dimension(200, 25));
//        checkAvailabilityButton = new JButton("Check Availability");
//        checkAvailabilityButton.setPreferredSize(new Dimension(300, 25));
//        
//        //panels
//        JPanel carRentalPanel = new JPanel();
//        
//        //add to carRentalPanel
//        carRentalPanel.add(brandLabel);
//        carRentalPanel.add(carBrandCombo);
//        carRentalPanel.add(transmissionLabel);
//        carRentalPanel.add(carTransmissionCombo);
//        carRentalPanel.add(modelLabel);
//        carRentalPanel.add(carModelCombo);
//        carRentalPanel.add(checkAvailabilityButton);
//        
//        //window
//        carRentWindow.add(carRentalPanel);
//        //carRentWindow.add(customerInfoPanel);
//        carRentWindow.setSize(350,350);
//        carRentWindow.show();
//        carRentWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

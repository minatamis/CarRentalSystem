package carrentalsystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class UserInfo extends JFrame
{
    static JButton okButton;
    
    public UserInfo (String userName,int userAge, String userEmail, String userNumber, String userAddress) {
        setTitle("Car Rental System");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 320);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel titleLbl = new JLabel("CUSTOMER INFORMATION");
        titleLbl.setBounds(130, 20, 250, 30);
        
        JLabel nameLbl = new JLabel("Name: ");
        nameLbl.setBounds(60, 50, 60, 30);
        JLabel nameValue = new JLabel(userName);
        nameValue.setBounds(100, 50, 250, 30);
        
        JLabel ageLbl = new JLabel("Age: ");
        ageLbl.setBounds(60, 80, 30, 30);
        JLabel ageValue = new JLabel(Integer.toString(userAge));
        ageValue.setBounds(95, 80, 100, 30);
        
        JLabel emailLbl = new JLabel("Email: ");
        emailLbl.setBounds(60, 110, 60, 30);
        JLabel emailValue = new JLabel(userEmail);
        emailValue.setBounds(100, 110, 200, 30);

        
        JLabel contactLbl = new JLabel("Contact No.: ");
        contactLbl.setBounds(60, 140, 150, 30);
        JLabel contactValue = new JLabel(userNumber);
        contactValue.setBounds(135, 140, 150, 30);
        
        JLabel addressLbl = new JLabel("Address: ");
        addressLbl.setBounds(60, 170, 100, 30);
        JLabel addressValue =  new JLabel(userAddress);
        addressValue.setBounds(115, 170, 300, 30);
        
        JLabel successLbl = new JLabel("SUCCESSFULLY SUBMITTED!!");
        successLbl.setBounds(125, 195, 250, 30);
        
        okButton = new JButton("OK");
        okButton.setBounds(170, 230, 50, 30);
        
        add(titleLbl);
        add(nameLbl);        
        add(nameValue);       
        add(ageLbl);        
        add(ageValue);
        add(emailLbl);        
        add(emailValue);       
        add(contactLbl);        
        add(contactValue);        
        add(addressLbl);        
        add(addressValue);
        add(successLbl);
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

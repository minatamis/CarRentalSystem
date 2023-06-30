package carrentalsystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UserRegistration extends JFrame implements ActionListener
{
    static JFrame userRegistrationWindow;
    static JTextField userNameTextField, userAgeTextField, userEmailTextField, userNumberTextField, userAddressTextField, clientUsernameTextField;
    static JPasswordField clientPasswordTextField;
    static JButton submitInfoButton;
    
    UserRegistration()
    {
        userRegistrationWindow = new JFrame("Register");
        try 
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
        
        Label nameLabel = new Label("Name:");
        userNameTextField = new JTextField(30);
        Label ageLabel = new Label("Age:");
        userAgeTextField = new JTextField(30);
        Label emailLabel = new Label("Email:");
        userEmailTextField = new JTextField(30);
        Label numberLabel = new Label("Mobile:");
        userNumberTextField = new JTextField(30);
        Label adddressLabel = new Label("Adddress:");
        userAddressTextField = new JTextField(30);
        Label clientUsernameLabel = new Label("Username :");
        clientUsernameTextField = new JTextField(20);
        Label clientPasswordLabel = new Label("Password:");
        clientPasswordTextField = new JPasswordField(20);
        submitInfoButton = new JButton("Submit");
        submitInfoButton.setPreferredSize(new Dimension(100, 25));
        
        JPanel userRegistrationPanel = new JPanel();
        
        //add to customerInfoPanel (experiment only)
        userRegistrationPanel.add(nameLabel);
        userRegistrationPanel.add(userNameTextField);
        userRegistrationPanel.add(ageLabel);
        userRegistrationPanel.add(userAgeTextField);
        userRegistrationPanel.add(emailLabel);
        userRegistrationPanel.add(userEmailTextField);
        userRegistrationPanel.add(numberLabel);
        userRegistrationPanel.add(userNumberTextField);
        userRegistrationPanel.add(adddressLabel);
        userRegistrationPanel.add(userAddressTextField);
        userRegistrationPanel.add(clientUsernameLabel);
        userRegistrationPanel.add(clientUsernameTextField);
        userRegistrationPanel.add(clientPasswordLabel);
        userRegistrationPanel.add(clientPasswordTextField);
        userRegistrationPanel.add(submitInfoButton);
        
        //window
        userRegistrationWindow.add(userRegistrationPanel);
        userRegistrationWindow.setSize(350,350);
        userRegistrationWindow.setVisible(true);
        userRegistrationWindow.setLocationRelativeTo(null);
        userRegistrationWindow.setResizable(false);
        userRegistrationWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        
        
    }
    
}

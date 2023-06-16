package carrentalsystem;
import java.awt.*;
import javax.swing.*;


public class UserLogin //extends JFrame
{
    static JFrame userLoginWindow;
    static JTextField clientUsernameTextField;
    static JPasswordField clientPasswordTextField;
    static JButton logInButton;
    static JButton registerButton;
    
    public UserLogin()
    {
        userLoginWindow = new JFrame("Log In");
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
        Label clientPasswordLabel = new Label("Password:");
        clientPasswordTextField = new JPasswordField(20);
        logInButton = new JButton("Log In");
        logInButton.setPreferredSize(new Dimension(100, 25));
        registerButton = new JButton("Register");
        registerButton.setPreferredSize(new Dimension(100, 25));
        
        //panel
        JPanel userLogInPanel = new JPanel();
        
        userLogInPanel.add(clientUsernameLabel);
        userLogInPanel.add(clientUsernameTextField);
        userLogInPanel.add(clientPasswordLabel);
        userLogInPanel.add(clientPasswordTextField);
        userLogInPanel.add(logInButton);
        userLogInPanel.add(registerButton);
        
        //window
        userLoginWindow.add(userLogInPanel);
        userLoginWindow.setSize(300,150);
        userLoginWindow.show();
        userLoginWindow.setLocationRelativeTo(null);
        userLoginWindow.setResizable(false);
        userLoginWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

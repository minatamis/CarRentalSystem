package com.mycompany.carrentalsystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class RentACar extends JFrame implements ActionListener
{
    
    private JButton refreshButton, rentButton, btnNewButton;
    private JTextField modelTextField, usernameTextField;
    private JPasswordField confirmPasswordTextField;
    private JComboBox<String> dropdownBrand,dropdownTrans,dropdownAvail;
    private JTable carTable;
    private DefaultTableModel tableModel;
    private Connection connection;
    private String car, username, password;

    RentACar() throws SQLException
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
        String[] brandOptions = {
            "All", 
            "Audi",
            "Bentley",
            "BMW",
            "Chevrolet",
            "Dodge",
            "Ford",
            "Honda",
            "Isuzu",
            "Jaguar",
            "Jeep",
            "Land Rover",
            "Mazda",
            "Mercedes-Benz",
            "Mitsubishi",
            "Nissan",
            "Rolls Royce",
            "Suzuki",
            "Tesla",
            "Toyota",
            "Volkswagen",
            "Volvo"
        };
        dropdownBrand = new JComboBox<>(brandOptions);
        dropdownBrand.setBounds(20, 115, 150, 35);
        add(dropdownBrand);
    
        
        JLabel transLbl = new JLabel("TRANSMISSION");
        Font transFont = transLbl.getFont();
        Font transNewFont = transFont.deriveFont (30);
        transLbl.setFont(transNewFont);
        transLbl.setBounds(20,150,100,30);
        add(transLbl);
        String[] transOptions = {"All", "Automatic", "Manual"};
        dropdownTrans = new JComboBox<>(transOptions);
        dropdownTrans.setBounds(20, 175, 150, 35);
        add(dropdownTrans);
        
        JLabel availLbl = new JLabel("AVAILABILITY");
        Font availFont = availLbl.getFont();
        Font availNewFont = availFont.deriveFont (30);
        availLbl.setFont(availNewFont);
        availLbl.setBounds(20,210,100,30);
        add(availLbl);
        String[] availOptions = {"All", "Available", "Unavailable"};
        dropdownAvail = new JComboBox<>(availOptions);
        dropdownAvail.setBounds(20, 235, 150, 35);
        add(dropdownAvail);
        
        refreshButton = new JButton("APPLY FILTER");
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
        
        Connection initialconnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/carrentalsystem","root", "Jem4764?");


        String query = "SELECT * FROM car";
        Statement statement = initialconnection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Brand");
        tableModel.addColumn("Model");
        tableModel.addColumn("Transmission");
        tableModel.addColumn("Category");
        tableModel.addColumn("Availability");

        while (resultSet.next()) 
        {
            String Brand = resultSet.getString("Brand"); 
            String Model = resultSet.getString("Model"); 
            String Transmission = resultSet.getString("Transmission"); 
            String Category = resultSet.getString("Category"); 
            String Availability = resultSet.getString("Availability"); 

            tableModel.addRow(new Object[] { Brand, Model, Transmission, Category, Availability});
        }

        resultSet.close();
        statement.close();
        
        carTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(carTable);
        scrollPane.setBounds(200, 10, 670, 540);
        add(scrollPane);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        username = usernameTextField.getText();
        password = confirmPasswordTextField.getText();
        car = modelTextField.getText();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/carrentalsystem", "root", "Jem4764?");
            connection.setAutoCommit(false);

            if (e.getSource() == refreshButton) {
                applyFilter();
            } 
            else if (e.getSource() == rentButton) {
                if (updateUserTable(connection, username, password, car)) {
                    updateCarTable(connection, car);
                    connection.commit();

                    String query = "SELECT * FROM userinfo WHERE userEmail=?";
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setString(1, username);

                    String quer = "SELECT * FROM car WHERE Model=?";
                    PreparedStatement prepStatement = connection.prepareStatement(quer);
                    prepStatement.setString(1, car);

                    ResultSet userResult = preparedStatement.executeQuery();
                    ResultSet carResult = prepStatement.executeQuery();

                    if (userResult.next() && carResult.next()) {
                        String UserName = userResult.getString("userName");
                        String Age = userResult.getString("userAge");
                        String email = userResult.getString("userEmail");
                        String Number = userResult.getString("userNumber");
                        String Address = userResult.getString("userAddress");
                        String Brand = carResult.getString("Brand");
                        String Model = carResult.getString("Model");
                        String Transmission = carResult.getString("Transmission");
                        String Category = carResult.getString("Category");

                        String invoiceMessage = "CAR RENTAL INVOICE\n\n" +
                            "Customer Information:\n" +
                            "Customer Name: " + UserName + "\n" +
                            "Customer Age: " + Age + "\n" +
                            "Customer Email: " + email + "\n" +
                            "Contact No.: " + Number + "\n" +
                            "Customer Address: " + Address + "\n" +
                            "Car Information:\n" +
                            "Car Brand: " + Brand + "\n" +
                            "Car Model: " + Model + "\n" +
                            "Transmission: " + Transmission + "\n" +
                            "Category: " + Category;

                    
                    JOptionPane.showMessageDialog(btnNewButton, invoiceMessage);
                    applyFilter();

                    } else {
                        connection.rollback();
                        JOptionPane.showMessageDialog(btnNewButton, "Error: Unable to Rent");
                    }

                    applyFilter();
                } else {
                    connection.rollback();
                    JOptionPane.showMessageDialog(btnNewButton, "Error: Unable to Rent");
                }
            }
            connection.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException rollbackException) {
                rollbackException.printStackTrace();
            }
        }
    }
    
    public void applyFilter() throws SQLException 
    {
        String selectedBrand = (String) dropdownBrand.getSelectedItem();
        String selectedTransmission = (String) dropdownTrans.getSelectedItem();
        String selectedAvailability = (String) dropdownAvail.getSelectedItem();

        String query = "SELECT * FROM car WHERE (Brand = ? OR ? = 'All') AND (Transmission = ? OR ? = 'All') AND (Availability = ? OR ? = 'All')";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, selectedBrand);
        preparedStatement.setString(2, selectedBrand);
        preparedStatement.setString(3, selectedTransmission);
        preparedStatement.setString(4, selectedTransmission);
        preparedStatement.setString(5, selectedAvailability);
        preparedStatement.setString(6, selectedAvailability);

        ResultSet resultSet = preparedStatement.executeQuery();

        DefaultTableModel filteredTableModel = new DefaultTableModel();
        filteredTableModel.addColumn("Brand");
        filteredTableModel.addColumn("Model");
        filteredTableModel.addColumn("Transmission");
        filteredTableModel.addColumn("Category");
        filteredTableModel.addColumn("Availability");

        while (resultSet.next()) {
            String Brand = resultSet.getString("Brand");
            String Model = resultSet.getString("Model");
            String Transmission = resultSet.getString("Transmission");
            String Category = resultSet.getString("Category");
            String Availability = resultSet.getString("Availability");

            filteredTableModel.addRow(new Object[]{Brand, Model, Transmission, Category, Availability});
        }

        resultSet.close();
        preparedStatement.close();
        carTable.setModel(filteredTableModel);
    }
    public boolean updateUserTable(Connection connection, String email, String pass, String car) throws SQLException {
        String userSt = "UPDATE userinfo SET carInRent=? WHERE userEmail=? and userPassword=?";
        try (PreparedStatement userPrepStatement = connection.prepareStatement(userSt)) {
            userPrepStatement.setString(1, car);
            userPrepStatement.setString(2, email);
            userPrepStatement.setString(3, pass);

            int rowsAffected = userPrepStatement.executeUpdate();
            return rowsAffected > 0;
        }
    }

    public void updateCarTable(Connection connection, String model) throws SQLException {
        String carSt = "UPDATE car SET Availability=? WHERE Model=?";
        try (PreparedStatement carPrepStatement = connection.prepareStatement(carSt)) {
            carPrepStatement.setString(1, "Unavailable");
            carPrepStatement.setString(2, model);

            int rowsAffected = carPrepStatement.executeUpdate();
            if (rowsAffected <= 0) {
                JOptionPane.showMessageDialog(btnNewButton, "The Car is Unavailable");
            }
        }
    }
}
package bank_management_system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class BalanceEquiry extends JFrame implements ActionListener {

    String pinNumber, mobileNumber;
    JButton back;

    public BalanceEquiry(String pinNumber, String mobileNumber) {
        setTitle("BALANCE EQUIRY PAGE");
        this.pinNumber = pinNumber;
        this.mobileNumber = mobileNumber;
        setLayout(null);
        ImageIcon im1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image im2 = im1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon im3 = new ImageIcon(im2);
        JLabel image = new JLabel(im3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        back = new JButton("Back");
        back.setBounds(355, 510, 150, 30);
        back.addActionListener(this);
        image.add(back);

        DataBaseConnection conn = new DataBaseConnection();
        String currBalance = "";
        try {

            String query2 = "SELECT * FROM Account WHERE mobileNumber = '" + mobileNumber + "'";
            ResultSet result = conn.s.executeQuery(query2);
            result.next();
            String accountNumber = result.getString("accountNumber");

//            String query = "SELECT GetAccountBalance('" + accountNumber + "') AS balance";
//            ResultSet balanceResult = conn.s.executeQuery(query);
//            balanceResult.next();
//            currBalance = balanceResult.getString("balance");

            query2 = "select * from Balance where accountNumber = '" + accountNumber + "'";
            ResultSet result1 = conn.s.executeQuery(query2);
            result1.next();
            currBalance = result1.getString("balance");
        } catch (Exception e) {
            System.out.println(e);
        }

        JLabel balance = new JLabel("Your Account Balance: Rs. " + currBalance);
        balance.setForeground(Color.WHITE);
        balance.setFont(new Font("Raleway", Font.BOLD, 16));
        balance.setBounds(200, 350, 500, 35);
        image.add(balance);

        setSize(900, 900);
        setLocation(350, 0);
//         setUndecorated(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEquiry("", "");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Transactions(pinNumber, mobileNumber).setVisible(true);
    }
}

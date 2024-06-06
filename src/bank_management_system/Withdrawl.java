package bank_management_system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;
import java.sql.*;

public class Withdrawl extends JFrame implements ActionListener {

    JButton back, withdrawl;
    JTextField amount;
    String pinNumber;
    String mobileNumber;

    public Withdrawl(String pinNumber, String mobileNumber) {
        setTitle("CASH WITHDRAWL PAGE");
        setLayout(null);
        this.pinNumber = pinNumber;
        this.mobileNumber = mobileNumber;
        ImageIcon im1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image im2 = im1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon im3 = new ImageIcon(im2);
        JLabel image = new JLabel(im3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Enter The Amount :");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(170, 300, 400, 20);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 25));
        amount.setBounds(170, 350, 320, 25);
        image.add(amount);

        withdrawl = new JButton("Withdrawl");
        withdrawl.setBounds(355, 480, 150, 30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        back = new JButton("Back");
        back.setBounds(170, 480, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(350, 0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == withdrawl) {
            String withdrawlAmount = this.amount.getText();
            Date date = new Date();
            String type = "Debited";
            if (withdrawlAmount.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please Enter Amount");
            } else {

                try {
                    DataBaseConnection conn = new DataBaseConnection();
                    String query2 = "select * from Account where mobileNumber = '" + mobileNumber + "'";
                    ResultSet result = conn.s.executeQuery(query2);
                    result.next();
                    String accountNumber = result.getString("accountNumber");
                    query2 = "select * from Balance where accountNumber = '" + accountNumber + "'";
                    ResultSet result1 = conn.s.executeQuery(query2);
                    result1.next();
                    String currBalance = result1.getString("balance");
                    String finalBalance = (Double.parseDouble(currBalance) - Double.parseDouble(withdrawlAmount)) + "";
                   

                   
                    if (ae.getSource() != back && Double.parseDouble(currBalance) < Double.parseDouble(withdrawlAmount)) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        setVisible(false);
                        new Login().setVisible(true);
                    } else {
                        
                        finalBalance = (Double.parseDouble(currBalance) - Double.parseDouble(withdrawlAmount)) + "";
                        String query3 = "update Balance set balance = '" + finalBalance + "'where accountNumber = '" + accountNumber + "'";
                        conn.s.executeLargeUpdate(query3);
                        String query = "insert into Transaction values('" + mobileNumber + "','" + date + "','" + type + "','" + withdrawlAmount + "')";
                        conn.s.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "Rs " + withdrawlAmount + " Withdrawl SuccessFully.");
                        setVisible(false);
                        new Transactions(pinNumber, mobileNumber).setVisible(true);
                    }

                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinNumber, mobileNumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Withdrawl("", "");
    }
}

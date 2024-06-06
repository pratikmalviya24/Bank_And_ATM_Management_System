package bank_management_system;

import java.awt.Color;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

import java.sql.*;

public class OTPGenerate extends JFrame implements ActionListener {

    JButton submit;
    JTextField enterOTP;
    String mobileNumber, pinNumber;
    String OTP;

    public OTPGenerate(String mobileNumber, String pinNumber) {
        this.mobileNumber = mobileNumber;
        this.pinNumber = pinNumber;
        setTitle("OTP Page");
        setLayout(null);

        JLabel message = new JLabel("VERIFICATION CODE");
        message.setFont(new Font("Raleway", Font.BOLD, 22));
        message.setBounds(80, 30, 400, 30);
        add(message);

        JLabel sms = new JLabel("Please Check Your MailID For The Code!");
        sms.setFont(new Font("Raleway", Font.BOLD, 14));
        sms.setBounds(50, 100, 400, 30);
        add(sms);

        JLabel otp = new JLabel("Enter OTP : ");
        otp.setFont(new Font("Raleway", Font.BOLD, 20));
        otp.setBounds(40, 170, 200, 30);
        add(otp);
        enterOTP = new JTextField();
        enterOTP.setBounds(170, 170, 200, 30);
        enterOTP.setFont(new Font("Arial", Font.BOLD, 14));
        add(enterOTP);

        submit = new JButton("SUBMIT");
        submit.setBounds(270, 260, 90, 50);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        add(submit);
        submit.addActionListener(this);

        getContentPane().setBackground(Color.GRAY);
        setSize(400, 400);
        setLocation(350, 10);
        setVisible(true);
        OTP = sendOTP();
    }

    public static void main(String[] args) {
        new OTPGenerate("", "");
    }

    private String sendOTP() {
        String OTP = "";
        try {
            String query = "select * from CustomerDetails where mobile_number = '" + mobileNumber + "'";
            DataBaseConnection connection = new DataBaseConnection();
            ResultSet result = connection.s.executeQuery(query);
            if (result.next()) {
                String userEmailId = result.getString("email").toLowerCase();
                System.out.println(userEmailId);
                Random rand = new Random();
                final int MIN_VALUE = 100000;
                final int MAX_VALUE = 999999;
                OTP = (rand.nextInt((MAX_VALUE - MIN_VALUE) + MIN_VALUE)) + "";
                String message = "Your OTP is " + OTP;
                new OTP(message, userEmailId);

            } else {
                JOptionPane.showMessageDialog(null, "Something went Wrong! Please try later...");
            }

        } catch (Exception ex) {
            System.out.println(ex);;
        }

        return OTP;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String otpNumber = enterOTP.getText();
        if (OTP.equals(otpNumber)) {
            setVisible(false);
            new PinChange(pinNumber, mobileNumber).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Your Have Enter Wrong OTP");
            setVisible(false);
            new Login().setVisible(true);
        }
    }

}

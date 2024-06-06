
package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener{
    JButton login,signUp,clear;
    JTextField cardTextField;
    JPasswordField pinPasswordField;
    Login(){
        // Title of the Frame Window:
        setTitle("AUTOMATED TELLER MACHINE");
        
        setLayout(null);
        // Image related code:
        ImageIcon image1=  new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image image2 = image1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2);
        JLabel label = new JLabel(image3);
        
        // Fixing the location of the image
        label.setBounds(70,10,100,100);
        add(label);
 
        JLabel text  = new JLabel("WELCOME TO ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);
        
        // Card_Number_Label
        JLabel card  = new JLabel("CARD NO : ");
        card.setFont(new Font("Raleway",Font.BOLD,28));
        card.setBounds(120,150,400,30);
        add(card);
        
        // BOX
        cardTextField  = new JTextField("");
        cardTextField.setBounds(300,150,230,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);
        
        // Pin_Number_Label:
        JLabel pin  = new JLabel("PIN :");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120,220,250,30);
        add(pin);
        
        pinPasswordField  = new JPasswordField();
        pinPasswordField.setBounds(300,220,230,30);
        pinPasswordField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinPasswordField);
        
        // Buttons:
        login = new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        add(login);
        login.addActionListener(this);
        
        clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        add(clear);
        clear.addActionListener(this);
        
        
        // Background-Color
        getContentPane().setBackground(Color.GRAY);
         
        
        
        // Frame related code;
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }
    
    
    @Override
    public void  actionPerformed(ActionEvent ae){
        if(ae.getSource()== clear){
            cardTextField.setText("");
            pinPasswordField.setText("");
        }
        else if(ae.getSource()==login){
            DataBaseConnection conn = new DataBaseConnection();
            String cardNumber = cardTextField.getText();
            String pinNumber = pinPasswordField.getText();
            ValidationCheck valid = new ValidationCheck();
            if(valid.isValidCARDNumber(cardNumber) && valid.isValidPin(pinNumber)){
                String query = "select * from Card where cardNumber = '"+ cardNumber+  "'  and pinNumber = '" +pinNumber + "'";
                try {
                    ResultSet result = conn.s.executeQuery(query);
                
                    if(result.next()){
                        String mobileNumber = result.getString("mobileNumber");
                        setVisible(false);
//                        new LoadingPage(pinNumber,mobileNumber);

                        new Transactions(pinNumber, mobileNumber).setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Incorrecr CardNumber And Pin");
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"Incorrecr CardNumber And Pin");
            }
            
        }
        else if(ae.getSource()==signUp){
            setVisible(false);
            new SignUp().setVisible(true);
        }
    }
    public static void main(String args[]){
        new Login();
        
    }
}

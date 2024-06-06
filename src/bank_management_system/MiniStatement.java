
package bank_management_system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import java.sql.*;
import javax.swing.JLabel;

public class MiniStatement extends JFrame implements ActionListener{
    
    String pinNumber ,mobileNumber;
    public MiniStatement(String pinNumber,String mobileNumber){
        this.pinNumber = pinNumber;
        this.mobileNumber = mobileNumber;
        setLayout(null);
        setTitle("MINI-STATEMENT");
        
        
        JLabel text = new JLabel();
        add(text);
        
        JLabel bankName = new JLabel("INDIAN BANK");
        bankName.setFont(new Font("Algerian",Font.BOLD,26));
        bankName.setBounds(110,20,250,20);
        add(bankName);
        
        JLabel card = new JLabel();
        card.setBounds(20,80,350,20);
        add(card);
        
        String accountNumber = "";
       
        try {
            DataBaseConnection conn = new DataBaseConnection();
            ResultSet result =  conn.s.executeQuery("select * from Card where mobileNumber = '" + mobileNumber+ "'");
            
            if(result.next()){
                card.setText("Card Number :  XXXX-XXXX-XXXX-" + result.getString("cardNumber").substring(12));
                result =  conn.s.executeQuery("select * from Account where mobileNumber = '" + mobileNumber+ "'");
                result.next();
                accountNumber = result.getString("accountNumber");
            }
        } catch (Exception e) {
            System.out.println(e);
            
        }
        
        
        
        String currBalance = "";
        try {
            DataBaseConnection conn = new DataBaseConnection();
            String query2 = "select * from Balance where accountNumber = '"+accountNumber+"'";
            ResultSet result = conn.s.executeQuery(query2);
            result.next();
            currBalance = result.getString("balance");
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
        JLabel balance = new JLabel("Your Account Balance: Rs. "+currBalance);
        balance.setForeground(Color.BLACK);
        balance.setFont(new Font("Raleeay",Font.BOLD,16));
        balance.setBounds(20,120,350,35);
        add(balance);
        
        
        
        
        try {
            DataBaseConnection conn = new DataBaseConnection();
            ResultSet rs = conn.s.executeQuery("select * from Transaction where mobileNumber = '" + mobileNumber+ "' ORDER BY date DESC LIMIT 5");
            while(rs.next()){
                text.setText(text.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") +"&nbsp;&nbsp;&nbsp;&nbsp;"+ "Rs. "+ rs.getString("amount")+"<br><br><html>");
            } 
        } catch (Exception e) {
            System.out.println(e);
        }
        text.setBounds(20,160,400,200);
        
        
        
       
        
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new MiniStatement("","");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

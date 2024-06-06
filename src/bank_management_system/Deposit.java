
package bank_management_system;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;
import java.sql.*;


public class Deposit extends JFrame implements ActionListener{
    
    JButton back,deposit;
    JTextField amount;
    String pinNumber,mobileNumber;
    boolean flag;
    public Deposit(String pinNumber,boolean flag,String mobileNumber){
        setTitle("Cash Deposit Page");
        setLayout(null);
        this.flag = flag;
        this.pinNumber  = pinNumber;
        this.mobileNumber = mobileNumber;
        ImageIcon im1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image im2 = im1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon im3 = new ImageIcon(im2);
        JLabel image = new JLabel(im3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        
        JLabel text = new JLabel("Enter The Amount :");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(170,300,400,20);
        image.add(text);
        
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,25));
        amount.setBounds(170,350,320,25);
        image.add(amount);
        
        
        deposit = new JButton("Deposit");
        deposit.setBounds(355,480,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        
        back = new JButton("Back");
        back.setBounds(170,480,150,30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(350,0);
        setVisible(true);
    }
    
        
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==deposit){
            String depositAmount = this.amount.getText();
            Date date = new Date();
            String type = "Credited";
            if(depositAmount.isEmpty()){
                JOptionPane.showMessageDialog(null,"Please Enter Amount");
            }
            else{
                
                try {
                    DataBaseConnection conn = new DataBaseConnection();
                    String query = "call AddTransaction('"+mobileNumber+"','"+date+"','"+type+"','"+depositAmount+"');";
                    conn.s.executeUpdate(query);
                    String query2 = "select * from Account where mobileNumber = '"+mobileNumber+"'";
                    ResultSet result = conn.s.executeQuery(query2);
                    result.next();
                    String accountNumber = result.getString("accountNumber");
                    query2 = "select * from Balance where accountNumber = '"+accountNumber+"'";
                    ResultSet result1 = conn.s.executeQuery(query2);
                    result1.next();
                    String currBalance = result1.getString("balance");
                    String finalBalance = (Double.parseDouble(depositAmount) + Double.parseDouble(currBalance))+"";
                    String query3 = "update Balance set balance = '"+finalBalance+"'where accountNumber = '"+accountNumber+"'";
                    conn.s.executeLargeUpdate(query3);
                    JOptionPane.showMessageDialog(null,"Rs "+depositAmount+" Deposited SuccessFully.");
                    setVisible(false);
                    if(flag){
                        new Transactions(pinNumber,mobileNumber).setVisible(true);
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        }
        else if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pinNumber,mobileNumber).setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new Deposit("",false,"");
    }
}

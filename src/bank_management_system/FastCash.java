
package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;
public class FastCash extends JFrame implements ActionListener{

    JButton deposit,cashWithDrawl,fastCash,miniStatement,pinChange,balanceCheck,back;
    String pinNumber,mobileNumber;
    
    
    public FastCash(String pinNumber,String mobileNumber) {
        setTitle("FASTCASH WITHDRAWL PAGE");
        setLayout(null);
        this.pinNumber = pinNumber;
        this.mobileNumber = mobileNumber;
        ImageIcon im1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image im2 = im1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon im3 = new ImageIcon(im2);
        JLabel image = new JLabel(im3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT:");
        text.setBounds(210,280,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        
        deposit = new JButton("RS. 100");
        deposit.setBounds(165,390,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        cashWithDrawl = new JButton("RS. 500");
        cashWithDrawl.setBounds(350,390,150,30);
        cashWithDrawl.addActionListener(this);
        image.add(cashWithDrawl);
        
        fastCash = new JButton("Rs. 1000");
        fastCash.setBounds(165,425,150,30);
        fastCash.addActionListener(this);
        image.add(fastCash);
        
        
        miniStatement = new JButton("RS. 2000");
        miniStatement.setBounds(350,425,150,30);
        miniStatement.addActionListener(this);
        image.add(miniStatement);
        
        
        pinChange = new JButton("RS. 5000");
        pinChange.setBounds(165,460,150,30);
        pinChange.addActionListener(this);
        image.add(pinChange);
        
        balanceCheck = new JButton("Rs. 10000");
        balanceCheck.setBounds(350,460,150,30);
        balanceCheck.addActionListener(this);
        image.add(balanceCheck);
        
        back = new JButton("Back");
        back.setBounds(350,495,150,30);
        back.addActionListener(this);
        image.add(back);
        
        
        setSize(900,900);
        setLocation(350,0);
//         setUndecorated(true);
        setVisible(true);
       
    }
    
    public static void main(String[] args) {
        new FastCash("","");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pinNumber,mobileNumber).setVisible(true);
        }
        else{
            
            String amount = ((JButton)ae.getSource()).getText().substring(4);
            DataBaseConnection conn = new DataBaseConnection();
            try {
                String query2 = "select * from Account where mobileNumber = '" + mobileNumber + "'";
                    ResultSet result = conn.s.executeQuery(query2);
                    result.next();
                    String accountNumber = result.getString("accountNumber");
                    query2 = "select * from Balance where accountNumber = '" + accountNumber + "'";
                    ResultSet result1 = conn.s.executeQuery(query2);
                    result1.next();
                    String currBalance = result1.getString("balance");
                
                if(ae.getSource()!=back && Double.parseDouble(currBalance)<Double.parseDouble(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    setVisible(false);
                    new Login().setVisible(true);
                }
                else{
                    Date date = new Date();
                    String type  = "Debited";
                    String query = "insert into Transaction values('"+ mobileNumber +"','"+date+"','"+type+"','"+amount+"')";
                    conn.s.executeUpdate(query);
                    String finalBalance = (Double.parseDouble(currBalance)-Double.parseDouble(amount))+"";
                    String query3 = "update Balance set balance = '"+finalBalance+"'where accountNumber = '"+accountNumber+"'";
                    conn.s.executeLargeUpdate(query3);
                    JOptionPane.showMessageDialog(null,"Rs. "+amount+" Debited Successfully.");                    
                    setVisible(false);                    
                    new Transactions(pinNumber,mobileNumber).setVisible(true);
                }
                
                
                
                
            } catch (Exception e) {
                System.out.println(e);
            } 
        }
        
    }
}

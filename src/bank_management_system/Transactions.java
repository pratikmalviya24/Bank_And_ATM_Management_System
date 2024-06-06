
package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener{

    JButton deposit,cashWithDrawl,fastCash,miniStatement,pinChange,balanceCheck,exit;
    String pinNumber,mobileNumber;
    
    
    public Transactions(String pinNumber,String mobileNumber) {
//        setLayout(null);
        this.pinNumber = pinNumber;
        this.mobileNumber = mobileNumber;
        
        ImageIcon im1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image im2 = im1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon im3 = new ImageIcon(im2);
        JLabel image = new JLabel(im3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("Please Select Your Transaction");
        text.setBounds(210,260,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        
        deposit = new JButton("Deposit");
        deposit.setBounds(165,390,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        cashWithDrawl = new JButton("Cash Withdrawl");
        cashWithDrawl.setBounds(350,390,150,30);
        cashWithDrawl.addActionListener(this);
        image.add(cashWithDrawl);
        
        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(165,425,150,30);
        fastCash.addActionListener(this);
        image.add(fastCash);
        
        
        miniStatement = new JButton("Mini-Statement");
        miniStatement.setBounds(350,425,150,30);
        miniStatement.addActionListener(this);
        image.add(miniStatement);
        
        
        pinChange = new JButton("Pin Change");
        pinChange.setBounds(165,460,150,30);
        pinChange.addActionListener(this);
        image.add(pinChange);
        
        balanceCheck = new JButton("Balance Enquiry");
        balanceCheck.setBounds(350,460,150,30);
        balanceCheck.addActionListener(this);
        image.add(balanceCheck);
        
        exit = new JButton("Exit");
        exit.setBounds(350,495,150,30);
        exit.addActionListener(this);
        image.add(exit);
        
        
        setSize(900,900);
        setLocation(350,0);
//         setUndecorated(true);
        setVisible(true);
       
    }
    
    public static void main(String[] args) {
        new Transactions("","");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==exit){
            System.exit(0);
        }
        else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinNumber,true,mobileNumber).setVisible(true);
        }
        else if(ae.getSource()==cashWithDrawl){
            setVisible(false);
            new Withdrawl(pinNumber,mobileNumber).setVisible(true);
        }
        else if(ae.getSource()==fastCash){
            setVisible(false);
            new FastCash(pinNumber,mobileNumber).setVisible(true);
        }
        else if(ae.getSource()==pinChange){
            setVisible(false);
//            new PinChange(pinNumber,mobileNumber).setVisible(true);
            new OTPGenerate(mobileNumber, pinNumber).setVisible(true);
             
        }
        else if(ae.getSource()==balanceCheck){
            setVisible(false);
            new BalanceEquiry(pinNumber,mobileNumber).setVisible(true);
        }
        else if(ae.getSource()==miniStatement){
            new MiniStatement(pinNumber,mobileNumber).setVisible(true);
        }
    }
}

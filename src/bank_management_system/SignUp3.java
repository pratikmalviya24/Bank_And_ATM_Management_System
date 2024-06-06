
package bank_management_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SignUp3 extends JFrame implements ActionListener{
     DataBaseConnection conn;
    JRadioButton savingAccount,currentAccount,fixDepositAccount,recurringDepositAccount;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel,back;
    String mobileNumber,cardNumber,pinNumber,accountNumber;
    ArrayList<String> customerDetails;
    public SignUp3(String mobileNumber,ArrayList<String> customerDetails){
        setTitle("Account Details Page");
        this.customerDetails =customerDetails;
        this.mobileNumber = mobileNumber;
        setLayout(null);
        JLabel accountDetails = new JLabel("Page 3: Account Details");
        accountDetails.setFont(new Font("Raleway",Font.BOLD,24));
        accountDetails.setBounds(280, 20, 400, 40);
        add(accountDetails);
        
        JLabel accountType = new JLabel("Account Type:");
        accountType.setFont(new Font("Raleway",Font.BOLD,22));
        accountType.setBounds(100, 100, 200, 30);
        add(accountType);
        
        savingAccount  = new JRadioButton("Saving Account");
        savingAccount.setFont(new Font("Raleway",Font.BOLD,16));
        savingAccount.setBackground(Color.LIGHT_GRAY);
        savingAccount.setBounds(100,150,160,30);
        add(savingAccount);
        
        fixDepositAccount  = new JRadioButton("Fix Deposit Account");
        fixDepositAccount.setFont(new Font("Raleway",Font.BOLD,16));
        fixDepositAccount.setBackground(Color.LIGHT_GRAY);
        fixDepositAccount.setBounds(350,150,250,30);
        add(fixDepositAccount);
        
        
        currentAccount  = new JRadioButton("Current Account");
        currentAccount.setFont(new Font("Raleway",Font.BOLD,16));
        currentAccount.setBackground(Color.LIGHT_GRAY);
        currentAccount.setBounds(100,200,160,30);
        add(currentAccount);
        
        recurringDepositAccount  = new JRadioButton("Recurring Deposit Account");
        recurringDepositAccount.setFont(new Font("Raleway",Font.BOLD,16));
        recurringDepositAccount.setBackground(Color.LIGHT_GRAY);
        recurringDepositAccount.setBounds(350,200,250,30);
        add(recurringDepositAccount);
        
        ButtonGroup groupAccount = new ButtonGroup();
        groupAccount.add(savingAccount);
        groupAccount.add(currentAccount);
        groupAccount.add(fixDepositAccount);
        groupAccount.add(recurringDepositAccount);
        
        
        JLabel accountNumberLabel = new JLabel("Account Number : ");
        accountNumberLabel.setFont(new Font("Raleway",Font.BOLD,22));
        accountNumberLabel.setBounds(100, 250, 280, 30);
        add(accountNumberLabel);
        
        JLabel accountNumberDetail = new JLabel("(Your 14 digit Account number)");
        accountNumberDetail.setFont(new Font("Raleway",Font.BOLD,12));
        accountNumberDetail.setBounds(100, 270, 310, 30);
        add(accountNumberDetail);
        accountNumber = (RandomCARDNumber().substring(0,4) + mobileNumber+"").trim();
        cardNumber = (mobileNumber + RandomCARDNumber().substring(6, 12));
        pinNumber = RandomPinNumber().trim();
        
        JLabel acc_number = new JLabel(accountNumber);
        acc_number.setFont(new Font("Raleway",Font.BOLD,16));
        acc_number.setBounds(320, 250, 250, 30);
        add(acc_number);
        
        JLabel card = new JLabel("Card Number       :");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100, 310, 200, 30);
        add(card);
        
        JLabel cardNumber = new JLabel("XXXX-XXXX-XXXX-"+this.cardNumber.substring(12));
        cardNumber.setFont(new Font("Raleway",Font.BOLD,16));
        cardNumber.setBounds(320, 310, 250, 30);
        add(cardNumber);
        JLabel cardDetail = new JLabel("(Your 16 digit card number)");
        cardDetail.setFont(new Font("Raleway",Font.BOLD,12));
        cardDetail.setBounds(100, 330, 310, 30);
        add(cardDetail);
        
        
        JLabel pin = new JLabel("Pin Number         :");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100, 370, 200, 30);
        add(pin);
        
        JLabel pinNumber = new JLabel("XXXX");
        pinNumber.setFont(new Font("Raleway",Font.BOLD,16));
        pinNumber.setBounds(320, 370, 200, 30);
        add(pinNumber);
        
        JLabel pinDetail = new JLabel("(Your 4 digit pin)");
        pinDetail.setFont(new Font("Raleway",Font.BOLD,12));
        pinDetail.setBounds(100, 390, 310, 30);
        add(pinDetail);
        
        
        JLabel service = new JLabel("Services Required : ");
        service.setFont(new Font("Raleway",Font.BOLD,22));
        service.setBounds(100, 440, 310, 30);
        add(service);
        
        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.LIGHT_GRAY);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,500,200,30);
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.LIGHT_GRAY);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350,500,200,30);
        add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.LIGHT_GRAY);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,550,200,30);
        add(c3);
        
        c4 = new JCheckBox("Email & SMS Alerts");
        c4.setBackground(Color.LIGHT_GRAY);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350,550,200,30);
        add(c4);
        
        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.LIGHT_GRAY);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,600,200,30);
        add(c5);
        
        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.LIGHT_GRAY);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350,600,200,30);
        add(c6);
        
        c7 = new JCheckBox("I hereby declare that the above entered information are correct.(Terms & Conditions)");
        c7.setBackground(Color.LIGHT_GRAY);
        c7.setFont(new Font("Raleway",Font.BOLD,16));
        c7.setBounds(100,660,680,30);
        add(c7);
        
        
        
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(450,720,100,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(220,720,100,30);
        cancel.addActionListener(this);
        add(cancel);

        
        getContentPane().setBackground(Color.lightGray);
        setSize(850,850);
        setLocation(350,0);
        setVisible(true);
    }
    public String RandomCARDNumber(){
        Random random = new Random();
        return Math.abs((random.nextLong()%90000000) + 5040936000000000L) + "";
    }
    public String RandomPinNumber(){
        Random random = new Random();
        return Math.abs((random.nextLong()%9000L) + 1000L) + "";
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==submit){
            String accountType = null;
            if(savingAccount.isSelected()){
                accountType = "Saving";
            }
            else if(currentAccount.isSelected()){
                accountType = "Current";
            }
            else if(fixDepositAccount.isSelected()){
                accountType = "Fix Deposit";
            }
            else if(recurringDepositAccount.isSelected()){
                accountType = "Recurring Deposit";
            }
            
            
            String services = "";
            if(c1.isSelected()){
                services = services + "ATM CARD/";
            }
            if(c2.isSelected()){
                services = services + "Internet Banking/";
            }
            if(c3.isSelected()){
                services = services + "Mobile Banking/";
            }
            if(c4.isSelected()){
                services = services + "Email-SMS Alerts/";
            }
            if(c5.isSelected()){
                services = services + "Cheque Book/";
            }
            if(c6.isSelected()){
                services = services + "E-Statement/";
            }
            
            services = services.substring(0,services.length()-1);
            
            try {
                if(accountType.isEmpty() || !c7.isEnabled()){
                    JOptionPane.showMessageDialog(null,"Please Enter Required Field!");
                }
                else if(!c7.isSelected()){
                    JOptionPane.showMessageDialog(null, "Please accept the Terms and Conditions!");
                }
                else{
                    conn = new DataBaseConnection();
                    
                    // CustomerDetails:
                    String query1 = "insert into CustomerDetails values('"+customerDetails.get(0) + "' , '"+customerDetails.get(1) + "' ,'"+customerDetails.get(2) + "','" +customerDetails.get(3) + "','"+customerDetails.get(4) + "' ,'"+customerDetails.get(5) + "','"+customerDetails.get(6) + "','"+customerDetails.get(7) + "','"+customerDetails.get(8) + "','"+customerDetails.get(9) + "','"+customerDetails.get(10) + "','"+customerDetails.get(11) + "','"+customerDetails.get(12) + "')" ;
                    conn.s.executeUpdate(query1);
                    
                    // Personal Details:
                    String query = "insert into PersonalDetails values('"+ customerDetails.get(15) + "','"+ customerDetails.get(16) + "','"+customerDetails.get(17) + "','"+customerDetails.get(18) + "','"+customerDetails.get(19) + "','"+customerDetails.get(20) + "','"+ customerDetails.get(21)+ "','"+customerDetails.get(22) + "','"+customerDetails.get(23) + "','"+customerDetails.get(24) + "')" ;
                    conn.s.executeUpdate(query);
                    
                    query1 = "insert into Account values('"+ mobileNumber + "','"+ accountType.toUpperCase() + "','"+ accountNumber+ "','"+ cardNumber + "','"+ pinNumber + "','"+ services + "')" ;
                    String query2 = "insert into Card values('"+ mobileNumber + "','"+ cardNumber + "','"+ pinNumber + "')" ;
                    conn.s.execute(query1);
                    conn.s.execute(query2);
                     query2 = "insert into Balance values('"+accountNumber+"','"+customerDetails.get(14)+"')";
                    conn.s.executeUpdate(query2);

                    String message = "Your Account Number :  " + accountNumber+"\n" + "Card Number : " +cardNumber+"\n" + "Pin Number : "+pinNumber;
                    String emailId = customerDetails.get(7);
                    new OTP(message, emailId);
                    JOptionPane.showMessageDialog(null,"Account details have been sent to your registered mail address.");
                    
                    setVisible(false);
                    new depositPage(accountNumber, mobileNumber).setVisible(true);
//                    new Deposit(pinNumber,false,mobileNumber).setVisible(true);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,e);
            } catch (Exception ex) {
                Logger.getLogger(SignUp3.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else if(ae.getSource()==cancel){
            setVisible(false);
            new Main().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new SignUp3("9632587410",new ArrayList<String>());
    }

    
}


package bank_management_system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class PinChange extends JFrame implements ActionListener{
    
    
    JPasswordField pin,repin;
    JButton back,change;
    String oldPinNumber,mobileNumber;
    public PinChange(String pinNumber,String mobileNumber){
        setLayout(null);
        this.oldPinNumber = pinNumber;
        this.mobileNumber = mobileNumber;
        ImageIcon im1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image im2 = im1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon im3 = new ImageIcon(im2);
        JLabel image = new JLabel(im3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(250,280,500,35);
        image.add(text);
        
         JLabel newPinNumber = new JLabel("Enter New PIN      :");
        newPinNumber.setForeground(Color.WHITE);  
        newPinNumber.setFont(new Font("System",Font.BOLD,16));
        newPinNumber.setBounds(165,340,180,25);
        image.add(newPinNumber);
        
        pin = new JPasswordField();
        pin.setFont(new Font("Raleway",Font.BOLD,25));
        pin.setBounds(330,340,180,25);
        image.add(pin);
        
        JLabel renewPinNumber = new JLabel("Re-Enter New PIN :");
        renewPinNumber.setForeground(Color.WHITE);
        renewPinNumber.setFont(new Font("System",Font.BOLD,16));
        renewPinNumber.setBounds(165,400,180,25);
        image.add(renewPinNumber);
        
        repin = new JPasswordField();
        repin.setFont(new Font("Raleway",Font.BOLD,25));
        repin.setBounds(330,400,180,25);
        image.add(repin);
        
        
        change = new JButton("Change");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("Back");
        back.setBounds(170,485,150,30);
        back.addActionListener(this);
        image.add(back);
        
         setSize(900,900);
        setLocation(350,0);
//         setUndecorated(true);
        setVisible(true);
        
    }
    public static void main(String[] args) {
        new PinChange("","");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==change){
            try {
            String newPinNumber = pin.getText();
            String reNewPinNumber = repin.getText();
            if(newPinNumber.equals(reNewPinNumber)){
                if(newPinNumber.isEmpty() || reNewPinNumber.isEmpty()){
                    JOptionPane.showConfirmDialog(null, "Please Enter New PIN Number!");
                    return;
                }
                
                DataBaseConnection conn = new DataBaseConnection();
                String query2 = "update Card set pinNumber = '"+newPinNumber +"' where mobileNumber = '"+mobileNumber+"'";
                String query3 = "update Account set pinNumber = '"+newPinNumber +"' where mobileNumber = '"+mobileNumber+"'";
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null,"Pin Changed Successfully.");
                
                setVisible(false);
                new Transactions(newPinNumber,mobileNumber).setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(null,"Entered PIN does not match!");
                return;
            }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        else if(ae.getSource()==back){
            setVisible(false);
            new Transactions(oldPinNumber,mobileNumber).setVisible(true);
        }
    } 
}

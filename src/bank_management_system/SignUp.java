
package bank_management_system;

import java.awt.*;
import javax.swing.*;
import  java.util.*;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.demo.DateChooserPanel;
import java.awt.event.*;
import java.sql.*;

public class SignUp extends JFrame implements  ActionListener{
    
    long randomNumber;
    JButton clear;
    JTextField nameTextField,fnameTextField,mnameTextField,emailTextField,dobJTextField,addressTextField,cityTextField,stateTextField,pinTextField,phoneNumberTextField;
    JButton next;
    JRadioButton male,female,other,married,unMarried;
    JDateChooser date;
    
    
    public SignUp() {
        setTitle("REGISTRATION FORM");
        setLayout(null);
        
        Random random  = new Random();
        randomNumber = (Math.abs(random.nextLong()%9000L))  + 1000L;
        JLabel formNo = new JLabel("APPLICATION FORM NO. : "+ randomNumber);
        formNo.setFont(new Font("Raleway",Font.BOLD,38));
        formNo.setBounds(140,20,600,40);
        add(formNo);
        
        
        
        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personalDetails.setBounds(290,80,400,30);
        add(personalDetails);
        
        
        // Name-Button
        JLabel name = new JLabel("Name : ");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);
        
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        nameTextField.setBounds(300, 140, 300, 30);
        add(nameTextField);
        
        
        
        JLabel fname = new JLabel("Father's Name : ");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,190,30);
        add(fname);
        
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        fnameTextField.setBounds(300, 190, 300, 30);
        add(fnameTextField);
        
        
        
        JLabel mname = new JLabel("Mother's Name : ");
        mname.setFont(new Font("Raleway",Font.BOLD,20));
        mname.setBounds(100,240,190,30);
        add(mname);
        
        mnameTextField = new JTextField();
        mnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        mnameTextField.setBounds(300, 240, 300, 30);
        add(mnameTextField);
        
        
        
        
        JLabel dob = new JLabel("Date of Birth : ");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,290,200,30);
        add(dob);
        
        date = new JDateChooser();
        date.setBounds(300,290,240,30);
        date.setForeground(Color.BLACK);
        add(date);
        
        
        
        
        
        JLabel gender = new JLabel("Gender : ");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,340,200,30);
        add(gender);
        
        
        male = new JRadioButton("Male");
        male.setBounds(300, 340, 60, 30);
        male.setBackground(Color.ORANGE);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(450, 340, 70, 30);
        female.setBackground(Color.ORANGE);
        add(female);
        
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        
        
        
        
        JLabel emailId = new JLabel("Email-ID : ");
        emailId.setFont(new Font("Raleway",Font.BOLD,20));
        emailId.setBounds(100,390,200,30);
        add(emailId);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
        emailTextField.setBounds(300, 390, 300, 30);
        add(emailTextField);
        
        
        
        
        
        
        
        JLabel mobileNumber = new JLabel("Phone Number : ");
        mobileNumber.setFont(new Font("Raleway",Font.BOLD,20));
        mobileNumber.setBounds(100,440,200,30);
        add(mobileNumber);
        
        phoneNumberTextField = new JTextField();
        phoneNumberTextField.setFont(new Font("Raleway",Font.BOLD,14));
        phoneNumberTextField.setBounds(300, 440, 300, 30);
        add(phoneNumberTextField);
    
        
        
        
        
        
        
        
        
        
        
        JLabel maritalStatus = new JLabel("Marital Status : ");
        maritalStatus.setFont(new Font("Raleway",Font.BOLD,20));
        maritalStatus.setBounds(100,490,200,30);
        add(maritalStatus);
        
        married = new JRadioButton("Married");
        married.setBounds(300, 490, 90, 30);
        married.setBackground(Color.ORANGE);
        add(married);
        
        unMarried = new JRadioButton("Not-Married");
        unMarried.setBounds(450, 490, 100, 30);
        unMarried.setBackground(Color.ORANGE);
        add(unMarried);
        
        other = new JRadioButton("Other");
        other.setBounds(630, 490, 100, 30);
        other.setBackground(Color.ORANGE);
        add(other);
        
        
        ButtonGroup  maritalGroup= new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unMarried);
        maritalGroup.add(other);
        
        
        
        
        
        
        
        JLabel address = new JLabel("Address : ");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,540,200,30);
        add(address);
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,14));
        addressTextField.setBounds(300, 540, 300, 30);
        add(addressTextField);
        

        
        
        
        
        
        JLabel city = new JLabel("City : ");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,590,200,30);
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
        cityTextField.setBounds(300, 590, 300, 30);
        add(cityTextField);
        
        
        
        
        
        
        
        JLabel state = new JLabel("State : ");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,640,200,30);
        add(state);
        
        
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
        stateTextField.setBounds(300, 640, 300, 30);
        add(stateTextField);
        
        
        
        
        
        
        
        JLabel pinCode = new JLabel("PinCode : ");
        pinCode.setFont(new Font("Raleway",Font.BOLD,20));
        pinCode.setBounds(100,690,200,30);
        add(pinCode);
        
        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway",Font.BOLD,14));
        pinTextField.setBounds(300, 690, 300, 30);
        add(pinTextField);
        
        
        
        
        
        
        clear = new JButton("CLEAR");
        clear.setBounds(300, 740, 80, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        add(clear);
        clear.addActionListener(this);
        
        
        
        
        
        
        JButton next  = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(500,740,80,30);
        next.addActionListener(this);
        add(next);
        
        
        
        
        
        
        getContentPane().setBackground(Color.orange);
        setSize(850,830);
        setLocation(350,10);
        setVisible(true);
    }
     @Override
    public void  actionPerformed(ActionEvent ae){
        if(ae.getSource()==clear){
            nameTextField.setText("");
            fnameTextField.setText("");
            emailTextField.setText("");
            dobJTextField.setText("");
            addressTextField.setText("");
            cityTextField.setText("");
            stateTextField.setText("");
            pinTextField.setText("");
            phoneNumberTextField.setText("");
            mnameTextField.setText("");
        }
        String formno = randomNumber+"";
        String name = nameTextField.getText().trim().toUpperCase();
        String fname = fnameTextField.getText().trim().toUpperCase();
        String mname = mnameTextField.getText().trim().toUpperCase();
        String dob = ((JTextField)date.getDateEditor().getUiComponent()).getText();
        String gender = null;
        String mobile_number = phoneNumberTextField.getText();
        if(male.isSelected()){
            gender = "Male";
        }
        else if(female.isSelected()){
            gender = "Female";
        }
        
        String email = emailTextField.getText().trim().toLowerCase();
        String marital =  null;
        if(unMarried.isSelected()){
            marital = "Single";
        }
        else if(married.isSelected()){
            marital = "Married";
        }
        else if(other.isSelected()){
            marital = "Other";
        }
        
        String address = addressTextField.getText().trim().toUpperCase();
        String city = cityTextField.getText().trim().toUpperCase();
        String state = stateTextField.getText().trim().toUpperCase();
        String pinCode = pinTextField.getText().trim().toUpperCase();
        
        ValidationCheck valid = new ValidationCheck();
        if(name.isEmpty() || fname.isEmpty() || dob.isEmpty() || gender.isEmpty() || email.isEmpty() || marital.isEmpty() || address.isEmpty() || city.isEmpty() || state.isEmpty() || pinCode.isEmpty() || mobile_number.isEmpty() || mname.isEmpty()){
            JOptionPane.showMessageDialog(null,"All The Field Are Required To Be FullFilled!");
        }
        else if(!valid.isTextValid(name) || !valid.isTextValid(fname) || !valid.isTextValid(mname)){
             JOptionPane.showMessageDialog(null,"Invalid Name!");
         }
//         else if(!valid.isValidEmailAddress(email)){
//             JOptionPane.showMessageDialog(null,"Invalid Email!");
//         }
         else if(!valid.isValidMobileNumber(mobile_number)){
             JOptionPane.showMessageDialog(null,"Invalid PhoneNumber!");
         }
         else if(!valid.isValidStateOrCity(state)){
             JOptionPane.showMessageDialog(null,"Invalid StateName");
         }
         else if(!valid.isValidStateOrCity(city)){
             JOptionPane.showMessageDialog(null,"Invalid CityName");
         }
         else if(!valid.isValidPinCode(pinCode)){
             JOptionPane.showMessageDialog(null,"Invalid PinCode!");
         }
         else{
             ArrayList<String> signUpDetails = new ArrayList<>();
             String[] temp = {mobile_number,formno,name,fname,mname,dob,gender,email,marital,address,city,state,pinCode,mobile_number,"0"};
             for(String s : temp){
                 signUpDetails.add(s);
             }
        
                  setVisible(false);
                new SignUp2(mobile_number, signUpDetails).setVisible(true);
                
            
//             try {
//                 
//                 
//              DataBaseConnection connection = new DataBaseConnection();
//              String query = "select * from CustomerDetails where mobile_number = '"+mobile_number+"'";
//              ResultSet result = connection.s.executeQuery(query);
//              if(result.next()){
//                  JOptionPane.showMessageDialog(null, "An account already exists with the mobile number you have provided!");
//              }
//              else{
//                   setVisible(false);
//                   new SignUp2(mobile_number, signUpDetails).setVisible(true);
//              }
//                
//            } catch (SQLException e) {
//                System.out.println(e);
//            }         
         }
        
        
        
        
        
    }
    public static void main(String[] args) {
        new SignUp();
    }
}

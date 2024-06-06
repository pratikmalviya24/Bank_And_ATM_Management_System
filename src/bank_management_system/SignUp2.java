
package bank_management_system;

import java.awt.*;
import javax.swing.*;
import  java.util.*;

import java.awt.event.*;

public class SignUp2 extends JFrame implements  ActionListener{
    
    JButton clear;
    JTextField panNumberTextField,aadharNumberTextField;
    JButton next,back;
    JRadioButton yes,no,eyes,eno;
    JComboBox religionBox,categoryBox,incomeBox,educationBox,occupationBox;
    String mobile_number;
    ArrayList<String> signUpDetails;
    public SignUp2(String mobile_number,ArrayList<String> signUpDetails) {
        this.signUpDetails = signUpDetails;
        setTitle("Customer Personal Detail Form");
        setLayout(null);
        this.mobile_number = mobile_number;
        JLabel additionalDetail = new JLabel("Page 2: Additional Details");
        additionalDetail.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetail.setBounds(290,50,400,30);
        add(additionalDetail);
        
        
        JLabel religion = new JLabel("Religion : ");
        religion.setFont(new Font("Raleway",Font.BOLD,20));
        religion.setBounds(100,140,100,30);
        add(religion);
        
        String religionValue[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        religionBox = new JComboBox(religionValue);
        religionBox.setBounds(300, 140, 300, 30);
        religionBox.setBackground(Color.WHITE);
        add(religionBox);
        
        
        
        
        
        
        
        JLabel category = new JLabel("Category : ");
        category.setFont(new Font("Raleway",Font.BOLD,20));
        category.setBounds(100,190,190,30);
        add(category);
        
        String categoryValue[] = {"General","OBC","SC","ST","Other"};
        categoryBox = new JComboBox(categoryValue);
        categoryBox.setBounds(300, 190, 300, 30);
        categoryBox.setBackground(Color.WHITE);
        add(categoryBox);
        
        
        
        
        
        JLabel income = new JLabel("Annual Income : ");
        income.setFont(new Font("Raleway",Font.BOLD,20));
        income.setBounds(100,240,190,30);
        add(income);
        String incomeValue[] = {"<50,000","<1,50,000","3,00,000","6,00,000","upto 10,00,000"};
        incomeBox = new JComboBox(incomeValue);
        incomeBox.setBounds(300, 240, 300, 30);
        incomeBox.setBackground(Color.WHITE);
        add(incomeBox);
        
        
        
        
        
        
        JLabel education = new JLabel("Educational");
        education.setFont(new Font("Raleway",Font.BOLD,20));
        education.setBounds(100,290,200,30);
        add(education);
        JLabel qualification = new JLabel("Qualification : ");
        qualification.setFont(new Font("Raleway",Font.BOLD,20));
        qualification.setBounds(100,320,200,30);
        add(qualification);
        String educationVal[] = {"Non-Graduation","Graducate","Post Graducation","Doctrate","Other"};
        educationBox = new JComboBox(educationVal);
        educationBox.setBounds(300, 320, 300, 30);
        educationBox.setBackground(Color.WHITE);
        add(educationBox);
        
       
        
        
        
        JLabel occupation = new JLabel("Occupation : ");
        occupation.setFont(new Font("Raleway",Font.BOLD,20));
        occupation.setBounds(100,380,200,30);
        add(occupation);
        
        String occupationValue[] = {"Salary","Self-Employee","Bussiness","Student","Retired","Other"};
        occupationBox = new JComboBox(occupationValue);
        occupationBox.setBounds(300, 380, 300, 30);
        occupationBox.setBackground(Color.WHITE);
        add(occupationBox);
        
        
        
        
        
        
        
        JLabel panNumber = new JLabel("PAN Number : ");
        panNumber.setFont(new Font("Raleway",Font.BOLD,20));
        panNumber.setBounds(100,440,200,30);
        add(panNumber);
        
        panNumberTextField = new JTextField();
        panNumberTextField.setFont(new Font("Raleway",Font.BOLD,14));
        panNumberTextField.setBounds(300, 440, 300, 30);
        add(panNumberTextField);
    
        
        
        
     
        JLabel aadharNumber = new JLabel("Aadhar Number : ");
        aadharNumber.setFont(new Font("Raleway",Font.BOLD,20));
        aadharNumber.setBounds(100,490,200,30);
        add(aadharNumber);
        
        aadharNumberTextField = new JTextField();
        aadharNumberTextField.setFont(new Font("Raleway",Font.BOLD,14));
        aadharNumberTextField.setBounds(300, 490, 300, 30);
        add(aadharNumberTextField);
        
        
        
        
        
        
        
        JLabel seniorCitizen = new JLabel("Senior Citizen: ");
        seniorCitizen.setFont(new Font("Raleway",Font.BOLD,20));
        seniorCitizen.setBounds(100,540,200,30);
        add(seniorCitizen);
        
        yes = new JRadioButton("Yes");
        yes.setBounds(300, 540, 100, 30);
        yes.setBackground(Color.WHITE);
        add(yes);
        
        no = new JRadioButton("NO");
        no.setBounds(450, 540, 100, 30);
        no.setBackground(Color.WHITE);
        add(no);
        
        
        ButtonGroup  maritalGroup= new ButtonGroup();
        maritalGroup.add(yes);
        maritalGroup.add(no);

        
        
        
        
        
        JLabel existingAccount = new JLabel("Exisiting Account : ");
        existingAccount.setFont(new Font("Raleway",Font.BOLD,20));
        existingAccount.setBounds(100,590,200,30);
        add(existingAccount);
    
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno = new JRadioButton("NO");
        eno.setBounds(450, 590, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        
        ButtonGroup  emaritalGroup= new ButtonGroup();
        emaritalGroup.add(eyes);
        emaritalGroup.add(eno);
        
        
        
        

        clear = new JButton("CLEAR");
        clear.setBounds(300, 640, 80, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        add(clear);
        clear.addActionListener(this);
        
        
         back = new JButton("BACK");
        back.setBounds(400, 690, 80, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        back.addActionListener(this);
        
        
        
        JButton next  = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(500,640,80,30);
        next.addActionListener(this);
        add(next);
        
        
        
        
        
        
        getContentPane().setBackground(Color.ORANGE);
        setSize(850,830);
        setLocation(350,10);
        setVisible(true);
    }
    
     @Override
    public void  actionPerformed(ActionEvent ae){
        if(ae.getSource()==clear){
            panNumberTextField.setText("");
            aadharNumberTextField.setText("");
            yes.setText("");
            no.setText("");
            eyes.setText("");
            eno.setText("");
        }
        else if(ae.getSource()==back){
            setVisible(false);
            new SignUp().setVisible(true);
        }
        String religion = ((String)religionBox.getSelectedItem()).trim().toUpperCase();
        String category = ((String)categoryBox.getSelectedItem()).trim().toUpperCase();
        String income = ((String)incomeBox.getSelectedItem()).trim().toUpperCase();
        String education = ((String)educationBox.getSelectedItem()).trim().toUpperCase();
        String occupation = ((String)occupationBox.getSelectedItem()).trim().toUpperCase();
        
        
        
        String senionCitizen = null;
        if(yes.isSelected()){
            senionCitizen = "Yes";
        }
        else if(no.isSelected()){
            senionCitizen = "No";
        }
        
        
        String existingAccount = null;
        if(eyes.isSelected()){
            existingAccount = "YES";
        }
        else if(eno.isSelected()){
            existingAccount = "NO";
        }
        
        String panNumber = panNumberTextField.getText().trim().toUpperCase();
        String aadharNumber = aadharNumberTextField.getText().trim().toUpperCase();

        
        ValidationCheck valid = new ValidationCheck();
     
        if(panNumber.isEmpty() || aadharNumber.isEmpty() || senionCitizen.isEmpty() || existingAccount.isEmpty() || panNumber.isEmpty() ||aadharNumber.isEmpty() ){
            JOptionPane.showMessageDialog(null,"All The Field Are Required To Be FullFilled!");
        }
        else if(valid.isValidPanNUmber(panNumber)){
            JOptionPane.showMessageDialog(null,"InValid PanNumber!");
        }
        else if(valid.isValidAadharNumber(aadharNumber)){
            JOptionPane.showMessageDialog(null,"InValid AadharNumber!");
        }
        else{
            String[] temp = {mobile_number,religion,category,income,education,occupation,panNumber,aadharNumber,existingAccount,senionCitizen};
            for(String s : temp){
                signUpDetails.add(s);
            }
            setVisible(false); 
            new SignUp3(mobile_number,signUpDetails).setVisible(true);
//            try {
//             
//                 DataBaseConnection c = new DataBaseConnection();
//                 String query = "insert into PersonalDetails values('"+ mobile_number + "','"+ religion + "','"+category + "','"+income + "','"+education + "','"+occupation + "','"+ panNumber+ "','"+aadharNumber + "','"+existingAccount + "','"+senionCitizen + "')" ;
//                 c.s.executeUpdate(query);
//                 
//                 
//                 
//                 
//            } catch (Exception e) {
//                System.out.println(e);
//            }
        }
    }
    public static void main(String[] args) {
        new SignUp2("",new ArrayList<String>());
    }
}

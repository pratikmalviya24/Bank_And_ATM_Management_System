package bank_management_system;

import java.util.regex.*;
import java.util.*;

public class ValidationCheck {
    Pattern p;
    Matcher m;

    public ValidationCheck() {
        p = Pattern.compile("");
        m = p.matcher("");
    }
    
    public boolean isTextValid(String name){
        p = Pattern.compile("[a-z\\s]+",Pattern.CASE_INSENSITIVE);
        m = p.matcher(name);
        
        if(m.find() && m.group().equals(name)){
            return true;
        }
        
        return  false;
    }
    
    public boolean isValidMobileNumber(String str){
        p = Pattern.compile("(0/91)?[6-9][0-9]{9}");
        m = p.matcher(str);
        
        if(m.find() && m.group().equals(str)){
            return true;
        }
        return  false;
    }
    public boolean isValidCARDNumber(String str){
        return isValidNumber(str, 16);
    }
    public boolean isValidPin(String pin){
        return isValidNumber(pin, 4);
    }
    public boolean isValidPinCode(String str){
        return isValidNumber(str, 6);
    }
    public boolean isValidAccountNumber(String str){
        return isValidNumber(str, 14);
    }
    public boolean isValidPanNUmber(String str){
        p = Pattern.compile("[a-z]{5}[0-9]{4}[a-z]");
        m = p.matcher(str);
        
        if(m.find() && m.group().equals(str)){
            return true;
        }
        
        return false;
    }
    public boolean isValidAadharNumber(String str){
        return isValidNumber(str, 12);
    }
    public boolean isValidEmailAddress(String email){
        p = Pattern.compile("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
        m = p.matcher(email);
        if(m.find() && m.group().endsWith(email)){
            return true;
        }
        return false;
    }
    private boolean isValidNumber(String str,int digit){
        String pattern = "[0-9]" + "{"+ digit + "}";
        p = Pattern.compile(pattern);
        m = p.matcher(str);
        
        if(m.find() && m.group().equals(str)){
            return true;
        }
        return false;
    }
    public boolean isValidStateOrCity(String com){
        p = Pattern.compile("[a-z]+",Pattern.CASE_INSENSITIVE);
        m = p.matcher(com);
        
        if(m.find() && m.group().equals(com)){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        ValidationCheck v = new ValidationCheck();
        System.out.println(v.isValidEmailAddress("malviyapratik302@gmail.com"));
        System.out.println(v.isValidStateOrCity("Gujarat"));
        
    }   
}

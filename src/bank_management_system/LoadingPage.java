
package bank_management_system;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoadingPage {
    String pinNumber,mobileNumber;
    public LoadingPage(String pinNumber,String mobileNumber) {
        this.pinNumber = pinNumber;
        this.mobileNumber = mobileNumber;
        LoadingScreenFrame screen = new LoadingScreenFrame();
        screen.setVisible(true);
        
        try {
            for(int i = 0;i<=100;i++){
                Thread.sleep(60);
                screen.Loading.setValue(i);
            }
            screen.setVisible(false);
            new Login();
            
        } catch (InterruptedException ex) {
            Logger.getLogger(LoadingPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
        new LoadingPage("", "");
    }
    
}

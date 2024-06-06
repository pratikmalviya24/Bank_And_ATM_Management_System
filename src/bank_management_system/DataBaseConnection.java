
package bank_management_system;
import java.sql.*;
public class DataBaseConnection {

    Connection conn;
    Statement s;
    
    public DataBaseConnection(){
        try {
            // 1. Driver register
//            Class.forName(com.mysql.cj.jdbc.Driver);
            
            // 2.Creating COnnection:
            conn = DriverManager.getConnection("jdbc:mysql:///BANK_MANAGEMENT_SYSTEM","root","Pratik@007");
            
            // Creating Statement:`
            s = conn.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

/* 
    1. Load or Register the Driver
    2. Create Connection
    3. Create Statement
    4. Execute Query
    5. Close Connection
*/


package Connections;


import java.sql.*;
import javax.swing.JOptionPane;
public class ConnectionToDB {
    Connection conn = null;
    public static Connection ConnectToDB(){
        try{
            Connection conn  = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=OnlineVoting;user=sa;password=lydeptraiabCD; connectTimeout=1000");
            return conn;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}
 
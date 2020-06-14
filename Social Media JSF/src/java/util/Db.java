package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author New
 */
public class Db {
    
     final private String db_url = "jdbc:derby://localhost:1527/webDb";
     final private String class_url = "org.apache.derby.jdbc.ClientDriver";
     final private String user = "APP";
     final private String pass = "APP";
    
     public Connection connect() {
       
        Connection connection = null;
        try {
             Class.forName(class_url).newInstance();;
            connection = DriverManager.getConnection(db_url, user, pass);
        } catch (Exception e) {
           e.printStackTrace();
        }
          return connection;
    }    
}

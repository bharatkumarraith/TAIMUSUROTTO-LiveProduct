package DAOimplementation;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnection {
    public static Connection GetConnection(){
        Connection connection=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox","root","Bharat@123");
            System.out.println("Connection sucessfully ");
        }
        catch(Exception e){
            System.out.println(e);
        }
        return connection;
    }
}

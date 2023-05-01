package DAOimplementation;

import DAOinterface.UserInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserImpl implements UserInterface {

    Scanner scanner=new Scanner(System.in);
    Connection connection=null;

    @Override
    public boolean createAccount() throws SQLException {
        System.out.println("ENTER NEW USERID");
        String userid=scanner.next();
        System.out.println("ENTER NEW PASSWORD");
        String password=scanner.next();
        System.out.println("ENTER NEW MOBILENUMBER");
        String mobilenumber=scanner.next();
        connection=DBConnection.GetConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("insert into jukebox.user(userid,password,mobilenumber)values(?,?,?)");
        preparedStatement.setString(1,userid);
        preparedStatement.setString(2,password);
        preparedStatement.setString(3,mobilenumber);
        preparedStatement.executeUpdate();
        System.out.println("VALUES UPDATED");
        return false;
    }

    @Override
    public boolean login() {
        try {
            System.out.println("Enter the Existing User ID  : ");
            String username = scanner.next();
            System.out.println("Enter the Existing Password : ");
            String password = scanner.next();
            String query = "select * from user where userid = ? and password = ?";
            connection=DBConnection.GetConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("Login Successfull");
                return true;
            }
            else{
                System.out.println("Invalid Credentials");
            }
        }
        catch (Exception e){
            System.out.println(e);
        }

        return false;
    }
}
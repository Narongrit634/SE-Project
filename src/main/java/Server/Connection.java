package Server;

import DesignPattern.Users;
import com.google.cloud.storage.Acl;

import java.sql.*;

public class Connection {
//    private static String driver = "org.sqlite.JDBC";
//    private static String dbURL = "jdbc:sqlite:sedatabase.db";
    private  static String driver = "com.mysql.jdbc.Driver";
    private static String dbURL ="jdbc:mysql://remotemysql.com:3306/ytzEjdpCNf";
    private static String dbUser = "ytzEjdpCNf";
    private static String dbPass = "L9LcYDD81I";

    public static boolean isLogin(String username ,String password){
        try {
            // setup
            Class.forName(driver);
            java.sql.Connection conn = DriverManager.getConnection(dbURL,dbUser,dbPass);
            if (conn != null) {
                String query = "Select * from Users Where username = '"+username+"'";
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    if(resultSet.getString("role").equals("teacher") && password.equals(resultSet.getString("password"))){
                        Users users = Users.getInstance();
                        users.setId(resultSet.getInt("id"));
                        users.setName(resultSet.getString("name"));
                        users.setEmail(resultSet.getString("email"));
                        users.setUsername(resultSet.getString("username"));
                        users.setPassword(resultSet.getString("password"));

                        System.out.println(users);
                        return true;
                    }
            }
                // close connection
                conn.close();
            }
        }catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

}

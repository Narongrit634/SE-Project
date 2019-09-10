package Server;

import java.sql.*;

public class Connection {
//    private static String driver = "org.sqlite.JDBC";
//    private static String dbURL = "jdbc:sqlite:sedatabase.db";
    private  static String driver = "com.mysql.jdbc.Driver";
    private static String dbURL ="jdbc:mysql://remotemysql.com:3306/ytzEjdpCNf";
    private static String dbUser = "ytzEjdpCNf";
    private static String dbPass = "L9LcYDD81I";
    public static void check(){
        try {
            // setup
            Class.forName(driver);
            java.sql.Connection conn = DriverManager.getConnection(dbURL,dbUser,dbPass);
            if (conn != null) {
                System.out.println("Connected to the database....");
                String query = "Select * from users";
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String email = resultSet.getString("email");

                    System.out.println("id:"+id+" name:"+name+" email: "+email);
            }
                // close connection
                conn.close();
            }
        }catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Connection.check();
    }
}

package Server;

import java.sql.*;

public class Connection {
    private static String driver = "org.sqlite.JDBC";
    private static String dbURL = "jdbc:sqlite:sedatabase.db";
    public static void check(){
        try {
            // setup
            Class.forName(driver);
            java.sql.Connection conn = DriverManager.getConnection(dbURL);
            if (conn != null) {
                System.out.println("Connected to the database....");
                String query = "Select * from Users";
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String email = resultSet.getString("email");

                    System.out.println("id:"+id+" name:"+name+" price: "+email);
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

package login_test;

import java.sql.*;

public class MysqlCon {

    public static void main(String[] args) {

        // Declare variables
        String url = "jdbc:mysql://localhost:3306/login_test";
        String username = "root";
        String password = "";

        // Register the driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Get a connection
        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            // Create a statement
            Statement statement = connection.createStatement();

            // Execute a query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM userlogin_tbl");

            // Iterate over the results
            while (resultSet.next()) {
                System.out.println(resultSet.getString("email")); //field from login_test database
                System.out.println(resultSet.getString("pass")); //field from login_test database
            }

            // Close the connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


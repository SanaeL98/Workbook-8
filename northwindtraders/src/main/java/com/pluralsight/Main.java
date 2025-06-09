package com.pluralsight;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // Load the MySQL Driver, line not needed in newer versions of Java
        // Class.forName("com.mysql.cj.jdbc.Driver");

        // 1. Open a connection to the database
        // Use the database URL to point to the correct database
        Connection connection;
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", "root", "yearup");

        // 2. Create statement
        // The statement is tied to the open connection
        Statement statement = connection.createStatement();

        // 3. Define your query
        String query = "SELECT * FROM products";
        System.out.println(query);

        // 4. Execute your query
        ResultSet results = statement.executeQuery(query);

        // 5. Process the results
        while (results.next()) {
            String city = results.getString("ProductName");
            System.out.println(city);
        }

        // 6. Close resources
        results.close();
        statement.close();
        connection.close();
    }
}

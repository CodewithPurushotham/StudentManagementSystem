package StudentManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        // Database credentials
        String url = "jdbc:mysql://localhost:3306/School";
        String username = "root";
        String password = "Purush@123"; // Replace with your MySQL password

        try {
            // Establishing the connection
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database!");

            // Creating a Statement object
            Statement statement = connection.createStatement();

            // Query to fetch data
            String sqlQuery = "SELECT * FROM students";
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            // Displaying the results
            System.out.println("ID | Name | Age | Course | Email");
            System.out.println("---------------------------------------");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String course = resultSet.getString("course");
                String email = resultSet.getString("email");

                System.out.println(id + " | " + name + " | " + age + " | " + course + " | " + email);
            }

            // Closing the resources
            resultSet.close();
            statement.close();
            connection.close();
            
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("General error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}


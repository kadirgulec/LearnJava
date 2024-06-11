package JavaLearn.datenbankImport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class evbMitarbeiter {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/evb_aufgabe_mitarbeiter";
        String username = "root";
        String password = "";
        
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish a connection
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            
            // Create a statement
            statement = connection.createStatement();
            
            // Execute a query
            String sql = "SELECT * FROM mitarbeiter";
            resultSet = statement.executeQuery(sql);
            
            // Process the result set
            while (resultSet.next()) {
                int id = resultSet.getInt("MitarbeiterID");
                String name = resultSet.getString("name");
                
                // Print the data
                System.out.println("ID: " + id + ", Name: " + name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the result set
                if (resultSet != null) resultSet.close();
                // Close the statement
                if (statement != null) statement.close();
                // Close the connection
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

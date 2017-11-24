package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB {

    public static void main(String[] argv) throws SQLException {

        System.out.println("-------- Oracle JDBC Connection Testing ------");

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

        } catch (ClassNotFoundException e) {

            System.out.println("Where is your Oracle JDBC Driver?");
            e.printStackTrace();
            return;

        }

        System.out.println("Oracle JDBC Driver Registered!");

        Connection connection = null;

        try {

            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "user_fraud", "password");

        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;

        }

        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }
        
        PreparedStatement pst = connection.prepareStatement("Select * from TBLISO");
            
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String F2_PAN = rs.getString("F2_PAN");
                System.out.println(F2_PAN);
            }
            
    }

}

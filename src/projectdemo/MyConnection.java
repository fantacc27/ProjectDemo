/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectdemo;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author Xiao
 */
public class MyConnection {
    public Connection connection = null;
    
    public Connection getConnection()
    {
            System.out.println("----- Mysql Connection Testing -----");
            try {
                Class.forName("com.mysql.jdbc.Driver");
                
            } catch (ClassNotFoundException e) {
                System.out.println("Where is MySQL Driver?");
                e.printStackTrace();
            }
            System.out.println("Mysql Driver Registered!");
            Connection connection = null;
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost/database_project","root","charles");
                
            } catch (SQLException e) {
                System.out.println("Connection Failed! Check output console");
                e.printStackTrace();
            }
            if (connection != null) {
                System.out.println("You made it, take control your database now!");
                
            } else {
                System.out.println("Failed to make connection!");
                
            }
            return connection;
    }
    
}

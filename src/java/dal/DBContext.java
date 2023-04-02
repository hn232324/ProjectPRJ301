/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBContext {
    
    public Connection connection;
    public DBContext(){
        try {
            String url = "jdbc:sqlserver://DESKTOP-U3EAPUS\\SQLEXPRESS:1433;databaseName=Assignment_PRJ301";
            String username = "sa";
            String password = "123";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
            connection = DriverManager.getConnection(url, username, password);
        } catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex);
        }
    }
    
    public static void main(String[] args) {
        new DBContext();
    }
}

 
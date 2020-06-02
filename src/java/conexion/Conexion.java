/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Pc
 */
public class Conexion {
    
    public Connection connectDatabase() throws  ClassNotFoundException{
        
        Connection connection = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistemas","root","");
            
        } catch (Exception ex) {
            System.out.println("ERROR"+ex.getMessage());
        }
        
        return connection;
        
    }
    
}

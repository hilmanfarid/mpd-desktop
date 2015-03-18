/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author toshiba
 */
public class DBConnection {
    public Connection openConnection() {
        
        Connection con = null;
        try  {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5444/sikp_db6","sikp","sikp");
            System.out.println("Berhasil Koneksi");
            return con;
        }catch(ClassNotFoundException | SQLException e) {
            System.out.println("Gagal Koneksi " + e.getMessage());
            return con;
        }
              
    }
    
}

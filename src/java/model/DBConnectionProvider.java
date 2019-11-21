
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletContext;

/**
 *
 * @author nik_3
 */
public class DBConnectionProvider {
    Connection con = null;

    private static ResultSet rs;
    public static ResultSet executeQuery(String query){
        try {
            //ServletContext sc = sce.getServletContext();
            String dbUser = "xyz";//sc.getInitParameter("dbName");
            String dbPassword = "password";//sc.getInitParameter("dbPassword");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/XYZ", dbUser, dbPassword);
            Statement stmt =con.createStatement();
            DBConnectionProvider.rs = stmt.executeQuery(query);
        }
        catch(Exception e){ System.out.println(e);}
        System.out.println(rs);
        return rs;
    }
    
    public Connection getConnection() {return this.con;}
       
}

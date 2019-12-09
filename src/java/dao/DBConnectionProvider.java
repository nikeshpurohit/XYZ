
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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

    private static String dbUser = "xyz";
    private static String dbPassword = "password";


    private static ResultSet rs;

    public static ResultSet executeQuery(String query) {
        try {
            //ServletContext sc = sce.getServletContext();
            //sc.getInitParameter("dbName");
            //sc.getInitParameter("dbPassword");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/XYZ", DBConnectionProvider.dbUser, DBConnectionProvider.dbPassword);
            Statement stmt = con.createStatement();
            DBConnectionProvider.rs = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(rs);
        return rs;
    }

    public Connection getConnection() {
        try{
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/XYZ", dbUser, dbPassword);
            return con;
        }
        catch (Exception e) {System.out.println(e);
        return null;}
    }
    
    public static void commitQuery(String query) {
        try {
             Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/XYZ", dbUser, dbPassword);
             Statement stmt = con.createStatement();
             stmt.executeUpdate(query);
        
        } catch (Exception e) {System.out.println(e);}
    }

}

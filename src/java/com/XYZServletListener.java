/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.ServletContext;

/**
 * Web application lifecycle listener.
 *
 * @author tobys
 */
public class XYZServletListener implements ServletContextListener {
    
    private Connection con = null;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        String dbName = sc.getInitParameter("dbName");
        String dbUser = sc.getInitParameter("dbUser");
        String dbPassword = sc.getInitParameter("dbPassword");
        System.out.println("Servlet listener started");
        
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/"+dbName.trim(), dbUser, dbPassword);
        } catch(ClassNotFoundException | SQLException e){
            sc.setAttribute("error", e);
        }
        sc.setAttribute("connection", con);
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try{ con.close(); } catch(SQLException e){}
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import model.DBConnectionProvider;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 *
 * @author nik_3
 */
public class UsersDAOImpl {

    public static model.User findByUsername(String username) throws SQLException {
        model.User entity = null;
        String query = ("SELECT * FROM XYZ.\"Users\" WHERE XYZ.\"Users\".\"id\" = " + "'" + username + "'");
        //System.out.println(query);
        ResultSet rs = model.DBConnectionProvider.executeQuery(query);

        if (rs.next() == false) {
            entity = null;
        } else {

            do {
                entity = new model.User(rs.getString("id"), rs.getString("password"), rs.getString("status"));
            } while (rs.next());
        }

        /*if(rs.isBeforeFirst()){return null;}
        
        //rs.beforeFirst();
        
        while (rs.next()) { 
            entity = new Classes.User(rs.getString("id"), rs.getString("password"), rs.getString("status"));
        } */
        return entity;
        /*while (rs.next()) {
            entity = new Classes.User(rs.getString("id"), rs.getString("password"), rs.getString("status"));
            //System.out.println(entity.getUsername() + entity.getPassword() + entity.getStatus());
        }*/
    }
    
    public static ArrayList listAllUsers(){
        ArrayList<model.User> users = new ArrayList<model.User>();
        String query = "SELECT XYZ.\"Users\".\"id\" FROM XYZ.\"Users\"";
        try {
            ResultSet rs = model.DBConnectionProvider.executeQuery(query);

            while (rs.next()){
                model.User u = new model.User();
                u.setUsername(rs.getString("id"));
                users.add(u);
            }  
        } catch(SQLException e){
            e.printStackTrace();
        }
         
        return users;
    }
     //NEW NEW NEW NEW 
    public  addUser(String fn, String ln, String pass, String un, String r)
    {
   
        try
        {
            DataBase db = new DataBase();
            PreparedStatement stmt = db.getCon().prepareStatement("INSERT INTO users(USERNAME, PASSWORD, USERTYPE, FIRST_NAME, LAST_NAME) VALUES (?, ?, ?, ?, ?)");
            stmt.setString(1, un);
            stmt.setString(2, pass);
            stmt.setString(3, r);
            stmt.setString(4, fn);
            stmt.setString(5, ln);
            
            // execute insert SQL stetement
            stmt.executeUpdate();
            
            stmt.close();
            db.getCon().close();
            
        } catch (SQLException ex)
        {
            Logger.getLogger(UsersDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("FAILED IN CREATING USER");
        }
       
    }

    public User addCustomer(String fn, String ln, String pass, String un, String add)
    {
        this.addUser(fn, ln, pass, un, "CUSTOMER");
        User user = this.findByName(un);
        
        try
        {
            DataBase db = new DataBase();
            PreparedStatement stmt = db.getCon().prepareStatement("INSERT INTO customer(ADDRESS, USER_ID) VALUES (?, ?)");
            stmt.setString(1, add);
            stmt.setInt(2, user.getID());
            
            // execute insert SQL stetement
            stmt.executeUpdate();
            
            stmt.close();
            db.getCon().close();
            
        } catch (SQLException ex)
        {
            Logger.getLogger(UsersDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("FAILED IN CREATING CUSTOMER");
        }
        
        return user;
    }
    
    public void updateUser(User user) {
        try
        {
            DataBase db = new DataBase();
            PreparedStatement stmt = db.getCon().prepareStatement("UPDATE users set username = ?, password = ?, first_name = ?, last_name = ? WHERE id = ?");
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getFirstName());
            stmt.setString(4, user.getLastName());
            stmt.setInt(5, user.getID());
            
            // execute insert SQL stetement
            stmt.executeUpdate();
            
            stmt.close();
            db.getCon().close();
            
        } catch (SQLException ex)
        {
            Logger.getLogger(UsersDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("FAILED IN CREATING CUSTOMER");
        }
    }


}

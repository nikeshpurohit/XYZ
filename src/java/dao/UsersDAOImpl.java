/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.DBConnectionProvider;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
    
    public static void createNewUser(model.User user){
        //Attributes of the new user
        String id = user.getUsername();
        String password = user.getPassword();
        String status = user.getStatus();
        
        //DB Query
        //String query = "INSERT INTO XYZ.\"Users\"";
    }

}

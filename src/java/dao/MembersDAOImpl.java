/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.DBConnectionProvider;
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
public class MembersDAOImpl {

    public static model.User findByUsername(String username) throws SQLException {
        model.User entity = null;
        String query = ("SELECT * FROM XYZ.\"Members\" WHERE XYZ.\"Users\".\"id\" = " + "'" + username + "'");
        //System.out.println(query);
        ResultSet rs = com.DBConnectionProvider.executeQuery(query);

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

    public static ArrayList listAllMembers(){
        ArrayList<model.Member> members = new ArrayList<model.Member>();
        String query = "SELECT * FROM XYZ.\"Members\"";
        try {
            ResultSet rs = com.DBConnectionProvider.executeQuery(query);

            while (rs.next()){
                model.Member m = new model.Member();
                m.setName(rs.getString("name"));
                m.setAddress(rs.getString("address"));
                m.setDOB(rs.getString("dob"));
                m.setDOR(rs.getString("dor"));
                m.setBalance(rs.getFloat("balance"));
                members.add(m);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }

        return members;
    }

    public static void createNewUser(model.User user){
        //Attributes of the new user
        String id = user.getUsername();
        String password = user.getPassword();
        String status = user.getStatus();

        //DB Query
        String query = "INSERT INTO XYZ.\"Users\" (\"id\",\"password\",\"status\") VALUES ('" + id + "', '" + password + "', '" + status + "')" ;
        com.DBConnectionProvider.commitQuery(query);
        
        // this should call the members dao
        
                
    }

}

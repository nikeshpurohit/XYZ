/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Objects.DBConnectionProvider;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author nik_3
 */
public class UsersDAOImpl {

    public static Classes.User findByUsername(String username) throws SQLException {
        Classes.User entity = null;
        String query = ("SELECT * FROM XYZ.\"Users\" WHERE XYZ.\"Users\".\"id\" = " + "'" + username + "'");
        //System.out.println(query);
        ResultSet rs = Objects.DBConnectionProvider.executeQuery(query);

        if (rs.next() == false) {
            entity = null;
        } else {

            do {
                entity = new Classes.User(rs.getString("id"), rs.getString("password"), rs.getString("status"));
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

}

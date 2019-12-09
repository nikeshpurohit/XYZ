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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 *
 * @author nik_3
 */
public class MembersDAOImpl {

    public static model.Member findByUsername(String username) throws SQLException {
        model.Member entity = new model.Member();
        String query = ("SELECT * FROM XYZ.\"Members\" WHERE XYZ.\"Members\".\"id\" = " + "'" + username + "'");
        //System.out.println(query);
        ResultSet rs = com.DBConnectionProvider.executeQuery(query);

        if (rs.next() == false) {
            entity = null;
        } else {

            do {
                entity.setAddress(rs.getString("address"));
                entity.setDOB(rs.getString("dob"));
                entity.setDOR(rs.getDate("dor"));
                entity.setName(rs.getString("name"));
                entity.setBalance(rs.getFloat("balance"));
            } while (rs.next());
        }

        return entity;
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
                m.setDOR(rs.getDate("dor"));
                m.setBalance(rs.getFloat("balance"));
                members.add(m);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }

        return members;
    }
    
    public static void CreateNewMember(model.Member member){
        
        // the attributes of a new member
        String Username =  member.getUsername();
        String FullName = member.getName();
        String Address = member.getAddress();
        String DoB = member.getDob();
        Date DoR = new Date();
        String Status = member.getStatus();
        float Balance = member.getBalance();
        
        
        //DB Query
        String query = "INSERT INTO XYZ.\"Members\" (\"id\",\"name\",\"address\",\"dob\",\"dor\",\"status\",\"balance\") VALUES ('" + Username + "','" + FullName + "', '" + Address + "', '" + DoB + "' , CURRENT_DATE , '" + Status + "' , " + Balance + ")";
        //String query = "INSERT INTO XYZ.\"Claims\" (\"mem_id\",\"date\",\"rationale\",\"status\",\"amount\") VALUES ('" + ClaimsID + "', CURRENT_DATE ,'" + ClaimsRationale + "', '" + ClaimsStatus + "', " + ClaimsAmount + ")" ;

        System.out.println(query);
        com.DBConnectionProvider.commitQuery(query);
        
    }
    
    public static ArrayList listAllAppliedMembers(){
        ArrayList<model.Member> members = new ArrayList<model.Member>();
        String query = "SELECT * FROM XYZ.\"Members\" WHERE XYZ.\"Members\".\"status\" = 'APPLIED'";
        
        try{
            ResultSet rs = com.DBConnectionProvider.executeQuery(query);

            while (rs.next()){
                model.Member m = new model.Member();
                m.setName(rs.getString("name"));
                m.setAddress(rs.getString("address"));
                m.setDOB(rs.getString("dob"));
                m.setDOR(rs.getDate("dor"));
                m.setStatus(rs.getString("status"));
                m.setBalance(rs.getFloat("balance"));
                members.add(m);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }            
        return members;
    }

    public static ArrayList listAllApprovedMembers(){
        ArrayList<model.Member> members = new ArrayList<model.Member>();
        String query = "SELECT * FROM XYZ.\"Members\" WHERE XYZ.\"Members\".\"status\" = 'MEMBER'";
        
        try{
            ResultSet rs = com.DBConnectionProvider.executeQuery(query);

            while (rs.next()){
                model.Member m = new model.Member();
                m.setName(rs.getString("name"));
                m.setAddress(rs.getString("address"));
                m.setDOB(rs.getString("dob"));
                m.setDOR(rs.getDate("dor"));
                m.setStatus(rs.getString("status"));
                m.setBalance(rs.getFloat("balance"));
                members.add(m);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }            
        return members;
    }
}

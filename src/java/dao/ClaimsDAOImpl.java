/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Date;
import com.DBConnectionProvider;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Claims;
/**
 *
 * @author tobys
 */
public class ClaimsDAOImpl {
    
    public static ArrayList listAllClaimsForUser(String username){
        ArrayList<model.Claims> claims = new ArrayList<model.Claims>();
        String query = "SELECT * FROM XYZ.\"Claims\" WHERE XYZ.\"Claims\".\"mem_id\" = " + "'" + username + "'";
        try{
            ResultSet rs = com.DBConnectionProvider.executeQuery(query);
            
            while (rs.next()){
                model.Claims c = new model.Claims();
                c.setID(rs.getInt("id"));
                c.setUsername(rs.getString("mem_id"));
                c.setAmount(rs.getInt("amount"));
                c.setRationale(rs.getString("rationale"));
                c.setStatus(rs.getString("status"));
                c.setDate(rs.getDate("date"));
                
                claims.add(c);
            }
        } catch(SQLException e){;}
        
        return claims;
    }
    
    public static ArrayList listAllClaims(){
        ArrayList<model.Claims> claims = new ArrayList<model.Claims>();
        String query = "SELECT * FROM XYZ.\"Claims\"";
        try{
            ResultSet rs = com.DBConnectionProvider.executeQuery(query);
            
            while (rs.next()){
                model.Claims c = new model.Claims();
                c.setID(rs.getInt("id"));
                c.setUsername(rs.getString("mem_id"));
                c.setAmount(rs.getInt("amount"));
                c.setRationale(rs.getString("rationale"));
                c.setStatus(rs.getString("status"));
                c.setDate(rs.getDate("date"));
                
                claims.add(c);
            }
        } catch(SQLException e){;}
        
        return claims;
    }
        
    public static void MakeNewClaims(model.Claims claims)
    {
        //Attributes of the new user
         String ClaimsID = claims.getUsername();
         Date ClaimsDate = claims.getDate();
         String ClaimsRationale= claims.getRationale();
         String ClaimsStatus = claims.getStatus();
         int ClaimsAmount = claims.getAmount();

        //DB Query
        //String query = "INSERT INTO XYZ.\"Claims\" (\"mem_id\",\"date\",\"rationale\",\"status\",\"amount\") VALUES ('" + ClaimsID + "', '" + ClaimsDate + "', '" + ClaimsRationale + ", " + ClaimsStatus + ", " + ClaimsAmount + "')" ;
        String query = "INSERT INTO XYZ.\"Claims\" (\"mem_id\",\"date\",\"rationale\",\"status\",\"amount\") VALUES ('" + ClaimsID + "', CURRENT_DATE ,'" + ClaimsRationale + "', '" + ClaimsStatus + "', " + ClaimsAmount + ")" ;
          //              INSERT INTO XYZ.\"Claims\" (\"mem_id\",\"date\",\"rationale\",\"status\",\"amount\") VALUES ('me-aydin', CURRENT_DATE, 'crash', 'open', 5000.0)"
        //String query = "INSERT INTO XYZ.\"Users\" (\"id\",\"password\",\"status\") VALUES ('" + id + "', '" + password + "', '" + status + "')" ;
        System.out.println(query);
        com.DBConnectionProvider.commitQuery(query);
        
    }
}

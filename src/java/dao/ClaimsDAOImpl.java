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
 * @author tobys
 */
public class ClaimsDAOImpl {
    
    public static ArrayList listAllClaims(String username){
        ArrayList<model.Claims> claims = new ArrayList<model.Claims>();
        String query = "SELECT * FROM XYZ.\"Claims\" WHERE XYZ.\"Claims\".\"mem_id\" = " + "'" + username + "'";
        try{
            ResultSet rs = model.DBConnectionProvider.executeQuery(query);
            
            while (rs.next()){
                model.Claims c = new model.Claims();
                c.setAmount(rs.getInt("amount"));
                c.setRationale(rs.getString("rationale"));
                c.setStatus(rs.getString("status"));
                c.setDate(rs.getDate("date"));
                
                claims.add(c);
            }
        } catch(SQLException e){;}
        
        return claims;
    }
}

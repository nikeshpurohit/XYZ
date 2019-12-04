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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
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
                c.setUsername(rs.getString("mem_id"));
                                
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
         
         ArrayList<Date> dates = new ArrayList<Date>();
         
        //DB Query
        String query = "INSERT INTO XYZ.\"Claims\" (\"mem_id\",\"date\",\"rationale\",\"status\",\"amount\") VALUES ('" + ClaimsID + "', CURRENT_DATE ,'" + ClaimsRationale + "', '" + ClaimsStatus + "', " + ClaimsAmount + ")" ;
        String query1 = "SELECT * FROM XYZ.\"Claims\" WHERE XYZ.\"Claims\".\"mem_id\" = " + "'" + ClaimsID + "'";
        ResultSet rs = com.DBConnectionProvider.executeQuery(query1);
        try{
            
                System.out.println("hello1");
                while(rs.next()){
                    dates.add(rs.getDate("date"));
                    System.out.println("hello2");
                }
                System.out.println(dates.size() + " dates size");
                if (dates.size() < 2){
                    com.DBConnectionProvider.commitQuery(query);
                    System.out.println("hello3");
                }else{
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    Date startOfYear = format.parse("2019-01-01"); 
                    System.out.println(startOfYear + " start of ueardsgsg");
                    System.out.println(dates.get(0) + " dates in db");
                    int claimsThisYear = 0;
                    System.out.println("hello4");
                    for (int i = 0; i < dates.size();i++){
                        if (dates.get(i).after(startOfYear)){
                            claimsThisYear++;
                            System.out.println("hello5");
                        }
                    }
                    if (claimsThisYear < 2){
                        com.DBConnectionProvider.commitQuery(query);
                        System.out.println("hello6");
                    }
                    System.out.println(dates.size());
                
            }
        }catch(SQLException | ParseException e){;}
    }
    
    public static float totalClaimAmount(){
        float total = 0;
        String query = "SELECT XYZ.\"Claims\".\"amount\" FROM XYZ.\"Claims\"";
        try{
            ResultSet rs = com.DBConnectionProvider.executeQuery(query);            
            while (rs.next()){
                total += rs.getFloat("amount");
            }
        } catch(SQLException e){;}        
        
        System.out.println(total);
        return total;
    }
    
    public static void totalClaimAmountAndChargeMembers(){
        float total = 0, amountToPay;
        int numOfMembers=0;
        String query = "SELECT XYZ.\"Claims\".\"amount\" FROM XYZ.\"Claims\"";
        String query1 = "SELECT COUNT(*) as \"total\" FROM XYZ.\"Members\" WHERE XYZ.\"Members\".\"status\" = 'MEMBER'";
        try{
            ResultSet rs = com.DBConnectionProvider.executeQuery(query); 
            ResultSet rs1 = com.DBConnectionProvider.executeQuery(query1);
            while (rs.next()){
                total += rs.getFloat("amount");
            }
            while (rs1.next()){
                numOfMembers++;
            }
        } catch(SQLException e){;}       
        amountToPay = total / numOfMembers;
        //Loop through members database and minus amountToPay from balance of each member
    }
}

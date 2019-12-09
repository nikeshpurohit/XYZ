/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Date;
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
            ResultSet rs = dao.DBConnectionProvider.executeQuery(query);

            while (rs.next()){
                model.Claims c = new model.Claims();
                c.setId(rs.getInt("id"));
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
            ResultSet rs = dao.DBConnectionProvider.executeQuery(query);

            while (rs.next()){
                model.Claims c = new model.Claims();
                c.setId(rs.getInt("id"));
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
        ResultSet rs = dao.DBConnectionProvider.executeQuery(query1);
        dao.DBConnectionProvider.commitQuery(query);
        /*try{

                while(rs.next()){
                    dates.add(rs.getDate("date"));
                }
                System.out.println(dates.size() + " dates size");
                if (dates.size() < 2){
                    com.DBConnectionProvider.commitQuery(query);
                }else{
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    Date startOfYear = format.parse("2019-01-01");
                    int claimsThisYear = 0;
                    for (int i = 0; i < dates.size();i++){
                        if (dates.get(i).after(startOfYear)){
                            claimsThisYear++;
                        }
                    }
                    if (claimsThisYear < 2){
                        com.DBConnectionProvider.commitQuery(query);
                    }

            }
        }catch(SQLException | ParseException e){;}*/
    }

    public static float totalClaimAmount(){
        float total = 0;
        String query = "SELECT XYZ.\"Claims\".\"amount\" FROM XYZ.\"Claims\" WHERE XYZ.\"Claims\".\"status\" = 'closed'";
        try{
            ResultSet rs = dao.DBConnectionProvider.executeQuery(query);
            while (rs.next()){
                total += rs.getFloat("amount");
            }
        } catch(SQLException e){;}
        return total;
    }

    public static void totalClaimAmountAndChargeMembers(){
        float total = totalClaimAmount(), amountToPay;
        int numOfMembers=0;
        String query = "SELECT * FROM XYZ.\"Members\" WHERE XYZ.\"Members\".\"status\" = 'MEMBER'";
        String query2 = "SELECT * FROM XYZ.\"Users\" WHERE XYZ.\"Users\".\"status\" = 'MEMBER'";
        try{
            ResultSet rs = dao.DBConnectionProvider.executeQuery(query);
            ResultSet rs2 = dao.DBConnectionProvider.executeQuery(query2);
            while (rs.next()){
                numOfMembers++;
            }
            amountToPay = total / numOfMembers;           
            while (rs2.next()){
                model.User u = new model.User();
                u.setUsername(rs2.getString("id"));
                u.setPassword(rs2.getString("password"));
                u.setStatus(rs2.getString("status"));
                model.Member m = new model.Member();
                m.setUser(u);
                model.Payment p = new model.Payment();
                p.setAmount(amountToPay);
                dao.PaymentsDAOImpl.removeBalance(p, m);                
            }
        } catch(SQLException e){;}
    }
    
    public static void rejectClaim(String id){
        String query = "UPDATE XYZ.\"Claims\" SET \"status\" = " + "'rejected'" + " WHERE \"id\" = " + id;
        //System.out.println("reubge" + query);
        dao.DBConnectionProvider.commitQuery(query);
    }
    
    public static void closeClaim(String id){
        String query = "UPDATE XYZ.\"Claims\" SET \"status\" = " + "'closed'" + " WHERE \"id\" = " + id;
        //System.out.println("reubge" + query);
        dao.DBConnectionProvider.commitQuery(query);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author tobys
 */
public class PaymentsDAOImpl {
    
    public static ArrayList listAllPaymentsMadeForUser(String username){
        ArrayList<model.Payment> payment = new ArrayList<model.Payment>();
        String query = "SELECT * FROM XYZ.\"Payments\" WHERE XYZ.\"Payments\".\"mem_id\" = " + "'" + username + "'";
        try{
            ResultSet rs = dao.DBConnectionProvider.executeQuery(query);
            
            while (rs.next()){
                model.Payment p = new model.Payment();
                p.setUsername(rs.getString("mem_id"));
                p.setAmount(rs.getInt("amount"));
                p.setTypeOfPayment(rs.getString("type_of_payment"));
                p.setDate(rs.getDate("date"));
                
                payment.add(p);
            }
        } catch(SQLException e){;}
        
        return payment;
          
    }
    
    public static ArrayList listAllPaymentsMade(){
        ArrayList<model.Payment> payment = new ArrayList<model.Payment>();
        String query = "SELECT * FROM XYZ.\"Payments\"";
        try{
            ResultSet rs = dao.DBConnectionProvider.executeQuery(query);
            
            while (rs.next()){
                model.Payment p = new model.Payment();
                p.setUsername(rs.getString("mem_id"));
                p.setAmount(rs.getInt("amount"));
                p.setTypeOfPayment(rs.getString("type_of_payment"));
                p.setDate(rs.getDate("date"));
                
                payment.add(p);
            }
        } catch(SQLException e){;}
        
        return payment;
          
    }
    
    public static ArrayList listAllPayments(){
        ArrayList<model.Payment> payments = new ArrayList<model.Payment>();
        String query = "SELECT * FROM XYZ.\"Payments\"";
        try{
            ResultSet rs = dao.DBConnectionProvider.executeQuery(query);
            
            while (rs.next()){
                model.Payment p = new model.Payment();
                p.setAmount(rs.getInt("amount"));
                p.setUsername(rs.getString("mem_id"));
                p.setTypeOfPayment(rs.getString("type_of_payment"));
                p.setDate(rs.getDate("date"));
                
                payments.add(p);
            }
        } catch(SQLException e){;}
        
        return payments;
    }
    
     public static void MakeNewPayment(model.Payment payment){
        //Attributes of the new user
         String PaymentID = payment.getUsername();
         Date PaymentDate = payment.getDate();
         String PaymentType = payment.getTypeOfPayment();
         float PaymentAmount = payment.getAmount();

        //DB Query
        String query = "INSERT INTO XYZ.\"Payments\" (\"mem_id\",\"date\",\"type_of_payment\",\"amount\") VALUES ('" + PaymentID + "', CURRENT_DATE ,'" + PaymentType + "', " + PaymentAmount + ")" ;
        System.out.println(query);
        dao.DBConnectionProvider.commitQuery(query);
        
    }
     
    public static void addBalance(model.Payment payment, model.Member member){
        // do the calculations
        float newBalance;
        float oldBalance = member.getBalance();
        newBalance = oldBalance + payment.getAmount();
        
        // set the vars
        member.setBalance(newBalance);
        String query = "UPDATE XYZ.\"Members\" SET \"balance\" = " + newBalance + " WHERE \"id\" = " + "'" + member.getUser().getUsername() + "'";
        System.out.println("Add" + query);
        dao.DBConnectionProvider.commitQuery(query);
    }
    
    public static void removeBalance(model.Payment payment, model.Member member){
         // do the calculations
        float newBalance;
        float oldBalance = member.getBalance();
        newBalance = oldBalance - payment.getAmount();
        System.out.println("old: " + oldBalance + " new: " + newBalance);
        
        // set the vars
        member.setBalance(newBalance);
        String query = "UPDATE XYZ.\"Members\" SET \"balance\" = " + newBalance + " WHERE \"id\" = " + "'" + member.getUser().getUsername() + "'";
        System.out.println("remove" + query);
        dao.DBConnectionProvider.commitQuery(query);
    }
}

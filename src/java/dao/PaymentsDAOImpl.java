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
public class PaymentsDAOImpl {
    
    public static ArrayList listAllPaymentsMadeForUser(String username){
        ArrayList<model.Payment> payment = new ArrayList<model.Payment>();
        String query = "SELECT * FROM XYZ.\"Payments\" WHERE XYZ.\"Payments\".\"mem_id\" = " + "'" + username + "'";
        try{
            ResultSet rs = model.DBConnectionProvider.executeQuery(query);
            
            while (rs.next()){
                model.Payment p = new model.Payment();
                p.setAmount(rs.getInt("amount"));
                p.setTypeOfPayment(rs.getString("type_of_payment"));
                p.setDate(rs.getDate("date"));
                
                payment.add(p);
            }
        } catch(SQLException e){;}
        
        return payment;
    }
}

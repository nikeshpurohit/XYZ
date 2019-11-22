/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
/**
 *
 * @author tobys
 */
public class Payment {
    private int id;
    private int amount;
    private Date date = new Date();
    private String username;
    private String typeOfPayment;
    
    public Payment(){}
    
    public Payment(String username, int amount, Date date, String typeOfPayment, String status){
        this.username = username;
        this.amount = amount;
        this.date = date;
        this.typeOfPayment = typeOfPayment;
    }
    
    public String getUsername(){return this.username;}
    
    public int getAmount() {return this.amount;}
    
    public String getTypeOfPayment(){return this.typeOfPayment;}
        
    public Date getDate(){return this.date;}
    
    public void setUsername(String username){this.username = username;}
    
    public void setAmount(int amount){this.amount = amount;}
        
    public void setTypeOfPayment(String typeOfPayment){this.typeOfPayment = typeOfPayment;}
    
    public void setDate(Date date){this.date = date;}
       
}

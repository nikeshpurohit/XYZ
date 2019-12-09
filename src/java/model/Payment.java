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
    public int id;
    public float amount;
    public Date date = new Date();
    public String username;
    public String typeOfPayment;
    
    public Payment(){}
    
    public Payment(String username, int amount, Date date, String typeOfPayment){
        this.username = username;
        this.amount = amount;
        this.date = date;
        this.typeOfPayment = typeOfPayment;
    }
    
    public String getUsername(){return this.username;}
    
    public float getAmount() {return this.amount;}
    
    public String getTypeOfPayment(){return this.typeOfPayment;}
        
    public Date getDate(){return this.date;}
    
    public void setUsername(String username){this.username = username;}
    
    public void setAmount(float amount){this.amount = amount;}
        
    public void setTypeOfPayment(String typeOfPayment){this.typeOfPayment = typeOfPayment;}
    
    public void setDate(Date date){this.date = date;}
       
}

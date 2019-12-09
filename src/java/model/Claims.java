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
public class Claims {
    public int id;
    public int amount;
    public Date date = new Date();
    public String username;
    public String rationale;
    public String status;
    
    public Claims(){}
    
    public Claims(String username, int amount, Date date, String rationale, String status){
        this.id = 0;
        this.username = username;
        this.amount = amount;
        this.date = date;
        this.rationale = rationale;
        this.status = status;
    }
    
    public String getUsername(){return this.username;}
    
    public int getAmount() {return this.amount;}
    
    public String getRationale(){return this.rationale;}
    
    public String getStatus(){return this.status;}
    
    public Date getDate(){return this.date;}
    
    public int getId() {return this.id;}
    
    public void setUsername(String username){this.username = username;}
    
    public void setAmount(int amount){this.amount = amount;}
    
    public void setStatus(String status){this.status = status;}
    
    public void setRationale(String rationale){this.rationale = rationale;}
    
    public void setDate(Date date){this.date = date;}
    
    public void setId(int id){this.id = id;}
       
}

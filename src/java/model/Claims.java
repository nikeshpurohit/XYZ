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
    private int id;
    private int amount;
    private Date date = new Date();
    private String username;
    private String rationale;
    private String status;
    
    public Claims(){}
    
    public Claims(String username, int amount, Date date, String rationale, String status){
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
    
    public void setUsername(String username){this.username = username;}
    
    public void setAmount(int amount){this.amount = amount;}
    
    public void setStatus(String status){this.status = status;}
    
    public void setRationale(String rationale){this.rationale = rationale;}
    
    public void setDate(Date date){this.date = date;}
       
}

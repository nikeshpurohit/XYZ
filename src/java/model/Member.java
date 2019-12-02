/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author nik_3
 */
public class Member {
    public model.User user;
    public String name;
    public String address;
    public String dob;
    public String dor;
    public String status = user.getStatus();
    public float balance;
    
    public void setUser(model.User user) {this.user = user;}
    
    public void setName(String name) {this.name = name;}
    
    public void setAddress(String address) {this.address = address;}
    
    public void setDOB(String dob) {this.dob = dob;}
    
    public void setDOR(String dor) {this.dor = dor;}

    public void setStatus(String status) {this.status = status;}

    public void setBalance(float balance) {this.balance = balance;}

    public model.User getUser() {return user;}

    public String getName() {return name;}

    public String getAddress() {return address;}

    public String getDob() {return dob;}

    public String getDor() {return dor;}

    public String getStatus() {return status;}

    public float getBalance() {return balance;}
    
    
}

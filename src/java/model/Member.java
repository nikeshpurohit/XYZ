/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Table;

/**
 *
 * @author nik_3
 */
@Table(name = "Members")

public class Member {
    public model.User user;
    public String name;
    public String address;
    public String dob;
    public String dor;
    public String status;
    public float balance;
    
    public Member() {}

    public Member(Member m) {
        this.user = m.getUser();
        this.name = m.getName();
        this.address = m.getAddress();
        this.dob = m.getDob();
        this.dor = m.getDor();
        this.status = m.getStatus();
    }

    public Member(User user, String name, String address, String dob, String dor, float balance) {
        this.user = user;
        this.name = name;
        this.address = address;
        this.dob = dob;
        this.dor = dor;
        this.balance = balance;
    }
       
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
    
    public String getUsername() {return user.getUsername();}
    
    
}

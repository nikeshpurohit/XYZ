/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import javax.persistence.Table;
import java.text.SimpleDateFormat;

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
    public Date dor;
    public String status;
    public float balance;
    public String id;
    
    public Member() {}

    public Member(Member m) {
        this.user = m.getUser();
        this.name = m.getName();
        this.address = m.getAddress();
        this.dob = m.getDob();
        this.dor = m.getDor();
        this.status = m.getStatus();
        this.id = m.getId();
    }

    public Member(User user, String name, String address, String dob, Date dor, float balance, String status) {
        this.user = user;
        this.name = name;
        this.address = address;
        this.dob = dob;
        this.dor = dor;
        this.balance = balance;
        this.status = status;
    }
       
    public void setUser(model.User user) {this.user = user;}
    
    public void setName(String name) {this.name = name;}
    
    public void setAddress(String address) {this.address = address;}
    
    public void setDOB(String dob) {this.dob = dob;}
    
    public void setDOR(Date dor) {this.dor = dor;}

    public void setStatus(String status) {this.status = status;}

    public void setBalance(float balance) {this.balance = balance;}

    public void setId(String id) {this.id = id;}

    public model.User getUser() {return user;}

    public String getName() {return name;}

    public String getAddress() {return address;}

    public String getDob() {return dob;}

    public Date getDor() {return dor;}

    public String getStatus() {return status;}

    public float getBalance() {return balance;}
    
    public String getUsername() {return user.getUsername();}
    
    public String getId(){return this.id;}
    

    
}

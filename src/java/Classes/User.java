/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;
import javax.persistence.Table;

/**
 *
 * @author nik_3
 */
@Table(name = "users")

public class User {
    private int id;
    private String username;
    private String password;
    private String status;
    
    public User() {}
    
    public User(User u) {
        this.id = u.id;
        this.username = u.username;
        this.password = u.password;
        this.status = u.status;
    }
    
    public User(String username, String password, String status){
        this.username = username;
        this.password = password;
        this.status = status;
    }
    
    public String getUsername(){return this.username;}
    
    public String getPassword(){return this.password;}
    
    public String getStatus(){return this.status;}
    
    public void setUsername(String username){this.username = username;}
    
    public void setPassword(String password){this.username = password;}
    
    public void setStatus(String username){this.username = status;}
}
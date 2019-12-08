/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nik_3
 */
public class LoginSession {

    private model.User user;
    private model.Member member;

    public LoginSession(model.User user, model.Member member, HttpSession session, HttpServletResponse response)
    {
        this.user = user;
        this.member = member;

        session.setAttribute("user",user);
        session.setAttribute("member",member);
        session.setAttribute("userStatus",user.getStatus());
    }

    public boolean validateUser(String username, String password)
    {
        boolean valid = false;
        if (user != null)
        {
            if (user.getUsername().equals(username) && user.getPassword().equals(password))
            {
                valid = true;
            }
        }

        return valid;
    }


    public String getUsername(){return user.getUsername();}

    public String getPassword(){return user.getPassword();}

}

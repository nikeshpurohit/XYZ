/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ralph Sartorio
 */
//WebServlet(name = "RegisterServlet", urlPatterns = {"/Register.do"})
public class RegisterServlet extends HttpServlet {
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
          
            String RUserName = request.getParameter("rUsernameInput");
            String RPassword = request.getParameter("rPasswordInput");
            String RPassword2 = request.getParameter("rPasswordInput2");
            
            model.User user = new model.User();
            dao.UsersDAOImpl userDAO = new dao.UsersDAOImpl();
            HttpSession session = request.getSession();
           
             //if(request.getParameter("Register") != null){
                try {
                    user = dao.UsersDAOImpl.findByUsername(RUserName);// this goes to the DB to check if there is a user with the same user name


                    if (RUserName.isEmpty()|| RPassword.isEmpty() || RPassword2.isEmpty()){
                        out.println("All fields are empty!");
                        session.setAttribute("RegisterError", "REmpty");
                        response.sendRedirect(request.getContextPath() + "/Register.jsp");
                    }
                    
                    else if (user != null){
                        out.println("Username Already Exsits");
                        session.setAttribute("RegisterError", "user");
                        response.sendRedirect(request.getContextPath() + "/Register.jsp");
                    }
   
                    else if (!RPassword.equals(RPassword2)) {
                        out.println("your pssswords does not match");
                        session.setAttribute("RegisterError", "RPassword");
                        response.sendRedirect(request.getContextPath() + "/Register.jsp");
                    }
                            
                    else if (user == null && RPassword.equals(RPassword2))
                    {
                        out.println("username and password is added to the database and direct you to the members dashboard");
                        request.getSession().setAttribute("RegisterError", "none");
                        request.getRequestDispatcher("/XYZ/Login.jsp").forward(request, response);
                        
                        
                        
                        model.LoginSession login_session = new model.LoginSession(user, session, response);

                        session.setAttribute("login_session", login_session);

                        if (login_session.validateUser(RUserName, RPassword));{request.getRequestDispatcher("Dashboard.jsp");} 
                    } 
                    }
                    /*else {
                        out.println("theres a problem with your validation....");
                    }*/
                        
                    
                    catch (SQLException ex) {
                        Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                        out.println(ex);
                } 
           
            }
        }
             
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

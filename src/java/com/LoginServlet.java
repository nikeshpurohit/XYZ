package com;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nik_3
 */
public class LoginServlet extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */

            String username = request.getParameter("usernameInput");
            String password = request.getParameter("passwordInput");
            //out.println(username);
            //out.println(password);
            model.User user;
            HttpSession session = request.getSession();
            
            if(request.getParameter("loginButton") != null){
                try {
                    user = dao.UsersDAOImpl.findByUsername(username);


                    if (user == null){
                        request.getSession().setAttribute("LoginError", "user");
                        response.sendRedirect(request.getContextPath() + "/Login.jsp");
                    }
                    else if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                        //HttpSession session = request.getSession();
                        session.setAttribute("username", username);
                        request.getSession().setAttribute("LoginError", "none");
                        model.LoginSession login_session = new model.LoginSession(user, session, response);

                        session.setAttribute("login_session", login_session);

                        if (login_session.validateUser(username, password));{request.getRequestDispatcher("UserDashServlet");}
  
                    } 
                    else {
                        out.println("incorrect password");
                        //HttpSession session = request.getSession();
                        request.getSession().setAttribute("LoginError", "password");
                        response.sendRedirect(request.getContextPath() + "/Login.jsp");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                    out.println(ex);
                } }
            
                else if (request.getParameter("registerButton")!= null){
                    request.getSession().setAttribute("LoginError", "none");
                    response.sendRedirect(request.getContextPath() + "/Register.jsp");
                }
        
            

            //Objects.DBConnectionProvider.executeQuery("SELECT * from Users")

            //Objects.DBConnectionProvider.executeQuery("SELECT * from Users")
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

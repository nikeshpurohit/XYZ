/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
            
            
            String RFirstName = (String)request.getParameter("rFirstNameInput");
            String RSecondName = request.getParameter("rSecondNameInput");
            String RFullName = RFirstName + " " + RSecondName; 
            String RAddress = request.getParameter("rAddress");
            float RBalance = -10;
            String Status = "APPLIED";
            Date DoR = new Date();
            
            model.User u = new model.User(); 
            String s[] = RFirstName.split("");
            System.out.println(RFirstName);
            System.out.println(s[0].split(""));
            String RUserName = s[0] + "-" + RSecondName;

            model.User user;
            dao.UsersDAOImpl userDAO = new dao.UsersDAOImpl();
            HttpSession session = request.getSession();
             //if(request.getParameter("Register") != null){
                try {
                   user = dao.UsersDAOImpl.findByUsername(RUserName);// this goes to th+e DB to check if there is a user with the same user name


                    if (RFirstName.isEmpty() || RSecondName.isEmpty() || RAddress.isEmpty()){
                        out.println("A fields is empty! Please input data in all the ");
                        session.setAttribute("RegisterError", "REmpty");
                        response.sendRedirect(request.getContextPath() + "/Register.jsp");
                    }

                    else if (user != null){
                        out.println("Username Already Exsits");
                        session.setAttribute("RegisterError", "RUser");
                        response.sendRedirect(request.getContextPath() + "/Register.jsp");
                    }


                    else if (user == null)
                    {
                        out.println("username and password is added to the database and direct you to the members dashboard");
                        request.getSession().setAttribute("RegisterError", "none");
                        request.getSession().setAttribute("LoginError", "RSuccess");
                        
                        //Date DoB = new SimpleDateFormat("ddMMyy").parse(request.getParameter("rDoB"));
                        
                        DateFormat dateFormat = new SimpleDateFormat("ddMMyy");

                        //DateFormat dadteFormat = SimpleDateFormat("ddMMyy");
                        String strDoB = dateFormat.format((request.getParameter("rDoB")));
                        String rPassword = "dob";
                   
                        model.User AddUser = new model.User(RUserName, rPassword, Status);
                        model.Member AddMem = new model.Member(AddUser, RFullName, RAddress, strDoB , DoR, RBalance, Status);
                        
                        dao.UsersDAOImpl.createNewUser(AddUser);
                        dao.MembersDAOImpl.CreateNewMember(AddMem);
                        
                        request.getRequestDispatcher("/Login.jsp").forward(request, response);


                    }
                    }
                    /*else {
                        out.println("theres a problem with your validation....");
                    }*/ catch (SQLException  ex) {
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

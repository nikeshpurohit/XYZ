/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "MakePaymentServlet", urlPatterns = {"/MakePaymentServlet"})
public class MakePaymentServlet extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. 
            String ClaimsID = request.getParameter("ClaimsID");
            String ClaimsDate = request.getParameter("ClaimsDate");
            String ClaimsDesc = request.getParameter("ClaimsDesc");
            String ClaimsStatus = request.getParameter("ClaimsStatus");
            String ClaimsAmount = request.getParameter("ClaimsAmount");
            
            model.Claims claims = new model.Claims();
            dao.ClaimsDAOImpl claimsDAO = new dao.ClaimsDAOImpl();
            
            model.User user = new model.User();
            dao.UsersDAOImpl userDAO = new dao.UsersDAOImpl();
            
            HttpSession session = request.getSession();
 
            //if(request.getParameter("MakeClaims") != null){
               try {
                    // this goes to the DB to check if there is a user with the same user name
                    user = dao.UsersDAOImpl.findByUsername(ClaimsID);

                    if (ClaimsID.isEmpty()|| ClaimsDate.isEmpty() || ClaimsDesc.isEmpty()|| ClaimsStatus.isEmpty() || ClaimsAmount.isEmpty()){
                        out.println("All fields are empty!");
                        session.setAttribute("MakeClaimsError", "errEmpty");
                        response.sendRedirect(request.getContextPath() + "/MakeClaims.jsp");
                    }
                    
                    else if (user == null){
                        out.println("userID incorrect! please re-type the username");
                        session.setAttribute("MakeClaimsError", "errMakeID");
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
                        model.User AddUser = new model.User(RUserName, RPassword, Status);
                        dao.UsersDAOImpl.createNewUser(AddUser);
                        request.getRequestDispatcher("/XYZ/Login.jsp").forward(request, response);  
                        

                    } 
                    } */
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

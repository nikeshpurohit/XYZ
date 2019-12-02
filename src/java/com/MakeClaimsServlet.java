/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import dao.ClaimsDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.DateFormatter;

/**
 *
 * @author Ralph Sartorio
 */
@WebServlet(name = "MakeClaimsServlet", urlPatterns = {"/MakeClaimsServlet.do"})
public class MakeClaimsServlet extends HttpServlet {

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
            HttpSession session = request.getSession();
            //System.out.println("IT worked");
            String ClaimsID = (String)session.getAttribute("username");
            Date ClaimsDate = new Date();            
            String ClaimsDesc = request.getParameter("ClaimsRationale");
            String ClaimsStatus = "open";
            String ClaimsAmount = request.getParameter("ClaimsAmount");
                               
            if (ClaimsDesc.isEmpty()|| ClaimsAmount.isEmpty()){
                out.println("Not All fields are full!");
                session.setAttribute("MakeClaimsError", "errEmpty");
                response.sendRedirect(request.getContextPath() + "/MakeClaims.jsp");
            }else{
                model.Claims claim = new model.Claims(ClaimsID, Integer.parseInt(ClaimsAmount), ClaimsDate, ClaimsDesc, ClaimsStatus );
                dao.ClaimsDAOImpl.MakeNewClaims(claim);
                response.sendRedirect(request.getContextPath() + "/MakeClaims.jsp");                       
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

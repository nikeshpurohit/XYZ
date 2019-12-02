/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import dao.MembersDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nik_3
 */
public class AdminDashServlet extends HttpServlet {

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
            System.out.println("ADMIN DASH SERVLET WORKING");

            //================Get Claims for this user=========================
            ArrayList<model.Claims> claims = new ArrayList<model.Claims>();
            claims = dao.ClaimsDAOImpl.listAllClaims();
            //model.Claims[] claimsArray = claims.toArray(new model.Claims[claims.size()]);
            session.setAttribute("listOfAllClaims", claims);
            
            //=================Get list of users================================
            ArrayList<model.User> users = new ArrayList<model.User>();
            users = dao.UsersDAOImpl.listAllUsers(); 
            request.setAttribute("listOfAllUsers", users);
            
            //=================List Members=====================================
            ArrayList<model.Member> members = new ArrayList<model.Member>();
            members = dao.MembersDAOImpl.listAllMembers();
            request.setAttribute("listOfAllMembers", members);
            
            //-----------------List applied members=============================
            ArrayList<model.Member> appliedMembers = new ArrayList<model.Member>();
            members = MembersDAOImpl.listAllAppliedMembers();
            request.setAttribute("listOfAppliedUsers", members);
            
            request.getRequestDispatcher("Dashboard_Admin.jsp").forward(request, response);
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

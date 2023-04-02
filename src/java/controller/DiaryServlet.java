/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import model.Account;
import model.Diary;

/**
 *
 * @author 
 */
@WebServlet(name = "DiaryServlet", urlPatterns = {"/diary"})
public class DiaryServlet extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DiaryServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DiaryServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        //processRequest(request, response);
        
        String id = request.getParameter("sid");
        DAO dao = new DAO();
        dao.delete(id);
        Account a = (Account) request.getSession().getAttribute("acc");
        response.sendRedirect("home?aid=" + a.getId());


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
        String id_raw = request.getParameter("id");
        String name = request.getParameter("title");
        String address = request.getParameter("note");
        int id=0;
        try {
            
            id = Integer.parseInt(id_raw);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }

        Calendar c = Calendar.getInstance();

        Account a = (Account) request.getSession().getAttribute("acc");

        SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String createDate = f.format(c.getTime());
        String updateDate = f.format(c.getTime());
        Diary d = new Diary(id, name, address, createDate, updateDate, a.getId());

        DAO dao = new DAO();
        dao.update(d);

        response.sendRedirect("home?aid=" + a.getId());
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

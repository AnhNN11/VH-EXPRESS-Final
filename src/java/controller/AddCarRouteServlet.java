/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.entity.Carroutes;
import model.entity.Cars;
import model.entity.Seats;
import model.entity.Tickets;
import model.repository.CarRepository;
import model.repository.CarRouteRepository;
import model.repository.SeatRepository;
import model.repository.TicketRepository;

/**
 *
 * @author tuna
 */
@WebServlet(name = "AddCarRouteServlet", urlPatterns = {"/addcarroute"})
public class AddCarRouteServlet extends HttpServlet {

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
            out.println("<title>Servlet AddCarRouteServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddCarRouteServlet at " + request.getContextPath() + "</h1>");
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
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("add_car_route.jsp").forward(request, response);
//        processRequest(request, response);
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
//        processRequest(request, response);
        int car_id = Integer.parseInt(request.getParameter("car_id"));
        int from = Integer.parseInt(request.getParameter("from"));
        int to = Integer.parseInt(request.getParameter("to"));
//        float price = Float.parseFloat(request.getParameter("price"));
        int price = Integer.parseInt(request.getParameter("price"));
        String start = request.getParameter("start");
        String end = request.getParameter("end");
        Date datestart = Date.valueOf(request.getParameter("datestart"));
        int user_id = Integer.parseInt(request.getParameter("driver_id"));
        
        //add carroute
        Carroutes carroutes = new Carroutes(car_id, from, to, price, start, end, datestart, user_id);
        CarRouteRepository crr = new CarRouteRepository();
        crr.createCarroutes(carroutes);
        
        
        //add ticket
        SeatRepository sr = new SeatRepository();
        TicketRepository tr = new TicketRepository();
        CarRepository cr = new CarRepository();
        Cars c = cr.getCar(car_id);
        Carroutes carroute = crr.getByCarUser(car_id, user_id);
        for(int i = 1; i<=c.getCountseat(); i++){
            Seats s = sr.getSeat(i,c.getId());
            Tickets t = new Tickets(carroute.getId(),s.getId(),0,0);
            tr.InserTicket(t);
        }
        response.sendRedirect("listcarroute");
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

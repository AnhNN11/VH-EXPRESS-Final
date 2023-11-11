/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.entity.Carroutes;
import model.entity.Cars;
import model.entity.Tickets;
import model.repository.CarRepository;
import model.repository.CarRouteRepository;
import model.repository.TicketRepository;

/**
 *
 * @author tuna
 */
@WebServlet(name = "ListSeatServlet", urlPatterns = {"/listseat"})
public class ListSeatServlet extends HttpServlet {

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
        String carouteid = request.getParameter("crid") ;
        System.out.println(carouteid);
        CarRouteRepository crr = new CarRouteRepository();
        Carroutes carroute = crr.getCarroute(carouteid);
        
//        System.out.println(carroute);
        CarRepository cr = new CarRepository();
        Cars car = cr.getCar(carroute.getCar_id());
        //lay list tickets
        TicketRepository tr = new TicketRepository();
        ArrayList<Tickets> tlist = tr.getListTickets(carroute.getId());
//        SeatRepository sr = new SeatRepository();
//        ArrayList<Seats> sList = sr.getListSeats(carroute.getCar_id());
        
        
        HttpSession session = request.getSession(true);
        session.setAttribute("tlistS", tlist);
        session.setAttribute("curCarroute",carroute);
        session.setAttribute("curCar", car);
//        response.sendRedirect("listseat");
        request.getRequestDispatcher("list_seat.jsp").forward(request, response);
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

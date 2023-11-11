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
import model.entity.Orders;
import model.entity.Seats;
import model.entity.Tickets;
import model.entity.Users;
import model.repository.OrderRepository;
import model.repository.SeatRepository;
import model.repository.TicketRepository;

/**
 *
 * @author tuna
 */
@WebServlet(name = "CreateTicketServlet", urlPatterns = {"/createticket"})
public class CreateTicketServlet extends HttpServlet {

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
        String tickets;
        tickets = request.getParameter("lticket");
//        System.out.println(seats);

        String[] listticket = tickets.split(",");
        int[] ticketids = new int[listticket.length];

        for (int i = 0; i < listticket.length; i++) {
            ticketids[i] = Integer.parseInt(listticket[i]);
        }

        HttpSession session = request.getSession();
//        session.setAttribute("lseatS", seatids);
        Carroutes crs = (Carroutes) session.getAttribute("curCarroute");
        int idCar = crs.getCar_id();
        int price = crs.getPrice();
        int total = 0;
        
        TicketRepository tr = new TicketRepository();
        ArrayList<Tickets> ltickets = new ArrayList<>();
        SeatRepository sr = new SeatRepository();
        for(int ticketid : ticketids){
            total +=price;
            Seats s = sr.getSeat(ticketid, idCar);
            Tickets t = tr.getTicketByRouteSeat(crs.getId(),s.getId());
            ltickets.add(t);
        }
        
        //test
//        for(Tickets t : ltickets){
//            System.out.println(t);
//        }
        
        session.setAttribute("lticketS", ltickets);
        session.setAttribute("totalPrice", total);
        
        
//        ArrayList<Seats> lSeats = new ArrayList<>();
//        SeatRepository sr = new SeatRepository();
//        for (int seatid : ticketids) {
//            total += price;
//            Seats s = sr.getSeat(seatid, idCar);
////            System.out.println(s);
//            lSeats.add(s);
//        }
//        

//        
        request.getRequestDispatcher("create_ticket.jsp").forward(request, response);
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
//        processRequest(request, response);
        HttpSession session = request.getSession();

        OrderRepository or = new OrderRepository();

        Users u = (Users) session.getAttribute("cur_user");
        int u_id = u.getId();
        
        int total_price = (int) session.getAttribute("totalPrice");
        Orders o = new Orders(u_id,0,total_price);
        or.InserOrder(o);
        Orders o_new = or.getNearOrder();
        session.setAttribute("cur_order", o_new);
        
        Carroutes carr = (Carroutes) session.getAttribute("curCarroute");
//        System.out.println(carr.getCar_id());

        //add ticket to order and update passenger information to ticket
        TicketRepository tr = new TicketRepository();
        SeatRepository sr = new SeatRepository();
        ArrayList<Tickets> ltickets = (ArrayList<Tickets>) session.getAttribute("lticketS");
        ArrayList<Tickets> ltickets_new = new ArrayList<>();
        for(Tickets t : ltickets){
            String passName = new String(request.getParameter("passen_name"+t.getId()).getBytes("iso-8859-1"), "utf-8");
//            String passName = request.getParameter("passen_name"+t.getId());
            String passPhone = request.getParameter("passen_phone"+t.getId());
            Tickets t_new = new Tickets(t.getId(),
                    t.getRoute_id(),
                    t.getSeat_id(),
                    o_new.getId(),
                    1,
                    passName,
                    passPhone
            );
//            System.out.println(t_new);
            tr.updatePassenger(t_new);
            ltickets_new.add(t_new);
        }
        session.setAttribute("litcket_newS", ltickets_new);
        request.getRequestDispatcher("confirm_ticket.jsp").forward(request, response);
        //test
//        for(Tickets t : ltickets){
//            System.out.println(t);
//        }


        
//        TicketRepository tr = new TicketRepository();
//        SeatRepository sr = new SeatRepository();
//        ArrayList<Tickets> ltickets = new ArrayList<>();
//        ArrayList<Seats> lseats = (ArrayList<Seats>) session.getAttribute("lseatS");
//        for (Seats s : lseats) {
//            String passName = request.getParameter("passen_name"+s.getSeat_number());
//            String passPhone = request.getParameter("passen_phone"+s.getSeat_number());
//            Tickets t = new Tickets(carr.getId(),s.getSeat_number(),o_new.getId(), passName, passPhone);
//            tr.InserTicket(t);
//            sr.setIsBooked(carr.getCar_id(), s.getSeat_number());
//            ltickets.add(t);
//        }
//        session.setAttribute("lticketS", ltickets);
        
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

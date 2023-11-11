/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.entity.Cars;
import model.repository.CarRepository;
import model.repository.SeatRepository;

/**
 *
 * @author tuna
 */
@WebServlet(name = "AddCarServlet", urlPatterns = {"/addcar"})
public class AddCarServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddCar</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddCar at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("add_car.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String name = new String(request.getParameter("name").getBytes("iso-8859-1"), "utf-8");
//        String name = request.getParameter("name");
        System.out.println(name);
        String type = request.getParameter("type");
        
        int countseat = 0;
        if(type.equalsIgnoreCase("VIP")){
            countseat = 45;
        }else if(type.equalsIgnoreCase("LUXURY")){
            countseat = 24;
        }else if(type.equalsIgnoreCase("STANDARD")){
            countseat = 22;
        }
//        int countseat = Integer.parseInt(request.getParameter("countseat"));
        String licenseplate = request.getParameter("licenseplate");
        Cars cars = new Cars(name, type, countseat, licenseplate);
        CarRepository cr = new CarRepository();
        String result = cr.InserCar(cars);
        
        if(result.equalsIgnoreCase("SUCCESS")){
            Cars c = cr.getCarbyLicenseplate(licenseplate);
            for(int i = 1; i<= countseat; i++){
                SeatRepository sr = new SeatRepository();
                sr.insertSeats(i,c.getId());
            }
            response.sendRedirect("listcar");
        } else{
            response.sendRedirect("addcar");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

package controller;

import java.io.IOException;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.entity.Orders;
import model.repository.OrderRepository;
import model.repository.TicketRepository;

@WebServlet(name = "PaySuccessServlet", urlPatterns = {"/paysuccess"})
public class PaySuccessServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        OrderRepository or = new OrderRepository();
        HttpSession session = request.getSession();
        Orders o = (Orders) session.getAttribute("cur_order");
        System.out.println(o.getId());
        or.updateStatusOrder(o.getId());

        // Update status = 2 ticket in order
        TicketRepository tr = new TicketRepository();
        System.out.println(o.getId());
        tr.updatePayment(o.getId());

        // Send payment success email
        try {
            EmailSender.sendPaymentSuccessEmail("hoangkrt1@gmail.com", o.getId());
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("payment.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

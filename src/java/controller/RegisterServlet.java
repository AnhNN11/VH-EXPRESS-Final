/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.RegisterDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.entity.Authority;
import model.repository.UserRepository;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegisterServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterServlet at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("register.jsp").forward(request, response);
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
        try {
            String name = request.getParameter("fullname");
//            System.out.println(name);
            String email = request.getParameter("email");
//            System.out.println(email);
            String password = request.getParameter("password");
//            System.out.println(password);
            String newPass = DigestUtils.md5Hex(password);
            
            String authStr = Authority.ROLE_MEMBER.toString();

            if (isEmailExists(email)) {
                System.out.println("kkk");
                HttpSession session = request.getSession();
                session.setAttribute("emailExistsMessage", "Email đã tồn tại, vui lòng chọn email khác.");
                response.sendRedirect("register"); // Chuyển hướng về trang đăng ký
            } else {
                System.out.println("kkk1");
                //HashGenerate
                String hash;
                Random rand = new Random();
                rand.nextInt(999999);
                hash = DigestUtils.md5Hex("" + rand);

                //Create a dataBean 
                RegisterDao rd = new RegisterDao();
                System.out.println(rd);
                rd.setFullname(name);
                rd.setEmail(email);
                rd.setPassword(newPass);
                rd.setHash(hash);
                rd.setAuthority(authStr);

                UserRepository ur = new UserRepository();
                String str = ur.Register(rd);
                System.out.println(str);
                if (str.equals("SUCCESS")) {
                    response.sendRedirect("verifired.jsp");
                } else {
                    response.sendRedirect("register");
                }
            }
        } catch (Exception e) {
            System.err.println("Register Servlet File:: " + e);
        }

    }

    private boolean isEmailExists(String email) {
        // Thực hiện kiểm tra xem email đã tồn tại trong cơ sở dữ liệu hay chưa
        // Trả về true nếu email đã tồn tại, ngược lại trả về false
        UserRepository ur = new UserRepository();
        return ur.isEmailExists(email);
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

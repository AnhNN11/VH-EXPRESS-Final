package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.config.DBConnect;
import model.repository.UserRepository;
import org.apache.commons.codec.digest.DigestUtils;

@WebServlet("/newpassword")
public class NewPassword extends HttpServlet {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String newPassword = request.getParameter("password");
//        String newPassGenerate;
//        Random rand = new Random();
//        rand.nextInt(999999);
//        newPassword= DigestUtils.md5Hex("" + rand);
        String newPass = DigestUtils.md5Hex(newPassword);
        RequestDispatcher dispatcher = null;
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement("update users set password = ? where email = ?");
            ps.setString(1, newPass);
            ps.setString(2, (String) session.getAttribute("email"));
            int rowCount = ps.executeUpdate();
            if (rowCount > 0) {
                request.setAttribute("status", "resetSuccess");
                dispatcher = request.getRequestDispatcher("login.jsp");
            } else {
                request.setAttribute("status", "resetFailed");
                dispatcher = request.getRequestDispatcher("login.jsp");
            }
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
    
}

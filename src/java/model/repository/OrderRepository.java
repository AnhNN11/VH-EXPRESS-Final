/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.config.DBConnect;
import model.entity.Orders;

/**
 *
 * @author tuna
 */
public class OrderRepository {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public String InserOrder(Orders o) {
        String sql = "INSERT INTO orders (user_id, status, total_price) VALUES (?, 0, ?);";

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);

            ps.setInt(1, o.getUser_id());
            ps.setFloat(2, o.getTotal_price());

            int i = ps.executeUpdate();
            if (i != 0) {
                return "SUCCESS";
            }
            ps.close();

        } catch (Exception e) {
            System.err.println("RegisterRepository File:: " + e);
        }
        return "ERROR";
    }

    public Orders getNearOrder() {
        Orders o = new Orders();
        String sql = "SELECT TOP 1 * FROM orders ORDER BY id DESC";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();
            if (rs.next()) {
                return new Orders(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getDate(5));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("khong lay dc id");
        }
        return o;
    }

    public void updateStatusOrder(int id) {
        String sql = "UPDATE [orders]\n"
                + "SET [status] = 1\n"
                + "WHERE id = ?;";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            int i = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<Orders> getListOrdersbyUser(int id) {
        ArrayList<Orders> list = new ArrayList<>();
        String sql = "SELECT * FROM orders where user_id = ?";

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            rs = ps.executeQuery();
            while (rs.next()) {
                Orders o = new Orders(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getDate(5));
                list.add(o);
            }
            return list;
        } catch (Exception e) {
            System.err.println(e);
            System.out.println("Lỗi list trong User repo");
        }
        return null;
    }

    public static void main(String[] args) {
        OrderRepository or = new OrderRepository();
        int userId = 1;
        float totalPrice = (float) 1200.009;
//        Orders o = new Orders(userId, 1, totalPrice);
        int id = 2001;
//        System.out.println(or.InserOrder(o));
//        System.out.println(or.getNearOrder());
//        or.updateStatusOrder(id);
        System.out.println(or.getListOrdersbyUser(5));
    }
}

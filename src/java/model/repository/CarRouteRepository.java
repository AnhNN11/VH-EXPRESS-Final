/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.config.DBConnect;
import model.entity.Carroutes;

/**
 *
 * @author tuna
 */
public class CarRouteRepository {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public ArrayList<Carroutes> getListCarroutes() {
        ArrayList<Carroutes> list = new ArrayList<>();
        String sql = "SELECT * FROM carroutes";

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                int car_id = rs.getInt(2);
                int from = rs.getInt(3);
                int to = rs.getInt(4);
                int price = rs.getInt(5);
                String start = rs.getString(6);
                String end = rs.getString(7);
                Date datestart = rs.getDate(8);
                int user_id = rs.getInt(9);

                Carroutes c = new Carroutes(id, car_id, from, to, price, start, end, datestart, user_id);
                list.add(c);
            }
            return list;
        } catch (Exception e) {
            System.err.println(e);
            System.out.println("Lỗi list trong car repo");
        }
        return null;
    }

    public Carroutes getCarroute(String id) {
        Carroutes c = new Carroutes();
        String sql = "SELECT * FROM carroutes WHERE id = ?";

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, id);

            rs = ps.executeQuery();
            if (rs.next()) {
                return new Carroutes(rs.getInt("id"),
                        rs.getInt("car_id"),
                        rs.getInt("from"),
                        rs.getInt("to"),
                        rs.getInt(5),
                        rs.getString("start"),
                        rs.getString("end"),
                        rs.getDate("datestart"),
                        rs.getInt("user_id"));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("khong lay dc id");
        }
        return c;
    }

    public void createCarroutes(Carroutes c) {

        String sql = "INSERT INTO [dbo].[carroutes] ([car_id], [from], [to], [price], [start], [end], [datestart], [user_id])\n"
                + "VALUES (?, ?, ?, ?, ?, ?, ?,?);";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);

            ps.setInt(1, c.getCar_id());
            ps.setInt(2, c.getFrom());
            ps.setInt(3, c.getTo());
            ps.setInt(4, c.getPrice());
            ps.setString(5, c.getStart());
            ps.setString(6, c.getEnd());
            ps.setDate(7, c.getDatestart());
            ps.setInt(8, c.getUser_id());

            ps.executeUpdate();
            con.commit();
            ps.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("----------LOI DANG KY Carroutes trong CarroutesRepository------------");
        }
    }

    public ArrayList<Carroutes> searchCarroutes(int from, int to, Date datestart) {

        ArrayList<Carroutes> list = new ArrayList<>();

        String sql = "Select * from carroutes where [from] = ? and [to] = ? and datestart = ?";

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);

            ps.setInt(1, from);
            ps.setInt(2, to);
            ps.setDate(3, datestart);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                int car_id = rs.getInt(2);
                from = rs.getInt(3);
                to = rs.getInt(4);
                int price = rs.getInt(5);
                String start = rs.getString(6);
                String end = rs.getString(7);
                datestart = rs.getDate(8);
                int user_id = rs.getInt(9);

                Carroutes c = new Carroutes(id, car_id, from, to, price, start, end, datestart, user_id);
                list.add(c);
            }
            return list;
        } catch (Exception e) {
            System.err.println(e);
            System.out.println("Lỗi get list trong car repo");
        }
        return null;
    }

    public void updateCarRoute(Carroutes carroute) {
        String sql = "UPDATE carroutes SET car_id = ?, [from] = ?, [to] = ?, price = ?, [start] = ?, [end] = ?, datestart = ?, user_id = ? WHERE id = ?";

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);

            ps.setInt(1, carroute.getCar_id());
            ps.setInt(2, carroute.getFrom());
            ps.setInt(3, carroute.getTo());
            ps.setDouble(4, carroute.getPrice());
            ps.setString(5, carroute.getStart());
            ps.setString(6, carroute.getEnd());
            ps.setDate(7, carroute.getDatestart());
            ps.setInt(8, carroute.getUser_id());
            ps.setInt(9, carroute.getId());

            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error in updating car route information");
        }
    }

    public void deleteCarroute(int id) {
        String sql = "DELETE FROM carroutes WHERE id = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("----------LOI Delete Carroute trong CarrouteRepository------------");
        }
    }

    public int getbyOrder(int id) {
        String sql = "SELECT TOP 1 route_id\n"
                + "FROM dbo.tickets\n"
                + "WHERE order_id = ?\n"
                + "ORDER BY id;";

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public Carroutes getByCarUser(int car_id, int user_id) {
        String sql = "Select * from carroutes where [car_id] = ? and [user_id] = ? ";

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);

            ps.setInt(1, car_id);
            ps.setInt(2, user_id);

            rs = ps.executeQuery();

            while (rs.next()) {
                return new Carroutes(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getDate(8),
                        rs.getInt(9));
            }
        } catch (Exception e) {
            System.err.println(e);
            System.out.println("Lỗi getByCarUser ");
        }
        return null;
    }

    public static void main(String[] args) {
        CarRouteRepository crr = new CarRouteRepository();
//        System.out.println(crr.getListCarroutes());
//        System.out.println(crr.getCarroute("1"));
        int car_id = 2;
        int from = 3;
        int to = 4;
        int price = 500000;
        String start = "09:00:00";
        String end = "15:00:00";
        Date datestart = Date.valueOf("2023-12-26");
        int user_id = 4;
        Carroutes cr = new Carroutes(car_id, from, to, price, start, end, datestart, user_id);
//        crr.createCarroutes(cr);

//        System.out.println(crr.getbyOrder(1));
        System.out.println(crr.getByCarUser(4, 4));
    }
}

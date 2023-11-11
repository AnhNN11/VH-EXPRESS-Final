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
import model.entity.Tickets;

/**
 *
 * @author tuna
 */
public class TicketRepository {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public String InserTicket(Tickets t) {
        String sql = "INSERT INTO tickets (route_id, seat_id, order_id,status)\n"
                + "VALUES (?, ?, ?, ?);";

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);

            ps.setInt(1, t.getRoute_id());
            ps.setInt(2, t.getSeat_id());
            ps.setInt(3, t.getOrder_id());
            ps.setInt(4, 0);

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

    public ArrayList<Tickets> getListTickets(int crr_id) {
        ArrayList<Tickets> list = new ArrayList<>();
        String sql = "SELECT * FROM tickets where route_id = ?";

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);

            ps.setInt(1, crr_id);

            rs = ps.executeQuery();
            while (rs.next()) {
                Tickets t = new Tickets(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getNString(6),
                        rs.getNString(7));
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            System.err.println(e);
            System.out.println("Lỗi getListSeats");
        }
        return null;
    }

    public Tickets getTicketByRouteSeat(int route_id, int seat_id) {
        String sql = "SELECT * FROM tickets where route_id = ? and seat_id = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);

            ps.setInt(1, route_id);
            ps.setInt(2, seat_id);

            rs = ps.executeQuery();
            while (rs.next()) {
                return new Tickets(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getNString(6),
                        rs.getNString(7));
            }

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Loi getTicketByRouteSeat");
        }
        return null;
    }

    public void updatePassenger(Tickets t) {
        String sql = "UPDATE [dbo].[tickets]\n"
                + "SET \n"
                + "    status = 1,\n"
                + "    order_id = ?,\n"
                + "    passenger_name = ?,\n"
                + "    passenger_phone = ?\n"
                + "WHERE\n"
                + "    route_id = ?\n"
                + "    AND seat_id = ?;";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);

            ps.setInt(1, t.getOrder_id());
            ps.setNString(2, t.getPassenger_name());
            ps.setNString(3, t.getPassenger_phone());
            ps.setInt(4, t.getRoute_id());
            ps.setInt(5, t.getSeat_id());

            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Loi updatePassenger");
        }
    }

    public void updatePayment(int order_id) {
        String sql = "UPDATE tickets \n"
                + "SET status = 2\n"
                + "WHERE order_id = ?;";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);

            ps.setInt(1, order_id);

            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error in update Ticket Payment");
        }
    }

    public static void main(String[] args) {
        TicketRepository tr = new TicketRepository();
        int id = 1;
        String name = new String("Nguyễn Anh Tú");
        String phone = new String("0912644974");
//        Tickets t = new Tickets(id, id, id, name, phone);
//        System.out.println(tr.InserTicket(t));
//        System.out.println(tr.getListTickets(7));
//        System.out.println(tr.getTicketByRouteSeat(7, 70));
        Tickets t_new = new Tickets(162,
                7,
                73,
                3,
                1,
                "x",
                "y"
        );
//        tr.updatePassenger(t_new);
        tr.updatePayment(2);
    }
}

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
import model.entity.Cars;
import model.entity.Seats;

/**
 *
 * @author tuna
 */
public class SeatRepository {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public int insertSeats(int id, int car_id) {
        String sql = "INSERT INTO seats (car_id,seat_number, status)\n"
                + "VALUES\n"
                + "    (?, ?, 0)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, car_id);
            ps.setInt(2, id);
            int i = ps.executeUpdate();
            if (i != 0) {
                return 1;
            }
            ps.close();

        } catch (Exception e) {
            System.err.println("RegisterRepository File:: " + e);
        }
        return 0;
    }

    public ArrayList<Seats> getListSeats(int id_car) {
        ArrayList<Seats> list = new ArrayList<>();
        String sql = "SELECT * FROM seats where car_id = ?";

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);

            ps.setInt(1, id_car);

            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int status = rs.getInt("status");
                int idcar = rs.getInt("car_id");
                int seat_number = rs.getInt("seat_number");

                Seats s = new Seats(id, status, seat_number, idcar);
                list.add(s);
            }
            return list;
        } catch (Exception e) {
            System.err.println(e);
            System.out.println("Lỗi list trong seat repo");
        }
        return null;
    }

    public Seats getSeat(int seat_number, int car_id) {
        Seats s = new Seats();
        String sql = "SELECT * FROM seats WHERE seat_number = ? and car_id = ?";

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, seat_number);
            ps.setInt(2, car_id);

            rs = ps.executeQuery();
            if (rs.next()) {
                return new Seats(rs.getInt(1),
                        rs.getInt(4),
                        rs.getInt(3),
                        rs.getInt(2));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("khong lay dc id");
        }
        return s;
    }

    public Seats getById(int seat_id) {
        Seats s = new Seats();
        String sql = "SELECT * FROM seats WHERE id= ?";

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, seat_id);

            rs = ps.executeQuery();
            if (rs.next()) {
                return new Seats(rs.getInt(1),
                        rs.getInt(4),
                        rs.getInt(3),
                        rs.getInt(2));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi getSeatbyId");
        }
        return s;
    }

    public void setIsBooked(int car_id, int seat_number) {
        String sql = "UPDATE [seats]\n"
                + "SET [status] = 1\n"
                + "WHERE [car_id] = ? AND [seat_number] = ?;";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, car_id);
            ps.setInt(2, seat_number);
            int i = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        SeatRepository sr = new SeatRepository();
        int car_id = 2;
        int seat_number = 15;
        sr.setIsBooked(car_id, seat_number);

//        System.out.println(sr.getListSeats(2));
//        System.out.println(sr.getSeat(12,2).toString());
    }
}

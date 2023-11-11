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

/**
 *
 * @author tuna
 */
public class CarRepository {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public ArrayList<Cars> getListCars() {
        ArrayList<Cars> list = new ArrayList<>();
        String sql = "SELECT * FROM cars";

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int idcar = rs.getInt(1);
                String namecar = rs.getString(2);
                String type = rs.getString(3);
                int countseat = rs.getInt(4);
                int isactive = rs.getInt(5);
                String licenseplate = rs.getString(6);
                Cars car = new Cars(idcar, namecar, type, countseat, isactive, licenseplate);
                list.add(car);
            }
            return list;
        } catch (Exception e) {
            System.err.println(e);
            System.out.println("Lỗi list trong car repo");
        }
        return null;
    }

    public String InserCar(Cars c) {
        String sql = "INSERT INTO cars (name, type, countseat, isactive, licenseplate)\n"
                + "VALUES\n"
                + "    (?, ?, ?, 1, ?)";

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            String name = c.getName();
            String type = c.getType();
            int countseat = c.getCountseat();
            String licenseplate = c.getLicenseplate();

            ps.setString(1, name);
            ps.setString(2, type);
            ps.setInt(3, countseat);
            ps.setString(4, licenseplate);

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

    public Cars getCar(int id) {
        Cars c = new Cars();
        String sql = "SELECT * FROM cars WHERE id = ?";

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            if (rs.next()) {
                return new Cars(rs.getInt("id"), rs.getString("name"), rs.getString("type"), rs.getInt("countseat"), rs.getInt("isactive"), rs.getString("licenseplate"));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("khong lay dc id");
        }
        return c;
    }

    public Cars getCarbyLicenseplate(String licenseplate) {
        Cars c = new Cars();
        String sql = "SELECT * FROM cars WHERE licenseplate = ?";

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, licenseplate);

            rs = ps.executeQuery();
            if (rs.next()) {
                return new Cars(rs.getInt("id"), rs.getString("name"), rs.getString("type"), rs.getInt("countseat"), rs.getInt("isactive"), rs.getString("licenseplate"));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("khong lay dc licenseplate");
        }
        return c;
    }

    public void updateCar(Cars car) {

        String sql = "UPDATE cars SET name = ?, type = ?, countseat = ?, isactive = ?, licenseplate = ? WHERE id = ?";

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, car.getName());
            ps.setString(2, car.getType());
            ps.setInt(3, car.getCountseat());
            ps.setInt(4, car.getIsactive());
            ps.setString(5, car.getLicenseplate());
            ps.setInt(6, car.getId());

            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error in updating car information");
        }
    }

    public void deleteCar(int id) {
        try {
            con = DBConnect.getConnection();
            // First, delete related records in the Seats table
            String deleteSeatsQuery = "DELETE FROM seats WHERE car_id = ?";
            PreparedStatement deleteSeatsStatement = con.prepareStatement(deleteSeatsQuery);
            deleteSeatsStatement.setInt(1, id);
            deleteSeatsStatement.executeUpdate();
            deleteSeatsStatement.close();

            // Then, delete the car from the Cars table
            String deleteCarQuery = "DELETE FROM cars WHERE id = ?";
            PreparedStatement deleteCarStatement = con.prepareStatement(deleteCarQuery);
            deleteCarStatement.setInt(1, id);
            deleteCarStatement.executeUpdate();
            deleteCarStatement.close();

            con.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("----------LOI Delete Car trong CarRepository------------");
        }

    }

    public ArrayList<Cars> searchCarByName(String car_name) {
        ArrayList<Cars> list = new ArrayList<>();
        String sql = "SELECT * FROM cars where name=?";

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);

            ps.setNString(1, car_name);

            rs = ps.executeQuery();
            while (rs.next()) {
                int idcar = rs.getInt(1);
                String namecar = rs.getString(2);
                String type = rs.getString(3);
                int countseat = rs.getInt(4);
                int isactive = rs.getInt(5);
                String licenseplate = rs.getString(6);
                Cars car = new Cars(idcar, namecar, type, countseat, isactive, licenseplate);
                list.add(car);
            }
            return list;
        } catch (Exception e) {
            System.err.println(e);
            System.out.println("Lỗi list trong car repo");
        }
        return null;
    }

    public static void main(String[] args) {
        CarRepository cr = new CarRepository();
//        System.out.println(cr.getListCars());

        String name = new String("Hoa Hieu");
        String type = new String("VIP");
        int countseat = 40;
        String licenseplate = new String("73A16699");
        String id = new String("1");
        Cars car = new Cars(name, type, countseat, licenseplate);
//        cr.InserCar(car);
//        Cars c = cr.getCar(id);
//        System.out.println(c);
//        System.out.println(cr.insertSeats(1, 1));
        System.out.println(cr.getCarbyLicenseplate(licenseplate));
    }
}

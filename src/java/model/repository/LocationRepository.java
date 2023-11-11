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

import model.entity.Locations;

/**
 *
 * @author s
 */
public class LocationRepository {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public ArrayList<Locations> getListLocations() {
        ArrayList<Locations> list = new ArrayList<>();
        String sql = "SELECT * FROM locations";

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                Locations l = new Locations(rs.getInt(1), rs.getNString(2));
                list.add(l);
            }
            return list;
        } catch (Exception e) {
            System.err.println(e);
            System.out.println("Lỗi list trong car repo");
        }
        return null;
    }

    public Locations getlocation(int id) {
        Locations c = new Locations();
        String sql = "SELECT * FROM locations WHERE id = ?";

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            if (rs.next()) {
                return new Locations(id, rs.getNString(2));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("khong lay dc id");
        }
        return c;
    }

    public static void main(String[] args) {
        LocationRepository lr = new LocationRepository();
        System.out.println(lr.getListLocations());
//        System.out.println(lr.getlocation(3).getProvince());
    }

}

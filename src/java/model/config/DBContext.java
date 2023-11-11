///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package model.config;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
///**
// *
// * @author tuna
// */
//public class DBContext {
//    public Connection getConnection() throws SQLException {
//        try {
//            Connection con = null;
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            String url = "jdbc:sqlserver://localhost:1433;databaseName=vh_express;encrypt=true;trustServerCertificate=true; user = sa; password = Tuna1.dev;";
//            con = DriverManager.getConnection(url);
//            return con;
//        } catch (ClassNotFoundException ex) {
//            ex.printStackTrace();
//        }
//        return null;
//    }
//
//    public static void main(String[] args) {
//        try {
//            System.out.println(new DBContext().getConnection());
//            System.out.println("Success");
//        } catch (Exception e) {
//            System.out.println("Failed");
//
//        }
//    }
//}

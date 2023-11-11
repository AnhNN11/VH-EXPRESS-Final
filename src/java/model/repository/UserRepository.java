/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.repository;

import dao.LoginDao;
import dao.RegisterDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.config.DBConnect;
import model.entity.SendingEmail;
import model.entity.Users;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author ADMIN
 */
public class UserRepository {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public String Register(RegisterDao rd) {
        String sql = "Insert into users(fullname, email, password, hashkey, authority) values (?, ?, ?, ?, ?)";

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            String name = rd.getFullname();
            String email = rd.getEmail();
            String pass = rd.getPassword();
            String hash = rd.getHash();
            String authority = rd.getAuthority();

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, pass);
            ps.setString(4, hash);
            ps.setString(5, authority);

            int i = ps.executeUpdate();
            if (i != 0) {
                SendingEmail se = new SendingEmail(email, hash);
                se.sendMail();
                return "SUCCESS";
            }
            ps.close();

        } catch (Exception e) {
            System.err.println("RegisterRepository File:: " + e);
        }
        return "error";
    }

    public boolean isEmailExists(String email) {
        String sql = "SELECT email FROM users WHERE email = ?";

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            return rs.next(); // Trả về true nếu email đã tồn tại, ngược lại trả về false
        } catch (Exception e) {
            System.err.println("Error checking email existence: " + e);
        }
        return false; // Trả về false nếu có lỗi xảy ra
    }

    public String login(LoginDao ld) {

        String email = ld.getEmail();
        String pass = ld.getPassword();
        String newPass = ld.getNewPass();

        String sql = "Select * from users where email = ? and password = ? and active = '1'";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, newPass);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("vao roi do");
                String auth = rs.getString("authority");
                if ("ROLE_MEMBER".equals(auth)) {
                    return "success_member";
                } else if ("ROLE_ADMIN".equals(auth)) {
                    return "success_admin";
                } else if ("ROLE_STAFF".equals(auth)) {
                    return "success_staff";
                }
            }
            rs.close();
            ps.close();

        } catch (Exception e) {
            System.out.println("khong nhan database");
        }

        return "error";
    }

    // Phương thức để lấy thông tin quyền của người dùng từ cơ sở dữ liệu
    public String getUserAuthority(String email) {
        String authority = null;
        String sql = "SELECT authority FROM users WHERE email = ?";

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                authority = rs.getString("authority");
            }

            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("khong lay dc email");
        }

        return authority;
    }

    public String getUserName(String email) {
        String fullname = null;
        String sql = "SELECT fullname FROM users WHERE email = ?";

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return fullname = rs.getString("fullname");
            }

            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("khong lay dc email");
        }
        return null;
    }

    public Users getUserByEmail(String email) {
        Users u = new Users();
        String sql = "SELECT * FROM users WHERE email = ?";

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, email);

            rs = ps.executeQuery();
            if (rs.next()) {
                return new Users(rs.getInt(1), email, rs.getString(2), rs.getString("age"), rs.getString("phone"), rs.getString("authority"), rs.getString("address"), rs.getString("gender"));
            }

            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("khong lay dc email");
        }
        return null;
    }

    public Users getUserById(int id) {
        Users u = new Users();
        String sql = "SELECT * FROM users WHERE id = ?";

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            if (rs.next()) {
                return new Users(rs.getInt(1), rs.getString("email"), rs.getString(2), rs.getString("age"), rs.getString("phone"), rs.getString("authority"), rs.getString("address"), rs.getString("gender"));
            }

            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR getUserById ");
        }
        return null;
    }

    public ArrayList<Users> getListUser() {
        ArrayList<Users> list = new ArrayList<>();
        String sql = "SELECT * FROM users";

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                int idUser = rs.getInt("id");
                String fullname = rs.getString("fullname");
                String email = rs.getString("email");
                String age = rs.getString("age");
                String phone = rs.getString("phone");
                String authority = rs.getString("authority");
                String address = rs.getString("address");
                String gender = rs.getString("gender");
                Users users = new Users(idUser, email, fullname, age, phone, authority, address, gender);
                list.add(users);
            }
            return list;
        } catch (Exception e) {
            System.err.println(e);
            System.out.println("Lỗi list trong User repo");
        }
        return null;
    }

    public ArrayList<Users> getListStaff() {
        ArrayList<Users> list = new ArrayList<>();
        String sql = "SELECT * FROM users";

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                int idUser = rs.getInt("id");
                String fullname = rs.getString("fullname");
                String email = rs.getString("email");
                String age = rs.getString("age");
                String phone = rs.getString("phone");
                String authority = rs.getString("authority");
                String address = rs.getString("address");
                String gender = rs.getString("gender");
                Users users = new Users(idUser, email, fullname, age, phone, authority, address, gender);
                list.add(users);
            }
            return list;
        } catch (Exception e) {
            System.err.println(e);
            System.out.println("Lỗi list trong User repo");
        }
        return null;
    }

    public ArrayList<Users> getListDriver() {
        ArrayList<Users> list = new ArrayList<>();
        String sql = "SELECT * FROM users where authority = 'ROLE_DRIVER'";

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                int idUser = rs.getInt("id");
                String fullname = rs.getString("fullname");
                String email = rs.getString("email");
                String age = rs.getString("age");
                String phone = rs.getString("phone");
                String authority = rs.getString("authority");
                String address = rs.getString("address");
                String gender = rs.getString("gender");
                Users users = new Users(idUser, email, fullname, age, phone, authority, address, gender);
                list.add(users);
            }
            return list;
        } catch (Exception e) {
            System.err.println(e);
            System.out.println("Lỗi list trong User repo");
        }
        return null;
    }

    public void insertStaff(Users u) {
        String sql = "INSERT INTO users (fullname, email, password, hashkey, active, age, phone, authority, address, gender) VALUES (?,?,'202cb962ac59075b964b07152d234b70','2b5d701cb0fee995eed93d7e1a851fe3',1,?,?,?,?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, u.getFullname());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getAge());
            ps.setString(4, u.getPhone());
            ps.setString(5, u.getAuthority());
            ps.setString(6, u.getAddress());
            ps.setString(7, u.getGender());

            int i = ps.executeUpdate();

            ps.close();

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("----------LOI DANG KY user trong userRepository------------");
        }
    }

    public void deleteUser(String id) {
        String sql = "DELETE FROM users WHERE id = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("----------LOI Delete User trong UserRepository------------");
        }
    }

    public Users getDriver(int id) {
        String sql = "SELECT * FROM users WHERE id = ? AND authority = 'ROLE_DRIVER'";

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);  // Set the ID parameter

            rs = ps.executeQuery();
            if (rs.next()) {
                int idUser = rs.getInt("id");
                String fullname = rs.getString("fullname");
                String email = rs.getString("email");
                String age = rs.getString("age");
                String phone = rs.getString("phone");
                String authority = rs.getString("authority");
                String address = rs.getString("address");
                String gender = rs.getString("gender");
                Users user = new Users(idUser, email, fullname, age, phone, authority, address, gender);
                return user;
            }
        } catch (Exception e) {
            System.err.println(e);
            System.out.println("Error in User repo");
        } finally {
            // Close database resources (con, ps, rs) in a 'finally' block
            // to ensure they are closed even in case of an exception.
            // Handle this properly in your code.
        }
        return null;
    }

    public ArrayList<Users> getAllDrivers() {

        ArrayList<Users> drivers = new ArrayList<>();
        String sql = "SELECT * FROM users WHERE authority = 'ROLE_DRIVER'";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                int idUser = rs.getInt("id");
                String fullname = rs.getString("fullname");
                String email = rs.getString("email");
                String age = rs.getString("age");
                String phone = rs.getString("phone");
                String authority = rs.getString("authority");
                String address = rs.getString("address");
                String gender = rs.getString("gender");
                Users user = new Users(idUser, email, fullname, age, phone, authority, address, gender);
                drivers.add(user);
            }
            return drivers;
        } catch (Exception e) {
            System.err.println(e);
            System.out.println("Error in User repo");
        } finally {
            // Close database resources (con, ps, rs) in a 'finally' block
            // to ensure they are closed even in case of an exception.
            // Handle this properly in your code.
        }
        return null;
    }

    public void updateUser(Users user) {
        String sql = "UPDATE users SET fullname = ?, age = ?, phone = ?, authority = ?, address = ?, gender = ? WHERE id = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, user.getFullname());
            ps.setString(2, user.getAge());
            ps.setString(3, user.getPhone());
            ps.setString(4, user.getAuthority());
            ps.setString(5, user.getAddress());
            ps.setString(6, user.getGender());
            ps.setInt(7, user.getId());

            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error in updating user information");
        }
    }

    public void editProfile(Users user) {
        String sql = "UPDATE users SET fullname = ?, age = ?, phone = ?, address = ?, gender = ? WHERE id = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, user.getFullname());
            ps.setString(2, user.getAge());
            ps.setString(3, user.getPhone());
            ps.setString(4, user.getAddress());
            ps.setString(5, user.getGender());
            ps.setInt(6, user.getId());

            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error Edit Profile");
        }
    }

    public static void main(String[] args) {
        UserRepository ur = new UserRepository();
        String fullname = new String("Nguyen Anh Tu");
        String email = new String("tranthib@example.com");
        String email1 = new String("nnguyenttu2@gmail.com");
        String age = new String("20");
        String phone = new String("0915215288");
        String authority = new String("ROLE_ADMIN");
        String gender = new String("MEMBER");
        String address = new String("90 Nguyen Thuc Tu");
        String pass = new String("123");
        String newPass = DigestUtils.md5Hex(pass);

//        String authority = new String("ROLE_MEMBER");
//        LoginDao ld = new LoginDao(email,pass);        
//        LoginDao ld = new LoginDao();
//        ld.setEmail(email);
//        ld.setNewPass(newPass);
//        System.out.println(newPass);
//        System.out.println(ur.login(ld));
//        RegisterDao rd = new RegisterDao(fullname, email1, pass, authority);
//        System.out.println(ur.Register(rd));
//        System.out.println("123" + ur.Register(rd));
//        System.out.println(ur.getUserName(email));
//        System.out.println(ur.getListUser());
//        Users u = new Users(fullname, email, age, phone, authority, address, gender);
//        ur.insertStaff(u);
//        System.out.println(ur.getListDriver());
//        int id = 12;
//        System.out.println(ur.deleteUser(id));
//        System.out.println(ur.getUser(email));
//        System.out.println(ur.getUserById("2"));
    }

}

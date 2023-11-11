/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

/**
 *
 * @author ADMIN
 */
public class Users {
    
    private int id, active;
    
    private String email, password, fullname, age, phone, authority, address, gender;

    public Users() {
    }

    public Users(String email, String fullname, String age, String phone, String authority, String address, String gender) {
        this.email = email;
        this.fullname = fullname;
        this.age = age;
        this.phone = phone;
        this.authority = authority;
        this.address = address;
        this.gender = gender;
    }

    public Users(int id, String fullname, String age, String phone, String address, String gender) {
        this.id = id;
        this.fullname = fullname;
        this.age = age;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
    }
    
    
    public Users(int id, int active, String email, String password, String fullname, String age, String phone, String authority, String address, String gender) {
        this.id = id;
        this.active = active;
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.age = age;
        this.phone = phone;
        this.authority = authority;
        this.address = address;
        this.gender = gender;
    }

    public Users(int id, int active, String password, String fullname, String age, String phone, String authority, String address, String gender) {
        this.id = id;
        this.active = active;
        this.password = password;
        this.fullname = fullname;
        this.age = age;
        this.phone = phone;
        this.authority = authority;
        this.address = address;
        this.gender = gender;
    }
    
    public Users(int id, String fullname, String age, String phone, String authority, String address, String gender) {
        this.id = id;
        this.fullname = fullname;
        this.age = age;
        this.phone = phone;
        this.authority = authority;
        this.address = address;
        this.gender = gender;
    }
    
    

    public Users(int id, String email, String fullname, String age, String phone, String authority, String address, String gender) {
        this.id = id;
        this.email = email;
        this.fullname = fullname;
        this.age = age;
        this.phone = phone;
        this.authority = authority;
        this.address = address;
        this.gender = gender;
    }

    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Users{" + "id=" + id + ", active=" + active + ", email=" + email + ", password=" + password + ", fullname=" + fullname + ", age=" + age + ", phone=" + phone + ", authority=" + authority + ", address=" + address + ", gender=" + gender + '}';
    }
    
    
}

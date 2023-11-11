/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Random;
import model.entity.Authority;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author ADMIN
 */
public class RegisterDao {

    private String fullname;
    private String email;
    private String password;
    private String hash;
    private String authority;

    public RegisterDao(String fullname, String email, String password, String authority) {
        this.fullname = fullname;
        this.email = email;
        this.password = DigestUtils.md5Hex(password);
        Random rand = new Random();
        rand.nextInt(999999);
        this.hash = DigestUtils.md5Hex("" + rand);
        this.authority = authority;
    }

    public RegisterDao() {
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

}

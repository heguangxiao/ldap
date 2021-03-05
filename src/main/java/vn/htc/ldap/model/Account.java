/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.htc.ldap.model;

import java.io.Serializable;

/**
 *
 * @author HTC-PC
 */
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private int id;
    private String username;
    private String password;
    private String email;
    private int status;
    private String code;
    private String fullname;

    public Account() {
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Account(int id, String username, String password, String email, int status, String code, String fullname) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.status = status;
        this.code = code;
        this.fullname = fullname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    
    public static void formatStringNull(Account acc) {
        if (acc.getCode() == null) {
            acc.setCode("");
        }
        if (acc.getEmail() == null) {
            acc.setEmail("");
        }
        if (acc.getFullname() == null) {
            acc.setFullname("");
        }
        if (acc.getPassword() == null) {
            acc.setPassword("");
        }
        if (acc.getUsername() == null) {
            acc.setUsername("");
        }
    }

}

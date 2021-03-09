/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.htc.ldap.repository.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import vn.htc.ldap.common.Md5;
import vn.htc.ldap.common.Tool;
import vn.htc.ldap.model.Account;
import vn.htc.ldap.repository.AccountRepository;

/**
 *
 * @author HTC-PC
 */
@Repository
public class AccountRepositoryImpl implements AccountRepository {

    private List<Account> listGia = new ArrayList<>();

    @PostConstruct
    public void init() {
        for (int i = 0; i < 10; i++) {
            Account acc = new Account(i + 1, "username" + i, Md5.encryptMD5("password" + i), "email" + i, 1, i + 1 + "", "full name " + (i + 1));
            listGia.add(acc);
        }
        Account acc = new Account(11, "hieuhq", Md5.encryptMD5("Acmalinh1@"), "heguangxiao@gmail.com", 1, "HQH", "Hà Quang Hiếu");
        listGia.add(acc);
    }

    @Override
    public List<Account> findAll() {
        List<Account> result = new ArrayList<>();
        try {
            if (!listGia.isEmpty()) {
                for (Account one : listGia) {
                    if (one != null) {
                        result.add(one);
                    }
                }
            }
        } catch (Exception e) {
            Tool.showError("findAll()", "AccountRepositoryImpl", e.getMessage());
        }
        return result;
    }

    @Override
    public Account findById(int id) {
        Account result = null;
        try {
            if (!listGia.isEmpty()) {
                for (Account one : listGia) {
                    if (one != null) {
                        if (id == one.getId()) {
                            result = one;
                            break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            Tool.showError("findById(int id)", "AccountRepositoryImpl", e.getMessage());
        }
        return result;
    }

    @Override
    public boolean create(Account t) {
        boolean result = false;
        try {
            t.setId(getNewId());
            listGia.add(t);
            result = true;
        } catch (Exception e) {
            Tool.showError("create(Account t)", "AccountRepositoryImpl", e.getMessage());
        }
        return result;
    }

    @Override
    public boolean update(Account t) {
        boolean result = false;
        try {
            List<Account> all = findAll();
            if (!all.isEmpty()) {
                listGia.clear();
                for (Account one : all) {
                    if (one != null) {
                        if (t.getId() == one.getId()) {
                            listGia.add(t);
                            result = true;
                        } else {
                            listGia.add(one);
                        }
                    }
                }
            }
        } catch (Exception e) {
            Tool.showError("update(Account t)", "AccountRepositoryImpl", e.getMessage());
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        try {
            List<Account> all = findAll();
            if (!all.isEmpty()) {
                listGia.clear();
                for (Account one : all) {
                    if (one != null) {
                        if (id != one.getId()) {
                            listGia.add(one);
                        } else {
                            result = true;
                        }
                    }
                }
            }
        } catch (Exception e) {
            Tool.showError("delete(int id)", "AccountRepositoryImpl", e.getMessage());
        }
        return result;
    }

    private int getNewId() {
        int result = -1;
        try {
            if (!listGia.isEmpty()) {
                for (Account one : listGia) {
                    if (one != null) {
                        if (result < one.getId()) {
                            result = one.getId();
                        }
                    }
                }
            }
        } catch (Exception e) {
            Tool.showError("getNewId()", "AccountRepositoryImpl", e.getMessage());
        }
        return (result + 1);
    }

    @Override
    public Account findByUsernameAndPassword(String username, String password) {
        Account result = null;
        try {
            if (!listGia.isEmpty()) {
                for (Account one : listGia) {
                    if (one != null) {
                        if (username.equals(one.getUsername())) {
                            String pass = Md5.encryptMD5(password);
                            if (pass.equals(one.getPassword())) {
                                result = one;
                            }
                            break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            Tool.showError("findById(int id)", "AccountRepositoryImpl", e.getMessage());
        }
        return result;
    }

}

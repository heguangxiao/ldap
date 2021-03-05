/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.htc.ldap.service.impl;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.htc.ldap.common.Tool;
import vn.htc.ldap.config.MyConfig;
import vn.htc.ldap.model.Account;
import vn.htc.ldap.repository.AccountRepository;
import vn.htc.ldap.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account findById(int id) {
        return accountRepository.findById(id);
    }

    @Override
    public boolean create(Account t) {
        return accountRepository.create(t);
    }

    @Override
    public boolean update(Account t) {
        return accountRepository.update(t);
    }

    @Override
    public boolean delete(int id) {
        return accountRepository.delete(id);
    }

    @Override
    public Account getAccountLogin(HttpServletRequest request) {
        Account acc = null;
        try {
            HttpSession session = request.getSession(false);
            acc = (Account) session.getAttribute(MyConfig.USER_SESSION_NAME);
        } catch (Exception e) {
            Tool.showError("getAccountLogin(HttpServletRequest request)", "AccountServiceImpl", e.getMessage());
        }
        return acc;
    }

    @Override
    public Account findByUsernameAndPassword(String username, String password) {
        return accountRepository.findByUsernameAndPassword(username, password);
    }

}

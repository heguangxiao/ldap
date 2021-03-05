/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.htc.ldap.service;

import javax.servlet.http.HttpServletRequest;
import vn.htc.ldap.model.Account;

/**
 *
 * @author HTC-PC
 */
public interface AccountService extends BaseService<Account> {

    public Account getAccountLogin(HttpServletRequest request);

    Account findByUsernameAndPassword(String username, String password);
}

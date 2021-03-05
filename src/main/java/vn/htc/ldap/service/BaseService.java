/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.htc.ldap.service;

import java.util.List;

public interface BaseService<T> {
    List<T> findAll();
    T findById(int id);
    boolean create(T t);
    boolean update(T t);
    boolean delete(int id);
}

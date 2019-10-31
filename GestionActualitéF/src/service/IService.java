/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;

/**
 *
 * @author ASUS
 */
public interface IService <T>{
    void insert(T t);
    List<T> readAll();
    T readById(int id);
    void delete (T t);
    void update(T t,int id);
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.repository;

import com.fpt.pojo.User;
import java.util.List;

/**
 *
 * @author quant
 */
public interface UserRepository {

    User getUserById(int userId);
    
    boolean addUser(User user);

    List<User> getUsers(String username);
}

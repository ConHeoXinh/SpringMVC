/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.service.impl;

import com.fpt.pojo.Cart;
import com.fpt.repository.OrderRepository;
import com.fpt.service.OrderService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author quant
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public boolean addReceipt(Map<Integer, Cart> cart) {

        if (cart != null) {
            return this.orderRepository.addReceipt(cart);
        }
        return false;
    }

}

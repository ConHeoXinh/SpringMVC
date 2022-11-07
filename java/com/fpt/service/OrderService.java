/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.service;

import com.fpt.pojo.Cart;
import java.util.Map;

/**
 *
 * @author quant
 */
public interface OrderService {
    boolean addReceipt(Map<Integer, Cart> cart);
}

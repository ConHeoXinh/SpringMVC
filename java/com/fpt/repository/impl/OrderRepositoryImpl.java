/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.repository.impl;

import com.fpt.pojo.Cart;
import com.fpt.pojo.OrderDetail;
import com.fpt.pojo.SaleOrder;
import com.fpt.repository.OrderRepository;
import com.fpt.repository.ProductRepository;
import com.fpt.repository.UserRepository;
import com.fpt.utils.Utils;
import java.util.Date;
import java.util.Map;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author quant
 */
@Repository
@Transactional(propagation = Propagation.REQUIRED)// khi giao tac thuc hien luu nhieu thao tac co moi quan he cha con
public class OrderRepositoryImpl implements OrderRepository {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public boolean addReceipt(Map<Integer, Cart> cart) {

        try {
            Session session = this.sessionFactory.getObject().getCurrentSession();
            SaleOrder order = new SaleOrder();
            order.setUserId(this.userRepository.getUserById(6));
            order.setCreatedDate(new Date());

            Map<String, String> stats = Utils.cartStats(cart);
            order.setAmount(Long.parseLong(stats.get("amount")));

            session.save(order);

            for (Cart c : cart.values()) {
                OrderDetail d = new OrderDetail();
                d.setOrderId(order);
                d.setProduct(this.productRepository.getProductById(c.getProductId()));
                d.setUnitPrice(c.getPrice());
                d.setNum(c.getQuantity());

                session.save(d);
            }
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return false;
    }

}

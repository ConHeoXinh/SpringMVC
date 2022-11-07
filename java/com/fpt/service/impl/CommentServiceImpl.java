/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.service.impl;

import com.fpt.pojo.Comment;
import com.fpt.pojo.Product;
import com.fpt.pojo.User;
import com.fpt.repository.CommentRepository;
import com.fpt.repository.ProductRepository;
import com.fpt.repository.UserRepository;
import com.fpt.service.CommentService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author quant
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment adddComment(String content, int productId, User creator) {
        Product p = this.productRepository.getProductById(productId);

//        User u = this.userRepository.getUserById(creator);

        Comment c = new Comment();
        c.setContent(content);
        c.setProduct(p);
        c.setUserId(creator);
        c.setCreateDate(new Date());

        return this.commentRepository.addComment(c);
    }

}

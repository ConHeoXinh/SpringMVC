/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.service;

import com.fpt.pojo.Comment;
import com.fpt.pojo.User;

/**
 *
 * @author quant
 */
public interface CommentService {
    Comment adddComment(String content, int productId, User creator);
}

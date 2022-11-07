/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.controller;

import com.fpt.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author quant
 */
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;
    
    @GetMapping("/products/{productId}")
    public String detail(Model model, @PathVariable(value = "productId") int productId) {
        model.addAttribute("product", this.productService.getProductById(productId));
        
        return "product-detail";
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.controller;

import com.fpt.pojo.Cart;
import com.fpt.pojo.Category;
import com.fpt.service.CategoryService;
import com.fpt.service.ProductService;
import com.fpt.utils.Utils;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author quant
 */
@Controller
@ControllerAdvice
public class HomeController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;

    @ModelAttribute
    public void commonAttrs(Model model, HttpSession session) {
        model.addAttribute("categories", this.categoryService.getCategories());
        model.addAttribute("cartCounter", Utils.countCart((Map<Integer, Cart>) session.getAttribute("cart")));
        model.addAttribute("currentUser", session.getAttribute("currentUser"));
    }

    @GetMapping("/")
    public String index(Model model, @RequestParam(required = false) Map<String, String> params,
      HttpSession session) {
        String kw = params.getOrDefault("kw", null);
        int page = Integer.parseInt(params.getOrDefault("page", "1"));

        String cateId = params.get("CatedId");

        if (cateId == null) {
            model.addAttribute("products", this.productService.getProducts(kw, page));
        } else {
            Category c = this.categoryService.getCategoryById(Integer.parseInt(cateId));
            model.addAttribute("products", c.getProductCollection());
        }

        model.addAttribute("productCounter", this.productService.countProduct());

        model.addAttribute("hotProducts", this.productService.getHotProducts(3));

        model.addAttribute("disProducts", this.productService.getMostDisccusProducts(3));

        return "index";
    }
}

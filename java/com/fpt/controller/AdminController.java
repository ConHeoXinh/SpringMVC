/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.controller;

import com.fpt.service.StatsService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author quant
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private StatsService statsService;

    @GetMapping("/category-stats")
    public String cateStats(Model model) {
        model.addAttribute("cateStats", this.statsService.cateStats());
        return "category-stats";
    }

    @GetMapping("product-stats")
    public String productStats(Model model, @RequestParam(required = false) Map<String, String> params) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String kw = params.getOrDefault("kw", null);
        Date fromDate = null, toDate = null;

        try {
            String from = params.getOrDefault("fromDate", null);
            if (from != null) {
                fromDate = sdf.parse(from);
            }
            
            String to = params.getOrDefault("toDate", null);
            if (to != null) {
                toDate = sdf.parse(to);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        model.addAttribute("productStats", this.statsService.productStats(kw, fromDate, toDate));
        return "product-stats";
    }
    
    @GetMapping("product-month-stats")
    public String productMonthStats(Model model,  @RequestParam(required = false) Map<String, String> params){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String kw = params.getOrDefault("kw", null);
        Date fromDate = null, toDate = null;

        try {
            String from = params.getOrDefault("fromDate", null);
            if (from != null) {
                fromDate = sdf.parse(from);
            }
            
            String to = params.getOrDefault("toDate", null);
            if (to != null) {
                toDate = sdf.parse(to);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        model.addAttribute("productMonthStats", this.statsService.productMonthStats(kw, fromDate, toDate));
        return "product-month-stats";
    }
}

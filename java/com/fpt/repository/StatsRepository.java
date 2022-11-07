/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.repository;

import java.util.Date;
import java.util.List;

/**
 *
 * @author quant
 */
public interface StatsRepository {
    
    List<Object[]> cateStats(); 
    
    List<Object[]> productStats(String kw, Date formDate, Date toDate);
    
    List<Object[]> productMonthStats(String kw, Date formDate, Date toDate);
}

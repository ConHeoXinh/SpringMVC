/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.repository;

import com.fpt.pojo.Product;
import java.util.List;

/**
 *
 * @author quant
 */
public interface ProductRepository {

    List<Product> getProducts(String kw, int page);
    
    List<Object[]> getHotProducts(int num);
    
    List<Object[]> getMostDisccusProducts(int num);

    Product getProductById(int productId);

    long countProduct();

    Boolean addOrUpdate(Product product);
}

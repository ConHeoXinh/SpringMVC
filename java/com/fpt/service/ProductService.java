/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.service;

import com.fpt.pojo.Product;
import java.util.List;

/**
 *
 * @author quant
 */
public interface ProductService {

    List<Product> getProducts(String kw, int page);

    List<Object[]> getHotProducts(int num);

    List<Object[]> getMostDisccusProducts(int num);

    long countProduct();

    Boolean addOrUpdate(Product product);

    Product getProductById(int productId);
}

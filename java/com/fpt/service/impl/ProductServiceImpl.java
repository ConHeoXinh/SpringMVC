/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.fpt.pojo.Product;
import com.fpt.repository.ProductRepository;
import com.fpt.service.ProductService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author quant
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getProducts(String kw, int page) {
        return this.productRepository.getProducts(kw, page);
    }

    @Override
    public Boolean addOrUpdate(Product product) {

//        try {
//            Map r = this.cloudinary.uploader().upload(product.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
//
//            product.setImage((String) r.get("secure_url"));
//
//            return this.productRepository.addOrUpdate(product);
//        } catch (IOException ex) {
//            System.err.println("== ADD PRoduct ==" + ex.getMessage());
//        }
        return false;
    }

    @Override
    public long countProduct() {
        return this.productRepository.countProduct();
    }

    @Override
    public Product getProductById(int productId) {
        return this.productRepository.getProductById(productId);
    }

    @Override
    public List<Object[]> getHotProducts(int num) {

        return this.productRepository.getHotProducts(num);
    }

    @Override
    public List<Object[]> getMostDisccusProducts(int i) {
        return this.productRepository.getMostDisccusProducts(i);
    }
}

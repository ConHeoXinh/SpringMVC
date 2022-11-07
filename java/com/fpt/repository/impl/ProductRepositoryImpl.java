/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.repository.impl;

import com.fpt.pojo.Comment;
import com.fpt.pojo.OrderDetail;
import com.fpt.pojo.Product;
import com.fpt.repository.ProductRepository;
import java.util.List;
import javax.persistence.Transient;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author quant
 */
@Repository
@Transactional
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Product> getProducts(String kw, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Product> query = builder.createQuery(Product.class);
        Root root = query.from(Product.class);
        query = query.select(root);

        if (kw != null) {
            Predicate p = builder.like(root.get("name").as(String.class), String.format("%%%s%%", kw));
            query = query.where(p);
        }

        query = query.orderBy(builder.desc(root.get("id")));

        Query q = session.createQuery(query);

        // phan trang
        int maxItem = 6;

        q.setMaxResults(maxItem);
        q.setFirstResult((page - 1) * maxItem);

        return q.getResultList();
    }

    ;

    @Override
    public Boolean addOrUpdate(Product product) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        try {
            session.save(product);
            return true;
        } catch (Exception e) {
            System.out.println("== ADD product==" + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public long countProduct() {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        Query q = session.createQuery("Select Count(*) From Product");

        return Long.parseLong(q.getSingleResult().toString());
    }

    @Override
    public Product getProductById(int productId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Product.class, productId);
    }

    @Override
    public List<Object[]> getHotProducts(int num) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        Root rootP = query.from(Product.class);
        Root rootD = query.from(OrderDetail.class);

        query = query.where(builder.equal(rootD.get("product"), rootP.get("id")));
        query.multiselect(rootP.get("id"), rootP.get("name"), rootP.get("price"), rootP.get("image"), builder.count(rootP.get("id")));

        query = query.groupBy(rootP.get("id"));
        query = query.orderBy(builder.desc(builder.count(rootP.get("id"))));

        Query q = session.createQuery(query);
        q.setMaxResults(num);

        return q.getResultList();
    }

    @Override
    public List<Object[]> getMostDisccusProducts(int num) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        Root rootP = query.from(Product.class);
        Root rootC = query.from(Comment.class);

        query = query.where(builder.equal(rootC.get("product"), rootP.get("id")));
        query.multiselect(rootP.get("id"), rootP.get("name"), rootP.get("price"), rootP.get("image"), builder.count(rootP.get("id")));

        query = query.groupBy(rootP.get("id"));
        query = query.orderBy(builder.desc(builder.count(rootP.get("id"))),
          builder.desc(rootP.get("id")));

        Query q = session.createQuery(query);
        q.setMaxResults(num);

        return q.getResultList();

    }

}

package com.example.son.SpringMVC.dao.impl;

import com.example.son.SpringMVC.dao.ProductDAO;
import com.example.son.SpringMVC.entity.Product;
import com.example.son.SpringMVC.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoImpl extends JPARepository<Product>  implements ProductDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        CriteriaBuilder builder  = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> criteriaQuery = builder.createQuery(Product.class);
        Root<Product> root = criteriaQuery.from(Product.class);
        criteriaQuery.select(root);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public Product findById(Integer id) {
        return entityManager.find(Product.class, id);
    }
}

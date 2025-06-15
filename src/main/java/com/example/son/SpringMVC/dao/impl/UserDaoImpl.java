package com.example.son.SpringMVC.dao.impl;

import com.example.son.SpringMVC.dao.UserDAO;
import com.example.son.SpringMVC.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl extends JPARepository<User> implements UserDAO  {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> findAll() {
        CriteriaBuilder builder  = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public User findById(int id) {
        return entityManager.find(User.class, id);
    }
}

package com.example.son.SpringMVC.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public abstract class JPARepository<T> {

    @PersistenceContext
    protected EntityManager entityManager;

    public void add(T t) {
        entityManager.persist(t);
    }

    public void update(T t) {
        entityManager.merge(t);
    }

    public void delete(T t) {
        entityManager.remove(t);
    }
}

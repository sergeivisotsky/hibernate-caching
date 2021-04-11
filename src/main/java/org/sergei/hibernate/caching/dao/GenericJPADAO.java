package org.sergei.hibernate.caching.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Sergei Visotsky
 * @since 1.0
 */
@Transactional
@SuppressWarnings("unchecked")
public abstract class GenericJPADAO<T, ID extends Serializable> implements GenericDAO<T, ID> {

    private Class<T> persistenceClass;

    private EntityManager entityManager;

    public Class<T> getPersistenceClass() {
        return persistenceClass;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public GenericJPADAO(Class<T> persistenceClass) {
        this.persistenceClass = persistenceClass;
    }

    @Override
    public List<T> findAll() {
        return getEntityManager().createQuery("select x from " + getPersistenceClass().getSimpleName() + " x").getResultList();
    }

    @Override
    public T findById(ID id) {
        return getEntityManager().find(getPersistenceClass(), id);
    }

    @Override
    public T save(T entity) {
        getEntityManager().persist(entity);
        return entity;
    }

    @Override
    public T update(T entity) {
        return getEntityManager().merge(entity);
    }

    @Autowired
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}

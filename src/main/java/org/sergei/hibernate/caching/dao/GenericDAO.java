package org.sergei.hibernate.caching.dao;

import java.util.List;

/**
 * @author Sergei Visotsky
 * @since 1.0
 */
public interface GenericDAO<E, T> {
    List<E> findAll();

    E findById(T id);

    E save(E entity);

    E update(E entity);
}

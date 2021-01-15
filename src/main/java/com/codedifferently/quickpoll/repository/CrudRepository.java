package com.codedifferently.quickpoll.repository;

import com.codedifferently.quickpoll.domain.Poll;
import org.springframework.data.repository.Repository;

import java.io.Serializable;


public interface CrudRepository <T, ID extends Serializable> extends Repository<T, ID> {

    //Create and Update methods
    <S extends T> S save(S entity);
    <S extends T> Iterable<S> save(Iterable<S> entities);

    //Finder methods
    Poll findOne(ID id);
    Iterable<Poll> findAll();
    Iterable<T> findAll(Iterable<ID> ids);

    // Delete Methods
    void delete(ID id);
    void delete(T entity);
    void delete(Iterable<? extends T> entities);
    void deleteAll();

    // Utility Methods
    long count();
    boolean exists(ID id);

}

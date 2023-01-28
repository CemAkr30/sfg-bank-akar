package ca.springframework.sfgbankakar.services;

import org.springframework.stereotype.Component;

import java.util.Set;

public interface Crudservice<T,ID> {

    Set<T> findAll();

    T findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);

    void deleteAll();

//    T print();
}

package ca.springframework.sfgbankakar.services;

import java.util.Set;

public interface Crudservice<T,ID> {

    Set<T> findAll();

    T findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);

//    T print();
}

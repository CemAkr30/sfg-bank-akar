package ca.springframework.sfgbankakar.services.map;

import java.util.*;

public abstract class AbstractMapService<T,ID> {

    protected Map<ID,T> map = new HashMap<>();

    Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    T findById(ID id){
        return map.get(id);
    }

    T save(ID id,T object){
        map.put(id,object);
        return object;
    }

    void deleteById(ID id){
        map.remove(id);
    }

    void delete(T object){
        map.entrySet().removeIf(idtEntry -> idtEntry.getValue().equals(object));
    }

//    T print(){
////        for (Map.Entry<ID, T> entry : map.entrySet()) {
////            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
////        }
//        return (T) map.entrySet().iterator().next();
//    }
}

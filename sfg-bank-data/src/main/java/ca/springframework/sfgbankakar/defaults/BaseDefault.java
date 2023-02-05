package ca.springframework.sfgbankakar.defaults;

import java.util.List;
import java.util.Set;

public class BaseDefault {


     public final static <T> boolean checkNull(T value){
        if(value == null){
            return true;
        }
        return false;
    }

    public final static <T> boolean isNotEmptyList(List<T> list){
         if(list.isEmpty()){
             return false;
         }
         return true;
    }

    public  final static <T> boolean isEmptyList(List<T> list){
        if(!list.isEmpty()){
            return false;
        }
        return true;
    }


    public final static <T> boolean isNotEmptySet(Set<T> list){
        if(list.isEmpty()){
            return false;
        }
        return true;
    }

    final static <T> boolean isEmptySet(Set<T> list){
        if(!list.isEmpty()){
            return false;
        }
        return true;
    }
}

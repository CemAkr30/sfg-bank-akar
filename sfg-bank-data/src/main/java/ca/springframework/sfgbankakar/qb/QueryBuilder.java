package ca.springframework.sfgbankakar.qb;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class QueryBuilder<T> {


    private Map<String,String> tableAndAlias = new HashMap<>();


    public QueryBuilder createBuilderQuery(T table,String alias){
        tableAndAlias.put(table.getClass().getSimpleName(),alias);
        return this;
    }
//
//    public QueryBuilder join()

}

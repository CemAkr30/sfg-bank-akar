package ca.springframework.sfgbankakar.daoNativeQuery;

import ca.springframework.sfgbankakar.enums.AggerationFunction;
import ca.springframework.sfgbankakar.enums.JoinType;
import ca.springframework.sfgbankakar.enums.Operator;
import ca.springframework.sfgbankakar.enums.OrderType;
import ca.springframework.sfgbankakar.model.BaseEntity;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class QueryBuilder<T extends BaseEntity> {

    private  EntityManager entityManager;

    public  EntityManager getEntityManager() {
        return entityManager;
    }

    private  String query= "";
    private  String whereClause= "";
    private  String orderByClause= "";
    private  String groupByClause= "";
    private  String havingClause= "";
    private  String selectClause = "SELECT ";

    private boolean isSelect = false;
    private  String fromClause= "" ;
    private  String joinClause= "";

    private  String unionClause= "";

    private Integer paramCount = 0;

    private Integer paramUnionCount = 0;

    private Map<Integer,Map<String,Object>> parameters = new HashMap<>();

    private Map<Integer,String> unionAllMap = new HashMap<>();

    public QueryBuilder setEntityManager(EntityManager em){
        entityManager = em;
        return this;
    }

    public QueryBuilder createQueryFrom(Class<?> clazz, String alias) {
        fromClause += " FROM " + clazz.getSimpleName() + " " + alias;
        return this;
    }

    public QueryBuilder select(String... fields) {
        for (String field : fields) {
            selectClause += field + ",";
        }
        if(isSelect) {
            selectClause = "," + selectClause.substring(0, selectClause.length() - 1);
        }else{
            selectClause = selectClause.substring(0, selectClause.length() - 1);
        }
        isSelect=true;
        return this;
    }

    public QueryBuilder selectJpql(String jpql) {
        if(isSelect) {
            selectClause += "," + jpql;
        }else{
            selectClause += jpql;
        }
        isSelect=true;
        return this;
    }

    public QueryBuilder selectFunction(AggerationFunction aggerationFunction, String field) {
        if(isSelect) {
            selectClause += "," + aggerationFunction.getAdi() + "(" + field + ")";
        }else{
            selectClause += aggerationFunction.getAdi() + "(" + field + ")";
        }
        isSelect=true;
        return this;
    }

    public QueryBuilder selectSubQuery(QueryBuilder subQuery) {
        if(isSelect) {
            selectClause += ", ( " + subQuery.getQueryAsString() + " ) ";
        }else{
            selectClause += " ( " +  subQuery + " ) ";
        }
        isSelect=true;
        return this;
    }

    public  QueryBuilder where(String field, Operator operator, Object value) {
        if(!" WHERE ".equals(whereClause)) {
            whereClause = " WHERE " + field + " " + operator.getAdi() + " " + value;
            return this;
        }
        whereClause = " AND " + field + " " + operator.getAdi() + " " + value;
        return this;
    }

    public  QueryBuilder whereOr(String field, Operator operator, Object value) {
        if(!" WHERE ".equals(whereClause)) {
            whereClause = " WHERE " + field + " " + operator.getAdi() + " " + value;
            return this;
        }
        whereClause = " OR " + field + " " + operator.getAdi() + " " + value;
        return this;
    }

    public  QueryBuilder whereJpql(String jpql) {
        if(!" WHERE ".equals(whereClause)) {
            whereClause = " WHERE " + jpql;
            return this;
        }
        whereClause = " AND " + jpql;
        return this;
    }

    public  QueryBuilder groupBy(String... fields) {
        groupByClause = " GROUP BY ";
        for (String field : fields) {
            groupByClause += field + ",";
        }
        groupByClause = groupByClause.substring(0, groupByClause.length() - 1);
        return this;
    }


    public  QueryBuilder orderBy(OrderType type, String... fields) {
        orderByClause = " ORDER BY ";
        for (String field : fields) {
            orderByClause += field + ",";
        }
        orderByClause = orderByClause.substring(0, orderByClause.length() - 1);
        orderByClause += " " + type.getAdi();
        return this;
    }

    public  QueryBuilder havingFunction(AggerationFunction aggerationFunction,String limitations) {
        havingClause = " HAVING "+ aggerationFunction.getAdi() +"(*)" + limitations;
        return this;
    }

    public  QueryBuilder havingFunctionAndOperator(AggerationFunction aggerationFunction, Operator operator, String havingJpql,String limitations) {
        havingClause = " HAVING "+ aggerationFunction.getAdi() +"("+havingJpql+") " + operator.getAdi() + limitations ;
        return this;
    }

    public  QueryBuilder join(Class<?> clazz, String alias, String conditions , JoinType joinType) {
        fromClause+=" "+joinType.getAdi()+" "+clazz.getSimpleName()+" "+alias+" ON "+conditions;
        return this;
    }

    public  QueryBuilder unionAll(QueryBuilder queryBuilder) {
        unionAllMap.put(paramUnionCount," UNION ALL " +queryBuilder.getQueryAsString());
        return this;
    }


    private  String getQuery() {
        query = selectClause + fromClause + whereClause + groupByClause + havingClause + orderByClause;
        for (int k=0;k<parameters.size();k++) {
            Map<String,Object> map = parameters.get(k+1);
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                query = query.replace(":"+entry.getKey(),entry.getValue().toString());
            }
        }
        for (int k=0;k<unionAllMap.size();k++) {
            query += unionAllMap.get(k);
        }
         return query;
    }


    public  Query createClassQuery(Class<?> clazz) {
        return getEntityManager().createQuery(getQuery(), clazz);
    }

    public  Query createNativeQuery() {
        return getEntityManager().createQuery(getQuery());
    }


    public  QueryBuilder addExtraParam(String param,Object value) {
        Map<String,Object> map = new HashMap<>();
        map.put(param,value);
        paramCount++;
        parameters.put(paramCount, map);
        return this;
    }

    public  List<Object> getResultList() {
        return createNativeQuery().getResultList();
    }

    public  <T> List<T> getResultClassList(Class<T> clazz) {
        return  createClassQuery(clazz).getResultList();
    }

    public  int getMaxResult() {
        return createNativeQuery().getMaxResults();
    }

    public  Object getFirstDefaultResult() {
        return createNativeQuery().getSingleResult();
    }


    public   <T> T  getFirstClassResult(Class<?> clazz) {
        return (T) createNativeQuery().getSingleResult();
    }

    public String getQueryAsString() {
        return getQuery();
    }

}

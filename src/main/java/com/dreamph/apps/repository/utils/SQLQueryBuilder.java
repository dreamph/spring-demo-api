package com.dreamph.apps.repository.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SQLQueryBuilder {

    private String select;
    private SQLCriteriaBuilder sqlCriteriaBuilder;

    public String toSQLQuery() throws Exception {
        return select + " " + sqlCriteriaBuilder.getSql().toString();
    }

    public static String toQuery(String select, SQLCriteriaBuilder sqlCriteriaBuilder) throws Exception {
        return select + " " + sqlCriteriaBuilder.getSql().toString();
    }
}

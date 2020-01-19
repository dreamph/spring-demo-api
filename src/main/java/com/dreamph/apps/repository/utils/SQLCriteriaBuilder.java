package com.dreamph.apps.repository.utils;

import lombok.Data;
import org.apache.commons.io.IOUtils;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

@Data
public class SQLCriteriaBuilder {
    private MapSqlParameterSource parameters;
    private StringBuilder sql;

    public SQLCriteriaBuilder() {
        parameters = new MapSqlParameterSource();
        sql = new StringBuilder();
    }

    public SQLCriteriaBuilder addQuery(String sqlString, SQLParameter... sqlParameters) throws Exception {
        sql.append(" ").append(sqlString).append(" ").append(IOUtils.LINE_SEPARATOR);
        for (SQLParameter parameter : sqlParameters) {
            parameters.addValue(parameter.getKey(), parameter.getValue());
        }
        return this;
    }

    public SQLCriteriaBuilder addQuery(String sqlString) throws Exception {
        sql.append(" ").append(sqlString).append(" ").append(IOUtils.LINE_SEPARATOR);
        return this;
    }

    public SQLCriteriaBuilder addParam(SQLParameter sqlParameter) throws Exception {
        parameters.addValue(sqlParameter.getKey(), sqlParameter.getValue());
        return this;
    }

    public SQLCriteriaBuilder addParam(String key, Object value) throws Exception {
        parameters.addValue(key, value);
        return this;
    }


}

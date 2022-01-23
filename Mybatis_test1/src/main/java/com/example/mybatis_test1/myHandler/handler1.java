package com.example.mybatis_test1.myHandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.*;

/**
 * @author 2657944563
 */
public class handler1 extends BaseTypeHandler<java.util.Date> {

    //    将java类型转换为数据库需要的类型
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, java.util.Date date, JdbcType jdbcType) throws SQLException {
        preparedStatement.setLong(i, date.getTime());
    }

    //      将数据库类型转换为java类型
    @Override
    public Date getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return new Date(resultSet.getLong(s));
    }

    //      将数据库类型转换为java类型
    @Override
    public Date getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return new Date(resultSet.getLong(i));
    }

    //      将数据库类型转换为java类型
    @Override
    public Date getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return new Date(callableStatement.getLong(i));

    }
}

package com.autotest.utils.db;

import cn.hutool.db.Db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class SqlServerUtils {

    public static void main(String[] args) throws SQLException {
        Connection connection = Db.use().getConnection();
        String result = connection.nativeSQL("select * from myuser");
        System.out.println(result);
        CallableStatement callableStatement = connection.prepareCall("select * from myuser");
        System.out.println(callableStatement.executeQuery().toString());
    }
}

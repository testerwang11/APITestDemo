package com.autotest.utils.db;

import cn.hutool.db.Db;

import java.sql.SQLException;

public class SqlServerUtils {

    public static void main(String[] args) throws SQLException {
        Db.use().getConnection();
    }
}

package com.autotest.services;

import com.autotest.mode.TestResultStoragePO;
import com.autotest.utils.ConfigManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class TestResultService {

    private Connection con;
    public TestResultService() {
        //驱动程序名
        String driver = "com.mysql.jdbc.Driver";
        //URL指向要访问的数据库名mydata
        String url = ConfigManager.getInstance().getProperty("db_url");
        //MySQL配置时的用户名
        String user = ConfigManager.getInstance().getProperty("db_username");
        //MySQL配置时的密码
        String password = ConfigManager.getInstance().getProperty("db_password");
        try{
            //加载驱动程序
            Class.forName(driver);
            //1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url,user,password);
            if(!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void insertTestResult(List<TestResultStoragePO> testResultStoragePOs) throws SQLException {
        java.sql.PreparedStatement psql;
        for(TestResultStoragePO tr:testResultStoragePOs){
            psql = con.prepareStatement("insert into at_historyui (test_task_id, test_name, test_class, method, start_time, end_time, status, err_msg, env, is_valid, description) "
                    + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            psql.setString(1, tr.getTestTaskId());
            psql.setString(2, tr.getTestName());
            psql.setString(3, tr.getTestClass());
            psql.setString(4, tr.getMethod());
            psql.setTimestamp(5, new Timestamp(tr.getStartTime()));
            psql.setTimestamp(6, new Timestamp(tr.getEndTime()));
            psql.setInt(7, tr.getStatus());
            psql.setString(8, tr.getErrMsg());
            psql.setString(9, tr.getEnv());
            psql.setBoolean(10, true);
            psql.setString(11, tr.getDescription());
            psql.execute();
        }
    }

    public void close() {
        try {
            con.close();
        } catch (SQLException e) {
            //e.printStackTrace();
        }
    }
}

package com.autotest.database;

import com.autotest.database.dao.ApiRunHistoryMapper;
import com.autotest.database.model.ApiRunHistory;
import com.autotest.utils.ConfigManager;
import com.autotest.utils.db.SqlManager;

public class DBService {

    SqlManager manage;

    public DBService() {
        manage = new SqlManager("spring" + ConfigManager.getInstance().getProperty("env"));
    }

    /**
     * 根据ID查询执行记录
     * @param id
     * @return
     */
    public ApiRunHistory selectByPrimaryKey(int id){
        ApiRunHistoryMapper mapper = manage.getSession().getMapper(ApiRunHistoryMapper.class);
        return mapper.selectByPrimaryKey(id);
    }

    public int delByPrimaryKey(int id){
        ApiRunHistoryMapper mapper = manage.getSession().getMapper(ApiRunHistoryMapper.class);
        return mapper.deleteByPrimaryKey(id);
    }

    public void close() {
        manage.close();
    }

    public static void main(String[] args) {
        DBService db = new DBService();
        db.delByPrimaryKey(7066);
        db.manage.commit();
        db.close();
    }
}

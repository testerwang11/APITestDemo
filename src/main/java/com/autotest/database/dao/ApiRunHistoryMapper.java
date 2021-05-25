package com.autotest.database.dao;

import com.autotest.database.model.ApiRunHistory;
import java.util.List;

public interface ApiRunHistoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ApiRunHistory record);

    ApiRunHistory selectByPrimaryKey(Integer id);

    List<ApiRunHistory> selectAll();

    int updateByPrimaryKey(ApiRunHistory record);
}
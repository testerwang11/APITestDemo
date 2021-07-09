package com.autotest.utils.excel;

import cn.hutool.poi.excel.ExcelUtil;
import com.autotest.database.model.ApiCaseEntity;
import com.github.crab2died.ExcelUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReadApiCaseUtil {

    /**
     * 读取Excel中的用例
     * @param excelPath
     * @return
     */
    public static LinkedList<ApiCaseEntity> excel2Object2(String excelPath) {
        try {
            List<String> sheetNames = ExcelUtil.getReader(excelPath).getSheetNames();
            List<ApiCaseEntity> caseDatas = new ArrayList<>();
            List<ApiCaseEntity> caseDatasTemp = new ArrayList<>();
            LinkedList<ApiCaseEntity> caseEntities = new LinkedList<>();
            for (int i = 0; i < sheetNames.size(); i++) {
                caseDatasTemp.clear();
                caseDatas = ExcelUtils.getInstance().readExcel2Objects(excelPath, ApiCaseEntity.class, 0, i);
                for (ApiCaseEntity caseData : caseDatas) {
                    caseData.setSuitName(sheetNames.get(i));
                    caseDatasTemp.add(caseData);
                }
                caseEntities.addAll(caseDatasTemp);
            }
            return caseEntities;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

package com.zp.tap.execel;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;

import java.util.List;
import java.util.Map;

/**
 * <p></p>
 *
 * @author zhoupeng peng.zhou@topay.ae
 * @date FundInExcel.java v1.0  2020/2/18 2:16 下午
 */
public class FundInExcel {
    public static void main(String[] args) {
        ExcelReader reader = ExcelUtil.getReader("/Users/zhoupeng/Desktop/zp/I_Tap102_20200217_001.xlsx");
        List<List<Object>> readAll = reader.read();
        for (int i = 1; i < readAll.size(); i++) {

        }
        System.out.println(readAll);

    }
}

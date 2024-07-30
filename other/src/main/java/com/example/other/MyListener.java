package com.example.other;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;

import java.util.List;

/**
 * @description:
 * @auther: liubiao
 * @date: 2024-07-25
 */
public class MyListener implements ReadListener<EnumImport> {
    private List<EnumImport> cachedDataList = ListUtils.newArrayListWithExpectedSize(1000);

    @Override
    public void invoke(EnumImport enumImport, AnalysisContext analysisContext) {
        cachedDataList.add(enumImport);

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }


    public List<EnumImport> getCachedDataList(){
       return this.cachedDataList;
    }
}

package com.example.springlearndemo.excel;


import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @Author: lipeisheng
 * @Date: 2023/8/1
 */
@Slf4j
public class ExcelUtils {





    private static <T> void getList(List<T> list, Class<T> pojoClass) {
        if (list == null) {
            list = new ArrayList<>();
        }
        if (list.size() == 0) {
            try {
                list.add(pojoClass.getConstructor().newInstance());
            } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                     IllegalAccessException e) {
                log.error("创建对象失败", e);
                throw new RuntimeException(e);
            }
        }
    }




    public static <T> List<T> importExcel(InputStream inputStream, Class<T> pojoClass) {
        return importExcel(inputStream, 1, 1, pojoClass);
    }

    public static <T> List<T> importExcel(MultipartFile multipartFile, Class<T> pojoClass) {
        return importExcel(multipartFile, 1, 1, pojoClass);
    }

    /**
     * 功能描述：根据接收的Excel文件来导入Excel,并封装成实体类
     *
     * @param file       上传的文件
     * @param titleRows  表标题的行数
     * @param headerRows 表头行数
     * @param pojoClass  Excel实体类
     * @return
     */
    public static <T> List<T> importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass) {

        try {
            return importExcel(file.getInputStream(), titleRows, headerRows, pojoClass);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 功能描述：根据接收的Excel文件来导入Excel,并封装成实体类
     *
     * @param inputStream 上传的文件
     * @param titleRows   表标题的行数
     * @param headerRows  表头行数
     * @param pojoClass   Excel实体类
     * @return
     */
    public static <T> List<T> importExcel(InputStream inputStream, Integer titleRows, Integer headerRows, Class<T> pojoClass) {
        if (inputStream == null) {
            return null;
        }
        ImportParams params = new ImportParams();
        params.setTitleRows(titleRows);
        params.setHeadRows(headerRows);
        List<T> list = null;
        try {
            list = ExcelImportUtil.importExcel(inputStream, pojoClass, params);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("excel文件不能为空");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());

        }
        return list;
    }

    public static <T> List<T> importExcelFile(MultipartFile file, Class<T> pojoClass) {
        if (file == null) {
            return null;
        }
        ImportParams params = new ImportParams();
        List<T> list = null;
        try {
            list = ExcelImportUtil.importExcel(file.getInputStream(), pojoClass, params);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("模板不能为空");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        return list;
    }

}

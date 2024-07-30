package com.example.other;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @auther: liubiao
 * @date: 2024-07-24
 */
@Data
public class EnumImport implements Serializable {

    @ExcelProperty(value = "枚举编码")
    private String keyCode;

    @ExcelProperty(value = "枚举名称")
    private String keyName;

    @ExcelProperty(value = "本期是否涉及")
    private String need;

    //0 不允许 1 允许自定义
    @ExcelProperty(value = "是否允许租户自定义")
    private String customerFlag;

    @ExcelProperty(value = "枚举子项编码")
    private String enumCode;

    @ExcelProperty(value = "枚举子项名称")
    private String enumName;

    @ExcelProperty(value = "枚举子项名称备注")
    private String notes;

    @ExcelProperty(value = "备注")
    private String remark;

}

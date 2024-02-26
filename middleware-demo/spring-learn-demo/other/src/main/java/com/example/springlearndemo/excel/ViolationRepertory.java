package com.example.springlearndemo.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

/**
 * @description:
 * @auther: liubiao
 * @date: 2024/1/10
 */

@Data
public class ViolationRepertory {

    @Excel( name = "编号")
    private String clause;

    @Excel(name = "违规条款类型")
    private String type;

    @Excel(name = "具体内容")
    private String content;

    @Excel(name = "级别")
    private String level;

    @Excel(name = "罚金金额")
    private double amount;

    @Excel(name = "直接责任单位")
    private double company;

    @Excel(name = "直接责任人")
    private double personnel;

    @Excel(name = "班组长")
    private double foreman;

    @Excel(name ="安全员")
    private double safety;

    @Excel(name = "副经理")
    private double assistantManager;

    @Excel(name = "经理")
    private double manager;




}

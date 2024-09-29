package com.example.other.trans.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Joker
 * @version 1.0.0
 * @since 2024/4/9
 * 描述:  静态文件资源枚举类
 */
@Getter
@AllArgsConstructor
public enum ResourceEnum {

    /**
     * 编码格式: 公司标识-模块标识-自定义编码  eg: PM_General_Purchase_Doc001
     *     公司标识: [史记: SJ 汉世伟: HS  通用: PM]
     *     模块标识:
     *         通用功能:  General
     *         育肥板块:  Fattening
     *         种猪板块:  Breeding
     *         系统管理:  System
     *         应用管理:  Application
     *         耳标管理:  EarTag
     *         任务引擎:  TaskEngine
     *         动保兽药:  Animal
     *
     */
    // -----------------------------------------  通用功能模块 ---------------------------------------------------------------------------------------------------------------------------------------------
    /*猪只采购入库*/
    HS_GENERAL_DOCUMENT_001("HS_General_Purchase_Doc001", "批次猪采购个体猪只信息导入模板", "批次猪采购-猪只信息导入模板", "static/template/purchase/hs_batch_single_purchase_import.xls"),
    HS_GENERAL_DOCUMENT_002("HS_General_Purchase_Doc002", "母猪采购导入模板", "母猪采购-猪只信息导入模板", "static/template/purchase/hs_sow_purchase_import.xls"),
    HS_GENERAL_DOCUMENT_003("HS_General_Purchase_Doc003", "公猪采购导入模板", "公猪采购-猪只信息导入模板", "static/template/purchase/hs_boar_purchase_import.xls"),
    SJ_GENERAL_DOCUMENT_001("SJ_General_Purchase_Doc001", "批次猪采购个体猪只信息导入模板", "批次猪采购-猪只信息导入模板", "static/template/purchase/sj_batch_single_purchase_import.xls"),
    SJ_GENERAL_DOCUMENT_002("SJ_General_Purchase_Doc002", "公猪采购导入模板", "公猪采购-猪只信息导入模板", "static/template/purchase/sj_sow_purchase_import.xls"),
    SJ_GENERAL_DOCUMENT_003("SJ_General_Purchase_Doc003", "公猪采购导入模板", "公猪采购-猪只信息导入模板", "static/template/purchase/sj_boar_purchase_import.xls"),
    /*猪只销售入库*/
    PM_GENERAL_DOCUMENT_004("PM_General_Sell_Doc001", "批次猪销售个体猪只信息导入模板", "批次猪销售-猪只信息导入模板", "static/template/sell/batch_single_sell_import.xls"),
    PM_GENERAL_DOCUMENT_005("PM_General_Sell_Doc002", "母猪销售导入模板", "母猪销售-猪只信息导入模板", "static/template/sell/sow_sell_import.xls"),
    PM_GENERAL_DOCUMENT_006("PM_General_Sell_Doc003", "公猪销售导入模板", "公猪销售-猪只信息导入模板", "static/template/sell/boar_sell_import.xls"),
    /*猪只销售报批*/
    PM_GENERAL_DOCUMENT_007("PM_General_SaleApply_Doc001", "销售报批导入模板", "猪只销售-销售报批导入模板", "static/template/sell/sell_apply_import.xlsx"),
    PM_GENERAL_DOCUMENT_010("PM_General_SaleApply_Doc010", "销售报批导入模板", "猪只销售-销售报批导入模板（汉世伟）", "static/template/sell/hs_sell_apply_import.xlsx"),
    SJ_GENERAL_DOCUMENT_010("SJ_General_SaleApply_Doc010", "销售报批导入模板", "猪只销售-销售报批导入模板（史记）", "static/template/sell/sj_sell_apply_import.xlsx"),



    /*死亡*/
    PM_GENERAL_DOCUMENT_008("PM_General_Death_Doc001", "批次猪批量死亡导入模板", "批次猪死亡-猪只信息导入模板", "static/template/death/pigbatch_death_import.xls"),
    SJ_GENERAL_DOCUMENT_008("SJ_General_Death_Doc001", "史记批次猪批量死亡导入模板", "史记批次猪死亡-猪只信息导入模板", "static/template/death/pigbatch_death_import_sj.xls"),

    /*公母猪死亡*/
    PM_GENERAL_DOCUMENT_009("PM_General_Sow_Death_Doc002", "公母猪死亡导入模板", "公母猪死亡-猪只信息导入模板", "static/template/death/sow_death_import.xls"),
    SJ_GENERAL_DOCUMENT_009("SJ_General_Sow_Death_Doc002", "史记公母猪死亡导入模板", "史记公母猪死亡-猪只信息导入模板", "static/template/death/sow_death_import_sj.xls"),

    /* 批次猪死亡-个体信息 初版只导入电子耳标号 */
    PM_GENERAL_DOCUMENT_0010("PM_General_Death_SOLO_Doc001", "批次猪死亡个体信息导入模板", "批次猪死亡-猪只个体信息导入模板", "static/template/death/pigbatch_death_solo_import.xls"),

    /**公母猪淘汰*/
    PM_GENERAL_PIG_ELIMINATE_TMPL("PM_GENERAL_Pig_Eliminate_Tmpl", "公母猪淘汰导入模板", "公母猪淘汰-猪只信息导入模板", "static/template/eliminate/sow_eliminate_import.xls"),

    /** 公母猪转舍 */
    PM_GENERAL_TRANSFER_PIG_TMPL("PM_GENERAL_Pig_Transfer_Tmpl", "公母猪转舍导入模板", "公母猪转舍-猪只信息导入模板", "static/template/transfer/sow_transfer_import.xls"),

    /*公猪精液*/
    PM_GENERAL_SEMEN_001("PM_General_Semen_Doc001", "精液采购申请", "精液入库-采购入库物料信息下载模板", "static/template/semen/精液采购申请.xlsx"),
    PM_GENERAL_SEMEN_001_SJ("PM_General_Semen_Doc001_SJ", "精液采购申请", "精液入库-采购入库物料信息下载模板", "static/template/semen/精液采购申请（sj）.xlsx"),
    PM_GENERAL_SEMEN_002("PM_General_Semen_Doc002", "精液调拨出库", "精液出库-调拨出库下载模板", "static/template/semen/精液调拨出库.xls"),
    PM_GENERAL_SEMEN_002_SJ("PM_General_Semen_Doc002_SJ", "精液调拨出库", "精液出库-调拨出库下载模板", "static/template/semen/精液调拨出库（sj）.xls"),
    PM_GENERAL_SEMEN_003("PM_General_Semen_Doc003", "采精登记导入模板", "种猪板块-公猪生产管理-采精登记导入模板", "static/template/semen/采精登记导入模板.xls"),
    PM_GENERAL_SEMEN_004("PM_General_Semen_Doc004", "原精检测导入模板", "种猪板块-公猪生产管理-原精检测导入模板", "static/template/semen/原精检测导入模板.xls"),

    /*公母猪调拨出库*/
    PM_GENERAL_ALLOCATE_001("PM_General_Allocate_Doc001", "公母猪调拨出库导入模板", "公母猪调拨出库导入模板", "static/template/allocate/sow_boar_allocate_import.xls"),


    // -----------------------------------------  育肥板块 ---------------------------------------------------------------------------------------------------------------------------------------------
    /*种猪外部档案导入模版*/
    PM_INDIVIDUAL_DOCUMENT("INDIVIDUAL_IMPORT_HSW", "种猪档案登记（汉世伟）", "种猪档案登记（汉世伟）", "static/template/individual/individual_import_hsw.xls"),
    SJ_INDIVIDUAL_DOCUMENT("INDIVIDUAL_IMPORT_SJ", "种猪档案登记（史记）", "种猪档案登记（史记）", "static/template/individual/individual_import_sj.xls"),

    // -----------------------------------------  种猪板块 ---------------------------------------------------------------------------------------------------------------------------------------------
    PM_BOAR_ENTRY_TMPL("PM_Boar_Entry_Tmpl", "公猪入场导入模板", "公猪入场-猪只信息导入模板", "static/template/entry/boar_entry_import.xls"),

    /**
     * 汉世伟母猪入场
     */
    HS_SOW_ENTRANCE("Tpl_Sow_In_hsw","汉世伟母猪入场模板","汉世伟母猪入场模板","static/template/breeding/hsw_sow_entrance.xls"),
    /**
     * 史记母猪入场
     */
    SJ_SOW_ENTRANCE("Tpl_Sow_In_cg","史记母猪入场模板","史记母猪入场模板","static/template/breeding/sg_sow_entrance.xls"),
    /**
     * 汉世伟配种
     */
    HS_SOW_MATING("sowBreedImportTemplatehsw","汉世伟配种模板","汉世伟配种模板","static/template/breeding/hsw_mating.xls"),
    /**
     * 汉世伟配种带落地批
     */
    HS_SOW_MATING_BATCH("matingBatchHsw","汉世伟配种模板（落地批）","汉世伟配种模板（落地批）","static/template/breeding/hsw_mating_batch.xls"),
    /**
     * 史记配种
     */
    SJ_SOW_MATING("sowBreedImportTemplate","史记配种模板","史记配种模板","static/template/breeding/sg_mating.xls"),
    /**
     * 史记配种带落地批
     */
    SJ_SOW_MATING_BATCH("matingBatchSj","史记配种模板（落地批）","史记配种模板（落地批）","static/template/breeding/sg_mating_batch.xls"),
    /**
     * 妊检
     */
    PM_SOW_GESTATING("sowGestateImportTemplate","妊检异常批量导入模板","妊检异常批量导入模板","static/template/breeding/gestating.xls"),
    /**
     * 汉世伟分娩
     */
    HS_SOW_DELIVERY("Tpl_Sow_Delivery","母猪分娩批量导入模板","母猪分娩批量导入模板","static/template/breeding/hsw_delivery.xls"),
    /**
     * 史记分娩
     */
    SG_SOW_DELIVERY("Tpl_Sow_Delivery_shiji","母猪分娩批量导入模板","母猪分娩批量导入模板","static/template/breeding/sg_delivery.xls"),
    /**
     * 断奶
     */
    PM_SOW_WEANING("sowWeaningImportTemplate","母猪断奶批量导入模板","母猪断奶批量导入模板","static/template/breeding/weaning.xls"),
    /**
     * 仔猪寄入
     */
    PM_SOW_SEND_IN("sowSendInImportTemplate","母猪寄入批量导入模板","母猪寄入批量导入模板","static/template/breeding/sendIn.xls"),
    /**
     * 仔猪寄出
     */
    PM_SOW_SEND_OUT("sowSendOutImportTemplate","母猪寄出批量导入模板","母猪寄出批量导入模板","static/template/breeding/sendOut.xls"),
    /**
     * 猪只转生产
     */
    PM_FATTENING_TRANSFER_TO_PRODUCTION("PM_Fattening_Transfer_To_Production", "猪只转生产模板", "猪只转生产模板", "static/template/breeding/transfer_to_production.xls"),
    // -----------------------------------------  系统管理 ---------------------------------------------------------------------------------------------------------------------------------------------
    
    // -----------------------------------------  应用管理 ---------------------------------------------------------------------------------------------------------------------------------------------
    
    // -----------------------------------------  耳标管理 ---------------------------------------------------------------------------------------------------------------------------------------------
    /**
     * 耳号更新记录
     */
    PM_EAR_TAG_UPDATE_RECORD("PM_Ear_Tag_Update_Record", "批量更新场内编号模板", "批量更新场内编号模板", "static/template/eartag/批量更新场内编号模板.xlsx"),

    /**
     * 母猪查情管理
     */
    PM_SOW_SEEK_FEELING("PM_Sow_Seek_Feeling", "母猪查情批量导入模版", "母猪查情批量导入模版", "static/template/sowSeekFeeling/sow_seek_feeling.xlsx"),

    /**
     * 栏位导入
     */
    PM_FARM_COLUMN("PM_Farm_Column", "栏位导入模版", "栏位导入模版", "static/template/farm/pm_column_import.xls"),
    // -----------------------------------------  任务引擎 ---------------------------------------------------------------------------------------------------------------------------------------------
    
    // -----------------------------------------  动保兽药 ---------------------------------------------------------------------------------------------------------------------------------------------

    // -----------------------------------------  添加示例：无实际含义 ---------------------------------------------------------------------------------------------------------------------------------------------
    EXCEL_TEMPLATE("ExcelTemplate", "Excel模板", "Excel模板", "static/template/excel_template.xlsx")
    ;
    
    
    
    
    
    
    
    /**
     * 文档编码
     */
    private final String code;
    /**
     * 文档名称
     */
    private final String name;
    /**
     * 文档声明
     */
    private final String declare;
    /**
     * 文档路径
     */
    private final String path;



    /**
     * 根据自定义编码查找对应的资源枚举项。
     *
     * @param code 自定义编码
     * @return 匹配的资源枚举项，如果没有找到则返回null
     */
    public static ResourceEnum findByCode(String code) {
        for (ResourceEnum resource : values()) {
            if (resource.getCode().equals(code)) {
                return resource;
            }
        }
        return null;
    }
}

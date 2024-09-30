package com.example.mybatisplusexample.domain.db;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @description:
 * @auther: liubiao
 * @date: 2023/7/6
 */
@Data
public class PageBean {

    @TableField(exist = false)
    private Integer current = 1;

    @TableField(exist = false)
    private Integer size = 10;

    @TableField(exist = false)
    private List<String> ascList;

    @TableField(exist = false)
    private List<String> descList;

    /**
     * @return Page<PageBean>
     * @author Zhang Sichu
     * @description PageBean入参支持排序，排序字段在数据库中必须须符合下划线命名方式
     * @date 2021/12/13
     */
    @JsonIgnore
    public <T extends PageBean> PageDTO<T> getPage() {
        PageDTO<T> page = new PageDTO<>(this.getCurrent(), this.getSize());
        List<OrderItem> orderItems = new ArrayList<>();
        Optional.ofNullable(this.getAscList()).orElse(new ArrayList<>())
                .forEach(item -> orderItems.add(OrderItem.asc(StrUtil.toUnderlineCase(item))));
        Optional.ofNullable(this.getDescList()).orElse(new ArrayList<>())
                .forEach(item -> orderItems.add(OrderItem.desc(StrUtil.toUnderlineCase(item))));
        page.addOrder(orderItems);
        return page;
    }
}

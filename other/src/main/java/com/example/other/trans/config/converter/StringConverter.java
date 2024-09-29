package com.example.other.trans.config.converter;


import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.core.convert.converter.Converter;

import java.util.HashMap;
import java.util.Map;


/**
 * 解决入参为 Date类型
 *
 * @author Joker
 * 
 */
@Slf4j
public class StringConverter extends BaseDateConverter<String> implements Converter<String, String> {

    @Override
    protected Map<String, String> getFormat() {
        return new HashMap<>();
    }

    @Override
    public String convert(@NotNull String source) {
        String target = "\"\"";
        return StrUtil.equals(source, target) ? StrUtil.EMPTY : source;
    }

}

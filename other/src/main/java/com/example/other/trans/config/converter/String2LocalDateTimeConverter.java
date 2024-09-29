package com.example.other.trans.config.converter;


import org.springframework.core.convert.converter.Converter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.example.other.trans.config.converter.TimeConstants.*;
import org.antlr.v4.runtime.misc.NotNull;

/**
 * 解决入参为 Date类型
 *
 * @author Joker
 * 
 */
public class String2LocalDateTimeConverter extends BaseDateConverter<LocalDateTime> implements Converter<String, LocalDateTime> {
    
    protected static final Map<String, String> FORMAT = new LinkedHashMap<>(2);
    
    static {
        FORMAT.put(FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND, "^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$");
        FORMAT.put(FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND_SLASH, "^\\d{4}/\\d{1,2}/\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$");
    }
    
    @Override
    protected Map<String, String> getFormat() {
        return FORMAT;
    }
    
    @Override
    public LocalDateTime convert(@NotNull String source) {
        return super.convert(source, (key) -> LocalDateTime.parse(source, DateTimeFormatter.ofPattern(key)));
    }
}

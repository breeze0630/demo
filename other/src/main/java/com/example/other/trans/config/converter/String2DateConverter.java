package com.example.other.trans.config.converter;


import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.core.convert.converter.Converter;

import java.rmi.ServerException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.example.other.trans.config.converter.TimeConstants.*;


/**
 * 解决入参为 Date类型
 *
 * @author Joker
 * 
 */
@Slf4j
public class String2DateConverter extends BaseDateConverter<Date> implements Converter<String, Date> {

    private static final Map<String, String> FORMAT = new LinkedHashMap<>(11);

    static {
        FORMAT.put(FORMAT_YEAR, "^\\d{4}");
        FORMAT.put(FORMAT_YEAR_MONTH, "^\\d{4}-\\d{1,2}$");
        FORMAT.put(FORMAT_YEAR_MONTH_DAY, "^\\d{4}-\\d{1,2}-\\d{1,2}$");
        FORMAT.put(FORMAT_YEAR_MONTH_DAY_HOUR, "^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}");
        FORMAT.put(FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE, "^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}$");
        FORMAT.put(FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND, "^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$");
        FORMAT.put(FORMAT_YEAR_MONTH_SLASH, "^\\d{4}/\\d{1,2}$");
        FORMAT.put(FORMAT_YEAR_MONTH_DAY_SLASH, "^\\d{4}/\\d{1,2}/\\d{1,2}$");
        FORMAT.put(FORMAT_YEAR_MONTH_DAY_HOUR_SLASH, "^\\d{4}/\\d{1,2}/\\d{1,2} {1}\\d{1,2}");
        FORMAT.put(FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SLASH, "^\\d{4}/\\d{1,2}/\\d{1,2} {1}\\d{1,2}:\\d{1,2}$");
        FORMAT.put(FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND_SLASH, "^\\d{4}/\\d{1,2}/\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$");
    }

    /**
     * 格式化日期
     *
     * @param dateStr String 字符型日期
     * @param format  String 格式
     * @return Date 日期
     */
    protected static Date parseDate(String dateStr, String format) {
        Date date = null;
        try {
            DateFormat dateFormat = new SimpleDateFormat(format);
            // 严格模式
            dateFormat.setLenient(false);
            date = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            log.info("转换日期失败, date={}, format={}", dateStr, format, e);
            throw new RuntimeException( e.getMessage());
        }
        return date;
    }

    @Override
    protected Map<String, String> getFormat() {
        return FORMAT;
    }

    @Override
    public Date convert(@NotNull String source) {
        return super.convert(source, (key) -> parseDate(source, key));
    }

}

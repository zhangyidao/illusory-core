package com.illusory.util;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author jzb
 * @desc 时间工具类
 * @date 2023/7/7 16:03
 */
public abstract class DateUtils {

    /** 无符号日期格式化模板 */
    public final static String DATE_NO_SYMBOL_PATTERN = "yyyyMMdd";

    /** 有符号日期格式化模板 */
    public final static String DATE_SYMBOL_PATTERN = "yyyy-MM-dd";

    /** 无符号时间格式化模板 */
    public final static String TIME_NO_SYMBOL_PATTERN = "yyyyMMddHHmmss";

    /** 有符号时间格式化模板 */
    public final static String TIME_SYMBOL_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * Date 转为 LocalDateTime
     * @param date
     * @return 返回LocalDateTime
     */
    public static LocalDateTime dateToLocalDateTime(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * 当前日期转无符号字符串日期
     * @return 返回一个无符号日期字符串，例如：20220101
     */
    public static String currentDateToNoSymbolDate() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_NO_SYMBOL_PATTERN);
        return dateTimeFormatter.format(LocalDate.now());
    }

    /**
     * 当前日期转有符号字符串日期
     * @return 返回一个有符号日期字符串，例如：2022-01-01
     */
    public static String currentDateToSymbolDate() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_SYMBOL_PATTERN);
        return dateTimeFormatter.format(LocalDate.now());
    }

    /**
     * 当前时间转无符号字符串时间
     * @return 返回一个有符号时间字符串，例如：20220101130101
     */
    public static String currentTimeToNoSymbolTime() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(TIME_NO_SYMBOL_PATTERN);
        return dateTimeFormatter.format(LocalDateTime.now());
    }

    /**
     * 当前时间转有符号字符串时间
     * @return 返回一个有符号时间字符串，例如：2022-01-01 13:01:01
     */
    public static String currentTimeToSymbolTime() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(TIME_SYMBOL_PATTERN);
        return dateTimeFormatter.format(LocalDateTime.now());
    }

    /**
     * 日期转无符号字符串日期
     * @param localDate
     * @return 返回一个无符号日期字符串，例如：20220101
     */
    public static String dateToNoSymbolDate(LocalDate localDate) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_NO_SYMBOL_PATTERN);
        return dateTimeFormatter.format(localDate);
    }

    /**
     * 日期转有符号字符串日期
     * @param localDate
     * @return 返回一个有符号日期字符串，例如：2022-01-01
     */
    public static String dateToSymbolDate(LocalDate localDate) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_SYMBOL_PATTERN);
        return dateTimeFormatter.format(localDate);
    }

    /**
     * 时间转无符号字符串时间
     * @param localDateTime
     * @return 返回一个有符号时间字符串，例如：20220101130101
     */
    public static String timeToNoSymbolTime(LocalDateTime localDateTime) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(TIME_NO_SYMBOL_PATTERN);
        return dateTimeFormatter.format(localDateTime);
    }

    /**
     * 时间转有符号字符串时间
     * @param localDateTime
     * @return 返回一个有符号时间字符串，例如：2022-01-01 13:01:01
     */
    public static String timeToSymbolTime(LocalDateTime localDateTime) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(TIME_SYMBOL_PATTERN);
        return dateTimeFormatter.format(localDateTime);
    }

    /**
     * 无符号日期字符串转LocalDate，日期符号为 20220101
     * @param dateStr
     * @return LocalDate
     */
    public static LocalDate dateNoSymbolStrToLocalDate(String dateStr) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_NO_SYMBOL_PATTERN);
        return LocalDate.parse(dateStr, dateTimeFormatter);
    }

    /**
     * 有符号日期字符串转LocalDate，日期符号为 2022-01-01
     * @param dateStr
     * @return LocalDate
     */
    public static LocalDate dateSymbolStrToLocalDate(String dateStr) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_SYMBOL_PATTERN);
        return LocalDate.parse(dateStr, dateTimeFormatter);
    }

    /**
     * 无符号时间字符串转LocalDate，时间符号为 20220101131213
     * @param timeStr
     * @return LocalDateTime
     */
    public static LocalDateTime timeNoSymbolStrToLocalDate(String timeStr) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(TIME_NO_SYMBOL_PATTERN);
        return LocalDateTime.parse(timeStr, dateTimeFormatter);
    }

    /**
     * 有符号日期字符串转LocalDate，日期符号为 2022-01-01
     * @param timeStr
     * @return LocalDateTime
     */
    public static LocalDateTime timeSymbolStrToLocalDate(String timeStr) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(TIME_SYMBOL_PATTERN);
        return LocalDateTime.parse(timeStr, dateTimeFormatter);
    }

    /**
     * 获取当前时间的毫秒级时间戳
     * @return 返回当前时间的毫秒数
     */
    public static long currentTimeToMilliTimestamp() {
        return Timestamp.valueOf(LocalDateTime.now()).getTime();
    }

    /**
     * 获取当前时间的秒级时间戳
     * @return 返回当前时间的秒数
     */
    public static long currentTimeToSecTimestamp() {
        return LocalDateTime.now().atZone(ZoneId.systemDefault()).toEpochSecond();
    }

    /**
     * 毫秒级时间戳转LocalDateTime
     * @param timestamp
     * @return LocalDateTime
     */
    public static LocalDateTime millsTimestampToLocaDateTime(Long timestamp) {
        return Instant.ofEpochMilli(timestamp).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * 秒级时间戳转LocalDateTime
     * @param timestamp
     * @return LocalDateTime
     */
    public static LocalDateTime secTimestampToLocaDateTime(Long timestamp) {
        return Instant.ofEpochSecond(timestamp).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

}

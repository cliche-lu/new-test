package com.cliche.newtest.utils;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashSet;
import java.util.Set;

public class HolidayChecker {

    // 定义节假日集合
    private static final Set<LocalDate> holidays = new HashSet<>();
//
    private static final Set<LocalDate> needWorkSunDay = new HashSet<>();
//    2024年节假日
    static {

        holidays.add(LocalDate.of(2024, Month.OCTOBER, 1)); // 国庆节 8
        holidays.add(LocalDate.of(2024, Month.OCTOBER, 2)); // 国庆节
        holidays.add(LocalDate.of(2024, Month.OCTOBER, 3)); // 国庆节
        holidays.add(LocalDate.of(2024, Month.OCTOBER, 4)); // 国庆节
        holidays.add(LocalDate.of(2024, Month.OCTOBER, 5)); // 国庆节
        holidays.add(LocalDate.of(2024, Month.OCTOBER, 6)); // 国庆节
        holidays.add(LocalDate.of(2024, Month.OCTOBER, 7)); // 国庆节
        holidays.add(LocalDate.of(2024, Month.OCTOBER, 8)); // 国庆节
        // 其他节假日依次添加
    }
    // 初始化节假日集合 2025年节假日
    static {
        holidays.add(LocalDate.of(2025, Month.JANUARY, 1)); // 元旦节

        holidays.add(LocalDate.of(2025, Month.JANUARY, 25)); // 春节 5
        holidays.add(LocalDate.of(2025, Month.JANUARY, 26)); // 春节
        holidays.add(LocalDate.of(2025, Month.JANUARY, 27)); // 春节
        holidays.add(LocalDate.of(2025, Month.JANUARY, 28)); // 春节
        holidays.add(LocalDate.of(2025, Month.JANUARY, 29)); // 春节
        holidays.add(LocalDate.of(2025, Month.JANUARY, 30)); // 春节
        holidays.add(LocalDate.of(2025, Month.JANUARY, 31)); // 春节
        holidays.add(LocalDate.of(2025, Month.FEBRUARY, 1)); // 春节
        holidays.add(LocalDate.of(2025, Month.FEBRUARY, 2)); // 春节
        holidays.add(LocalDate.of(2025, Month.FEBRUARY, 3)); // 春节
        holidays.add(LocalDate.of(2025, Month.FEBRUARY, 4)); // 春节
        holidays.add(LocalDate.of(2025, Month.FEBRUARY, 5)); // 春节

        holidays.add(LocalDate.of(2025, Month.APRIL, 4)); // 清明节 3
        holidays.add(LocalDate.of(2025, Month.APRIL, 5)); // 清明节
        holidays.add(LocalDate.of(2025, Month.APRIL, 6)); // 清明节

        holidays.add(LocalDate.of(2025, Month.MAY, 1)); // 劳动节 5
        holidays.add(LocalDate.of(2025, Month.MAY, 2)); // 劳动节
        holidays.add(LocalDate.of(2025, Month.MAY, 3)); // 劳动节
        holidays.add(LocalDate.of(2025, Month.MAY, 4)); // 劳动节
        holidays.add(LocalDate.of(2025, Month.MAY, 5)); // 劳动节

        holidays.add(LocalDate.of(2025, Month.MAY, 31)); // 端午节 3
        holidays.add(LocalDate.of(2025, Month.MAY, 1)); // 端午节
        holidays.add(LocalDate.of(2025, Month.MAY, 2)); // 端午节

        holidays.add(LocalDate.of(2025, Month.OCTOBER, 1)); // 国庆节 8
        holidays.add(LocalDate.of(2025, Month.OCTOBER, 2)); // 国庆节
        holidays.add(LocalDate.of(2025, Month.OCTOBER, 3)); // 国庆节
        holidays.add(LocalDate.of(2025, Month.OCTOBER, 4)); // 国庆节
        holidays.add(LocalDate.of(2025, Month.OCTOBER, 5)); // 国庆节
        holidays.add(LocalDate.of(2025, Month.OCTOBER, 6)); // 国庆节
        holidays.add(LocalDate.of(2025, Month.OCTOBER, 7)); // 国庆节
        holidays.add(LocalDate.of(2025, Month.OCTOBER, 8)); // 国庆节
        // 其他节假日依次添加
    }
//    2024年调休周末
    static {
//        needWorkSunDay.add(LocalDate.of(2024, Month.JANUARY, 26)); // 春节调休
//        needWorkSunDay.add(LocalDate.of(2024, Month.FEBRUARY, 8)); // 春节调休
//
//        needWorkSunDay.add(LocalDate.of(2024, Month.APRIL, 27)); // 劳动节

        needWorkSunDay.add(LocalDate.of(2024, Month.SEPTEMBER, 29)); // 国庆节
        needWorkSunDay.add(LocalDate.of(2024, Month.OCTOBER, 12)); // 国庆节
    }
//    2025年调休周末
    static {
//        needWorkSunDay.add(LocalDate.of(2025, Month.JANUARY, 26)); // 春节调休
        needWorkSunDay.add(LocalDate.of(2025, Month.FEBRUARY, 8)); // 春节调休

        needWorkSunDay.add(LocalDate.of(2025, Month.APRIL, 27)); // 劳动节调休

        needWorkSunDay.add(LocalDate.of(2025, Month.SEPTEMBER, 28)); // 国庆节调休
        needWorkSunDay.add(LocalDate.of(2025, Month.OCTOBER, 11)); // 国庆节调休
    }

    public static boolean isHoliday(LocalDate date) {
        return holidays.contains(date);
    }
    public static boolean needWorkSunDay(LocalDate date) {
        return needWorkSunDay.contains(date);
    }

    public static void main(String[] args) {
        System.out.println("holidays = " + holidays.size());
        System.out.println("holidays = " + (holidays.size()-needWorkSunDay.size())); // 劳动节
        LocalDate date = LocalDate.of(2025, Month.JANUARY, 26);
        System.out.println("needWorkSunDay(date) = " + needWorkSunDay(date));
        if (isHoliday(date)) {
            System.out.println("是节假日");
        } else {
            System.out.println("不是节假日");
        }
    }
}

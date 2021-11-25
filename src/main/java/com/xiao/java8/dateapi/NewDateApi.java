package com.xiao.java8.dateapi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

public class NewDateApi {
    public static void main(String[] args) {
        /*
            LocalDate
         */
        LocalDate date = LocalDate.of(2018, 4, 20); // 2018-04-20
        int year = date.getYear(); // 2018
        int month = date.getMonth().getValue(); // 4
        int day = date.getDayOfMonth(); // 20
        // 查看该月有多少天
        int days = date.lengthOfMonth(); // 30
        // 是否是闰年
        boolean isLeap = date.isLeapYear(); // false

        LocalDate now = LocalDate.now();



        int year1 = date.get(ChronoField.YEAR); // 2018
        int month1 = date.get(ChronoField.MONTH_OF_YEAR); // 4
        int day1 = date.get(ChronoField.DAY_OF_MONTH); // 20
// 当前日期属于该月第几周
        int weekOfMonth = date.get(ChronoField.ALIGNED_WEEK_OF_MONTH); // 3
        int year12 = date.get(ChronoField.YEAR); // 2018
        int month13 = date.get(ChronoField.MONTH_OF_YEAR); // 4
        int day21 = date.get(ChronoField.DAY_OF_MONTH); // 20
// 当前日期属于该月第几周
        int weekOfMonth3 = date.get(ChronoField.ALIGNED_WEEK_OF_MONTH); // 3
        /**
         * 格式化操作
         */
        String str1 = date.format(DateTimeFormatter.BASIC_ISO_DATE); // 20180420
        String str2 = date.format(DateTimeFormatter.ISO_LOCAL_DATE); // 2018-04-20

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String str5 = date.format(dtf); // 2018-04-20
        LocalDate date13 = LocalDate.parse(str5, dtf); // 2018-04-20
        /**
        LocalTime
        LocalTime和LocalDate类似，区别在于LocalTime包含的是时分秒（毫秒）信息。举些LocalTime的例子：

        LocalTime time = LocalTime.of(20, 13, 54); // 20:13:54
        int hour = time.getHour(); // 20
        int minute = time.getMinute(); // 13
        int second = time.getSecond(); // 54
        LocalDate和LocalTime都可以通过字符串来创建：

        LocalDate date = LocalDate.parse("2018-04-20");
        LocalTime time = LocalTime.parse("20:13:54");
        LocalDateTime
        LocalDateTime是LocalDate和LocalTime的组合形式，包含了年月日时分秒信息。举些LocalDateTime的使用示例：

        LocalDateTime ldt1 = LocalDateTime.of(2018, 4, 20, 20, 13, 54); // 2018-04-20T20:13:54
        LocalDateTime ldt2 = LocalDateTime.of(date, time); // 2018-04-20T20:13:54
        LocalDateTime可以转换为LocalDate和LocalTime，转换后包含的信息减少了：

        LocalDate date1 = ldt1.toLocalDate(); // 2018-04-20
        LocalTime time1 = ldt1.toLocalTime(); // 20:13:54
        同样的，LocalDate和LocalTime也可以转换为LocalDateTime，只需要补上日期或者时间：

        LocalDateTime ldt3 = date.atTime(time); // 2018-04-20T20:13:54
        LocalDateTime ldt4 = date.atTime(20, 13, 54); // 2018-04-20T20:13:54
        LocalDateTime ldt5 = time.atDate(date); // 2018-04-20T20:13:54
        Duration
        Duration用于计算两个LocalTime或者LocalDateTime的时间差，例如：

        LocalTime time2 = LocalTime.of(23, 59, 59);
        Duration duration = Duration.between(time1, time2);
        long seconds = duration.getSeconds(); // 13565
        time1和time2之间相差了13565秒。

        手动创建Duration对象：

        Duration threeMinutes = Duration.ofMinutes(3);
        threeMinutes = Duration.of(3, ChronoUnit.MINUTES); // 创建了一个3分钟的Duration，两种创建方式等价
        Period
        Period用于计算两个LocalDate之间的时长。举些例子：

        LocalDate date2 = LocalDate.of(2018, 5, 21);
        Period period = Period.between(date1, date2);
        int monthsBetween = period.getMonths(); // 1
        int daysBetween = period.getDays(); // 1
        2018-04-21和2018-04-20之间月份相差1，天数相差1。

        同样的，我们也可以手动创建Period对象：

        Period tenDays = Period.ofDays(10);
        Period threeWeeks = Period.ofWeeks(3);
        Period twoYearsSixMonthsOneDay = Period.of(2, 6, 1);
        其他一些常用的方法
                比较两个时间的先后
        LocalDate date15 = LocalDate.of(2018,4,21);
        date.isEqual(date15); // false
        date.isAfter(date15); // false
        date.isBefore(date15); // true
        MonthDay类的使用
        MonthDay只包含月日信息，可以用于存放类似于生日，结婚纪念日等信息。举个使用MonthDay的例子：

        LocalDate birthday = LocalDate.of(1999, 9, 9);
        MonthDay monthDay = MonthDay.of(birthday.getMonth(), birthday.getDayOfMonth());
        MonthDay currentMonthDay = MonthDay.from(LocalDate.now());
        if (currentMonthDay.equals(monthDay)) {
            System.out.println("happy birthday!");
        }
        假如用户的生日是1999年9月9号，那么可以通过这种方法来判断今天是否是用户的生日，如果是的话便发送生日祝福。同样的也有YearMonth类。
        **/
    }
}

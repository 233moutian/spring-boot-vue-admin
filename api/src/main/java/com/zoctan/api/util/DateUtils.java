package com.zoctan.api.util;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.Seconds;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
* 时间操作类
* */
public class DateUtils extends DateUtilsZXW{
	
	/**
	 * 获取传入时间+-n天的date
	 */
	public static Date getNextDay(Date date, Integer n){
		Calendar calendar = Calendar.getInstance();  
        calendar.setTime(date);  
        calendar.add(Calendar.DAY_OF_MONTH, n);  
        date = calendar.getTime();  
        return date;
	}
	
	/**
	 * 获取+-hour个小时的date
	 */
	public static Date getNextHour(Date date, int hour) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.HOUR_OF_DAY, hour);
		return calendar.getTime();
	}

	/**
	 * 获取+-min 个分钟的date
	 */
	public static Date getNextMinute(Date date, int minute) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, minute);
		return calendar.getTime();
	}
	
	/**
	 * 获取+-sec 个秒的date
	 */
	public static Date getNextSecond(Date date, int second) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.SECOND, second);
		return calendar.getTime();
	}


	/**
	 * 获取指定时间得小时数
	 */
	public static int getHour(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * 将制定时间设置为月初
	 */
	public static Date setEarlyMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 得到当前时间yyyy-MM-dd HH:mm:ss
	 */
	public static String getTime() {
		String time = "";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			time = sdf.format(new Date(System.currentTimeMillis()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return time;
	}

	/**
	 * 比较两个日期相差多少天
	 */
	public static int daysOfTwo(Date fDate, Date oDate) {
		Calendar aCalendar = Calendar.getInstance();
		aCalendar.setTime(fDate);
		int day1 = aCalendar.get(Calendar.DAY_OF_YEAR);
		aCalendar.setTime(oDate);
		int day2 = aCalendar.get(Calendar.DAY_OF_YEAR);
		return day2 - day1;
	}

	/**
	 * 获取当天剩余时间
	 */
	public static long getMilliSecondsLeftToday() {
		return (86400000 - org.apache.commons.lang3.time.DateUtils.getFragmentInMilliseconds(Calendar.getInstance(), Calendar.DATE));
	}
	
	/**
	 * 获取当天剩余时间
	 */
	public static long getSecondsLeftToday(){
		return (getMilliSecondsLeftToday()/1000);
	}
	
	/**
	 *  格式转换
	 */
	public static String getFormatString(String date, String format) {
		SimpleDateFormat sdf2 = new SimpleDateFormat(format);
		if (StringUtils.isBlank(date)) {
			date = sdf2.format(new Date());
		} else {
			try {
				Date date2 = sdf2.parse(date);
				date = sdf2.format(date2);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		}
		return date;
	}
	
	public static String getDateString(Date date, String format) {
		SimpleDateFormat sdf2 = new SimpleDateFormat(format);
		return sdf2.format(date);
	}
	
	/**
	 * 格式转换
	 */
	public static Date getFormatDate(String date, String format) {
		SimpleDateFormat sdf2 = new SimpleDateFormat(format);
		Date dateNow = null;
		if (StringUtils.isBlank(date)) {
			dateNow = new Date();
		} else {
			try {
				dateNow = sdf2.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return dateNow;
	}

	/**
	 * 格式转换
	 * yyyy-MM-dd
	 */
	public static Date getDateByStringWithDefaultFormat(String date) {
		return getFormatDate(date, DATE_DEFAULT_FORMAT);
	}

	/**
	 * 格式转换
	 * yyyy/MM/dd
	 */
	public static Date getDateByStringWithShortFormat(String date) {
		return getFormatDate(date, DATE_SHORT_FORMAT);
	}

	/**
	 * 格式转换
	 * HH:mm:ss
	 */
	public static Date getDateByStringWithDefaultFormatTime(String time) {
		return getFormatDate(time, DATE_FORMAT_HMS);
	}

	/**
	 * 格式转换
	 * "yyyy-MM-dd HH:mm:ss";
	 */
	public static Date getDateByStringWithDateFormatDefault(String dateTime) {
		return getFormatDate(dateTime, DATE_FORMAT_DEFAULT);
	}

	/**
	 * 格式转换
	 * yyyyMMddHHmmss
	 */
	public static Date getDateByStringWithoutSymbol(String dateTime) {
		return getFormatDate(dateTime, DATE_Time_FORMAT_WITHOUT_SYMBOL);
	}

	/**
	 * 合并两个字符串,然后再转成一个date对象返回出去
	 * 格式转换
	 * yyyy/MM/dd, HH:MM:SS
	 */
	public static Date getDateByStringWithShortFormat(String date, String time) {
		String dateTime = date + " " + time;
		return getFormatDate(dateTime, DATE_FORMAT_DEFAULT2);
	}


	/**
	 * 取得当月天数
	 * */
	public static int getCurrentMonthLastDay() {
		Calendar a = Calendar.getInstance();
		a.set(Calendar.DATE, 1);// 把日期设置为当月第一天
		a.roll(Calendar.DATE, -1);// 日期回滚一天，也就是最后一天
		int maxDate = a.get(Calendar.DATE);
		return maxDate;
	}
	
	/**
     * 获取两个日期相差几个月
     */
    public static int getMonth(Date start, Date end) {
		if (start.after(end)) {
			Date t = start;
			start = end;
			end = t;
		}
		Calendar startCalendar = Calendar.getInstance();
		startCalendar.setTime(start);
		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(end);
		Calendar temp = Calendar.getInstance();
		temp.setTime(end);

		int year = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
		int month = endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);
		return year * 12 + month;
	}
    
	 /**
     * 获取今天剩余的秒数
     *
     * @return 秒数
     */
    public static int oddSecondOfDay() {
    	org.joda.time.DateTime start = new org.joda.time.DateTime();
    	org.joda.time.DateTime end = new org.joda.time.DateTime().withHourOfDay(23).withMinuteOfHour(59).withSecondOfMinute(59);
        return Seconds.secondsBetween(start, end).getSeconds();
    }

    /**
     * 获取本周剩余的秒数
     *
     * @return 秒数
     */
    public static int oddSecondOfWeek() {
    	org.joda.time.DateTime start = new org.joda.time.DateTime();
    	org.joda.time.DateTime end =
            new org.joda.time.DateTime().dayOfWeek().withMaximumValue().withHourOfDay(23).withMinuteOfHour(59).withSecondOfMinute(59);
        return Seconds.secondsBetween(start, end).getSeconds();
    }

    /**
     * 获取本月剩余的秒数
     *
     * @return 秒数
     */
    public static int oddSecondOfMonth() {
    	org.joda.time.DateTime start = new org.joda.time.DateTime();
    	org.joda.time.DateTime end =
            new org.joda.time.DateTime().dayOfMonth().withMaximumValue().withHourOfDay(23).withMinuteOfHour(59).withSecondOfMinute(59);
        return Seconds.secondsBetween(start, end).getSeconds();
    }

    /**
     * 获取今年剩余的秒数
     *
     * @return 秒数
     */
    public static int oddSecondOfYear() {
    	org.joda.time.DateTime start = new org.joda.time.DateTime();
    	org.joda.time.DateTime end =
            new org.joda.time.DateTime().dayOfYear().withMaximumValue().withHourOfDay(23).withMinuteOfHour(59).withSecondOfMinute(59);
        return Seconds.secondsBetween(start, end).getSeconds();
    }
    
    public static void main(String[] args) {
//    	Date start = new Date(1501516800000L);
//    	Date end = new Date(1504108800000L);
//		int num = getMonth(start, end);
//		System.out.println("num:"+num);
//		System.out.println("剩余时间："+getMilliSecondsLeftToday()+",---->\n\n");


		System.out.println(DateUtils.getFormatDate("20110202020202", "yyyyMMddHHmmss"));
	/*	int oddSecondOfMonth = oddSecondOfMonth();
		int oddSecondOfDay = oddSecondOfDay();
		long getSecondsLeftToday = getSecondsLeftToday();
		System.out.println("oddSecondOfMonth:"+oddSecondOfMonth
				+"\noddSecondOfDay:"+oddSecondOfDay
				+"\ngetSecondsLeftToday:"+getSecondsLeftToday);
		*/
	}
    
}

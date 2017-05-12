package com.example.user.utils.sys;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import java.io.File;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;

/**
 * 时间处理工具类
 */
public class DataUtils {
	/**
	  * 获取现在时间
	  * 
	  * @return 返回时间类型 yyyy-MM-dd HH:mm:ss
	  */
	public static Date getNowDate() {
	  Date currentTime = new Date();
	  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	  String dateString = formatter.format(currentTime);
	  ParsePosition pos = new ParsePosition(8);
	  Date currentTime_2 = formatter.parse(dateString, pos);
	  return currentTime_2;
	}
	 
	/**
	  * 获取现在时间
	  * 
	  * @return返回短时间格式 yyyy-MM-dd
	  */
	public static Date getNowDateShort() {
	  Date currentTime = new Date();
	  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	  String dateString = formatter.format(currentTime);
	  ParsePosition pos = new ParsePosition(8);
	  Date currentTime_2 = formatter.parse(dateString, pos);
	  return currentTime_2;
	}
	 
	/**
	  * 获取现在时间
	  * 
	  * @return返回字符串格式 yyyy-MM-dd HH:mm:ss
	  */
	public static String getStringDate() {
	  Date currentTime = new Date();
	  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	  String dateString = formatter.format(currentTime);
	  return dateString;
	}
	 
	/**
	  * 获取现在时间
	  * 
	  * @return 返回短时间字符串格式yyyy-MM-dd
	  */
	public static String getStringDateShort() {
	  Date currentTime = new Date();
	  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	  String dateString = formatter.format(currentTime);
	  return dateString;
	}
	/**
	 * 获取现在时间
	 *
	 * @return返回短时间格式 yyyy年MM月dd日
	 */
	public static String getNowDateShortCN() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日");
		String dateString = formatter.format(currentTime);
		return dateString;
	}
	/**
	 * 把long类型的转换成对应的时间格式
	 * @param pattern
	 * @param dateTime
	 * @return
	 */
	public static String getFormatDateTime(String pattern, long dateTime){
		Date d = new Date(dateTime);
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(d);
	}
	/**
	  * 获取时间 小时:分;秒 HH:mm:ss
	  * 
	  * @return
	  */
	public static String getTimeShort() {
	  SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
	  Date currentTime = new Date();
	  String dateString = formatter.format(currentTime);
	  return dateString;
	}
	 
	/**
	  * 将长时间格式字符串转换为时间 yyyy-MM-dd HH:mm:ss
	  * 
	  * @param strDate
	  * @return
	  */
	public static Date strToDateLong(String strDate) {
	  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	  ParsePosition pos = new ParsePosition(0);
	  Date strtodate = formatter.parse(strDate, pos);
	  return strtodate;
	}
	 
	/**  * 将长时间格式时间转换为字符串 yyyy-MM-dd HH:mm:ss  *   * @param dateDate  * @return  */
	public static String dateToStrLong(Date dateDate) {
	  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	  String dateString = formatter.format(dateDate);
	  return dateString;
	}
	/**
	 * 把毫秒转化成日期
	 * @param dateFormat(日期格式，例如：MM/ dd/yyyy HH:mm:ss)
	 * @param millSec(毫秒数)
	 * @return
	 */
	public static String transferLongToDate(String dateFormat, Long millSec){
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		Date date= new Date(millSec);
		return sdf.format(date);
	}
	/**
	 * 把字符毫秒转化成日期
	 * @param dateFormat(日期格式，例如：MM/ dd/yyyy HH:mm:ss)
	 * @param millSec(毫秒数)
	 * @return
	 */
	public static String transferStringToDate(String dateFormat, String millSec){
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		Date date= new Date(Long.valueOf(millSec).longValue()*1000);
		return sdf.format(date);
	}
	/**

	  * 将短时间格式时间转换为字符串 yyyy-MM-dd
	  * 
	  * @param dateDate
	  * @return
	  */
	public static String dateToStr(Date dateDate) {
	  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	  String dateString = formatter.format(dateDate);
	  return dateString;
	}
	/**
	 * 将短时间格式时间转换为字符串 MM月dd日
	 *
	 * @param date
	 * @return
	 */
	public static String dataToStr(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("MM月dd日");
		String dateString = formatter.format(date);
		return dateString;
	}
	/**
	 * 获取版本号
	 * @return 当前应用的版本号
	 */
	public static String getVersion(Context context) {
		try {
			PackageManager manager = context.getPackageManager();
			PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
			String version = info.versionName;
			return version;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	/**
	  * 将短时间格式字符串转换为时间 yyyy-MM-dd 
	  * 
	  * @param strDate
	  * @return
	  */
	public static Date strToDate(String strDate) {
	  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	  ParsePosition pos = new ParsePosition(0);
	  Date strtodate = formatter.parse(strDate, pos);
	  return strtodate;
	}

	/**
	 * 把字符串根据传入的时间格式转换成date
	 * @param strDate
	 * @param formatDate
     * @return
     */
	public static Date strToDate(String strDate, String formatDate){
		SimpleDateFormat formatter = new SimpleDateFormat(formatDate);
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(strDate, pos);
		return strtodate;
	}
	/**
	  * 得到现在时间
	  * 
	  * @return
	  */
	public static Date getNow() {
	  Date currentTime = new Date();
	  return currentTime;
	}
	 
	/**
	  * 提取一个月中的最后一天
	  * 
	  * @param day
	  * @return
	  */
	public static Date getLastDate(long day) {
	  Date date = new Date();
	  long date_3_hm = date.getTime() - 3600000 * 34 * day;
	  Date date_3_hm_date = new Date(date_3_hm);
	  return date_3_hm_date;
	}
	 
	/**
	  * 得到现在时间
	  * 
	  * @return 字符串 yyyyMMdd HHmmss
	  */
	public static String getStringToday() {
	  Date currentTime = new Date();
	  SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd HHmmss");
	  String dateString = formatter.format(currentTime);
	  return dateString;
	}
	 
	/**
	  * 得到现在小时
	  */
	public static String getHour() {
	  Date currentTime = new Date();
	  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	  String dateString = formatter.format(currentTime);
	  String hour;
	  hour = dateString.substring(11, 13);
	  return hour;
	}
	 
	/**
	  * 得到现在分钟
	  * 
	  * @return
	  */
	public static String getTime() {
	  Date currentTime = new Date();
	  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	  String dateString = formatter.format(currentTime);
	  String min;
	  min = dateString.substring(14, 16);
	  return min;
	}
	 
	/**
	  * 根据用户传入的时间表示格式，返回当前时间的格式 如果是yyyyMMdd，注意字母y不能大写。
	  * 
	  * @param sformat
	  *            yyyyMMddhhmmss
	  * @return
	  */
	public static String getUserDate(String sformat) {
	  Date currentTime = new Date();
	  SimpleDateFormat formatter = new SimpleDateFormat(sformat);
	  String dateString = formatter.format(currentTime);
	  return dateString;
	}
	 
	/**
	  * 二个小时时间间的差值,必须保证二个时间都是"HH:MM"的格式，返回字符型的分钟
	  */
	public static String getTwoHour(String st1, String st2) {
	  String[] kk = null;
	  String[] jj = null;
	  kk = st1.split(":");
	  jj = st2.split(":");
	  if (Integer.parseInt(kk[0]) < Integer.parseInt(jj[0]))
	   return "0";
	  else {
	   double y = Double.parseDouble(kk[0]) + Double.parseDouble(kk[1]) / 60;
	   double u = Double.parseDouble(jj[0]) + Double.parseDouble(jj[1]) / 60;
	   if ((y - u) > 0)
	    return y - u + "";
	   else
	    return "0";
	  }
	}

	/**
	 * 得到二个日期间的间隔天数
	 * @param sj1
	 * @param sj2
     * @return 二个日期间的间隔天数
     */
	public static String getTwoDay(String sj1, String sj2) {
	  SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
	  long day = 0;
	  try {
	   Date date = myFormatter.parse(sj1);
	   Date mydate = myFormatter.parse(sj2);
	   day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
	  } catch (Exception e) {
	   return "";
	  }
	  return day + "";
	}

	/**
	 * 时间前推或后推分钟,其中JJ表示分钟.
	 * @param sj1
	 * @param jj
     * @return 时间前推或后推分钟
     */
	public static String getPreTime(String sj1, String jj) {
	  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	  String mydate1 = "";
	  try {
	   Date date1 = format.parse(sj1);
	   long Time = (date1.getTime() / 1000) + Integer.parseInt(jj) * 60;
	   date1.setTime(Time * 1000);
	   mydate1 = format.format(date1);
	  } catch (Exception e) {
	  }
	  return mydate1;
	}

	/**
	 * 得到一个时间延后或前移几天的时间,nowdate为时间,delay为前移或后延的天数
	 * @param nowdate
	 * @param delay
     * @return 前移或后延的天数
     */
	public static String getNextDay(String nowdate, String delay) {
	  try{
	  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	  String mdate = "";
	  Date d = strToDate(nowdate);
	  long myTime = (d.getTime() / 1000) + Integer.parseInt(delay) * 24 * 60 * 60;
	  d.setTime(myTime * 1000);
	  mdate = format.format(d);
	  return mdate;
	  }catch(Exception e){
	   return "";
	  }
	}
	 
	/**
	  * 判断是否润年
	  * 
	  * @param ddate
	  * @return 是否润年
	  */
	public static boolean isLeapYear(String ddate) {
	 
	  /**
	   * 详细设计： 1.被400整除是闰年，否则： 2.不能被4整除则不是闰年 3.能被4整除同时不能被100整除则是闰年
	   * 3.能被4整除同时能被100整除则不是闰年
	   */
	  Date d = strToDate(ddate);
	  GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
	  gc.setTime(d);
	  int year = gc.get(Calendar.YEAR);
	  if ((year % 400) == 0)
	   return true;
	  else if ((year % 4) == 0) {
	   if ((year % 100) == 0)
	    return false;
	   else
	    return true;
	  } else
	   return false;
	}
	 
	/**
	  * 返回美国时间格式 26 Apr 2006
	  * 
	  * @param str
	  * @return 美国时间格式
	  */
	public static String getEDate(String str) {
	  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	  ParsePosition pos = new ParsePosition(0);
	  Date strtodate = formatter.parse(str, pos);
	  String j = strtodate.toString();
	  String[] k = j.split(" ");
	  return k[2] + k[1].toUpperCase() + k[5].substring(2, 4);
	}
	 
	/**
	  * 获取一个月的最后一天
	  * 
	  * @param dat
	  * @return 一个月的最后一天
	  */
	public static String getEndDateOfMonth(String dat) {// yyyy-MM-dd
	  String str = dat.substring(0, 8);
	  String month = dat.substring(5, 7);
	  int mon = Integer.parseInt(month);
	  if (mon == 1 || mon == 3 || mon == 5 || mon == 7 || mon == 8 || mon == 10 || mon == 12) {
	   str += "31";
	  } else if (mon == 4 || mon == 6 || mon == 9 || mon == 11) {
	   str += "30";
	  } else {
	   if (isLeapYear(dat)) {
	    str += "29";
	   } else {
	    str += "28";
	   }
	  }
	  return str;
	}
	 
	/**
	  * 判断二个时间是否在同一个周
	  * 
	  * @param date1
	  * @param date2
	  * @return 二个时间是否在同一个周
	  */
	public static boolean isSameWeekDates(Date date1, Date date2) {
	  Calendar cal1 = Calendar.getInstance();
	  Calendar cal2 = Calendar.getInstance();
	  cal1.setTime(date1);
	  cal2.setTime(date2);
	  int subYear = cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR);
	  if (0 == subYear) {
	   if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR))
	    return true;
	  } else if (1 == subYear && 11 == cal2.get(Calendar.MONTH)) {
	   // 如果12月的最后一周横跨来年第一周的话则最后一周即算做来年的第一周
	   if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR))
	    return true;
	  } else if (-1 == subYear && 11 == cal1.get(Calendar.MONTH)) {
	   if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR))
	    return true;
	  }
	  return false;
	}
	 
	/**
	  * 产生周序列,即得到当前时间所在的年度是第几周
	  * 
	  * @return 得到当前时间所在的年度是第几周
	  */
	public static String getSeqWeek() {
	  Calendar c = Calendar.getInstance(Locale.CHINA);
	  String week = Integer.toString(c.get(Calendar.WEEK_OF_YEAR));
	  if (week.length() == 1)
	   week = "0" + week;
	  String year = Integer.toString(c.get(Calendar.YEAR));
	  return year + week;
	}
	 
	/**
	  * 获得一个日期所在的周的星期几的日期，如要找出2002年2月3日所在周的星期一是几号
	  * 
	  * @param sdate
	  * @param
	  * @return 一个日期所在的周的星期几的日期
	  */
	public static String getWeek(String sdate, String num) {
	  // 再转换为时间
	  Date dd = strToDate(sdate);
	  Calendar c = Calendar.getInstance();
	  c.setTime(dd);
	  if (num.equals("1")) // 返回星期一所在的日期
	   c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
	  else if (num.equals("2")) // 返回星期二所在的日期
	   c.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
	  else if (num.equals("3")) // 返回星期三所在的日期
	   c.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
	  else if (num.equals("4")) // 返回星期四所在的日期
	   c.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
	  else if (num.equals("5")) // 返回星期五所在的日期
	   c.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
	  else if (num.equals("6")) // 返回星期六所在的日期
	   c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
	  else if (num.equals("0")) // 返回星期日所在的日期
	   c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
	  return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
	}
	 
	/**
	  * 根据一个日期，返回是星期几的字符串
	  * 
	  * @param sdate
	  * @return
	  */
	public static String getWeek(String sdate) {
	  // 再转换为时间
	  Date date = strToDate(sdate);
	  Calendar c = Calendar.getInstance();
	  c.setTime(date);
	  // int hour=c.get(Calendar.DAY_OF_WEEK);
	  // hour中存的就是星期几了，其范围 1~7
	  // 1=星期日 7=星期六，其他类推
	  return new SimpleDateFormat("EEEE").format(c.getTime());
	}

	/**
	 * 获取星期几
	 * @param sdate
	 * @return
     */
	public static String getWeekStr(String sdate){
	  String str = "";
	  str = getWeek(sdate);
	  if("1".equals(str)){
	   str = "星期日";
	  }else if("2".equals(str)){
	   str = "星期一";
	  }else if("3".equals(str)){
	   str = "星期二";
	  }else if("4".equals(str)){
	   str = "星期三";
	  }else if("5".equals(str)){
	   str = "星期四";
	  }else if("6".equals(str)){
	   str = "星期五";
	  }else if("7".equals(str)){
	   str = "星期六";
	  }
	  return str;
	}
	/**
	  * 两个时间之间的天数
	  * @param date1
	  * @param date2
	  * @return
	  */
	public static long getDays(String date1, String date2) {
	  if (date1 == null || date1.equals(""))
	   return 0;
	  if (date2 == null || date2.equals(""))
	   return 0;
	  // 转换为标准时间
	  SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
	  Date date = null;
	  Date mydate = null;
	  try {
	   date = myFormatter.parse(date1);
	   mydate = myFormatter.parse(date2);
	  } catch (Exception e) {
	  }
	  long day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
	  return day;
	}
	/**
	  * 形成如下的日历 ， 根据传入的一个时间返回一个结构 星期日 星期一 星期二 星期三 星期四 星期五 星期六 下面是当月的各个时间
	  * 此函数返回该日历第一行星期日所在的日期
	  * 
	  * @param sdate
	  * @return
	  */
	public static String getNowMonth(String sdate) {
	  // 取该时间所在月的一号
	  sdate = sdate.substring(0, 8) + "01";
	  // 得到这个月的1号是星期几
	  Date date =strToDate(sdate);
	  Calendar c = Calendar.getInstance();
	  c.setTime(date);
	  int u = c.get(Calendar.DAY_OF_WEEK);
	  String newday = getNextDay(sdate, (1 - u) + "");
	  return newday;
	}
	 
	/**
	  * 返回一个随机数
	  * 
	  * @param i
	  * @return
	  */
	public static String getRandom(int i) {
	  Random jjj = new Random();
	  // int suiJiShu = jjj.nextInt(9);
	  if (i == 0)
	   return "";
	  String jj = "";
	  for (int k = 0; k < i; k++) {
	   jj = jj + jjj.nextInt(9);
	  }
	  return jj;
	}
	private static final String[] WEEK_CN_NAME = { "周一", "周二", "周三", "周四",
			"周五", "周六", "周日" };

	/**
	 * 通过传入的date时间对象获取对应的星期数
	 * @param date
	 * @return
     */
	public static String getDateWeekCnName(Date date) {//通过传入date对象,获取对应的星期数
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
		String mWay = String.valueOf(c.get(Calendar.DAY_OF_WEEK));
		if ("1".equals(mWay)) {
			mWay = WEEK_CN_NAME[6];
		} else if ("2".equals(mWay)) {
			mWay = WEEK_CN_NAME[0];
		} else if ("3".equals(mWay)) {
			mWay = WEEK_CN_NAME[1];
		} else if ("4".equals(mWay)) {
			mWay = WEEK_CN_NAME[2];
		} else if ("5".equals(mWay)) {
			mWay = WEEK_CN_NAME[3];
		} else if ("6".equals(mWay)) {
			mWay = WEEK_CN_NAME[4];
		} else if ("7".equals(mWay)) {
			mWay = WEEK_CN_NAME[5];
		}
		return mWay;
	}

	/**
	 * 根据传入的字符时间获取对应的星期数
	 * @param date 传入格式为: yyyy-MM-dd
	 * @return
     */
	public static String getDateWeekCnName(String date) {
		Date toDate = strToDate(date);
		Calendar c = Calendar.getInstance();
		c.setTime(toDate);
		c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
		String mWay = String.valueOf(c.get(Calendar.DAY_OF_WEEK));
		if ("1".equals(mWay)) {
			mWay = WEEK_CN_NAME[6];
		} else if ("2".equals(mWay)) {
			mWay = WEEK_CN_NAME[0];
		} else if ("3".equals(mWay)) {
			mWay = WEEK_CN_NAME[1];
		} else if ("4".equals(mWay)) {
			mWay = WEEK_CN_NAME[2];
		} else if ("5".equals(mWay)) {
			mWay = WEEK_CN_NAME[3];
		} else if ("6".equals(mWay)) {
			mWay = WEEK_CN_NAME[4];
		} else if ("7".equals(mWay)) {
			mWay = WEEK_CN_NAME[5];
		}
		return mWay;
	}
	/**
	 * 获取时间
	 * @param timeMillis
	 * @param pattern
	 * @return
	 */
	public static String timeFormat(long timeMillis, String pattern){
		SimpleDateFormat format = new SimpleDateFormat(pattern, Locale.CHINA);
		return format.format(new Date(timeMillis));
	}

	/**
	 * 获取照片的时间
	 * @param time
	 * @param timeType
	 * @return
	 */
	public static String formatPhotoDate(long time, String timeType){
		return timeFormat(time, timeType);
	}

	/**
	 * 获取照片时间排列顺序
	 * @param path
	 * @param timeType
	 * @return
	 */
	public static String formatPhotoDate(String path, String timeType){
		File file = new File(path);
		if(file.exists()){
			long time = file.lastModified();
			return formatPhotoDate(time,timeType);
		}
		return "1970-01-01";
	}
	/**
	 * 是否是闰年
	 * @param year
	 * @return
	 */
	public static boolean isLeap(int year) {
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
			return true;
		else
			return false;
	}
	/**
	 * 取得数据库主键 生成格式为yyyymmddhhmmss+k位随机数
	 *
	 * @param k
	 *            表示是取几位随机数，可以自己定
	 */

	public static String getNo(int k) {

		return getUserDate("yyyyMMddhhmmss") + getRandom(k);
	}

	/**
	 * 通过年份和月份 得到当月的日子
	 *
	 * @param year
	 * @param month
	 * @return 当月的日子
	 */
	public static int getMonthDays(int year, int month) {
		month++;
		switch (month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				return 31;
			case 4:
			case 6:
			case 9:
			case 11:
				return 30;
			case 2:
				if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)){
					return 29;
				}else{
					return 28;
				}
			default:
				return  -1;
		}
	}
	/**
	 * 返回当前月份1号位于周几
	 * @param year
	 * 		年份
	 * @param month
	 * 		月份，传入系统获取的，不需要正常的
	 * @return
	 * 	日：1		一：2		二：3		三：4		四：5		五：6		六：7
	 */
	public static int getFirstDayWeek(int year, int month){
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, 1);
//		Log.d("DateView", "DateView:First:" + calendar.getFirstDayOfWeek());
		return calendar.get(Calendar.DAY_OF_WEEK);
	}
	/**
	 * 获取两个字符串时间之间的相隔时间  字符串时间格式必须为:yyyy-MM-dd HH:mm:ss
	 * @param time1 字符串时间格式:yyyy-MM-dd HH:mm:ss
	 * @param time2 字符串时间格式:yyyy-MM-dd HH:mm:ss
	 * @return  days+"天"+hours+"小时"+minutes+"分"
	 */
	public static String getTwoDaysBetweenDays(String time1, String time2){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date d1 = df.parse(time1);
			Date d2 = df.parse(time2);
			// 转换成long类型的时间相减,这样得到的差值是微秒级别
			long diff = d1.getTime() - d2.getTime();
//			格式装换
			long days = diff / (1000 * 60 * 60 * 24);
			long hours = (diff-days*(1000 * 60 * 60 * 24))/(1000* 60 * 60);
			long minutes = (diff-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60))/(1000* 60);
			Log.e("DateUtils",""+days+"天"+hours+"小时"+minutes+"分");
			return days+"天"+hours+"小时"+minutes+"分";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}

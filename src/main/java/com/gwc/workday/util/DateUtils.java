package com.gwc.workday.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 日期工具类
 *
 * @author chenggaowei Created on 2018-03-31 14:52
 **/
public class DateUtils {

  private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

  /**
   * 计算某天加上几天之后的日期
   * @param date 要计算的日期
   * @param days 天数
   * @return 返回的日期
   * @throws ParseException
   */
  public static String plusDays(String date, Integer days) throws ParseException {
    Calendar cal = Calendar.getInstance();
    cal.setTime(sdf.parse(date));
    cal.add(Calendar.DATE, days);
    Date dateReturn = cal.getTime();
    return sdf.format(dateReturn);
  }

  /**
   * 是否是日期
   * @param str
   * @return
   */
  public static boolean isDate(String str){
    Pattern pattern = Pattern.compile("^(\\d{4})-(\\d{1,2})-(\\d{1,2})$");
    Matcher isNum = pattern.matcher(str);
    if (!isNum.matches()) {
      return false;
    }
    return true;
  }


}

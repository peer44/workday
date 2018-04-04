package com.gwc.workday.service;

import com.gwc.workday.dao.WorkDayDao;
import com.gwc.workday.entity.WorkDay;
import com.gwc.workday.util.DateUtils;
import java.text.ParseException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * 工作日service
 *
 * @author chenggaowei
 * @version V1.0
 * @description: 验证事务
 * @date 2017-09-21 22:35
 */
@Service
@CacheConfig(cacheNames = "workdays")
public class WorkDayService {

  @Autowired
  private WorkDayDao workDayDao;

  /**
   * 删除节假日
   *
   * @param date 给定的节假日 yyyy-MM-dd
   */
  @CacheEvict(key = "#date")
  public void delete(String date) {
    WorkDay workDay = workDayDao.findFirstByDate(date);
    workDayDao.delete(workDay);
  }

  /**
   * 更新节假日
   *
   * @param date yyyy-MM-dd
   * @return 返回更新后的数据
   */
  @CacheEvict(key = "#date")
  public WorkDay save(String date) {
    WorkDay workDay = workDayDao.findFirstByDate(date);
    if (ObjectUtils.isEmpty(workDay)) {
      workDay = new WorkDay();
    }
    workDay.setDate(date);
    workDay.setIsWorkDay(false);
    return workDayDao.save(workDay);
  }

  /**
   * 判断指定的日期是不是工作日
   *
   * @param date 给定的日期 yyyy-MM-dd
   * @return true是工作日，false不是工作日
   */
  @Cacheable(key = "#date")
  public boolean isWorkDay(String date) {
    WorkDay holiday = workDayDao.findFirstByDate(date);
    return ObjectUtils.isEmpty(holiday) ? true : false;
  }

  /**
   * 在给定日期区间内查找节假日
   *
   * @param start 开始日期
   * @param end 结束日期
   * @return 节假日列表
   */
  public List<WorkDay> findHolidays(String start, String end) {
    Sort sort = new Sort(Sort.Direction.ASC, "date");
    List<WorkDay> workDays = workDayDao.findByDateBetween(start, end, sort);
    return workDays;
  }

  /**
   * 查询某一年的工作日
   */
  public List<WorkDay> findByYear(String year) {
    Sort sort = new Sort(Sort.Direction.ASC, "date");
    List<WorkDay> workDays = workDayDao.findByDateGreaterThanEqual(year + "-01-01", sort);
    return workDays;
  }

  /**
   * 给定日期之前/后的工作日
   *
   * @param date 给定的日期
   * @param days 多少天
   * @return 工作日
   */
  public String afterDays(String date, Integer days) throws ParseException {

    // 控制向前还是向后
    boolean position = days > 0 ? true : false;
    int size = Math.abs(days);
    while (size > 0) {
      if (position) {
        date = DateUtils.plusDays(date, 1);
      } else {
        date = DateUtils.plusDays(date, -1);
      }
      if (isWorkDay(date)) {
        size--;
      }
    }
    return date;
  }

}

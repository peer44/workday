package com.gwc.workday.service;

import com.gwc.workday.dao.WorkDayDao;
import com.gwc.workday.entity.WorkDay;
import com.gwc.workday.util.DateUtils;
import java.text.ParseException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * 工作日service
 *
 * @author chenggaowei
 * @version V1.0
 * @description: 验证事务
 * @date 2017-09-21 22:35
 */
@Service
public class WorkDayService {

  @Autowired
  private WorkDayDao workDayDao;

  public void delete(String date) {
    List<WorkDay> workDayList = workDayDao.findByDate(date);
    WorkDay workDay = new WorkDay();
    workDay.setDate(date);
    workDay.setIsWorkDay(false);
    if (!CollectionUtils.isEmpty(workDayList)) {
      workDay.setId(workDayList.get(0).getId());
    }
    workDayDao.delete(workDay);
  }

  public WorkDay save(String date) {
    List<WorkDay> workDayList = workDayDao.findByDate(date);
    WorkDay workDay = new WorkDay();
    workDay.setDate(date);
    workDay.setIsWorkDay(false);
    if (!CollectionUtils.isEmpty(workDayList)) {
      workDay.setId(workDayList.get(0).getId());
    }
    return workDayDao.save(workDay);
  }

  public Boolean isWorkDay(String date) {
    List<WorkDay> holidays = workDayDao.findByDate(date);
    if (!CollectionUtils.isEmpty(holidays)) {
      return false;
    }
    return true;
  }

  public List<WorkDay> findAllHolidays() {
    Sort sort = new Sort(Sort.Direction.ASC, "date");
    List<WorkDay> workDays = workDayDao.findAll(sort);
    return workDays;
  }

  public List<WorkDay> findByYear(String year) {
    Sort sort = new Sort(Sort.Direction.ASC, "date");
    List<WorkDay> workDays = workDayDao.findByDateGreaterThanEqual(year + "-01-01", sort);
    return workDays;
  }

  public String afterDays(String date, Integer days) throws ParseException {

    // 控制向前还是向后
    Boolean position = days > 0 ? true : false;
    int size = Math.abs(days);
    while (size > 0) {
      if (position == true) {
        date = DateUtils.plusDays(date, 1);
      } else {
        date = DateUtils.plusDays(date, -1);
      }
      if (isWorkDay(date) == true) {
        size--;
      }
    }
    return date;
  }

}

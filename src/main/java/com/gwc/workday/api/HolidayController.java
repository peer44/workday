package com.gwc.workday.api;

import com.gwc.workday.entity.WorkDay;
import com.gwc.workday.service.WorkDayService;
import com.gwc.workday.vo.EventVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 节假日controller
 *
 * @author chenggaowei Created on 2018-03-31 11:20
 **/
@Api(value = "HolidayController", description = "节假日相关API", tags = {"HolidayController"})
@Controller
public class HolidayController {

  @Autowired
  private WorkDayService workDayService;

  @ApiOperation(value = "日历首页")
  @GetMapping(value = "index")
  public String index() {
    return "calendar";
  }

  @ApiOperation(value = "添加节假日，YYYY-MM-DD格式")
  @PostMapping(value = "holiday/add")
  @ResponseBody
  public WorkDay add(String date) {
    WorkDay workDay = workDayService.save(date);
    return workDay;
  }

  @ApiOperation(value = "删除节假日，YYYY-MM-DD格式")
  @PostMapping(value = "holiday/delete")
  @ResponseBody
  public Boolean delete(String date) {
    try {
      workDayService.delete(date);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  @ApiOperation(value = "加载节假日")
  @GetMapping(value = "holiday/init")
  @ResponseBody
  public List<EventVO> init() {
    List<WorkDay> workDays = workDayService.findAllHolidays();
    List<EventVO> events = new ArrayList<>();
    if (!CollectionUtils.isEmpty(workDays)) {
      workDays.forEach(workDay -> {
        EventVO event = new EventVO(workDay.getDate());
        events.add(event);
      });
    }
    return events;
  }

}

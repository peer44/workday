package com.gwc.workday.api;

import com.gwc.workday.service.WorkDayService;
import com.gwc.workday.util.DateUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.text.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 工作日controller
 *
 * @author chenggaowei Created on 2018-03-31 11:20
 **/
@Api(value = "WorkDayController", description = "工作日相关API", tags = {"WorkDayController"})
@RestController
public class WorkDayController {

  @Autowired
  private WorkDayService workDayService;


  @ApiOperation(value = "判断某天是不是工作日，YYYY-MM-DD格式")
  @GetMapping(value = "workday/isWorkDay")
  public Boolean isWorkDay(String date) {
    return workDayService.isWorkDay(date);
  }


  @ApiOperation(value = "从date开始向前days/后-days个工作日后的工作日，YYYY-MM-DD格式")
  @GetMapping(value = "workday/afterDays")
  public String afterDays(String date, Integer days) throws ParseException {
    return workDayService.afterDays(date, days);
  }

}

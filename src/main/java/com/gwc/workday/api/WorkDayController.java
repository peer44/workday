package com.gwc.workday.api;

import com.gwc.workday.service.WorkDayService;
import com.gwc.workday.util.DateUtils;
import com.gwc.workday.util.ResponseUtil;
import com.gwc.workday.vo.ResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.text.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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


  @ApiOperation(value = "判断某天是不是工作日")
  @GetMapping(value = "workday/isWorkDay")
  public ResponseVO<Boolean> isWorkDay(
      @ApiParam(value = "具体的时间，yyyy-MM-dd") @RequestParam String date) {
    if (!DateUtils.isDate(date)) {
      return ResponseUtil.paramError("时间必须满足yyyy-MM-dd，比如2018-01-01");
    }
    return ResponseUtil.success(workDayService.isWorkDay(date));
  }


  @ApiOperation(value = "从date开始向前days/后-days个工作日后的工作日，YYYY-MM-DD格式")
  @GetMapping(value = "workday/afterDays")
  public ResponseVO<String> afterDays(
      @ApiParam(value = "具体的时间，yyyy-MM-dd") @RequestParam String date,
      @ApiParam(value = "间隔天数，整数（可以为负）") @RequestParam Integer days)
      throws ParseException {
    if (!DateUtils.isDate(date)) {
      return ResponseUtil.paramError("时间必须满足yyyy-MM-dd，比如2018-01-01");
    }
    return ResponseUtil.success(workDayService.afterDays(date, days));
  }

}

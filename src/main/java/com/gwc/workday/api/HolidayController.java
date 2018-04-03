package com.gwc.workday.api;

import com.gwc.workday.entity.WorkDay;
import com.gwc.workday.service.WorkDayService;
import com.gwc.workday.vo.EventVO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 节假日controller
 *
 * @author chenggaowei Created on 2018-03-31 11:20
 **/
@ApiIgnore
@Controller
public class HolidayController {

  @Autowired
  private WorkDayService workDayService;

  @GetMapping(value = "index")
  public String index() {
    return "calendar";
  }

  @PostMapping(value = "holiday/add")
  @ResponseBody
  public WorkDay add(String date) {
    WorkDay workDay = workDayService.save(date);
    return workDay;
  }

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

  @GetMapping(value = "holiday/init")
  @ResponseBody
  public List<EventVO> init(String start, String end) {
    List<WorkDay> workDays = workDayService.findHolidays(start, end);
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

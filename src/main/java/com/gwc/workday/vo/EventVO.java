package com.gwc.workday.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * fullcalander 渲染的event
 *
 * @author chenggaowei Created on 2018-03-31 12:32
 **/
@Getter
@Setter
@ToString
@NoArgsConstructor
@ApiModel(value = "EventVO", description = "fullcalander渲染的event")
public class EventVO {

  @ApiModelProperty(value = "id")
  private String id;
  @ApiModelProperty(value ="显示的内容")
  private String title;
  private Boolean allDay;
  /**
   * The date/time an event begins
   */
  private String start;
  /**
   * The exclusive date/time an event ends
   */
  private String end;
  /**
   *  event's background and border color
   */
  private String color;
  /**
   * Sets an event's background color
   */
  private String backgroundColor;
  /**
   * Sets an event's text color
   */
  private String textColor;

  private String rendering;

  public EventVO(String start) {
    this.id = start;
    this.title = "假";
    this.allDay = true;
    this.start = start;
    this.color="#54FF9F";
    this.backgroundColor = this.color;
    this.textColor="#000000";
    // this.rendering = "background";
  }
}

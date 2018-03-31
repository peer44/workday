package com.gwc.workday.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * user.
 *
 * @author chenggaowei
 * @version V1.0
 * @description: 用户
 * @date 2017-09-21 21:58
 */
@Getter
@Setter
@ToString
@Entity
public class WorkDay {

  @Id
  @GeneratedValue
  private Integer id;
  private String date;
  /**
   * 是否工作日，添加的都是休息日，所以都是false
   */
  private Boolean isWorkDay;
}

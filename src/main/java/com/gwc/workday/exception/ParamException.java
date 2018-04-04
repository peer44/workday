package com.gwc.workday.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author chenggaowei
 * @version V1.0
 * @description: 自定义异常
 * @date 2017-09-25 14:33
 */
@Setter
@Getter
@ToString
public class ParamException extends RuntimeException {

  public ParamException(String message) {
    super(message);
  }
}

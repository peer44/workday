package com.gwc.workday.handler;

import com.gwc.workday.enums.ErrorCode;
import com.gwc.workday.util.ResponseUtil;
import com.gwc.workday.vo.ResponseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理
 */
@ControllerAdvice
public class HandleException {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @ExceptionHandler(value = Exception.class)
  @ResponseBody
  public ResponseVO handle(Exception e) {
    logger.error("未知错误:{}", e);
    return ResponseUtil.error(ErrorCode.END_ERROR);
  }
}

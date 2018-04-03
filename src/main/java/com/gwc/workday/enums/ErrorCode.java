package com.gwc.workday.enums;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum ErrorCode {

  // 操作成功
  SUCCESS(0, "请求成功"),

  // 用户权限问题
  TOKEN_INVALID(40001, "登录凭证过期"),

  // 输入参数问题
  INPUT_PARAM_ERROR(40035, "输入参数有误相关"),

  // 后端代码异常
  END_ERROR(-1, "系统繁忙，此时请开发者稍候再试");

  private Integer code;
  private String message;

  ErrorCode(Integer code, String message) {
    this.code = code;
    this.message = message;
  }

}

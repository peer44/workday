package com.gwc.workday.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 返回值
 */
@Getter
@Setter
@ToString
@ApiModel(value = "ResponseVO", description = "请求返回数据")
public class ResponseVO<T> {

  @ApiModelProperty(value = "返回码(正确为0)", required = true)
  private int errorCode;

  @ApiModelProperty(value = "操作结果的相关信息", position = 1)
  private String message;

  @ApiModelProperty(value = "返回数据", position = 2)
  private T data;

}

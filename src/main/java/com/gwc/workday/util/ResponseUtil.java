package com.gwc.workday.util;

import com.gwc.workday.enums.ErrorCode;
import com.gwc.workday.vo.ResponseVO;
import org.springframework.util.StringUtils;

/**
 * 统一返回数据
 */
public class ResponseUtil {

  /**
   * 操作成功没有数据返回
   */
  public static ResponseVO success() {
    ResponseVO ResponseVO = new ResponseVO();
    ResponseVO.setErrorCode(ErrorCode.SUCCESS.getCode());
    ResponseVO.setMessage("请求成功");
    ResponseVO.setData(null);
    return ResponseVO;
  }

  /**
   * 操作成功并返回数据
   */
  public static ResponseVO success(Object data) {
    ResponseVO ResponseVO = new ResponseVO();
    ResponseVO.setErrorCode(ErrorCode.SUCCESS.getCode());
    ResponseVO.setMessage("请求成功");
    ResponseVO.setData(data);
    return ResponseVO;
  }

  /**
   * 错误返回
   */
  public static ResponseVO error(ErrorCode errorCode) {
    ResponseVO responseVO = new ResponseVO();
    responseVO.setErrorCode(errorCode.getCode());
    responseVO.setMessage(errorCode.getMessage());
    return responseVO;
  }

  /**
   * 参数错误
   */
  public static ResponseVO paramError() {
    ResponseVO responseVO = new ResponseVO();
    responseVO.setErrorCode(ErrorCode.INPUT_PARAM_ERROR.getCode());
    responseVO.setMessage(ErrorCode.INPUT_PARAM_ERROR.getMessage());
    return responseVO;
  }

  /**
   * 参数错误
   */
  public static ResponseVO paramError(String message) {
    ResponseVO responseVO = new ResponseVO();
    responseVO.setErrorCode(ErrorCode.INPUT_PARAM_ERROR.getCode());
    if (StringUtils.isEmpty(message)) {
      responseVO.setMessage(ErrorCode.INPUT_PARAM_ERROR.getMessage());
    } else {
      responseVO.setMessage(message);
    }
    return responseVO;
  }

}

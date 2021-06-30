package com.xdcplus.xdcweb.global.enums;

import org.springframework.http.HttpStatus;

/**
 *  数据信息状态枚举类
 * @author Rong.Jia
 * @date 2019/4/2
 */
public enum ResponseEnum {

    /**
     *  枚举类code 开头使用规则：
     *  0: 成功；
     *  -1: 失败；
     *  1：参数不正确
     *  401： 登录相关  需跳登录
     *  404：未找到
     *  405：请求方式错误
     *  415：媒体类型不支持
     *
     *  1000: 公共
     */

    // 成功
    SUCCESS(0,"成功"),

    // 参数不正确
    PARAMETER_ERROR(1, "参数不正确"),

    // 失败
    ERROR(-1, "失败"),
    SYSTEM_ERROR(-1, "系统错误"),
    INT404_NOT_FOUND(-1,"找不到请求接口"),
    INT400_BAD_REQUEST(-1,"请求参数或方式错误"),
    FILE_LIMIT_EXCEEDED(-1, "文件超出限制, 请选择较小文件"),

    // 未找到
    NOT_FOUND(HttpStatus.NOT_FOUND.value(), "请求接口不存在"),

    // 请求方式错误
    REQUEST_MODE_ERROR(HttpStatus.METHOD_NOT_ALLOWED.value(), "请求方式错误, 请检查"),

    //媒体类型不支持
    MEDIA_TYPE_NOT_SUPPORTED(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value(), "媒体类型不支持"),


    THE_PARAMETER_TYPE_IS_INCORRECT(1000, "参数类型不正确"),
    REQUEST_PARAMETER_FORMAT_IS_INCORRECT(1001, "请求参数格式不正确"),



















    ;

    private Integer code;
    private String message;

    ResponseEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

package com.xdcplus.xdcweb.global.exception;

import com.xdcplus.xdcweb.global.enums.ResponseEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 *   项目自定义异常
 * @author Rong.Jia
 * @date 2019/4/3
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class XdcWebException extends RuntimeException  implements Serializable {

    private static final long serialVersionUID = -1501020198729282518L;

    /**
     *  异常code 码
     */
    private Integer code;

    /**
     * 异常详细信息
     */
    private String message;

    public XdcWebException(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    public XdcWebException(ResponseEnum responseEnum) {
        super(responseEnum.getMessage());
        this.code = responseEnum.getCode();
        this.message = responseEnum.getMessage();
    }

    public XdcWebException(ResponseEnum responseEnum, String message) {
        super(message);
        this.code = responseEnum.getCode();
        this.message = message;
    }

    public XdcWebException(Integer code, String message, Throwable t) {
        super(message, t);
        this.code = code;
        this.message = message;
    }

    public XdcWebException(ResponseEnum responseEnum, Throwable t) {
        super(responseEnum.getMessage(), t);
        this.code = responseEnum.getCode();
        this.message = responseEnum.getMessage();
    }


}

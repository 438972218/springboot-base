package com.xdcplus.xdcweb.global.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

/**
 *  Servlet工具类
 * @author Rong.Jia
 * @date 2019/03/06 9:56
 */
public class ServletUtils {

    /**
     *  获取request 对象
     * @date 2019/04/16 08:59:22
     * @return HttpServletRequest request 对象
     */
    public static HttpServletRequest getHttpRequest(){

        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        return Optional.ofNullable(requestAttributes).map(ServletRequestAttributes::getRequest).orElse(null);
    }

    /**
     *  获取response 对象
     * @date 2019/04/16 08:59:22
     * @return HttpServletResponse response 对象
     */
    public static HttpServletResponse getHttpResponse() {

        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        return Optional.ofNullable(requestAttributes).map(ServletRequestAttributes::getResponse).orElse(null);
    }

}

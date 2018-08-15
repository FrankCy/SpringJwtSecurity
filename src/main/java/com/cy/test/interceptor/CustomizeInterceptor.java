package com.cy.test.interceptor;

import com.cy.test.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

/**
 * @version 1.0
 * @description：自定义拦截器
 * @author: Yang.Chang
 * @project: SpringJwtSecurity
 * @package: com.cy.test.interceptor
 * @email: cy880708@163.com
 * @date: 2018/8/15 下午6:34
 * @mofified By:
 */
public class CustomizeInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        System.out.println("执行自定义拦截器 <-----> preHandle ");
        //判断token有效性
        String sign = request.getParameter("sign");
        //签名验证
        if((!StringUtils.isEmpty(sign)) && checkSign(request, sign) ) {
            //通过
        } else {
            //失败

        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("执行自定义拦截器 <-----> postHandle ");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {
        System.out.println("执行自定义拦截器 <-----> afterCompletion ");
    }


    /**
     * @description：校验用户签名情况
     * @version 1.0
     * @author: Yang.Chang
     * @email: cy880708@163.com
     * @date: 2018/8/15 下午6:54
     * @mofified By:
     */
    public static boolean checkSign(HttpServletRequest request, String resSign) {

        List<String> keys = new ArrayList<>(request.getParameterMap().keySet());
        Collections.sort(keys);

        String linkString = "";
        if(!keys.contains("time") || !keys.contains("sign")) {
            return false;
        }
        if(StringUtils.isEmpty(request.getParameter("time")) || StringUtils.isEmpty(request.getParameter("sign"))){
            return false;
        }

        for (String key : keys) {
            if (!"time".equals(key) && !"sign".equals(key)) {
                linkString += request.getParameter(key);
            }
        }

        if (StringUtils.isEmpty(linkString)) {
            return false;
        }

        String time = request.getParameter("time");
        String key = "com.bdjr";
        String sign = DigestUtils.md5Hex(linkString + time + key);

        return sign.equals(resSign);
    }

}

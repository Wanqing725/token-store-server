package com.token.interceptor;

import com.token.constant.JwtClaimsConstant;
import com.token.constant.MessageConstant;
import com.token.context.BaseContext;
import com.token.exception.JwtTokenInterceptorException;
import com.token.properties.JwtProperties;
import com.token.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
public class CommonJwtTokenInterceptor implements HandlerInterceptor {
    @Autowired
    private JwtProperties jwtProperties;

    /**
     * jwt校验
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //  判断当前拦截到的是Controller的方法还是其他资源
        if (!(handler instanceof HandlerMethod)) {
            return false;
        }
        //  从请求头中获取令牌
        String token = request.getHeader(jwtProperties.getCommonTokenName());

        //  校验令牌
        try {
            log.info("拦截器 jwt校验0：{}", token);
            Claims claims = JwtUtil.parseJWT(jwtProperties.getCommonSecretKey(), token);
            Long empId = Long.valueOf(claims.get(JwtClaimsConstant.EMP_ID).toString());
            log.info("员工ID:{}", empId);

            BaseContext.setCurrentId(empId);
            // 通过 放行
            return true;
        } catch (Exception e) {
            throw new JwtTokenInterceptorException(MessageConstant.TOKEN_ERROR);
        }
    }
    /**
     * 释放ThreadLocal
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        BaseContext.removeCurrentId();
    }
}

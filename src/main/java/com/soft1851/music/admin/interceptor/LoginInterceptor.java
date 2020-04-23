package com.soft1851.music.admin.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.soft1851.music.admin.common.ResultCode;
import com.soft1851.music.admin.controller.CaptchaController;
import com.soft1851.music.admin.domain.dto.LoginDto;
import com.soft1851.music.admin.exception.CustomException;
import com.soft1851.music.admin.handler.RequestWrapper;
import com.soft1851.music.admin.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xunmi
 * @ClassName LoginInterceptor
 * @Description TODO
 * @Date 2020/4/21
 * @Version 1.0
 **/
@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Resource
    private RedisService redisService;

    /**
     * 前置处理，拦截登录请求，校验参数、验证码等
     *
     * @param request
     * @param response
     * @param handler
     * @return boolean
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        //将request包装成HttpServletRequestWrapper类型
        RequestWrapper requestWrapper = new RequestWrapper(request);
        //取得请求的json对象
        String body = requestWrapper.getBody();
        log.info(body);
        //从redis取得指定用户名的验证码
        JSONObject jsonObject = JSONObject.parseObject(body);
        //判断以用户名作为key的数据是否还存在
        String verifyCode = jsonObject.getString("verifyCode");
        String uuid = jsonObject.getString("uuid");
        if (redisService.existsKey(uuid)) {
            //取得redis中的验证码
            String correctCode = redisService.getValue(uuid, String.class);
            System.out.println(verifyCode);
            System.out.println(correctCode);

            //忽略大小写比对，成功则放行到controller调用登录接口
            if (correctCode.equalsIgnoreCase(verifyCode)) {
                return true;
            } else {
                throw new CustomException("验证码错误", ResultCode.USER_VERIFY_CODE_ERROR);
            }
        } else {
            throw new CustomException("验证码失效", ResultCode.USER_CODE_TIMEOUT);
        }
    }
}
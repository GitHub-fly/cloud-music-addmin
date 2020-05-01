package com.soft1851.music.admin.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author xunmi
 * @ClassName LogInterceptor
 * @Description TODO
 * @Date 2020/4/30
 * @Version 1.0
 **/
@Slf4j
public class LogInterceptor {
    @Pointcut("execution(* com.soft1851.music.admin..*.*(..))")
    public void logCut() {
    }

    @AfterReturning("execution(* com.soft1851.music.admin..*.*(..))")
    public void cutPhoto() {
        log.info("已写入日志");
    }
}

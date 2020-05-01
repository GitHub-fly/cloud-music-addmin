package com.soft1851.music.admin.annotation;

import java.lang.annotation.*;

/**
 * @author xunmi
 * @ClassName ControllerWebLog
 * @Description TODO
 * @Date 2020/4/9
 * @Version 1.0
 **/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ControllerWebLog {
    /**
     * 调用的接口名称
     */
    String name();

    /**
     * 标识该日志是否需要持久化存储
     *
     * @return boolean
     */
    boolean isSaved() default false;
}

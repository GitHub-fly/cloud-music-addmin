package com.soft1851.music.admin.annotation;

import com.soft1851.music.admin.validator.PasswordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

/**
 * @author xunmi
 * @ClassName Password
 * @Description TODO
 * @Date 2020/4/30
 * @Version 1.0
 **/
@Target({FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
@Documented
public @interface Password {
    String message() default "password 密码输入有误";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

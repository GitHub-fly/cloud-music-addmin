package com.soft1851.music.admin.validator;

import com.soft1851.music.admin.annotation.Password;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

/**
 * @author xunmi
 * @ClassName PasswordValidator
 * @Description TODO
 * @Date 2020/4/30
 * @Version 1.0
 **/
public class PasswordValidator implements ConstraintValidator<Password, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // 长度至少6位
        Pattern length = compile("^.{6,}$");
        // 包含字母
        Pattern letter = compile("^.*[a-zA-Z]+.*$");
        // 包含数字
        Pattern number = compile("^.*[0-9]+.*$");

        Matcher lengthMatcher = length.matcher(value);
        Matcher letterMatcher = letter.matcher(value);
        Matcher numberMatcher = number.matcher(value);

        return (lengthMatcher.matches() && letterMatcher.matches() && numberMatcher.matches());
    }
}

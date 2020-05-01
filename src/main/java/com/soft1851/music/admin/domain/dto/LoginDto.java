package com.soft1851.music.admin.domain.dto;

import com.soft1851.music.admin.annotation.Password;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xunmi
 * @ClassName LoginDto
 * @Description TODO
 * @Date 2020/4/21
 * @Version 1.0
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {

    private String name;

    @Password
    private String password;

    private String verifyCode;

    private String uuid;

}

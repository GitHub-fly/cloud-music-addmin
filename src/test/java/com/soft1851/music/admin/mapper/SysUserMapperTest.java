package com.soft1851.music.admin.mapper;

import com.soft1851.music.admin.domain.dto.LoginDto;
import com.soft1851.music.admin.service.SysUserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SysUserMapperTest {

    @Resource
    private SysUserService sysUserService;

    @Test
    public void testLogin() {
        LoginDto user = LoginDto.builder()
                .name("mqxu")
                .password("1213456")
                .verifyCode("213")
                .build();
        sysUserService.login(user);
    }
}
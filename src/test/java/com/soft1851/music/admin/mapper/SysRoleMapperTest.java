package com.soft1851.music.admin.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SysRoleMapperTest {

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Test
    public void test() {
        System.out.println(sysRoleMapper.selectRoleById(1));
    }

}
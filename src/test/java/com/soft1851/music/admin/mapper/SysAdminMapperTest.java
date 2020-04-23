package com.soft1851.music.admin.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SysAdminMapperTest {

    @Resource
    private SysAdminMapper sysAdminMapper;

    @Test
    public void test() {
        System.out.println(sysAdminMapper.getRoleName("DE35D7CC05AF96A21D7ADFC8651E6614"));
    }
}
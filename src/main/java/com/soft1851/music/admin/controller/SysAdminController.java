package com.soft1851.music.admin.controller;


import com.soft1851.music.admin.common.ResponseResult;
import com.soft1851.music.admin.common.ResultCode;
import com.soft1851.music.admin.domain.dto.LoginDto;
import com.soft1851.music.admin.domain.entity.SysAdmin;
import com.soft1851.music.admin.service.SysAdminService;
import com.soft1851.music.admin.util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author xunmi
 * @since 2020-04-21
 */
@RestController
@RequestMapping("/api/sysAdmin")
@Slf4j
public class SysAdminController {
    @Resource
    private SysAdminService sysAdminService;

    /**
     * 登录
     *
     * @return String
     */
    @PostMapping("/login")
    public ResponseResult login(@RequestBody LoginDto loginDto) {
        List<Object> data = new ArrayList<>(2);
        log.info(loginDto.toString());
        boolean login = sysAdminService.login(loginDto);
        if (login) {
            SysAdmin admin = sysAdminService.getAdmin(loginDto.getName());
            List<String> roleNames = sysAdminService.getRoleName(admin.getId());
            data.add(roleNames);
            if (roleNames.size() == 0) {
                data.add(JwtTokenUtil.getToken(admin.getId(), "none", new Date(System.currentTimeMillis() + 60L * 60L * 1000L)));
            }
            if (roleNames.size() == 1) {
                data.add(JwtTokenUtil.getToken(admin.getId(), roleNames.get(0), new Date(System.currentTimeMillis() + 60L * 60L * 1000L)));
            }
            if (roleNames.size() == 2) {
                data.add(JwtTokenUtil.getToken(admin.getId(), roleNames.get(0), new Date(System.currentTimeMillis() + 60L * 60L * 1000L)));
                log.info(roleNames.get(0) + "       " + JwtTokenUtil.getToken(admin.getId(), roleNames.get(0), new Date(System.currentTimeMillis() + 60L * 60L * 1000L)));
                data.add(JwtTokenUtil.getToken(admin.getId(), roleNames.get(1), new Date(System.currentTimeMillis() + 60L * 60L * 1000L)));
                log.info(roleNames.get(1) + "       " + JwtTokenUtil.getToken(admin.getId(), roleNames.get(1), new Date(System.currentTimeMillis() + 60L * 60L * 1000L)));
            }
            data.add(admin);
            return ResponseResult.success(data);
        } else {
            return ResponseResult.failure(ResultCode.USER_SIGN_IN_FAIL);
        }
    }
}

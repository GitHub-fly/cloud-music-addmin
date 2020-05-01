package com.soft1851.music.admin.controller;


import com.alibaba.fastjson.JSONObject;
import com.soft1851.music.admin.annotation.ControllerWebLog;
import com.soft1851.music.admin.common.ResponseResult;
import com.soft1851.music.admin.common.ResultCode;
import com.soft1851.music.admin.domain.dto.LoginDto;
import com.soft1851.music.admin.domain.entity.SysAdmin;
import com.soft1851.music.admin.domain.entity.SysRole;
import com.soft1851.music.admin.service.SysAdminService;
import com.soft1851.music.admin.util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Update;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author xunmi
 * @since 2020-04-21
 */
@RestController
@RequestMapping(value = "/api/sysAdmin")
@Slf4j
@Validated
public class SysAdminController {
    @Resource
    private SysAdminService sysAdminService;

    /**
     * 管理员登录
     * @param loginDto
     * @return String
     */
    @PostMapping("/login")
    @ControllerWebLog(name = "admin", isSaved = true)
    public Map login(@Valid @RequestBody LoginDto loginDto) {
        log.info(loginDto.toString());
        return sysAdminService.login(loginDto);
    }

    @PutMapping("/password")
    @ControllerWebLog(name = "admin", isSaved = true)
    public boolean changePass(@Valid @RequestBody LoginDto loginDto) {
        return sysAdminService.updatePassword(loginDto);
    }
}
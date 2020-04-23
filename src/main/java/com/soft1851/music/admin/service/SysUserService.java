package com.soft1851.music.admin.service;

import com.soft1851.music.admin.domain.dto.LoginDto;
import com.soft1851.music.admin.domain.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xunmi
 * @since 2020-04-21
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 登录
     * @param loginDto
     * @return
     */
    boolean login(LoginDto loginDto);

}

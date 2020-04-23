package com.soft1851.music.admin.service.impl;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.soft1851.music.admin.domain.dto.LoginDto;
import com.soft1851.music.admin.domain.entity.SysUser;
import com.soft1851.music.admin.mapper.SysUserMapper;
import com.soft1851.music.admin.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft1851.music.admin.util.Md5Util;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xunmi
 * @since 2020-04-21
 */
@Service
@Slf4j
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Resource
    private SysUserMapper userMapper;

    @Resource
    private DefaultKaptcha defaultKaptcha;

    @Override
    public boolean login(LoginDto loginDto) {
        String verifyText = defaultKaptcha.createText();
        // 通过 name 查找表中数据
        SysUser sysUser = userMapper.selectUserByNameAndPass(loginDto);
        if (sysUser == null) {
            log.info("用户不存在");
            return false;
        }
        // 用户存在比对密码
        String password = sysUser.getPassword();
        if (!verifyText.equals(loginDto.getVerifyCode())) {
            log.info("验证码错误，请重新输入");
            return false;
        }
        if (password.equals(Md5Util.getMd5(loginDto.getPassword(), true, 32))) {
            log.info("登录成功！");
            return true;
        } else {
            log.info("密码错误！请重新输入");
            return false;
        }
    }
}

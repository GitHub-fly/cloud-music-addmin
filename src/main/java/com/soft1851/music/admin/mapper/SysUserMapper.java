package com.soft1851.music.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soft1851.music.admin.domain.dto.LoginDto;
import com.soft1851.music.admin.domain.entity.SysUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author xunmi
 * @since 2020-04-21
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 通过用户名和密码查找指定用户信息
     * @param loginDto
     * @return
     */
    @Select("SELECT * FROM sys_admin " +
            "WHERE name = #{loginDto.name} ")
    SysUser selectUserByNameAndPass(@Param("loginDto") LoginDto loginDto);
}

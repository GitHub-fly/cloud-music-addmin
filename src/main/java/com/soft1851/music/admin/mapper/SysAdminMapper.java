package com.soft1851.music.admin.mapper;

import com.soft1851.music.admin.domain.entity.SysAdmin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xunmi
 * @since 2020-04-21
 */
public interface SysAdminMapper extends BaseMapper<SysAdmin> {


    /**
     * 通过adminId 查找出该用户的所有角色信息
     * @param adminId
     * @return
     */
    @Select("SELECT role_name " +
            "FROM sys_role " +
            "WHERE role_id IN ( " +
            "SELECT role_id " +
            "FROM role_admin " +
            "WHERE admin_id = #{adminId} " +
            ") ")
    List<String> getRoleName(@Param("adminId") String adminId);

}

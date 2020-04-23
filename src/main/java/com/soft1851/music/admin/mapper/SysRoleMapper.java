package com.soft1851.music.admin.mapper;

import com.soft1851.music.admin.domain.entity.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface SysRoleMapper extends BaseMapper<SysRole> {
    /**
     * 根据id查询角色，包含其所有菜单
     * @param roleId
     * @return
     */
//    @Select("SELECT t1.role_id, t1.role_name, t3.*\n" +
//            "        FROM sys_role t1,\n" +
//            "             role_menu t2,\n" +
//            "             sys_menu t3\n" +
//            "        WHERE t1.role_id = t2.role_id\n" +
//            "          AND t2.menu_id = t3.id\n" +
//            "          AND t1.role_id = #{roleId}")
    SysRole selectRoleById(int roleId);
}

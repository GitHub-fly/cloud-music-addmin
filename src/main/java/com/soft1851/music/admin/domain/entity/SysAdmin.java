package com.soft1851.music.admin.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.soft1851.music.admin.annotation.Password;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author xunmi
 * @since 2020-04-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_admin")
public class SysAdmin extends Model<SysAdmin> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("id")
    private String id;

    /**
     * 用户名
     */
    @TableField("name")
    private String name;

    /**
     * 密码
     */
    @JsonIgnore
    @TableField("password")
    @Password
    private String password;

    /**
     * 加密盐
     */
    @JsonIgnore
    @TableField("salt")
    private String salt;

    /**
     * 头像
     */
    @TableField("avatar")
    private String avatar;

    /**
     * 创建时间
     */
    @JsonIgnore
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @JsonIgnore
    @TableField("update_time")
    private LocalDateTime updateTime;

    /**
     * 账户状态：0 禁用 1 启用
     */
    @JsonIgnore
    @TableField("status")
    private Integer status;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    private List<SysRole> roles;

}

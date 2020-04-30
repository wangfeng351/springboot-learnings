package com.soft1851.springboot.mybatis.plus.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author mq_xu
 * @since 2020-04-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_permission")
public class SysPermission extends Model<SysPermission> {

    private static final long serialVersionUID = 1L;

    /**
     * 权限id
     */
    @TableId(value = "p_id", type = IdType.AUTO)
    private Integer pId;

    /**
     * 父类id
     */
    @TableField("parent_id")
    private Integer parentId;

    /**
     * 权限名称
     */
    @TableField("p_name")
    private String pName;

    /**
     * 类型
     */
    @TableField("type")
    private Integer type;

    /**
     * 图标
     */
    @TableField("icon")
    private String icon;

    /**
     * 地址
     */
    @TableField("path")
    private String path;

    /**
     * 扩展字段1
     */
    @TableField("ex1")
    private String ex1;

    /**
     * 扩展字段2
     */
    @TableField("ex2")
    private Integer ex2;


    @Override
    protected Serializable pkVal() {
        return this.pId;
    }

}

package com.soft1851.springboot.mybatis.plus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/4/16
 * @Version 1.0
 */
@Data
@Builder
@TableName("t_follower")
public class Follower {
    @TableId(type = IdType.AUTO)
    private String id;
    private String name;
    private String url;
    private String gender;
    private String avatarUrl;
    private Integer followerCount;
}

package com.soft1851.springboot.mybatis.plus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.soft1851.springboot.mybatis.plus.entity.Follower;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/4/16
 * @Version 1.0
 */
@SpringBootTest
class FollowerMapperTest {

    @Resource
    private FollowerMapper mapper;

    @Test
    public void insert() {
        Follower follower = Follower.builder()
                        .id("1234567")
                        .name("王锋")
                        .avatarUrl("https://baidu.com")
                        .gender("男")
                        .followerCount(12132)
                        .build();
        int n = mapper.insert(follower);
        assertEquals(1, n);
        System.out.println(n);
    }

    @Test
    public void batchDeleteById() {
        List<String> idList = new ArrayList<>();
        idList.add("0377157d3aea0bf4ee97cfd00e99afc3");
        idList.add("0458b8ab6c8d1d60dbf7716808512f3d");
        int result = mapper.deleteBatchIds(idList);
        assertEquals(2, result);
        System.out.println(result);
    }

    @Test
    public void deleteByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "王锋");
        int n = mapper.deleteByMap(map);
        assertEquals(1, n);
        System.out.println(n);
    }

    @Test
    public void update() {
        Follower follower = Follower.builder()
                        .name("蜂王英明")
                        .followerCount(0)
                        .build();
        UpdateWrapper<Follower> wrapper = new UpdateWrapper<>();
        wrapper.eq("id", "04b4d1b7e941adeee61ef67694e9d249");
        int n = mapper.update(follower, wrapper);
        assertEquals(1, n);
        System.out.println(n);
    }

    @Test
    public void selectAll() {
        QueryWrapper<Follower> queryWrapper = new QueryWrapper<>();
        List<Follower> followers = mapper.selectList(queryWrapper);
        assertEquals(500, followers.size());
        System.out.println(followers.size());
    }

    @Test
    public void getOneById() {
        Follower follower = mapper.selectById("04b4d1b7e941adeee61ef67694e9d249");
        assertNotNull(follower);
        System.out.println(follower);
    }

    @Test
    public void selectCount() {
        QueryWrapper<Follower> wrapper = new QueryWrapper<Follower>();
        /*条件为between....and */
        wrapper.between("follower_count", 10,  100);
        int count = mapper.selectCount(wrapper);
        System.out.println(count);
    }
}
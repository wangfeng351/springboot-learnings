package com.soft1851.springboot.aop.controller;

import com.soft1851.springboot.aop.annotation.ImageHandle;
import com.soft1851.springboot.aop.common.Result;
import com.soft1851.springboot.aop.util.AliOssUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/4/14
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/upload")
public class UpLoadController {

    @ImageHandle(operations = {"waterMark", "noWaterMark"})
    @PostMapping(value = "/single")
    public Result uploadSingle(@RequestParam("file") MultipartFile file) {
        System.out.println("文件" + file);
        String url = AliOssUtil.upload(file);
        return Result.success(url);
    }
}

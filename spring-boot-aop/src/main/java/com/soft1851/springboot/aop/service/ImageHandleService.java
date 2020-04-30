package com.soft1851.springboot.aop.service;

import java.io.File;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/4/14
 * @Version 1.0
 */
public interface ImageHandleService {

    /**
     * 加水印上传
     *
     * @param file
     * @return
     */
    File addWaterMarkUpload(File file, String pressName);
}

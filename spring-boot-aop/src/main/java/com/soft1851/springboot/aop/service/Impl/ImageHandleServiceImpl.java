package com.soft1851.springboot.aop.service.Impl;

import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.io.FileUtil;
import com.soft1851.springboot.aop.service.ImageHandleService;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.File;
import java.util.UUID;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/4/14
 * @Version 1.0
 */
@Service
public class ImageHandleServiceImpl implements ImageHandleService {

    @Override
    public File addWaterMarkUpload(File file, String pressName) {
        String path = file.getParent() + "/" + UUID.randomUUID().toString() + ".jpg";
        ImgUtil.pressText(
                FileUtil.file(file),
                FileUtil.file(path),
                pressName, Color.WHITE, //文字
                new Font("黑体", Font.BOLD, 100), //字体
                0, //x坐标修正值。 默认在中间，偏移量相对于中间偏移
                0, //y坐标修正值。 默认在中间，偏移量相对于中间偏移
                0.8f//透明度：alpha 必须是范围 [0.0, 1.0] 之内（包含边界值）的一个浮点数字
        );
        return new File(path);
    }

    public static void main(String[] args) {
        File file = new File("D:\\1.jpg");
        File file1 = new ImageHandleServiceImpl().addWaterMarkUpload(file, "123");
        System.out.println(file1.getPath());
    }
}

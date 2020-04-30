package com.soft1851.springboot.aop.aspect;

import com.soft1851.springboot.aop.annotation.ImageHandle;
import com.soft1851.springboot.aop.service.ImageHandleService;
import com.soft1851.springboot.aop.util.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Files;
import java.util.*;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/4/14
 * @Version 1.0
 */
@Aspect
@Component
@Slf4j
public class ImageAspect {
    @Resource
    private ImageHandleService service;

    /**
     * 配置加上自定义注解的方法为切点
     *
     * @param imageHandle
     */
    @Pointcut("@annotation(imageHandle)")
    public void handleImage(ImageHandle imageHandle) {
    }

    @Around(value = "handleImage(imageHandle)", argNames = "pjp, imageHandle")
    public Object doRound(ProceedingJoinPoint pjp, ImageHandle imageHandle) throws Throwable {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert sra != null;
        HttpServletRequest request = sra.getRequest();
        Object[] objects = pjp.getArgs();
        log.info("参数： " + Arrays.toString(objects));
        String operation = request.getHeader("operation");
        String pressName = null;
        pressName = request.getHeader("name");
        String[] args = imageHandle.operations();
        for (String op : args) {
            if (op.equals(operation) && "waterMark".equals(operation)) {
                //获取request中的文件流在根目录生成文件，返回文件路径
                String path = FileUtil.readRequestFile(request);
                //进行加水印操作
                if (pressName == null) {
                    pressName = "蜂王专用水印";
                }
                File file1 = service.addWaterMarkUpload(new File(path), pressName);
                //file转MultipartFile
                MultipartFile mul = FileUtil.convertFile(file1);
                MultipartFile[] files = {mul};
                System.out.println("加水印");
                return pjp.proceed(files);
            }
        }
        //正常上传图片
        System.out.println("不加水印");
        return pjp.proceed();
    }
}

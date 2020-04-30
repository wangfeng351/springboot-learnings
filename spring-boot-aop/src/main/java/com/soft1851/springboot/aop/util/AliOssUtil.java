package com.soft1851.springboot.aop.util;

import com.aliyun.oss.OSSClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author wf
 * @ClassName Aliosso
 * @Description TODO
 * @Date 2019/12/9
 */
@Slf4j
public class AliOssUtil {
    public static String upload(MultipartFile sourceFile) {
        // 获取文件名
        String fileName = sourceFile.getOriginalFilename();
        //uuid生成主文件名
        String prefix = UUID.randomUUID().toString();
        assert fileName != null;
        //源文件的扩展名

        String suffix = "";
        System.out.println(fileName.length());
        if (fileName.length() > 1) {
            suffix = fileName.substring(fileName.lastIndexOf("."));
        } else {
            suffix = sourceFile.getName().substring(sourceFile.getName().lastIndexOf("."));
        }
        //创建File类型的临时文件
        File tempFile = null;
        try {
            tempFile = File.createTempFile(prefix, suffix);
            // 将MultipartFile转换成File
            sourceFile.transferTo(tempFile);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        assert tempFile != null;
        return upload(tempFile);
    }


    public static String upload(File file) {
        String endpoint = "https://oss-cn-shanghai.aliyuncs.com";
        String accessKeyId = "LTAI4FpzLFy8uA2PWAXH8cwQ";
        String accessKeySecret = "XLTomRADcglUJ5IgRrHxWKJMjPqg8b";
        String bucketName = "blog-manage";
        String filePath = "img/";
        String fileName = file.getName();
        String newFileName = UUID.randomUUID().toString() + fileName.substring(fileName.indexOf("."));
        // 创建OSSClient实例
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        // 上传文件到指定位置，并使用UUID更名
        ossClient.putObject(bucketName, filePath + newFileName, file);
        // 拼接URL
        String url = "https://niit-soft.oss-cn-hangzhou.aliyuncs.com/" + filePath + newFileName;
        ossClient.shutdown();
        return url;
    }

    public static void main(String[] args) {
        File file = new File("D:\\1.jpg");
        System.out.println(upload(file));
    }
}

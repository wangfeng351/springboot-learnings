package com.soft1851.springboot.aop.util;

import org.springframework.mock.web.MockMultipartFile;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.*;
import java.util.Collection;
import java.util.UUID;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/4/15
 * @Version 1.0
 */
public class FileUtil {

    /**
     * file转MultipartFile
     *
     * @param file
     * @return
     */
    public static MultipartFile convertFile(File file) throws IOException {
        // 多态，创建InputStream
        InputStream fis = new FileInputStream(file);
        System.out.println(fis.available());
        // fis.available()获取输入流的长度
        byte[] data = new byte[fis.available()];
        // 将输入流读入字节数组中
        fis.read(data);
        fis.close();
        // 返回multipartFile类型的文件
        return new MockMultipartFile(file.getPath(), data);
    }

    /**
     * 获取请求中的文件，再根目录下临时创建一个文件
     *
     * @param request
     * @return
     * @throws Exception
     */
    public static String readRequestFile(HttpServletRequest request) throws Exception {
        // 读取request中的文件
        Collection<Part> parts = request.getParts();
        String path = " ";
        FileOutputStream out = null;
        for (Part part : parts) {
            // 随机生成一个UUID
            String name = UUID.randomUUID().toString();
            // 获取根目录下的路径，用于存放临时文件
            path = ResourceUtils.getURL("classpath:").getPath() + name + ".jpg";
            // 为该文件定义输入流
            out = new FileOutputStream(new File(path));
            byte[] b = new byte[1024];
            int len = 0;
            // 通过getInputStream()获取request中的输入流，转型为FileInputStream
            FileInputStream fis = (FileInputStream) part.getInputStream();
            while ((len = fis.read(b)) != -1) {
                out.write(b, 0, len);
            }
        }
        assert out != null;
        out.close();
        return path;
    }
}

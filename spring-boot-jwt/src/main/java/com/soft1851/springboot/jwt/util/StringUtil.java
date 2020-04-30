package com.soft1851.springboot.jwt.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/4/15
 * @Version 1.0
 */
public class StringUtil {

    /**
     * 使用md5生成一个32位加密的盐
     *
     * @return
     */
    public static String getSalt(String str) {
        try {
            //创建具有指定算法名称的摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            //使用指定的字节数组更新摘要
            md.update(str.getBytes());
            //对传入的数组进行加密
            byte[] mdBytes = md.digest();
            StringBuilder hash = new StringBuilder();
            //循环字节数组
            for (byte mdByte : mdBytes) {
                int temp;
                //如果有小于0的字节,则转换为正数
                if (mdByte < 0) {
                    temp = 256 + mdByte;
                } else {
                    temp = mdByte;
                }
                if (temp < 16) {
                    hash.append("0");
                }
                //将字节转换为16进制后，转换为字符串
                hash.append(Integer.toString(temp, 16));
            }
            return hash.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getRandomString() {
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int id = random.nextInt(7);
            builder.append(id);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(getSalt(getRandomString()));
    }
}

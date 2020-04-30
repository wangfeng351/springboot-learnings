package com.soft1851.springboot.jwt.util;

import com.auth0.jwt.interfaces.DecodedJWT;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/4/15
 * @Version 1.0
 */
public class Test {
    static long time = 0;

    public static void main(String[] args) {
        // 生成token
        Encrypt encrypt = new Encrypt();
        String id = StringUtil.getRandomString();
        String token = encrypt.getToken("超管", id, "蜂王");

        // 打印token
        System.out.println("token: " + token);

        // 解密token
        Decrypt decrypt = new Decrypt();
        DecodedJWT jwt = decrypt.deToken(token, id);

        System.out.println("issuer: " + jwt.getIssuer());
        System.out.println("role:  " + jwt.getClaim("role").asBoolean());
        System.out.println("id: " + jwt.getClaim("id").asString());
        System.out.println("name:     " + jwt.getClaim("name").asString());
        long currentTime = System.currentTimeMillis();
        time = jwt.getExpiresAt().getTime();
        System.out.println("token暂未失效");
        while (currentTime <= time) {
            currentTime = System.currentTimeMillis();
        }
        System.out.println("token已失效");

    }
}

package com.soft1851.springboot.jwt.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.security.Signature;
import java.sql.Date;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/4/15
 * @Version 1.0
 */
public class Encrypt {
    /**
     * 生成加密后的token
     *
     * @param id   用户id
     * @param name 真实姓名
     * @return 加密后的token
     */
    public String getToken(final String role, final String id,
                           final String name) {
        String token = null;
        try {
//            Date expiresAt = new Date(System.currentTimeMillis() + 24L * 60L * 3600L * 1000L);
            Date expiresAt = new Date(System.currentTimeMillis() + 5L * 1000L);
            String secret = StringUtil.getSalt(id);
            token = JWT.create()
                    .withIssuer("auth0")
                    .withClaim("role", role)
                    .withClaim("id", id)
                    .withClaim("name", name)
                    .withExpiresAt(expiresAt)
                    // 使用了HMAC256加密算法, mySecret是用来加密数字签名的密钥。
                    .sign(Algorithm.HMAC256(secret));

        } catch (Exception exception) {
            //Invalid Signing configuration / Couldn't convert Claims.
        }
        return token;
    }
}

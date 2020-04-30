package com.soft1851.springboot.jwt.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.soft1851.springboot.jwt.common.ResultCode;
import com.soft1851.springboot.jwt.exception.JwtException;
import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName JwtTokenUtil
 * @Description TODO
 * @Author wf
 * @Date 2020/4/15
 * @Version 1.0
 */
@Slf4j
public class JwtTokenUtil {
    /**
     * 加密
     *
     * @param userId
     * @param userRole
     * @param expiresAt
     * @return String
     */
    public static String getToken(final String userId, final String userRole, Date expiresAt) {
        String token = null;
        Map<String, Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        token = JWT.create()
                .withHeader(map) //header
                .withIssuer("auth0")  //payload
                .withClaim("userId", userId) // 自定义
                .withClaim("userRole", userRole)
                .withExpiresAt(expiresAt) //过期时间
                // 使用了HMAC256加密算法, mySecret是用来加密数字签名的密钥
                .sign(Algorithm.HMAC256("mySecret")); //signature

        return token;
    }

    /**
     * 解密
     *
     * @param token
     * @return DecodedJWT
     */
    public static DecodedJWT deToken(final String token) {
        DecodedJWT jwt;
        JWTVerifier verifier = null;
        verifier = JWT.require(Algorithm.HMAC256("mySecret"))
                .withIssuer("auth0")
                .build();
        assert verifier != null;
        try {
            jwt = verifier.verify(token);
        } catch (TokenExpiredException e) {
            throw new JwtException("token失效", ResultCode.TOKEN_NOT_USE);
        }
        return jwt;
    }

    /**
     * 获取userId
     *
     * @param token
     * @return String
     */
    public static String getUserId(String token) {
        return deToken(token).getClaim("userId").asString();
    }

    /**
     * 获取role
     *
     * @param token
     * @return String
     */
    public static String getUserRole(String token) {
        return deToken(token).getClaim("userRole").asString();
    }

    /**
     * 验证是否过期
     *
     * @param token
     * @return boolean
     */
    public static boolean isExpiration(String token) {
        return deToken(token).getExpiresAt().before(new Date());
    }

    public static void main(String[] args) throws InterruptedException {
        long currentTime = System.currentTimeMillis();
        String token = getToken("123", "123", new Date(currentTime + 10L * 1000L));
        while (!isExpiration(token)) {
            System.out.println("未失效");
            Thread.sleep(1000);
        }
        throw new JwtException("token失效", ResultCode.DATABASE_ERROR);
    }
}

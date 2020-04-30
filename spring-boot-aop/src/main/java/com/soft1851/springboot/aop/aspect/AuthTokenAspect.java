package com.soft1851.springboot.aop.aspect;

import com.soft1851.springboot.aop.annotation.AuthToken;
import com.soft1851.springboot.aop.common.Result;
import com.soft1851.springboot.aop.common.ResultCode;
import com.soft1851.springboot.aop.entity.UserRole;
import com.soft1851.springboot.aop.mapper.SysUserMapper;
import com.soft1851.springboot.aop.mapper.UserRoleMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/4/13
 * @Version 1.0
 */
@Aspect
@Component
@Slf4j
public class AuthTokenAspect {
    @Resource
    private SysUserMapper mapper;

    /**
     * 配置加上自定义注解的方法为切点
     *
     * @param authToken
     */
    @Pointcut("@annotation(authToken)")
    public void doAuthToken(AuthToken authToken) {
    }


    /**
     * object是指controller方法返回的类型
     */
    @Around(value = "doAuthToken(authToken)", argNames = "pjp,authToken")
    public Object doAround(ProceedingJoinPoint pjp, AuthToken authToken) throws Throwable {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert sra != null;
        HttpServletRequest request = sra.getRequest();
        // 取得注解中的role_name的值
        String[] roleNames = authToken.role_name();
        // 取出header中的token值
        String token = request.getHeader("token");
        // 进行token认证
        if (token != null) {
            // 为authToken.role_name()的值为一个及以下的接口进行鉴权
            if (roleNames.length <= 1) {
                String id = request.getParameter("id");
                Map<String, Object> map = mapper.getUserById(id);
                // 取出用户的角色名称信息进行鉴权
                if (roleNames[0].equals(map.get("role_name"))) {
                    // 返回controller方法的值
                    return pjp.proceed();
                }
                return Result.failure(ResultCode.PERMISSION_NO_ACCESS);
            } else {
                // 获取请求参数id,通过id查询到该用户角色信息
                String id = request.getParameter("id");
                // 根据id查询用户的信息
                Map<String, Object> map = mapper.getUserById(id);
                for (String roleName : roleNames) {
                    //取出用户的角色名称信息进行鉴权
                    if (roleName.equals(map.get("role_name"))) {
                        // 身份匹配成功，返回目标方法执行之后返回的值
                        return pjp.proceed();
                    }
                }
                return Result.failure(ResultCode.PERMISSION_NO_ACCESS);
            }
        }
        // 没有token则返回未登录信息
        return Result.failure(ResultCode.USER_NOT_SIGN_IN);
    }
}

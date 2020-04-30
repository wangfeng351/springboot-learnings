package com.soft1851.oauth.controller;

import com.soft1851.oauth.dto.AccessTokenDto;
import com.soft1851.oauth.entity.GitHubUser;
import com.soft1851.oauth.util.GitHubProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/4/29
 * @Version 1.0
 */
@RestController
@Slf4j
public class TestController {
    @Autowired
    private GitHubProvider gitHubProvider;

    @GetMapping(value = "/login/oauth2/code/github")
    public void callBack( @RequestParam(name = "code")String code,
                           @RequestParam(name = "state") String state){
        log.info("进入callback接口");
        AccessTokenDto accessTokenDTO = new AccessTokenDto();
        accessTokenDTO.setClientId("7db13c356933fea303d7");
        accessTokenDTO.setCode(code);
        accessTokenDTO.setClientSecret("0fa928fcd1bcc6fd47fc1ca309c4a1c8dc0bc56a");
        accessTokenDTO.setRedirectUrl("http://localhost:8080/login/oauth2/code/github");
        accessTokenDTO.setState(state);
        String accessToken = gitHubProvider.getAccessToken(accessTokenDTO);
        log.info("accessToken: " + accessToken);
        GitHubUser user = gitHubProvider.getUser(accessToken);
        //return "index"+user.toString();
    }

    @GetMapping(value = "/index")
    public String test() {
        log.info("进入test接口 ");
        return "index";
    }

}

package com.soft1851.springboot.aop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/4/13
 * @Version 1.0
 */
@SpringBootTest
@WebAppConfiguration
public class HelloApplicationTest {
    //用于模拟调用Controller的接口发起的请求
    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;

    //预加载内容，初始化mockMvc
    @BeforeEach
    public void setup() throws Exception{
        mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    @Test
    public void hello() throws Exception{
       /*
        * 1、mockMvc.perform执行一个请求。
        * 2、MockMvcRequestBuilders.get("XXX")构造一个请求。
        * 3、ResultActions.param添加请求传值
        * 4、ResultActions.accept(MediaType.TEXT_HTML_VALUE))设置返回类型
        * 5、ResultActions.andExpect添加执行完成后的断言。
        * 6、ResultActions.andDo添加一个结果处理器，表示要对结果做点什么事情
        *
        比如此处使用MockMvcResultHandlers.print()输出整个响应结果信息。
        * 7、ResultActions.andReturn表示执行完成后返回相应的结果。
        */

//        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
//                .get("/api/hello")
//                .param("name", "Tom")
//                .param("age", "123")
//                .header("token", "123456"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().string("Hello Tom"))
//                .andDo(MockMvcResultHandlers.print())
//                .andReturn();
//        System.out.println("返回的结果：" + result.getResponse().getContentAsString());

        MvcResult result1 = mockMvc.perform(MockMvcRequestBuilders
                .get("/api/hello")
                .header("token", "123456"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("hello方法访问成功"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println("返回的结果：" + result1.getResponse().getContentAsString());
    }
}

package com.xiaominfo.springfox.customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.OperationBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiDescription;
import springfox.documentation.service.Operation;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.ApiListingScannerPlugin;
import springfox.documentation.spi.service.contexts.DocumentationContext;
import springfox.documentation.spring.web.readers.operation.CachingOperationNameGenerator;

import java.util.*;

/**
 * @author <a href="xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2023/7/12 09:12
 * @since knife4j-customer-api
 */
@Slf4j
@Component
public class CustomerApiPlugin implements ApiListingScannerPlugin {
    @Override
    public List<ApiDescription> apply(DocumentationContext context) {
        // consumers、produces
        Set<String> mediaSet=new HashSet<>();
        mediaSet.add(MediaType.APPLICATION_JSON_VALUE);
        //设定参数
        List<Parameter> parameters=new ArrayList<>();
        parameters.add(new ParameterBuilder().name("username").required(true).modelRef(new ModelRef("String")).defaultValue("test").description("用户名").build());
        parameters.add(new ParameterBuilder().name("password").required(true).modelRef(new ModelRef("String")).defaultValue("123").description("密码").build());
        // 接口的Tag
        Set<String> tags=new HashSet<>();
        tags.add("首页");
        //构建Operation对象
        Operation usernamePasswordOperation = new OperationBuilder(new CachingOperationNameGenerator())
                .method(HttpMethod.POST)
                .tags(tags)
                .summary("用户名密码登录")
                .notes("用户登陆获取token")
                .parameters(parameters)
                .consumes(mediaSet)
                .produces(mediaSet)
                .build();

        //需要注意的是groupName需要和开发者创建的Docket对象赋值的groupName保持一致
        ApiDescription loginApiDescription = new ApiDescription("hello", "/login", "登录接口描述", Collections.singletonList(usernamePasswordOperation), false);
        return Collections.singletonList(loginApiDescription);
    }

    @Override
    public boolean supports(DocumentationType documentationType) {
        return documentationType==DocumentationType.SWAGGER_2;
    }
}

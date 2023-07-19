/*
 * Copyright © 2017-2023 Knife4j(xiaoymin@foxmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.xiaominfo.springdoc.customer;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.customizers.GlobalOpenApiCustomizer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author <a href="xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2023/7/13 08:53
 * @since knife4j-customer-api
 */
@Slf4j
@Component
public class CustomerOperation implements GlobalOpenApiCustomizer {
    
    @Override
    public void customise(OpenAPI openApi) {
        log.info("customer.");
        // 因为要新增自定义的接口，直接这里add
        PathItem pathItem = new PathItem();
        // 基础信息 构建Operation
        Operation operation = new Operation();
        operation.operationId("login");
        operation.summary("登录接口");
        operation.description("根据用户名和密码登录获取token");
        operation.tags(Collections.singletonList("登录"));
        // 构建参数
        List<Parameter> parameters = new ArrayList<>();
        parameters.add(new Parameter().name("name").example("zhangFei").description("用户名").required(true).schema(new StringSchema()).in("query"));
        parameters.add(new Parameter().name("password").example("123456").description("密码").required(true).schema(new StringSchema()).in("query"));
        operation.parameters(parameters);
        // 构建响应body
        ApiResponses apiResponses = new ApiResponses();
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.description("ok").content(new Content().addMediaType("*/*", new MediaType().schema(new StringSchema())));
        apiResponses.addApiResponse("200",apiResponse);
        operation.responses(apiResponses);
        // 该自定义接口为post
        pathItem.post(operation);
        openApi.path("/login", pathItem);
    }
}

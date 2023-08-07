package com.xiaominfo.knife4j.advice;

import com.xiaominfo.knife4j.core.CourseType;
import com.xiaominfo.knife4j.plugin.GenericEnumPropertySupport;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author <a href="xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2023/8/7 20:24
 * @since knife4j-handler-enum
 */
@RestControllerAdvice
public class GlobalRestAdvice {
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        //这里可以做成scan扫描包的方式，扫描所有枚举类，然后分批注入，或者其他的方式也行，看自己项目的规则
        binder.registerCustomEditor(CourseType.class,new GenericEnumPropertySupport<>(CourseType.class));
    }
}

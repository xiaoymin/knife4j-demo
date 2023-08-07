package com.xiaominfo.knife4j.core;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.xiaominfo.knife4j.plugin.CommonFormEnumParser;
import com.xiaominfo.knife4j.plugin.CourseTypeDeserializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * @author <a href="xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2023/8/7 07:06
 * @since knife4j-handler-enum
 */
@Slf4j
@AllArgsConstructor
@Getter
@JsonDeserialize(using = CourseTypeDeserializer.class)
public enum CourseType implements CommonFormEnumParser<CourseType> {

    MATH(1,"数学"),
    ENGLISH(2,"英语"),
    CHINESE(3,"语文"),
    COMPUTER(4,"计算机");

    /**
     * 课程编码
     */
    final int code;
    /**
     * 课程标签
     */
    final String label;

    @Override
    public String toString() {
        return this.name()+":"+this.label;
    }

    @Override
    public CourseType fromValue(String input) {
        log.info("input:{}",input);
        for (CourseType courseType : CourseType. values()) {
            // 根据规则自定义实现
            if (input.startsWith(Objects.toString(courseType))||input.equalsIgnoreCase(courseType.name())) {
                return courseType;
            }
        }
        throw new IllegalArgumentException("Invalid CourseType value: " + input);
    }
}

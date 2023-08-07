package com.xiaominfo.knife4j.plugin;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.xiaominfo.knife4j.core.CourseType;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Objects;

/**
 * @author <a href="xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2023/8/7 20:34
 * @since knife4j-handler-enum
 */
@Slf4j
public class CourseTypeDeserializer   extends JsonDeserializer<CourseType> {
    @Override
    public CourseType deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        log.info("des....");
        String input = jsonParser.getValueAsString();
        log.info("value:{}",input);
        for (CourseType courseType : CourseType.values()) {
            // 根据规则自定义实现
            if (input.startsWith(Objects.toString(courseType))||input.equalsIgnoreCase(courseType.name())) {
                return courseType;
            }
        }
        throw new IllegalArgumentException("Invalid CourseType value: " + input);
    }
}

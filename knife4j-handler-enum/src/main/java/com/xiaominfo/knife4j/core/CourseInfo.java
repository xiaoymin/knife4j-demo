package com.xiaominfo.knife4j.core;

import cn.hutool.core.util.RandomUtil;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

/**
 * @author <a href="xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2023/8/7 07:11
 * @since knife4j-handler-enum
 */
@Getter
@Setter
public class CourseInfo {

    @Schema(description = "学生")
    private String student;

    @Schema(description = "分数")
    public Integer score;

    @Schema(description = "课程类别")
    private CourseType courseType;


    public static CourseInfo create(){
        CourseInfo courseInfo=new CourseInfo();
        courseInfo.setStudent("学生"+RandomUtil.randomInt(1,1000));
        courseInfo.setScore(RandomUtil.randomInt(1,100));
        courseInfo.setCourseType(Arrays.asList(CourseType.values()).get(RandomUtil.randomInt(0,CourseType.values().length)));
        return courseInfo;
    }
}

package com.xiaominfo.knife4j.rest;

import com.xiaominfo.knife4j.core.CourseInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2023/8/7 07:08
 * @since knife4j-handler-enum
 */
@Tag(name = "课程")
@RestController
@RequestMapping("/course")
public class EnumRestController {


    @Operation(summary = "获取所有课程")
    @GetMapping("/get")
    public ResponseEntity<List<CourseInfo>> get(){
        List<CourseInfo> result=new ArrayList<>();
        for (int i=0;i<100;i++){
            result.add(CourseInfo.create());
        }
        return ResponseEntity.ok(result);
    }


    @Operation(summary = "form提交")
    @PostMapping("/form")
    public ResponseEntity<CourseInfo> form(CourseInfo courseInfo){
        return ResponseEntity.ok(courseInfo);
    }


    @Operation(summary = "json提交")
    @PostMapping("/json")
    public ResponseEntity<CourseInfo> json(@RequestBody CourseInfo courseInfo){
        return ResponseEntity.ok(courseInfo);
    }
}

package com.quayal.abt.controllers;

import com.quayal.abt.beans.CourseBean;
import com.quayal.abt.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }

    @GetMapping("/courses")
    public List<CourseBean> getCourses(){
        return courseService.getCourses();
    }
}

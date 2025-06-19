package com.example.INCISOL360.controller;

import com.example.INCISOL360.model.Course;
import com.example.INCISOL360.model.CourseRegistry;
import com.example.INCISOL360.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseService courseService;
    private String name;
    private String emailId;
    private String courseName;

    @GetMapping("course")
    public List<Course> getCourse() {
        return courseService.getCourses();
    }

   @GetMapping("enrolled-students")
   public List<CourseRegistry> getStudent() {
        return courseService.getStudents();
   }

   @PutMapping("edit-detail")
  public String updateStudents(@RequestBody CourseRegistry course) {
        courseService.updateStudent(course);
        return "update Successfull";
   }

    @PostMapping("course-register")
    public String registerCourse(@RequestParam("name") String name,
                                 @RequestParam("emailId") String emailId,
                                 @RequestParam("courseName") String courseName) {
        courseService.courseRegistry(name, emailId, courseName);
        return "Congrats";
    }

    @DeleteMapping("delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        courseService.deleteStudents(id);
        return "Delete Successfull";
    }
}

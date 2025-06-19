package com.example.INCISOL360.service;

import com.example.INCISOL360.model.Course;
import com.example.INCISOL360.model.CourseRegistry;
import com.example.INCISOL360.repository.CourseRegistryRepo;
import com.example.INCISOL360.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    CourseRepo courseRepo;

    @Autowired
    CourseRegistryRepo courseRegistryRepo;

    public List<Course> getCourses() {
        return courseRepo.findAll();
    }

    public void courseRegistry(String name, String emailId, String courseName) {
        CourseRegistry courseRegister = new CourseRegistry(name, emailId, courseName);
        courseRegistryRepo.save(courseRegister);
    }

    public List<CourseRegistry> getStudents() {
        return courseRegistryRepo.findAll();
    }

    public boolean updateStudent(CourseRegistry course) {
        Optional<CourseRegistry> optionalcourse = courseRegistryRepo.findById(course.getId());
        if(optionalcourse.isPresent()) {
            CourseRegistry existing = optionalcourse.get();
            existing.setName(course.getName());
            existing.setEmailId(course.getEmailId());
            existing.setCourseName(course.getCourseName());

            courseRegistryRepo.save(existing);
            return true;
        }
        else
            return false;
    }

    public void deleteStudents(int id) {
        courseRegistryRepo.deleteById(id);
    }
}

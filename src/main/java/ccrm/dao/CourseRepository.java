package ccrm.dao;

import ccrm.model.Course;
import java.util.*;

public class CourseRepository {
    private final Map<String, Course> courses = new HashMap<>();

    public void save(Course c) {
        courses.put(c.getCode(), c);
    }

    public Course findByCode(String code) {
        return courses.get(code);
    }

    public Collection<Course> findAll() {
        return courses.values();
    }
}

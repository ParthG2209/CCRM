package ccrm.service;

import ccrm.dao.CourseRepository;
import ccrm.dao.OfferingRepository;
import ccrm.model.Course;
import ccrm.model.Offering;
import java.util.Collection;

public class CourseService {
    private final CourseRepository courseRepo;
    private final OfferingRepository offeringRepo;

    public CourseService(CourseRepository courseRepo, OfferingRepository offeringRepo) {
        this.courseRepo = courseRepo;
        this.offeringRepo = offeringRepo;
    }

    public void addCourse(String code, String title, int credits) {
        Course c = new Course(code, title, credits);
        courseRepo.save(c);
    }

    public void addOffering(String id, String courseCode, String semester, String instructor, int capacity) {
        Course c = courseRepo.findByCode(courseCode);
        if (c == null) {
            throw new IllegalArgumentException("Course not found: " + courseCode);
        }
        Offering o = new Offering(id, c, semester, instructor, capacity);
        offeringRepo.save(o);
    }

    public Collection<Course> listCourses() {
        return courseRepo.findAll();
    }

    public Collection<Offering> listOfferings() {
        return offeringRepo.findAll();
    }
}

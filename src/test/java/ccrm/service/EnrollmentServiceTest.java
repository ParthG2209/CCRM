package ccrm.service;

import ccrm.dao.*;
import ccrm.model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EnrollmentServiceTest {

    @Test
    public void testComputeGPA() {
        StudentRepository sRepo = new StudentRepository();
        CourseRepository cRepo = new CourseRepository();
        OfferingRepository oRepo = new OfferingRepository();
        EnrollmentRepository eRepo = new EnrollmentRepository();

        Student s = new Student("S1", "Test Student", "test@example.com", "CSE", 2);
        sRepo.save(s);
        Course c1 = new Course("C1", "Course 1", 3);
        Course c2 = new Course("C2", "Course 2", 4);
        cRepo.save(c1);
        cRepo.save(c2);

        Offering o1 = new Offering("O1", c1, "2025-ODD", "Prof A", 10);
        Offering o2 = new Offering("O2", c2, "2025-ODD", "Prof B", 10);
        oRepo.save(o1);
        oRepo.save(o2);

        EnrollmentService es = new EnrollmentService(eRepo, sRepo, oRepo);
        es.enroll("E1", "S1", "O1");
        es.enroll("E2", "S1", "O2");

        es.setGrade("E1", "A");
        es.setGrade("E2", "B+");

        double gpa = es.computeGPAForStudent("S1");
        assertTrue(gpa > 0);
    }
}

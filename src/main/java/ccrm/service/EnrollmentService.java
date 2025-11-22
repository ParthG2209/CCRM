package ccrm.service;

import ccrm.dao.EnrollmentRepository;
import ccrm.dao.OfferingRepository;
import ccrm.dao.StudentRepository;
import ccrm.model.Enrollment;
import ccrm.model.Offering;
import ccrm.model.Student;
import ccrm.util.GPAUtil;

import java.util.List;

public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepo;
    private final StudentRepository studentRepo;
    private final OfferingRepository offeringRepo;

    public EnrollmentService(EnrollmentRepository enrollmentRepo,
                             StudentRepository studentRepo,
                             OfferingRepository offeringRepo) {
        this.enrollmentRepo = enrollmentRepo;
        this.studentRepo = studentRepo;
        this.offeringRepo = offeringRepo;
    }

    public void enroll(String enrollmentId, String studentId, String offeringId) {
        Student s = studentRepo.findById(studentId);
        if (s == null) throw new IllegalArgumentException("Student not found: " + studentId);
        Offering o = offeringRepo.findById(offeringId);
        if (o == null) throw new IllegalArgumentException("Offering not found: " + offeringId);

        List<Enrollment> inOffering = enrollmentRepo.findByOffering(o);
        if (inOffering.size() >= o.getCapacity()) {
            throw new IllegalStateException("Offering is full");
        }
        Enrollment e = new Enrollment(enrollmentId, s, o);
        enrollmentRepo.save(e);
    }

    public void setGrade(String enrollmentId, String grade) {
        for (Enrollment e : enrollmentRepo.findAll()) {
            if (e.getId().equals(enrollmentId)) {
                e.setGrade(grade);
                return;
            }
        }
        throw new IllegalArgumentException("Enrollment not found: " + enrollmentId);
    }

    public double computeGPAForStudent(String studentId) {
        Student s = studentRepo.findById(studentId);
        if (s == null) throw new IllegalArgumentException("Student not found: " + studentId);

        double totalPoints = 0.0;
        int totalCredits = 0;
        for (Enrollment e : enrollmentRepo.findByStudent(s)) {
            String grade = e.getGrade();
            if (grade == null) continue;
            int credits = e.getOffering().getCourse().getCredits();
            totalCredits += credits;
            totalPoints += GPAUtil.gradeToPoints(grade) * credits;
        }
        if (totalCredits == 0) return 0.0;
        return totalPoints / totalCredits;
    }

    public java.util.List<Enrollment> getEnrollmentsForStudent(String studentId) {
        Student s = studentRepo.findById(studentId);
        if (s == null) throw new IllegalArgumentException("Student not found: " + studentId);
        return enrollmentRepo.findByStudent(s);
    }
}

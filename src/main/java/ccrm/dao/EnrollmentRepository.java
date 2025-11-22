package ccrm.dao;

import ccrm.model.Enrollment;
import ccrm.model.Student;
import ccrm.model.Offering;
import java.util.*;

public class EnrollmentRepository {
    private final Map<String, Enrollment> enrollments = new HashMap<>();

    public void save(Enrollment e) {
        enrollments.put(e.getId(), e);
    }

    public Collection<Enrollment> findAll() {
        return enrollments.values();
    }

    public List<Enrollment> findByStudent(Student s) {
        List<Enrollment> result = new ArrayList<>();
        for (Enrollment e : enrollments.values()) {
            if (e.getStudent().getId().equals(s.getId())) {
                result.add(e);
            }
        }
        return result;
    }

    public List<Enrollment> findByOffering(Offering o) {
        List<Enrollment> result = new ArrayList<>();
        for (Enrollment e : enrollments.values()) {
            if (e.getOffering().getId().equals(o.getId())) {
                result.add(e);
            }
        }
        return result;
    }
}

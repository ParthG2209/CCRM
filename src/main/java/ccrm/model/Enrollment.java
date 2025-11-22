package ccrm.model;

public class Enrollment {
    private String id;
    private Student student;
    private Offering offering;
    private String grade; // e.g. O, A+, A, B+, B, C, F

    public Enrollment(String id, Student student, Offering offering) {
        this.id = id;
        this.student = student;
        this.offering = offering;
    }

    public String getId() { return id; }
    public Student getStudent() { return student; }
    public Offering getOffering() { return offering; }
    public String getGrade() { return grade; }

    public void setGrade(String grade) { this.grade = grade; }

    @Override
    public String toString() {
        return id + " - " + student.getId() + " in " + offering.getId() + (grade != null ? " grade=" + grade : "");
    }
}

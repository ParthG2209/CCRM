package ccrm.model;

public class Offering {
    private String id;
    private Course course;
    private String semester;
    private String instructor;
    private int capacity;

    public Offering(String id, Course course, String semester, String instructor, int capacity) {
        this.id = id;
        this.course = course;
        this.semester = semester;
        this.instructor = instructor;
        this.capacity = capacity;
    }

    public String getId() { return id; }
    public Course getCourse() { return course; }
    public String getSemester() { return semester; }
    public String getInstructor() { return instructor; }
    public int getCapacity() { return capacity; }

    public void setInstructor(String instructor) { this.instructor = instructor; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    @Override
    public String toString() {
        return id + " - " + course.getCode() + " (" + semester + ", " + instructor + ", cap=" + capacity + ")";
    }
}

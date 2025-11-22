package ccrm.model;

public class Student {
    private String id;
    private String name;
    private String email;
    private String program;
    private int year;

    public Student(String id, String name, String email, String program, int year) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.program = program;
        this.year = year;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getProgram() { return program; }
    public int getYear() { return year; }

    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setProgram(String program) { this.program = program; }
    public void setYear(int year) { this.year = year; }

    @Override
    public String toString() {
        return id + " - " + name + " (" + program + " Y" + year + ")";
    }
}

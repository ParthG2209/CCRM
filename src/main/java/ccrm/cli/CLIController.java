package ccrm.cli;

import ccrm.service.StudentService;
import ccrm.service.CourseService;
import ccrm.service.EnrollmentService;
import ccrm.model.Enrollment;
import ccrm.model.Student;
import ccrm.model.Course;
import ccrm.model.Offering;

import java.util.Scanner;

public class CLIController {
    private final StudentService studentService;
    private final CourseService courseService;
    private final EnrollmentService enrollmentService;

    public CLIController(StudentService studentService,
                         CourseService courseService,
                         EnrollmentService enrollmentService) {
        this.studentService = studentService;
        this.courseService = courseService;
        this.enrollmentService = enrollmentService;
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while (running) {
            printMenu();
            System.out.print("Enter choice: ");
            String choice = sc.nextLine().trim();
            try {
                switch (choice) {
                    case "1" -> addStudent(sc);
                    case "2" -> listStudents();
                    case "3" -> addCourse(sc);
                    case "4" -> listCourses();
                    case "5" -> addOffering(sc);
                    case "6" -> listOfferings();
                    case "7" -> enroll(sc);
                    case "8" -> setGrade(sc);
                    case "9" -> showTranscript(sc);
                    case "0" -> running = false;
                    default -> System.out.println("Invalid choice");
                }
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }

    private void printMenu() {
        System.out.println();
        System.out.println("=== CCRM Menu ===");
        System.out.println("1. Add student");
        System.out.println("2. List students");
        System.out.println("3. Add course");
        System.out.println("4. List courses");
        System.out.println("5. Add offering");
        System.out.println("6. List offerings");
        System.out.println("7. Enroll student");
        System.out.println("8. Set grade");
        System.out.println("9. Show transcript");
        System.out.println("0. Exit");
    }

    private void addStudent(Scanner sc) {
        System.out.print("Student id: ");
        String id = sc.nextLine().trim();
        System.out.print("Name: ");
        String name = sc.nextLine().trim();
        System.out.print("Email: ");
        String email = sc.nextLine().trim();
        System.out.print("Program: ");
        String program = sc.nextLine().trim();
        System.out.print("Year (int): ");
        int year = Integer.parseInt(sc.nextLine().trim());
        studentService.addStudent(id, name, email, program, year);
        System.out.println("Student added");
    }

    private void listStudents() {
        for (Student s : studentService.listStudents()) {
            System.out.println(s);
        }
    }

    private void addCourse(Scanner sc) {
        System.out.print("Course code: ");
        String code = sc.nextLine().trim();
        System.out.print("Title: ");
        String title = sc.nextLine().trim();
        System.out.print("Credits (int): ");
        int credits = Integer.parseInt(sc.nextLine().trim());
        courseService.addCourse(code, title, credits);
        System.out.println("Course added");
    }

    private void listCourses() {
        for (Course c : courseService.listCourses()) {
            System.out.println(c);
        }
    }

    private void addOffering(Scanner sc) {
        System.out.print("Offering id: ");
        String id = sc.nextLine().trim();
        System.out.print("Course code: ");
        String code = sc.nextLine().trim();
        System.out.print("Semester (e.g. 2025-ODD): ");
        String sem = sc.nextLine().trim();
        System.out.print("Instructor: ");
        String instructor = sc.nextLine().trim();
        System.out.print("Capacity (int): ");
        int cap = Integer.parseInt(sc.nextLine().trim());
        courseService.addOffering(id, code, sem, instructor, cap);
        System.out.println("Offering added");
    }

    private void listOfferings() {
        for (Offering o : courseService.listOfferings()) {
            System.out.println(o);
        }
    }

    private void enroll(Scanner sc) {
        System.out.print("Enrollment id: ");
        String id = sc.nextLine().trim();
        System.out.print("Student id: ");
        String sid = sc.nextLine().trim();
        System.out.print("Offering id: ");
        String oid = sc.nextLine().trim();
        enrollmentService.enroll(id, sid, oid);
        System.out.println("Enrollment created");
    }

    private void setGrade(Scanner sc) {
        System.out.print("Enrollment id: ");
        String id = sc.nextLine().trim();
        System.out.print("Grade (O,A+,A,B+,B,C,F): ");
        String grade = sc.nextLine().trim();
        enrollmentService.setGrade(id, grade);
        System.out.println("Grade set");
    }

    private void showTranscript(Scanner sc) {
        System.out.print("Student id: ");
        String sid = sc.nextLine().trim();
        System.out.println("Transcript for " + sid);
        for (Enrollment e : enrollmentService.getEnrollmentsForStudent(sid)) {
            System.out.println(e);
        }
        double gpa = enrollmentService.computeGPAForStudent(sid);
        System.out.printf("Computed GPA: %.2f%n", gpa);
    }
}

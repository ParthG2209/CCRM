Campus Course & Records Manager (CCRM)

A modular, console-based academic records system that manages students, courses, offerings, enrollments, grades, and GPA computation. Designed as a clean, college-level implementation demonstrating modular design, layered architecture, and basic data-handling workflows.

⸻

Overview

CCRM is a lightweight academic administration tool intended for small departments or institutional units that require a simple way to manage:
	•	Student information
	•	Course catalog
	•	Semester offerings
	•	Enrollments
	•	Grade recording
	•	GPA calculation
	•	Transcript-style reports

Everything runs purely in the console, with a structured service-layer architecture and in-memory repositories. The project demonstrates core principles of software design without relying on heavyweight databases or frameworks.

⸻

Features

Student Management
	•	Add new students
	•	Update academic details
	•	View complete student list

Course Management
	•	Add courses with credits
	•	Create semester-wise offerings
	•	List course catalog and offerings

Enrollment System
	•	Enroll students into offerings
	•	Validate offering capacity
	•	Assign and update grades
	•	Compute cumulative GPA

Reporting
	•	Transcript-style student record
	•	Enrollment listings per offering

⸻

Architecture

The system uses a clear, layered structure:

1. Presentation Layer
	•	Console interface (CLIController)
	•	Command-driven operations for all modules

2. Service Layer
	•	Independent services for:
	•	Students
	•	Courses & offerings
	•	Enrollments & grades
	•	GPA computation

3. Repository Layer
	•	In-memory storage for:
	•	Students
	•	Courses
	•	Offerings
	•	Enrollments

Each repository abstracts persistence, allowing easy future migration to a real database.

⸻

Project Structure

ccrm-project/
 ├─ src/
 │  ├─ main/java/ccrm/cli/
 │  ├─ main/java/ccrm/service/
 │  ├─ main/java/ccrm/dao/
 │  ├─ main/java/ccrm/model/
 │  └─ main/java/ccrm/util/
 ├─ src/test/java/...
 ├─ pom.xml
 ├─ README.md
 └─ statement.md


⸻

Running the Project

Requirements
	•	Java 17+
	•	Maven 3+

Build

mvn clean package

Run

java -jar target/ccrm-1.0-SNAPSHOT.jar


⸻

Usage Guide

The console displays a numbered menu for all major operations:

=== CCRM Menu ===
1. Add student
2. List students
3. Add course
4. List courses
5. Add offering
6. List offerings
7. Enroll student
8. Set grade
9. Show transcript
0. Exit

Example Actions

Add a student

1
Student id: S101
Name: Arjun Mehta
Email: arjun@example.com
Program: CSE
Year: 2

Enroll a student

7
Enrollment id: E201
Student id: S101
Offering id: OFR-CSE2001-1

Generate transcript

9
Student id: S101


⸻

Testing

JUnit tests validate:
	•	Enrollment workflow
	•	GPA computation
	•	Repository behavior
	•	Basic integrity rules

Run tests:

mvn test


⸻

Key Concepts Demonstrated
	•	Modular design
	•	Encapsulation through services
	•	Simple layered architecture
	•	Data modeling (Student, Course, Offering, Enrollment)
	•	Business rule validation (capacity, grading)
	•	Test-first verification using JUnit

⸻

Future Enhancements
	•	Shift from in-memory storage to SQLite or MongoDB
	•	Web interface (Express/React/JavaFX)
	•	Authentication and role-based access
	•	CSV import/export
	•	Automated transcript PDF generation
	•	Attendance or timetable modules

⸻

Author

Developed as part of an academic project requirement to practice design thinking, modular programming, and real-world system modeling.

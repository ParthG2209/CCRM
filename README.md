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
```

On first run, use the menu shown in the console to add students, courses, offerings, enrollments and grades.

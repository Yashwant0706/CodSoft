import java.io.*;
import java.util.*;

class Student {

    private String name;
    private int rollNumber;
    private String grade;
    private String course;

    Student(String name, int rollNumber, String grade, String course) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        this.course = course;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String display() {
        return "Roll: " + rollNumber +
               ", Name: " + name +
               ", Grade: " + grade +
               ", Course: " + course;
    }

    @Override
    public String toString() {
        return rollNumber + "," + name + "," + grade + "," + course;
    }
}


public class StudentManagementSystem {

    private static final String FILE_NAME = "students.txt";
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        loadStudents();

        int choice;
        do {
            System.out.println("\n----- Student Management System -----");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Remove Student");
            System.out.println("4. Search Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> editStudent();
                case 3 -> removeStudent();
                case 4 -> searchStudent();
                case 5 -> displayStudents();
                case 6 -> saveStudents();
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 6);

        System.out.println("Application exited.");
    }

    // Add student
    private static void addStudent() {
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        if (name.isEmpty()) {
            System.out.println("Name cannot be empty!");
            return;
        }

        System.out.print("Enter roll number: ");
        int roll = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter grade: ");
        String grade = sc.nextLine();

        System.out.print("Enter course: ");
        String course = sc.nextLine();

        students.add(new Student(name, roll, grade, course));
        System.out.println("Student added successfully.");
    }

    // Edit student
    private static void editStudent() {
        System.out.print("Enter roll number to edit: ");
        int roll = sc.nextInt();
        sc.nextLine();

        for (Student s : students) {
            if (s.getRollNumber() == roll) {
                System.out.print("Enter new name: ");
                s.setName(sc.nextLine());

                System.out.print("Enter new grade: ");
                s.setGrade(sc.nextLine());

                System.out.print("Enter new course: ");
                s.setCourse(sc.nextLine());

                System.out.println("Student updated.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Remove student
    private static void removeStudent() {
        System.out.print("Enter roll number to remove: ");
        int roll = sc.nextInt();

        students.removeIf(s -> s.getRollNumber() == roll);
        System.out.println("Student removed (if existed).");
    }

    // Search student
    private static void searchStudent() {
        System.out.print("Enter roll number to search: ");
        int roll = sc.nextInt();

        for (Student s : students) {
            if (s.getRollNumber() == roll) {
                System.out.println(s.display());
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Display all students
    private static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        for (Student s : students) {
            System.out.println(s.display());
        }
    }

    // File handling: save
    private static void saveStudents() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Student s : students) {
                pw.println(s.toString());
            }
        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }

    // File handling: load
    private static void loadStudents() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                students.add(new Student(
                        data[1],
                        Integer.parseInt(data[0]),
                        data[2],
                        data[3]
                ));
            }
        } catch (Exception e) {
            System.out.println("Error loading file.");
        }
    }
}
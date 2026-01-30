
import java.util.*;

public class StudentGradeCalcultor {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Subjects : ");
        int n = sc.nextInt();
        int totalMarks = 0;

        //----Input marks----//
        for (int i = 1; i <= n; i++) {
            System.out.println("Enter marks of Subject " + i + " (out of 100)");
            int marks = sc.nextInt();

            //----Optional Vaidation----//
            if (marks < 0 || marks > 100) {
                System.out.println("Invalid marks! Eneter marks between 0 to 100.");
                i--;
                continue;
            }
            totalMarks += marks;
        }

        //----Calculate average percentage----//
        double average = (double) totalMarks / n;

        //----GradeCalculation----//
        String grade;
        if (average >= 90) {
            grade = "A+";
        } else if (average >= 80) {
            grade = "A";
        } else if (average >= 70) {
            grade = "B";
        } else if (average >= 60) {
            grade = "C";
        } else if (average >= 50) {
            grade = "D";
        } else {
            grade = "F (Fail)";
        }

        //----Display Result----//
        System.out.println("----* RESULT *----");
        System.out.println("Total Marks = " + totalMarks + " (Out of " + n * 100 + ")");
        System.out.println("Average percentage = " + average + "%");
        System.out.println("Grade = " + grade);

        sc.close();
    }

}

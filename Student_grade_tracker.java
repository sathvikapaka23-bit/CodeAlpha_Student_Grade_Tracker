import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    String name;
    double marks;

    Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {

            System.out.print("\nEnter student name: ");
            String name = sc.nextLine();

            double marks;

            // ✅ Input validation loop
            while (true) {
                System.out.print("Enter marks: ");

                if (sc.hasNextDouble()) {
                    marks = sc.nextDouble();
                    sc.nextLine();
                    break;
                } else {
                    System.out.println("Invalid input! Please enter a number.");
                    sc.next(); // discard wrong input
                }
            }

            students.add(new Student(name, marks));
        }

        if (students.isEmpty()) {
            System.out.println("No students entered.");
            return;
        }

        double total = 0;
        double highest = students.get(0).marks;
        double lowest = students.get(0).marks;

        String highestStudent = students.get(0).name;
        String lowestStudent = students.get(0).name;

        System.out.println("\n===== STUDENT REPORT =====");

        for (Student s : students) {

            System.out.println(s.name + " : " + s.marks);
            total += s.marks;

            if (s.marks > highest) {
                highest = s.marks;
                highestStudent = s.name;
            }

            if (s.marks < lowest) {
                lowest = s.marks;
                lowestStudent = s.name;
            }
        }

        double average = total / students.size();

        System.out.printf("\nAverage Marks : %.2f\n", average);
        System.out.println("Highest Marks : " + highest +
                           " (" + highestStudent + ")");
        System.out.println("Lowest Marks  : " + lowest +
                           " (" + lowestStudent + ")");

        sc.close();
    }
}
import java.util.Scanner;

class Student {
    String name;
    int[] marks;
    int totalMarks;
    double average;
    
    // Constructor to initialize student data
    Student(String name, int subjects) {
        this.name = name;
        this.marks = new int[subjects];
    }
    
    // Method to calculate total marks
    void calculateTotal() {
        totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }
        
    }

    void calculateAverage(){
        average = (double) totalMarks / marks.length;
    }
    
    // Method overloading: Assign grade based on marks
    char assignGrade(int marks) {
        if (marks >= 90) return 'A';
        else if (marks >= 80) return 'B';
        else if (marks >= 70) return 'C';
        else if (marks >= 60) return 'D';
        else return 'F';
    }
    
    // Method overloading: Assign grade based on average
    char assignGrade() {
        return assignGrade((int) average);
    }
    
    // Method to print student details
    void display() {
        System.out.println("\nTotal Marks: " + totalMarks);
        System.out.println("Average Marks: " + average);
        System.out.println("Grade: " + assignGrade());
    }
}

public class StudentGradeSystem {
    
    // Recursive method to find highest mark
    static int findHighest(int[] marks, int n) {
        if (n == 1) return marks[0];
        return Math.max(marks[n - 1], findHighest(marks, n - 1));
    }
    
    // Demonstrating pass-by-value
    static void modifyValue(int x) {
        x = x + 10; // Changes only the local copy
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Take input for number of students
        System.out.print("Enter number of students: ");
        int numStudents = sc.nextInt();
        
        // Declare an array of Student objects
        Student[] students = new Student[numStudents];
        
        int highestMark = Integer.MIN_VALUE;
        
        // Taking input for each student
        for (int i = 0; i < numStudents; i++) {
            sc.nextLine(); // Consume newline
            System.out.print("\nEnter name of student " + (i + 1) + ": ");
            String name = sc.nextLine();
            
            System.out.print("Enter number of subjects: ");
            int numSubjects = sc.nextInt();
            
            students[i] = new Student(name, numSubjects);
            
            System.out.print("Enter marks in " + numSubjects + " subjects: ");
            for (int j = 0; j < numSubjects; j++) {
                students[i].marks[j] = sc.nextInt();
            }
            
            students[i].calculateTotal();
            students[i].display();
            
            // Find the highest mark among all students
            highestMark = Math.max(highestMark, findHighest(students[i].marks, students[i].marks.length));
        }
        
        System.out.println("\nHighest mark among all: " + highestMark);
        
        // Demonstrating pass-by-value
        int testValue = 50;
        modifyValue(testValue);
        System.out.println("\nValue after calling modifyValue(): " + testValue); // Still 50
        
        sc.close();
    }
}

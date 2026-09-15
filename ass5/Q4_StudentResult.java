package ass5;

import java.util.Scanner;

public class Q4_StudentResult {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Student Result Processor ---");
        
        try {
            System.out.print("Enter number of subjects: ");
            int numSubjects = scanner.nextInt();
            
            if (numSubjects <= 0) {
                System.out.println("Invalid number of subjects.");
                return;
            }
            
            int[] marks = new int[numSubjects];
            int total = 0;
            
            for (int i = 0; i < numSubjects; i++) {
                System.out.print("Enter marks for subject " + (i + 1) + ": ");
                int mark = scanner.nextInt();
                
                // Throw custom exception if marks are invalid
                if (mark < 0 || mark > 100) {
                    throw new InvalidMarksException("Marks must be between 0 and 100. Entered: " + mark);
                }
                
                marks[i] = mark;
                total += mark;
            }
            
            // Calculate total, percentage, and grade only when all input is valid
            double percentage = (double) total / numSubjects;
            String grade;
            if (percentage >= 90) grade = "A+";
            else if (percentage >= 80) grade = "A";
            else if (percentage >= 70) grade = "B";
            else if (percentage >= 60) grade = "C";
            else grade = "F";
            
            System.out.println("\n--- Result Summary ---");
            System.out.println("Total Marks: " + total + " / " + (numSubjects * 100));
            System.out.println("Percentage: " + String.format("%.2f", percentage) + "%");
            System.out.println("Grade: " + grade);
            
        } catch (InvalidMarksException e) {
            // Meaningful error message
            System.out.println("Validation Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Invalid input encountered.");
        } finally {
            scanner.close();
            System.out.println("Processor closed.");
        }
    }
}

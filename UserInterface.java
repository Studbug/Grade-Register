import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private Grades grades;
    
    public UserInterface(Scanner scanner, Grades grades) {
        this.scanner = scanner;
        this.grades = grades;
    }
    
    public void start() {
        System.out.println("Enter point totals, -1 stops:");
        while (true) {
            int grade = Integer.valueOf(scanner.nextLine());
            if (grade == -1) {
                break;
            }
            grades.addGrade(grade);
        }
        grades.addGradesToDistribution();
        System.out.println(grades);
        int grade = 5;
        while (grade >= 0) {
            int stars = grades.numberOfGrades(grade);
            System.out.print(grade + ": ");
            while (stars > 0) {
                System.out.print("*");
                stars--;
            }
            System.out.println("");
            grade--;
        }
    }
}

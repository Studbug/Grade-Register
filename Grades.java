
import java.util.Collections;
import java.util.ArrayList;

public class Grades {

    private ArrayList<Integer> grades;
    private ArrayList<Integer> passingGrades;
    private ArrayList<Integer> gradeDistribution;

    public Grades() {
        this.grades = new ArrayList<>();
        this.passingGrades = new ArrayList<>();
        this.gradeDistribution = new ArrayList<>();
    }

    public void addGrade(int grade) {
        if (grade >= 0 && grade <= 100) {
            this.grades.add(grade);
        }
        if (grade >= 50 && grade <= 100) {
            this.passingGrades.add(grade);
        }
    }
    
    public ArrayList<Integer> getGradeDistribution() {       
        return this.gradeDistribution;
    }

    public double getAverage() {
        int sum = 0;
        if (!this.grades.isEmpty()) {
            for (Integer grade : grades) {
                sum += grade;
            }
            return (double) sum / grades.size();
        }
        return -1;
    }

    public double getPassingAverage() {
        int sum = 0;
        if (!this.passingGrades.isEmpty()) {
            for (Integer grade : passingGrades) {
                sum += grade;
            }
            return (double) sum / passingGrades.size();
        }
        return -1;
    }

    public double getPassingPercentage() {
        return (double) 100 * this.passingGrades.size() / this.grades.size();
    }

    public void printGrades() {
        for (Integer grade : grades) {
            System.out.println(grade);
        }
    }
    
    public int numberOfGrades(int gradeRequest) {
        int count = 0;         
        for (int grade : this.gradeDistribution) {
            if (grade == gradeRequest) {
                count++;
            }
        }
        return count;
    }
    public void addGradesToDistribution() {
        for (int grade : this.grades) {
            this.gradeDistribution.add(pointsToGrades(grade));
        }
    }
            
    public static int pointsToGrades(int points) {
        int grade = 0;
        if (points < 50) {
            grade = 0;
        } else if (points < 60) {
            grade = 1;
        } else if (points < 70) {
            grade = 2;
        } else if (points < 80) {
            grade = 3;
        } else if (points < 90) {
            grade = 4;
        } else {
            grade = 5;
        }

        return grade;
    }
    
    
    @Override
    public String toString() {
        if (this.grades.isEmpty()) {
            return "There are no recorded grades.";
        }
        if (this.getPassingAverage() == -1) {
            return "Point average (all): " + this.getAverage()
                    + "\nPoint average (passing): -"
                    + "\n Pass percentage: 0.0"
                    + "\n Grade distribuition: ";
        }
        return "Point average (all): " + this.getAverage()
                + "\nPoint average (passing): " + this.getPassingAverage()
                + "\nPass percentage: " + this.getPassingPercentage();
    }
}

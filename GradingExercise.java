package Wednesday;

import java.util.Scanner;

public class GradingExercise {
    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    double a = 90.0;
    double b = 80.0;
    double c = 70.0;
    double f = 69.0;

    double grade1;

    System.out.println("Input grade here: ");
    grade1 = sc.nextDouble();
    System.out.println("The grade was: " + grade1);

    if (grade1 == 90 || grade1 > 90) {
        System.out.println("The grade is: A");
    }
    else if (grade1 >= 80 && grade1 < 90) {
        System.out.println("The grade is: B");
    }
    else if (grade1 >= 70 && grade1 < 80) {
        System.out.println("The grade is: C");
    }
    else if (grade1 <= 69) {
        System.out.println("The grade is: F");
        System.out.println("Not passed.");
    } else {
        System.out.println("Please enter only a grade number.");
    }

    sc.close();




    }
}

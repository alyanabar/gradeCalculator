/**
 * author [Alyana Barrera]
 * CS1180, Summer 2020
 * Project 2
 */

import java.util.Scanner;

/**
 * This program will calculate a percentage score for a single student in 
 * four grading categories (labs, projects, quizzes, and exams), then it will
 * output a final percentage and letter grade using a weighted average.
 */

class Main {

  /**
     * Prompts user to enter name, values of the grades they have received 
     * in the class with a given range, and a yes or no questions for looping
     * program over again
     * @param args 
     */
  
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
        
        //Declared constants
        final int NUMBER_OF_LABS = 5;
        final int NUMBER_OF_PROJECTS = 3;
        final int NUMBER_OF_QUIZZES = 5;
        final int NUMBER_OF_EXAMS = 2;
        final double POINTS_PER_LAB = 10;
        final double POINTS_PER_PROJECT = 50;
        final double POINTS_PER_QUIZ = 5;
        final double POINTS_PER_EXAM = 100;
        final double LAB_WEIGHT = .15;
        final double PROJECT_WEIGHT = .25;
        final double QUIZ_WEIGHT = .10;
        final double EXAM_WEIGHT = .50;
        final double A = 90;
        final double B = 80;
        final double C = 70;
        final double D = 60;
        final double F = 0;
        
        //Declared variables
        String name;
        double labGrade, labSum, labAvg = 0;
        double projectGrade, projectSum, projectAvg = 0;
        double quizGrade, quizSum, quizAvg = 0;
        double examGrade, examSum, examAvg = 0;
        int countLab, countProject, countQuiz, countExam;
        double courseAvg;
        char nextStudent;
        
        //do loop for repeating program for another student
        do{
        
            //Enter name input for student
            System.out.print("Enter the student's name: ");
            name = keyboard.nextLine();
            System.out.println();

            //Lab grade loop for 5 loops, input validation loop, and lab average calculation 
            countLab = 1;
            labSum = 0;
            while (countLab <= NUMBER_OF_LABS) 
            {
                System.out.print("Enter lab grade " + countLab + ": ");
                labGrade = keyboard.nextDouble();
                while (labGrade < 0 || labGrade > POINTS_PER_LAB)
                {
                    System.out.print("All lab grades must be between 0 and 10. Please re-enter: ");
                    labGrade = keyboard.nextDouble();
                }
                labSum = labSum + labGrade;
                labAvg = (labSum/50)*100;
                countLab++;
            }
            System.out.println();

            //Project grade loop for 3 loops, intput validation loop, and project average calculation
            countProject = 1;
            projectSum = 0;
            while (countProject <= NUMBER_OF_PROJECTS)
            {
                System.out.print("Enter project grade " + countProject + ": ");
                projectGrade = keyboard.nextDouble();
                while (projectGrade < 0 || projectGrade > POINTS_PER_PROJECT)
                {
                    System.out.print("All project grades must be between 0 and 50. Please re-enter: ");
                    projectGrade = keyboard.nextDouble();
                }
                projectSum = projectSum + projectGrade;
                projectAvg = (projectSum/150)*100;
                countProject++;
            }
            System.out.println();

            //Quiz grade loop for 5 loops, input validation loop, and quiz average calculation
            countQuiz = 1;
            quizSum = 0;
            while (countQuiz <= NUMBER_OF_QUIZZES)
            {
                System.out.print("Enter quiz grade " + countQuiz + ": ");
                quizGrade = keyboard.nextDouble();
                while (quizGrade < 0 || quizGrade > POINTS_PER_QUIZ)
                {
                    System.out.print("All quiz grades must be between 0 and 5. Please re-enter: ");
                    quizGrade = keyboard.nextDouble();
                }
                quizSum = quizSum + quizGrade;
                quizAvg = (quizSum/25)*100;
                countQuiz++;
            }
            System.out.println();

            //Exam grade loop for 2 loops, input validation loop, and exam average calculation
            countExam = 1;
            examSum = 0;
            while (countExam <= NUMBER_OF_EXAMS)
            {
                System.out.print("Enter exam grade " + countExam + ": ");
                examGrade = keyboard.nextDouble();
                while (examGrade < 0 || examGrade > POINTS_PER_EXAM)
                {
                    System.out.print("All exam grades must be between 0 and 100. Please re-enter: ");
                    examGrade = keyboard.nextDouble();
                }
                examSum = examSum + examGrade;
                examAvg = (examSum/200)*100;
                countExam++;
            }
            System.out.println();

            //Output of section averages (lab, project, quiz, and exam averages)
            System.out.println("Grade for " + name + ": ");
            System.out.printf("    Lab average: %.1f%%\n", labAvg);
            System.out.printf("    Project average: %.1f%%\n", projectAvg);
            System.out.printf("    Quiz average: %.1f%%\n", quizAvg);
            System.out.printf("    Exam average: %.1f%%\n", examAvg);

            //Calculations for course average and output
            courseAvg = (labAvg*LAB_WEIGHT) + (projectAvg*PROJECT_WEIGHT) + (quizAvg*QUIZ_WEIGHT) + (examAvg*EXAM_WEIGHT);
            System.out.printf("Course average for " + name + ": %.2f%%\n", courseAvg);

            //Determine course grade based off grade cutoffs
            if (courseAvg >= A)
            {
                System.out.println("Course grade for " + name + ": A");
            }
            else if (courseAvg >= B && courseAvg < A)
            {
                System.out.println("Course grade for " + name + ": B");
            }
            else if (courseAvg >= C && courseAvg < B)
            {
                System.out.println("Course grade for " + name + ": C");
            }
            else if (courseAvg >= D && courseAvg < C)
            {
                System.out.println("Course grade for " + name + ": D");
            }
            else if (courseAvg >= F && courseAvg < D)
            {
                System.out.println("Course grade for " + name + ": F");
            }
            System.out.println();

            //Ask for input y/n and redo loop for another student if y
            System.out.print("Do you wnat to enter grades for another student(Y/N)? ");
            nextStudent = keyboard.next().charAt(0);
            keyboard.nextLine();
            System.out.println();
        }while(nextStudent == 'y' || nextStudent == 'Y');
        
  }
}
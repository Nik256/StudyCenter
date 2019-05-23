package menu;

import center.StudyCenter;

import java.util.Scanner;

public class Menu {
    private StudyCenter studyCenter;

    public Menu(StudyCenter studyCenter) {
        this.studyCenter = studyCenter;
    }

    public void showMenu() {
        System.out.printf("\n%2s %-40s", "1.", "Calculate student number of days left");
        System.out.printf("\n%2s %-40s", "2.", "Calculate student average mark");
        System.out.printf("\n%2s %-40s", "3.", "Calculate possibility of student success");
        System.out.printf("\n%2s %-40s", "4.", "List students sorted by average mark");
        System.out.printf("\n%2s %-40s", "5.", "List students sorted by time left to end of entity");
        System.out.printf("\n%2s %-40s", "6.", "List students full info");
        System.out.printf("\n%2s %-40s", "7.", "List only possible success students");
        System.out.printf("\n%2s %-40s\n\n", "0.", "Quit");

        selectMenuItem();
    }

    private void selectMenuItem() {
        Scanner scanner = new Scanner(System.in);
        Scanner strScanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        String studentName;
        switch (choice) {
            case 1:
                studentName = strScanner.nextLine();
                studyCenter.showStudentNumberOfDaysLeftByName(studentName);
                break;
            case 2:
                studentName = strScanner.nextLine();
                studyCenter.showStudentAverageMarkByName(studentName);
                break;
            case 3:
                studentName = strScanner.nextLine();
                studyCenter.showStudentIsPossibleToSucceedByName(studentName);
                break;
            case 4:
                studyCenter.listStudentsSortedByNameAverageMark();
                break;
            case 5:
                studyCenter.listStudentsSortedByLeftDaysToEndOfStudy();
                break;
            case 6:
                studyCenter.listStudentsFullInfo();
                break;
            case 7:
                studyCenter.listOnlySuccessStudents();
                break;
            case 0:
                break;
            default:
                break;
        }
    }
}

package console;

import center.StudyCenter;

import java.util.Scanner;

public class Menu {
    private StudyCenter studyCenter;

    public Menu(StudyCenter studyCenter) {
        this.studyCenter = studyCenter;
    }

    public void showMenu() {
        System.out.printf("\n%2s %-40s", "1.", "List students sorted by average mark");
        System.out.printf("\n%2s %-40s", "2.", "List students sorted by time left to end of study");
        System.out.printf("\n%2s %-40s", "3.", "List students full info");
        System.out.printf("\n%2s %-40s", "4.", "List only possible success students");
        System.out.printf("\n%2s %-40s\n\n", "0.", "Quit");

        selectMenuItem();
    }

    public void selectMenuItem() {
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                studyCenter.listStudentsSortedByNameAverageMark();
                break;
            case 2:
                studyCenter.listStudentsSortedByLeftDaysToEndOfStudy();
                break;
            case 3:
                studyCenter.listStudentsFullInfo();
                break;
            case 4:
                studyCenter.listOnlySucessStudents();
                break;
            case 0:
                break;
            default:
                break;
        }
    }

//    public void clearConsole() {
//        System.out.print("\033[H\033[2J");
//        System.out.flush();
//    }
}

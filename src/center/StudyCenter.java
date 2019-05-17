package center;

import study.Course;
import study.Curriculum;
import study.Student;
import utils.AverageMarkComparator;
import utils.DaysLeftComparator;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class StudyCenter {
    private List<Student> students;

    public StudyCenter() {
    }

    public StudyCenter(List<Student> students) {
        this.students = students;
    }

    public long calculateNumberOfDaysLeft(Student student) {
        double numberOfHoursToStudy = 0;
        for (Course course : student.getCurriculum().getCourses()) {
            numberOfHoursToStudy += course.getDuration();
        }

        LocalDate startDate = student.getCurriculum().getStartDate();
        LocalDate endDate = startDate.plusDays((long) Math.ceil(numberOfHoursToStudy / 8));
        LocalDate currentDate = LocalDate.now();

        if (currentDate.isBefore(startDate)) {
            return ChronoUnit.DAYS.between(startDate, endDate) + 1;
        }

        if (currentDate.isAfter(endDate) || currentDate.isEqual(endDate)) {
            return 0;
        } else {
            return ChronoUnit.DAYS.between(currentDate, endDate);
        }
    }

//    public long calculateNumberOfHoursLeft(Student student) {
//        double numberOfHoursToStudy = 0;
//        for (Course course : student.getCurriculum().getCourses()) {
//            numberOfHoursToStudy += course.getDuration();
//        }
//
//        LocalDate startDate = student.getCurriculum().getStartDate();
//        LocalDate endDate = startDate.plusDays((long) Math.ceil(numberOfHoursToStudy / 8));
//        LocalDate currentDate = LocalDate.now();
//    }

    public double calculateAverageMark(Student student) {
        return getMarkSum(student.getMarks()) / (double) student.getMarks().size();
    }

    public int getMarkSum(List<Integer> marks) {
        int markSum = 0;
        for (Integer mark : marks) {
            markSum += mark;
        }
        return markSum;
    }

    public long getNumberOfDaysToStudy(Curriculum curriculum) {
        double numberOfHoursToStudy = 0;
        for (Course course : curriculum.getCourses()) {
            numberOfHoursToStudy += course.getDuration();
        }

        LocalDate startDate = curriculum.getStartDate();
        LocalDate endDate = startDate.plusDays((long) Math.ceil(numberOfHoursToStudy / 8));

        return ChronoUnit.DAYS.between(startDate, endDate) + 1;
    }

    public boolean calculateStudentDeduction(Student student) {
        if (((getNumberOfDaysToStudy(student.getCurriculum()) -
                student.getMarks().size()) * 5 +
                getMarkSum(student.getMarks())) /
                (double) getNumberOfDaysToStudy(student.getCurriculum()) >= 4.5f) {
            return true;
        } else {
            return false;
        }
    }

    public void listStudentsSortedByNameAverageMark() {
        students.sort(new AverageMarkComparator());
        System.out.printf("\n%-30s %s\n", "Name", "Average mark");
        System.out.printf("-------------------------------------------\n");
        for (Student student : students) {
            System.out.printf("%-30s %.2f\n",
                    student.getName(),
                    calculateAverageMark(student));
        }
    }

    public void listStudentsSortedByLeftDaysToEndOfStudy() {
        students.sort(new DaysLeftComparator());
        System.out.printf("\n%-30s %s\n", "Name", "Days Left");
        System.out.printf("----------------------------------------\n");
        for (Student student : students) {
            System.out.printf("%-30s %d\n",
                    student.getName(),
                    calculateNumberOfDaysLeft(student));
        }
    }

    public void listStudentsFullInfo() {
        System.out.printf("\n%-30s %-20s %-15s %-30s\n", "Name", "Curriculum", "Average mark", "Possibility Of Deduction");
        System.out.printf("--------------------------------------------------------------------------------------------\n");
        for (Student student : students) {
            System.out.printf("%-30s %-20s %-15.2f %-30s\n",
                    student.getName(),
                    student.getCurriculum().getName(),
                    calculateAverageMark(student),
                    calculateStudentDeduction(student));
        }
    }

    public void listOnlySucessStudents() {
        System.out.printf("\n%-30s %-20s %-15s\n", "Name", "Curriculum", "Average mark");
        System.out.printf("----------------------------------------------------------------\n");
        for (Student student : students) {
            if (calculateStudentDeduction(student)) {
                System.out.printf("%-30s %-20s %-15.2f\n",
                        student.getName(),
                        student.getCurriculum().getName(),
                        calculateAverageMark(student));
            }
        }
    }
}

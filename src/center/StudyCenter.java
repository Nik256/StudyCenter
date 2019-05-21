package center;

import entity.Course;
import entity.Curriculum;
import entity.Student;
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

    private Student getStudentByName(String studentName) {
        Student student = students.stream().filter(st -> studentName.equals(st.getName()))
                .findFirst().orElse(null);
        if (student == null) {
            throw new RuntimeException("Wrong student name");
        }
        return student;
    }

    public void showStudentNumberOfDaysLeftByName(String studentName) {
        Student student = getStudentByName(studentName);
        System.out.printf("\n%-30s %s\n", "Name", "Days Left");
        System.out.print("----------------------------------------\n");
        System.out.printf("%-30s %d\n",
                student.getName(),
                calculateNumberOfDaysLeft(student));
    }

    public double calculateAverageMark(Student student) {
        return getMarkSum(student.getMarks()) / (double) student.getMarks().size();
    }

    public void showStudentAverageMarkByName(String studentName) {
        Student student = getStudentByName(studentName);
        System.out.printf("\n%-30s %s\n", "Name", "Average mark");
        System.out.print("-------------------------------------------\n");
        System.out.printf("%-30s %.2f\n",
                student.getName(),
                calculateAverageMark(student));
    }

    private int getMarkSum(List<Integer> marks) {
        int markSum = 0;
        for (Integer mark : marks) {
            markSum += mark;
        }
        return markSum;
    }

    private long getNumberOfDaysToStudy(Curriculum curriculum) {
        double numberOfHoursToStudy = 0;
        for (Course course : curriculum.getCourses()) {
            numberOfHoursToStudy += course.getDuration();
        }

        LocalDate startDate = curriculum.getStartDate();
        LocalDate endDate = startDate.plusDays((long) Math.ceil(numberOfHoursToStudy / 8));

        return ChronoUnit.DAYS.between(startDate, endDate) + 1;
    }

    private boolean calculatePossibilityOfStudentSuccess(Student student) {
        return ((getNumberOfDaysToStudy(student.getCurriculum()) -
                student.getMarks().size()) * 5 +
                getMarkSum(student.getMarks())) /
                (double) getNumberOfDaysToStudy(student.getCurriculum()) >= 4.5f;
    }

    public void showStudentIsPossibleToSucceedByName(String studentName) {
        Student student = getStudentByName(studentName);
        System.out.printf("\n%-30s %-15s %-30s\n", "Name", "Average mark", "Possibility Of Success");
        System.out.print("---------------------------------------------------------------------\n");
        System.out.printf("%-30s %-15.2f %-30s\n",
                student.getName(),
                calculateAverageMark(student),
                calculatePossibilityOfStudentSuccess(student));
    }

    public void listStudentsSortedByNameAverageMark() {
        students.sort(new AverageMarkComparator());
        System.out.printf("\n%-30s %s\n", "Name", "Average mark");
        System.out.print("-------------------------------------------\n");
        for (Student student : students) {
            System.out.printf("%-30s %.2f\n",
                    student.getName(),
                    calculateAverageMark(student));
        }
    }

    public void listStudentsSortedByLeftDaysToEndOfStudy() {
        students.sort(new DaysLeftComparator());
        System.out.printf("\n%-30s %s\n", "Name", "Days Left");
        System.out.print("----------------------------------------\n");
        for (Student student : students) {
            System.out.printf("%-30s %d\n",
                    student.getName(),
                    calculateNumberOfDaysLeft(student));
        }
    }

    public void listStudentsFullInfo() {
        System.out.printf("\n%-30s %-20s %-15s %-30s\n", "Name", "Curriculum", "Average mark", "Possibility Of Success");
        System.out.print("--------------------------------------------------------------------------------------------\n");
        for (Student student : students) {
            System.out.printf("%-30s %-20s %-15.2f %-30s\n",
                    student.getName(),
                    student.getCurriculum().getName(),
                    calculateAverageMark(student),
                    calculatePossibilityOfStudentSuccess(student));
        }
    }

    public void listOnlySuccessStudents() {
        System.out.printf("\n%-30s %-20s %-15s\n", "Name", "Curriculum", "Average mark");
        System.out.print("----------------------------------------------------------------\n");
        for (Student student : students) {
            if (calculatePossibilityOfStudentSuccess(student)) {
                System.out.printf("%-30s %-20s %-15.2f\n",
                        student.getName(),
                        student.getCurriculum().getName(),
                        calculateAverageMark(student));
            }
        }
    }
}

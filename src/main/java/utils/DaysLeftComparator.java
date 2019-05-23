package utils;

import center.StudyCenter;
import entity.Student;

import java.util.Comparator;

public class DaysLeftComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        StudyCenter studyCenter = new StudyCenter();
        return Long.compare(studyCenter.calculateNumberOfDaysLeft(o1),
                studyCenter.calculateNumberOfDaysLeft(o2));
    }
}

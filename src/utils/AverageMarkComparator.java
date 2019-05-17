package utils;

import center.StudyCenter;
import study.Student;

import java.util.Comparator;

public class AverageMarkComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        StudyCenter studyCenter = new StudyCenter();
        return Double.compare(studyCenter.calculateAverageMark(o1),
                studyCenter.calculateAverageMark(o2));
    }
}

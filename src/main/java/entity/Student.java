package entity;

import java.util.List;

public class Student {
    private String name;
    private Curriculum curriculum;
    private List<Integer> marks;

    public Student(String name, Curriculum curriculum, List<Integer> marks) {
        this.name = name;
        this.curriculum = curriculum;
        this.marks = marks;
    }

    public List<Integer> getMarks() {
        return marks;
    }

    public void setMarks(List<Integer> marks) {
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Curriculum getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(Curriculum curriculum) {
        this.curriculum = curriculum;
    }
}

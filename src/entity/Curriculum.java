package entity;

import java.time.LocalDate;
import java.util.List;

public class Curriculum {
    private String name;
    private List<Course> courses;
    private LocalDate startDate;

    public Curriculum(String name, List<Course> courses, LocalDate startDate) {
        this.name = name;
        this.courses = courses;
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
}

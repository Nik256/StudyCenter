package demo;

import center.StudyCenter;
import menu.Menu;
import entity.Course;
import entity.Curriculum;
import entity.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DemoStudyCenter {

    public void execute() {
        List<Student> students = new ArrayList<>();

        // Ivanov Ivan
        List<Course> courses = new ArrayList<>();
        courses.add(new Course("Технология Java Servlets", 16));
        courses.add(new Course("Struts Framework", 24));
        courses.add(new Course("Spring Framework", 48));
        courses.add(new Course("Hibernate", 20));

        Curriculum curriculum = new Curriculum("J2EE Developer", courses, LocalDate.of(2019, 5, 20));

        List<Integer> marks = new ArrayList<>();
        marks.add(3);
        marks.add(4);
        marks.add(2);
        marks.add(5);
        marks.add(3);
        marks.add(3);

        students.add(new Student("Ivanov Ivan", curriculum, marks));

        // Petrov Petr
        courses = new ArrayList<>();
        courses.add(new Course("Обзор технологий Java", 8));
        courses.add(new Course("Библиотека JFC/Swing", 16));
        courses.add(new Course("Технология JDBC", 16));
        courses.add(new Course("Технология JAX", 16));
        courses.add(new Course("Библиотеки commons", 44));

        curriculum = new Curriculum("Java Developer", courses, LocalDate.of(2019, 5, 12));

        marks = new ArrayList<>();
        marks.add(4);
        marks.add(5);
        marks.add(3);
        marks.add(2);
        marks.add(3);
        marks.add(3);
        marks.add(5);
        marks.add(5);

        students.add(new Student("Petrov Petr", curriculum, marks));

        // Sidorov Sidor
        courses = new ArrayList<>();
        courses.add(new Course("Обзор технологий C++", 16));
        courses.add(new Course("Библиотека Qt", 32));
        courses.add(new Course("Библиотека STL", 16));
        courses.add(new Course("Библиотека Boost", 32));
        courses.add(new Course("Анализатор кода PVS-Studio", 16));

        curriculum = new Curriculum("C++ Developer", courses, LocalDate.of(2019, 5, 16));

        marks = new ArrayList<>();
        marks.add(4);
        marks.add(3);

        students.add(new Student("Sidorov Sidor", curriculum, marks));

        // Alexandrov Alexander
        courses = new ArrayList<>();
        courses.add(new Course("Обзор Ruby", 16));
        courses.add(new Course("Функциональное программирование", 24));
        courses.add(new Course("Фреймворк Ruby on Rails", 32));

        curriculum = new Curriculum("Ruby Developer", courses, LocalDate.of(2019, 5, 15));

        marks = new ArrayList<>();
        marks.add(4);
        marks.add(5);
        marks.add(5);

        students.add(new Student("Alexandrov Alexander", curriculum, marks));

        // show menu
        Menu menu = new Menu(new StudyCenter(students));
        menu.showMenu();
    }
}

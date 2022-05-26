package LessonNine;

import javax.xml.crypto.Data;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;



public class HomeTask {
    public static void main(String[] args) {
        List<Student> students = Data.getStudentsList();
        Course randomCourse = Data.randomCourse();
        System.out.println(getUnicsCourses(students));
        System.out.println(inquisitiveStudents(students));
        System.out.println(getStudentsFromCourse(students, randomCourse));
    }


    public static List<Course> getUnicsCourses(List<Student> students) {
        return students.stream()
                .flatMap(student -> student.getAllCourses().stream())
                .distinct()
                .collect(Collectors.toList());
    }


    public static List<Student> inquisitiveStudents(List<Student> students) {
        return students.stream()
                .sorted((s1, s2) -> (s2.getAllCourses().size()) - (s1.getAllCourses().size()))
                .limit(3)
                .collect(Collectors.toList());
    }


    public static List<Student> getStudentsFromCourse(List<Student> students, Course course) {
        System.out.println("Ищем студентов проходящих курс " + course);
        return students.stream()
                .filter(student -> student.getAllCourses().contains(course))
                .collect(Collectors.toList());
    }

    static class Data {

        public static List<Student> getStudentsList() {
            return null;
        }


        public static Course randomCourse() {
            return null;
        }
    }

    interface Student {
        String getName();

    List<Course> getAllCourses();
    }

   interface Course {

   }
}

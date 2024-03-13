package kz.bitlab.springboot.springSprint1.db;

import kz.bitlab.springboot.springSprint1.model.Students;

import java.util.ArrayList;

public class DBManager {
    public static ArrayList<Students> studentList = new ArrayList<>();
    private static Long id = 4L;

    static {
        studentList.add(new Students(1L, "Maksat", "Smagulov", 99, "A"));
        studentList.add(new Students(2L, "Aibek", "Abdukarimov", 89, "B"));
        studentList.add(new Students(3L, "Ernar", "Shahan", 48, "F"));
    }

    public static ArrayList<Students> getAllStudents() {
        return studentList;
    }

    public static void addStudent (Students student) {
        student.setId(id);
        studentList.add(student);
        id++;

        if (student.getExam() >= 90) {
            student.setMark("A");
        } else if (student.getExam() >= 75 && student.getExam() <= 89) {
            student.setMark("B");
        } else if (student.getExam() >= 60 && student.getExam() <= 74) {
            student.setMark("C");
        } else if (student.getExam() >= 50 && student.getExam() <= 59) {
            student.setMark("D");
        } else {
            student.setMark("F");
        }
    }

    public static String getMarkStyle(Students student) {
        return student.getMark().equals("F") ? "color: red;" : "";
    }
}

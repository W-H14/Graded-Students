package my;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Classroom {
    private Student[] students;
    private int maxNumberOfStudents;

    public Classroom(int maxNumberOfStudents) {
        this.maxNumberOfStudents = maxNumberOfStudents;
    }

    public Classroom(Student[] students) {
        this.students = students;
    }
    public Classroom() {
        this.students = new Student[30];
        this.maxNumberOfStudents = 30;
    }

    public Student[] getStudents() {
        return students;
    }
    public double getAverageExamScore() {
        double totalAverage = 0.0;
        int count = 0;

        for (Student student : students) {
                totalAverage += student.getAverageExamScore();
                count++;
        }
        return totalAverage / count;
    }
    public void addStudent(Student student) {
        for (int i = 0; i < maxNumberOfStudents; i++) {
            if (students[i] == null) {
                students[i] = student;
                return;
            }
        }
        System.out.println("Classroom is full. Cannot add more students.");
    }

    public void removeStudent(String firstName, String lastName) {
        for (int i = 0; i < maxNumberOfStudents; i++) {
            if (students[i] != null && students[i].getFirstName().equals(firstName) && students[i].getLastName().equals(lastName)) {
                students[i] = null;
                break;
            }
        }
    }
    public Student[] getStudentsByScore() {
        Student[] sortedStudents = Arrays.copyOf(students, students.length);
        Arrays.sort(sortedStudents, (s1, s2) -> {
            if (s1 == null && s2 == null) {
                return 0;
            } else if (s1 == null) {
                return 1;
            } else if (s2 == null) {
                return -1;
            } else {
                double scoreDiff = s2.getAverageExamScore() - s1.getAverageExamScore();
                if (scoreDiff == 0) {
                    return s1.getLastName().compareTo(s2.getLastName());
                } else {
                    return Double.compare(scoreDiff, 0);
                }
            }
        });
        return sortedStudents;
    }

    public Map<Student, String> getGradeBook() {
        Student[] sortedStudents = getStudentsByScore();
        Map<Student, String> gradeBook = new HashMap<>();

        int upper10thPercentile = (int) Math.ceil(0.1 * maxNumberOfStudents);
        int upper11thTo29thPercentile = (int) Math.ceil(0.29 * maxNumberOfStudents);
        int upper30thTo50thPercentile = (int) Math.ceil(0.50 * maxNumberOfStudents);
        int lower51stTo89thPercentile = (int) Math.ceil(0.89 * maxNumberOfStudents);

        for (int i = 0; i < maxNumberOfStudents; i++) {
            if (sortedStudents[i] != null) {
                if (i < upper10thPercentile) {
                    gradeBook.put(sortedStudents[i], "A");
                } else if (i < upper11thTo29thPercentile) {
                    gradeBook.put(sortedStudents[i], "B");
                } else if (i < upper30thTo50thPercentile) {
                    gradeBook.put(sortedStudents[i], "C");
                } else if (i < lower51stTo89thPercentile) {
                    gradeBook.put(sortedStudents[i], "D");
                } else {
                    gradeBook.put(sortedStudents[i], "F");
                }
            }
        }

        return gradeBook;
    }

}

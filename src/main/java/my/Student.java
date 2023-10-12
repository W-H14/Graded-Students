package my;

import java.util.ArrayList;

public class Student {
        private String firstName;
        private String lastName;
        private ArrayList<Double> examScores;

        public Student(String firstName, String lastName, Double [] testScores) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.examScores = new ArrayList<>();
            for (Double score : testScores) {
                this.examScores.add(score);
            }
        }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getExamScores() {
        String output = "Exam Scores:\n";

        for (int i = 0; i < examScores.size(); i++) {
            output += "\tExam " + (i + 1) + " -> " + examScores.get(i) + "\n";
        }

        return output;
    }
    public int getNumberOfExamsTaken() {
        return examScores.size();
    }
    public void addExamScore(double examScore){
            examScores.add(examScore);
    }
    public void setExamScore(int examNumber, double newScore) {
        examScores.set(examNumber - 1, newScore);
    }
    public double getAverageExamScore() {
        if (examScores.isEmpty()) {
            return 0.0;
        }
        double sum = 0.0;
        for (Double score : examScores) {
            sum += score;
        }
        return sum / examScores.size();
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", examScores=" + examScores +
                ", numberOfExamsTaken=" + getNumberOfExamsTaken() +
                ", averageExamScore=" + getAverageExamScore() +
                '}';
    }
}

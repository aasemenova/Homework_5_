package Lesson_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Student {
    private String name;
    private String surname;
    private String patronymic;
    private List<Integer> scores;

    public Student(String name, String surname, String patronymic, List<Integer> scores) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.scores = scores;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public List<Integer> getScores() {
        return scores;
    }

    public void setScores(List<Integer> scores) {
        this.scores = scores;
    }

    public static void findWinners(List<Student> students) {
        students.sort((s1, s2) -> {
            double avgScore1 = s1.getScores().stream().mapToInt(Integer::intValue).average().orElse(0);
            double avgScore2 = s2.getScores().stream().mapToInt(Integer::intValue).average().orElse(0);
            return Double.compare(avgScore2, avgScore1);
        });
        for (int i = 0; i < 3; i++) {
            System.out.println(i + 1 + " место: " + students.get(i).getSurname() + " " + students.get(i).getName() + " " + students.get(i).getPatronymic());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfParticipants = 3;
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < numberOfParticipants; i++) {
            System.out.println("Введите имя студента:");
            String name = scanner.next();
            System.out.println("Введите фамилию студента:");
            String surname = scanner.next();
            System.out.println("Введите отчество студента:");
            String patronymic = scanner.next();
            System.out.println("Введите баллы студента:");
            scanner.nextLine();
            List<Integer> scoreList = Arrays.stream(scanner.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            students.add(new Student(name, surname, patronymic, scoreList));
        }

        Student.findWinners(students);
    }
}
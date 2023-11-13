package Lesson_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class House {
    public static void main(String[] args) {
        HashMap<String, Integer> residents = new HashMap<>();

        residents.put("Петров Сергей Александрович", 37);
        residents.put("Михайлова Мария Евгеньевна", 25);
        residents.put("Левицкая Ева Дмитриевна", 17);
        residents.put("Васильев Матвей Сергеевич", 13);
        residents.put("Крушинская Полина Андреевна", 29);

        ArrayList<String> adults = residents.entrySet().stream()
                .filter(entry -> entry.getValue() > 18)
                .sorted(Map.Entry.comparingByValue())
                .map(entry -> entry.getKey() + " - " + entry.getValue() + " лет")
                .collect(Collectors.toCollection(ArrayList::new));

        System.out.println("Жильцы старше 18 лет: " + adults);
    }
}
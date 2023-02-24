/*Пусть дан список сотрудников: 
    Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, Иван Юрин, Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова, 
    Марина Светлова, Мария Савина, Мария Рыкова, Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов. 
Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. 
Отсортировать по убыванию популярности. Для сортировки использовать TreeMap. */

package HW_5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Task2 {
    public static void main(String[] args) {
        String text = "Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, Иван Юрин, Петр Лыков, " +
                      "Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова, " +
                      "Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов";
        
        Map<String, Integer> map = toMap(text);
        System.out.printf("-> считаем имена: \t\t\t%s\n", map.toString());
        TreeMap<Integer, List<String>> tmap = toTreeMap(map);
        System.out.printf("-> сортируем по количеству повторений: \t%s\n", tmap.toString());
        printResult(tmap);
    }

    private static Map<String, Integer> toMap(String text) {
        String[] txt = text.split(",");
        Map<String, Integer> map = new HashMap<>();
        for (String elem : txt) {
            String name = elem.trim().split(" ")[0];
            if (map.containsKey(name)) { map.put(name, map.get(name) + 1); }
            else                       { map.put(name, 1); }
        }
        return map;
    }

    private static TreeMap<Integer, List<String>> toTreeMap(Map<String, Integer> map) {
        TreeMap<Integer, List<String>> tmap = new TreeMap<>(Collections.reverseOrder());
        for (Map.Entry<String, Integer> item : map.entrySet()) {
            if (tmap.containsKey(item.getValue())) {
                List<String> list = tmap.get(item.getValue());
                list.add(item.getKey());
            }
            else {
                List<String> list = new ArrayList<>();
                list.add(item.getKey());
                tmap.put(item.getValue(), list);
            }
        }
        return tmap;
    }
    private static void printResult(Map<Integer, List<String>> tmap) {
        System.out.println("-> сортируем повторяющиеся имена поколичеству повторений:");
        for (Map.Entry<Integer, List<String>> elem : tmap.entrySet()) {
            if (elem.getKey() != 1) {
                System.out.printf("%d раза встречается - %s\n", 
                                  elem.getKey(), 
                                  String.join(", ", elem.getValue()));
            }
        }
    }
}

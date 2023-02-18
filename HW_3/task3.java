/* 3.Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифметическое этого списка */

import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class task3 {
    public static void main(String[] args) {
        List<Integer> array = createArray(28, -100, 100);
        printResult(array, checkArray(array));
    }

    private static List<Integer> createArray(int size, int min, int max) {
        List<Integer> arr = new ArrayList<>();
        if (min < max) {
            Random rnd = new Random();
            for (int i=0; i < size; i++) arr.add(rnd.nextInt(min, max));
        }
        return arr;
    }

    private static HashMap<String, Integer> checkArray(List<Integer> arr) {
        HashMap<String, Integer> result = new HashMap<String, Integer>();
        Iterator<Integer> it = arr.iterator();
        int min = arr.get(0);
        int max = min, sum = 0, curr = 0;
        while (it.hasNext()) {
            curr = it.next();
            min = (curr < min) ? curr : min;
            max = (curr > max) ? curr : max;
            sum += curr;
        }
        result.put("size", arr.size());
        result.put("min", min);
        result.put("max", max);
        result.put("sum", sum);
        return result;
    }

    private static void printResult(List<Integer> arr, HashMap<String, Integer> result){
        System.out.printf("массив целых чисел: %s\n", arr.toString());
        System.out.printf("минимальное значение: %d\n", result.get("min"));
        System.out.printf("максимальное значение: %d\n", result.get("max"));
        double mid = result.get("sum") / (double)result.get("size");
        System.out.printf("среднее арифметическое значение: %.2f\n", mid);
        return;
    }
}

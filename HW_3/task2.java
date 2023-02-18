/* 2.Пусть дан произвольный список целых чисел, удалить из него четные числа */

import java.util.Random;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class task2 {
    public static void main(String[] args) {
        List<Integer> arr = createArray(30, 0, 200);
        System.out.println(arr);
        oddRemove(arr);
        System.out.println(arr);
    }

    private static List<Integer> createArray(int size, int min, int max) {
        List<Integer> arr = new ArrayList<>();
        if (min < max) {
            Random rnd = new Random();
            for (int i=0; i < size; i++) arr.add(rnd.nextInt(min, max));
        }
        return arr;
    }

    private static void oddRemove(List<Integer> arr) {
        Iterator<Integer> it = arr.iterator();
        while (it.hasNext()) {
            if (it.next() % 2 == 0) it.remove();
        }
        return;
    }
}

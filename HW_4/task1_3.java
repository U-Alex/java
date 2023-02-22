package HW_4;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class task1_3 {
    public static void main(String[] args) {
        LinkedList<Integer> list1 = CreateArray(20, 10, 100);
        System.out.printf("исходный: \t%s\n", list1.toString());
        LinkedList<Integer> list2 = ReverseList(list1);
        System.out.printf("перевернутый: \t%s\n", list2.toString());
        int sum = SumList(list1);
        System.out.printf("сумма элементов: %d\n", sum);
    }
    private static LinkedList<Integer> CreateArray(int size, int min, int max) {
        LinkedList<Integer> arr = new LinkedList<>();
        if ((min < max) && size > 0) {
            Random rnd = new Random();
            for (int i=0; i < size; i++) arr.add(rnd.nextInt(min, max));
        }
        return arr;
    }
    private static LinkedList<Integer> ReverseList(LinkedList<Integer> list) {
        LinkedList<Integer> new_list = new LinkedList<>();
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            new_list.addFirst(it.next());
        }
        return new_list;
    }
    private static Integer SumList(LinkedList<Integer> list) {
        int sum = 0;
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            sum += it.next();
        }
        return sum;
    }
}

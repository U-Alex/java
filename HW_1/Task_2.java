package HW_1;
/*2. Вывести все простые числа от 1 до 1000 */

import java.util.ArrayList;

public class Task_2 {
    public static void main(String[] args) {
        ArrayList<Integer> simple_list = new ArrayList<Integer>();
        for (int num = 2; num <= 1000; num++) {
            if (isSimple(num)) simple_list.add(num);
        }
        printList(simple_list);
    }
    private static boolean isSimple(int num) {
        boolean simple = true;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                simple = false;
                break;
            }
        }
        return simple;
    }
    private static void printList(ArrayList<Integer> sl) {
        for (int i = 0; i < sl.size(); i++) {
            if (i == 0) System.out.println("простые числа от 1 до 1000");
            else if (i % 8 == 0) System.out.println();
            System.out.printf(" %d\t", sl.get(i));
        }
        return;
    }
}

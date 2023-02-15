/* 2 . Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.*/

package HW_2;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.FileHandler;

public class task2 {
    public static void main(String[] args) {
        int[] arr = {11, 3, 14, 16, 7, 0, 2, 3, 4, 11, 3};
        bub_sorting(arr);
    }
    
    private static void bub_sorting(int[] arr) {
        Logger logger = Logger.getLogger(task2.class.getName());
        try {
            FileHandler fh = new FileHandler("log_sort_task2.txt");
            logger.addHandler(fh);
        }
        catch (IOException e) {System.out.println(e);}

        logger.log(Level.INFO, Arrays.toString(arr));
        int temp;
        boolean exchange = true;
        while (exchange) {
            exchange = false;
            for (int i = 0; i < arr.length-1; i++) {
                if (arr[i] > arr[i+1]) {
                    exchange = true;
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
            if (exchange) logger.log(Level.INFO, Arrays.toString(arr));
        }
    }
}

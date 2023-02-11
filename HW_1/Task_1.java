package HW_1;
/*1. Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n) */

import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {
        int num = userInput();
        int sum = sumNums(num);
        System.out.printf("сумма чисел от 1 до %d = %d\n", num, sum);
        if (num > 20) {
            System.out.printf("произведение чисел от 1 до %d и выше, в рамках этого задания не вычисляется\n", num);
        }
        else {
            long mul = mulNums(num);
            System.out.printf("произведение чисел от 1 до %d = %d\n", num, mul);
        }
    }
    private static int userInput() {
        Scanner iScanner = new Scanner(System.in);
        boolean ok = false;
        int i = 0;
        String text = "введите целое положительное число: ";
        while (!ok) {
            System.out.printf(text);
            while (!iScanner.hasNextInt()){
                System.out.printf(text);
                iScanner.next();
            }
            i = iScanner.nextInt();
            if (i > 1) ok = true;
        }
        iScanner.close();
        return i;
    }
    private static int sumNums(int num) {
        int sum = 0;
        for (int i=1; i <= num; i++) sum += i;
        return sum;
    }
    private static long mulNums(int num) {
        long mul = 1;
        for (int i=1; i <= num; i++) mul *= i;
        return mul;
    }
}

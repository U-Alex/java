/*На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга. */

package HW_5;

import java.util.Random;

public class Task4 {
    public static void main(String[] args) {
        int[][] arr = new int[8][8];
        Random rnd = new Random();
        int queen, row, col, next;
        boolean ok = false;
        int repeat;
        for (repeat = 0; !ok; repeat++) {
            clearArray(arr);
            queen = 8;
            while (queen > 0) {
                if (!checkNull(arr)) break;
                next = rnd.nextInt(0, 64);
                row = next / 8;
                col = next % 8;
                if (arr[row][col] != 0) continue;
                setQueen(arr, queen, row, col);
                queen--;
            }
            ok = (queen == 0) ? true : false;
        }
        System.out.printf("количество попыток - %d\n", repeat);
        printArray(arr);
    }
    
    private static void clearArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = 0;
            }
        }
    }

    private static void setQueen(int[][] arr, int queen, int row, int col) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == row && j == col) arr[i][j] = queen;
                else {
                    if (i == row || j == col) arr[i][j] = -1;
                }
            }
        }
        if (row < 8) {
            for (int id = 1; id <= 7-row; id++) {
                if (col-id >= 0) arr[row+id][col-id] = -1;
                if (col+id < 8) arr[row+id][col+id] = -1;
            }
        }
        if (row > 0) {
            for (int iu = 1; iu <= row; iu++) {
                if (col-iu >= 0) arr[row-iu][col-iu] = -1;
                if (col+iu < 8) arr[row-iu][col+iu] = -1;
            }
        }
    }

    private static boolean checkNull(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0) return true;
            }
        }
        return false;
    }

    private static void printArray(int[][] arr) {
        int pos;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                pos = arr[i][j];
                if (pos > 0) System.out.print(arr[i][j] + " ");
                else {
                    if (pos == 0) System.out.print("+ ");
                    else System.out.print(". "); 
                }
            }
            System.out.println();
        }
    }
}

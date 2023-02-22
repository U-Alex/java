/*Реализуйте очередь с помощью LinkedList со следующими методами: 
enqueue() - помещает элемент в конец очереди, 
dequeue() - возвращает первый элемент из очереди и удаляет его, 
first() - возвращает первый элемент из очереди, не удаляя. */
package HW_4;

import java.util.Iterator;
import java.util.LinkedList;
//import HW_4.CustomList;

public class task2_3 {
    public static void main(String[] args) {
        CustomList customList = new CustomList();

        for (int i = 1; i < 10; i++) customList.enqueue(i);
        System.out.printf("очередь: \t\t\t%s\n", customList.getAllElem());
        System.out.printf("размер очереди: \t\t%d\n", customList.listSize());
        System.out.printf("первый элемент: (удаляем) \t%d\n", customList.dequeue());
        System.out.printf("очередь: \t\t\t%s\n", customList.getAllElem());
        System.out.printf("первый элемент: (не удаляем) \t%d\n", customList.first());
        System.out.printf("очередь: \t\t\t%s\n", customList.getAllElem());
        System.out.printf("сумма элементов: \t\t%d\n", customList.SumList());
    }
}


// в vscode  почему-то не получается вынести класс в отдельный файл
public class CustomList {
    private LinkedList<Integer> list;
    
    CustomList() {
        list = new LinkedList<>();
    }

    void enqueue(int elem) {
        list.addLast(elem);
    }

    Integer dequeue() {
        if (!list.isEmpty()) return list.removeFirst();
        return null;
    }

    Integer first() {
        if (!list.isEmpty()) return list.getFirst();
        return null;
    }

    LinkedList<Integer> getAllElem() {
        return list;
    }

    int listSize() {
        return list.size();
    }

    Integer SumList() {
        int sum = 0;
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            sum += it.next();
        }
        return sum;
    }
}

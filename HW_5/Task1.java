/*Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов. */

package HW_5;

public class Task1 {
    public static void main(String[] args) {
        Phone phone = new Phone();
        System.out.println("-> заполняем справочник");
        phone.add("Вася", "+71111111111");
        phone.add("Петя", "+71111111222");
        phone.add("Гриша", "+71111111333");
        phone.add("Вася", "+71111111444");
        phone.add("Гриша", "+71111111555");
        System.out.println("-> показываем весь справочник");
        System.out.println(phone.getAll());
        System.out.println("-> показываем телефоны Гриши");
        System.out.println(phone.getName("Гриша"));
        System.out.println("-> пытаемся записать повторно существующий телефон Пети");
        System.out.println(phone.add("Петя", "+71111111222"));
        System.out.println("-> пытаемся удалить несуществующий телефон Пети");
        System.out.println(phone.del("Петя", "+7000"));
        System.out.println("-> пытаемся удалить один из телефонов Васи");
        System.out.println(phone.del("Вася", "+71111111444"));
        System.out.println("-> показываем весь справочник");
        System.out.println(phone.getAll());
        System.out.println("-> пытаемся удалить второй из телефонов Васи");
        System.out.println(phone.del("Вася", "+71111111111"));
        System.out.println("-> показываем весь справочник");
        System.out.println(phone.getAll());
    }
}
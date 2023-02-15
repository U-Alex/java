/* 3* . Дана json строка (можно сохранить в файл и читать из файла)
[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
Пример вывода:
Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика.*/

package HW_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class task3 {
    public static void main(String[] args) {
        String line = readFile();
        List<String> final_line = parse(line);
        print(final_line);
    }

    private static String readFile() {
        String pathProject = System.getProperty ("user.dir" );
        String pathFile = pathProject.concat("/HW_2/task3.txt" );
        String line = new String();
        try {
            File file = new File(pathFile);
            BufferedReader bufReader = new BufferedReader(new FileReader(file));
            line = bufReader.readLine();
            bufReader.close();
        }
        catch (Exception e) {e.printStackTrace();}
        return line;
    }

    private static List<String> parse(String line) {
        String[] lst = line.replace("[{", "").replace("}]", "").split("\\},\\{", 0);
        List<String> final_list = new ArrayList<String>();
        for (String string : lst) {
            StringBuilder sb = new StringBuilder("Студент(ка) ");
            String[] str = string.replaceAll("\"", "").split(",", 0);
            sb.append(str[0].split(":", 0)[1]);
            sb.append(" получил(а) ");
            sb.append(str[1].split(":", 0)[1]);
            sb.append(" предмету ");
            sb.append(str[2].split(":", 0)[1]);
            sb.append(".");

            final_list.add(sb.toString());
        }
        return final_list;
    }

    private static void print(List<String> list) {
        for (String string : list) {
            System.out.println(string);
        }
    }
}

package HW_1;
/*3. Реализовать простой калькулятор */

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Task_3 {
    public static void main(String[] args) {
        List<String> example_list = new ArrayList<String>();
        example_list.add("-2+2*3-4/2");
        example_list.add("4*(3-2+1)+5");
        example_list.add("10*((5-2)+2*3)-2");
        example_list.add("-1*(1+2+3)");
        for (String line : example_list) {
            List<String> lst = parse(line);
            String res = operate(lst);
            System.out.printf(" %s = %s \n", line, res);
        }
    }
    private static List<String> parse(String line) {
        line = line.replace("(", " ( ").replace(")", " ) ");
        line = line.replace("*", " * ").replace("/", " / ");
        line = line.replace("+", " + ").replace("-", " - ");
        line = line.replaceAll("\\s+", " ").strip();
        List<String> it_list = new ArrayList<String>(Arrays.asList(line.split(" ")));
        if (it_list.get(0).startsWith("-")) {
            it_list.set(1, "-" + it_list.get(1));
            it_list.remove(0);
        }
        return it_list;
    }

    private static String operate(List<String> lst) {
        while (lst.size() > 1) lst = parentheses(lst);
        return lst.get(0);
    }

    private static List<String> parentheses(List<String> lst) {
        int lst_size = lst.size();
        for (int i = 0; i < lst_size; i++) {
            if (lst.get(i).contentEquals("(")) {
                int i_st = i;
                for (int j = i; j < lst_size; j++) {
                    if (lst.get(i_st).contentEquals("(")) i_st = j;
                    if (lst.get(j).contentEquals(")")) {
                        operate2(lst.subList(i_st, j));
                        lst.remove(i_st+1);
                        lst.remove(i_st-1);
                        return lst;
                    }
                }
                //error
            }
        }
        List<String> temp = new ArrayList<String>();
        temp.add(0, operate2(lst));
        return temp;
    }

    private static String operate2(List<String> lst) {
        while (lst.size() > 1) lst = running(lst);
        return lst.get(0);
    }

    private static List<String> running(List<String> lst) {
        for (int i = 0; i < lst.size(); i++) {
            if (lst.get(i).contentEquals("*")) {
                lst.set(i-1, String.valueOf(Double.parseDouble(lst.get(i-1)) * Double.parseDouble(lst.get(i+1))));
                lst.remove(i+1);
                lst.remove(i);
                return lst;
            }
            if (lst.get(i).contentEquals("/")) {
                lst.set(i-1, String.valueOf(Double.parseDouble(lst.get(i-1)) / Double.parseDouble(lst.get(i+1))));
                lst.remove(i+1);
                lst.remove(i);
                return lst;
            }
        }
        for (int i = 0; i < lst.size(); i++) {
            if (lst.get(i).contentEquals("+")) {
                lst.set(i-1, String.valueOf(Double.parseDouble(lst.get(i-1)) + Double.parseDouble(lst.get(i+1))));
                lst.remove(i+1);
                lst.remove(i);
                return lst;
            }
            if (lst.get(i).contentEquals("-")) {
                lst.set(i-1, String.valueOf(Double.parseDouble(lst.get(i-1)) - Double.parseDouble(lst.get(i+1))));
                lst.remove(i+1);
                lst.remove(i);
                return lst;
            }
        }
        return lst;
    }

}

/* 4*. К калькулятору из предыдущего дз добавить логирование. */
package HW_2;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.io.IOException;

public class task4 {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(task4.class.getName());
        try {
            FileHandler fh = new FileHandler("log_calc_task4.txt");
            logger.addHandler(fh);
        }
        catch (IOException e) {System.out.println(e);}

        List<String> example_list = new ArrayList<String>();
        example_list.add("-2+2*3-4/0"); //zero divide
        example_list.add("4*(3-2+1)+5");
        example_list.add("10*((5-2)+2*3)-2");
        example_list.add("-1*(1+2+3)");
        for (String line : example_list) {
            List<String> lst = parse(line, logger);
            logger.log(Level.INFO, " new examlpe ");
            logger.log(Level.INFO, line + " parsing to list " + lst.toString());
            String res = operate(lst, logger);
            logger.log(Level.INFO, line + " result: " + res);
            System.out.printf(" %s = %s \n", line, res);
        }
    }
    private static List<String> parse(String line, Logger logger) {
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

    private static String operate(List<String> lst, Logger logger) {
        while (lst.size() > 1) {
            lst = parentheses(lst, logger);
        }
        return lst.get(0);
    }

    private static List<String> parentheses(List<String> lst, Logger logger) {
        int lst_size = lst.size();
        for (int i = 0; i < lst_size; i++) {
            if (lst.get(i).contentEquals("(")) {
                int i_st = i;
                for (int j = i; j < lst_size; j++) {
                    if (lst.get(i_st).contentEquals("(")) i_st = j;
                    if (lst.get(j).contentEquals(")")) {
                        operate2(lst.subList(i_st, j), logger);
                        lst.remove(i_st+1);
                        lst.remove(i_st-1);
                        logger.log(Level.INFO, " parentheses: " + lst.toString());
                        return lst;
                    }
                }
                logger.log(Level.WARNING, "not found ')'");
            }
        }
        List<String> temp = new ArrayList<String>();
        temp.add(0, operate2(lst, logger));
        return temp;
    }

    private static String operate2(List<String> lst, Logger logger) {
        while (lst.size() > 1) lst = running(lst, logger);
        return lst.get(0);
    }

    private static List<String> running(List<String> lst, Logger logger) {
        for (int i = 0; i < lst.size(); i++) {
            if (lst.get(i).contentEquals("*")) {
                lst.set(i-1, String.valueOf(Double.parseDouble(lst.get(i-1)) * Double.parseDouble(lst.get(i+1))));
                lst.remove(i+1);
                lst.remove(i);
                logger.log(Level.INFO, " operate * -> result: " + lst.toString());
                return lst;
            }
            if (lst.get(i).contentEquals("/")) {
                if (Double.parseDouble(lst.get(i+1)) == 0) logger.log(Level.WARNING, " zero divide ");
                lst.set(i-1, String.valueOf(Double.parseDouble(lst.get(i-1)) / Double.parseDouble(lst.get(i+1))));
                lst.remove(i+1);
                lst.remove(i);
                logger.log(Level.INFO, " operate / -> result: " + lst.toString());
                return lst;
            }
        }
        for (int i = 0; i < lst.size(); i++) {
            if (lst.get(i).contentEquals("+")) {
                lst.set(i-1, String.valueOf(Double.parseDouble(lst.get(i-1)) + Double.parseDouble(lst.get(i+1))));
                lst.remove(i+1);
                lst.remove(i);
                logger.log(Level.INFO, " operate + -> result: " + lst.toString());
                return lst;
            }
            if (lst.get(i).contentEquals("-")) {
                lst.set(i-1, String.valueOf(Double.parseDouble(lst.get(i-1)) - Double.parseDouble(lst.get(i+1))));
                lst.remove(i+1);
                lst.remove(i);
                logger.log(Level.INFO, " operate - -> result: " + lst.toString());
                return lst;
            }
        }
        return lst;
    }
}

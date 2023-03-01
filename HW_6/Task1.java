package HW_6;


import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class Task1 {
    public static void main(String[] args) {
        Filter filter = new Filter();
        List<Notebook> nbList = readDb(filter);
        List<Notebook> sortedList = new ArrayList<>();

        int num;
        int[] nums;
        Scanner iScanner = new Scanner(System.in);
        while (true) {
            filter.view();
            sorting(nbList, sortedList, filter);
            printNotebook(sortedList);

            num = userInput(iScanner, 5);
            if (num == 0) break;
            if (num == 1) {
                LinkedHashMap<String, Boolean> list = filter.getBrands();
                printList(list);
                num = userInput(iScanner, list.size());
                if (num != 0) filter.setBrands(num);
                continue;
            }
            if (num == 2) {
                printInt(filter.getRamSize());
                nums = userInput2(iScanner);
                if (!(nums[0] == 0 && nums[1] == 0)) filter.setRamSize(nums);
                continue;
            }
            if (num == 3) {
                printInt(filter.getHddSize());
                nums = userInput2(iScanner);
                if (!(nums[0] == 0 && nums[1] == 0)) filter.setHddSize(nums);
                continue;
            }
            if (num == 4) {
                LinkedHashMap<String, Boolean> list = filter.getColors();
                printList(list);
                num = userInput(iScanner, list.size());
                if (num != 0) filter.setColors(num);
                continue;
            }
            if (num == 5) {
                LinkedHashMap<String, Boolean> list = filter.getOsys();
                printList(list);
                num = userInput(iScanner, list.size());
                if (num != 0) filter.setOsys(num);
                continue;
            }
        }
        iScanner.close();
    }

    public static void sorting(List<Notebook> nbList, List<Notebook> sortedList, Filter filter) {
        LinkedHashMap<String, Boolean> brand = filter.getBrands();
        LinkedHashMap<String, Boolean> color = filter.getColors();
        LinkedHashMap<String, Boolean> osys = filter.getOsys();
        sortedList.clear();
        for (Notebook nb : nbList) {
            if ((brand.get(nb.brand)) &&
                (nb.ramSize >= filter.getRamSize()[0] && nb.ramSize <= filter.getRamSize()[1]) &&
                (nb.hddSize >= filter.getHddSize()[0] && nb.hddSize <= filter.getHddSize()[1]) &&
                (color.get(nb.color)) &&
                (osys.get(nb.oSys))
                ) {
                sortedList.add(nb);
            }
        }
        return;
    }

    private static void printList(LinkedHashMap<String, Boolean> list) {
        int i = 0;
        String boo;
        for (Map.Entry<String, Boolean> item : list.entrySet()) {
            i++;
            boo = (item.getValue()) ? "(+)" : "(-)";
            System.out.printf("%d %s %s\n", i, boo, item.getKey());

        }
    }
    private static void printInt(Integer[] nums) {
        System.out.printf("текущий интервал: %d -- %d\n", nums[0], nums[1]);
    }
    private static void printNotebook(List<Notebook> nbList) {
        System.out.println("доступные модели:");
        for (Notebook nb : nbList) {
            System.out.println(nb);
        }
    }

    private static int userInput(Scanner iScanner, int max) {
        boolean ok = false;
        int i = 0;
        String text = "\nвведите число (номер фильтра) от 1 до " + max + ": (0 -> выход) ";
        while (!ok) {
            System.out.printf(text);
            while (!iScanner.hasNextInt()){
                System.out.printf(text);
                iScanner.next();
            }
            i = iScanner.nextInt();
            if (i >= 0 && i <= max) ok = true;
        }
        return i;
    }
    private static int[] userInput2(Scanner iScanner) {
        boolean ok = false;
        int[] nums = new int[2];
        String text = "\nвведите число или интервал через \'-\' : (0 -> выход) ";
        String[] inp;
        while (!ok) {
            System.out.printf(text);
            while (!iScanner.hasNext()){
                System.out.printf(text);
                iScanner.next();
            }
            inp = iScanner.next().split("-");
            if (inp.length < 2) {
                nums[0] = Integer.parseInt(inp[0].trim());
                nums[1] = nums[0];
                ok = true;
            }
            else {
                nums[0] = Integer.parseInt(inp[0].trim());
                nums[1] = Integer.parseInt(inp[1].trim());
                if (nums[1] >= nums[0]) ok = true;
            }
        }
        return nums;
    }

    private static List<Notebook> readDb(Filter filter) {
        List<Notebook> nbList = new ArrayList<>();
        Set<String> brands = new HashSet<>();
        Set<String> colors = new HashSet<>();
        Set<String> osys = new HashSet<>();
        List<Integer> ram = new ArrayList<>();
        List<Integer> hdd = new ArrayList<>();
        try (FileReader reader = new FileReader("HW_6/db.txt")) {
            Scanner scan = new Scanner(reader);
            while (scan.hasNextLine()) {
                String[] line = scan.nextLine().split(";");
                nbList.add(new Notebook(line[0], line[1], line[2], line[3], line[4], line[5]));
                brands.add(line[1]);
                colors.add(line[4]);
                osys.add(line[5]);
                ram.add(Integer.parseInt(line[2]));
                hdd.add(Integer.parseInt(line[3]));
            }
            scan.close();
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
        filter.putBrands(brands);
        filter.putColors(colors);
        filter.putOsys(osys);
        filter.putRamSize(ram);
        filter.putHddSize(hdd);
        return nbList;
    }
}

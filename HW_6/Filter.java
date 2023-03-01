package HW_6;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Filter {
    private LinkedHashMap<String, Boolean> brand;
    private LinkedHashMap<String, Boolean> color;
    private LinkedHashMap<String, Boolean> oSys;
    private Integer[] ramSize;
    private Integer[] hddSize;

    public Filter() {
        brand = new LinkedHashMap<>();
        color = new LinkedHashMap<>();
        oSys = new LinkedHashMap<>();
        ramSize = new Integer[2];
        hddSize = new Integer[2];
    }

    public void putBrands(Set<String> set) {
        for (String item : set) brand.put(item, true);
    }
    public LinkedHashMap<String, Boolean> getBrands() {
        return brand;
    }
    public void setBrands(int num) {
        int i = 0;
        for (Map.Entry<String, Boolean> item : brand.entrySet()) {
            i++;
            if (i == num) {
                brand.put(item.getKey(), !item.getValue());
            }
        }
    }

    public void putRamSize(List<Integer> nums) {
        int min = nums.get(0), max = min;
        for (Integer num : nums) {
            if (num < min) min = num;
            if (num > max) max = num;
        }
        ramSize[0] = min;
        ramSize[1] = max;
    }
    public Integer[] getRamSize() {
        return ramSize;
    }
    public void setRamSize(int[] nums) {
        ramSize[0] = nums[0];
        ramSize[1] = nums[1];
    }

    public void putHddSize(List<Integer> nums) {
        int min = nums.get(0), max = min;
        for (Integer num : nums) {
            if (num < min) min = num;
            if (num > max) max = num;
        }
        hddSize[0] = min;
        hddSize[1] = max;
    }
    public Integer[] getHddSize() {
        return hddSize;
    }
    public void setHddSize(int[] nums) {
        hddSize[0] = nums[0];
        hddSize[1] = nums[1];
    }

    public void putColors(Set<String> set) {
        for (String item : set) color.put(item, true);
    }
    public LinkedHashMap<String, Boolean> getColors() {
        return color;
    }
    public void setColors(int num) {
        int i = 0;
        for (Map.Entry<String, Boolean> item : color.entrySet()) {
            i++;
            if (i == num) {
                color.put(item.getKey(), !item.getValue());
            }
        }
    }
    
    public void putOsys(Set<String> set) {
        for (String item : set) oSys.put(item, true);
    }
    public LinkedHashMap<String, Boolean> getOsys() {
        return oSys;
    }
    public void setOsys(int num) {
        int i = 0;
        for (Map.Entry<String, Boolean> item : oSys.entrySet()) {
            i++;
            if (i == num) {
                oSys.put(item.getKey(), !item.getValue());
            }
        }
    }

    public void view() {
        System.out.println("\nтекущий фильтр:");
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Boolean> item : brand.entrySet()) {
            sb.append(item.getKey());
            sb.append((item.getValue()) ? " (+)   " : " (-)   ");
        }
        System.out.printf("1. Модель \t\t %s \n", sb.toString());
        System.out.printf("2. объем опер.памяти \t %s -- %s Gb\n", getRamSize()[0].toString(), getRamSize()[1].toString());
        System.out.printf("3. объем hdd \t\t %s -- %s Gb\n", getHddSize()[0].toString(), getHddSize()[1].toString());
        sb.setLength(0);
        for (Map.Entry<String, Boolean> item : color.entrySet()) {
            sb.append(item.getKey());
            sb.append((item.getValue()) ? " (+)   " : " (-)   ");
        }
        System.out.printf("4. цвет корпуса \t %s \n", sb.toString());
        sb.setLength(0);
        for (Map.Entry<String, Boolean> item : oSys.entrySet()) {
            sb.append(item.getKey());
            sb.append((item.getValue()) ? " (+)   " : " (-)   ");
        }
        System.out.printf("5. опер.система \t %s \n", sb.toString());

        return;
    }
}

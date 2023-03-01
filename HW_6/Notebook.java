package HW_6;


public class Notebook {
    Integer id;
    String brand;
    Integer ramSize;
    Integer hddSize;
    String color;
    String oSys;

    public Notebook(String id, String brand, String ramSize, String hddSize, String color, String oSys) {
        this.id = Integer.parseInt(id);
        this.brand = brand;
        this.ramSize = Integer.parseInt(ramSize);
        this.hddSize = Integer.parseInt(hddSize);
        this.color = color;
        this.oSys = oSys;
    }

    @Override
    public String toString() {
        return String.format("id: %d\tмодель: %s\tRAM: %d Gb\tHDD: %d Gb\tcolor: %s\tOS: %s", id, brand, ramSize, hddSize, color, oSys);
    }
}

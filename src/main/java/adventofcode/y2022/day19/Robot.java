package adventofcode.y2022.day19;

public class Robot {

    private String name;
    private int ore;
    private int clay;
    private int obsidian;

    public Robot(String name, int ore, int clay, int obsidian) {
        this.name = name;
        this.ore = ore;
        this.clay = clay;
        this.obsidian = obsidian;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOre() {
        return ore;
    }

    public void setOre(int ore) {
        this.ore = ore;
    }

    public int getClay() {
        return clay;
    }

    public void setClay(int clay) {
        this.clay = clay;
    }

    public int getObsidian() {
        return obsidian;
    }

    public void setObsidian(int obsidian) {
        this.obsidian = obsidian;
    }
}

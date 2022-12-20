package adventofcode.y2022.day19;

public class Blueprint {

    private Robot ore;
    private Robot clay;
    private Robot obsidian;
    private Robot geode;

    public Blueprint(Robot ore, Robot clay, Robot obsidian, Robot geode) {
        this.ore = ore;
        this.clay = clay;
        this.obsidian = obsidian;
        this.geode = geode;
    }

    public Robot getOre() {
        return ore;
    }

    public void setOre(Robot ore) {
        this.ore = ore;
    }

    public Robot getClay() {
        return clay;
    }

    public void setClay(Robot clay) {
        this.clay = clay;
    }

    public Robot getObsidian() {
        return obsidian;
    }

    public void setObsidian(Robot obsidian) {
        this.obsidian = obsidian;
    }

    public Robot getGeode() {
        return geode;
    }

    public void setGeode(Robot geode) {
        this.geode = geode;
    }
}

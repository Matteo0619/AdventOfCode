package adventofcode.y2024.day9;

public class MemoryFile {

    private String value;

    private Long ocurrency;

    public MemoryFile(String value, Long ocurrency) {
        this.value = value;
        this.ocurrency = ocurrency;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getOcurrency() {
        return ocurrency;
    }

    public void setOcurrency(Long ocurrency) {
        this.ocurrency = ocurrency;
    }


}

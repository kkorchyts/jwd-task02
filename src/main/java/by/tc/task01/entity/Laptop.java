package by.tc.task01.entity;

public class Laptop extends Appliance{
    private Float batteryCapacity;
    private String operationSystem;
    private Integer memoryRom;
    private Integer systemMemory;
    private String cpu;
    private Float displayInchs;

    public Float getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(Float batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String getOperationSystem() {
        return operationSystem;
    }

    public void setOperationSystem(String operationSystem) {
        this.operationSystem = operationSystem;
    }

    public Integer getMemoryRom() {
        return memoryRom;
    }

    public void setMemoryRom(Integer memoryRom) {
        this.memoryRom = memoryRom;
    }

    public Integer getSystemMemory() {
        return systemMemory;
    }

    public void setSystemMemory(Integer systemMemory) {
        this.systemMemory = systemMemory;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public Float getDisplayInchs() {
        return displayInchs;
    }

    public void setDisplayInchs(Float displayInchs) {
        this.displayInchs = displayInchs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Laptop laptop = (Laptop) o;

        if (batteryCapacity != null ? !batteryCapacity.equals(laptop.batteryCapacity) : laptop.batteryCapacity != null)
            return false;
        if (operationSystem != null ? !operationSystem.equals(laptop.operationSystem) : laptop.operationSystem != null)
            return false;
        if (memoryRom != null ? !memoryRom.equals(laptop.memoryRom) : laptop.memoryRom != null) return false;
        if (systemMemory != null ? !systemMemory.equals(laptop.systemMemory) : laptop.systemMemory != null)
            return false;
        if (cpu != null ? !cpu.equals(laptop.cpu) : laptop.cpu != null) return false;
        return displayInchs != null ? displayInchs.equals(laptop.displayInchs) : laptop.displayInchs == null;
    }

    @Override
    public int hashCode() {
        int result = batteryCapacity != null ? batteryCapacity.hashCode() : 0;
        result = 31 * result + (operationSystem != null ? operationSystem.hashCode() : 0);
        result = 31 * result + (memoryRom != null ? memoryRom.hashCode() : 0);
        result = 31 * result + (systemMemory != null ? systemMemory.hashCode() : 0);
        result = 31 * result + (cpu != null ? cpu.hashCode() : 0);
        result = 31 * result + (displayInchs != null ? displayInchs.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "batteryCapacity=" + batteryCapacity +
                ", opearationSystems='" + operationSystem + '\'' +
                ", memoryRom=" + memoryRom +
                ", systemMemory=" + systemMemory +
                ", cpu='" + cpu + '\'' +
                ", displayInchs=" + displayInchs +
                '}';
    }
}

package com.kkorchyts.jwd.task02.entity.impl;

import com.kkorchyts.jwd.task02.entity.Appliance;

public class TabletPC implements Appliance {
    private Integer batteryCapacity;
    private String displayInches;
    private Integer memoryRom;
    private Integer flashMemoryCapacity;
    private String color;

    public Integer getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(Integer batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String getDisplayInches() {
        return displayInches;
    }

    public void setDisplayInches(String displayInches) {
        this.displayInches = displayInches;
    }

    public Integer getMemoryRom() {
        return memoryRom;
    }

    public void setMemoryRom(Integer memoryRom) {
        this.memoryRom = memoryRom;
    }

    public Integer getFlashMemoryCapacity() {
        return flashMemoryCapacity;
    }

    public void setFlashMemoryCapacity(Integer flashMemoryCapacity) {
        this.flashMemoryCapacity = flashMemoryCapacity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TabletPC tabletPC = (TabletPC) o;

        if (batteryCapacity != null ? !batteryCapacity.equals(tabletPC.batteryCapacity) : tabletPC.batteryCapacity != null)
            return false;
        if (displayInches != null ? !displayInches.equals(tabletPC.displayInches) : tabletPC.displayInches != null)
            return false;
        if (memoryRom != null ? !memoryRom.equals(tabletPC.memoryRom) : tabletPC.memoryRom != null) return false;
        if (flashMemoryCapacity != null ? !flashMemoryCapacity.equals(tabletPC.flashMemoryCapacity) : tabletPC.flashMemoryCapacity != null)
            return false;
        return color != null ? color.equals(tabletPC.color) : tabletPC.color == null;
    }

    @Override
    public int hashCode() {
        int result = batteryCapacity != null ? batteryCapacity.hashCode() : 0;
        result = 31 * result + (displayInches != null ? displayInches.hashCode() : 0);
        result = 31 * result + (memoryRom != null ? memoryRom.hashCode() : 0);
        result = 31 * result + (flashMemoryCapacity != null ? flashMemoryCapacity.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TabletPC{" +
                "batteryCapacity=" + batteryCapacity +
                ", displayInches='" + displayInches + '\'' +
                ", memoryRom=" + memoryRom +
                ", flashMemoryCapacity=" + flashMemoryCapacity +
                ", color='" + color + '\'' +
                '}';
    }
}

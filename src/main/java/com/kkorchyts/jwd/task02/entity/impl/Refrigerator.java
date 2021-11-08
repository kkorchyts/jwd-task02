package com.kkorchyts.jwd.task02.entity.impl;

import com.kkorchyts.jwd.task02.entity.Appliance;

public class Refrigerator implements Appliance {
    private Integer powerConsumption;
    private Integer weight;
    private Integer freezerCapacity;
    private Float overallCapacity;
    private Float height;
    private Float width;

    public Integer getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(Integer powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getFreezerCapacity() {
        return freezerCapacity;
    }

    public void setFreezerCapacity(Integer freezerCapacity) {
        this.freezerCapacity = freezerCapacity;
    }

    public Float getOverallCapacity() {
        return overallCapacity;
    }

    public void setOverallCapacity(Float overallCapacity) {
        this.overallCapacity = overallCapacity;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getWidth() {
        return width;
    }

    public void setWidth(Float width) {
        this.width = width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Refrigerator that = (Refrigerator) o;

        if (powerConsumption != null ? !powerConsumption.equals(that.powerConsumption) : that.powerConsumption != null)
            return false;
        if (weight != null ? !weight.equals(that.weight) : that.weight != null) return false;
        if (freezerCapacity != null ? !freezerCapacity.equals(that.freezerCapacity) : that.freezerCapacity != null)
            return false;
        if (overallCapacity != null ? !overallCapacity.equals(that.overallCapacity) : that.overallCapacity != null)
            return false;
        if (height != null ? !height.equals(that.height) : that.height != null) return false;
        return width != null ? width.equals(that.width) : that.width == null;
    }

    @Override
    public int hashCode() {
        int result = powerConsumption != null ? powerConsumption.hashCode() : 0;
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (freezerCapacity != null ? freezerCapacity.hashCode() : 0);
        result = 31 * result + (overallCapacity != null ? overallCapacity.hashCode() : 0);
        result = 31 * result + (height != null ? height.hashCode() : 0);
        result = 31 * result + (width != null ? width.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Refrigerator{" +
                "powerConsumption=" + powerConsumption +
                ", weight=" + weight +
                ", freezerCapacity=" + freezerCapacity +
                ", overallCapacity=" + overallCapacity +
                ", height=" + height +
                ", width=" + width +
                '}';
    }
}

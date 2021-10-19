package by.tc.task01.entity;

public class Oven extends Appliance{
    private Integer powerConsumption;
    private Integer weight;
    private Integer capacity;
    private Float depth;
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

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Float getDepth() {
        return depth;
    }

    public void setDepth(Float depth) {
        this.depth = depth;
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

        Oven oven = (Oven) o;

        if (powerConsumption != null ? !powerConsumption.equals(oven.powerConsumption) : oven.powerConsumption != null)
            return false;
        if (weight != null ? !weight.equals(oven.weight) : oven.weight != null) return false;
        if (capacity != null ? !capacity.equals(oven.capacity) : oven.capacity != null) return false;
        if (depth != null ? !depth.equals(oven.depth) : oven.depth != null) return false;
        if (height != null ? !height.equals(oven.height) : oven.height != null) return false;
        return width != null ? width.equals(oven.width) : oven.width == null;
    }

    @Override
    public int hashCode() {
        int result = powerConsumption != null ? powerConsumption.hashCode() : 0;
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (capacity != null ? capacity.hashCode() : 0);
        result = 31 * result + (depth != null ? depth.hashCode() : 0);
        result = 31 * result + (height != null ? height.hashCode() : 0);
        result = 31 * result + (width != null ? width.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Oven{" +
                "powerConsumption=" + powerConsumption +
                ", weight=" + weight +
                ", capacity=" + capacity +
                ", depth=" + depth +
                ", height=" + height +
                ", width=" + width +
                '}';
    }
}

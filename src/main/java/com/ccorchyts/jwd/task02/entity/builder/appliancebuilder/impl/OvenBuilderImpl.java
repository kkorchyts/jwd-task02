package com.ccorchyts.jwd.task02.entity.builder.appliancebuilder.impl;

import com.ccorchyts.jwd.task02.entity.builder.appliancebuilder.ApplianceBuilder;
import com.ccorchyts.jwd.task02.entity.builder.property.ApplianceFields;
import com.ccorchyts.jwd.task02.entity.impl.Oven;
import com.ccorchyts.jwd.task02.util.numberparsing.ValueParser;

import java.util.Map;

public final class OvenBuilderImpl implements ApplianceBuilder<Oven> {
    private Integer powerConsumption;
    private Integer weight;
    private Integer capacity;
    private Float depth;
    private Float height;
    private Float width;

    public OvenBuilderImpl() {
    }

    public static OvenBuilderImpl builder() {
        return new OvenBuilderImpl();
    }

    public OvenBuilderImpl powerConsumption(Integer powerConsumption) {
        this.powerConsumption = powerConsumption;
        return this;
    }

    public OvenBuilderImpl weight(Integer weight) {
        this.weight = weight;
        return this;

    }

    public OvenBuilderImpl capacity(Integer capacity) {
        this.capacity = capacity;
        return this;
    }

    public OvenBuilderImpl depth(Float depth) {
        this.depth = depth;
        return this;
    }

    public OvenBuilderImpl height(Float height) {
        this.height = height;
        return this;
    }

    public OvenBuilderImpl width(Float width) {
        this.width = width;
        return this;
    }

    @Override
    public OvenBuilderImpl properties(Map<String, Object> properties) {
        for (Map.Entry<String, Object> entry : properties.entrySet()) {
            switch (ApplianceFields.Oven.valueOf(entry.getKey())) {
                case POWER_CONSUMPTION:
                    powerConsumption = ValueParser.parseInteger(String.valueOf(entry.getValue()));
                    break;
                case WEIGHT:
                    weight = ValueParser.parseInteger(String.valueOf(entry.getValue()));
                    break;
                case CAPACITY:
                    capacity = ValueParser.parseInteger(String.valueOf(entry.getValue()));
                    break;
                case DEPTH:
                    depth = ValueParser.parseFloat(String.valueOf(entry.getValue()));
                    break;
                case HEIGHT:
                    height = ValueParser.parseFloat(String.valueOf(entry.getValue()));
                    break;
                case WIDTH:
                    width = ValueParser.parseFloat(String.valueOf(entry.getValue()));
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + ApplianceFields.Oven.valueOf(entry.getKey()));
            }
        }
        return this;
    }

    @Override
    public Oven build() {
        Oven oven = new Oven();
        oven.setPowerConsumption(powerConsumption);
        oven.setWeight(weight);
        oven.setCapacity(capacity);
        oven.setDepth(depth);
        oven.setHeight(height);
        oven.setWidth(width);
        return oven;
    }
}

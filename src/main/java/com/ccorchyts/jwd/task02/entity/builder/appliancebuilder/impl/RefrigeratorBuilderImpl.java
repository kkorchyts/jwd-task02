package com.ccorchyts.jwd.task02.entity.builder.appliancebuilder.impl;

import com.ccorchyts.jwd.task02.entity.Refrigerator;
import com.ccorchyts.jwd.task02.entity.builder.appliancebuilder.ApplianceBuilder;
import com.ccorchyts.jwd.task02.entity.factory.ValueParser;

import java.util.Map;

public final class RefrigeratorBuilderImpl implements ApplianceBuilder<Refrigerator> {
    private Integer powerConsumption;
    private Integer weight;
    private Integer freezerCapacity;
    private Float overallCapacity;
    private Float height;
    private Float width;

    public RefrigeratorBuilderImpl() {
    }

    public static RefrigeratorBuilderImpl builder() {
        return new RefrigeratorBuilderImpl();
    }

    public RefrigeratorBuilderImpl powerConsumption(Integer powerConsumption) {
        this.powerConsumption = powerConsumption;
        return this;
    }

    public RefrigeratorBuilderImpl weight(Integer weight) {
        this.weight = weight;
        return this;
    }

    public RefrigeratorBuilderImpl freezerCapacity(Integer freezerCapacity) {
        this.freezerCapacity = freezerCapacity;
        return this;
    }

    public RefrigeratorBuilderImpl overallCapacity(Float overallCapacity) {
        this.overallCapacity = overallCapacity;
        return this;
    }

    public RefrigeratorBuilderImpl height(Float height) {
        this.height = height;
        return this;
    }

    public RefrigeratorBuilderImpl width(Float width) {
        this.width = width;
        return this;
    }

    @Override
    public RefrigeratorBuilderImpl properties(Map<String, Object> properties) {
        for (Map.Entry<String, Object> entry : properties.entrySet()) {
            switch (entry.getKey()) {
                case "POWER_CONSUMPTION":
                    powerConsumption = ValueParser.parseInteger(String.valueOf(entry.getValue()));
                    break;
                case "WEIGHT":
                    weight = ValueParser.parseInteger(String.valueOf(entry.getValue()));
                    break;
                case "FREEZER_CAPACITY":
                    freezerCapacity = ValueParser.parseInteger(String.valueOf(entry.getValue()));
                    break;
                case "OVERALL_CAPACITY":
                    overallCapacity = ValueParser.parseFloat(String.valueOf(entry.getValue()));
                    break;
                case "HEIGHT":
                    height = ValueParser.parseFloat(String.valueOf(entry.getValue()));
                    break;
                case "WIDTH":
                    width = ValueParser.parseFloat(String.valueOf(entry.getValue()));
                    break;
            }
        }
        return this;
    }

    @Override
    public Refrigerator build() {
        Refrigerator refrigerator = new Refrigerator();
        refrigerator.setPowerConsumption(powerConsumption);
        refrigerator.setWeight(weight);
        refrigerator.setFreezerCapacity(freezerCapacity);
        refrigerator.setOverallCapacity(overallCapacity);
        refrigerator.setHeight(height);
        refrigerator.setWidth(width);
        return refrigerator;
    }
}

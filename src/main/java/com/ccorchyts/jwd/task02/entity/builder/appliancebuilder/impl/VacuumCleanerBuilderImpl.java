package com.ccorchyts.jwd.task02.entity.builder.appliancebuilder.impl;

import com.ccorchyts.jwd.task02.entity.VacuumCleaner;
import com.ccorchyts.jwd.task02.entity.builder.appliancebuilder.ApplianceBuilder;
import com.ccorchyts.jwd.task02.entity.factory.ValueParser;

import java.util.Map;

public final class VacuumCleanerBuilderImpl implements ApplianceBuilder<VacuumCleaner> {
    private Integer powerConsumption;
    private String filterType;
    private String bagType;
    private String wandType;
    private Integer motorSpeedRegulation;
    private Integer cleaningWidth;

    public VacuumCleanerBuilderImpl() {
    }

    public static VacuumCleanerBuilderImpl builder() {
        return new VacuumCleanerBuilderImpl();
    }

    private VacuumCleanerBuilderImpl powerConsumption(Integer powerConsumption) {
        this.powerConsumption = powerConsumption;
        return this;
    }

    private VacuumCleanerBuilderImpl filterType(String filterType) {
        this.filterType = filterType;
        return this;
    }

    private VacuumCleanerBuilderImpl bagType(String bagType) {
        this.bagType = bagType;
        return this;
    }

    private VacuumCleanerBuilderImpl wandType(String wandType) {
        this.wandType = wandType;
        return this;
    }

    private VacuumCleanerBuilderImpl motorSpeedRegulation(Integer motorSpeedRegulation) {
        this.motorSpeedRegulation = motorSpeedRegulation;
        return this;
    }

    private VacuumCleanerBuilderImpl cleaningWidth(Integer cleaningWidth) {
        this.cleaningWidth = cleaningWidth;
        return this;
    }


    @Override
    public VacuumCleanerBuilderImpl properties(Map<String, Object> properties) {
        for (Map.Entry<String, Object> entry : properties.entrySet()) {
            switch (entry.getKey()) {
                case "POWER_CONSUMPTION":
                    powerConsumption = ValueParser.parseInteger(String.valueOf(entry.getValue()));
                    break;
                case "FILTER_TYPE":
                    filterType = String.valueOf(entry.getValue());
                    break;
                case "BAG_TYPE":
                    bagType = String.valueOf(entry.getValue());
                    break;
                case "WAND_TYPE":
                    wandType = String.valueOf(entry.getValue());
                    break;
                case "MOTOR_SPEED_REGULATION":
                    motorSpeedRegulation = ValueParser.parseInteger(String.valueOf(entry.getValue()));
                    break;
                case "CLEANING_WIDTH":
                    cleaningWidth = ValueParser.parseInteger(String.valueOf(entry.getValue()));
                    break;
            }
        }
        return this;
    }

    @Override
    public VacuumCleaner build() {
        VacuumCleaner vacuumCleaner = new VacuumCleaner();
        vacuumCleaner.setPowerConsumption(powerConsumption);
        vacuumCleaner.setFilterType(filterType);
        vacuumCleaner.setBagType(bagType);
        vacuumCleaner.setWandType(wandType);
        vacuumCleaner.setMotorSpeedRegulation(motorSpeedRegulation);
        vacuumCleaner.setCleaningWidth(cleaningWidth);
        return vacuumCleaner;
    }
}

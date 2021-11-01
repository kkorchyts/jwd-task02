package com.ccorchyts.jwd.task02.entity.builder.appliancebuilder.impl;

import com.ccorchyts.jwd.task02.entity.Laptop;
import com.ccorchyts.jwd.task02.entity.builder.appliancebuilder.ApplianceBuilder;
import com.ccorchyts.jwd.task02.entity.factory.ValueParser;

import java.util.Map;

public final class LaptopBuilderImpl implements ApplianceBuilder<Laptop> {
    private Float batteryCapacity;
    private String operationSystem;
    private Integer memoryRom;
    private Integer systemMemory;
    private String cpu;
    private Float displayInchs;

    public LaptopBuilderImpl() {
    }

    public static LaptopBuilderImpl builder() {
        return new LaptopBuilderImpl();
    }

    public LaptopBuilderImpl batteryCapacity(Float batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
        return this;
    }

    public LaptopBuilderImpl operationSystem(String operationSystem) {
        this.operationSystem = operationSystem;
        return this;
    }

    public LaptopBuilderImpl memoryRom(Integer memoryRom) {
        this.memoryRom = memoryRom;
        return this;
    }

    public LaptopBuilderImpl systemMemory(Integer systemMemory) {
        this.systemMemory = systemMemory;
        return this;
    }

    public LaptopBuilderImpl cpu(String cpu) {
        this.cpu = cpu;
        return this;
    }

    public LaptopBuilderImpl displayInchs(Float displayInchs) {
        this.displayInchs = displayInchs;
        return this;
    }

    @Override
    public LaptopBuilderImpl properties(Map<String, Object> properties) {
        for (Map.Entry<String, Object> entry : properties.entrySet()) {
            switch (entry.getKey()) {
                case "BATTERY_CAPACITY":
                    batteryCapacity = ValueParser.parseFloat(String.valueOf(entry.getValue()));
                    break;
                case "OS":
                    operationSystem = String.valueOf(entry.getValue());
                    break;
                case "MEMORY_ROM":
                    memoryRom = ValueParser.parseInteger(String.valueOf(entry.getValue()));
                    break;
                case "SYSTEM_MEMORY":
                    systemMemory = ValueParser.parseInteger(String.valueOf(entry.getValue()));
                    break;
                case "CPU":
                    cpu = String.valueOf(entry.getValue());
                    break;
                case "DISPLAY_INCHS":
                    displayInchs = ValueParser.parseFloat(String.valueOf(entry.getValue()));
                    break;
            }
        }
        return this;
    }

    @Override
    public Laptop build() {
        Laptop laptop = new Laptop();
        laptop.setBatteryCapacity(this.batteryCapacity);
        laptop.setOperationSystem(operationSystem);
        laptop.setMemoryRom(memoryRom);
        laptop.setSystemMemory(systemMemory);
        laptop.setCpu(cpu);
        laptop.setDisplayInchs(displayInchs);
        return laptop;
    }
}

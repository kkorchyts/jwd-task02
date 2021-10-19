package by.tc.task01.entity.factory;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.Refrigerator;
import by.tc.task01.entity.Speakers;
import by.tc.task01.entity.TabletPC;
import by.tc.task01.entity.VacuumCleaner;

import java.util.Arrays;

import static by.tc.task01.entity.factory.TxtParser.parseFloat;
import static by.tc.task01.entity.factory.TxtParser.parseInteger;

public class EntityFactory {
    private static final EntityFactory instance = new EntityFactory();

    private EntityFactory() {
    }

    public Appliance createAppliance(String row) {
        String[] payLoadParts = row.split(":");
        if (payLoadParts.length != 2) {
            return null;
        }
        Appliance appliance;

        switch (payLoadParts[0].trim().toUpperCase()) {
            case "OVEN":
                appliance = createOven(payLoadParts[1]);
                break;
            case "LAPTOP":
                appliance = createLaptop(payLoadParts[1]);
                break;
            case "REFRIGERATOR":
                appliance = createRefrigerator(payLoadParts[1]);
                break;
            case "VACUUMCLEANER":
                appliance = createVacuumCleaner(payLoadParts[1]);
                break;
            case "TABLETPC":
                appliance = createTabletPC(payLoadParts[1]);
                break;
            case "SPEAKERS":
                appliance = createSpeakers(payLoadParts[1]);
                break;
            default:
                appliance = null;
        }
        return appliance;
    }

    private Oven createOven(String payLoad) {
        //POWER_CONSUMPTION=1000, WEIGHT=10, CAPACITY=32, DEPTH=60, HEIGHT=45.5, WIDTH=59.5
        Oven oven = new Oven();
        Arrays.stream(payLoad.split(",")).forEach(valueString -> {
            String[] pair = valueString.split("=");
            switch (pair[0].trim().toUpperCase()) {
                case "POWER_CONSUMPTION":
                    oven.setPowerConsumption(parseInteger(pair[1].trim()));
                    break;
                case "WEIGHT":
                    oven.setWeight(parseInteger(pair[1].trim()));
                    break;
                case "CAPACITY":
                    oven.setCapacity(parseInteger(pair[1].trim()));
                    break;
                case "DEPTH":
                    oven.setDepth(parseFloat(pair[1].trim()));
                    break;
                case "HEIGHT":
                        oven.setHeight(parseFloat(pair[1].trim()));
                    break;
                case "WIDTH":
                    oven.setWidth(parseFloat(pair[1].trim()));
                    break;
            }
        });
        return oven;
    }

    private Laptop createLaptop(String payLoad) {
        // BATTERY_CAPACITY=1, OS=Windows, MEMORY_ROM=4000, SYSTEM_MEMORY=1000, CPU=1.2, DISPLAY_INCHS=18
        Laptop laptop = new Laptop();
        Arrays.stream(payLoad.split(",")).forEach(valueString -> {
            String[] pair = valueString.split("=");
            switch (pair[0].trim().toUpperCase()) {
                case "BATTERY_CAPACITY":
                    laptop.setBatteryCapacity(parseFloat(pair[1].trim()));
                    break;
                case "OS":
                    laptop.setOperationSystem(pair[1].trim());
                    break;
                case "MEMORY_ROM":
                    laptop.setMemoryRom(parseInteger(pair[1].trim()));
                    break;
                case "SYSTEM_MEMORY":
                    laptop.setSystemMemory(parseInteger(pair[1].trim()));
                    break;
                case "CPU":
                    laptop.setCpu(pair[1].trim());
                    break;
                case "DISPLAY_INCHS":
                    laptop.setDisplayInchs(parseFloat(pair[1].trim()));
                    break;
            }
        });
        return laptop;
    }

    private Refrigerator createRefrigerator(String payLoad) {
        // POWER_CONSUMPTION=100, WEIGHT=20, FREEZER_CAPACITY=10, OVERALL_CAPACITY=300, HEIGHT=200, WIDTH=70
        Refrigerator refrigerator = new Refrigerator();
        Arrays.stream(payLoad.split(",")).forEach(valueString -> {
            String[] pair = valueString.split("=");
            switch (pair[0].trim().toUpperCase()) {
                case "POWER_CONSUMPTION":
                    refrigerator.setPowerConsumption(parseInteger(pair[1].trim()));
                    break;
                case "WEIGHT":
                    refrigerator.setWeight(parseInteger(pair[1].trim()));
                    break;
                case "FREEZER_CAPACITY":
                    refrigerator.setFreezerCapacity(parseInteger(pair[1].trim()));
                    break;
                case "OVERALL_CAPACITY":
                    refrigerator.setOverallCapacity(parseFloat(pair[1].trim()));
                    break;
                case "HEIGHT":
                    refrigerator.setHeight(parseFloat(pair[1].trim()));
                    break;
                case "WIDTH":
                    refrigerator.setWidth(parseFloat(pair[1].trim()));
                    break;
            }
        });
        return refrigerator;
    }

    private VacuumCleaner createVacuumCleaner(String payLoad) {
        // POWER_CONSUMPTION=100, FILTER_TYPE=A, BAG_TYPE=A2, WAND_TYPE=all-in-one, MOTOR_SPEED_REGULATION=3000, CLEANING_WIDTH=20
        VacuumCleaner vacuumCleaner = new VacuumCleaner();
        Arrays.stream(payLoad.split(",")).forEach(valueString -> {
            String[] pair = valueString.split("=");
            switch (pair[0].trim().toUpperCase()) {
                case "POWER_CONSUMPTION":
                    vacuumCleaner.setPowerConsumption(parseInteger(pair[1].trim()));
                    break;
                case "FILTER_TYPE":
                    vacuumCleaner.setFilterType(pair[1].trim());
                    break;
                case "BAG_TYPE":
                    vacuumCleaner.setBagType(pair[1].trim());
                    break;
                case "WAND_TYPE":
                    vacuumCleaner.setWandType(pair[1].trim());
                    break;
                case "MOTOR_SPEED_REGULATION":
                    vacuumCleaner.setMotorSpeedRegulation(parseInteger(pair[1].trim()));
                    break;
                case "CLEANING_WIDTH":
                    vacuumCleaner.setCleaningWidth(parseInteger(pair[1].trim()));
                    break;
            }
        });
        return vacuumCleaner;
    }

    private TabletPC createTabletPC(String payLoad) {
        // BATTERY_CAPACITY=3, DISPLAY_INCHES=14, MEMORY_ROM=8000, FLASH_MEMORY_CAPACITY=2, COLOR=blue
        TabletPC tabletPC = new TabletPC();
        Arrays.stream(payLoad.split(",")).forEach(valueString -> {
            String[] pair = valueString.split("=");
            switch (pair[0].trim().toUpperCase()) {
                case "BATTERY_CAPACITY":
                    tabletPC.setBatteryCapacity(parseInteger(pair[1].trim()));
                    break;
                case "DISPLAY_INCHES":
                    tabletPC.setDisplayInches(pair[1].trim());
                    break;
                case "MEMORY_ROM":
                    tabletPC.setMemoryRom(parseInteger(pair[1].trim()));
                    break;
                case "FLASH_MEMORY_CAPACITY":
                    tabletPC.setFlashMemoryCapacity(parseInteger(pair[1].trim()));
                    break;
                case "COLOR":
                    tabletPC.setColor(pair[1].trim());
                    break;
            }
        });
        return tabletPC;
    }

    private Speakers createSpeakers(String payLoad) {
        // POWER_CONSUMPTION=15, NUMBER_OF_SPEAKERS=2, FREQUENCY_RANGE=2-4, CORD_LENGTH=2
        Speakers speakers = new Speakers();
        Arrays.stream(payLoad.split(",")).forEach(valueString -> {
            String[] pair = valueString.split("=");
            switch (pair[0].trim().toUpperCase()) {
                case "POWER_CONSUMPTION":
                    speakers.setPowerConsumption(parseInteger(pair[1].trim()));
                    break;
                case "NUMBER_OF_SPEAKERS":
                    speakers.setNumberOfSpeakers(parseInteger(pair[1].trim()));
                    break;
                case "FREQUENCY_RANGE":
                    speakers.setFrequencyRange(pair[1].trim());
                    break;
                case "CORD_LENGTH":
                    speakers.setCordLength(parseFloat(pair[1].trim()));
                    break;
            }
        });
        return speakers;
    }

    public static EntityFactory getInstance() {
        return instance;
    }
}

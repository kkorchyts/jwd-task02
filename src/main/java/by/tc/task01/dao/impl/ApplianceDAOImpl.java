package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.Refrigerator;
import by.tc.task01.entity.Speakers;
import by.tc.task01.entity.TabletPC;
import by.tc.task01.entity.VacuumCleaner;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.factory.EntityFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static by.tc.task01.entity.factory.ValueParser.parseFloat;
import static by.tc.task01.entity.factory.ValueParser.parseInteger;

public class ApplianceDAOImpl implements ApplianceDAO {

    @Override
    public Appliance find(Criteria criteria) {
        // you may add your own code here
        List<Appliance> appliances;

        try {
            appliances = readAppliancesFromFile("appliances_db.txt");
        }catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

        for (Appliance appliance : appliances) {
            Boolean isPassed = false;
            if (appliance != null) {
                switch (appliance.getClass().getSimpleName()) {
                    case "Oven":
                        isPassed = checkOven((Oven) appliance, criteria);
                        break;
                    case "Laptop":
                        break;
                    case "Refrigerator":
                        break;
                    case "VacuumCleaner":
                        break;
                    case "TabletPC":
                        break;
                    case "Speakers":
                        break;
                }
            }
            if (isPassed) {
                System.out.println(appliance);
            }
        }
        return null;
    }

    // you may add your own code here
    private List<Appliance> readAppliancesFromFile(String fileName) throws IOException {

        File file = new File(getClass().getClassLoader().getResource(fileName).getFile());

        if (file == null) {
            throw new RuntimeException("File not found!");
        }

        List<Appliance> appliances = new ArrayList<>();

        try (FileReader reader = new FileReader(file);
             BufferedReader br = new BufferedReader(reader)) {
            Appliance appliance;
            String line;
            EntityFactory entityFactory = EntityFactory.getInstance();
            while ((line = br.readLine()) != null) {
                appliances.add(entityFactory.createAppliance(line));
            }
        }
        return appliances;
    }

    private Boolean checkOven(Oven oven, Criteria criteria) {
        boolean result = true;
        for (String searchCriteria: criteria.searchCriteries()) {
            switch (searchCriteria) {
                case "POWER_CONSUMPTION":
                    result = result && oven.getPowerConsumption().equals(parseInteger(String.valueOf(criteria.getValue(searchCriteria))));
                    break;
                case "WEIGHT":
                    result = result && oven.getWeight().equals(parseInteger(String.valueOf(criteria.getValue(searchCriteria))));
                    break;
                case "CAPACITY":
                    result = result && oven.getCapacity().equals(parseInteger(String.valueOf(criteria.getValue(searchCriteria))));
                    break;
                case "DEPTH":
                    result = result && oven.getDepth().equals(parseFloat(String.valueOf(criteria.getValue(searchCriteria))));
                    break;
                case "HEIGHT":
                    result = result && oven.getHeight().equals(parseFloat(String.valueOf(criteria.getValue(searchCriteria))));
                    break;
                case "WIDTH":
                    result = result && oven.getWidth().equals(parseFloat(String.valueOf(criteria.getValue(searchCriteria))));
                    ;
                    break;
            }
        }
        return result;
    }

    private Boolean checkLaptop(Laptop laptop, Criteria criteria) {
        boolean result = true;
        for (String searchCriteria: criteria.searchCriteries()) {
            switch (searchCriteria) {
                //BATTERY_CAPACITY=1, OS=Windows, MEMORY_ROM=4000, SYSTEM_MEMORY=1000, CPU=1.2, DISPLAY_INCHS=18
                case "BATTERY_CAPACITY":
                    result = result && laptop.getBatteryCapacity().equals(parseFloat(String.valueOf(criteria.getValue(searchCriteria))));
                    break;
                case "OS":
                    result = result && laptop.getOperationSystem().equals(String.valueOf(criteria.getValue(searchCriteria)));
                    break;
                case "SYSTEM_MEMORY":
                    result = result && laptop.getSystemMemory().equals(parseInteger(String.valueOf(criteria.getValue(searchCriteria))));
                    break;
                case "CPU":
                    result = result && laptop.getCpu().equals(String.valueOf(criteria.getValue(searchCriteria)));
                    break;
                case "DISPLAY_INCHS":
                    result = result && laptop.getDisplayInchs().equals(parseFloat(String.valueOf(criteria.getValue(searchCriteria))));
                    break;
            }
        }
        return result;
    }

    private Boolean checkRefrigerator(Refrigerator refrigerator, Criteria criteria) {
        // POWER_CONSUMPTION=100, WEIGHT=20, FREEZER_CAPACITY=10, OVERALL_CAPACITY=300, HEIGHT=200, WIDTH=70
        boolean result = true;
        for (String searchCriteria: criteria.searchCriteries()) {
            switch (searchCriteria) {
                case "POWER_CONSUMPTION":
                    result = result && refrigerator.getPowerConsumption().equals(parseInteger(String.valueOf(criteria.getValue(searchCriteria))));
                    break;
                case "WEIGHT":
                    result = result && refrigerator.getWeight().equals(parseInteger(String.valueOf(criteria.getValue(searchCriteria))));
                    break;
                case "FREEZER_CAPACITY":
                    result = result && refrigerator.getFreezerCapacity().equals(parseInteger(String.valueOf(criteria.getValue(searchCriteria))));
                    break;
                case "OVERALL_CAPACITY":
                    result = result && refrigerator.getOverallCapacity().equals(parseFloat(String.valueOf(criteria.getValue(searchCriteria))));
                    break;
                case "HEIGHT":
                    result = result && refrigerator.getHeight().equals(parseFloat(String.valueOf(criteria.getValue(searchCriteria))));
                    break;
                case "WIDTH":
                    result = result && refrigerator.getWidth().equals(parseFloat(String.valueOf(criteria.getValue(searchCriteria))));
                    ;
                    break;
            }
        }
        return result;
    }

    private Boolean checkVacuumCleaner(VacuumCleaner vacuumCleaner, Criteria criteria) {
        // POWER_CONSUMPTION=100, FILTER_TYPE=A, BAG_TYPE=A2, WAND_TYPE=all-in-one, MOTOR_SPEED_REGULATION=3000, CLEANING_WIDTH=20
        boolean result = true;
        for (String searchCriteria: criteria.searchCriteries()) {
            switch (searchCriteria) {
                case "POWER_CONSUMPTION":
                    result = result && vacuumCleaner.getPowerConsumption().equals(parseInteger(String.valueOf(criteria.getValue(searchCriteria))));
                    break;
                case "FILTER_TYPE":
                    result = result && vacuumCleaner.getFilterType().equals(String.valueOf(criteria.getValue(searchCriteria)));
                    break;
                case "BAG_TYPE":
                    result = result && vacuumCleaner.getBagType().equals(String.valueOf(criteria.getValue(searchCriteria)));
                    break;
                case "WAND_TYPE":
                    result = result && vacuumCleaner.getWandType().equals(String.valueOf(criteria.getValue(searchCriteria)));
                    break;
                case "MOTOR_SPEED_REGULATION":
                    result = result && vacuumCleaner.getMotorSpeedRegulation().equals(parseInteger(String.valueOf(criteria.getValue(searchCriteria))));
                    break;
                case "CLEANING_WIDTH":
                    result = result && vacuumCleaner.getCleaningWidth().equals(parseInteger(String.valueOf(criteria.getValue(searchCriteria))));
                    break;
            }
        }
        return result;
    }

    private Boolean checkTabletPC(TabletPC tabletPC, Criteria criteria) {
        // BATTERY_CAPACITY=3, DISPLAY_INCHES=14, MEMORY_ROM=8000, FLASH_MEMORY_CAPACITY=2, COLOR=blue
        boolean result = true;
        for (String searchCriteria: criteria.searchCriteries()) {
            switch (searchCriteria) {
                case "BATTERY_CAPACITY":
                    result = result && tabletPC.getBatteryCapacity().equals(parseInteger(String.valueOf(criteria.getValue(searchCriteria))));
                    break;
                case "DISPLAY_INCHES":
                    result = result && tabletPC.getDisplayInches().equals(String.valueOf(criteria.getValue(searchCriteria)));
                    break;
                case "MEMORY_ROM":
                    result = result && tabletPC.getMemoryRom().equals(parseInteger(String.valueOf(criteria.getValue(searchCriteria))));
                    break;
                case "FLASH_MEMORY_CAPACITY":
                    result = result && tabletPC.getFlashMemoryCapacity().equals(parseInteger(String.valueOf(criteria.getValue(searchCriteria))));
                    break;
                case "COLOR":
                    result = result && tabletPC.getColor().equals(String.valueOf(criteria.getValue(searchCriteria)));
                    break;
            }
        }
        return result;
    }

    private Boolean checkSpeakers(Speakers speakers, Criteria criteria) {
        // POWER_CONSUMPTION=15, NUMBER_OF_SPEAKERS=2, FREQUENCY_RANGE=2-4, CORD_LENGTH=2
        boolean result = true;
        for (String searchCriteria: criteria.searchCriteries()) {
            switch (searchCriteria) {
                case "POWER_CONSUMPTION":
                    result = result && speakers.getPowerConsumption().equals(parseInteger(String.valueOf(criteria.getValue(searchCriteria))));
                    break;
                case "NUMBER_OF_SPEAKERS":
                    result = result && speakers.getNumberOfSpeakers().equals(parseInteger(String.valueOf(criteria.getValue(searchCriteria))));
                    break;
                case "FREQUENCY_RANGE":
                    result = result && speakers.getFrequencyRange().equals(String.valueOf(criteria.getValue(searchCriteria)));
                    break;
                case "CORD_LENGTH":
                    result = result && speakers.getCordLength().equals(parseFloat(String.valueOf(criteria.getValue(searchCriteria))));
                    break;
            }
        }
        return result;
    }
}


//you may add your own new classes
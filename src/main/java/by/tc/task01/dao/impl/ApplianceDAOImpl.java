package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.factory.EntityFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static by.tc.task01.entity.factory.TxtParser.parseFloat;
import static by.tc.task01.entity.factory.TxtParser.parseInteger;

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

}


//you may add your own new classes
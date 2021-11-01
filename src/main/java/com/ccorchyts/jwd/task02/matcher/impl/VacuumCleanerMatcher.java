package com.ccorchyts.jwd.task02.matcher.impl;

import com.ccorchyts.jwd.task02.entity.Appliance;
import com.ccorchyts.jwd.task02.entity.VacuumCleaner;
import com.ccorchyts.jwd.task02.entity.criteria.Criteria;
import com.ccorchyts.jwd.task02.entity.factory.ValueParser;
import com.ccorchyts.jwd.task02.matcher.ApplianceMatcher;

public class VacuumCleanerMatcher implements ApplianceMatcher<VacuumCleaner> {
    @Override
    public Boolean matchAppliance(Appliance appliance, Criteria criteria) {
        VacuumCleaner vacuumCleaner = (VacuumCleaner) appliance;
        boolean result = true;
        for (String searchCriteria : criteria.searchCriteries()) {
            switch (searchCriteria) {
                case "POWER_CONSUMPTION":
                    result = result && vacuumCleaner.getPowerConsumption().equals(ValueParser.parseInteger(String.valueOf(criteria.getValue(searchCriteria))));
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
                    result = result && vacuumCleaner.getMotorSpeedRegulation().equals(ValueParser.parseInteger(String.valueOf(criteria.getValue(searchCriteria))));
                    break;
                case "CLEANING_WIDTH":
                    result = result && vacuumCleaner.getCleaningWidth().equals(ValueParser.parseInteger(String.valueOf(criteria.getValue(searchCriteria))));
                    break;
            }
        }
        return result;
    }
}

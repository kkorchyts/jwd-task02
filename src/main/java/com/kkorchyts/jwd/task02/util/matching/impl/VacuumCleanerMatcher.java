package com.kkorchyts.jwd.task02.util.matching.impl;

import com.kkorchyts.jwd.task02.entity.Appliance;
import com.kkorchyts.jwd.task02.entity.criteria.Criteria;
import com.kkorchyts.jwd.task02.entity.criteria.SearchCriteria;
import com.kkorchyts.jwd.task02.entity.impl.VacuumCleaner;
import com.kkorchyts.jwd.task02.util.matching.ApplianceMatcher;
import com.kkorchyts.jwd.task02.util.numberparsing.ValueParser;

public class VacuumCleanerMatcher implements ApplianceMatcher<VacuumCleaner> {
    @Override
    public Boolean matchAppliance(Appliance appliance, Criteria criteria) {
        VacuumCleaner vacuumCleaner = (VacuumCleaner) appliance;
        boolean result = true;
        for (String searchCriteria : criteria.searchCriteries()) {
            switch (SearchCriteria.VacuumCleaner.valueOf(searchCriteria)) {
                case POWER_CONSUMPTION:
                    result = result && vacuumCleaner.getPowerConsumption().equals(ValueParser.parseInteger(String.valueOf(criteria.getValue(searchCriteria))));
                    break;
                case FILTER_TYPE:
                    result = result && vacuumCleaner.getFilterType().equals(String.valueOf(criteria.getValue(searchCriteria)));
                    break;
                case BAG_TYPE:
                    result = result && vacuumCleaner.getBagType().equals(String.valueOf(criteria.getValue(searchCriteria)));
                    break;
                case WAND_TYPE:
                    result = result && vacuumCleaner.getWandType().equals(String.valueOf(criteria.getValue(searchCriteria)));
                    break;
                case MOTOR_SPEED_REGULATION:
                    result = result && vacuumCleaner.getMotorSpeedRegulation().equals(ValueParser.parseInteger(String.valueOf(criteria.getValue(searchCriteria))));
                    break;
                case CLEANING_WIDTH:
                    result = result && vacuumCleaner.getCleaningWidth().equals(ValueParser.parseInteger(String.valueOf(criteria.getValue(searchCriteria))));
                    break;
            }
        }
        return result;
    }
}

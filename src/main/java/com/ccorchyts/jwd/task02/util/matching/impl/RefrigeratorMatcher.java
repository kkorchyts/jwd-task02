package com.ccorchyts.jwd.task02.util.matching.impl;

import com.ccorchyts.jwd.task02.entity.Appliance;
import com.ccorchyts.jwd.task02.entity.criteria.Criteria;
import com.ccorchyts.jwd.task02.entity.criteria.SearchCriteria;
import com.ccorchyts.jwd.task02.entity.impl.Refrigerator;
import com.ccorchyts.jwd.task02.util.matching.ApplianceMatcher;
import com.ccorchyts.jwd.task02.util.numberparsing.ValueParser;

public class RefrigeratorMatcher implements ApplianceMatcher<Refrigerator> {
    @Override
    public Boolean matchAppliance(Appliance appliance, Criteria criteria) {
        Refrigerator refrigerator = (Refrigerator) appliance;
        boolean result = true;
        for (String searchCriteria : criteria.searchCriteries()) {
            switch (SearchCriteria.Refrigerator.valueOf(searchCriteria)) {
                case POWER_CONSUMPTION:
                    result = result && refrigerator.getPowerConsumption().equals(ValueParser.parseInteger(String.valueOf(criteria.getValue(searchCriteria))));
                    break;
                case WEIGHT:
                    result = result && refrigerator.getWeight().equals(ValueParser.parseInteger(String.valueOf(criteria.getValue(searchCriteria))));
                    break;
                case FREEZER_CAPACITY:
                    result = result && refrigerator.getFreezerCapacity().equals(ValueParser.parseInteger(String.valueOf(criteria.getValue(searchCriteria))));
                    break;
                case OVERALL_CAPACITY:
                    result = result && refrigerator.getOverallCapacity().equals(ValueParser.parseFloat(String.valueOf(criteria.getValue(searchCriteria))));
                    break;
                case HEIGHT:
                    result = result && refrigerator.getHeight().equals(ValueParser.parseFloat(String.valueOf(criteria.getValue(searchCriteria))));
                    break;
                case WIDTH:
                    result = result && refrigerator.getWidth().equals(ValueParser.parseFloat(String.valueOf(criteria.getValue(searchCriteria))));
                    break;
            }
        }
        return result;
    }
}

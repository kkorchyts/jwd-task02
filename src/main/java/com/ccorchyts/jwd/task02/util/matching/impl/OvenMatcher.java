package com.ccorchyts.jwd.task02.util.matching.impl;

import com.ccorchyts.jwd.task02.entity.Appliance;
import com.ccorchyts.jwd.task02.entity.criteria.Criteria;
import com.ccorchyts.jwd.task02.entity.impl.Oven;
import com.ccorchyts.jwd.task02.util.matching.ApplianceMatcher;
import com.ccorchyts.jwd.task02.util.numberparsing.ValueParser;

public class OvenMatcher implements ApplianceMatcher<Oven> {
    @Override
    public Boolean matchAppliance(Appliance appliance, Criteria criteria) {
        Oven oven = (Oven) appliance;
        boolean result = true;
        for (String searchCriteria : criteria.searchCriteries()) {
            switch (searchCriteria) {
                case "POWER_CONSUMPTION":
                    result = result && oven.getPowerConsumption().equals(ValueParser.parseInteger(String.valueOf(criteria.getValue(searchCriteria))));
                    break;
                case "WEIGHT":
                    result = result && oven.getWeight().equals(ValueParser.parseInteger(String.valueOf(criteria.getValue(searchCriteria))));
                    break;
                case "CAPACITY":
                    result = result && oven.getCapacity().equals(ValueParser.parseInteger(String.valueOf(criteria.getValue(searchCriteria))));
                    break;
                case "DEPTH":
                    result = result && oven.getDepth().equals(ValueParser.parseFloat(String.valueOf(criteria.getValue(searchCriteria))));
                    break;
                case "HEIGHT":
                    result = result && oven.getHeight().equals(ValueParser.parseFloat(String.valueOf(criteria.getValue(searchCriteria))));
                    break;
                case "WIDTH":
                    result = result && oven.getWidth().equals(ValueParser.parseFloat(String.valueOf(criteria.getValue(searchCriteria))));
                    break;
            }
        }
        return result;
    }
}


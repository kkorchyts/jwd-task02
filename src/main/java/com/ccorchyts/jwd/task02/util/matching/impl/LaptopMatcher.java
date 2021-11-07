package com.ccorchyts.jwd.task02.util.matching.impl;

import com.ccorchyts.jwd.task02.entity.Appliance;
import com.ccorchyts.jwd.task02.entity.criteria.Criteria;
import com.ccorchyts.jwd.task02.entity.criteria.SearchCriteria;
import com.ccorchyts.jwd.task02.entity.impl.Laptop;
import com.ccorchyts.jwd.task02.util.matching.ApplianceMatcher;
import com.ccorchyts.jwd.task02.util.numberparsing.ValueParser;

public class LaptopMatcher implements ApplianceMatcher<Laptop> {
    @Override
    public Boolean matchAppliance(Appliance appliance, Criteria criteria) {
        Laptop laptop = (Laptop) appliance;
        boolean result = true;
        for (String searchCriteria : criteria.searchCriteries()) {
            switch (SearchCriteria.Laptop.valueOf(searchCriteria)) {
                case BATTERY_CAPACITY:
                    result = result && laptop.getBatteryCapacity().equals(ValueParser.parseFloat(String.valueOf(criteria.getValue(searchCriteria))));
                    break;
                case OS:
                    result = result && laptop.getOperationSystem().equals(String.valueOf(criteria.getValue(searchCriteria)));
                    break;
                case SYSTEM_MEMORY:
                    result = result && laptop.getSystemMemory().equals(ValueParser.parseInteger(String.valueOf(criteria.getValue(searchCriteria))));
                    break;
                case CPU:
                    result = result && laptop.getCpu().equals(String.valueOf(criteria.getValue(searchCriteria)));
                    break;
                case DISPLAY_INCHS:
                    result = result && laptop.getDisplayInchs().equals(ValueParser.parseFloat(String.valueOf(criteria.getValue(searchCriteria))));
                    break;
            }
        }
        return result;
    }
}

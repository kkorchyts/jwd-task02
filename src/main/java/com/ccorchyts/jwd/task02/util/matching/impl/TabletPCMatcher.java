package com.ccorchyts.jwd.task02.util.matching.impl;

import com.ccorchyts.jwd.task02.entity.Appliance;
import com.ccorchyts.jwd.task02.entity.criteria.Criteria;
import com.ccorchyts.jwd.task02.entity.impl.TabletPC;
import com.ccorchyts.jwd.task02.util.matching.ApplianceMatcher;
import com.ccorchyts.jwd.task02.util.numberparsing.ValueParser;

public class TabletPCMatcher implements ApplianceMatcher<TabletPC> {
    @Override
    public Boolean matchAppliance(Appliance appliance, Criteria criteria) {
        TabletPC tabletPC = (TabletPC) appliance;
        boolean result = true;
        for (String searchCriteria : criteria.searchCriteries()) {
            switch (searchCriteria) {
                case "BATTERY_CAPACITY":
                    result = result && tabletPC.getBatteryCapacity().equals(ValueParser.parseInteger(String.valueOf(criteria.getValue(searchCriteria))));
                    break;
                case "DISPLAY_INCHES":
                    result = result && tabletPC.getDisplayInches().equals(String.valueOf(criteria.getValue(searchCriteria)));
                    break;
                case "MEMORY_ROM":
                    result = result && tabletPC.getMemoryRom().equals(ValueParser.parseInteger(String.valueOf(criteria.getValue(searchCriteria))));
                    break;
                case "FLASH_MEMORY_CAPACITY":
                    result = result && tabletPC.getFlashMemoryCapacity().equals(ValueParser.parseInteger(String.valueOf(criteria.getValue(searchCriteria))));
                    break;
                case "COLOR":
                    result = result && tabletPC.getColor().equals(String.valueOf(criteria.getValue(searchCriteria)));
                    break;
            }
        }
        return result;
    }
}

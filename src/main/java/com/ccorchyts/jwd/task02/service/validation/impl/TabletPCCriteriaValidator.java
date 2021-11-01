package com.ccorchyts.jwd.task02.service.validation.impl;

import com.ccorchyts.jwd.task02.entity.criteria.SearchCriteria;
import com.ccorchyts.jwd.task02.entity.factory.ValueParser;
import com.ccorchyts.jwd.task02.service.validation.CriteriaValidator;

import java.util.Objects;

public class TabletPCCriteriaValidator extends BaseCriteriaValidator implements CriteriaValidator {
    {
        parameterValidators.put(SearchCriteria.TabletPC.BATTERY_CAPACITY.toString(), value -> {
            Integer integerValue = ValueParser.parseInteger(String.valueOf(value));
            return integerValue > 0 && integerValue < 100;
        });

        parameterValidators.put(SearchCriteria.TabletPC.DISPLAY_INCHES.toString(), Objects::nonNull);

        parameterValidators.put(SearchCriteria.TabletPC.MEMORY_ROM.toString(), value -> {
            Integer integerValue = ValueParser.parseInteger(String.valueOf(value));
            return integerValue > 0 && integerValue < 32768;
        });

        parameterValidators.put(SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY.toString(), value -> {
            Integer integerValue = ValueParser.parseInteger(String.valueOf(value));
            return integerValue > 0 && integerValue < 65536;
        });

        parameterValidators.put(SearchCriteria.TabletPC.COLOR.toString(), Objects::nonNull);
    }
}
package com.ccorchyts.jwd.task02.service.validation.impl;

import com.ccorchyts.jwd.task02.entity.criteria.SearchCriteria;
import com.ccorchyts.jwd.task02.service.validation.CriteriaValidator;
import com.ccorchyts.jwd.task02.util.numberparsing.ValueParser;

public class OvenCriteriaValidator extends BaseCriteriaValidator implements CriteriaValidator {
    {
        parameterValidators.put(SearchCriteria.Oven.POWER_CONSUMPTION.toString(), value -> {
            Integer integerValue = ValueParser.parseInteger(String.valueOf(value));
            return integerValue > 0 && integerValue < 1000;
        });

        parameterValidators.put(SearchCriteria.Oven.WEIGHT.toString(), value -> {
            Integer integerValue = ValueParser.parseInteger(String.valueOf(value));
            return integerValue > 5 && integerValue < 50;
        });

        parameterValidators.put(SearchCriteria.Oven.CAPACITY.toString(), value -> {
            Integer integerValue = ValueParser.parseInteger(String.valueOf(value));
            return integerValue > 10 && integerValue < 200;
        });

        parameterValidators.put(SearchCriteria.Oven.DEPTH.toString(), value -> {
            Float floatValue = ValueParser.parseFloat(String.valueOf(value));
            return floatValue > 20 && floatValue < 500;
        });

        parameterValidators.put(SearchCriteria.Oven.HEIGHT.toString(), value -> {
            Float floatValue = ValueParser.parseFloat(String.valueOf(value));
            return floatValue > 20 && floatValue < 500;
        });

        parameterValidators.put(SearchCriteria.Oven.WIDTH.toString(), value -> {
            Float floatValue = ValueParser.parseFloat(String.valueOf(value));
            return floatValue > 20 && floatValue < 500;
        });
    }
}
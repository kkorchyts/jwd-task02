package com.kkorchyts.jwd.task02.service.validation.impl;

import com.kkorchyts.jwd.task02.entity.criteria.SearchCriteria;
import com.kkorchyts.jwd.task02.service.validation.CriteriaValidator;
import com.kkorchyts.jwd.task02.util.numberparsing.ValueParser;

public class RefrigeratorCriteriaValidator extends BaseCriteriaValidator implements CriteriaValidator {

    {
        parameterValidators.put(SearchCriteria.Refrigerator.POWER_CONSUMPTION.toString(), value -> {
            Integer integerValue = ValueParser.parseInteger(String.valueOf(value));
            return integerValue > 0 && integerValue < 1000;
        });

        parameterValidators.put(SearchCriteria.Refrigerator.WEIGHT.toString(), value -> {
            Integer integerValue = ValueParser.parseInteger(String.valueOf(value));
            return integerValue > 5 && integerValue < 50;
        });

        parameterValidators.put(SearchCriteria.Refrigerator.FREEZER_CAPACITY.toString(), value -> {
            Integer integerValue = ValueParser.parseInteger(String.valueOf(value));
            return integerValue > -20 && integerValue < 0;
        });

        parameterValidators.put(SearchCriteria.Refrigerator.OVERALL_CAPACITY.toString(), value -> {
            Float floatValue = ValueParser.parseFloat(String.valueOf(value));
            return floatValue > -20 && floatValue < 0;
        });

        parameterValidators.put(SearchCriteria.Refrigerator.HEIGHT.toString(), value -> {
            Float floatValue = ValueParser.parseFloat(String.valueOf(value));
            return floatValue > 50 && floatValue < 200;
        });

        parameterValidators.put(SearchCriteria.Oven.WIDTH.toString(), value -> {
            Float floatValue = ValueParser.parseFloat(String.valueOf(value));
            return floatValue > 20 && floatValue < 100;
        });
    }
}
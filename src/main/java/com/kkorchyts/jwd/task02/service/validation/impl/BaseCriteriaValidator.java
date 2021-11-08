package com.kkorchyts.jwd.task02.service.validation.impl;

import com.kkorchyts.jwd.task02.entity.criteria.Criteria;
import com.kkorchyts.jwd.task02.service.validation.CriteriaValidator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class BaseCriteriaValidator implements CriteriaValidator {
    protected Map<String, Predicate<Object>> parameterValidators = new HashMap<>();

    @Override
    public Boolean validate(Criteria criteria) {
        boolean result = true;
        for (String searchCriteriaName : criteria.searchCriteries()) {
            Object searchCriteriaValue = criteria.getValue(searchCriteriaName);
            result = result && parameterValidators.get(searchCriteriaName).test(searchCriteriaValue);
        }
        return result;
    }
}

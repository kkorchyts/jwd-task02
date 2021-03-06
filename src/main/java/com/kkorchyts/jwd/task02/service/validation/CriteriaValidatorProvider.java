package com.kkorchyts.jwd.task02.service.validation;

import com.kkorchyts.jwd.task02.entity.Appliance;
import com.kkorchyts.jwd.task02.entity.impl.Laptop;
import com.kkorchyts.jwd.task02.entity.impl.Oven;
import com.kkorchyts.jwd.task02.entity.impl.Refrigerator;
import com.kkorchyts.jwd.task02.entity.impl.Speakers;
import com.kkorchyts.jwd.task02.entity.impl.TabletPC;
import com.kkorchyts.jwd.task02.entity.impl.VacuumCleaner;
import com.kkorchyts.jwd.task02.service.validation.impl.LaptopCriteriaValidator;
import com.kkorchyts.jwd.task02.service.validation.impl.OvenCriteriaValidator;
import com.kkorchyts.jwd.task02.service.validation.impl.RefrigeratorCriteriaValidator;
import com.kkorchyts.jwd.task02.service.validation.impl.SpeakersCriteriaValidator;
import com.kkorchyts.jwd.task02.service.validation.impl.TabletPCCriteriaValidator;
import com.kkorchyts.jwd.task02.service.validation.impl.VacuumCleanerCriteriaValidator;

import java.util.Map;
import java.util.TreeMap;

public class CriteriaValidatorProvider {
    private final static CriteriaValidatorProvider INSTANCE = new CriteriaValidatorProvider();
    private final Map<String, CriteriaValidator> validatorMap;

    {
        validatorMap = new TreeMap<>();
        validatorMap.put(Laptop.class.getSimpleName(), new LaptopCriteriaValidator());
        validatorMap.put(Oven.class.getSimpleName(), new OvenCriteriaValidator());
        validatorMap.put(Refrigerator.class.getSimpleName(), new RefrigeratorCriteriaValidator());
        validatorMap.put(Speakers.class.getSimpleName(), new SpeakersCriteriaValidator());
        validatorMap.put(TabletPC.class.getSimpleName(), new TabletPCCriteriaValidator());
        validatorMap.put(VacuumCleaner.class.getSimpleName(), new VacuumCleanerCriteriaValidator());
    }

    private CriteriaValidatorProvider() {
    }

    public static CriteriaValidatorProvider getInstance() {
        return INSTANCE;
    }

    public CriteriaValidator getCriteriaValidator(String ApplianceClassName) {
        return validatorMap.get(ApplianceClassName);
    }

    public CriteriaValidator getCriteriaValidator(Class<? extends Appliance> cl) {
        return validatorMap.get(cl.getSimpleName());
    }
}

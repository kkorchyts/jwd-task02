package com.ccorchyts.jwd.task02.service.validation;

import com.ccorchyts.jwd.task02.entity.Appliance;
import com.ccorchyts.jwd.task02.entity.Laptop;
import com.ccorchyts.jwd.task02.entity.Oven;
import com.ccorchyts.jwd.task02.entity.Refrigerator;
import com.ccorchyts.jwd.task02.entity.Speakers;
import com.ccorchyts.jwd.task02.entity.TabletPC;
import com.ccorchyts.jwd.task02.entity.VacuumCleaner;
import com.ccorchyts.jwd.task02.service.validation.impl.LaptopCriteriaValidator;
import com.ccorchyts.jwd.task02.service.validation.impl.OvenCriteriaValidator;
import com.ccorchyts.jwd.task02.service.validation.impl.RefrigeratorCriteriaValidator;
import com.ccorchyts.jwd.task02.service.validation.impl.SpeakersCriteriaValidator;
import com.ccorchyts.jwd.task02.service.validation.impl.TabletPCCriteriaValidator;
import com.ccorchyts.jwd.task02.service.validation.impl.VacuumCleanerCriteriaValidator;

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

package com.ccorchyts.jwd.task02.util.matching;

import com.ccorchyts.jwd.task02.entity.Appliance;
import com.ccorchyts.jwd.task02.entity.impl.Laptop;
import com.ccorchyts.jwd.task02.entity.impl.Oven;
import com.ccorchyts.jwd.task02.entity.impl.Refrigerator;
import com.ccorchyts.jwd.task02.entity.impl.Speakers;
import com.ccorchyts.jwd.task02.entity.impl.TabletPC;
import com.ccorchyts.jwd.task02.entity.impl.VacuumCleaner;
import com.ccorchyts.jwd.task02.util.matching.impl.LaptopMatcher;
import com.ccorchyts.jwd.task02.util.matching.impl.OvenMatcher;
import com.ccorchyts.jwd.task02.util.matching.impl.RefrigeratorMatcher;
import com.ccorchyts.jwd.task02.util.matching.impl.SpeakersMatcher;
import com.ccorchyts.jwd.task02.util.matching.impl.TabletPCMatcher;
import com.ccorchyts.jwd.task02.util.matching.impl.VacuumCleanerMatcher;

import java.util.Map;
import java.util.TreeMap;

public class ApplianceMatcherProvider {
    private final static ApplianceMatcherProvider INSTANCE = new ApplianceMatcherProvider();
    private final Map<String, ApplianceMatcher<? extends Appliance>> matcherMap;

    {
        matcherMap = new TreeMap<>();
        matcherMap.put(Laptop.class.getSimpleName().toLowerCase(), new LaptopMatcher());
        matcherMap.put(Oven.class.getSimpleName().toLowerCase(), new OvenMatcher());
        matcherMap.put(Refrigerator.class.getSimpleName().toLowerCase(), new RefrigeratorMatcher());
        matcherMap.put(Speakers.class.getSimpleName().toLowerCase(), new SpeakersMatcher());
        matcherMap.put(TabletPC.class.getSimpleName().toLowerCase(), new TabletPCMatcher());
        matcherMap.put(VacuumCleaner.class.getSimpleName().toLowerCase(), new VacuumCleanerMatcher());
    }

    private ApplianceMatcherProvider() {
    }

    public static ApplianceMatcherProvider getInstance() {
        return INSTANCE;
    }

    public ApplianceMatcher<? extends Appliance> getApplianceMatcher(String ApplianceClassName) {
        return matcherMap.get(ApplianceClassName);
    }

    public ApplianceMatcher<? extends Appliance> getApplianceMatcher(Class<? extends Appliance> cl) {
        return matcherMap.get(cl.getSimpleName().toLowerCase());
    }

}

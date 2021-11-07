package com.ccorchyts.jwd.task02.util.xmlparsing.domwriting.converation;

import com.ccorchyts.jwd.task02.entity.impl.Laptop;
import com.ccorchyts.jwd.task02.entity.impl.Oven;
import com.ccorchyts.jwd.task02.entity.impl.Refrigerator;
import com.ccorchyts.jwd.task02.entity.impl.Speakers;
import com.ccorchyts.jwd.task02.entity.impl.TabletPC;
import com.ccorchyts.jwd.task02.entity.impl.VacuumCleaner;
import com.ccorchyts.jwd.task02.util.xmlparsing.domwriting.converation.impl.LaptopConverterImpl;
import com.ccorchyts.jwd.task02.util.xmlparsing.domwriting.converation.impl.OvenConverterImpl;
import com.ccorchyts.jwd.task02.util.xmlparsing.domwriting.converation.impl.RefrigeratorConverterImpl;
import com.ccorchyts.jwd.task02.util.xmlparsing.domwriting.converation.impl.SpeakersConverterImpl;
import com.ccorchyts.jwd.task02.util.xmlparsing.domwriting.converation.impl.TabletPCConverterImpl;
import com.ccorchyts.jwd.task02.util.xmlparsing.domwriting.converation.impl.VacuumCleanerConverterImpl;

import java.util.HashMap;
import java.util.Map;

public class ApplianceConverterProvider {
    private final static ApplianceConverterProvider INSTANCE = new ApplianceConverterProvider();

    private ApplianceConverterProvider() {
    }

    public static ApplianceConverterProvider getInstance() {
        return INSTANCE;
    }

    Map<String, ApplianceConverter> converterMap = new HashMap<>();

    {
        converterMap.put(Laptop.class.getSimpleName().toLowerCase(), new LaptopConverterImpl());
        converterMap.put(Oven.class.getSimpleName().toLowerCase(), new OvenConverterImpl());
        converterMap.put(Refrigerator.class.getSimpleName().toLowerCase(), new RefrigeratorConverterImpl());
        converterMap.put(Speakers.class.getSimpleName().toLowerCase(), new SpeakersConverterImpl());
        converterMap.put(TabletPC.class.getSimpleName().toLowerCase(), new TabletPCConverterImpl());
        converterMap.put(VacuumCleaner.class.getSimpleName().toLowerCase(), new VacuumCleanerConverterImpl());
    }

    public ApplianceConverter getApplianceConverter(String applianceClassName) {
        return converterMap.get(applianceClassName.toLowerCase());
    }
}

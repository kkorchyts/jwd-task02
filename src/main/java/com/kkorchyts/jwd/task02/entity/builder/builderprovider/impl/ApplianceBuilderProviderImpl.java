package com.kkorchyts.jwd.task02.entity.builder.builderprovider.impl;

import com.kkorchyts.jwd.task02.entity.Appliance;
import com.kkorchyts.jwd.task02.entity.builder.appliancebuilder.ApplianceBuilder;
import com.kkorchyts.jwd.task02.entity.builder.appliancebuilder.impl.LaptopBuilderImpl;
import com.kkorchyts.jwd.task02.entity.builder.appliancebuilder.impl.OvenBuilderImpl;
import com.kkorchyts.jwd.task02.entity.builder.appliancebuilder.impl.RefrigeratorBuilderImpl;
import com.kkorchyts.jwd.task02.entity.builder.appliancebuilder.impl.SpeakersBuilderImpl;
import com.kkorchyts.jwd.task02.entity.builder.appliancebuilder.impl.TabletPCBuilderImpl;
import com.kkorchyts.jwd.task02.entity.builder.appliancebuilder.impl.VacuumCleanerBuilderImpl;
import com.kkorchyts.jwd.task02.entity.builder.builderprovider.ApplianceBuilderProvider;
import com.kkorchyts.jwd.task02.entity.impl.Laptop;
import com.kkorchyts.jwd.task02.entity.impl.Oven;
import com.kkorchyts.jwd.task02.entity.impl.Refrigerator;
import com.kkorchyts.jwd.task02.entity.impl.Speakers;
import com.kkorchyts.jwd.task02.entity.impl.TabletPC;
import com.kkorchyts.jwd.task02.entity.impl.VacuumCleaner;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public final class ApplianceBuilderProviderImpl implements ApplianceBuilderProvider {
    private final static ApplianceBuilderProviderImpl INSTANCE = new ApplianceBuilderProviderImpl();

    private ApplianceBuilderProviderImpl() {
    }

    public static ApplianceBuilderProvider getInstance() {
        return INSTANCE;
    }

    Map<String, Class<? extends ApplianceBuilder<? extends Appliance>>> builderMap = new HashMap<>();

    {
        builderMap.put(Laptop.class.getSimpleName().toLowerCase(), LaptopBuilderImpl.class);
        builderMap.put(Oven.class.getSimpleName().toLowerCase(), OvenBuilderImpl.class);
        builderMap.put(Refrigerator.class.getSimpleName().toLowerCase(), RefrigeratorBuilderImpl.class);
        builderMap.put(Speakers.class.getSimpleName().toLowerCase(), SpeakersBuilderImpl.class);
        builderMap.put(TabletPC.class.getSimpleName().toLowerCase(), TabletPCBuilderImpl.class);
        builderMap.put(VacuumCleaner.class.getSimpleName().toLowerCase(), VacuumCleanerBuilderImpl.class);
    }

    @Override
    public ApplianceBuilder<? extends Appliance> getApplianceBuilder(String applianceClassName) {
        Class<? extends ApplianceBuilder<? extends Appliance>> builderClass = builderMap.get(applianceClassName);
        try {
            return builderClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}

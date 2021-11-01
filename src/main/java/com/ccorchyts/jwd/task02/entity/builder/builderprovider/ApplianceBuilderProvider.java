package com.ccorchyts.jwd.task02.entity.builder.builderprovider;

import com.ccorchyts.jwd.task02.entity.Appliance;
import com.ccorchyts.jwd.task02.entity.builder.appliancebuilder.ApplianceBuilder;

import java.lang.reflect.InvocationTargetException;

public interface ApplianceBuilderProvider {
    ApplianceBuilder<? extends Appliance> getApplianceBuilder(String applianceClassName);
}

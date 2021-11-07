package com.ccorchyts.jwd.task02.entity.builder.builderprovider;

import com.ccorchyts.jwd.task02.entity.Appliance;
import com.ccorchyts.jwd.task02.entity.builder.appliancebuilder.ApplianceBuilder;

public interface ApplianceBuilderProvider {
    ApplianceBuilder<? extends Appliance> getApplianceBuilder(String applianceClassName);
}

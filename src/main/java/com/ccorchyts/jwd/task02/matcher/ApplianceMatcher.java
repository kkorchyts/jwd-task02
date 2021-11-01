package com.ccorchyts.jwd.task02.matcher;

import com.ccorchyts.jwd.task02.entity.Appliance;
import com.ccorchyts.jwd.task02.entity.Oven;
import com.ccorchyts.jwd.task02.entity.criteria.Criteria;

public interface ApplianceMatcher<T extends Appliance> {
    Boolean matchAppliance(Appliance appliance, Criteria criteria);
}

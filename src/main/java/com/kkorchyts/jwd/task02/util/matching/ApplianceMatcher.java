package com.kkorchyts.jwd.task02.util.matching;

import com.kkorchyts.jwd.task02.entity.Appliance;
import com.kkorchyts.jwd.task02.entity.criteria.Criteria;

public interface ApplianceMatcher<T extends Appliance> {
    Boolean matchAppliance(Appliance appliance, Criteria criteria);
}

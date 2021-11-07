package com.ccorchyts.jwd.task02.service;

import com.ccorchyts.jwd.task02.entity.Appliance;
import com.ccorchyts.jwd.task02.entity.criteria.Criteria;

import java.util.List;

public interface ApplianceService {
    List<Appliance> getAll();

    List<Appliance> find(Criteria criteria);

    void addAppliance(Appliance appliance);

    void addAppliances(List<Appliance> appliances);
}

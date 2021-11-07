package com.ccorchyts.jwd.task02.dao;

import com.ccorchyts.jwd.task02.entity.Appliance;
import com.ccorchyts.jwd.task02.entity.criteria.Criteria;

import java.util.List;

public interface ApplianceDAO {
    List<Appliance> find(Criteria criteria);

    List<Appliance> getAll();

    void add(Appliance appliance);

    void add(List<Appliance> appliances);

}

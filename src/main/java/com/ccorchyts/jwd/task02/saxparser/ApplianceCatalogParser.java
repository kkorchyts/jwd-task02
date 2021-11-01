package com.ccorchyts.jwd.task02.saxparser;

import com.ccorchyts.jwd.task02.entity.Appliance;
import com.ccorchyts.jwd.task02.entity.criteria.Criteria;

import java.util.List;

public interface ApplianceCatalogParser {
    List<Appliance> readCatalogFromFile(String fileName);
    //List<Appliance> readCatalogFromFile(String fileName, Criteria criteria);
}

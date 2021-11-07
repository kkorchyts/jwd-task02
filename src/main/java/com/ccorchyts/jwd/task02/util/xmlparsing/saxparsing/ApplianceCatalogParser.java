package com.ccorchyts.jwd.task02.util.xmlparsing.saxparsing;

import com.ccorchyts.jwd.task02.entity.Appliance;

import java.util.List;

public interface ApplianceCatalogParser {
    List<Appliance> readCatalogFromFile(String fileName);
    //List<Appliance> readCatalogFromFile(String fileName, Criteria criteria);
}

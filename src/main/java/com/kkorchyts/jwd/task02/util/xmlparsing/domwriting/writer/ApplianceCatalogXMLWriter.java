package com.kkorchyts.jwd.task02.util.xmlparsing.domwriting.writer;

import com.kkorchyts.jwd.task02.entity.Appliance;

import java.io.File;
import java.util.List;

public interface ApplianceCatalogXMLWriter {
    void saveCatalogIntoXMLCatalog(File file, List<Appliance> appliances);

    void saveCatalogIntoXMLCatalog(String fileName, List<Appliance> appliances);

    void appendCatalogIntoXMLFile(File file, List<Appliance> appliances);

    void appendCatalogIntoXMLFile(String fileName, List<Appliance> appliances);

    void appendApplianceIntoXMLCatalog(File file, Appliance appliance);

    void appendApplianceIntoXMLCatalog(String fileName, Appliance appliance);
}

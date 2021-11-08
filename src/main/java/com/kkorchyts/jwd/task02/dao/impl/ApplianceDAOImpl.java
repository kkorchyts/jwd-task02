package com.kkorchyts.jwd.task02.dao.impl;

import com.kkorchyts.jwd.task02.dao.ApplianceDAO;
import com.kkorchyts.jwd.task02.entity.Appliance;
import com.kkorchyts.jwd.task02.entity.criteria.Criteria;
import com.kkorchyts.jwd.task02.util.matching.ApplianceMatcher;
import com.kkorchyts.jwd.task02.util.matching.ApplianceMatcherProvider;
import com.kkorchyts.jwd.task02.util.xmlparsing.domwriting.writer.ApplianceCatalogXMLWriter;
import com.kkorchyts.jwd.task02.util.xmlparsing.domwriting.writer.impl.ApplianceCatalogXMLWriterImpl;
import com.kkorchyts.jwd.task02.util.xmlparsing.saxparsing.ApplianceCatalogParser;
import com.kkorchyts.jwd.task02.util.xmlparsing.saxparsing.impl.ApplianceCatalogXMLParserImpl;

import java.util.ArrayList;
import java.util.List;

public class ApplianceDAOImpl implements ApplianceDAO {
    private static final String DB_FILE_NAME = "bd.xml";
    private final ApplianceCatalogParser applianceCatalogParser = new ApplianceCatalogXMLParserImpl();
    private final ApplianceMatcherProvider applianceMatcherProvider = ApplianceMatcherProvider.getInstance();
    private final ApplianceCatalogXMLWriter applianceCatalogXMLWriter = new ApplianceCatalogXMLWriterImpl();

    @Override
    public List<Appliance> find(Criteria criteria) {
        List<Appliance> appliances;
        List<Appliance> result = new ArrayList<>();
        appliances = applianceCatalogParser.readCatalogFromFile(DB_FILE_NAME);
        for (Appliance appliance : appliances) {
            ApplianceMatcher<? extends Appliance> applianceMatcher = applianceMatcherProvider.getApplianceMatcher(appliance.getClass());
            if (applianceMatcher.matchAppliance(appliance, criteria)) {
                result.add(appliance);
            }
        }
        return result;
    }

    @Override
    public List<Appliance> getAll() {
        return applianceCatalogParser.readCatalogFromFile(DB_FILE_NAME);
    }

    @Override
    public void add(Appliance appliance) {
        applianceCatalogXMLWriter.appendApplianceIntoXMLCatalog(DB_FILE_NAME, appliance);
    }

    @Override
    public void add(List<Appliance> appliances) {
        applianceCatalogXMLWriter.appendCatalogIntoXMLFile(DB_FILE_NAME, appliances);

    }
}

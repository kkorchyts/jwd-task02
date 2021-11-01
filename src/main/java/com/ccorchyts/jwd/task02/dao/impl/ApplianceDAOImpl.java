package com.ccorchyts.jwd.task02.dao.impl;

import com.ccorchyts.jwd.task02.entity.Appliance;
import com.ccorchyts.jwd.task02.dao.ApplianceDAO;
import com.ccorchyts.jwd.task02.entity.criteria.Criteria;
import com.ccorchyts.jwd.task02.matcher.ApplianceMatcher;
import com.ccorchyts.jwd.task02.matcher.ApplianceMatcherProvider;
import com.ccorchyts.jwd.task02.saxparser.ApplianceCatalogParser;
import com.ccorchyts.jwd.task02.saxparser.impl.ApplianceCatalogXMLParserImpl;

import java.util.ArrayList;
import java.util.List;

public class ApplianceDAOImpl implements ApplianceDAO {
    private static final String DB_FILE_NAME = "bd.xml";
    ApplianceCatalogParser applianceCatalogParser = new ApplianceCatalogXMLParserImpl();
    ApplianceMatcherProvider applianceMatcherProvider = ApplianceMatcherProvider.getInstance();

    @Override
    public List<Appliance> find(Criteria criteria) {
        List<Appliance> appliances;
        List<Appliance> result = new ArrayList<>();
        appliances = applianceCatalogParser.readCatalogFromFile(DB_FILE_NAME);
        for (Appliance appliance : appliances) {
            Boolean isPassed = false;
            ApplianceMatcher<? extends Appliance> applianceMatcher = applianceMatcherProvider.getApplianceMatcher(appliance.getClass());
            if (applianceMatcher.matchAppliance(appliance, criteria)) {
                result.add(appliance);
            }
        }
        return result;
    }
}

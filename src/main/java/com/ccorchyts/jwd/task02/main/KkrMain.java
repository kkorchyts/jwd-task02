package com.ccorchyts.jwd.task02.main;

import com.ccorchyts.jwd.task02.entity.Appliance;
import com.ccorchyts.jwd.task02.entity.criteria.Criteria;
import com.ccorchyts.jwd.task02.entity.criteria.SearchCriteria;
import com.ccorchyts.jwd.task02.service.ApplianceService;
import com.ccorchyts.jwd.task02.service.impl.ApplianceServiceImpl;

import java.util.List;

public class KkrMain {
    public static void main(String[] args) {

        ApplianceService applianceService = new ApplianceServiceImpl();


        //ApplianceDAO applianceDAO = new ApplianceDAOImpl();

        Criteria criteriaOven = new Criteria(SearchCriteria.Oven.class.getSimpleName());
        //criteriaOven.add(SearchCriteria.Oven.HEIGHT.toString(), 45);
        criteriaOven.add("SearchCriteria.Oven.DEPTH.toString()", 60);

        List<Appliance> applianceList = applianceService.find(criteriaOven);

        for (Appliance appliance : applianceList) {
            PrintApplianceInfo.print(appliance);
        }
    }
}

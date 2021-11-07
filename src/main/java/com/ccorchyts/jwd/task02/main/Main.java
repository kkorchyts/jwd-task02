package com.ccorchyts.jwd.task02.main;

import com.ccorchyts.jwd.task02.entity.Appliance;
import com.ccorchyts.jwd.task02.entity.criteria.Criteria;
import com.ccorchyts.jwd.task02.entity.criteria.SearchCriteria;
import com.ccorchyts.jwd.task02.service.ApplianceService;
import com.ccorchyts.jwd.task02.service.ServiceFactory;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Appliance> appliances = new ArrayList<>();

        ServiceFactory factory = ServiceFactory.getInstance();
        ApplianceService service = factory.getApplianceService();

        //////////////////////////////////////////////////////////////////

        Criteria criteriaOven = new Criteria(SearchCriteria.Oven.class.getSimpleName());//"Oven"
        criteriaOven.add(SearchCriteria.Oven.CAPACITY.toString(), 32);

        appliances = service.find(criteriaOven);

        for (Appliance appliance : appliances) {
            PrintApplianceInfo.print(appliance);
        }

        //////////////////////////////////////////////////////////////////

        criteriaOven = new Criteria(SearchCriteria.Oven.class.getSimpleName());
        criteriaOven.add(SearchCriteria.Oven.HEIGHT.toString(), 200);
        criteriaOven.add(SearchCriteria.Oven.DEPTH.toString(), 300);

        appliances = service.find(criteriaOven);

        for (Appliance appliance : appliances) {
            PrintApplianceInfo.print(appliance);
        }

        //////////////////////////////////////////////////////////////////

        Criteria criteriaTabletPC = new Criteria(SearchCriteria.TabletPC.class.getSimpleName());
        criteriaTabletPC.add(SearchCriteria.TabletPC.COLOR.toString(), "BLUE");
        criteriaTabletPC.add(SearchCriteria.TabletPC.DISPLAY_INCHES.toString(), 14);
        criteriaTabletPC.add(SearchCriteria.TabletPC.MEMORY_ROM.toString(), 4);

        appliances = service.find(criteriaOven);// find(Object...obj)

        for (Appliance appliance : appliances) {
            PrintApplianceInfo.print(appliance);
        }

    }

}

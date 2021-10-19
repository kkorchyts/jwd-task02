package by.tc.task01.main;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.impl.ApplianceDAOImpl;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;

public class KkrMain {
    public static void main(String[] args) {
        ApplianceDAO applianceDAO = new ApplianceDAOImpl();

        Criteria criteriaOven = new Criteria(SearchCriteria.Oven.class.getSimpleName());
        criteriaOven.add(SearchCriteria.Oven.HEIGHT.toString(), 45);
        criteriaOven.add(SearchCriteria.Oven.DEPTH.toString(), 60);

        applianceDAO.find(criteriaOven);
    }
}

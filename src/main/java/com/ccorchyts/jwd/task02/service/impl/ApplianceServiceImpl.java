package com.ccorchyts.jwd.task02.service.impl;

import com.ccorchyts.jwd.task02.dao.ApplianceDAO;
import com.ccorchyts.jwd.task02.dao.DAOFactory;
import com.ccorchyts.jwd.task02.entity.Appliance;
import com.ccorchyts.jwd.task02.entity.criteria.Criteria;
import com.ccorchyts.jwd.task02.service.ApplianceService;
import com.ccorchyts.jwd.task02.service.validation.CriteriaValidatorProvider;

import java.util.List;

public class ApplianceServiceImpl implements ApplianceService{
	private final CriteriaValidatorProvider criteriaValidatorProvider = CriteriaValidatorProvider.getInstance();

	@Override
	public List<Appliance> find(Criteria criteria) {


		if (!criteriaValidatorProvider.getCriteriaValidator(criteria.getGroupSearchName()).validate(criteria)) {
			return null;
		}
		
		DAOFactory factory = DAOFactory.getInstance();
		ApplianceDAO applianceDAO = factory.getApplianceDAO();
		
		List<Appliance> appliances = applianceDAO.find(criteria);
		
		// you may add your own code here
		
		return appliances;
	}

}

//you may add your own new classes

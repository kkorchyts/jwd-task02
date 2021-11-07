package com.ccorchyts.jwd.task02.entity.criteria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Criteria {

    private final String groupSearchName;
    private final Map<String, Object> criteria = new HashMap<String, Object>();

    public Criteria(String groupSearchName) {
        this.groupSearchName = groupSearchName;
    }

    public String getGroupSearchName() {
        return groupSearchName;
    }

    public void add(String searchCriteria, Object value) {
        criteria.put(searchCriteria, value);
    }

    // you may add your own code here
    public List<String> searchCriteries() {
        return new ArrayList<>(criteria.keySet());
    }

    public Object getValue(String searchCriteria) {
        return criteria.get(searchCriteria);
    }
}

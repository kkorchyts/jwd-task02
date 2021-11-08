package com.kkorchyts.jwd.task02.entity.builder.appliancebuilder;

import java.util.Map;

public interface ApplianceBuilder<E> {
    ApplianceBuilder<E> properties(Map<String, Object> properties);

    E build();
}

/*
* Copyright (c) 2024 Contributors to the Eclipse Foundation.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
*
* Contributors:
*   Stefan Bischof (bipolis.org) - initial
*/
package org.eclipse.daanse.index.es.ecs.emf.generator.model;

import java.util.List;

public class EcsAllowesValues {
    private String beta;

    private String description;

    private List<String>  expected_event_types;

    private String name;

    public String getBeta() {
        return beta;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getExpected_event_types() {
        return expected_event_types;
    }

    public String getName() {
        return name;
    }

    public void setBeta(String beta) {
        this.beta = beta;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setExpected_event_types(List<String> expected_event_types) {
        this.expected_event_types = expected_event_types;
    }

    public void setName(String name) {
        this.name = name;
    }
}

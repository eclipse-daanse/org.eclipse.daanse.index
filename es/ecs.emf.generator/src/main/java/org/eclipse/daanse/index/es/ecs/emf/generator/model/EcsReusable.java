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

public class EcsReusable {

    private List<Object> expected;
    private Integer order;
    private Boolean top_level;
    public List<Object> getExpected() {
        return expected;
    }

    public Integer getOrder() {
        return order;
    }

    public Boolean getTop_level() {
        return top_level;
    }

    public void setExpected(List<Object> expected) {
        this.expected = expected;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public void setTop_level(Boolean top_level) {
        this.top_level = top_level;
    }

}

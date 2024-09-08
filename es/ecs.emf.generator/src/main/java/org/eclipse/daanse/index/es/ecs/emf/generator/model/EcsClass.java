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

public class EcsClass {
    private String beta;
    private String description;
    private List<EcsField> fields;
    private String footnote;
    private String format;
    private Integer group;
    private String name;
    private EcsReusable reusable;
    private Boolean root;
    private String shortDescription;
    private String title;
    private String type;


    public String getBeta() {
        return beta;
    }

    public String getDescription() {
        return description;
    }

    public List<EcsField> getFields() {
        return fields;
    }

    public String getFootnote() {
        return footnote;
    }

    public String getFormat() {
        return format;
    }

    public Integer getGroup() {
        return group;
    }

    public String getName() {
        return name;
    }

    public EcsReusable getReusable() {
        return reusable;
    }

    public Boolean getRoot() {
        return root;
    }

    public String getShort() {
        return shortDescription;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public void setBeta(String beta) {
        this.beta = beta;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFields(List<EcsField> fields) {
        this.fields = fields;
    }

    public void setFootnote(String footnote) {
        this.footnote = footnote;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReusable(EcsReusable reusable) {
        this.reusable = reusable;
    }

    public void setRoot(Boolean root) {
        this.root = root;
    }

    public void setShort(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(String type) {
        this.type = type;
    }

}

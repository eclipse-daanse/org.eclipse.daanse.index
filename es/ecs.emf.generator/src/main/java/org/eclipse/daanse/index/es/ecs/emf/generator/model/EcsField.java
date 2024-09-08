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

public class EcsField {

    private List<EcsAllowesValues> allowed_values;
    private String  beta;
    private String description;
    private Boolean doc_values;
    private String example;
    private List<String> expected_values;
    private String format;
    private Integer ignore_above;
    private Boolean index;
    private String input_format;
    private String level;
    private List<EcsFielsMulti> multi_fields;
    private String name;
    private String normalize;
    private String object_type;
    private String output_format;
    private Integer output_precision;
    private String pattern;

    private Boolean  required;
    private Integer scaling_factor;
    private String shortDescription;

    private String type;

    public List<EcsAllowesValues> getAllowed_values() {
        return allowed_values;
    }

    public String getBeta() {
        return beta;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getDoc_values() {
        return doc_values;
    }

    public String getExample() {
        return example;
    }

    public List<String> getExpected_values() {
        return expected_values;
    }

    public String getFormat() {
        return format;
    }

    public Integer getIgnore_above() {
        return ignore_above;
    }

    public Boolean getIndex() {
        return index;
    }

    public String getInput_format() {
        return input_format;
    }

    public String getLevel() {
        return level;
    }

    public List<EcsFielsMulti> getMulti_fields() {
        return multi_fields;
    }

    public String getName() {
        return name;
    }

    public String getNormalize() {
        return normalize;
    }

    public String getObject_type() {
        return object_type;
    }

    public String getOutput_format() {
        return output_format;
    }

    public Integer getOutput_precision() {
        return output_precision;
    }

    public String getPattern() {
        return pattern;
    }

    public Boolean getRequired() {
        return required;
    }

    public Integer getScaling_factor() {
        return scaling_factor;
    }

    public String getShort() {
        return shortDescription;
    }

    public String getType() {
        return type;
    }

    public void setAllowed_values(List<EcsAllowesValues> allowed_values) {
        this.allowed_values = allowed_values;
    }

    public void setBeta(String beta) {
        this.beta = beta;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDoc_values(Boolean doc_values) {
        this.doc_values = doc_values;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public void setExpected_values(List<String> expected_values) {
        this.expected_values = expected_values;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public void setIgnore_above(Integer ignore_above) {
        this.ignore_above = ignore_above;
    }

    public void setIndex(Boolean index) {
        this.index = index;
    }

    public void setInput_format(String input_format) {
        this.input_format = input_format;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setMulti_fields(List<EcsFielsMulti> multi_fields) {
        this.multi_fields = multi_fields;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNormalize(String normalize) {
        this.normalize = normalize;
    }

    public void setObject_type(String object_type) {
        this.object_type = object_type;
    }

    public void setOutput_format(String output_format) {
        this.output_format = output_format;
    }

    public void setOutput_precision(Integer output_precision) {
        this.output_precision = output_precision;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public void setScaling_factor(Integer scaling_factor) {
        this.scaling_factor = scaling_factor;
    }

    public void setShort(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public void setType(String type) {
        this.type = type;
    }

}

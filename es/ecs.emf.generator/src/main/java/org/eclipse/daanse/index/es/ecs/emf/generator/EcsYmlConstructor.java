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
package org.eclipse.daanse.index.es.ecs.emf.generator;

import java.util.ArrayList;

import org.eclipse.daanse.index.es.ecs.emf.generator.model.EcsClass;
import org.eclipse.daanse.index.es.ecs.emf.generator.model.EcsField;
import org.eclipse.daanse.index.es.ecs.emf.generator.model.EcsFielsMulti;
import org.eclipse.daanse.index.es.ecs.emf.generator.model.EcsReusable;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.TypeDescription;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.SequenceNode;

public class EcsYmlConstructor extends Constructor {

    private TypeDescription ecsClassType = new TypeDescription(EcsClass.class);
    private TypeDescription ecsFieldType = new TypeDescription(EcsField.class);
    private TypeDescription ecsFielsMultiType = new TypeDescription(EcsFielsMulti.class);
    private TypeDescription ecsReusableType = new TypeDescription(EcsReusable.class);

    public EcsYmlConstructor() {
        super(ArrayList.class, new LoaderOptions());

        this.addTypeDescription(ecsClassType);
        this.addTypeDescription(ecsFieldType);
        this.addTypeDescription(ecsFielsMultiType);
        this.addTypeDescription(ecsReusableType);

    }

    @Override
    protected Object constructObject(final Node node) {
        if (node instanceof SequenceNode && isRootNode(node)) {
            ((SequenceNode) node).setListType(EcsClass.class);
        }
        return super.constructObject(node);
    }

    private boolean isRootNode(final Node node) {
        return node.getStartMark().getIndex() == 778;
    }

}

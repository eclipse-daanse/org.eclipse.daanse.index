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

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.eclipse.daanse.index.es.ecs.emf.generator.model.EcsClass;
import org.eclipse.daanse.index.es.ecs.emf.generator.model.EcsField;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.yaml.snakeyaml.Yaml;

public class EcoreGen {

    EPackage generate(Path rootFolder) throws IOException {

        List<EcsClass> ecsClasses = listYmlFiles(rootFolder);

        EPackage ePackageEcs = createEcsPackage();

        for (EcsClass ecsClass : ecsClasses) {
            final EClass eClass = EcoreFactory.eINSTANCE.createEClass();
            String className = firstCharUpper(ecsClass.getName());
            eClass.setName(className);
            ePackageEcs.getEClassifiers().add(eClass);

            for (EcsField ecsField : ecsClass.getFields()) {
                addField(ePackageEcs, eClass, ecsField, ecsField.getName());
            }
        }

        ResourceSet resourceSet = new ResourceSetImpl();
        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore",
                new EcoreResourceFactoryImpl());

        Resource outputRes = resourceSet.createResource(URI.createFileURI("./ecs.ecore"));
        outputRes.getContents().add(ePackageEcs);

        outputRes.save(Files.newOutputStream(Paths.get("./ecs.ecore"), StandardOpenOption.CREATE), Map.of());

        return null;

    }

    private void addField(EPackage ePackageEcs, final EClass eClass, EcsField ecsField, String fieldName) {
        EClass eClassToPutFieldsOn = eClass;
        int index = fieldName.indexOf(".");
        if (index > 0) {

            String nestedObjectName = fieldName.substring(0, index);
            fieldName = fieldName.substring(index + 1);

            String word = firstCharUpper(nestedObjectName);
            String newName = eClass.getName() + word;

            eClassToPutFieldsOn = (EClass) ePackageEcs.getEClassifier(newName);

            if (eClassToPutFieldsOn == null) {
                eClassToPutFieldsOn = EcoreFactory.eINSTANCE.createEClass();
                eClassToPutFieldsOn.setName(newName);
                ePackageEcs.getEClassifiers().add(eClassToPutFieldsOn);

                EReference eReference = EcoreFactory.eINSTANCE.createEReference();
                eReference.setName(nestedObjectName);
                eReference.setLowerBound(0);
                eReference.setUpperBound(1);
                eReference.setContainment(true);
                eReference.setEType(eClassToPutFieldsOn);
                eClass.getEStructuralFeatures().add(eReference);
            }

            addField(ePackageEcs, eClassToPutFieldsOn, ecsField, fieldName);

        } else {

            final EAttribute eAttribute = EcoreFactory.eINSTANCE.createEAttribute();
            eAttribute.setName(fieldName);

            Map<String,String> detailsMap=new HashMap<>();
            detailsMap.put("title", fieldName);
            detailsMap.put("shortDescription", fieldName);
            detailsMap.put("description", fieldName);
            detailsMap.put("example", fieldName);
            final EAnnotation eAnnotation = createAnnotation("nsuri",detailsMap);
            eAttribute.getEAnnotations().add(eAnnotation);

            eAttribute.setEType(of(ecsField.getType()));
            eClassToPutFieldsOn.getEStructuralFeatures().add(eAttribute);
        }
    }

    private EAnnotation createAnnotation(String source,Map<String, String> detailsMap) {
        final EAnnotation eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
        eAnnotation.setSource(source);
        eAnnotation.getDetails().putAll(detailsMap);
        return eAnnotation;
    }


    private EClassifier of(String type) {
        return switch (type) {
        case "keyword" -> EcorePackage.Literals.ESTRING;
        case "constant_keyword" -> EcorePackage.Literals.ESTRING;
        case "match_only_text" -> EcorePackage.Literals.ESTRING;
        case "boolean" -> EcorePackage.Literals.EBOOLEAN_OBJECT;
        case "date" -> EcorePackage.Literals.EDATE;
        case "ip" -> EcorePackage.Literals.ESTRING;
        case "long" -> EcorePackage.Literals.ELONG_OBJECT;
        case "float" -> EcorePackage.Literals.EFLOAT_OBJECT;
        case "nested" -> EcorePackage.Literals.EOBJECT;
        case "object" -> EcorePackage.Literals.EOBJECT;
        case "flattened" -> EcorePackage.Literals.EOBJECT;
        case "wildcard" -> EcorePackage.Literals.EOBJECT;
        case "geo_point" -> EcorePackage.Literals.EOBJECT;
        case "source" -> EcorePackage.Literals.EOBJECT;


        case "scaled_float" -> EcorePackage.Literals.EBIG_DECIMAL;


        default -> EcorePackage.Literals.ESTRING;
        };


    }

    private String firstCharUpper(String nestedObjectName) {
        String charOne = nestedObjectName.substring(0, 1).toUpperCase();
        String charOther = nestedObjectName.substring(1);
        String word = charOne + charOther;
        return word;
    }

    private List<EcsClass> listYmlFiles(Path rootFolder) throws IOException {
        List<EcsClass> ymlFiles = Files.walk(rootFolder, 1).parallel().filter(Files::isRegularFile)
                .filter(EcoreGen::ymlFile).flatMap(this::computeYml).toList();
        return ymlFiles;
    }

    private Stream<EcsClass> computeYml(Path path) {
        Yaml yaml = new Yaml(new EcsYmlConstructor());

        try (InputStream is = Files.newInputStream(path, StandardOpenOption.READ)) {
            List<EcsClass> ecsClasses = yaml.load(is);
            return ecsClasses.stream();
        } // closes the Stream
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private EPackage createEcsPackage() {
        final EPackage epackage = EcoreFactory.eINSTANCE.createEPackage();
        epackage.setName("ecs");
        epackage.setNsPrefix("ecs");
        epackage.setNsURI("https://www.daanse.org/schemas/ecs/8");
        return epackage;
    }

    private static boolean ymlFile(Path path) {
        return path.getFileName().toString().endsWith(".yml");
    }
}

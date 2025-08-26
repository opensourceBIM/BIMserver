package org.bimserver.geometry;

import org.bimserver.emf.PackageMetaData;
import org.bimserver.emf.Schema;
import org.bimserver.models.ifc4.Ifc4Package;
import org.bimserver.shared.AbstractHashMapVirtualObject;
import org.bimserver.shared.HashMapVirtualObject;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.util.*;

class StreamingGeometryGeneratorTest {
    private StreamingGeometryGenerator generator;
    private PackageMetaData packageMetaData;

    @BeforeEach
    public void setup(){
        generator = new StreamingGeometryGenerator(null, null, 0L, null);
        generator.packageMetaData = new PackageMetaData(Ifc4Package.eINSTANCE, Schema.IFC4, Paths.get("tmp"));
        packageMetaData = generator.packageMetaData;
    }

    @Test
    void identityMatrix() {
        MockVirtualObject placement = createPlacement(List.of(0., 0., 1.), List.of(1., 0., 0.), List.of(0., 0., 0.));
        Assertions.assertArrayEquals(new double[]{1,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1}, generator.placement3DToMatrix(placement));
    }

    @Test
    void identityNotNormalized() {
        MockVirtualObject placement = createPlacement(List.of(0., 0., 10.), List.of(10., 0., 0.), List.of(0., 0., 0.));
        Assertions.assertArrayEquals(new double[]{1,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1}, generator.placement3DToMatrix(placement));
    }

    @Test
    void identityWithOffset() {
        MockVirtualObject placement = createPlacement(List.of(0., 0., 1.), List.of(1., 0., 0.), List.of(1., 2., 3.));
        Assertions.assertArrayEquals(new double[]{1,0,0,0,0,1,0,0,0,0,1,0,1,2,3,1}, generator.placement3DToMatrix(placement));
    }

    @Test
    void identityNonPerpendicular() {
        MockVirtualObject placement = createPlacement(List.of(0., 0., 1.), List.of(1., 0., 1.), List.of(0., 0., 0.));
        Assertions.assertArrayEquals(new double[]{1,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1}, generator.placement3DToMatrix(placement));
    }

    @Test
    void rotated90z(){
        MockVirtualObject placement = createPlacement(List.of(0., 0., 1.), List.of(0., 1., 0.), List.of(-1., 2., -3.));
        Assertions.assertArrayEquals(new double[]{0,1,0,0,-1,0,0,0,0,0,1,0,-1,2,-3,1}, generator.placement3DToMatrix(placement), 0.0000000001);
    }

    @Test
    void rotated90x(){
        MockVirtualObject placement = createPlacement(List.of(0., 1., 0.), List.of(1., 0., 0.), List.of(0., 0., 0.));
        Assertions.assertArrayEquals(new double[]{1,0,0,0,0,0,-1,0,0,1,0,0,0,0,0,1}, generator.placement3DToMatrix(placement), 0.0000000001);
    }

    @Test
    void rotated45z(){
        MockVirtualObject placement = createPlacement(List.of(0., 0., 1.), List.of(1., 1., 0.), List.of(0., 0., 0.));
        Assertions.assertArrayEquals(new double[]{Math.sqrt(2)/2,Math.sqrt(2)/2,0,0,-Math.sqrt(2)/2,Math.sqrt(2)/2,0,0,0,0,1,0,0,0,0,1}, generator.placement3DToMatrix(placement), 0.0000000001);
    }

    @Test
    void locationOnly(){
        MockVirtualObject placement = createPlacement(null, null, List.of(5.,3.,4.));
        Assertions.assertArrayEquals(new double[]{1,0,0,0,0,1,0,0,0,0,1,0,5,3,4,1}, generator.placement3DToMatrix(placement));
    }

    MockVirtualObject createPlacement(List<Double> axis, List<Double> refDirection, List<Double> location){
        return new MockVirtualObject(new HashMap<>(){{
            if(refDirection!=null) put(packageMetaData.getEReference("IfcAxis2Placement3D", "RefDirection"), new MockVirtualObject(
                    null, null, Map.of("DirectionRatios", refDirection)
            ));
            if(axis!=null) put(packageMetaData.getEReference("IfcAxis2Placement3D", "Axis"), new MockVirtualObject(
                    null, null, Map.of("DirectionRatios", axis)
            ));
            put(packageMetaData.getEReference("IfcPlacement", "Location"), new MockVirtualObject(
                    null, null, Map.of("Coordinates", location)
            ));
        }}, null, null);
    }

   static class MockVirtualObject extends AbstractHashMapVirtualObject {
        Map<EReference, AbstractHashMapVirtualObject> references = new HashMap<EReference, AbstractHashMapVirtualObject>();
        Map<EReference, Set<AbstractHashMapVirtualObject>> listReferences = new HashMap<EReference, Set<AbstractHashMapVirtualObject>>();
        Map<String, Object> attributes = new HashMap<>();


        public MockVirtualObject(Map<EReference, AbstractHashMapVirtualObject> features, Map<EReference, Set<AbstractHashMapVirtualObject>> listFeatures, Map<String, Object> attributes){
            this.references = features;
            this.listReferences = listFeatures;
            this.attributes = attributes;
       }
        @Override
        public EClass eClass() { return null; }

       @Override
       public AbstractHashMapVirtualObject getDirectFeature(EStructuralFeature eStructuralFeature) {
           return references.get(eStructuralFeature);
       }

       @Override
       public Object get(String s) {
           return attributes.get(s);
       }

       @Override
        public Set<HashMapVirtualObject> getDirectListFeature(EStructuralFeature eStructuralFeature) {
            return null; // TODO listReferences.get(eStructuralFeature);
        }

   }

}
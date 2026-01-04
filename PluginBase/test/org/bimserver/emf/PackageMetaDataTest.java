package org.bimserver.emf;

import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc4.Ifc4Package;
import org.bimserver.models.ifc4x3.Ifc4x3Package;
import org.eclipse.emf.ecore.EReference;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;


class PackageMetaDataTest {

    @Test
    void testInverseIfc2x3() {
        PackageMetaData packageMetaData = new PackageMetaData(Schema.IFC2X3TC1.getEPackage(), Schema.IFC2X3TC1, Paths.get("tmp"));
        Ifc2x3tc1Package ifc2x3 = Ifc2x3tc1Package.eINSTANCE;

        // asymmetric inverse
        EReference ifcTerminatorSymbol_annotatedCurve = ifc2x3.getIfcTerminatorSymbol_AnnotatedCurve();
        Assertions.assertTrue(packageMetaData.hasInverse(ifcTerminatorSymbol_annotatedCurve));

        // symmetric 1:1
        EReference ifcDraughtingCalloutRelationship_relatedDraughtingCallout = ifc2x3.getIfcDraughtingCalloutRelationship_RelatedDraughtingCallout();
        Assertions.assertTrue(packageMetaData.hasInverse(ifcDraughtingCalloutRelationship_relatedDraughtingCallout));
        EReference ifcDraughingCalloutRelationship_relatedDraughtingCallout_inverse = packageMetaData.getInverseOrOpposite(ifc2x3.getIfcDraughtingCallout(), ifcDraughtingCalloutRelationship_relatedDraughtingCallout);
        EReference ifcDraughtingCallout_isRelatedFromCallout = ifc2x3.getIfcDraughtingCallout_IsRelatedFromCallout();
        Assertions.assertEquals(ifcDraughtingCallout_isRelatedFromCallout, ifcDraughingCalloutRelationship_relatedDraughtingCallout_inverse);

        EReference ifcRelDefinesByProperties_relatingPropertyDefinition = ifc2x3.getIfcRelDefinesByProperties_RelatingPropertyDefinition();
        Assertions.assertTrue(packageMetaData.hasInverse(ifcRelDefinesByProperties_relatingPropertyDefinition));
        EReference ifcPropertySetDefinition_propertyDefinitionOf = ifc2x3.getIfcPropertySetDefinition_PropertyDefinitionOf();
        EReference ifcRelDefinesByProperties_relatingPropertyDefinition_inv = packageMetaData.getInverseOrOpposite(ifc2x3.getIfcPropertySetDefinition(), ifcRelDefinesByProperties_relatingPropertyDefinition);
        Assertions.assertEquals(ifcPropertySetDefinition_propertyDefinitionOf, ifcRelDefinesByProperties_relatingPropertyDefinition_inv);

        // symmetric 1:M
        EReference ifcRelDefines_relatedObjects = ifc2x3.getIfcRelDefines_RelatedObjects();
        Assertions.assertTrue(packageMetaData.hasInverse(ifcRelDefines_relatedObjects));
        EReference ifcRelDefines_relatedObjects_inv = packageMetaData.getInverseOrOpposite(ifc2x3.getIfcObject(), ifcRelDefines_relatedObjects);
        EReference ifcObject_isDefinedBy = ifc2x3.getIfcObject_IsDefinedBy();
        Assertions.assertEquals(ifcObject_isDefinedBy, ifcRelDefines_relatedObjects_inv);

        // inverse to forward
        Assertions.assertTrue(packageMetaData.isInverse(ifcObject_isDefinedBy));
        EReference ifcObject_isDefinedBy_inv = packageMetaData.getInverseOrOpposite(ifc2x3.getIfcRelDefines(), ifcObject_isDefinedBy);
        Assertions.assertEquals(ifcRelDefines_relatedObjects, ifcObject_isDefinedBy_inv);

        // no inverse
        EReference ifcRepresentation_items = ifc2x3.getIfcRepresentation_Items();
        Assertions.assertFalse(packageMetaData.hasInverse(ifcRepresentation_items));
        Assertions.assertNull(packageMetaData.getInverseOrOpposite(ifc2x3.getIfcRepresentationItem(), ifcRepresentation_items));
    }

    @Test
    void testInverseIfc4() {
        PackageMetaData packageMetaData = new PackageMetaData(Schema.IFC4.getEPackage(), Schema.IFC4, Paths.get("tmp"));
        Ifc4Package ifc4 = Ifc4Package.eINSTANCE;

        EReference externalReferenceRelationship_relatedResourceObjects = ifc4.getIfcExternalReferenceRelationship_RelatedResourceObjects();
        Assertions.assertTrue(packageMetaData.hasInverse(externalReferenceRelationship_relatedResourceObjects));

        EReference fwd = ifc4.getIfcRelDefinesByProperties_RelatedObjects();
        EReference inv1 = ifc4.getIfcContext_IsDefinedBy();
        EReference inv2 = ifc4.getIfcObject_IsDefinedBy();
        Assertions.assertTrue(packageMetaData.hasInverse(fwd));
        Assertions.assertEquals(inv1, packageMetaData.getInverseOrOpposite(ifc4.getIfcContext(), fwd));
        Assertions.assertEquals(inv2, packageMetaData.getInverseOrOpposite(ifc4.getIfcObject(), fwd));
        Assertions.assertTrue(packageMetaData.isInverse(inv1));
        Assertions.assertTrue(packageMetaData.isInverse(inv2));
        Assertions.assertEquals(fwd, packageMetaData.getInverseOrOpposite(ifc4.getIfcRelDefinesByProperties(), inv2));
        Assertions.assertEquals(fwd, packageMetaData.getInverseOrOpposite(ifc4.getIfcRelDefinesByProperties(), inv1));
    }

    @Test
    void testInverseIfc4x3() {
        PackageMetaData packageMetaData = new PackageMetaData(Schema.IFC4X3.getEPackage(), Schema.IFC4X3, Paths.get("tmp"));
        Ifc4x3Package ifc4x3 = Ifc4x3Package.eINSTANCE;

        EReference externalReferenceRelationship_relatedResourceObjects = ifc4x3.getIfcExternalReferenceRelationship_RelatedResourceObjects();
        Assertions.assertTrue(packageMetaData.hasInverse(externalReferenceRelationship_relatedResourceObjects));

        EReference fwd = ifc4x3.getIfcRelDefinesByProperties_RelatedObjects();
        EReference inv1 = ifc4x3.getIfcContext_IsDefinedBy();
        EReference inv2 = ifc4x3.getIfcObject_IsDefinedBy();
        Assertions.assertTrue(packageMetaData.hasInverse(fwd));
        Assertions.assertEquals(inv1, packageMetaData.getInverseOrOpposite(ifc4x3.getIfcContext(), fwd));
        Assertions.assertEquals(inv2, packageMetaData.getInverseOrOpposite(ifc4x3.getIfcObject(), fwd));
        Assertions.assertTrue(packageMetaData.isInverse(inv1));
        Assertions.assertTrue(packageMetaData.isInverse(inv2));
        Assertions.assertEquals(fwd, packageMetaData.getInverseOrOpposite(ifc4x3.getIfcRelDefinesByProperties(), inv1));
        Assertions.assertEquals(fwd, packageMetaData.getInverseOrOpposite(ifc4x3.getIfcRelDefinesByProperties(), inv2));
    }

}
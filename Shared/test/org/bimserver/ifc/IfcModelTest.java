package org.bimserver.ifc;

import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.emf.Schema;
import org.bimserver.models.ifc4.IfcProduct;
import org.bimserver.models.ifc4.IfcProductDefinitionShape;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class IfcModelTest {
    @Test
    public void testFixInversesIfc4() throws IfcModelInterfaceException {
        PackageMetaData packageMetaData = new PackageMetaData(Schema.IFC4.getEPackage(), Schema.IFC4, Paths.get("tmp"));
        IfcModel model = new BasicIfcModel(packageMetaData, null);
        IfcProduct product = model.createAndAdd(IfcProduct.class);
        IfcProductDefinitionShape representation = model.createAndAdd(IfcProductDefinitionShape.class);
        product.setRepresentation(representation);
        assertEquals(0, representation.getShapeOfProduct().size());
        model.fixInverseMismatches();
        assertEquals(1, representation.getShapeOfProduct().size());
        assertEquals(product, representation.getShapeOfProduct().get(0));
    }
    @Test
    public void testFixInversesIfc4x3() throws IfcModelInterfaceException {
        PackageMetaData packageMetaData = new PackageMetaData(Schema.IFC4X3.getEPackage(), Schema.IFC4X3, Paths.get("tmp"));
        IfcModel model = new BasicIfcModel(packageMetaData, null);
        org.bimserver.models.ifc4x3.IfcProduct product = model.createAndAdd(org.bimserver.models.ifc4x3.IfcProduct.class);
        org.bimserver.models.ifc4x3.IfcProductDefinitionShape representation = model.createAndAdd(org.bimserver.models.ifc4x3.IfcProductDefinitionShape.class);
        product.setRepresentation(representation);
        assertEquals(0, representation.getShapeOfProduct().size());
        model.fixInverseMismatches();
        assertEquals(1, representation.getShapeOfProduct().size());
        assertEquals(product, representation.getShapeOfProduct().get(0));
    }
}
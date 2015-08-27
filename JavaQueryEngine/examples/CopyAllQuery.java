package org.bimserver.jqep;

import java.io.PrintWriter;
import java.util.List;

import org.bimserver.models.ifc2x3tc1.IfcBuildingStorey;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.plugins.ModelHelper;
import org.bimserver.plugins.Reporter;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.jqep.*;

public class Query implements QueryInterface {

	@Override
	public void query(IfcModelInterface source, Reporter reporter, ModelHelper modelHelper) throws IfcModelInterfaceException {
        for (IdEObject idEObject : source.getValues()) {
        	modelHelper.copy(idEObject, false);
        }
	}
}
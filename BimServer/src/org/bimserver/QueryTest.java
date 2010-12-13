package org.bimserver;

import java.io.File;

import nl.tue.buildingsmart.express.dictionary.SchemaDefinition;

import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.SchemaLoader;
import org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Package;
import org.bimserver.ifc.file.reader.IfcStepDeserializer;
import org.bimserver.ifc.file.reader.IncorrectIfcFileException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EObjectAttributeValueCondition;
import org.eclipse.emf.query.conditions.numbers.NumberCondition;
import org.eclipse.emf.query.statements.FROM;
import org.eclipse.emf.query.statements.IQueryResult;
import org.eclipse.emf.query.statements.SELECT;
import org.eclipse.emf.query.statements.WHERE;

public class QueryTest {
	public static void main(String[] args) {
		new QueryTest().start();
	}

	private void start() {
		SchemaDefinition schema = SchemaLoader.loadDefaultSchema();
		IfcStepDeserializer deserializer = new IfcStepDeserializer(schema);
		try {
			deserializer.read(new File("..\\TestData\\data\\AC11-Institute-Var-2-IFC.ifc"));
			IfcModel ifcModel = deserializer.getModel();
			SELECT select = new SELECT(10, false, new FROM(ifcModel.getValues()), new WHERE(new EObjectAttributeValueCondition(Ifc2x3Package.eINSTANCE.getIfcWindow_OverallHeight(), new NumberCondition<Integer>(1))), new IProgressMonitor() {
				
				@Override
				public void worked(int arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void subTask(String arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void setTaskName(String arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void setCanceled(boolean arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public boolean isCanceled() {
					// TODO Auto-generated method stub
					return false;
				}
				
				@Override
				public void internalWorked(double arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void done() {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void beginTask(String arg0, int arg1) {
					// TODO Auto-generated method stub
					
				}
			});
			IQueryResult result = select.execute();
			System.out.println(result.getEObjects().size());
		} catch (IncorrectIfcFileException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
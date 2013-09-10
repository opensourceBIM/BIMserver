import org.bimserver.emf.IfcModelInterface;
import org.bimserver.javamodelchecker.JavaModelCheckerInterface;
import org.bimserver.models.ifc2x3tc1.IfcWall;
import org.bimserver.models.store.ModelCheckerResult;
import org.bimserver.models.store.ModelCheckerResultLine;
import org.bimserver.models.store.ModelCheckerResultType;
import org.bimserver.models.store.StoreFactory;

public class Test implements JavaModelCheckerInterface {
	public ModelCheckerResult check(IfcModelInterface model) {
		ModelCheckerResult result = StoreFactory.eINSTANCE.createModelCheckerResult();
		result.setValid(true);
		for (IfcWall ifcWall : model.getAllWithSubTypes(IfcWall.class)) {
			if (ifcWall.getName().equals("")) {
				ModelCheckerResultLine line = StoreFactory.eINSTANCE.createModelCheckerResultLine();
				line.setObjectId(ifcWall.getOid());
				line.setFieldOrClass("name");
				line.setShouldBe("Non empty");
				line.setValue("");
				line.setType(ModelCheckerResultType.ERROR);
				result.getItems().add(line);
				result.setValid(false);
			}
		}
		return result;
	}
}
/**
 * Copyright (C) 2009-2014 BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.bimserver.models.ifc2x3tc1.impl;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcAnalysisModelTypeEnum;
import org.bimserver.models.ifc2x3tc1.IfcAxis2Placement3D;
import org.bimserver.models.ifc2x3tc1.IfcStructuralAnalysisModel;
import org.bimserver.models.ifc2x3tc1.IfcStructuralLoadGroup;
import org.bimserver.models.ifc2x3tc1.IfcStructuralResultGroup;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Structural Analysis Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralAnalysisModelImpl#getPredefinedType <em>Predefined Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralAnalysisModelImpl#getOrientationOf2DPlane <em>Orientation Of2 DPlane</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralAnalysisModelImpl#getLoadedBy <em>Loaded By</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStructuralAnalysisModelImpl#getHasResults <em>Has Results</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcStructuralAnalysisModelImpl extends IfcSystemImpl implements IfcStructuralAnalysisModel {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcStructuralAnalysisModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_ANALYSIS_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAnalysisModelTypeEnum getPredefinedType() {
		return (IfcAnalysisModelTypeEnum) eGet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_ANALYSIS_MODEL__PREDEFINED_TYPE,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPredefinedType(IfcAnalysisModelTypeEnum newPredefinedType) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_ANALYSIS_MODEL__PREDEFINED_TYPE, newPredefinedType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAxis2Placement3D getOrientationOf2DPlane() {
		return (IfcAxis2Placement3D) eGet(
				Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_ANALYSIS_MODEL__ORIENTATION_OF2_DPLANE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrientationOf2DPlane(IfcAxis2Placement3D newOrientationOf2DPlane) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_ANALYSIS_MODEL__ORIENTATION_OF2_DPLANE, newOrientationOf2DPlane);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetOrientationOf2DPlane() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_ANALYSIS_MODEL__ORIENTATION_OF2_DPLANE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOrientationOf2DPlane() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_ANALYSIS_MODEL__ORIENTATION_OF2_DPLANE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcStructuralLoadGroup> getLoadedBy() {
		return (EList<IfcStructuralLoadGroup>) eGet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_ANALYSIS_MODEL__LOADED_BY,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLoadedBy() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_ANALYSIS_MODEL__LOADED_BY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLoadedBy() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_ANALYSIS_MODEL__LOADED_BY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcStructuralResultGroup> getHasResults() {
		return (EList<IfcStructuralResultGroup>) eGet(
				Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_ANALYSIS_MODEL__HAS_RESULTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetHasResults() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_ANALYSIS_MODEL__HAS_RESULTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetHasResults() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STRUCTURAL_ANALYSIS_MODEL__HAS_RESULTS);
	}

} //IfcStructuralAnalysisModelImpl

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
package org.bimserver.models.ifc4x3.impl;

import org.bimserver.models.ifc4x3.Ifc4x3Package;
import org.bimserver.models.ifc4x3.IfcAnalysisModelTypeEnum;
import org.bimserver.models.ifc4x3.IfcAxis2Placement3D;
import org.bimserver.models.ifc4x3.IfcObjectPlacement;
import org.bimserver.models.ifc4x3.IfcStructuralAnalysisModel;
import org.bimserver.models.ifc4x3.IfcStructuralLoadGroup;
import org.bimserver.models.ifc4x3.IfcStructuralResultGroup;

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
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcStructuralAnalysisModelImpl#getPredefinedType <em>Predefined Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcStructuralAnalysisModelImpl#getOrientationOf2DPlane <em>Orientation Of2 DPlane</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcStructuralAnalysisModelImpl#getLoadedBy <em>Loaded By</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcStructuralAnalysisModelImpl#getHasResults <em>Has Results</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcStructuralAnalysisModelImpl#getSharedPlacement <em>Shared Placement</em>}</li>
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
		return Ifc4x3Package.eINSTANCE.getIfcStructuralAnalysisModel();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcAnalysisModelTypeEnum getPredefinedType() {
		return (IfcAnalysisModelTypeEnum) eGet(Ifc4x3Package.eINSTANCE.getIfcStructuralAnalysisModel_PredefinedType(),
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPredefinedType(IfcAnalysisModelTypeEnum newPredefinedType) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcStructuralAnalysisModel_PredefinedType(), newPredefinedType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcAxis2Placement3D getOrientationOf2DPlane() {
		return (IfcAxis2Placement3D) eGet(Ifc4x3Package.eINSTANCE.getIfcStructuralAnalysisModel_OrientationOf2DPlane(),
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOrientationOf2DPlane(IfcAxis2Placement3D newOrientationOf2DPlane) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcStructuralAnalysisModel_OrientationOf2DPlane(), newOrientationOf2DPlane);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetOrientationOf2DPlane() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcStructuralAnalysisModel_OrientationOf2DPlane());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetOrientationOf2DPlane() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcStructuralAnalysisModel_OrientationOf2DPlane());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcStructuralLoadGroup> getLoadedBy() {
		return (EList<IfcStructuralLoadGroup>) eGet(Ifc4x3Package.eINSTANCE.getIfcStructuralAnalysisModel_LoadedBy(),
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLoadedBy() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcStructuralAnalysisModel_LoadedBy());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLoadedBy() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcStructuralAnalysisModel_LoadedBy());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcStructuralResultGroup> getHasResults() {
		return (EList<IfcStructuralResultGroup>) eGet(
				Ifc4x3Package.eINSTANCE.getIfcStructuralAnalysisModel_HasResults(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetHasResults() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcStructuralAnalysisModel_HasResults());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetHasResults() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcStructuralAnalysisModel_HasResults());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcObjectPlacement getSharedPlacement() {
		return (IfcObjectPlacement) eGet(Ifc4x3Package.eINSTANCE.getIfcStructuralAnalysisModel_SharedPlacement(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSharedPlacement(IfcObjectPlacement newSharedPlacement) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcStructuralAnalysisModel_SharedPlacement(), newSharedPlacement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetSharedPlacement() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcStructuralAnalysisModel_SharedPlacement());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetSharedPlacement() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcStructuralAnalysisModel_SharedPlacement());
	}

} //IfcStructuralAnalysisModelImpl

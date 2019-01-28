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
import org.bimserver.models.ifc2x3tc1.IfcGeometricProjectionEnum;
import org.bimserver.models.ifc2x3tc1.IfcGeometricRepresentationContext;
import org.bimserver.models.ifc2x3tc1.IfcGeometricRepresentationSubContext;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Geometric Representation Sub Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcGeometricRepresentationSubContextImpl#getParentContext <em>Parent Context</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcGeometricRepresentationSubContextImpl#getTargetScale <em>Target Scale</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcGeometricRepresentationSubContextImpl#getTargetScaleAsString <em>Target Scale As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcGeometricRepresentationSubContextImpl#getTargetView <em>Target View</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcGeometricRepresentationSubContextImpl#getUserDefinedTargetView <em>User Defined Target View</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcGeometricRepresentationSubContextImpl extends IfcGeometricRepresentationContextImpl
		implements IfcGeometricRepresentationSubContext {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcGeometricRepresentationSubContextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_GEOMETRIC_REPRESENTATION_SUB_CONTEXT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcGeometricRepresentationContext getParentContext() {
		return (IfcGeometricRepresentationContext) eGet(
				Ifc2x3tc1Package.Literals.IFC_GEOMETRIC_REPRESENTATION_SUB_CONTEXT__PARENT_CONTEXT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentContext(IfcGeometricRepresentationContext newParentContext) {
		eSet(Ifc2x3tc1Package.Literals.IFC_GEOMETRIC_REPRESENTATION_SUB_CONTEXT__PARENT_CONTEXT, newParentContext);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getTargetScale() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_GEOMETRIC_REPRESENTATION_SUB_CONTEXT__TARGET_SCALE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetScale(double newTargetScale) {
		eSet(Ifc2x3tc1Package.Literals.IFC_GEOMETRIC_REPRESENTATION_SUB_CONTEXT__TARGET_SCALE, newTargetScale);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTargetScale() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_GEOMETRIC_REPRESENTATION_SUB_CONTEXT__TARGET_SCALE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTargetScale() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_GEOMETRIC_REPRESENTATION_SUB_CONTEXT__TARGET_SCALE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTargetScaleAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_GEOMETRIC_REPRESENTATION_SUB_CONTEXT__TARGET_SCALE_AS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetScaleAsString(String newTargetScaleAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_GEOMETRIC_REPRESENTATION_SUB_CONTEXT__TARGET_SCALE_AS_STRING,
				newTargetScaleAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTargetScaleAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_GEOMETRIC_REPRESENTATION_SUB_CONTEXT__TARGET_SCALE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTargetScaleAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_GEOMETRIC_REPRESENTATION_SUB_CONTEXT__TARGET_SCALE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcGeometricProjectionEnum getTargetView() {
		return (IfcGeometricProjectionEnum) eGet(
				Ifc2x3tc1Package.Literals.IFC_GEOMETRIC_REPRESENTATION_SUB_CONTEXT__TARGET_VIEW, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetView(IfcGeometricProjectionEnum newTargetView) {
		eSet(Ifc2x3tc1Package.Literals.IFC_GEOMETRIC_REPRESENTATION_SUB_CONTEXT__TARGET_VIEW, newTargetView);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUserDefinedTargetView() {
		return (String) eGet(
				Ifc2x3tc1Package.Literals.IFC_GEOMETRIC_REPRESENTATION_SUB_CONTEXT__USER_DEFINED_TARGET_VIEW, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserDefinedTargetView(String newUserDefinedTargetView) {
		eSet(Ifc2x3tc1Package.Literals.IFC_GEOMETRIC_REPRESENTATION_SUB_CONTEXT__USER_DEFINED_TARGET_VIEW,
				newUserDefinedTargetView);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUserDefinedTargetView() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_GEOMETRIC_REPRESENTATION_SUB_CONTEXT__USER_DEFINED_TARGET_VIEW);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUserDefinedTargetView() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_GEOMETRIC_REPRESENTATION_SUB_CONTEXT__USER_DEFINED_TARGET_VIEW);
	}

} //IfcGeometricRepresentationSubContextImpl

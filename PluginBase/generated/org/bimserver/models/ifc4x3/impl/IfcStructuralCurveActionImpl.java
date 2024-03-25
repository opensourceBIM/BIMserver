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
import org.bimserver.models.ifc4x3.IfcProjectedOrTrueLengthEnum;
import org.bimserver.models.ifc4x3.IfcStructuralCurveAction;
import org.bimserver.models.ifc4x3.IfcStructuralCurveActivityTypeEnum;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Structural Curve Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcStructuralCurveActionImpl#getProjectedOrTrue <em>Projected Or True</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcStructuralCurveActionImpl#getPredefinedType <em>Predefined Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcStructuralCurveActionImpl extends IfcStructuralActionImpl implements IfcStructuralCurveAction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcStructuralCurveActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.Literals.IFC_STRUCTURAL_CURVE_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcProjectedOrTrueLengthEnum getProjectedOrTrue() {
		return (IfcProjectedOrTrueLengthEnum) eGet(
				Ifc4x3Package.Literals.IFC_STRUCTURAL_CURVE_ACTION__PROJECTED_OR_TRUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setProjectedOrTrue(IfcProjectedOrTrueLengthEnum newProjectedOrTrue) {
		eSet(Ifc4x3Package.Literals.IFC_STRUCTURAL_CURVE_ACTION__PROJECTED_OR_TRUE, newProjectedOrTrue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetProjectedOrTrue() {
		eUnset(Ifc4x3Package.Literals.IFC_STRUCTURAL_CURVE_ACTION__PROJECTED_OR_TRUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetProjectedOrTrue() {
		return eIsSet(Ifc4x3Package.Literals.IFC_STRUCTURAL_CURVE_ACTION__PROJECTED_OR_TRUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcStructuralCurveActivityTypeEnum getPredefinedType() {
		return (IfcStructuralCurveActivityTypeEnum) eGet(
				Ifc4x3Package.Literals.IFC_STRUCTURAL_CURVE_ACTION__PREDEFINED_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPredefinedType(IfcStructuralCurveActivityTypeEnum newPredefinedType) {
		eSet(Ifc4x3Package.Literals.IFC_STRUCTURAL_CURVE_ACTION__PREDEFINED_TYPE, newPredefinedType);
	}

} //IfcStructuralCurveActionImpl

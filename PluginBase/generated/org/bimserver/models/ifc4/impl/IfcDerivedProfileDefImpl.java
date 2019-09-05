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
package org.bimserver.models.ifc4.impl;

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

import org.bimserver.models.ifc4.Ifc4Package;
import org.bimserver.models.ifc4.IfcCartesianTransformationOperator2D;
import org.bimserver.models.ifc4.IfcDerivedProfileDef;
import org.bimserver.models.ifc4.IfcProfileDef;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Derived Profile Def</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDerivedProfileDefImpl#getParentProfile <em>Parent Profile</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDerivedProfileDefImpl#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcDerivedProfileDefImpl#getLabel <em>Label</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcDerivedProfileDefImpl extends IfcProfileDefImpl implements IfcDerivedProfileDef {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcDerivedProfileDefImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_DERIVED_PROFILE_DEF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcProfileDef getParentProfile() {
		return (IfcProfileDef) eGet(Ifc4Package.Literals.IFC_DERIVED_PROFILE_DEF__PARENT_PROFILE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setParentProfile(IfcProfileDef newParentProfile) {
		eSet(Ifc4Package.Literals.IFC_DERIVED_PROFILE_DEF__PARENT_PROFILE, newParentProfile);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCartesianTransformationOperator2D getOperator() {
		return (IfcCartesianTransformationOperator2D) eGet(Ifc4Package.Literals.IFC_DERIVED_PROFILE_DEF__OPERATOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOperator(IfcCartesianTransformationOperator2D newOperator) {
		eSet(Ifc4Package.Literals.IFC_DERIVED_PROFILE_DEF__OPERATOR, newOperator);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLabel() {
		return (String) eGet(Ifc4Package.Literals.IFC_DERIVED_PROFILE_DEF__LABEL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLabel(String newLabel) {
		eSet(Ifc4Package.Literals.IFC_DERIVED_PROFILE_DEF__LABEL, newLabel);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLabel() {
		eUnset(Ifc4Package.Literals.IFC_DERIVED_PROFILE_DEF__LABEL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLabel() {
		return eIsSet(Ifc4Package.Literals.IFC_DERIVED_PROFILE_DEF__LABEL);
	}

} //IfcDerivedProfileDefImpl

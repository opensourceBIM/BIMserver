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
import org.bimserver.models.ifc4x3.IfcStructuralSurfaceMember;
import org.bimserver.models.ifc4x3.IfcStructuralSurfaceMemberTypeEnum;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Structural Surface Member</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcStructuralSurfaceMemberImpl#getPredefinedType <em>Predefined Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcStructuralSurfaceMemberImpl#getThickness <em>Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcStructuralSurfaceMemberImpl#getThicknessAsString <em>Thickness As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcStructuralSurfaceMemberImpl extends IfcStructuralMemberImpl implements IfcStructuralSurfaceMember {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcStructuralSurfaceMemberImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.Literals.IFC_STRUCTURAL_SURFACE_MEMBER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcStructuralSurfaceMemberTypeEnum getPredefinedType() {
		return (IfcStructuralSurfaceMemberTypeEnum) eGet(
				Ifc4x3Package.Literals.IFC_STRUCTURAL_SURFACE_MEMBER__PREDEFINED_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPredefinedType(IfcStructuralSurfaceMemberTypeEnum newPredefinedType) {
		eSet(Ifc4x3Package.Literals.IFC_STRUCTURAL_SURFACE_MEMBER__PREDEFINED_TYPE, newPredefinedType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getThickness() {
		return (Double) eGet(Ifc4x3Package.Literals.IFC_STRUCTURAL_SURFACE_MEMBER__THICKNESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setThickness(double newThickness) {
		eSet(Ifc4x3Package.Literals.IFC_STRUCTURAL_SURFACE_MEMBER__THICKNESS, newThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetThickness() {
		eUnset(Ifc4x3Package.Literals.IFC_STRUCTURAL_SURFACE_MEMBER__THICKNESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetThickness() {
		return eIsSet(Ifc4x3Package.Literals.IFC_STRUCTURAL_SURFACE_MEMBER__THICKNESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getThicknessAsString() {
		return (String) eGet(Ifc4x3Package.Literals.IFC_STRUCTURAL_SURFACE_MEMBER__THICKNESS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setThicknessAsString(String newThicknessAsString) {
		eSet(Ifc4x3Package.Literals.IFC_STRUCTURAL_SURFACE_MEMBER__THICKNESS_AS_STRING, newThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetThicknessAsString() {
		eUnset(Ifc4x3Package.Literals.IFC_STRUCTURAL_SURFACE_MEMBER__THICKNESS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetThicknessAsString() {
		return eIsSet(Ifc4x3Package.Literals.IFC_STRUCTURAL_SURFACE_MEMBER__THICKNESS_AS_STRING);
	}

} //IfcStructuralSurfaceMemberImpl

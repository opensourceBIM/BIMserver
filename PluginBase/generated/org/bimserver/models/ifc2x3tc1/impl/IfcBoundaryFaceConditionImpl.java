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
import org.bimserver.models.ifc2x3tc1.IfcBoundaryFaceCondition;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Boundary Face Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcBoundaryFaceConditionImpl#getLinearStiffnessByAreaX <em>Linear Stiffness By Area X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcBoundaryFaceConditionImpl#getLinearStiffnessByAreaXAsString <em>Linear Stiffness By Area XAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcBoundaryFaceConditionImpl#getLinearStiffnessByAreaY <em>Linear Stiffness By Area Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcBoundaryFaceConditionImpl#getLinearStiffnessByAreaYAsString <em>Linear Stiffness By Area YAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcBoundaryFaceConditionImpl#getLinearStiffnessByAreaZ <em>Linear Stiffness By Area Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcBoundaryFaceConditionImpl#getLinearStiffnessByAreaZAsString <em>Linear Stiffness By Area ZAs String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcBoundaryFaceConditionImpl extends IfcBoundaryConditionImpl implements IfcBoundaryFaceCondition {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcBoundaryFaceConditionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_BOUNDARY_FACE_CONDITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getLinearStiffnessByAreaX() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_FACE_CONDITION__LINEAR_STIFFNESS_BY_AREA_X, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinearStiffnessByAreaX(double newLinearStiffnessByAreaX) {
		eSet(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_FACE_CONDITION__LINEAR_STIFFNESS_BY_AREA_X,
				newLinearStiffnessByAreaX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLinearStiffnessByAreaX() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_FACE_CONDITION__LINEAR_STIFFNESS_BY_AREA_X);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLinearStiffnessByAreaX() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_FACE_CONDITION__LINEAR_STIFFNESS_BY_AREA_X);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLinearStiffnessByAreaXAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_FACE_CONDITION__LINEAR_STIFFNESS_BY_AREA_XAS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinearStiffnessByAreaXAsString(String newLinearStiffnessByAreaXAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_FACE_CONDITION__LINEAR_STIFFNESS_BY_AREA_XAS_STRING,
				newLinearStiffnessByAreaXAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLinearStiffnessByAreaXAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_FACE_CONDITION__LINEAR_STIFFNESS_BY_AREA_XAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLinearStiffnessByAreaXAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_FACE_CONDITION__LINEAR_STIFFNESS_BY_AREA_XAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getLinearStiffnessByAreaY() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_FACE_CONDITION__LINEAR_STIFFNESS_BY_AREA_Y, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinearStiffnessByAreaY(double newLinearStiffnessByAreaY) {
		eSet(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_FACE_CONDITION__LINEAR_STIFFNESS_BY_AREA_Y,
				newLinearStiffnessByAreaY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLinearStiffnessByAreaY() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_FACE_CONDITION__LINEAR_STIFFNESS_BY_AREA_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLinearStiffnessByAreaY() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_FACE_CONDITION__LINEAR_STIFFNESS_BY_AREA_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLinearStiffnessByAreaYAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_FACE_CONDITION__LINEAR_STIFFNESS_BY_AREA_YAS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinearStiffnessByAreaYAsString(String newLinearStiffnessByAreaYAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_FACE_CONDITION__LINEAR_STIFFNESS_BY_AREA_YAS_STRING,
				newLinearStiffnessByAreaYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLinearStiffnessByAreaYAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_FACE_CONDITION__LINEAR_STIFFNESS_BY_AREA_YAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLinearStiffnessByAreaYAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_FACE_CONDITION__LINEAR_STIFFNESS_BY_AREA_YAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getLinearStiffnessByAreaZ() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_FACE_CONDITION__LINEAR_STIFFNESS_BY_AREA_Z, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinearStiffnessByAreaZ(double newLinearStiffnessByAreaZ) {
		eSet(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_FACE_CONDITION__LINEAR_STIFFNESS_BY_AREA_Z,
				newLinearStiffnessByAreaZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLinearStiffnessByAreaZ() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_FACE_CONDITION__LINEAR_STIFFNESS_BY_AREA_Z);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLinearStiffnessByAreaZ() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_FACE_CONDITION__LINEAR_STIFFNESS_BY_AREA_Z);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLinearStiffnessByAreaZAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_FACE_CONDITION__LINEAR_STIFFNESS_BY_AREA_ZAS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinearStiffnessByAreaZAsString(String newLinearStiffnessByAreaZAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_FACE_CONDITION__LINEAR_STIFFNESS_BY_AREA_ZAS_STRING,
				newLinearStiffnessByAreaZAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLinearStiffnessByAreaZAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_FACE_CONDITION__LINEAR_STIFFNESS_BY_AREA_ZAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLinearStiffnessByAreaZAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_BOUNDARY_FACE_CONDITION__LINEAR_STIFFNESS_BY_AREA_ZAS_STRING);
	}

} //IfcBoundaryFaceConditionImpl

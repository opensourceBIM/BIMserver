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
import org.bimserver.models.ifc4.IfcBoundaryFaceCondition;
import org.bimserver.models.ifc4.IfcModulusOfSubgradeReactionSelect;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Boundary Face Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBoundaryFaceConditionImpl#getTranslationalStiffnessByAreaX <em>Translational Stiffness By Area X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBoundaryFaceConditionImpl#getTranslationalStiffnessByAreaY <em>Translational Stiffness By Area Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcBoundaryFaceConditionImpl#getTranslationalStiffnessByAreaZ <em>Translational Stiffness By Area Z</em>}</li>
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
		return Ifc4Package.Literals.IFC_BOUNDARY_FACE_CONDITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcModulusOfSubgradeReactionSelect getTranslationalStiffnessByAreaX() {
		return (IfcModulusOfSubgradeReactionSelect) eGet(Ifc4Package.Literals.IFC_BOUNDARY_FACE_CONDITION__TRANSLATIONAL_STIFFNESS_BY_AREA_X, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTranslationalStiffnessByAreaX(IfcModulusOfSubgradeReactionSelect newTranslationalStiffnessByAreaX) {
		eSet(Ifc4Package.Literals.IFC_BOUNDARY_FACE_CONDITION__TRANSLATIONAL_STIFFNESS_BY_AREA_X, newTranslationalStiffnessByAreaX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTranslationalStiffnessByAreaX() {
		eUnset(Ifc4Package.Literals.IFC_BOUNDARY_FACE_CONDITION__TRANSLATIONAL_STIFFNESS_BY_AREA_X);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTranslationalStiffnessByAreaX() {
		return eIsSet(Ifc4Package.Literals.IFC_BOUNDARY_FACE_CONDITION__TRANSLATIONAL_STIFFNESS_BY_AREA_X);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcModulusOfSubgradeReactionSelect getTranslationalStiffnessByAreaY() {
		return (IfcModulusOfSubgradeReactionSelect) eGet(Ifc4Package.Literals.IFC_BOUNDARY_FACE_CONDITION__TRANSLATIONAL_STIFFNESS_BY_AREA_Y, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTranslationalStiffnessByAreaY(IfcModulusOfSubgradeReactionSelect newTranslationalStiffnessByAreaY) {
		eSet(Ifc4Package.Literals.IFC_BOUNDARY_FACE_CONDITION__TRANSLATIONAL_STIFFNESS_BY_AREA_Y, newTranslationalStiffnessByAreaY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTranslationalStiffnessByAreaY() {
		eUnset(Ifc4Package.Literals.IFC_BOUNDARY_FACE_CONDITION__TRANSLATIONAL_STIFFNESS_BY_AREA_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTranslationalStiffnessByAreaY() {
		return eIsSet(Ifc4Package.Literals.IFC_BOUNDARY_FACE_CONDITION__TRANSLATIONAL_STIFFNESS_BY_AREA_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcModulusOfSubgradeReactionSelect getTranslationalStiffnessByAreaZ() {
		return (IfcModulusOfSubgradeReactionSelect) eGet(Ifc4Package.Literals.IFC_BOUNDARY_FACE_CONDITION__TRANSLATIONAL_STIFFNESS_BY_AREA_Z, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTranslationalStiffnessByAreaZ(IfcModulusOfSubgradeReactionSelect newTranslationalStiffnessByAreaZ) {
		eSet(Ifc4Package.Literals.IFC_BOUNDARY_FACE_CONDITION__TRANSLATIONAL_STIFFNESS_BY_AREA_Z, newTranslationalStiffnessByAreaZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTranslationalStiffnessByAreaZ() {
		eUnset(Ifc4Package.Literals.IFC_BOUNDARY_FACE_CONDITION__TRANSLATIONAL_STIFFNESS_BY_AREA_Z);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTranslationalStiffnessByAreaZ() {
		return eIsSet(Ifc4Package.Literals.IFC_BOUNDARY_FACE_CONDITION__TRANSLATIONAL_STIFFNESS_BY_AREA_Z);
	}

} //IfcBoundaryFaceConditionImpl

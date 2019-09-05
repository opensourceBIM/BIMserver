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
import org.bimserver.models.ifc4.IfcStructuralLoadLinearForce;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Structural Load Linear Force</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcStructuralLoadLinearForceImpl#getLinearForceX <em>Linear Force X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcStructuralLoadLinearForceImpl#getLinearForceXAsString <em>Linear Force XAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcStructuralLoadLinearForceImpl#getLinearForceY <em>Linear Force Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcStructuralLoadLinearForceImpl#getLinearForceYAsString <em>Linear Force YAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcStructuralLoadLinearForceImpl#getLinearForceZ <em>Linear Force Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcStructuralLoadLinearForceImpl#getLinearForceZAsString <em>Linear Force ZAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcStructuralLoadLinearForceImpl#getLinearMomentX <em>Linear Moment X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcStructuralLoadLinearForceImpl#getLinearMomentXAsString <em>Linear Moment XAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcStructuralLoadLinearForceImpl#getLinearMomentY <em>Linear Moment Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcStructuralLoadLinearForceImpl#getLinearMomentYAsString <em>Linear Moment YAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcStructuralLoadLinearForceImpl#getLinearMomentZ <em>Linear Moment Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcStructuralLoadLinearForceImpl#getLinearMomentZAsString <em>Linear Moment ZAs String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcStructuralLoadLinearForceImpl extends IfcStructuralLoadStaticImpl implements IfcStructuralLoadLinearForce {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcStructuralLoadLinearForceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_LINEAR_FORCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getLinearForceX() {
		return (Double) eGet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_LINEAR_FORCE__LINEAR_FORCE_X, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLinearForceX(double newLinearForceX) {
		eSet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_LINEAR_FORCE__LINEAR_FORCE_X, newLinearForceX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLinearForceX() {
		eUnset(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_LINEAR_FORCE__LINEAR_FORCE_X);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLinearForceX() {
		return eIsSet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_LINEAR_FORCE__LINEAR_FORCE_X);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLinearForceXAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_LINEAR_FORCE__LINEAR_FORCE_XAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLinearForceXAsString(String newLinearForceXAsString) {
		eSet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_LINEAR_FORCE__LINEAR_FORCE_XAS_STRING, newLinearForceXAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLinearForceXAsString() {
		eUnset(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_LINEAR_FORCE__LINEAR_FORCE_XAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLinearForceXAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_LINEAR_FORCE__LINEAR_FORCE_XAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getLinearForceY() {
		return (Double) eGet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_LINEAR_FORCE__LINEAR_FORCE_Y, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLinearForceY(double newLinearForceY) {
		eSet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_LINEAR_FORCE__LINEAR_FORCE_Y, newLinearForceY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLinearForceY() {
		eUnset(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_LINEAR_FORCE__LINEAR_FORCE_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLinearForceY() {
		return eIsSet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_LINEAR_FORCE__LINEAR_FORCE_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLinearForceYAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_LINEAR_FORCE__LINEAR_FORCE_YAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLinearForceYAsString(String newLinearForceYAsString) {
		eSet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_LINEAR_FORCE__LINEAR_FORCE_YAS_STRING, newLinearForceYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLinearForceYAsString() {
		eUnset(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_LINEAR_FORCE__LINEAR_FORCE_YAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLinearForceYAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_LINEAR_FORCE__LINEAR_FORCE_YAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getLinearForceZ() {
		return (Double) eGet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_LINEAR_FORCE__LINEAR_FORCE_Z, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLinearForceZ(double newLinearForceZ) {
		eSet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_LINEAR_FORCE__LINEAR_FORCE_Z, newLinearForceZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLinearForceZ() {
		eUnset(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_LINEAR_FORCE__LINEAR_FORCE_Z);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLinearForceZ() {
		return eIsSet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_LINEAR_FORCE__LINEAR_FORCE_Z);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLinearForceZAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_LINEAR_FORCE__LINEAR_FORCE_ZAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLinearForceZAsString(String newLinearForceZAsString) {
		eSet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_LINEAR_FORCE__LINEAR_FORCE_ZAS_STRING, newLinearForceZAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLinearForceZAsString() {
		eUnset(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_LINEAR_FORCE__LINEAR_FORCE_ZAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLinearForceZAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_LINEAR_FORCE__LINEAR_FORCE_ZAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getLinearMomentX() {
		return (Double) eGet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_LINEAR_FORCE__LINEAR_MOMENT_X, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLinearMomentX(double newLinearMomentX) {
		eSet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_LINEAR_FORCE__LINEAR_MOMENT_X, newLinearMomentX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLinearMomentX() {
		eUnset(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_LINEAR_FORCE__LINEAR_MOMENT_X);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLinearMomentX() {
		return eIsSet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_LINEAR_FORCE__LINEAR_MOMENT_X);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLinearMomentXAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_LINEAR_FORCE__LINEAR_MOMENT_XAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLinearMomentXAsString(String newLinearMomentXAsString) {
		eSet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_LINEAR_FORCE__LINEAR_MOMENT_XAS_STRING, newLinearMomentXAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLinearMomentXAsString() {
		eUnset(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_LINEAR_FORCE__LINEAR_MOMENT_XAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLinearMomentXAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_LINEAR_FORCE__LINEAR_MOMENT_XAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getLinearMomentY() {
		return (Double) eGet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_LINEAR_FORCE__LINEAR_MOMENT_Y, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLinearMomentY(double newLinearMomentY) {
		eSet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_LINEAR_FORCE__LINEAR_MOMENT_Y, newLinearMomentY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLinearMomentY() {
		eUnset(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_LINEAR_FORCE__LINEAR_MOMENT_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLinearMomentY() {
		return eIsSet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_LINEAR_FORCE__LINEAR_MOMENT_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLinearMomentYAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_LINEAR_FORCE__LINEAR_MOMENT_YAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLinearMomentYAsString(String newLinearMomentYAsString) {
		eSet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_LINEAR_FORCE__LINEAR_MOMENT_YAS_STRING, newLinearMomentYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLinearMomentYAsString() {
		eUnset(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_LINEAR_FORCE__LINEAR_MOMENT_YAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLinearMomentYAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_LINEAR_FORCE__LINEAR_MOMENT_YAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getLinearMomentZ() {
		return (Double) eGet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_LINEAR_FORCE__LINEAR_MOMENT_Z, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLinearMomentZ(double newLinearMomentZ) {
		eSet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_LINEAR_FORCE__LINEAR_MOMENT_Z, newLinearMomentZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLinearMomentZ() {
		eUnset(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_LINEAR_FORCE__LINEAR_MOMENT_Z);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLinearMomentZ() {
		return eIsSet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_LINEAR_FORCE__LINEAR_MOMENT_Z);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLinearMomentZAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_LINEAR_FORCE__LINEAR_MOMENT_ZAS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLinearMomentZAsString(String newLinearMomentZAsString) {
		eSet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_LINEAR_FORCE__LINEAR_MOMENT_ZAS_STRING, newLinearMomentZAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLinearMomentZAsString() {
		eUnset(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_LINEAR_FORCE__LINEAR_MOMENT_ZAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLinearMomentZAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_LINEAR_FORCE__LINEAR_MOMENT_ZAS_STRING);
	}

} //IfcStructuralLoadLinearForceImpl

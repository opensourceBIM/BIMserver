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
import org.bimserver.models.ifc2x3tc1.IfcFailureConnectionCondition;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Failure Connection Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcFailureConnectionConditionImpl#getTensionFailureX <em>Tension Failure X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcFailureConnectionConditionImpl#getTensionFailureXAsString <em>Tension Failure XAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcFailureConnectionConditionImpl#getTensionFailureY <em>Tension Failure Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcFailureConnectionConditionImpl#getTensionFailureYAsString <em>Tension Failure YAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcFailureConnectionConditionImpl#getTensionFailureZ <em>Tension Failure Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcFailureConnectionConditionImpl#getTensionFailureZAsString <em>Tension Failure ZAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcFailureConnectionConditionImpl#getCompressionFailureX <em>Compression Failure X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcFailureConnectionConditionImpl#getCompressionFailureXAsString <em>Compression Failure XAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcFailureConnectionConditionImpl#getCompressionFailureY <em>Compression Failure Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcFailureConnectionConditionImpl#getCompressionFailureYAsString <em>Compression Failure YAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcFailureConnectionConditionImpl#getCompressionFailureZ <em>Compression Failure Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcFailureConnectionConditionImpl#getCompressionFailureZAsString <em>Compression Failure ZAs String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcFailureConnectionConditionImpl extends IfcStructuralConnectionConditionImpl
		implements IfcFailureConnectionCondition {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcFailureConnectionConditionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_FAILURE_CONNECTION_CONDITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getTensionFailureX() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_FAILURE_CONNECTION_CONDITION__TENSION_FAILURE_X, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTensionFailureX(double newTensionFailureX) {
		eSet(Ifc2x3tc1Package.Literals.IFC_FAILURE_CONNECTION_CONDITION__TENSION_FAILURE_X, newTensionFailureX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTensionFailureX() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_FAILURE_CONNECTION_CONDITION__TENSION_FAILURE_X);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTensionFailureX() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_FAILURE_CONNECTION_CONDITION__TENSION_FAILURE_X);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTensionFailureXAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_FAILURE_CONNECTION_CONDITION__TENSION_FAILURE_XAS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTensionFailureXAsString(String newTensionFailureXAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_FAILURE_CONNECTION_CONDITION__TENSION_FAILURE_XAS_STRING,
				newTensionFailureXAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTensionFailureXAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_FAILURE_CONNECTION_CONDITION__TENSION_FAILURE_XAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTensionFailureXAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_FAILURE_CONNECTION_CONDITION__TENSION_FAILURE_XAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getTensionFailureY() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_FAILURE_CONNECTION_CONDITION__TENSION_FAILURE_Y, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTensionFailureY(double newTensionFailureY) {
		eSet(Ifc2x3tc1Package.Literals.IFC_FAILURE_CONNECTION_CONDITION__TENSION_FAILURE_Y, newTensionFailureY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTensionFailureY() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_FAILURE_CONNECTION_CONDITION__TENSION_FAILURE_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTensionFailureY() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_FAILURE_CONNECTION_CONDITION__TENSION_FAILURE_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTensionFailureYAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_FAILURE_CONNECTION_CONDITION__TENSION_FAILURE_YAS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTensionFailureYAsString(String newTensionFailureYAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_FAILURE_CONNECTION_CONDITION__TENSION_FAILURE_YAS_STRING,
				newTensionFailureYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTensionFailureYAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_FAILURE_CONNECTION_CONDITION__TENSION_FAILURE_YAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTensionFailureYAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_FAILURE_CONNECTION_CONDITION__TENSION_FAILURE_YAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getTensionFailureZ() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_FAILURE_CONNECTION_CONDITION__TENSION_FAILURE_Z, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTensionFailureZ(double newTensionFailureZ) {
		eSet(Ifc2x3tc1Package.Literals.IFC_FAILURE_CONNECTION_CONDITION__TENSION_FAILURE_Z, newTensionFailureZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTensionFailureZ() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_FAILURE_CONNECTION_CONDITION__TENSION_FAILURE_Z);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTensionFailureZ() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_FAILURE_CONNECTION_CONDITION__TENSION_FAILURE_Z);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTensionFailureZAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_FAILURE_CONNECTION_CONDITION__TENSION_FAILURE_ZAS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTensionFailureZAsString(String newTensionFailureZAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_FAILURE_CONNECTION_CONDITION__TENSION_FAILURE_ZAS_STRING,
				newTensionFailureZAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTensionFailureZAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_FAILURE_CONNECTION_CONDITION__TENSION_FAILURE_ZAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTensionFailureZAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_FAILURE_CONNECTION_CONDITION__TENSION_FAILURE_ZAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getCompressionFailureX() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_FAILURE_CONNECTION_CONDITION__COMPRESSION_FAILURE_X, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompressionFailureX(double newCompressionFailureX) {
		eSet(Ifc2x3tc1Package.Literals.IFC_FAILURE_CONNECTION_CONDITION__COMPRESSION_FAILURE_X, newCompressionFailureX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCompressionFailureX() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_FAILURE_CONNECTION_CONDITION__COMPRESSION_FAILURE_X);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCompressionFailureX() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_FAILURE_CONNECTION_CONDITION__COMPRESSION_FAILURE_X);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCompressionFailureXAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_FAILURE_CONNECTION_CONDITION__COMPRESSION_FAILURE_XAS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompressionFailureXAsString(String newCompressionFailureXAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_FAILURE_CONNECTION_CONDITION__COMPRESSION_FAILURE_XAS_STRING,
				newCompressionFailureXAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCompressionFailureXAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_FAILURE_CONNECTION_CONDITION__COMPRESSION_FAILURE_XAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCompressionFailureXAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_FAILURE_CONNECTION_CONDITION__COMPRESSION_FAILURE_XAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getCompressionFailureY() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_FAILURE_CONNECTION_CONDITION__COMPRESSION_FAILURE_Y, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompressionFailureY(double newCompressionFailureY) {
		eSet(Ifc2x3tc1Package.Literals.IFC_FAILURE_CONNECTION_CONDITION__COMPRESSION_FAILURE_Y, newCompressionFailureY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCompressionFailureY() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_FAILURE_CONNECTION_CONDITION__COMPRESSION_FAILURE_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCompressionFailureY() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_FAILURE_CONNECTION_CONDITION__COMPRESSION_FAILURE_Y);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCompressionFailureYAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_FAILURE_CONNECTION_CONDITION__COMPRESSION_FAILURE_YAS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompressionFailureYAsString(String newCompressionFailureYAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_FAILURE_CONNECTION_CONDITION__COMPRESSION_FAILURE_YAS_STRING,
				newCompressionFailureYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCompressionFailureYAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_FAILURE_CONNECTION_CONDITION__COMPRESSION_FAILURE_YAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCompressionFailureYAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_FAILURE_CONNECTION_CONDITION__COMPRESSION_FAILURE_YAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getCompressionFailureZ() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_FAILURE_CONNECTION_CONDITION__COMPRESSION_FAILURE_Z, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompressionFailureZ(double newCompressionFailureZ) {
		eSet(Ifc2x3tc1Package.Literals.IFC_FAILURE_CONNECTION_CONDITION__COMPRESSION_FAILURE_Z, newCompressionFailureZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCompressionFailureZ() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_FAILURE_CONNECTION_CONDITION__COMPRESSION_FAILURE_Z);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCompressionFailureZ() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_FAILURE_CONNECTION_CONDITION__COMPRESSION_FAILURE_Z);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCompressionFailureZAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_FAILURE_CONNECTION_CONDITION__COMPRESSION_FAILURE_ZAS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompressionFailureZAsString(String newCompressionFailureZAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_FAILURE_CONNECTION_CONDITION__COMPRESSION_FAILURE_ZAS_STRING,
				newCompressionFailureZAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCompressionFailureZAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_FAILURE_CONNECTION_CONDITION__COMPRESSION_FAILURE_ZAS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCompressionFailureZAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_FAILURE_CONNECTION_CONDITION__COMPRESSION_FAILURE_ZAS_STRING);
	}

} //IfcFailureConnectionConditionImpl

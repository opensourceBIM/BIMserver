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
import org.bimserver.models.ifc4x3.IfcStructuralLoadSingleDisplacement;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Structural Load Single Displacement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcStructuralLoadSingleDisplacementImpl#getDisplacementX <em>Displacement X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcStructuralLoadSingleDisplacementImpl#getDisplacementXAsString <em>Displacement XAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcStructuralLoadSingleDisplacementImpl#getDisplacementY <em>Displacement Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcStructuralLoadSingleDisplacementImpl#getDisplacementYAsString <em>Displacement YAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcStructuralLoadSingleDisplacementImpl#getDisplacementZ <em>Displacement Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcStructuralLoadSingleDisplacementImpl#getDisplacementZAsString <em>Displacement ZAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcStructuralLoadSingleDisplacementImpl#getRotationalDisplacementRX <em>Rotational Displacement RX</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcStructuralLoadSingleDisplacementImpl#getRotationalDisplacementRXAsString <em>Rotational Displacement RX As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcStructuralLoadSingleDisplacementImpl#getRotationalDisplacementRY <em>Rotational Displacement RY</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcStructuralLoadSingleDisplacementImpl#getRotationalDisplacementRYAsString <em>Rotational Displacement RY As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcStructuralLoadSingleDisplacementImpl#getRotationalDisplacementRZ <em>Rotational Displacement RZ</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcStructuralLoadSingleDisplacementImpl#getRotationalDisplacementRZAsString <em>Rotational Displacement RZ As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcStructuralLoadSingleDisplacementImpl extends IfcStructuralLoadStaticImpl
		implements IfcStructuralLoadSingleDisplacement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcStructuralLoadSingleDisplacementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getDisplacementX() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_DisplacementX(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDisplacementX(double newDisplacementX) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_DisplacementX(), newDisplacementX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDisplacementX() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_DisplacementX());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDisplacementX() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_DisplacementX());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDisplacementXAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_DisplacementXAsString(),
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDisplacementXAsString(String newDisplacementXAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_DisplacementXAsString(),
				newDisplacementXAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDisplacementXAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_DisplacementXAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDisplacementXAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_DisplacementXAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getDisplacementY() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_DisplacementY(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDisplacementY(double newDisplacementY) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_DisplacementY(), newDisplacementY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDisplacementY() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_DisplacementY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDisplacementY() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_DisplacementY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDisplacementYAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_DisplacementYAsString(),
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDisplacementYAsString(String newDisplacementYAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_DisplacementYAsString(),
				newDisplacementYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDisplacementYAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_DisplacementYAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDisplacementYAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_DisplacementYAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getDisplacementZ() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_DisplacementZ(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDisplacementZ(double newDisplacementZ) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_DisplacementZ(), newDisplacementZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDisplacementZ() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_DisplacementZ());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDisplacementZ() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_DisplacementZ());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDisplacementZAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_DisplacementZAsString(),
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDisplacementZAsString(String newDisplacementZAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_DisplacementZAsString(),
				newDisplacementZAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDisplacementZAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_DisplacementZAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDisplacementZAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_DisplacementZAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getRotationalDisplacementRX() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRX(),
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRotationalDisplacementRX(double newRotationalDisplacementRX) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRX(),
				newRotationalDisplacementRX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetRotationalDisplacementRX() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRX());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRotationalDisplacementRX() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRX());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getRotationalDisplacementRXAsString() {
		return (String) eGet(
				Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRXAsString(),
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRotationalDisplacementRXAsString(String newRotationalDisplacementRXAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRXAsString(),
				newRotationalDisplacementRXAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetRotationalDisplacementRXAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRXAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRotationalDisplacementRXAsString() {
		return eIsSet(
				Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRXAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getRotationalDisplacementRY() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRY(),
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRotationalDisplacementRY(double newRotationalDisplacementRY) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRY(),
				newRotationalDisplacementRY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetRotationalDisplacementRY() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRotationalDisplacementRY() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getRotationalDisplacementRYAsString() {
		return (String) eGet(
				Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRYAsString(),
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRotationalDisplacementRYAsString(String newRotationalDisplacementRYAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRYAsString(),
				newRotationalDisplacementRYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetRotationalDisplacementRYAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRYAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRotationalDisplacementRYAsString() {
		return eIsSet(
				Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRYAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getRotationalDisplacementRZ() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRZ(),
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRotationalDisplacementRZ(double newRotationalDisplacementRZ) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRZ(),
				newRotationalDisplacementRZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetRotationalDisplacementRZ() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRZ());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRotationalDisplacementRZ() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRZ());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getRotationalDisplacementRZAsString() {
		return (String) eGet(
				Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRZAsString(),
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRotationalDisplacementRZAsString(String newRotationalDisplacementRZAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRZAsString(),
				newRotationalDisplacementRZAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetRotationalDisplacementRZAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRZAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRotationalDisplacementRZAsString() {
		return eIsSet(
				Ifc4x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRZAsString());
	}

} //IfcStructuralLoadSingleDisplacementImpl

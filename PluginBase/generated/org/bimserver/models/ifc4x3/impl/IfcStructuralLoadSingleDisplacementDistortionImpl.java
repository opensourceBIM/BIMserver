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
import org.bimserver.models.ifc4x3.IfcStructuralLoadSingleDisplacementDistortion;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Structural Load Single Displacement Distortion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcStructuralLoadSingleDisplacementDistortionImpl#getDistortion <em>Distortion</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcStructuralLoadSingleDisplacementDistortionImpl#getDistortionAsString <em>Distortion As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcStructuralLoadSingleDisplacementDistortionImpl extends IfcStructuralLoadSingleDisplacementImpl
		implements IfcStructuralLoadSingleDisplacementDistortion {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcStructuralLoadSingleDisplacementDistortionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT_DISTORTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getDistortion() {
		return (Double) eGet(Ifc4x3Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT_DISTORTION__DISTORTION,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDistortion(double newDistortion) {
		eSet(Ifc4x3Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT_DISTORTION__DISTORTION, newDistortion);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDistortion() {
		eUnset(Ifc4x3Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT_DISTORTION__DISTORTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDistortion() {
		return eIsSet(Ifc4x3Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT_DISTORTION__DISTORTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDistortionAsString() {
		return (String) eGet(
				Ifc4x3Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT_DISTORTION__DISTORTION_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDistortionAsString(String newDistortionAsString) {
		eSet(Ifc4x3Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT_DISTORTION__DISTORTION_AS_STRING,
				newDistortionAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDistortionAsString() {
		eUnset(Ifc4x3Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT_DISTORTION__DISTORTION_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDistortionAsString() {
		return eIsSet(Ifc4x3Package.Literals.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT_DISTORTION__DISTORTION_AS_STRING);
	}

} //IfcStructuralLoadSingleDisplacementDistortionImpl

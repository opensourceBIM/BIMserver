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
import org.bimserver.models.ifc4.IfcStructuralLoadCase;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Structural Load Case</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcStructuralLoadCaseImpl#getSelfWeightCoefficients <em>Self Weight Coefficients</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcStructuralLoadCaseImpl#getSelfWeightCoefficientsAsString <em>Self Weight Coefficients As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcStructuralLoadCaseImpl extends IfcStructuralLoadGroupImpl implements IfcStructuralLoadCase {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcStructuralLoadCaseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_CASE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Double> getSelfWeightCoefficients() {
		return (EList<Double>) eGet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_CASE__SELF_WEIGHT_COEFFICIENTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetSelfWeightCoefficients() {
		eUnset(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_CASE__SELF_WEIGHT_COEFFICIENTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetSelfWeightCoefficients() {
		return eIsSet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_CASE__SELF_WEIGHT_COEFFICIENTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<String> getSelfWeightCoefficientsAsString() {
		return (EList<String>) eGet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_CASE__SELF_WEIGHT_COEFFICIENTS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetSelfWeightCoefficientsAsString() {
		eUnset(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_CASE__SELF_WEIGHT_COEFFICIENTS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetSelfWeightCoefficientsAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_STRUCTURAL_LOAD_CASE__SELF_WEIGHT_COEFFICIENTS_AS_STRING);
	}

} //IfcStructuralLoadCaseImpl

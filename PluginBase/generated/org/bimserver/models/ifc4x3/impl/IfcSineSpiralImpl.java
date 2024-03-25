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
import org.bimserver.models.ifc4x3.IfcSineSpiral;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Sine Spiral</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcSineSpiralImpl#getSineTerm <em>Sine Term</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcSineSpiralImpl#getSineTermAsString <em>Sine Term As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcSineSpiralImpl#getLinearTerm <em>Linear Term</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcSineSpiralImpl#getLinearTermAsString <em>Linear Term As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcSineSpiralImpl#getConstantTerm <em>Constant Term</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcSineSpiralImpl#getConstantTermAsString <em>Constant Term As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcSineSpiralImpl extends IfcSpiralImpl implements IfcSineSpiral {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcSineSpiralImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.Literals.IFC_SINE_SPIRAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getSineTerm() {
		return (Double) eGet(Ifc4x3Package.Literals.IFC_SINE_SPIRAL__SINE_TERM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSineTerm(double newSineTerm) {
		eSet(Ifc4x3Package.Literals.IFC_SINE_SPIRAL__SINE_TERM, newSineTerm);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSineTermAsString() {
		return (String) eGet(Ifc4x3Package.Literals.IFC_SINE_SPIRAL__SINE_TERM_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSineTermAsString(String newSineTermAsString) {
		eSet(Ifc4x3Package.Literals.IFC_SINE_SPIRAL__SINE_TERM_AS_STRING, newSineTermAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getLinearTerm() {
		return (Double) eGet(Ifc4x3Package.Literals.IFC_SINE_SPIRAL__LINEAR_TERM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLinearTerm(double newLinearTerm) {
		eSet(Ifc4x3Package.Literals.IFC_SINE_SPIRAL__LINEAR_TERM, newLinearTerm);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLinearTerm() {
		eUnset(Ifc4x3Package.Literals.IFC_SINE_SPIRAL__LINEAR_TERM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLinearTerm() {
		return eIsSet(Ifc4x3Package.Literals.IFC_SINE_SPIRAL__LINEAR_TERM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLinearTermAsString() {
		return (String) eGet(Ifc4x3Package.Literals.IFC_SINE_SPIRAL__LINEAR_TERM_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLinearTermAsString(String newLinearTermAsString) {
		eSet(Ifc4x3Package.Literals.IFC_SINE_SPIRAL__LINEAR_TERM_AS_STRING, newLinearTermAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLinearTermAsString() {
		eUnset(Ifc4x3Package.Literals.IFC_SINE_SPIRAL__LINEAR_TERM_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLinearTermAsString() {
		return eIsSet(Ifc4x3Package.Literals.IFC_SINE_SPIRAL__LINEAR_TERM_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getConstantTerm() {
		return (Double) eGet(Ifc4x3Package.Literals.IFC_SINE_SPIRAL__CONSTANT_TERM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setConstantTerm(double newConstantTerm) {
		eSet(Ifc4x3Package.Literals.IFC_SINE_SPIRAL__CONSTANT_TERM, newConstantTerm);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetConstantTerm() {
		eUnset(Ifc4x3Package.Literals.IFC_SINE_SPIRAL__CONSTANT_TERM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetConstantTerm() {
		return eIsSet(Ifc4x3Package.Literals.IFC_SINE_SPIRAL__CONSTANT_TERM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getConstantTermAsString() {
		return (String) eGet(Ifc4x3Package.Literals.IFC_SINE_SPIRAL__CONSTANT_TERM_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setConstantTermAsString(String newConstantTermAsString) {
		eSet(Ifc4x3Package.Literals.IFC_SINE_SPIRAL__CONSTANT_TERM_AS_STRING, newConstantTermAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetConstantTermAsString() {
		eUnset(Ifc4x3Package.Literals.IFC_SINE_SPIRAL__CONSTANT_TERM_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetConstantTermAsString() {
		return eIsSet(Ifc4x3Package.Literals.IFC_SINE_SPIRAL__CONSTANT_TERM_AS_STRING);
	}

} //IfcSineSpiralImpl

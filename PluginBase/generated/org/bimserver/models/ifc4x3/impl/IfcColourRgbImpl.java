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
import org.bimserver.models.ifc4x3.IfcColourRgb;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Colour Rgb</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcColourRgbImpl#getRed <em>Red</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcColourRgbImpl#getRedAsString <em>Red As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcColourRgbImpl#getGreen <em>Green</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcColourRgbImpl#getGreenAsString <em>Green As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcColourRgbImpl#getBlue <em>Blue</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcColourRgbImpl#getBlueAsString <em>Blue As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcColourRgbImpl extends IfcColourSpecificationImpl implements IfcColourRgb {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcColourRgbImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.eINSTANCE.getIfcColourRgb();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getRed() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcColourRgb_Red(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRed(double newRed) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcColourRgb_Red(), newRed);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getRedAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcColourRgb_RedAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRedAsString(String newRedAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcColourRgb_RedAsString(), newRedAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getGreen() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcColourRgb_Green(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGreen(double newGreen) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcColourRgb_Green(), newGreen);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getGreenAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcColourRgb_GreenAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGreenAsString(String newGreenAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcColourRgb_GreenAsString(), newGreenAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getBlue() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcColourRgb_Blue(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBlue(double newBlue) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcColourRgb_Blue(), newBlue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getBlueAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcColourRgb_BlueAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBlueAsString(String newBlueAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcColourRgb_BlueAsString(), newBlueAsString);
	}

} //IfcColourRgbImpl

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
import org.bimserver.models.ifc4.IfcColourRgb;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Colour Rgb</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcColourRgbImpl#getRed <em>Red</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcColourRgbImpl#getRedAsString <em>Red As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcColourRgbImpl#getGreen <em>Green</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcColourRgbImpl#getGreenAsString <em>Green As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcColourRgbImpl#getBlue <em>Blue</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcColourRgbImpl#getBlueAsString <em>Blue As String</em>}</li>
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
		return Ifc4Package.Literals.IFC_COLOUR_RGB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getRed() {
		return (Double) eGet(Ifc4Package.Literals.IFC_COLOUR_RGB__RED, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRed(double newRed) {
		eSet(Ifc4Package.Literals.IFC_COLOUR_RGB__RED, newRed);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getRedAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_COLOUR_RGB__RED_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRedAsString(String newRedAsString) {
		eSet(Ifc4Package.Literals.IFC_COLOUR_RGB__RED_AS_STRING, newRedAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getGreen() {
		return (Double) eGet(Ifc4Package.Literals.IFC_COLOUR_RGB__GREEN, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGreen(double newGreen) {
		eSet(Ifc4Package.Literals.IFC_COLOUR_RGB__GREEN, newGreen);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getGreenAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_COLOUR_RGB__GREEN_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGreenAsString(String newGreenAsString) {
		eSet(Ifc4Package.Literals.IFC_COLOUR_RGB__GREEN_AS_STRING, newGreenAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getBlue() {
		return (Double) eGet(Ifc4Package.Literals.IFC_COLOUR_RGB__BLUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBlue(double newBlue) {
		eSet(Ifc4Package.Literals.IFC_COLOUR_RGB__BLUE, newBlue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getBlueAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_COLOUR_RGB__BLUE_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBlueAsString(String newBlueAsString) {
		eSet(Ifc4Package.Literals.IFC_COLOUR_RGB__BLUE_AS_STRING, newBlueAsString);
	}

} //IfcColourRgbImpl

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
import org.bimserver.models.ifc2x3tc1.IfcRightCircularCone;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Right Circular Cone</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcRightCircularConeImpl#getHeight <em>Height</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcRightCircularConeImpl#getHeightAsString <em>Height As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcRightCircularConeImpl#getBottomRadius <em>Bottom Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcRightCircularConeImpl#getBottomRadiusAsString <em>Bottom Radius As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcRightCircularConeImpl extends IfcCsgPrimitive3DImpl implements IfcRightCircularCone {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRightCircularConeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_RIGHT_CIRCULAR_CONE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getHeight() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_RIGHT_CIRCULAR_CONE__HEIGHT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeight(double newHeight) {
		eSet(Ifc2x3tc1Package.Literals.IFC_RIGHT_CIRCULAR_CONE__HEIGHT, newHeight);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHeightAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_RIGHT_CIRCULAR_CONE__HEIGHT_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeightAsString(String newHeightAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_RIGHT_CIRCULAR_CONE__HEIGHT_AS_STRING, newHeightAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getBottomRadius() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_RIGHT_CIRCULAR_CONE__BOTTOM_RADIUS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBottomRadius(double newBottomRadius) {
		eSet(Ifc2x3tc1Package.Literals.IFC_RIGHT_CIRCULAR_CONE__BOTTOM_RADIUS, newBottomRadius);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBottomRadiusAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_RIGHT_CIRCULAR_CONE__BOTTOM_RADIUS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBottomRadiusAsString(String newBottomRadiusAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_RIGHT_CIRCULAR_CONE__BOTTOM_RADIUS_AS_STRING, newBottomRadiusAsString);
	}

} //IfcRightCircularConeImpl

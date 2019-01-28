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
import org.bimserver.models.ifc2x3tc1.IfcConnectionCurveGeometry;
import org.bimserver.models.ifc2x3tc1.IfcCurveOrEdgeCurve;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Connection Curve Geometry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcConnectionCurveGeometryImpl#getCurveOnRelatingElement <em>Curve On Relating Element</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcConnectionCurveGeometryImpl#getCurveOnRelatedElement <em>Curve On Related Element</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcConnectionCurveGeometryImpl extends IfcConnectionGeometryImpl implements IfcConnectionCurveGeometry {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcConnectionCurveGeometryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_CONNECTION_CURVE_GEOMETRY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCurveOrEdgeCurve getCurveOnRelatingElement() {
		return (IfcCurveOrEdgeCurve) eGet(
				Ifc2x3tc1Package.Literals.IFC_CONNECTION_CURVE_GEOMETRY__CURVE_ON_RELATING_ELEMENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurveOnRelatingElement(IfcCurveOrEdgeCurve newCurveOnRelatingElement) {
		eSet(Ifc2x3tc1Package.Literals.IFC_CONNECTION_CURVE_GEOMETRY__CURVE_ON_RELATING_ELEMENT,
				newCurveOnRelatingElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCurveOrEdgeCurve getCurveOnRelatedElement() {
		return (IfcCurveOrEdgeCurve) eGet(
				Ifc2x3tc1Package.Literals.IFC_CONNECTION_CURVE_GEOMETRY__CURVE_ON_RELATED_ELEMENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurveOnRelatedElement(IfcCurveOrEdgeCurve newCurveOnRelatedElement) {
		eSet(Ifc2x3tc1Package.Literals.IFC_CONNECTION_CURVE_GEOMETRY__CURVE_ON_RELATED_ELEMENT,
				newCurveOnRelatedElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCurveOnRelatedElement() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_CONNECTION_CURVE_GEOMETRY__CURVE_ON_RELATED_ELEMENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCurveOnRelatedElement() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_CONNECTION_CURVE_GEOMETRY__CURVE_ON_RELATED_ELEMENT);
	}

} //IfcConnectionCurveGeometryImpl

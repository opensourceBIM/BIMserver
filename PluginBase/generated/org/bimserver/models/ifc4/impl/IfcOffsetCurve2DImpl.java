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
import org.bimserver.models.ifc4.IfcCurve;
import org.bimserver.models.ifc4.IfcOffsetCurve2D;
import org.bimserver.models.ifc4.Tristate;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Offset Curve2 D</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcOffsetCurve2DImpl#getBasisCurve <em>Basis Curve</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcOffsetCurve2DImpl#getDistance <em>Distance</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcOffsetCurve2DImpl#getDistanceAsString <em>Distance As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcOffsetCurve2DImpl#getSelfIntersect <em>Self Intersect</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcOffsetCurve2DImpl extends IfcCurveImpl implements IfcOffsetCurve2D {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcOffsetCurve2DImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_OFFSET_CURVE2_D;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCurve getBasisCurve() {
		return (IfcCurve) eGet(Ifc4Package.Literals.IFC_OFFSET_CURVE2_D__BASIS_CURVE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBasisCurve(IfcCurve newBasisCurve) {
		eSet(Ifc4Package.Literals.IFC_OFFSET_CURVE2_D__BASIS_CURVE, newBasisCurve);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getDistance() {
		return (Double) eGet(Ifc4Package.Literals.IFC_OFFSET_CURVE2_D__DISTANCE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDistance(double newDistance) {
		eSet(Ifc4Package.Literals.IFC_OFFSET_CURVE2_D__DISTANCE, newDistance);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDistanceAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_OFFSET_CURVE2_D__DISTANCE_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDistanceAsString(String newDistanceAsString) {
		eSet(Ifc4Package.Literals.IFC_OFFSET_CURVE2_D__DISTANCE_AS_STRING, newDistanceAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Tristate getSelfIntersect() {
		return (Tristate) eGet(Ifc4Package.Literals.IFC_OFFSET_CURVE2_D__SELF_INTERSECT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSelfIntersect(Tristate newSelfIntersect) {
		eSet(Ifc4Package.Literals.IFC_OFFSET_CURVE2_D__SELF_INTERSECT, newSelfIntersect);
	}

} //IfcOffsetCurve2DImpl

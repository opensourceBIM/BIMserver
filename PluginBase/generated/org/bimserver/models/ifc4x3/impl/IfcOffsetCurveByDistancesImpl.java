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
import org.bimserver.models.ifc4x3.IfcOffsetCurveByDistances;
import org.bimserver.models.ifc4x3.IfcPointByDistanceExpression;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Offset Curve By Distances</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcOffsetCurveByDistancesImpl#getOffsetValues <em>Offset Values</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcOffsetCurveByDistancesImpl#getTag <em>Tag</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcOffsetCurveByDistancesImpl extends IfcOffsetCurveImpl implements IfcOffsetCurveByDistances {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcOffsetCurveByDistancesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.Literals.IFC_OFFSET_CURVE_BY_DISTANCES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcPointByDistanceExpression> getOffsetValues() {
		return (EList<IfcPointByDistanceExpression>) eGet(
				Ifc4x3Package.Literals.IFC_OFFSET_CURVE_BY_DISTANCES__OFFSET_VALUES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTag() {
		return (String) eGet(Ifc4x3Package.Literals.IFC_OFFSET_CURVE_BY_DISTANCES__TAG, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTag(String newTag) {
		eSet(Ifc4x3Package.Literals.IFC_OFFSET_CURVE_BY_DISTANCES__TAG, newTag);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTag() {
		eUnset(Ifc4x3Package.Literals.IFC_OFFSET_CURVE_BY_DISTANCES__TAG);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTag() {
		return eIsSet(Ifc4x3Package.Literals.IFC_OFFSET_CURVE_BY_DISTANCES__TAG);
	}

} //IfcOffsetCurveByDistancesImpl

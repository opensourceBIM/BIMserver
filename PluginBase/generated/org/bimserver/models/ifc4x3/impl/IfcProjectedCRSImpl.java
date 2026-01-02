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
import org.bimserver.models.ifc4x3.IfcNamedUnit;
import org.bimserver.models.ifc4x3.IfcProjectedCRS;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Projected CRS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcProjectedCRSImpl#getVerticalDatum <em>Vertical Datum</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcProjectedCRSImpl#getMapProjection <em>Map Projection</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcProjectedCRSImpl#getMapZone <em>Map Zone</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcProjectedCRSImpl#getMapUnit <em>Map Unit</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcProjectedCRSImpl extends IfcCoordinateReferenceSystemImpl implements IfcProjectedCRS {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcProjectedCRSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.eINSTANCE.getIfcProjectedCRS();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getVerticalDatum() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcProjectedCRS_VerticalDatum(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVerticalDatum(String newVerticalDatum) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcProjectedCRS_VerticalDatum(), newVerticalDatum);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetVerticalDatum() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcProjectedCRS_VerticalDatum());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetVerticalDatum() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcProjectedCRS_VerticalDatum());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getMapProjection() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcProjectedCRS_MapProjection(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMapProjection(String newMapProjection) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcProjectedCRS_MapProjection(), newMapProjection);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetMapProjection() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcProjectedCRS_MapProjection());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetMapProjection() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcProjectedCRS_MapProjection());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getMapZone() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcProjectedCRS_MapZone(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMapZone(String newMapZone) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcProjectedCRS_MapZone(), newMapZone);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetMapZone() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcProjectedCRS_MapZone());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetMapZone() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcProjectedCRS_MapZone());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcNamedUnit getMapUnit() {
		return (IfcNamedUnit) eGet(Ifc4x3Package.eINSTANCE.getIfcProjectedCRS_MapUnit(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMapUnit(IfcNamedUnit newMapUnit) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcProjectedCRS_MapUnit(), newMapUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetMapUnit() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcProjectedCRS_MapUnit());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetMapUnit() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcProjectedCRS_MapUnit());
	}

} //IfcProjectedCRSImpl

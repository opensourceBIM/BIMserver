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

import org.bimserver.emf.IdEObjectImpl;

import org.bimserver.models.ifc4x3.Ifc4x3Package;
import org.bimserver.models.ifc4x3.IfcCoordinateOperation;
import org.bimserver.models.ifc4x3.IfcCoordinateReferenceSystem;
import org.bimserver.models.ifc4x3.IfcWellKnownText;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Coordinate Reference System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcCoordinateReferenceSystemImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcCoordinateReferenceSystemImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcCoordinateReferenceSystemImpl#getGeodeticDatum <em>Geodetic Datum</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcCoordinateReferenceSystemImpl#getHasCoordinateOperation <em>Has Coordinate Operation</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcCoordinateReferenceSystemImpl#getWellKnownText <em>Well Known Text</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcCoordinateReferenceSystemImpl extends IdEObjectImpl implements IfcCoordinateReferenceSystem {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcCoordinateReferenceSystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.Literals.IFC_COORDINATE_REFERENCE_SYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return (String) eGet(Ifc4x3Package.Literals.IFC_COORDINATE_REFERENCE_SYSTEM__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		eSet(Ifc4x3Package.Literals.IFC_COORDINATE_REFERENCE_SYSTEM__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetName() {
		eUnset(Ifc4x3Package.Literals.IFC_COORDINATE_REFERENCE_SYSTEM__NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetName() {
		return eIsSet(Ifc4x3Package.Literals.IFC_COORDINATE_REFERENCE_SYSTEM__NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescription() {
		return (String) eGet(Ifc4x3Package.Literals.IFC_COORDINATE_REFERENCE_SYSTEM__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		eSet(Ifc4x3Package.Literals.IFC_COORDINATE_REFERENCE_SYSTEM__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetDescription() {
		eUnset(Ifc4x3Package.Literals.IFC_COORDINATE_REFERENCE_SYSTEM__DESCRIPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetDescription() {
		return eIsSet(Ifc4x3Package.Literals.IFC_COORDINATE_REFERENCE_SYSTEM__DESCRIPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getGeodeticDatum() {
		return (String) eGet(Ifc4x3Package.Literals.IFC_COORDINATE_REFERENCE_SYSTEM__GEODETIC_DATUM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGeodeticDatum(String newGeodeticDatum) {
		eSet(Ifc4x3Package.Literals.IFC_COORDINATE_REFERENCE_SYSTEM__GEODETIC_DATUM, newGeodeticDatum);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetGeodeticDatum() {
		eUnset(Ifc4x3Package.Literals.IFC_COORDINATE_REFERENCE_SYSTEM__GEODETIC_DATUM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetGeodeticDatum() {
		return eIsSet(Ifc4x3Package.Literals.IFC_COORDINATE_REFERENCE_SYSTEM__GEODETIC_DATUM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcCoordinateOperation> getHasCoordinateOperation() {
		return (EList<IfcCoordinateOperation>) eGet(
				Ifc4x3Package.Literals.IFC_COORDINATE_REFERENCE_SYSTEM__HAS_COORDINATE_OPERATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetHasCoordinateOperation() {
		eUnset(Ifc4x3Package.Literals.IFC_COORDINATE_REFERENCE_SYSTEM__HAS_COORDINATE_OPERATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetHasCoordinateOperation() {
		return eIsSet(Ifc4x3Package.Literals.IFC_COORDINATE_REFERENCE_SYSTEM__HAS_COORDINATE_OPERATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcWellKnownText> getWellKnownText() {
		return (EList<IfcWellKnownText>) eGet(Ifc4x3Package.Literals.IFC_COORDINATE_REFERENCE_SYSTEM__WELL_KNOWN_TEXT,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetWellKnownText() {
		eUnset(Ifc4x3Package.Literals.IFC_COORDINATE_REFERENCE_SYSTEM__WELL_KNOWN_TEXT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetWellKnownText() {
		return eIsSet(Ifc4x3Package.Literals.IFC_COORDINATE_REFERENCE_SYSTEM__WELL_KNOWN_TEXT);
	}

} //IfcCoordinateReferenceSystemImpl

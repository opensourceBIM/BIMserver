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
import org.bimserver.models.ifc2x3tc1.IfcStairFlight;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Stair Flight</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStairFlightImpl#getNumberOfRiser <em>Number Of Riser</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStairFlightImpl#getNumberOfTreads <em>Number Of Treads</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStairFlightImpl#getRiserHeight <em>Riser Height</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStairFlightImpl#getRiserHeightAsString <em>Riser Height As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStairFlightImpl#getTreadLength <em>Tread Length</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcStairFlightImpl#getTreadLengthAsString <em>Tread Length As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcStairFlightImpl extends IfcBuildingElementImpl implements IfcStairFlight {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcStairFlightImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_STAIR_FLIGHT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getNumberOfRiser() {
		return (Long) eGet(Ifc2x3tc1Package.Literals.IFC_STAIR_FLIGHT__NUMBER_OF_RISER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumberOfRiser(long newNumberOfRiser) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STAIR_FLIGHT__NUMBER_OF_RISER, newNumberOfRiser);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetNumberOfRiser() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STAIR_FLIGHT__NUMBER_OF_RISER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetNumberOfRiser() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STAIR_FLIGHT__NUMBER_OF_RISER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getNumberOfTreads() {
		return (Long) eGet(Ifc2x3tc1Package.Literals.IFC_STAIR_FLIGHT__NUMBER_OF_TREADS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumberOfTreads(long newNumberOfTreads) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STAIR_FLIGHT__NUMBER_OF_TREADS, newNumberOfTreads);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetNumberOfTreads() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STAIR_FLIGHT__NUMBER_OF_TREADS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetNumberOfTreads() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STAIR_FLIGHT__NUMBER_OF_TREADS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getRiserHeight() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_STAIR_FLIGHT__RISER_HEIGHT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRiserHeight(double newRiserHeight) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STAIR_FLIGHT__RISER_HEIGHT, newRiserHeight);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRiserHeight() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STAIR_FLIGHT__RISER_HEIGHT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRiserHeight() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STAIR_FLIGHT__RISER_HEIGHT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRiserHeightAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_STAIR_FLIGHT__RISER_HEIGHT_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRiserHeightAsString(String newRiserHeightAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STAIR_FLIGHT__RISER_HEIGHT_AS_STRING, newRiserHeightAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRiserHeightAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STAIR_FLIGHT__RISER_HEIGHT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRiserHeightAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STAIR_FLIGHT__RISER_HEIGHT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getTreadLength() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_STAIR_FLIGHT__TREAD_LENGTH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTreadLength(double newTreadLength) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STAIR_FLIGHT__TREAD_LENGTH, newTreadLength);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTreadLength() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STAIR_FLIGHT__TREAD_LENGTH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTreadLength() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STAIR_FLIGHT__TREAD_LENGTH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTreadLengthAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_STAIR_FLIGHT__TREAD_LENGTH_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTreadLengthAsString(String newTreadLengthAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_STAIR_FLIGHT__TREAD_LENGTH_AS_STRING, newTreadLengthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTreadLengthAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_STAIR_FLIGHT__TREAD_LENGTH_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTreadLengthAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_STAIR_FLIGHT__TREAD_LENGTH_AS_STRING);
	}

} //IfcStairFlightImpl

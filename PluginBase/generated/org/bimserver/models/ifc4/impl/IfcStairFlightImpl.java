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
import org.bimserver.models.ifc4.IfcStairFlight;
import org.bimserver.models.ifc4.IfcStairFlightTypeEnum;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Stair Flight</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcStairFlightImpl#getNumberOfRisers <em>Number Of Risers</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcStairFlightImpl#getNumberOfTreads <em>Number Of Treads</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcStairFlightImpl#getRiserHeight <em>Riser Height</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcStairFlightImpl#getRiserHeightAsString <em>Riser Height As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcStairFlightImpl#getTreadLength <em>Tread Length</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcStairFlightImpl#getTreadLengthAsString <em>Tread Length As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcStairFlightImpl#getPredefinedType <em>Predefined Type</em>}</li>
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
		return Ifc4Package.Literals.IFC_STAIR_FLIGHT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getNumberOfRisers() {
		return (Long) eGet(Ifc4Package.Literals.IFC_STAIR_FLIGHT__NUMBER_OF_RISERS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNumberOfRisers(long newNumberOfRisers) {
		eSet(Ifc4Package.Literals.IFC_STAIR_FLIGHT__NUMBER_OF_RISERS, newNumberOfRisers);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetNumberOfRisers() {
		eUnset(Ifc4Package.Literals.IFC_STAIR_FLIGHT__NUMBER_OF_RISERS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetNumberOfRisers() {
		return eIsSet(Ifc4Package.Literals.IFC_STAIR_FLIGHT__NUMBER_OF_RISERS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getNumberOfTreads() {
		return (Long) eGet(Ifc4Package.Literals.IFC_STAIR_FLIGHT__NUMBER_OF_TREADS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNumberOfTreads(long newNumberOfTreads) {
		eSet(Ifc4Package.Literals.IFC_STAIR_FLIGHT__NUMBER_OF_TREADS, newNumberOfTreads);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetNumberOfTreads() {
		eUnset(Ifc4Package.Literals.IFC_STAIR_FLIGHT__NUMBER_OF_TREADS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetNumberOfTreads() {
		return eIsSet(Ifc4Package.Literals.IFC_STAIR_FLIGHT__NUMBER_OF_TREADS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getRiserHeight() {
		return (Double) eGet(Ifc4Package.Literals.IFC_STAIR_FLIGHT__RISER_HEIGHT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRiserHeight(double newRiserHeight) {
		eSet(Ifc4Package.Literals.IFC_STAIR_FLIGHT__RISER_HEIGHT, newRiserHeight);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetRiserHeight() {
		eUnset(Ifc4Package.Literals.IFC_STAIR_FLIGHT__RISER_HEIGHT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRiserHeight() {
		return eIsSet(Ifc4Package.Literals.IFC_STAIR_FLIGHT__RISER_HEIGHT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getRiserHeightAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_STAIR_FLIGHT__RISER_HEIGHT_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRiserHeightAsString(String newRiserHeightAsString) {
		eSet(Ifc4Package.Literals.IFC_STAIR_FLIGHT__RISER_HEIGHT_AS_STRING, newRiserHeightAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetRiserHeightAsString() {
		eUnset(Ifc4Package.Literals.IFC_STAIR_FLIGHT__RISER_HEIGHT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRiserHeightAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_STAIR_FLIGHT__RISER_HEIGHT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getTreadLength() {
		return (Double) eGet(Ifc4Package.Literals.IFC_STAIR_FLIGHT__TREAD_LENGTH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTreadLength(double newTreadLength) {
		eSet(Ifc4Package.Literals.IFC_STAIR_FLIGHT__TREAD_LENGTH, newTreadLength);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTreadLength() {
		eUnset(Ifc4Package.Literals.IFC_STAIR_FLIGHT__TREAD_LENGTH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTreadLength() {
		return eIsSet(Ifc4Package.Literals.IFC_STAIR_FLIGHT__TREAD_LENGTH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTreadLengthAsString() {
		return (String) eGet(Ifc4Package.Literals.IFC_STAIR_FLIGHT__TREAD_LENGTH_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTreadLengthAsString(String newTreadLengthAsString) {
		eSet(Ifc4Package.Literals.IFC_STAIR_FLIGHT__TREAD_LENGTH_AS_STRING, newTreadLengthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetTreadLengthAsString() {
		eUnset(Ifc4Package.Literals.IFC_STAIR_FLIGHT__TREAD_LENGTH_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetTreadLengthAsString() {
		return eIsSet(Ifc4Package.Literals.IFC_STAIR_FLIGHT__TREAD_LENGTH_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcStairFlightTypeEnum getPredefinedType() {
		return (IfcStairFlightTypeEnum) eGet(Ifc4Package.Literals.IFC_STAIR_FLIGHT__PREDEFINED_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPredefinedType(IfcStairFlightTypeEnum newPredefinedType) {
		eSet(Ifc4Package.Literals.IFC_STAIR_FLIGHT__PREDEFINED_TYPE, newPredefinedType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPredefinedType() {
		eUnset(Ifc4Package.Literals.IFC_STAIR_FLIGHT__PREDEFINED_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPredefinedType() {
		return eIsSet(Ifc4Package.Literals.IFC_STAIR_FLIGHT__PREDEFINED_TYPE);
	}

} //IfcStairFlightImpl

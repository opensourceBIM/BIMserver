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
import org.bimserver.models.ifc2x3tc1.IfcRelInteractionRequirements;
import org.bimserver.models.ifc2x3tc1.IfcSpaceProgram;
import org.bimserver.models.ifc2x3tc1.IfcSpatialStructureElement;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Space Program</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcSpaceProgramImpl#getSpaceProgramIdentifier <em>Space Program Identifier</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcSpaceProgramImpl#getMaxRequiredArea <em>Max Required Area</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcSpaceProgramImpl#getMaxRequiredAreaAsString <em>Max Required Area As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcSpaceProgramImpl#getMinRequiredArea <em>Min Required Area</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcSpaceProgramImpl#getMinRequiredAreaAsString <em>Min Required Area As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcSpaceProgramImpl#getRequestedLocation <em>Requested Location</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcSpaceProgramImpl#getStandardRequiredArea <em>Standard Required Area</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcSpaceProgramImpl#getStandardRequiredAreaAsString <em>Standard Required Area As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcSpaceProgramImpl#getHasInteractionReqsFrom <em>Has Interaction Reqs From</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcSpaceProgramImpl#getHasInteractionReqsTo <em>Has Interaction Reqs To</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcSpaceProgramImpl extends IfcControlImpl implements IfcSpaceProgram {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcSpaceProgramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_SPACE_PROGRAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSpaceProgramIdentifier() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_SPACE_PROGRAM__SPACE_PROGRAM_IDENTIFIER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpaceProgramIdentifier(String newSpaceProgramIdentifier) {
		eSet(Ifc2x3tc1Package.Literals.IFC_SPACE_PROGRAM__SPACE_PROGRAM_IDENTIFIER, newSpaceProgramIdentifier);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getMaxRequiredArea() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_SPACE_PROGRAM__MAX_REQUIRED_AREA, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxRequiredArea(double newMaxRequiredArea) {
		eSet(Ifc2x3tc1Package.Literals.IFC_SPACE_PROGRAM__MAX_REQUIRED_AREA, newMaxRequiredArea);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMaxRequiredArea() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_SPACE_PROGRAM__MAX_REQUIRED_AREA);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMaxRequiredArea() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_SPACE_PROGRAM__MAX_REQUIRED_AREA);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMaxRequiredAreaAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_SPACE_PROGRAM__MAX_REQUIRED_AREA_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxRequiredAreaAsString(String newMaxRequiredAreaAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_SPACE_PROGRAM__MAX_REQUIRED_AREA_AS_STRING, newMaxRequiredAreaAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMaxRequiredAreaAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_SPACE_PROGRAM__MAX_REQUIRED_AREA_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMaxRequiredAreaAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_SPACE_PROGRAM__MAX_REQUIRED_AREA_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getMinRequiredArea() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_SPACE_PROGRAM__MIN_REQUIRED_AREA, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinRequiredArea(double newMinRequiredArea) {
		eSet(Ifc2x3tc1Package.Literals.IFC_SPACE_PROGRAM__MIN_REQUIRED_AREA, newMinRequiredArea);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMinRequiredArea() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_SPACE_PROGRAM__MIN_REQUIRED_AREA);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMinRequiredArea() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_SPACE_PROGRAM__MIN_REQUIRED_AREA);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMinRequiredAreaAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_SPACE_PROGRAM__MIN_REQUIRED_AREA_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinRequiredAreaAsString(String newMinRequiredAreaAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_SPACE_PROGRAM__MIN_REQUIRED_AREA_AS_STRING, newMinRequiredAreaAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMinRequiredAreaAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_SPACE_PROGRAM__MIN_REQUIRED_AREA_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMinRequiredAreaAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_SPACE_PROGRAM__MIN_REQUIRED_AREA_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSpatialStructureElement getRequestedLocation() {
		return (IfcSpatialStructureElement) eGet(Ifc2x3tc1Package.Literals.IFC_SPACE_PROGRAM__REQUESTED_LOCATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequestedLocation(IfcSpatialStructureElement newRequestedLocation) {
		eSet(Ifc2x3tc1Package.Literals.IFC_SPACE_PROGRAM__REQUESTED_LOCATION, newRequestedLocation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRequestedLocation() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_SPACE_PROGRAM__REQUESTED_LOCATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRequestedLocation() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_SPACE_PROGRAM__REQUESTED_LOCATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getStandardRequiredArea() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_SPACE_PROGRAM__STANDARD_REQUIRED_AREA, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStandardRequiredArea(double newStandardRequiredArea) {
		eSet(Ifc2x3tc1Package.Literals.IFC_SPACE_PROGRAM__STANDARD_REQUIRED_AREA, newStandardRequiredArea);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStandardRequiredAreaAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_SPACE_PROGRAM__STANDARD_REQUIRED_AREA_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStandardRequiredAreaAsString(String newStandardRequiredAreaAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_SPACE_PROGRAM__STANDARD_REQUIRED_AREA_AS_STRING,
				newStandardRequiredAreaAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelInteractionRequirements> getHasInteractionReqsFrom() {
		return (EList<IfcRelInteractionRequirements>) eGet(
				Ifc2x3tc1Package.Literals.IFC_SPACE_PROGRAM__HAS_INTERACTION_REQS_FROM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetHasInteractionReqsFrom() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_SPACE_PROGRAM__HAS_INTERACTION_REQS_FROM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetHasInteractionReqsFrom() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_SPACE_PROGRAM__HAS_INTERACTION_REQS_FROM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelInteractionRequirements> getHasInteractionReqsTo() {
		return (EList<IfcRelInteractionRequirements>) eGet(
				Ifc2x3tc1Package.Literals.IFC_SPACE_PROGRAM__HAS_INTERACTION_REQS_TO, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetHasInteractionReqsTo() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_SPACE_PROGRAM__HAS_INTERACTION_REQS_TO);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetHasInteractionReqsTo() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_SPACE_PROGRAM__HAS_INTERACTION_REQS_TO);
	}

} //IfcSpaceProgramImpl

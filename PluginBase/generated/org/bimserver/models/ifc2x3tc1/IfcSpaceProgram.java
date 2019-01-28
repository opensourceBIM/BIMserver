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
package org.bimserver.models.ifc2x3tc1;

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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Space Program</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcSpaceProgram#getSpaceProgramIdentifier <em>Space Program Identifier</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcSpaceProgram#getMaxRequiredArea <em>Max Required Area</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcSpaceProgram#getMaxRequiredAreaAsString <em>Max Required Area As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcSpaceProgram#getMinRequiredArea <em>Min Required Area</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcSpaceProgram#getMinRequiredAreaAsString <em>Min Required Area As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcSpaceProgram#getRequestedLocation <em>Requested Location</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcSpaceProgram#getStandardRequiredArea <em>Standard Required Area</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcSpaceProgram#getStandardRequiredAreaAsString <em>Standard Required Area As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcSpaceProgram#getHasInteractionReqsFrom <em>Has Interaction Reqs From</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcSpaceProgram#getHasInteractionReqsTo <em>Has Interaction Reqs To</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcSpaceProgram()
 * @model
 * @generated
 */
public interface IfcSpaceProgram extends IfcControl {
	/**
	 * Returns the value of the '<em><b>Space Program Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Space Program Identifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Space Program Identifier</em>' attribute.
	 * @see #setSpaceProgramIdentifier(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcSpaceProgram_SpaceProgramIdentifier()
	 * @model
	 * @generated
	 */
	String getSpaceProgramIdentifier();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSpaceProgram#getSpaceProgramIdentifier <em>Space Program Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Space Program Identifier</em>' attribute.
	 * @see #getSpaceProgramIdentifier()
	 * @generated
	 */
	void setSpaceProgramIdentifier(String value);

	/**
	 * Returns the value of the '<em><b>Max Required Area</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Required Area</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Required Area</em>' attribute.
	 * @see #isSetMaxRequiredArea()
	 * @see #unsetMaxRequiredArea()
	 * @see #setMaxRequiredArea(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcSpaceProgram_MaxRequiredArea()
	 * @model unsettable="true"
	 * @generated
	 */
	double getMaxRequiredArea();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSpaceProgram#getMaxRequiredArea <em>Max Required Area</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Required Area</em>' attribute.
	 * @see #isSetMaxRequiredArea()
	 * @see #unsetMaxRequiredArea()
	 * @see #getMaxRequiredArea()
	 * @generated
	 */
	void setMaxRequiredArea(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSpaceProgram#getMaxRequiredArea <em>Max Required Area</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMaxRequiredArea()
	 * @see #getMaxRequiredArea()
	 * @see #setMaxRequiredArea(double)
	 * @generated
	 */
	void unsetMaxRequiredArea();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSpaceProgram#getMaxRequiredArea <em>Max Required Area</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Max Required Area</em>' attribute is set.
	 * @see #unsetMaxRequiredArea()
	 * @see #getMaxRequiredArea()
	 * @see #setMaxRequiredArea(double)
	 * @generated
	 */
	boolean isSetMaxRequiredArea();

	/**
	 * Returns the value of the '<em><b>Max Required Area As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Required Area As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Required Area As String</em>' attribute.
	 * @see #isSetMaxRequiredAreaAsString()
	 * @see #unsetMaxRequiredAreaAsString()
	 * @see #setMaxRequiredAreaAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcSpaceProgram_MaxRequiredAreaAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getMaxRequiredAreaAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSpaceProgram#getMaxRequiredAreaAsString <em>Max Required Area As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Required Area As String</em>' attribute.
	 * @see #isSetMaxRequiredAreaAsString()
	 * @see #unsetMaxRequiredAreaAsString()
	 * @see #getMaxRequiredAreaAsString()
	 * @generated
	 */
	void setMaxRequiredAreaAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSpaceProgram#getMaxRequiredAreaAsString <em>Max Required Area As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMaxRequiredAreaAsString()
	 * @see #getMaxRequiredAreaAsString()
	 * @see #setMaxRequiredAreaAsString(String)
	 * @generated
	 */
	void unsetMaxRequiredAreaAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSpaceProgram#getMaxRequiredAreaAsString <em>Max Required Area As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Max Required Area As String</em>' attribute is set.
	 * @see #unsetMaxRequiredAreaAsString()
	 * @see #getMaxRequiredAreaAsString()
	 * @see #setMaxRequiredAreaAsString(String)
	 * @generated
	 */
	boolean isSetMaxRequiredAreaAsString();

	/**
	 * Returns the value of the '<em><b>Min Required Area</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Required Area</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Required Area</em>' attribute.
	 * @see #isSetMinRequiredArea()
	 * @see #unsetMinRequiredArea()
	 * @see #setMinRequiredArea(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcSpaceProgram_MinRequiredArea()
	 * @model unsettable="true"
	 * @generated
	 */
	double getMinRequiredArea();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSpaceProgram#getMinRequiredArea <em>Min Required Area</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Required Area</em>' attribute.
	 * @see #isSetMinRequiredArea()
	 * @see #unsetMinRequiredArea()
	 * @see #getMinRequiredArea()
	 * @generated
	 */
	void setMinRequiredArea(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSpaceProgram#getMinRequiredArea <em>Min Required Area</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMinRequiredArea()
	 * @see #getMinRequiredArea()
	 * @see #setMinRequiredArea(double)
	 * @generated
	 */
	void unsetMinRequiredArea();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSpaceProgram#getMinRequiredArea <em>Min Required Area</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Min Required Area</em>' attribute is set.
	 * @see #unsetMinRequiredArea()
	 * @see #getMinRequiredArea()
	 * @see #setMinRequiredArea(double)
	 * @generated
	 */
	boolean isSetMinRequiredArea();

	/**
	 * Returns the value of the '<em><b>Min Required Area As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Required Area As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Required Area As String</em>' attribute.
	 * @see #isSetMinRequiredAreaAsString()
	 * @see #unsetMinRequiredAreaAsString()
	 * @see #setMinRequiredAreaAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcSpaceProgram_MinRequiredAreaAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getMinRequiredAreaAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSpaceProgram#getMinRequiredAreaAsString <em>Min Required Area As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Required Area As String</em>' attribute.
	 * @see #isSetMinRequiredAreaAsString()
	 * @see #unsetMinRequiredAreaAsString()
	 * @see #getMinRequiredAreaAsString()
	 * @generated
	 */
	void setMinRequiredAreaAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSpaceProgram#getMinRequiredAreaAsString <em>Min Required Area As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMinRequiredAreaAsString()
	 * @see #getMinRequiredAreaAsString()
	 * @see #setMinRequiredAreaAsString(String)
	 * @generated
	 */
	void unsetMinRequiredAreaAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSpaceProgram#getMinRequiredAreaAsString <em>Min Required Area As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Min Required Area As String</em>' attribute is set.
	 * @see #unsetMinRequiredAreaAsString()
	 * @see #getMinRequiredAreaAsString()
	 * @see #setMinRequiredAreaAsString(String)
	 * @generated
	 */
	boolean isSetMinRequiredAreaAsString();

	/**
	 * Returns the value of the '<em><b>Requested Location</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requested Location</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requested Location</em>' reference.
	 * @see #isSetRequestedLocation()
	 * @see #unsetRequestedLocation()
	 * @see #setRequestedLocation(IfcSpatialStructureElement)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcSpaceProgram_RequestedLocation()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcSpatialStructureElement getRequestedLocation();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSpaceProgram#getRequestedLocation <em>Requested Location</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Requested Location</em>' reference.
	 * @see #isSetRequestedLocation()
	 * @see #unsetRequestedLocation()
	 * @see #getRequestedLocation()
	 * @generated
	 */
	void setRequestedLocation(IfcSpatialStructureElement value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSpaceProgram#getRequestedLocation <em>Requested Location</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRequestedLocation()
	 * @see #getRequestedLocation()
	 * @see #setRequestedLocation(IfcSpatialStructureElement)
	 * @generated
	 */
	void unsetRequestedLocation();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSpaceProgram#getRequestedLocation <em>Requested Location</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Requested Location</em>' reference is set.
	 * @see #unsetRequestedLocation()
	 * @see #getRequestedLocation()
	 * @see #setRequestedLocation(IfcSpatialStructureElement)
	 * @generated
	 */
	boolean isSetRequestedLocation();

	/**
	 * Returns the value of the '<em><b>Standard Required Area</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Standard Required Area</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Standard Required Area</em>' attribute.
	 * @see #setStandardRequiredArea(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcSpaceProgram_StandardRequiredArea()
	 * @model
	 * @generated
	 */
	double getStandardRequiredArea();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSpaceProgram#getStandardRequiredArea <em>Standard Required Area</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Standard Required Area</em>' attribute.
	 * @see #getStandardRequiredArea()
	 * @generated
	 */
	void setStandardRequiredArea(double value);

	/**
	 * Returns the value of the '<em><b>Standard Required Area As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Standard Required Area As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Standard Required Area As String</em>' attribute.
	 * @see #setStandardRequiredAreaAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcSpaceProgram_StandardRequiredAreaAsString()
	 * @model
	 * @generated
	 */
	String getStandardRequiredAreaAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSpaceProgram#getStandardRequiredAreaAsString <em>Standard Required Area As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Standard Required Area As String</em>' attribute.
	 * @see #getStandardRequiredAreaAsString()
	 * @generated
	 */
	void setStandardRequiredAreaAsString(String value);

	/**
	 * Returns the value of the '<em><b>Has Interaction Reqs From</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcRelInteractionRequirements}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3tc1.IfcRelInteractionRequirements#getRelatedSpaceProgram <em>Related Space Program</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Interaction Reqs From</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Interaction Reqs From</em>' reference list.
	 * @see #isSetHasInteractionReqsFrom()
	 * @see #unsetHasInteractionReqsFrom()
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcSpaceProgram_HasInteractionReqsFrom()
	 * @see org.bimserver.models.ifc2x3tc1.IfcRelInteractionRequirements#getRelatedSpaceProgram
	 * @model opposite="RelatedSpaceProgram" unsettable="true"
	 * @generated
	 */
	EList<IfcRelInteractionRequirements> getHasInteractionReqsFrom();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSpaceProgram#getHasInteractionReqsFrom <em>Has Interaction Reqs From</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetHasInteractionReqsFrom()
	 * @see #getHasInteractionReqsFrom()
	 * @generated
	 */
	void unsetHasInteractionReqsFrom();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSpaceProgram#getHasInteractionReqsFrom <em>Has Interaction Reqs From</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Has Interaction Reqs From</em>' reference list is set.
	 * @see #unsetHasInteractionReqsFrom()
	 * @see #getHasInteractionReqsFrom()
	 * @generated
	 */
	boolean isSetHasInteractionReqsFrom();

	/**
	 * Returns the value of the '<em><b>Has Interaction Reqs To</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcRelInteractionRequirements}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3tc1.IfcRelInteractionRequirements#getRelatingSpaceProgram <em>Relating Space Program</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Interaction Reqs To</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Interaction Reqs To</em>' reference list.
	 * @see #isSetHasInteractionReqsTo()
	 * @see #unsetHasInteractionReqsTo()
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcSpaceProgram_HasInteractionReqsTo()
	 * @see org.bimserver.models.ifc2x3tc1.IfcRelInteractionRequirements#getRelatingSpaceProgram
	 * @model opposite="RelatingSpaceProgram" unsettable="true"
	 * @generated
	 */
	EList<IfcRelInteractionRequirements> getHasInteractionReqsTo();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSpaceProgram#getHasInteractionReqsTo <em>Has Interaction Reqs To</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetHasInteractionReqsTo()
	 * @see #getHasInteractionReqsTo()
	 * @generated
	 */
	void unsetHasInteractionReqsTo();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcSpaceProgram#getHasInteractionReqsTo <em>Has Interaction Reqs To</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Has Interaction Reqs To</em>' reference list is set.
	 * @see #unsetHasInteractionReqsTo()
	 * @see #getHasInteractionReqsTo()
	 * @generated
	 */
	boolean isSetHasInteractionReqsTo();

} // IfcSpaceProgram

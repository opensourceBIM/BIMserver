/**
 *  (c) Copyright bimserver.org 2009
 *  Licensed under GNU GPLv3
 *  http://www.gnu.org/licenses/gpl-3.0.txt
 *  For more information mail to license@bimserver.org
 *  
 *  Bimserver.org is free software: you can redistribute it and/or modify 
 *  it under the terms of the GNU General Public License as published by 
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  Bimserver.org is distributed in the hope that it will be useful, but 
 *  WITHOUT ANY WARRANTY; without even the implied warranty of 
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 *  General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License a 
 *  long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 */
package org.bimserver.models.ifc2x3;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Space Program</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSpaceProgram#getSpaceProgramIdentifier <em>Space Program Identifier</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSpaceProgram#getMaxRequiredArea <em>Max Required Area</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSpaceProgram#getMaxRequiredAreaAsString <em>Max Required Area As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSpaceProgram#getMinRequiredArea <em>Min Required Area</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSpaceProgram#getMinRequiredAreaAsString <em>Min Required Area As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSpaceProgram#getRequestedLocation <em>Requested Location</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSpaceProgram#getStandardRequiredArea <em>Standard Required Area</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSpaceProgram#getStandardRequiredAreaAsString <em>Standard Required Area As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSpaceProgram#getHasInteractionReqsFrom <em>Has Interaction Reqs From</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSpaceProgram#getHasInteractionReqsTo <em>Has Interaction Reqs To</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSpaceProgram()
 * @model
 * @generated
 */
public interface IfcSpaceProgram extends IfcControl
{
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSpaceProgram_SpaceProgramIdentifier()
	 * @model
	 * @generated
	 */
	String getSpaceProgramIdentifier();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcSpaceProgram#getSpaceProgramIdentifier <em>Space Program Identifier</em>}' attribute.
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
	 * @see #setMaxRequiredArea(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSpaceProgram_MaxRequiredArea()
	 * @model unsettable="true"
	 * @generated
	 */
	float getMaxRequiredArea();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcSpaceProgram#getMaxRequiredArea <em>Max Required Area</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Required Area</em>' attribute.
	 * @see #isSetMaxRequiredArea()
	 * @see #unsetMaxRequiredArea()
	 * @see #getMaxRequiredArea()
	 * @generated
	 */
	void setMaxRequiredArea(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcSpaceProgram#getMaxRequiredArea <em>Max Required Area</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMaxRequiredArea()
	 * @see #getMaxRequiredArea()
	 * @see #setMaxRequiredArea(float)
	 * @generated
	 */
	void unsetMaxRequiredArea();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcSpaceProgram#getMaxRequiredArea <em>Max Required Area</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Max Required Area</em>' attribute is set.
	 * @see #unsetMaxRequiredArea()
	 * @see #getMaxRequiredArea()
	 * @see #setMaxRequiredArea(float)
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSpaceProgram_MaxRequiredAreaAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getMaxRequiredAreaAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcSpaceProgram#getMaxRequiredAreaAsString <em>Max Required Area As String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcSpaceProgram#getMaxRequiredAreaAsString <em>Max Required Area As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMaxRequiredAreaAsString()
	 * @see #getMaxRequiredAreaAsString()
	 * @see #setMaxRequiredAreaAsString(String)
	 * @generated
	 */
	void unsetMaxRequiredAreaAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcSpaceProgram#getMaxRequiredAreaAsString <em>Max Required Area As String</em>}' attribute is set.
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
	 * @see #setMinRequiredArea(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSpaceProgram_MinRequiredArea()
	 * @model unsettable="true"
	 * @generated
	 */
	float getMinRequiredArea();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcSpaceProgram#getMinRequiredArea <em>Min Required Area</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Required Area</em>' attribute.
	 * @see #isSetMinRequiredArea()
	 * @see #unsetMinRequiredArea()
	 * @see #getMinRequiredArea()
	 * @generated
	 */
	void setMinRequiredArea(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcSpaceProgram#getMinRequiredArea <em>Min Required Area</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMinRequiredArea()
	 * @see #getMinRequiredArea()
	 * @see #setMinRequiredArea(float)
	 * @generated
	 */
	void unsetMinRequiredArea();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcSpaceProgram#getMinRequiredArea <em>Min Required Area</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Min Required Area</em>' attribute is set.
	 * @see #unsetMinRequiredArea()
	 * @see #getMinRequiredArea()
	 * @see #setMinRequiredArea(float)
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSpaceProgram_MinRequiredAreaAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getMinRequiredAreaAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcSpaceProgram#getMinRequiredAreaAsString <em>Min Required Area As String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcSpaceProgram#getMinRequiredAreaAsString <em>Min Required Area As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMinRequiredAreaAsString()
	 * @see #getMinRequiredAreaAsString()
	 * @see #setMinRequiredAreaAsString(String)
	 * @generated
	 */
	void unsetMinRequiredAreaAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcSpaceProgram#getMinRequiredAreaAsString <em>Min Required Area As String</em>}' attribute is set.
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSpaceProgram_RequestedLocation()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcSpatialStructureElement getRequestedLocation();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcSpaceProgram#getRequestedLocation <em>Requested Location</em>}' reference.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcSpaceProgram#getRequestedLocation <em>Requested Location</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRequestedLocation()
	 * @see #getRequestedLocation()
	 * @see #setRequestedLocation(IfcSpatialStructureElement)
	 * @generated
	 */
	void unsetRequestedLocation();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcSpaceProgram#getRequestedLocation <em>Requested Location</em>}' reference is set.
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
	 * @see #setStandardRequiredArea(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSpaceProgram_StandardRequiredArea()
	 * @model
	 * @generated
	 */
	float getStandardRequiredArea();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcSpaceProgram#getStandardRequiredArea <em>Standard Required Area</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Standard Required Area</em>' attribute.
	 * @see #getStandardRequiredArea()
	 * @generated
	 */
	void setStandardRequiredArea(float value);

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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSpaceProgram_StandardRequiredAreaAsString()
	 * @model
	 * @generated
	 */
	String getStandardRequiredAreaAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcSpaceProgram#getStandardRequiredAreaAsString <em>Standard Required Area As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Standard Required Area As String</em>' attribute.
	 * @see #getStandardRequiredAreaAsString()
	 * @generated
	 */
	void setStandardRequiredAreaAsString(String value);

	/**
	 * Returns the value of the '<em><b>Has Interaction Reqs From</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcRelInteractionRequirements}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcRelInteractionRequirements#getRelatedSpaceProgram <em>Related Space Program</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Interaction Reqs From</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Interaction Reqs From</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSpaceProgram_HasInteractionReqsFrom()
	 * @see org.bimserver.models.ifc2x3.IfcRelInteractionRequirements#getRelatedSpaceProgram
	 * @model opposite="RelatedSpaceProgram"
	 * @generated
	 */
	EList<IfcRelInteractionRequirements> getHasInteractionReqsFrom();

	/**
	 * Returns the value of the '<em><b>Has Interaction Reqs To</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcRelInteractionRequirements}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcRelInteractionRequirements#getRelatingSpaceProgram <em>Relating Space Program</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Interaction Reqs To</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Interaction Reqs To</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSpaceProgram_HasInteractionReqsTo()
	 * @see org.bimserver.models.ifc2x3.IfcRelInteractionRequirements#getRelatingSpaceProgram
	 * @model opposite="RelatingSpaceProgram"
	 * @generated
	 */
	EList<IfcRelInteractionRequirements> getHasInteractionReqsTo();

} // IfcSpaceProgram

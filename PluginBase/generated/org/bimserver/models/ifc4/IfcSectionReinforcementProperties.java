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
package org.bimserver.models.ifc4;

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
 * A representation of the model object '<em><b>Ifc Section Reinforcement Properties</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcSectionReinforcementProperties#getLongitudinalStartPosition <em>Longitudinal Start Position</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcSectionReinforcementProperties#getLongitudinalStartPositionAsString <em>Longitudinal Start Position As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcSectionReinforcementProperties#getLongitudinalEndPosition <em>Longitudinal End Position</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcSectionReinforcementProperties#getLongitudinalEndPositionAsString <em>Longitudinal End Position As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcSectionReinforcementProperties#getTransversePosition <em>Transverse Position</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcSectionReinforcementProperties#getTransversePositionAsString <em>Transverse Position As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcSectionReinforcementProperties#getReinforcementRole <em>Reinforcement Role</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcSectionReinforcementProperties#getSectionDefinition <em>Section Definition</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcSectionReinforcementProperties#getCrossSectionReinforcementDefinitions <em>Cross Section Reinforcement Definitions</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSectionReinforcementProperties()
 * @model
 * @generated
 */
public interface IfcSectionReinforcementProperties extends IfcPreDefinedProperties {
	/**
	 * Returns the value of the '<em><b>Longitudinal Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Longitudinal Start Position</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Longitudinal Start Position</em>' attribute.
	 * @see #setLongitudinalStartPosition(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSectionReinforcementProperties_LongitudinalStartPosition()
	 * @model
	 * @generated
	 */
	double getLongitudinalStartPosition();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcSectionReinforcementProperties#getLongitudinalStartPosition <em>Longitudinal Start Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Longitudinal Start Position</em>' attribute.
	 * @see #getLongitudinalStartPosition()
	 * @generated
	 */
	void setLongitudinalStartPosition(double value);

	/**
	 * Returns the value of the '<em><b>Longitudinal Start Position As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Longitudinal Start Position As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Longitudinal Start Position As String</em>' attribute.
	 * @see #setLongitudinalStartPositionAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSectionReinforcementProperties_LongitudinalStartPositionAsString()
	 * @model annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getLongitudinalStartPositionAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcSectionReinforcementProperties#getLongitudinalStartPositionAsString <em>Longitudinal Start Position As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Longitudinal Start Position As String</em>' attribute.
	 * @see #getLongitudinalStartPositionAsString()
	 * @generated
	 */
	void setLongitudinalStartPositionAsString(String value);

	/**
	 * Returns the value of the '<em><b>Longitudinal End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Longitudinal End Position</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Longitudinal End Position</em>' attribute.
	 * @see #setLongitudinalEndPosition(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSectionReinforcementProperties_LongitudinalEndPosition()
	 * @model
	 * @generated
	 */
	double getLongitudinalEndPosition();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcSectionReinforcementProperties#getLongitudinalEndPosition <em>Longitudinal End Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Longitudinal End Position</em>' attribute.
	 * @see #getLongitudinalEndPosition()
	 * @generated
	 */
	void setLongitudinalEndPosition(double value);

	/**
	 * Returns the value of the '<em><b>Longitudinal End Position As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Longitudinal End Position As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Longitudinal End Position As String</em>' attribute.
	 * @see #setLongitudinalEndPositionAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSectionReinforcementProperties_LongitudinalEndPositionAsString()
	 * @model annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getLongitudinalEndPositionAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcSectionReinforcementProperties#getLongitudinalEndPositionAsString <em>Longitudinal End Position As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Longitudinal End Position As String</em>' attribute.
	 * @see #getLongitudinalEndPositionAsString()
	 * @generated
	 */
	void setLongitudinalEndPositionAsString(String value);

	/**
	 * Returns the value of the '<em><b>Transverse Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transverse Position</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transverse Position</em>' attribute.
	 * @see #isSetTransversePosition()
	 * @see #unsetTransversePosition()
	 * @see #setTransversePosition(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSectionReinforcementProperties_TransversePosition()
	 * @model unsettable="true"
	 * @generated
	 */
	double getTransversePosition();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcSectionReinforcementProperties#getTransversePosition <em>Transverse Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transverse Position</em>' attribute.
	 * @see #isSetTransversePosition()
	 * @see #unsetTransversePosition()
	 * @see #getTransversePosition()
	 * @generated
	 */
	void setTransversePosition(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcSectionReinforcementProperties#getTransversePosition <em>Transverse Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTransversePosition()
	 * @see #getTransversePosition()
	 * @see #setTransversePosition(double)
	 * @generated
	 */
	void unsetTransversePosition();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcSectionReinforcementProperties#getTransversePosition <em>Transverse Position</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Transverse Position</em>' attribute is set.
	 * @see #unsetTransversePosition()
	 * @see #getTransversePosition()
	 * @see #setTransversePosition(double)
	 * @generated
	 */
	boolean isSetTransversePosition();

	/**
	 * Returns the value of the '<em><b>Transverse Position As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transverse Position As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transverse Position As String</em>' attribute.
	 * @see #isSetTransversePositionAsString()
	 * @see #unsetTransversePositionAsString()
	 * @see #setTransversePositionAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSectionReinforcementProperties_TransversePositionAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getTransversePositionAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcSectionReinforcementProperties#getTransversePositionAsString <em>Transverse Position As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transverse Position As String</em>' attribute.
	 * @see #isSetTransversePositionAsString()
	 * @see #unsetTransversePositionAsString()
	 * @see #getTransversePositionAsString()
	 * @generated
	 */
	void setTransversePositionAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcSectionReinforcementProperties#getTransversePositionAsString <em>Transverse Position As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTransversePositionAsString()
	 * @see #getTransversePositionAsString()
	 * @see #setTransversePositionAsString(String)
	 * @generated
	 */
	void unsetTransversePositionAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcSectionReinforcementProperties#getTransversePositionAsString <em>Transverse Position As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Transverse Position As String</em>' attribute is set.
	 * @see #unsetTransversePositionAsString()
	 * @see #getTransversePositionAsString()
	 * @see #setTransversePositionAsString(String)
	 * @generated
	 */
	boolean isSetTransversePositionAsString();

	/**
	 * Returns the value of the '<em><b>Reinforcement Role</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.IfcReinforcingBarRoleEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reinforcement Role</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reinforcement Role</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcReinforcingBarRoleEnum
	 * @see #setReinforcementRole(IfcReinforcingBarRoleEnum)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSectionReinforcementProperties_ReinforcementRole()
	 * @model
	 * @generated
	 */
	IfcReinforcingBarRoleEnum getReinforcementRole();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcSectionReinforcementProperties#getReinforcementRole <em>Reinforcement Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reinforcement Role</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcReinforcingBarRoleEnum
	 * @see #getReinforcementRole()
	 * @generated
	 */
	void setReinforcementRole(IfcReinforcingBarRoleEnum value);

	/**
	 * Returns the value of the '<em><b>Section Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Section Definition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Section Definition</em>' reference.
	 * @see #setSectionDefinition(IfcSectionProperties)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSectionReinforcementProperties_SectionDefinition()
	 * @model
	 * @generated
	 */
	IfcSectionProperties getSectionDefinition();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcSectionReinforcementProperties#getSectionDefinition <em>Section Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Section Definition</em>' reference.
	 * @see #getSectionDefinition()
	 * @generated
	 */
	void setSectionDefinition(IfcSectionProperties value);

	/**
	 * Returns the value of the '<em><b>Cross Section Reinforcement Definitions</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcReinforcementBarProperties}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cross Section Reinforcement Definitions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cross Section Reinforcement Definitions</em>' reference list.
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSectionReinforcementProperties_CrossSectionReinforcementDefinitions()
	 * @model
	 * @generated
	 */
	EList<IfcReinforcementBarProperties> getCrossSectionReinforcementDefinitions();

} // IfcSectionReinforcementProperties

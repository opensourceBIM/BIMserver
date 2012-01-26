/**
 * Copyright (C) 2011  BIMserver.org
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
package org.bimserver.models.ifc2x3;

import org.bimserver.emf.IdEObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Section Reinforcement Properties</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSectionReinforcementProperties#getLongitudinalStartPosition <em>Longitudinal Start Position</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSectionReinforcementProperties#getLongitudinalStartPositionAsString <em>Longitudinal Start Position As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSectionReinforcementProperties#getLongitudinalEndPosition <em>Longitudinal End Position</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSectionReinforcementProperties#getLongitudinalEndPositionAsString <em>Longitudinal End Position As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSectionReinforcementProperties#getTransversePosition <em>Transverse Position</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSectionReinforcementProperties#getTransversePositionAsString <em>Transverse Position As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSectionReinforcementProperties#getReinforcementRole <em>Reinforcement Role</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSectionReinforcementProperties#getSectionDefinition <em>Section Definition</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSectionReinforcementProperties#getCrossSectionReinforcementDefinitions <em>Cross Section Reinforcement Definitions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSectionReinforcementProperties()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface IfcSectionReinforcementProperties extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Longitudinal Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Longitudinal Start Position</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Longitudinal Start Position</em>' attribute.
	 * @see #isSetLongitudinalStartPosition()
	 * @see #unsetLongitudinalStartPosition()
	 * @see #setLongitudinalStartPosition(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSectionReinforcementProperties_LongitudinalStartPosition()
	 * @model unsettable="true"
	 * @generated
	 */
	double getLongitudinalStartPosition();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcSectionReinforcementProperties#getLongitudinalStartPosition <em>Longitudinal Start Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Longitudinal Start Position</em>' attribute.
	 * @see #isSetLongitudinalStartPosition()
	 * @see #unsetLongitudinalStartPosition()
	 * @see #getLongitudinalStartPosition()
	 * @generated
	 */
	void setLongitudinalStartPosition(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcSectionReinforcementProperties#getLongitudinalStartPosition <em>Longitudinal Start Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLongitudinalStartPosition()
	 * @see #getLongitudinalStartPosition()
	 * @see #setLongitudinalStartPosition(double)
	 * @generated
	 */
	void unsetLongitudinalStartPosition();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcSectionReinforcementProperties#getLongitudinalStartPosition <em>Longitudinal Start Position</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Longitudinal Start Position</em>' attribute is set.
	 * @see #unsetLongitudinalStartPosition()
	 * @see #getLongitudinalStartPosition()
	 * @see #setLongitudinalStartPosition(double)
	 * @generated
	 */
	boolean isSetLongitudinalStartPosition();

	/**
	 * Returns the value of the '<em><b>Longitudinal Start Position As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Longitudinal Start Position As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Longitudinal Start Position As String</em>' attribute.
	 * @see #isSetLongitudinalStartPositionAsString()
	 * @see #unsetLongitudinalStartPositionAsString()
	 * @see #setLongitudinalStartPositionAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSectionReinforcementProperties_LongitudinalStartPositionAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getLongitudinalStartPositionAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcSectionReinforcementProperties#getLongitudinalStartPositionAsString <em>Longitudinal Start Position As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Longitudinal Start Position As String</em>' attribute.
	 * @see #isSetLongitudinalStartPositionAsString()
	 * @see #unsetLongitudinalStartPositionAsString()
	 * @see #getLongitudinalStartPositionAsString()
	 * @generated
	 */
	void setLongitudinalStartPositionAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcSectionReinforcementProperties#getLongitudinalStartPositionAsString <em>Longitudinal Start Position As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLongitudinalStartPositionAsString()
	 * @see #getLongitudinalStartPositionAsString()
	 * @see #setLongitudinalStartPositionAsString(String)
	 * @generated
	 */
	void unsetLongitudinalStartPositionAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcSectionReinforcementProperties#getLongitudinalStartPositionAsString <em>Longitudinal Start Position As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Longitudinal Start Position As String</em>' attribute is set.
	 * @see #unsetLongitudinalStartPositionAsString()
	 * @see #getLongitudinalStartPositionAsString()
	 * @see #setLongitudinalStartPositionAsString(String)
	 * @generated
	 */
	boolean isSetLongitudinalStartPositionAsString();

	/**
	 * Returns the value of the '<em><b>Longitudinal End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Longitudinal End Position</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Longitudinal End Position</em>' attribute.
	 * @see #isSetLongitudinalEndPosition()
	 * @see #unsetLongitudinalEndPosition()
	 * @see #setLongitudinalEndPosition(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSectionReinforcementProperties_LongitudinalEndPosition()
	 * @model unsettable="true"
	 * @generated
	 */
	double getLongitudinalEndPosition();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcSectionReinforcementProperties#getLongitudinalEndPosition <em>Longitudinal End Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Longitudinal End Position</em>' attribute.
	 * @see #isSetLongitudinalEndPosition()
	 * @see #unsetLongitudinalEndPosition()
	 * @see #getLongitudinalEndPosition()
	 * @generated
	 */
	void setLongitudinalEndPosition(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcSectionReinforcementProperties#getLongitudinalEndPosition <em>Longitudinal End Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLongitudinalEndPosition()
	 * @see #getLongitudinalEndPosition()
	 * @see #setLongitudinalEndPosition(double)
	 * @generated
	 */
	void unsetLongitudinalEndPosition();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcSectionReinforcementProperties#getLongitudinalEndPosition <em>Longitudinal End Position</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Longitudinal End Position</em>' attribute is set.
	 * @see #unsetLongitudinalEndPosition()
	 * @see #getLongitudinalEndPosition()
	 * @see #setLongitudinalEndPosition(double)
	 * @generated
	 */
	boolean isSetLongitudinalEndPosition();

	/**
	 * Returns the value of the '<em><b>Longitudinal End Position As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Longitudinal End Position As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Longitudinal End Position As String</em>' attribute.
	 * @see #isSetLongitudinalEndPositionAsString()
	 * @see #unsetLongitudinalEndPositionAsString()
	 * @see #setLongitudinalEndPositionAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSectionReinforcementProperties_LongitudinalEndPositionAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getLongitudinalEndPositionAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcSectionReinforcementProperties#getLongitudinalEndPositionAsString <em>Longitudinal End Position As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Longitudinal End Position As String</em>' attribute.
	 * @see #isSetLongitudinalEndPositionAsString()
	 * @see #unsetLongitudinalEndPositionAsString()
	 * @see #getLongitudinalEndPositionAsString()
	 * @generated
	 */
	void setLongitudinalEndPositionAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcSectionReinforcementProperties#getLongitudinalEndPositionAsString <em>Longitudinal End Position As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLongitudinalEndPositionAsString()
	 * @see #getLongitudinalEndPositionAsString()
	 * @see #setLongitudinalEndPositionAsString(String)
	 * @generated
	 */
	void unsetLongitudinalEndPositionAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcSectionReinforcementProperties#getLongitudinalEndPositionAsString <em>Longitudinal End Position As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Longitudinal End Position As String</em>' attribute is set.
	 * @see #unsetLongitudinalEndPositionAsString()
	 * @see #getLongitudinalEndPositionAsString()
	 * @see #setLongitudinalEndPositionAsString(String)
	 * @generated
	 */
	boolean isSetLongitudinalEndPositionAsString();

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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSectionReinforcementProperties_TransversePosition()
	 * @model unsettable="true"
	 * @generated
	 */
	double getTransversePosition();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcSectionReinforcementProperties#getTransversePosition <em>Transverse Position</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcSectionReinforcementProperties#getTransversePosition <em>Transverse Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTransversePosition()
	 * @see #getTransversePosition()
	 * @see #setTransversePosition(double)
	 * @generated
	 */
	void unsetTransversePosition();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcSectionReinforcementProperties#getTransversePosition <em>Transverse Position</em>}' attribute is set.
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSectionReinforcementProperties_TransversePositionAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getTransversePositionAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcSectionReinforcementProperties#getTransversePositionAsString <em>Transverse Position As String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcSectionReinforcementProperties#getTransversePositionAsString <em>Transverse Position As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTransversePositionAsString()
	 * @see #getTransversePositionAsString()
	 * @see #setTransversePositionAsString(String)
	 * @generated
	 */
	void unsetTransversePositionAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcSectionReinforcementProperties#getTransversePositionAsString <em>Transverse Position As String</em>}' attribute is set.
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
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.IfcReinforcingBarRoleEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reinforcement Role</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reinforcement Role</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcReinforcingBarRoleEnum
	 * @see #isSetReinforcementRole()
	 * @see #unsetReinforcementRole()
	 * @see #setReinforcementRole(IfcReinforcingBarRoleEnum)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSectionReinforcementProperties_ReinforcementRole()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcReinforcingBarRoleEnum getReinforcementRole();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcSectionReinforcementProperties#getReinforcementRole <em>Reinforcement Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reinforcement Role</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcReinforcingBarRoleEnum
	 * @see #isSetReinforcementRole()
	 * @see #unsetReinforcementRole()
	 * @see #getReinforcementRole()
	 * @generated
	 */
	void setReinforcementRole(IfcReinforcingBarRoleEnum value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcSectionReinforcementProperties#getReinforcementRole <em>Reinforcement Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetReinforcementRole()
	 * @see #getReinforcementRole()
	 * @see #setReinforcementRole(IfcReinforcingBarRoleEnum)
	 * @generated
	 */
	void unsetReinforcementRole();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcSectionReinforcementProperties#getReinforcementRole <em>Reinforcement Role</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Reinforcement Role</em>' attribute is set.
	 * @see #unsetReinforcementRole()
	 * @see #getReinforcementRole()
	 * @see #setReinforcementRole(IfcReinforcingBarRoleEnum)
	 * @generated
	 */
	boolean isSetReinforcementRole();

	/**
	 * Returns the value of the '<em><b>Section Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Section Definition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Section Definition</em>' reference.
	 * @see #isSetSectionDefinition()
	 * @see #unsetSectionDefinition()
	 * @see #setSectionDefinition(IfcSectionProperties)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSectionReinforcementProperties_SectionDefinition()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcSectionProperties getSectionDefinition();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcSectionReinforcementProperties#getSectionDefinition <em>Section Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Section Definition</em>' reference.
	 * @see #isSetSectionDefinition()
	 * @see #unsetSectionDefinition()
	 * @see #getSectionDefinition()
	 * @generated
	 */
	void setSectionDefinition(IfcSectionProperties value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcSectionReinforcementProperties#getSectionDefinition <em>Section Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSectionDefinition()
	 * @see #getSectionDefinition()
	 * @see #setSectionDefinition(IfcSectionProperties)
	 * @generated
	 */
	void unsetSectionDefinition();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcSectionReinforcementProperties#getSectionDefinition <em>Section Definition</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Section Definition</em>' reference is set.
	 * @see #unsetSectionDefinition()
	 * @see #getSectionDefinition()
	 * @see #setSectionDefinition(IfcSectionProperties)
	 * @generated
	 */
	boolean isSetSectionDefinition();

	/**
	 * Returns the value of the '<em><b>Cross Section Reinforcement Definitions</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcReinforcementBarProperties}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cross Section Reinforcement Definitions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cross Section Reinforcement Definitions</em>' reference list.
	 * @see #isSetCrossSectionReinforcementDefinitions()
	 * @see #unsetCrossSectionReinforcementDefinitions()
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSectionReinforcementProperties_CrossSectionReinforcementDefinitions()
	 * @model unsettable="true"
	 * @generated
	 */
	EList<IfcReinforcementBarProperties> getCrossSectionReinforcementDefinitions();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcSectionReinforcementProperties#getCrossSectionReinforcementDefinitions <em>Cross Section Reinforcement Definitions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCrossSectionReinforcementDefinitions()
	 * @see #getCrossSectionReinforcementDefinitions()
	 * @generated
	 */
	void unsetCrossSectionReinforcementDefinitions();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcSectionReinforcementProperties#getCrossSectionReinforcementDefinitions <em>Cross Section Reinforcement Definitions</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Cross Section Reinforcement Definitions</em>' reference list is set.
	 * @see #unsetCrossSectionReinforcementDefinitions()
	 * @see #getCrossSectionReinforcementDefinitions()
	 * @generated
	 */
	boolean isSetCrossSectionReinforcementDefinitions();

} // IfcSectionReinforcementProperties

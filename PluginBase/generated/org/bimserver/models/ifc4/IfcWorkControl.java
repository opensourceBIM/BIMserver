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
 * A representation of the model object '<em><b>Ifc Work Control</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcWorkControl#getCreationDate <em>Creation Date</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcWorkControl#getCreators <em>Creators</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcWorkControl#getPurpose <em>Purpose</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcWorkControl#getDuration <em>Duration</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcWorkControl#getTotalFloat <em>Total Float</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcWorkControl#getStartTime <em>Start Time</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcWorkControl#getFinishTime <em>Finish Time</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcWorkControl()
 * @model
 * @generated
 */
public interface IfcWorkControl extends IfcControl {
	/**
	 * Returns the value of the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Creation Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Creation Date</em>' attribute.
	 * @see #setCreationDate(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcWorkControl_CreationDate()
	 * @model
	 * @generated
	 */
	String getCreationDate();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcWorkControl#getCreationDate <em>Creation Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Creation Date</em>' attribute.
	 * @see #getCreationDate()
	 * @generated
	 */
	void setCreationDate(String value);

	/**
	 * Returns the value of the '<em><b>Creators</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcPerson}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Creators</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Creators</em>' reference list.
	 * @see #isSetCreators()
	 * @see #unsetCreators()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcWorkControl_Creators()
	 * @model unsettable="true"
	 * @generated
	 */
	EList<IfcPerson> getCreators();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcWorkControl#getCreators <em>Creators</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCreators()
	 * @see #getCreators()
	 * @generated
	 */
	void unsetCreators();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcWorkControl#getCreators <em>Creators</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Creators</em>' reference list is set.
	 * @see #unsetCreators()
	 * @see #getCreators()
	 * @generated
	 */
	boolean isSetCreators();

	/**
	 * Returns the value of the '<em><b>Purpose</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Purpose</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Purpose</em>' attribute.
	 * @see #isSetPurpose()
	 * @see #unsetPurpose()
	 * @see #setPurpose(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcWorkControl_Purpose()
	 * @model unsettable="true"
	 * @generated
	 */
	String getPurpose();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcWorkControl#getPurpose <em>Purpose</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Purpose</em>' attribute.
	 * @see #isSetPurpose()
	 * @see #unsetPurpose()
	 * @see #getPurpose()
	 * @generated
	 */
	void setPurpose(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcWorkControl#getPurpose <em>Purpose</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPurpose()
	 * @see #getPurpose()
	 * @see #setPurpose(String)
	 * @generated
	 */
	void unsetPurpose();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcWorkControl#getPurpose <em>Purpose</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Purpose</em>' attribute is set.
	 * @see #unsetPurpose()
	 * @see #getPurpose()
	 * @see #setPurpose(String)
	 * @generated
	 */
	boolean isSetPurpose();

	/**
	 * Returns the value of the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Duration</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Duration</em>' attribute.
	 * @see #isSetDuration()
	 * @see #unsetDuration()
	 * @see #setDuration(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcWorkControl_Duration()
	 * @model unsettable="true"
	 * @generated
	 */
	String getDuration();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcWorkControl#getDuration <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Duration</em>' attribute.
	 * @see #isSetDuration()
	 * @see #unsetDuration()
	 * @see #getDuration()
	 * @generated
	 */
	void setDuration(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcWorkControl#getDuration <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDuration()
	 * @see #getDuration()
	 * @see #setDuration(String)
	 * @generated
	 */
	void unsetDuration();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcWorkControl#getDuration <em>Duration</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Duration</em>' attribute is set.
	 * @see #unsetDuration()
	 * @see #getDuration()
	 * @see #setDuration(String)
	 * @generated
	 */
	boolean isSetDuration();

	/**
	 * Returns the value of the '<em><b>Total Float</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Total Float</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Float</em>' attribute.
	 * @see #isSetTotalFloat()
	 * @see #unsetTotalFloat()
	 * @see #setTotalFloat(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcWorkControl_TotalFloat()
	 * @model unsettable="true"
	 * @generated
	 */
	String getTotalFloat();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcWorkControl#getTotalFloat <em>Total Float</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Float</em>' attribute.
	 * @see #isSetTotalFloat()
	 * @see #unsetTotalFloat()
	 * @see #getTotalFloat()
	 * @generated
	 */
	void setTotalFloat(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcWorkControl#getTotalFloat <em>Total Float</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTotalFloat()
	 * @see #getTotalFloat()
	 * @see #setTotalFloat(String)
	 * @generated
	 */
	void unsetTotalFloat();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcWorkControl#getTotalFloat <em>Total Float</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Total Float</em>' attribute is set.
	 * @see #unsetTotalFloat()
	 * @see #getTotalFloat()
	 * @see #setTotalFloat(String)
	 * @generated
	 */
	boolean isSetTotalFloat();

	/**
	 * Returns the value of the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Time</em>' attribute.
	 * @see #setStartTime(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcWorkControl_StartTime()
	 * @model
	 * @generated
	 */
	String getStartTime();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcWorkControl#getStartTime <em>Start Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Time</em>' attribute.
	 * @see #getStartTime()
	 * @generated
	 */
	void setStartTime(String value);

	/**
	 * Returns the value of the '<em><b>Finish Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Finish Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Finish Time</em>' attribute.
	 * @see #isSetFinishTime()
	 * @see #unsetFinishTime()
	 * @see #setFinishTime(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcWorkControl_FinishTime()
	 * @model unsettable="true"
	 * @generated
	 */
	String getFinishTime();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcWorkControl#getFinishTime <em>Finish Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Finish Time</em>' attribute.
	 * @see #isSetFinishTime()
	 * @see #unsetFinishTime()
	 * @see #getFinishTime()
	 * @generated
	 */
	void setFinishTime(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcWorkControl#getFinishTime <em>Finish Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFinishTime()
	 * @see #getFinishTime()
	 * @see #setFinishTime(String)
	 * @generated
	 */
	void unsetFinishTime();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcWorkControl#getFinishTime <em>Finish Time</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Finish Time</em>' attribute is set.
	 * @see #unsetFinishTime()
	 * @see #getFinishTime()
	 * @see #setFinishTime(String)
	 * @generated
	 */
	boolean isSetFinishTime();

} // IfcWorkControl

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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Relaxation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRelaxation#getRelaxationValue <em>Relaxation Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRelaxation#getRelaxationValueAsString <em>Relaxation Value As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRelaxation#getInitialStress <em>Initial Stress</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRelaxation#getInitialStressAsString <em>Initial Stress As String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelaxation()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface IfcRelaxation extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Relaxation Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relaxation Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relaxation Value</em>' attribute.
	 * @see #isSetRelaxationValue()
	 * @see #unsetRelaxationValue()
	 * @see #setRelaxationValue(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelaxation_RelaxationValue()
	 * @model unsettable="true"
	 * @generated
	 */
	double getRelaxationValue();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelaxation#getRelaxationValue <em>Relaxation Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relaxation Value</em>' attribute.
	 * @see #isSetRelaxationValue()
	 * @see #unsetRelaxationValue()
	 * @see #getRelaxationValue()
	 * @generated
	 */
	void setRelaxationValue(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelaxation#getRelaxationValue <em>Relaxation Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRelaxationValue()
	 * @see #getRelaxationValue()
	 * @see #setRelaxationValue(double)
	 * @generated
	 */
	void unsetRelaxationValue();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRelaxation#getRelaxationValue <em>Relaxation Value</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Relaxation Value</em>' attribute is set.
	 * @see #unsetRelaxationValue()
	 * @see #getRelaxationValue()
	 * @see #setRelaxationValue(double)
	 * @generated
	 */
	boolean isSetRelaxationValue();

	/**
	 * Returns the value of the '<em><b>Relaxation Value As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relaxation Value As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relaxation Value As String</em>' attribute.
	 * @see #isSetRelaxationValueAsString()
	 * @see #unsetRelaxationValueAsString()
	 * @see #setRelaxationValueAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelaxation_RelaxationValueAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getRelaxationValueAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelaxation#getRelaxationValueAsString <em>Relaxation Value As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relaxation Value As String</em>' attribute.
	 * @see #isSetRelaxationValueAsString()
	 * @see #unsetRelaxationValueAsString()
	 * @see #getRelaxationValueAsString()
	 * @generated
	 */
	void setRelaxationValueAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelaxation#getRelaxationValueAsString <em>Relaxation Value As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRelaxationValueAsString()
	 * @see #getRelaxationValueAsString()
	 * @see #setRelaxationValueAsString(String)
	 * @generated
	 */
	void unsetRelaxationValueAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRelaxation#getRelaxationValueAsString <em>Relaxation Value As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Relaxation Value As String</em>' attribute is set.
	 * @see #unsetRelaxationValueAsString()
	 * @see #getRelaxationValueAsString()
	 * @see #setRelaxationValueAsString(String)
	 * @generated
	 */
	boolean isSetRelaxationValueAsString();

	/**
	 * Returns the value of the '<em><b>Initial Stress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial Stress</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial Stress</em>' attribute.
	 * @see #isSetInitialStress()
	 * @see #unsetInitialStress()
	 * @see #setInitialStress(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelaxation_InitialStress()
	 * @model unsettable="true"
	 * @generated
	 */
	double getInitialStress();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelaxation#getInitialStress <em>Initial Stress</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial Stress</em>' attribute.
	 * @see #isSetInitialStress()
	 * @see #unsetInitialStress()
	 * @see #getInitialStress()
	 * @generated
	 */
	void setInitialStress(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelaxation#getInitialStress <em>Initial Stress</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetInitialStress()
	 * @see #getInitialStress()
	 * @see #setInitialStress(double)
	 * @generated
	 */
	void unsetInitialStress();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRelaxation#getInitialStress <em>Initial Stress</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Initial Stress</em>' attribute is set.
	 * @see #unsetInitialStress()
	 * @see #getInitialStress()
	 * @see #setInitialStress(double)
	 * @generated
	 */
	boolean isSetInitialStress();

	/**
	 * Returns the value of the '<em><b>Initial Stress As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial Stress As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial Stress As String</em>' attribute.
	 * @see #isSetInitialStressAsString()
	 * @see #unsetInitialStressAsString()
	 * @see #setInitialStressAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRelaxation_InitialStressAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getInitialStressAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelaxation#getInitialStressAsString <em>Initial Stress As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial Stress As String</em>' attribute.
	 * @see #isSetInitialStressAsString()
	 * @see #unsetInitialStressAsString()
	 * @see #getInitialStressAsString()
	 * @generated
	 */
	void setInitialStressAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRelaxation#getInitialStressAsString <em>Initial Stress As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetInitialStressAsString()
	 * @see #getInitialStressAsString()
	 * @see #setInitialStressAsString(String)
	 * @generated
	 */
	void unsetInitialStressAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRelaxation#getInitialStressAsString <em>Initial Stress As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Initial Stress As String</em>' attribute is set.
	 * @see #unsetInitialStressAsString()
	 * @see #getInitialStressAsString()
	 * @see #setInitialStressAsString(String)
	 * @generated
	 */
	boolean isSetInitialStressAsString();

} // IfcRelaxation

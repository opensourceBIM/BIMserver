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
 * A representation of the model object '<em><b>Ifc Structural Load Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStructuralLoadGroup#getPredefinedType <em>Predefined Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStructuralLoadGroup#getActionType <em>Action Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStructuralLoadGroup#getActionSource <em>Action Source</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStructuralLoadGroup#getCoefficient <em>Coefficient</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStructuralLoadGroup#getCoefficientAsString <em>Coefficient As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStructuralLoadGroup#getPurpose <em>Purpose</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStructuralLoadGroup#getSourceOfResultGroup <em>Source Of Result Group</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStructuralLoadGroup#getLoadGroupFor <em>Load Group For</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralLoadGroup()
 * @model
 * @generated
 */
public interface IfcStructuralLoadGroup extends IfcGroup
{
	/**
	 * Returns the value of the '<em><b>Predefined Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.IfcLoadGroupTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predefined Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcLoadGroupTypeEnum
	 * @see #setPredefinedType(IfcLoadGroupTypeEnum)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralLoadGroup_PredefinedType()
	 * @model
	 * @generated
	 */
	IfcLoadGroupTypeEnum getPredefinedType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadGroup#getPredefinedType <em>Predefined Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcLoadGroupTypeEnum
	 * @see #getPredefinedType()
	 * @generated
	 */
	void setPredefinedType(IfcLoadGroupTypeEnum value);

	/**
	 * Returns the value of the '<em><b>Action Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.IfcActionTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcActionTypeEnum
	 * @see #setActionType(IfcActionTypeEnum)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralLoadGroup_ActionType()
	 * @model
	 * @generated
	 */
	IfcActionTypeEnum getActionType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadGroup#getActionType <em>Action Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcActionTypeEnum
	 * @see #getActionType()
	 * @generated
	 */
	void setActionType(IfcActionTypeEnum value);

	/**
	 * Returns the value of the '<em><b>Action Source</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.IfcActionSourceTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action Source</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action Source</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcActionSourceTypeEnum
	 * @see #setActionSource(IfcActionSourceTypeEnum)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralLoadGroup_ActionSource()
	 * @model
	 * @generated
	 */
	IfcActionSourceTypeEnum getActionSource();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadGroup#getActionSource <em>Action Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action Source</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcActionSourceTypeEnum
	 * @see #getActionSource()
	 * @generated
	 */
	void setActionSource(IfcActionSourceTypeEnum value);

	/**
	 * Returns the value of the '<em><b>Coefficient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Coefficient</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Coefficient</em>' attribute.
	 * @see #isSetCoefficient()
	 * @see #unsetCoefficient()
	 * @see #setCoefficient(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralLoadGroup_Coefficient()
	 * @model unsettable="true"
	 * @generated
	 */
	float getCoefficient();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadGroup#getCoefficient <em>Coefficient</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Coefficient</em>' attribute.
	 * @see #isSetCoefficient()
	 * @see #unsetCoefficient()
	 * @see #getCoefficient()
	 * @generated
	 */
	void setCoefficient(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadGroup#getCoefficient <em>Coefficient</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCoefficient()
	 * @see #getCoefficient()
	 * @see #setCoefficient(float)
	 * @generated
	 */
	void unsetCoefficient();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadGroup#getCoefficient <em>Coefficient</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Coefficient</em>' attribute is set.
	 * @see #unsetCoefficient()
	 * @see #getCoefficient()
	 * @see #setCoefficient(float)
	 * @generated
	 */
	boolean isSetCoefficient();

	/**
	 * Returns the value of the '<em><b>Coefficient As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Coefficient As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Coefficient As String</em>' attribute.
	 * @see #isSetCoefficientAsString()
	 * @see #unsetCoefficientAsString()
	 * @see #setCoefficientAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralLoadGroup_CoefficientAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getCoefficientAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadGroup#getCoefficientAsString <em>Coefficient As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Coefficient As String</em>' attribute.
	 * @see #isSetCoefficientAsString()
	 * @see #unsetCoefficientAsString()
	 * @see #getCoefficientAsString()
	 * @generated
	 */
	void setCoefficientAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadGroup#getCoefficientAsString <em>Coefficient As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCoefficientAsString()
	 * @see #getCoefficientAsString()
	 * @see #setCoefficientAsString(String)
	 * @generated
	 */
	void unsetCoefficientAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadGroup#getCoefficientAsString <em>Coefficient As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Coefficient As String</em>' attribute is set.
	 * @see #unsetCoefficientAsString()
	 * @see #getCoefficientAsString()
	 * @see #setCoefficientAsString(String)
	 * @generated
	 */
	boolean isSetCoefficientAsString();

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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralLoadGroup_Purpose()
	 * @model unsettable="true"
	 * @generated
	 */
	String getPurpose();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadGroup#getPurpose <em>Purpose</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadGroup#getPurpose <em>Purpose</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPurpose()
	 * @see #getPurpose()
	 * @see #setPurpose(String)
	 * @generated
	 */
	void unsetPurpose();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadGroup#getPurpose <em>Purpose</em>}' attribute is set.
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
	 * Returns the value of the '<em><b>Source Of Result Group</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcStructuralResultGroup}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcStructuralResultGroup#getResultForLoadGroup <em>Result For Load Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Of Result Group</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Of Result Group</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralLoadGroup_SourceOfResultGroup()
	 * @see org.bimserver.models.ifc2x3.IfcStructuralResultGroup#getResultForLoadGroup
	 * @model opposite="ResultForLoadGroup" upper="2"
	 * @generated
	 */
	EList<IfcStructuralResultGroup> getSourceOfResultGroup();

	/**
	 * Returns the value of the '<em><b>Load Group For</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcStructuralAnalysisModel}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcStructuralAnalysisModel#getLoadedBy <em>Loaded By</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Load Group For</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Load Group For</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralLoadGroup_LoadGroupFor()
	 * @see org.bimserver.models.ifc2x3.IfcStructuralAnalysisModel#getLoadedBy
	 * @model opposite="LoadedBy"
	 * @generated
	 */
	EList<IfcStructuralAnalysisModel> getLoadGroupFor();

} // IfcStructuralLoadGroup

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
 * A representation of the model object '<em><b>Ifc Structural Load Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadGroup#getPredefinedType <em>Predefined Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadGroup#getActionType <em>Action Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadGroup#getActionSource <em>Action Source</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadGroup#getCoefficient <em>Coefficient</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadGroup#getCoefficientAsString <em>Coefficient As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadGroup#getPurpose <em>Purpose</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadGroup#getSourceOfResultGroup <em>Source Of Result Group</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadGroup#getLoadGroupFor <em>Load Group For</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcStructuralLoadGroup()
 * @model
 * @generated
 */
public interface IfcStructuralLoadGroup extends IfcGroup {
	/**
	 * Returns the value of the '<em><b>Predefined Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3tc1.IfcLoadGroupTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predefined Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.IfcLoadGroupTypeEnum
	 * @see #setPredefinedType(IfcLoadGroupTypeEnum)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcStructuralLoadGroup_PredefinedType()
	 * @model
	 * @generated
	 */
	IfcLoadGroupTypeEnum getPredefinedType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadGroup#getPredefinedType <em>Predefined Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.IfcLoadGroupTypeEnum
	 * @see #getPredefinedType()
	 * @generated
	 */
	void setPredefinedType(IfcLoadGroupTypeEnum value);

	/**
	 * Returns the value of the '<em><b>Action Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3tc1.IfcActionTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.IfcActionTypeEnum
	 * @see #setActionType(IfcActionTypeEnum)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcStructuralLoadGroup_ActionType()
	 * @model
	 * @generated
	 */
	IfcActionTypeEnum getActionType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadGroup#getActionType <em>Action Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.IfcActionTypeEnum
	 * @see #getActionType()
	 * @generated
	 */
	void setActionType(IfcActionTypeEnum value);

	/**
	 * Returns the value of the '<em><b>Action Source</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3tc1.IfcActionSourceTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action Source</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action Source</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.IfcActionSourceTypeEnum
	 * @see #setActionSource(IfcActionSourceTypeEnum)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcStructuralLoadGroup_ActionSource()
	 * @model
	 * @generated
	 */
	IfcActionSourceTypeEnum getActionSource();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadGroup#getActionSource <em>Action Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action Source</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.IfcActionSourceTypeEnum
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
	 * @see #setCoefficient(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcStructuralLoadGroup_Coefficient()
	 * @model unsettable="true"
	 * @generated
	 */
	double getCoefficient();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadGroup#getCoefficient <em>Coefficient</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Coefficient</em>' attribute.
	 * @see #isSetCoefficient()
	 * @see #unsetCoefficient()
	 * @see #getCoefficient()
	 * @generated
	 */
	void setCoefficient(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadGroup#getCoefficient <em>Coefficient</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCoefficient()
	 * @see #getCoefficient()
	 * @see #setCoefficient(double)
	 * @generated
	 */
	void unsetCoefficient();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadGroup#getCoefficient <em>Coefficient</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Coefficient</em>' attribute is set.
	 * @see #unsetCoefficient()
	 * @see #getCoefficient()
	 * @see #setCoefficient(double)
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
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcStructuralLoadGroup_CoefficientAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getCoefficientAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadGroup#getCoefficientAsString <em>Coefficient As String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadGroup#getCoefficientAsString <em>Coefficient As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCoefficientAsString()
	 * @see #getCoefficientAsString()
	 * @see #setCoefficientAsString(String)
	 * @generated
	 */
	void unsetCoefficientAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadGroup#getCoefficientAsString <em>Coefficient As String</em>}' attribute is set.
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
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcStructuralLoadGroup_Purpose()
	 * @model unsettable="true"
	 * @generated
	 */
	String getPurpose();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadGroup#getPurpose <em>Purpose</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadGroup#getPurpose <em>Purpose</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPurpose()
	 * @see #getPurpose()
	 * @see #setPurpose(String)
	 * @generated
	 */
	void unsetPurpose();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadGroup#getPurpose <em>Purpose</em>}' attribute is set.
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
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcStructuralResultGroup}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralResultGroup#getResultForLoadGroup <em>Result For Load Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Of Result Group</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Of Result Group</em>' reference list.
	 * @see #isSetSourceOfResultGroup()
	 * @see #unsetSourceOfResultGroup()
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcStructuralLoadGroup_SourceOfResultGroup()
	 * @see org.bimserver.models.ifc2x3tc1.IfcStructuralResultGroup#getResultForLoadGroup
	 * @model opposite="ResultForLoadGroup" unsettable="true" upper="2"
	 * @generated
	 */
	EList<IfcStructuralResultGroup> getSourceOfResultGroup();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadGroup#getSourceOfResultGroup <em>Source Of Result Group</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSourceOfResultGroup()
	 * @see #getSourceOfResultGroup()
	 * @generated
	 */
	void unsetSourceOfResultGroup();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadGroup#getSourceOfResultGroup <em>Source Of Result Group</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Source Of Result Group</em>' reference list is set.
	 * @see #unsetSourceOfResultGroup()
	 * @see #getSourceOfResultGroup()
	 * @generated
	 */
	boolean isSetSourceOfResultGroup();

	/**
	 * Returns the value of the '<em><b>Load Group For</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcStructuralAnalysisModel}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralAnalysisModel#getLoadedBy <em>Loaded By</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Load Group For</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Load Group For</em>' reference list.
	 * @see #isSetLoadGroupFor()
	 * @see #unsetLoadGroupFor()
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcStructuralLoadGroup_LoadGroupFor()
	 * @see org.bimserver.models.ifc2x3tc1.IfcStructuralAnalysisModel#getLoadedBy
	 * @model opposite="LoadedBy" unsettable="true"
	 * @generated
	 */
	EList<IfcStructuralAnalysisModel> getLoadGroupFor();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadGroup#getLoadGroupFor <em>Load Group For</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLoadGroupFor()
	 * @see #getLoadGroupFor()
	 * @generated
	 */
	void unsetLoadGroupFor();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadGroup#getLoadGroupFor <em>Load Group For</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Load Group For</em>' reference list is set.
	 * @see #unsetLoadGroupFor()
	 * @see #getLoadGroupFor()
	 * @generated
	 */
	boolean isSetLoadGroupFor();

} // IfcStructuralLoadGroup

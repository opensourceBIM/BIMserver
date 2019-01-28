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

public interface IfcAnnotationFillAreaOccurrence extends IfcAnnotationOccurrence {
	/**
	 * Returns the value of the '<em><b>Fill Style Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fill Style Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fill Style Target</em>' reference.
	 * @see #isSetFillStyleTarget()
	 * @see #unsetFillStyleTarget()
	 * @see #setFillStyleTarget(IfcPoint)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcAnnotationFillAreaOccurrence_FillStyleTarget()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcPoint getFillStyleTarget();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcAnnotationFillAreaOccurrence#getFillStyleTarget <em>Fill Style Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fill Style Target</em>' reference.
	 * @see #isSetFillStyleTarget()
	 * @see #unsetFillStyleTarget()
	 * @see #getFillStyleTarget()
	 * @generated
	 */
	void setFillStyleTarget(IfcPoint value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcAnnotationFillAreaOccurrence#getFillStyleTarget <em>Fill Style Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFillStyleTarget()
	 * @see #getFillStyleTarget()
	 * @see #setFillStyleTarget(IfcPoint)
	 * @generated
	 */
	void unsetFillStyleTarget();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcAnnotationFillAreaOccurrence#getFillStyleTarget <em>Fill Style Target</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Fill Style Target</em>' reference is set.
	 * @see #unsetFillStyleTarget()
	 * @see #getFillStyleTarget()
	 * @see #setFillStyleTarget(IfcPoint)
	 * @generated
	 */
	boolean isSetFillStyleTarget();

	/**
	 * Returns the value of the '<em><b>Global Or Local</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3tc1.IfcGlobalOrLocalEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Global Or Local</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Global Or Local</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.IfcGlobalOrLocalEnum
	 * @see #isSetGlobalOrLocal()
	 * @see #unsetGlobalOrLocal()
	 * @see #setGlobalOrLocal(IfcGlobalOrLocalEnum)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcAnnotationFillAreaOccurrence_GlobalOrLocal()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcGlobalOrLocalEnum getGlobalOrLocal();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcAnnotationFillAreaOccurrence#getGlobalOrLocal <em>Global Or Local</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Global Or Local</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.IfcGlobalOrLocalEnum
	 * @see #isSetGlobalOrLocal()
	 * @see #unsetGlobalOrLocal()
	 * @see #getGlobalOrLocal()
	 * @generated
	 */
	void setGlobalOrLocal(IfcGlobalOrLocalEnum value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcAnnotationFillAreaOccurrence#getGlobalOrLocal <em>Global Or Local</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetGlobalOrLocal()
	 * @see #getGlobalOrLocal()
	 * @see #setGlobalOrLocal(IfcGlobalOrLocalEnum)
	 * @generated
	 */
	void unsetGlobalOrLocal();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcAnnotationFillAreaOccurrence#getGlobalOrLocal <em>Global Or Local</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Global Or Local</em>' attribute is set.
	 * @see #unsetGlobalOrLocal()
	 * @see #getGlobalOrLocal()
	 * @see #setGlobalOrLocal(IfcGlobalOrLocalEnum)
	 * @generated
	 */
	boolean isSetGlobalOrLocal();

} // IfcAnnotationFillAreaOccurrence

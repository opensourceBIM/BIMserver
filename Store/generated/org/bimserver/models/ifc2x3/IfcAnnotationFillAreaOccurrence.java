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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Annotation Fill Area Occurrence</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcAnnotationFillAreaOccurrence#getFillStyleTarget <em>Fill Style Target</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcAnnotationFillAreaOccurrence#getGlobalOrLocal <em>Global Or Local</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcAnnotationFillAreaOccurrence()
 * @model
 * @generated
 */
public interface IfcAnnotationFillAreaOccurrence extends IfcAnnotationOccurrence
{
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcAnnotationFillAreaOccurrence_FillStyleTarget()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcPoint getFillStyleTarget();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcAnnotationFillAreaOccurrence#getFillStyleTarget <em>Fill Style Target</em>}' reference.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcAnnotationFillAreaOccurrence#getFillStyleTarget <em>Fill Style Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFillStyleTarget()
	 * @see #getFillStyleTarget()
	 * @see #setFillStyleTarget(IfcPoint)
	 * @generated
	 */
	void unsetFillStyleTarget();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcAnnotationFillAreaOccurrence#getFillStyleTarget <em>Fill Style Target</em>}' reference is set.
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
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.IfcGlobalOrLocalEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Global Or Local</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Global Or Local</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcGlobalOrLocalEnum
	 * @see #setGlobalOrLocal(IfcGlobalOrLocalEnum)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcAnnotationFillAreaOccurrence_GlobalOrLocal()
	 * @model
	 * @generated
	 */
	IfcGlobalOrLocalEnum getGlobalOrLocal();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcAnnotationFillAreaOccurrence#getGlobalOrLocal <em>Global Or Local</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Global Or Local</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcGlobalOrLocalEnum
	 * @see #getGlobalOrLocal()
	 * @generated
	 */
	void setGlobalOrLocal(IfcGlobalOrLocalEnum value);

} // IfcAnnotationFillAreaOccurrence

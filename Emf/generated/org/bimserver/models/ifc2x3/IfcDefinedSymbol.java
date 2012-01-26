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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Defined Symbol</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcDefinedSymbol#getDefinition <em>Definition</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcDefinedSymbol#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDefinedSymbol()
 * @model
 * @generated
 */
public interface IfcDefinedSymbol extends IfcGeometricRepresentationItem {
	/**
	 * Returns the value of the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Definition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Definition</em>' reference.
	 * @see #isSetDefinition()
	 * @see #unsetDefinition()
	 * @see #setDefinition(IfcDefinedSymbolSelect)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDefinedSymbol_Definition()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcDefinedSymbolSelect getDefinition();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcDefinedSymbol#getDefinition <em>Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Definition</em>' reference.
	 * @see #isSetDefinition()
	 * @see #unsetDefinition()
	 * @see #getDefinition()
	 * @generated
	 */
	void setDefinition(IfcDefinedSymbolSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcDefinedSymbol#getDefinition <em>Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDefinition()
	 * @see #getDefinition()
	 * @see #setDefinition(IfcDefinedSymbolSelect)
	 * @generated
	 */
	void unsetDefinition();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcDefinedSymbol#getDefinition <em>Definition</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Definition</em>' reference is set.
	 * @see #unsetDefinition()
	 * @see #getDefinition()
	 * @see #setDefinition(IfcDefinedSymbolSelect)
	 * @generated
	 */
	boolean isSetDefinition();

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #isSetTarget()
	 * @see #unsetTarget()
	 * @see #setTarget(IfcCartesianTransformationOperator2D)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDefinedSymbol_Target()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcCartesianTransformationOperator2D getTarget();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcDefinedSymbol#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #isSetTarget()
	 * @see #unsetTarget()
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(IfcCartesianTransformationOperator2D value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcDefinedSymbol#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTarget()
	 * @see #getTarget()
	 * @see #setTarget(IfcCartesianTransformationOperator2D)
	 * @generated
	 */
	void unsetTarget();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcDefinedSymbol#getTarget <em>Target</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Target</em>' reference is set.
	 * @see #unsetTarget()
	 * @see #getTarget()
	 * @see #setTarget(IfcCartesianTransformationOperator2D)
	 * @generated
	 */
	boolean isSetTarget();

} // IfcDefinedSymbol

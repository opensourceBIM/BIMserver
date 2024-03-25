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
package org.bimserver.models.ifc4x3;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Cosine Spiral</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcCosineSpiral#getCosineTerm <em>Cosine Term</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcCosineSpiral#getCosineTermAsString <em>Cosine Term As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcCosineSpiral#getConstantTerm <em>Constant Term</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcCosineSpiral#getConstantTermAsString <em>Constant Term As String</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcCosineSpiral()
 * @model
 * @generated
 */
public interface IfcCosineSpiral extends IfcSpiral {
	/**
	 * Returns the value of the '<em><b>Cosine Term</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cosine Term</em>' attribute.
	 * @see #setCosineTerm(double)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcCosineSpiral_CosineTerm()
	 * @model
	 * @generated
	 */
	double getCosineTerm();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcCosineSpiral#getCosineTerm <em>Cosine Term</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cosine Term</em>' attribute.
	 * @see #getCosineTerm()
	 * @generated
	 */
	void setCosineTerm(double value);

	/**
	 * Returns the value of the '<em><b>Cosine Term As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cosine Term As String</em>' attribute.
	 * @see #setCosineTermAsString(String)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcCosineSpiral_CosineTermAsString()
	 * @model annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getCosineTermAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcCosineSpiral#getCosineTermAsString <em>Cosine Term As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cosine Term As String</em>' attribute.
	 * @see #getCosineTermAsString()
	 * @generated
	 */
	void setCosineTermAsString(String value);

	/**
	 * Returns the value of the '<em><b>Constant Term</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constant Term</em>' attribute.
	 * @see #isSetConstantTerm()
	 * @see #unsetConstantTerm()
	 * @see #setConstantTerm(double)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcCosineSpiral_ConstantTerm()
	 * @model unsettable="true"
	 * @generated
	 */
	double getConstantTerm();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcCosineSpiral#getConstantTerm <em>Constant Term</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constant Term</em>' attribute.
	 * @see #isSetConstantTerm()
	 * @see #unsetConstantTerm()
	 * @see #getConstantTerm()
	 * @generated
	 */
	void setConstantTerm(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcCosineSpiral#getConstantTerm <em>Constant Term</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetConstantTerm()
	 * @see #getConstantTerm()
	 * @see #setConstantTerm(double)
	 * @generated
	 */
	void unsetConstantTerm();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcCosineSpiral#getConstantTerm <em>Constant Term</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Constant Term</em>' attribute is set.
	 * @see #unsetConstantTerm()
	 * @see #getConstantTerm()
	 * @see #setConstantTerm(double)
	 * @generated
	 */
	boolean isSetConstantTerm();

	/**
	 * Returns the value of the '<em><b>Constant Term As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constant Term As String</em>' attribute.
	 * @see #isSetConstantTermAsString()
	 * @see #unsetConstantTermAsString()
	 * @see #setConstantTermAsString(String)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcCosineSpiral_ConstantTermAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getConstantTermAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcCosineSpiral#getConstantTermAsString <em>Constant Term As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constant Term As String</em>' attribute.
	 * @see #isSetConstantTermAsString()
	 * @see #unsetConstantTermAsString()
	 * @see #getConstantTermAsString()
	 * @generated
	 */
	void setConstantTermAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcCosineSpiral#getConstantTermAsString <em>Constant Term As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetConstantTermAsString()
	 * @see #getConstantTermAsString()
	 * @see #setConstantTermAsString(String)
	 * @generated
	 */
	void unsetConstantTermAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcCosineSpiral#getConstantTermAsString <em>Constant Term As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Constant Term As String</em>' attribute is set.
	 * @see #unsetConstantTermAsString()
	 * @see #getConstantTermAsString()
	 * @see #setConstantTermAsString(String)
	 * @generated
	 */
	boolean isSetConstantTermAsString();

} // IfcCosineSpiral

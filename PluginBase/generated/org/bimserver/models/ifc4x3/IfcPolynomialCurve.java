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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Polynomial Curve</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcPolynomialCurve#getPosition <em>Position</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcPolynomialCurve#getCoefficientsX <em>Coefficients X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcPolynomialCurve#getCoefficientsXAsString <em>Coefficients XAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcPolynomialCurve#getCoefficientsY <em>Coefficients Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcPolynomialCurve#getCoefficientsYAsString <em>Coefficients YAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcPolynomialCurve#getCoefficientsZ <em>Coefficients Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcPolynomialCurve#getCoefficientsZAsString <em>Coefficients ZAs String</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcPolynomialCurve()
 * @model
 * @generated
 */
public interface IfcPolynomialCurve extends IfcCurve {
	/**
	 * Returns the value of the '<em><b>Position</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Position</em>' reference.
	 * @see #setPosition(IfcPlacement)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcPolynomialCurve_Position()
	 * @model
	 * @generated
	 */
	IfcPlacement getPosition();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcPolynomialCurve#getPosition <em>Position</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Position</em>' reference.
	 * @see #getPosition()
	 * @generated
	 */
	void setPosition(IfcPlacement value);

	/**
	 * Returns the value of the '<em><b>Coefficients X</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Double}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Coefficients X</em>' attribute list.
	 * @see #isSetCoefficientsX()
	 * @see #unsetCoefficientsX()
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcPolynomialCurve_CoefficientsX()
	 * @model unique="false" unsettable="true"
	 * @generated
	 */
	EList<Double> getCoefficientsX();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcPolynomialCurve#getCoefficientsX <em>Coefficients X</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCoefficientsX()
	 * @see #getCoefficientsX()
	 * @generated
	 */
	void unsetCoefficientsX();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcPolynomialCurve#getCoefficientsX <em>Coefficients X</em>}' attribute list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Coefficients X</em>' attribute list is set.
	 * @see #unsetCoefficientsX()
	 * @see #getCoefficientsX()
	 * @generated
	 */
	boolean isSetCoefficientsX();

	/**
	 * Returns the value of the '<em><b>Coefficients XAs String</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Coefficients XAs String</em>' attribute list.
	 * @see #isSetCoefficientsXAsString()
	 * @see #unsetCoefficientsXAsString()
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcPolynomialCurve_CoefficientsXAsString()
	 * @model unique="false" unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	EList<String> getCoefficientsXAsString();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcPolynomialCurve#getCoefficientsXAsString <em>Coefficients XAs String</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCoefficientsXAsString()
	 * @see #getCoefficientsXAsString()
	 * @generated
	 */
	void unsetCoefficientsXAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcPolynomialCurve#getCoefficientsXAsString <em>Coefficients XAs String</em>}' attribute list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Coefficients XAs String</em>' attribute list is set.
	 * @see #unsetCoefficientsXAsString()
	 * @see #getCoefficientsXAsString()
	 * @generated
	 */
	boolean isSetCoefficientsXAsString();

	/**
	 * Returns the value of the '<em><b>Coefficients Y</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Double}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Coefficients Y</em>' attribute list.
	 * @see #isSetCoefficientsY()
	 * @see #unsetCoefficientsY()
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcPolynomialCurve_CoefficientsY()
	 * @model unique="false" unsettable="true"
	 * @generated
	 */
	EList<Double> getCoefficientsY();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcPolynomialCurve#getCoefficientsY <em>Coefficients Y</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCoefficientsY()
	 * @see #getCoefficientsY()
	 * @generated
	 */
	void unsetCoefficientsY();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcPolynomialCurve#getCoefficientsY <em>Coefficients Y</em>}' attribute list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Coefficients Y</em>' attribute list is set.
	 * @see #unsetCoefficientsY()
	 * @see #getCoefficientsY()
	 * @generated
	 */
	boolean isSetCoefficientsY();

	/**
	 * Returns the value of the '<em><b>Coefficients YAs String</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Coefficients YAs String</em>' attribute list.
	 * @see #isSetCoefficientsYAsString()
	 * @see #unsetCoefficientsYAsString()
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcPolynomialCurve_CoefficientsYAsString()
	 * @model unique="false" unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	EList<String> getCoefficientsYAsString();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcPolynomialCurve#getCoefficientsYAsString <em>Coefficients YAs String</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCoefficientsYAsString()
	 * @see #getCoefficientsYAsString()
	 * @generated
	 */
	void unsetCoefficientsYAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcPolynomialCurve#getCoefficientsYAsString <em>Coefficients YAs String</em>}' attribute list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Coefficients YAs String</em>' attribute list is set.
	 * @see #unsetCoefficientsYAsString()
	 * @see #getCoefficientsYAsString()
	 * @generated
	 */
	boolean isSetCoefficientsYAsString();

	/**
	 * Returns the value of the '<em><b>Coefficients Z</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Double}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Coefficients Z</em>' attribute list.
	 * @see #isSetCoefficientsZ()
	 * @see #unsetCoefficientsZ()
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcPolynomialCurve_CoefficientsZ()
	 * @model unique="false" unsettable="true"
	 * @generated
	 */
	EList<Double> getCoefficientsZ();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcPolynomialCurve#getCoefficientsZ <em>Coefficients Z</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCoefficientsZ()
	 * @see #getCoefficientsZ()
	 * @generated
	 */
	void unsetCoefficientsZ();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcPolynomialCurve#getCoefficientsZ <em>Coefficients Z</em>}' attribute list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Coefficients Z</em>' attribute list is set.
	 * @see #unsetCoefficientsZ()
	 * @see #getCoefficientsZ()
	 * @generated
	 */
	boolean isSetCoefficientsZ();

	/**
	 * Returns the value of the '<em><b>Coefficients ZAs String</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Coefficients ZAs String</em>' attribute list.
	 * @see #isSetCoefficientsZAsString()
	 * @see #unsetCoefficientsZAsString()
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcPolynomialCurve_CoefficientsZAsString()
	 * @model unique="false" unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	EList<String> getCoefficientsZAsString();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcPolynomialCurve#getCoefficientsZAsString <em>Coefficients ZAs String</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCoefficientsZAsString()
	 * @see #getCoefficientsZAsString()
	 * @generated
	 */
	void unsetCoefficientsZAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcPolynomialCurve#getCoefficientsZAsString <em>Coefficients ZAs String</em>}' attribute list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Coefficients ZAs String</em>' attribute list is set.
	 * @see #unsetCoefficientsZAsString()
	 * @see #getCoefficientsZAsString()
	 * @generated
	 */
	boolean isSetCoefficientsZAsString();

} // IfcPolynomialCurve

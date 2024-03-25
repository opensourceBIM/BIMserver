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
 * A representation of the model object '<em><b>Ifc Third Order Polynomial Spiral</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcThirdOrderPolynomialSpiral#getCubicTerm <em>Cubic Term</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcThirdOrderPolynomialSpiral#getCubicTermAsString <em>Cubic Term As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcThirdOrderPolynomialSpiral#getQuadraticTerm <em>Quadratic Term</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcThirdOrderPolynomialSpiral#getQuadraticTermAsString <em>Quadratic Term As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcThirdOrderPolynomialSpiral#getLinearTerm <em>Linear Term</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcThirdOrderPolynomialSpiral#getLinearTermAsString <em>Linear Term As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcThirdOrderPolynomialSpiral#getConstantTerm <em>Constant Term</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcThirdOrderPolynomialSpiral#getConstantTermAsString <em>Constant Term As String</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcThirdOrderPolynomialSpiral()
 * @model
 * @generated
 */
public interface IfcThirdOrderPolynomialSpiral extends IfcSpiral {
	/**
	 * Returns the value of the '<em><b>Cubic Term</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cubic Term</em>' attribute.
	 * @see #setCubicTerm(double)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcThirdOrderPolynomialSpiral_CubicTerm()
	 * @model
	 * @generated
	 */
	double getCubicTerm();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcThirdOrderPolynomialSpiral#getCubicTerm <em>Cubic Term</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cubic Term</em>' attribute.
	 * @see #getCubicTerm()
	 * @generated
	 */
	void setCubicTerm(double value);

	/**
	 * Returns the value of the '<em><b>Cubic Term As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cubic Term As String</em>' attribute.
	 * @see #setCubicTermAsString(String)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcThirdOrderPolynomialSpiral_CubicTermAsString()
	 * @model annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getCubicTermAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcThirdOrderPolynomialSpiral#getCubicTermAsString <em>Cubic Term As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cubic Term As String</em>' attribute.
	 * @see #getCubicTermAsString()
	 * @generated
	 */
	void setCubicTermAsString(String value);

	/**
	 * Returns the value of the '<em><b>Quadratic Term</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Quadratic Term</em>' attribute.
	 * @see #isSetQuadraticTerm()
	 * @see #unsetQuadraticTerm()
	 * @see #setQuadraticTerm(double)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcThirdOrderPolynomialSpiral_QuadraticTerm()
	 * @model unsettable="true"
	 * @generated
	 */
	double getQuadraticTerm();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcThirdOrderPolynomialSpiral#getQuadraticTerm <em>Quadratic Term</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quadratic Term</em>' attribute.
	 * @see #isSetQuadraticTerm()
	 * @see #unsetQuadraticTerm()
	 * @see #getQuadraticTerm()
	 * @generated
	 */
	void setQuadraticTerm(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcThirdOrderPolynomialSpiral#getQuadraticTerm <em>Quadratic Term</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetQuadraticTerm()
	 * @see #getQuadraticTerm()
	 * @see #setQuadraticTerm(double)
	 * @generated
	 */
	void unsetQuadraticTerm();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcThirdOrderPolynomialSpiral#getQuadraticTerm <em>Quadratic Term</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Quadratic Term</em>' attribute is set.
	 * @see #unsetQuadraticTerm()
	 * @see #getQuadraticTerm()
	 * @see #setQuadraticTerm(double)
	 * @generated
	 */
	boolean isSetQuadraticTerm();

	/**
	 * Returns the value of the '<em><b>Quadratic Term As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Quadratic Term As String</em>' attribute.
	 * @see #isSetQuadraticTermAsString()
	 * @see #unsetQuadraticTermAsString()
	 * @see #setQuadraticTermAsString(String)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcThirdOrderPolynomialSpiral_QuadraticTermAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getQuadraticTermAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcThirdOrderPolynomialSpiral#getQuadraticTermAsString <em>Quadratic Term As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quadratic Term As String</em>' attribute.
	 * @see #isSetQuadraticTermAsString()
	 * @see #unsetQuadraticTermAsString()
	 * @see #getQuadraticTermAsString()
	 * @generated
	 */
	void setQuadraticTermAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcThirdOrderPolynomialSpiral#getQuadraticTermAsString <em>Quadratic Term As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetQuadraticTermAsString()
	 * @see #getQuadraticTermAsString()
	 * @see #setQuadraticTermAsString(String)
	 * @generated
	 */
	void unsetQuadraticTermAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcThirdOrderPolynomialSpiral#getQuadraticTermAsString <em>Quadratic Term As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Quadratic Term As String</em>' attribute is set.
	 * @see #unsetQuadraticTermAsString()
	 * @see #getQuadraticTermAsString()
	 * @see #setQuadraticTermAsString(String)
	 * @generated
	 */
	boolean isSetQuadraticTermAsString();

	/**
	 * Returns the value of the '<em><b>Linear Term</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Linear Term</em>' attribute.
	 * @see #isSetLinearTerm()
	 * @see #unsetLinearTerm()
	 * @see #setLinearTerm(double)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcThirdOrderPolynomialSpiral_LinearTerm()
	 * @model unsettable="true"
	 * @generated
	 */
	double getLinearTerm();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcThirdOrderPolynomialSpiral#getLinearTerm <em>Linear Term</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Linear Term</em>' attribute.
	 * @see #isSetLinearTerm()
	 * @see #unsetLinearTerm()
	 * @see #getLinearTerm()
	 * @generated
	 */
	void setLinearTerm(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcThirdOrderPolynomialSpiral#getLinearTerm <em>Linear Term</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLinearTerm()
	 * @see #getLinearTerm()
	 * @see #setLinearTerm(double)
	 * @generated
	 */
	void unsetLinearTerm();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcThirdOrderPolynomialSpiral#getLinearTerm <em>Linear Term</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Linear Term</em>' attribute is set.
	 * @see #unsetLinearTerm()
	 * @see #getLinearTerm()
	 * @see #setLinearTerm(double)
	 * @generated
	 */
	boolean isSetLinearTerm();

	/**
	 * Returns the value of the '<em><b>Linear Term As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Linear Term As String</em>' attribute.
	 * @see #isSetLinearTermAsString()
	 * @see #unsetLinearTermAsString()
	 * @see #setLinearTermAsString(String)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcThirdOrderPolynomialSpiral_LinearTermAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getLinearTermAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcThirdOrderPolynomialSpiral#getLinearTermAsString <em>Linear Term As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Linear Term As String</em>' attribute.
	 * @see #isSetLinearTermAsString()
	 * @see #unsetLinearTermAsString()
	 * @see #getLinearTermAsString()
	 * @generated
	 */
	void setLinearTermAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcThirdOrderPolynomialSpiral#getLinearTermAsString <em>Linear Term As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLinearTermAsString()
	 * @see #getLinearTermAsString()
	 * @see #setLinearTermAsString(String)
	 * @generated
	 */
	void unsetLinearTermAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcThirdOrderPolynomialSpiral#getLinearTermAsString <em>Linear Term As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Linear Term As String</em>' attribute is set.
	 * @see #unsetLinearTermAsString()
	 * @see #getLinearTermAsString()
	 * @see #setLinearTermAsString(String)
	 * @generated
	 */
	boolean isSetLinearTermAsString();

	/**
	 * Returns the value of the '<em><b>Constant Term</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constant Term</em>' attribute.
	 * @see #isSetConstantTerm()
	 * @see #unsetConstantTerm()
	 * @see #setConstantTerm(double)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcThirdOrderPolynomialSpiral_ConstantTerm()
	 * @model unsettable="true"
	 * @generated
	 */
	double getConstantTerm();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcThirdOrderPolynomialSpiral#getConstantTerm <em>Constant Term</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcThirdOrderPolynomialSpiral#getConstantTerm <em>Constant Term</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetConstantTerm()
	 * @see #getConstantTerm()
	 * @see #setConstantTerm(double)
	 * @generated
	 */
	void unsetConstantTerm();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcThirdOrderPolynomialSpiral#getConstantTerm <em>Constant Term</em>}' attribute is set.
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
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcThirdOrderPolynomialSpiral_ConstantTermAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getConstantTermAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcThirdOrderPolynomialSpiral#getConstantTermAsString <em>Constant Term As String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcThirdOrderPolynomialSpiral#getConstantTermAsString <em>Constant Term As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetConstantTermAsString()
	 * @see #getConstantTermAsString()
	 * @see #setConstantTermAsString(String)
	 * @generated
	 */
	void unsetConstantTermAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcThirdOrderPolynomialSpiral#getConstantTermAsString <em>Constant Term As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Constant Term As String</em>' attribute is set.
	 * @see #unsetConstantTermAsString()
	 * @see #getConstantTermAsString()
	 * @see #setConstantTermAsString(String)
	 * @generated
	 */
	boolean isSetConstantTermAsString();

} // IfcThirdOrderPolynomialSpiral

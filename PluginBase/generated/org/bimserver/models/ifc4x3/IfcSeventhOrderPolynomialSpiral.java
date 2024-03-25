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
 * A representation of the model object '<em><b>Ifc Seventh Order Polynomial Spiral</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral#getSepticTerm <em>Septic Term</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral#getSepticTermAsString <em>Septic Term As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral#getSexticTerm <em>Sextic Term</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral#getSexticTermAsString <em>Sextic Term As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral#getQuinticTerm <em>Quintic Term</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral#getQuinticTermAsString <em>Quintic Term As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral#getQuarticTerm <em>Quartic Term</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral#getQuarticTermAsString <em>Quartic Term As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral#getCubicTerm <em>Cubic Term</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral#getCubicTermAsString <em>Cubic Term As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral#getQuadraticTerm <em>Quadratic Term</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral#getQuadraticTermAsString <em>Quadratic Term As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral#getLinearTerm <em>Linear Term</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral#getLinearTermAsString <em>Linear Term As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral#getConstantTerm <em>Constant Term</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral#getConstantTermAsString <em>Constant Term As String</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcSeventhOrderPolynomialSpiral()
 * @model
 * @generated
 */
public interface IfcSeventhOrderPolynomialSpiral extends IfcSpiral {
	/**
	 * Returns the value of the '<em><b>Septic Term</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Septic Term</em>' attribute.
	 * @see #setSepticTerm(double)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcSeventhOrderPolynomialSpiral_SepticTerm()
	 * @model
	 * @generated
	 */
	double getSepticTerm();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral#getSepticTerm <em>Septic Term</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Septic Term</em>' attribute.
	 * @see #getSepticTerm()
	 * @generated
	 */
	void setSepticTerm(double value);

	/**
	 * Returns the value of the '<em><b>Septic Term As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Septic Term As String</em>' attribute.
	 * @see #setSepticTermAsString(String)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcSeventhOrderPolynomialSpiral_SepticTermAsString()
	 * @model annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getSepticTermAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral#getSepticTermAsString <em>Septic Term As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Septic Term As String</em>' attribute.
	 * @see #getSepticTermAsString()
	 * @generated
	 */
	void setSepticTermAsString(String value);

	/**
	 * Returns the value of the '<em><b>Sextic Term</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sextic Term</em>' attribute.
	 * @see #isSetSexticTerm()
	 * @see #unsetSexticTerm()
	 * @see #setSexticTerm(double)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcSeventhOrderPolynomialSpiral_SexticTerm()
	 * @model unsettable="true"
	 * @generated
	 */
	double getSexticTerm();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral#getSexticTerm <em>Sextic Term</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sextic Term</em>' attribute.
	 * @see #isSetSexticTerm()
	 * @see #unsetSexticTerm()
	 * @see #getSexticTerm()
	 * @generated
	 */
	void setSexticTerm(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral#getSexticTerm <em>Sextic Term</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSexticTerm()
	 * @see #getSexticTerm()
	 * @see #setSexticTerm(double)
	 * @generated
	 */
	void unsetSexticTerm();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral#getSexticTerm <em>Sextic Term</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Sextic Term</em>' attribute is set.
	 * @see #unsetSexticTerm()
	 * @see #getSexticTerm()
	 * @see #setSexticTerm(double)
	 * @generated
	 */
	boolean isSetSexticTerm();

	/**
	 * Returns the value of the '<em><b>Sextic Term As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sextic Term As String</em>' attribute.
	 * @see #isSetSexticTermAsString()
	 * @see #unsetSexticTermAsString()
	 * @see #setSexticTermAsString(String)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcSeventhOrderPolynomialSpiral_SexticTermAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getSexticTermAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral#getSexticTermAsString <em>Sextic Term As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sextic Term As String</em>' attribute.
	 * @see #isSetSexticTermAsString()
	 * @see #unsetSexticTermAsString()
	 * @see #getSexticTermAsString()
	 * @generated
	 */
	void setSexticTermAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral#getSexticTermAsString <em>Sextic Term As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSexticTermAsString()
	 * @see #getSexticTermAsString()
	 * @see #setSexticTermAsString(String)
	 * @generated
	 */
	void unsetSexticTermAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral#getSexticTermAsString <em>Sextic Term As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Sextic Term As String</em>' attribute is set.
	 * @see #unsetSexticTermAsString()
	 * @see #getSexticTermAsString()
	 * @see #setSexticTermAsString(String)
	 * @generated
	 */
	boolean isSetSexticTermAsString();

	/**
	 * Returns the value of the '<em><b>Quintic Term</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Quintic Term</em>' attribute.
	 * @see #isSetQuinticTerm()
	 * @see #unsetQuinticTerm()
	 * @see #setQuinticTerm(double)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcSeventhOrderPolynomialSpiral_QuinticTerm()
	 * @model unsettable="true"
	 * @generated
	 */
	double getQuinticTerm();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral#getQuinticTerm <em>Quintic Term</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quintic Term</em>' attribute.
	 * @see #isSetQuinticTerm()
	 * @see #unsetQuinticTerm()
	 * @see #getQuinticTerm()
	 * @generated
	 */
	void setQuinticTerm(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral#getQuinticTerm <em>Quintic Term</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetQuinticTerm()
	 * @see #getQuinticTerm()
	 * @see #setQuinticTerm(double)
	 * @generated
	 */
	void unsetQuinticTerm();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral#getQuinticTerm <em>Quintic Term</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Quintic Term</em>' attribute is set.
	 * @see #unsetQuinticTerm()
	 * @see #getQuinticTerm()
	 * @see #setQuinticTerm(double)
	 * @generated
	 */
	boolean isSetQuinticTerm();

	/**
	 * Returns the value of the '<em><b>Quintic Term As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Quintic Term As String</em>' attribute.
	 * @see #isSetQuinticTermAsString()
	 * @see #unsetQuinticTermAsString()
	 * @see #setQuinticTermAsString(String)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcSeventhOrderPolynomialSpiral_QuinticTermAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getQuinticTermAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral#getQuinticTermAsString <em>Quintic Term As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quintic Term As String</em>' attribute.
	 * @see #isSetQuinticTermAsString()
	 * @see #unsetQuinticTermAsString()
	 * @see #getQuinticTermAsString()
	 * @generated
	 */
	void setQuinticTermAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral#getQuinticTermAsString <em>Quintic Term As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetQuinticTermAsString()
	 * @see #getQuinticTermAsString()
	 * @see #setQuinticTermAsString(String)
	 * @generated
	 */
	void unsetQuinticTermAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral#getQuinticTermAsString <em>Quintic Term As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Quintic Term As String</em>' attribute is set.
	 * @see #unsetQuinticTermAsString()
	 * @see #getQuinticTermAsString()
	 * @see #setQuinticTermAsString(String)
	 * @generated
	 */
	boolean isSetQuinticTermAsString();

	/**
	 * Returns the value of the '<em><b>Quartic Term</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Quartic Term</em>' attribute.
	 * @see #isSetQuarticTerm()
	 * @see #unsetQuarticTerm()
	 * @see #setQuarticTerm(double)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcSeventhOrderPolynomialSpiral_QuarticTerm()
	 * @model unsettable="true"
	 * @generated
	 */
	double getQuarticTerm();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral#getQuarticTerm <em>Quartic Term</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quartic Term</em>' attribute.
	 * @see #isSetQuarticTerm()
	 * @see #unsetQuarticTerm()
	 * @see #getQuarticTerm()
	 * @generated
	 */
	void setQuarticTerm(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral#getQuarticTerm <em>Quartic Term</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetQuarticTerm()
	 * @see #getQuarticTerm()
	 * @see #setQuarticTerm(double)
	 * @generated
	 */
	void unsetQuarticTerm();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral#getQuarticTerm <em>Quartic Term</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Quartic Term</em>' attribute is set.
	 * @see #unsetQuarticTerm()
	 * @see #getQuarticTerm()
	 * @see #setQuarticTerm(double)
	 * @generated
	 */
	boolean isSetQuarticTerm();

	/**
	 * Returns the value of the '<em><b>Quartic Term As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Quartic Term As String</em>' attribute.
	 * @see #isSetQuarticTermAsString()
	 * @see #unsetQuarticTermAsString()
	 * @see #setQuarticTermAsString(String)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcSeventhOrderPolynomialSpiral_QuarticTermAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getQuarticTermAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral#getQuarticTermAsString <em>Quartic Term As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quartic Term As String</em>' attribute.
	 * @see #isSetQuarticTermAsString()
	 * @see #unsetQuarticTermAsString()
	 * @see #getQuarticTermAsString()
	 * @generated
	 */
	void setQuarticTermAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral#getQuarticTermAsString <em>Quartic Term As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetQuarticTermAsString()
	 * @see #getQuarticTermAsString()
	 * @see #setQuarticTermAsString(String)
	 * @generated
	 */
	void unsetQuarticTermAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral#getQuarticTermAsString <em>Quartic Term As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Quartic Term As String</em>' attribute is set.
	 * @see #unsetQuarticTermAsString()
	 * @see #getQuarticTermAsString()
	 * @see #setQuarticTermAsString(String)
	 * @generated
	 */
	boolean isSetQuarticTermAsString();

	/**
	 * Returns the value of the '<em><b>Cubic Term</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cubic Term</em>' attribute.
	 * @see #isSetCubicTerm()
	 * @see #unsetCubicTerm()
	 * @see #setCubicTerm(double)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcSeventhOrderPolynomialSpiral_CubicTerm()
	 * @model unsettable="true"
	 * @generated
	 */
	double getCubicTerm();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral#getCubicTerm <em>Cubic Term</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cubic Term</em>' attribute.
	 * @see #isSetCubicTerm()
	 * @see #unsetCubicTerm()
	 * @see #getCubicTerm()
	 * @generated
	 */
	void setCubicTerm(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral#getCubicTerm <em>Cubic Term</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCubicTerm()
	 * @see #getCubicTerm()
	 * @see #setCubicTerm(double)
	 * @generated
	 */
	void unsetCubicTerm();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral#getCubicTerm <em>Cubic Term</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Cubic Term</em>' attribute is set.
	 * @see #unsetCubicTerm()
	 * @see #getCubicTerm()
	 * @see #setCubicTerm(double)
	 * @generated
	 */
	boolean isSetCubicTerm();

	/**
	 * Returns the value of the '<em><b>Cubic Term As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cubic Term As String</em>' attribute.
	 * @see #isSetCubicTermAsString()
	 * @see #unsetCubicTermAsString()
	 * @see #setCubicTermAsString(String)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcSeventhOrderPolynomialSpiral_CubicTermAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getCubicTermAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral#getCubicTermAsString <em>Cubic Term As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cubic Term As String</em>' attribute.
	 * @see #isSetCubicTermAsString()
	 * @see #unsetCubicTermAsString()
	 * @see #getCubicTermAsString()
	 * @generated
	 */
	void setCubicTermAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral#getCubicTermAsString <em>Cubic Term As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCubicTermAsString()
	 * @see #getCubicTermAsString()
	 * @see #setCubicTermAsString(String)
	 * @generated
	 */
	void unsetCubicTermAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral#getCubicTermAsString <em>Cubic Term As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Cubic Term As String</em>' attribute is set.
	 * @see #unsetCubicTermAsString()
	 * @see #getCubicTermAsString()
	 * @see #setCubicTermAsString(String)
	 * @generated
	 */
	boolean isSetCubicTermAsString();

	/**
	 * Returns the value of the '<em><b>Quadratic Term</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Quadratic Term</em>' attribute.
	 * @see #isSetQuadraticTerm()
	 * @see #unsetQuadraticTerm()
	 * @see #setQuadraticTerm(double)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcSeventhOrderPolynomialSpiral_QuadraticTerm()
	 * @model unsettable="true"
	 * @generated
	 */
	double getQuadraticTerm();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral#getQuadraticTerm <em>Quadratic Term</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral#getQuadraticTerm <em>Quadratic Term</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetQuadraticTerm()
	 * @see #getQuadraticTerm()
	 * @see #setQuadraticTerm(double)
	 * @generated
	 */
	void unsetQuadraticTerm();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral#getQuadraticTerm <em>Quadratic Term</em>}' attribute is set.
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
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcSeventhOrderPolynomialSpiral_QuadraticTermAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getQuadraticTermAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral#getQuadraticTermAsString <em>Quadratic Term As String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral#getQuadraticTermAsString <em>Quadratic Term As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetQuadraticTermAsString()
	 * @see #getQuadraticTermAsString()
	 * @see #setQuadraticTermAsString(String)
	 * @generated
	 */
	void unsetQuadraticTermAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral#getQuadraticTermAsString <em>Quadratic Term As String</em>}' attribute is set.
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
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcSeventhOrderPolynomialSpiral_LinearTerm()
	 * @model unsettable="true"
	 * @generated
	 */
	double getLinearTerm();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral#getLinearTerm <em>Linear Term</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral#getLinearTerm <em>Linear Term</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLinearTerm()
	 * @see #getLinearTerm()
	 * @see #setLinearTerm(double)
	 * @generated
	 */
	void unsetLinearTerm();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral#getLinearTerm <em>Linear Term</em>}' attribute is set.
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
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcSeventhOrderPolynomialSpiral_LinearTermAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getLinearTermAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral#getLinearTermAsString <em>Linear Term As String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral#getLinearTermAsString <em>Linear Term As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLinearTermAsString()
	 * @see #getLinearTermAsString()
	 * @see #setLinearTermAsString(String)
	 * @generated
	 */
	void unsetLinearTermAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral#getLinearTermAsString <em>Linear Term As String</em>}' attribute is set.
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
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcSeventhOrderPolynomialSpiral_ConstantTerm()
	 * @model unsettable="true"
	 * @generated
	 */
	double getConstantTerm();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral#getConstantTerm <em>Constant Term</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral#getConstantTerm <em>Constant Term</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetConstantTerm()
	 * @see #getConstantTerm()
	 * @see #setConstantTerm(double)
	 * @generated
	 */
	void unsetConstantTerm();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral#getConstantTerm <em>Constant Term</em>}' attribute is set.
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
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcSeventhOrderPolynomialSpiral_ConstantTermAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getConstantTermAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral#getConstantTermAsString <em>Constant Term As String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral#getConstantTermAsString <em>Constant Term As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetConstantTermAsString()
	 * @see #getConstantTermAsString()
	 * @see #setConstantTermAsString(String)
	 * @generated
	 */
	void unsetConstantTermAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcSeventhOrderPolynomialSpiral#getConstantTermAsString <em>Constant Term As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Constant Term As String</em>' attribute is set.
	 * @see #unsetConstantTermAsString()
	 * @see #getConstantTermAsString()
	 * @see #setConstantTermAsString(String)
	 * @generated
	 */
	boolean isSetConstantTermAsString();

} // IfcSeventhOrderPolynomialSpiral

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
 * A representation of the model object '<em><b>Ifc Map Conversion Scaled</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcMapConversionScaled#getFactorX <em>Factor X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcMapConversionScaled#getFactorXAsString <em>Factor XAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcMapConversionScaled#getFactorY <em>Factor Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcMapConversionScaled#getFactorYAsString <em>Factor YAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcMapConversionScaled#getFactorZ <em>Factor Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcMapConversionScaled#getFactorZAsString <em>Factor ZAs String</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcMapConversionScaled()
 * @model
 * @generated
 */
public interface IfcMapConversionScaled extends IfcMapConversion {
	/**
	 * Returns the value of the '<em><b>Factor X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Factor X</em>' attribute.
	 * @see #setFactorX(double)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcMapConversionScaled_FactorX()
	 * @model
	 * @generated
	 */
	double getFactorX();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcMapConversionScaled#getFactorX <em>Factor X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Factor X</em>' attribute.
	 * @see #getFactorX()
	 * @generated
	 */
	void setFactorX(double value);

	/**
	 * Returns the value of the '<em><b>Factor XAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Factor XAs String</em>' attribute.
	 * @see #setFactorXAsString(String)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcMapConversionScaled_FactorXAsString()
	 * @model annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getFactorXAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcMapConversionScaled#getFactorXAsString <em>Factor XAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Factor XAs String</em>' attribute.
	 * @see #getFactorXAsString()
	 * @generated
	 */
	void setFactorXAsString(String value);

	/**
	 * Returns the value of the '<em><b>Factor Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Factor Y</em>' attribute.
	 * @see #setFactorY(double)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcMapConversionScaled_FactorY()
	 * @model
	 * @generated
	 */
	double getFactorY();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcMapConversionScaled#getFactorY <em>Factor Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Factor Y</em>' attribute.
	 * @see #getFactorY()
	 * @generated
	 */
	void setFactorY(double value);

	/**
	 * Returns the value of the '<em><b>Factor YAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Factor YAs String</em>' attribute.
	 * @see #setFactorYAsString(String)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcMapConversionScaled_FactorYAsString()
	 * @model annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getFactorYAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcMapConversionScaled#getFactorYAsString <em>Factor YAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Factor YAs String</em>' attribute.
	 * @see #getFactorYAsString()
	 * @generated
	 */
	void setFactorYAsString(String value);

	/**
	 * Returns the value of the '<em><b>Factor Z</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Factor Z</em>' attribute.
	 * @see #setFactorZ(double)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcMapConversionScaled_FactorZ()
	 * @model
	 * @generated
	 */
	double getFactorZ();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcMapConversionScaled#getFactorZ <em>Factor Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Factor Z</em>' attribute.
	 * @see #getFactorZ()
	 * @generated
	 */
	void setFactorZ(double value);

	/**
	 * Returns the value of the '<em><b>Factor ZAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Factor ZAs String</em>' attribute.
	 * @see #setFactorZAsString(String)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcMapConversionScaled_FactorZAsString()
	 * @model annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getFactorZAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcMapConversionScaled#getFactorZAsString <em>Factor ZAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Factor ZAs String</em>' attribute.
	 * @see #getFactorZAsString()
	 * @generated
	 */
	void setFactorZAsString(String value);

} // IfcMapConversionScaled

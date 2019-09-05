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
package org.bimserver.models.ifc4;

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

public interface IfcMapConversion extends IfcCoordinateOperation {
	/**
	 * Returns the value of the '<em><b>Eastings</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Eastings</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Eastings</em>' attribute.
	 * @see #setEastings(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMapConversion_Eastings()
	 * @model
	 * @generated
	 */
	double getEastings();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMapConversion#getEastings <em>Eastings</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Eastings</em>' attribute.
	 * @see #getEastings()
	 * @generated
	 */
	void setEastings(double value);

	/**
	 * Returns the value of the '<em><b>Eastings As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Eastings As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Eastings As String</em>' attribute.
	 * @see #setEastingsAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMapConversion_EastingsAsString()
	 * @model annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getEastingsAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMapConversion#getEastingsAsString <em>Eastings As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Eastings As String</em>' attribute.
	 * @see #getEastingsAsString()
	 * @generated
	 */
	void setEastingsAsString(String value);

	/**
	 * Returns the value of the '<em><b>Northings</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Northings</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Northings</em>' attribute.
	 * @see #setNorthings(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMapConversion_Northings()
	 * @model
	 * @generated
	 */
	double getNorthings();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMapConversion#getNorthings <em>Northings</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Northings</em>' attribute.
	 * @see #getNorthings()
	 * @generated
	 */
	void setNorthings(double value);

	/**
	 * Returns the value of the '<em><b>Northings As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Northings As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Northings As String</em>' attribute.
	 * @see #setNorthingsAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMapConversion_NorthingsAsString()
	 * @model annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getNorthingsAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMapConversion#getNorthingsAsString <em>Northings As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Northings As String</em>' attribute.
	 * @see #getNorthingsAsString()
	 * @generated
	 */
	void setNorthingsAsString(String value);

	/**
	 * Returns the value of the '<em><b>Orthogonal Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Orthogonal Height</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Orthogonal Height</em>' attribute.
	 * @see #setOrthogonalHeight(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMapConversion_OrthogonalHeight()
	 * @model
	 * @generated
	 */
	double getOrthogonalHeight();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMapConversion#getOrthogonalHeight <em>Orthogonal Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Orthogonal Height</em>' attribute.
	 * @see #getOrthogonalHeight()
	 * @generated
	 */
	void setOrthogonalHeight(double value);

	/**
	 * Returns the value of the '<em><b>Orthogonal Height As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Orthogonal Height As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Orthogonal Height As String</em>' attribute.
	 * @see #setOrthogonalHeightAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMapConversion_OrthogonalHeightAsString()
	 * @model annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getOrthogonalHeightAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMapConversion#getOrthogonalHeightAsString <em>Orthogonal Height As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Orthogonal Height As String</em>' attribute.
	 * @see #getOrthogonalHeightAsString()
	 * @generated
	 */
	void setOrthogonalHeightAsString(String value);

	/**
	 * Returns the value of the '<em><b>XAxis Abscissa</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XAxis Abscissa</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XAxis Abscissa</em>' attribute.
	 * @see #isSetXAxisAbscissa()
	 * @see #unsetXAxisAbscissa()
	 * @see #setXAxisAbscissa(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMapConversion_XAxisAbscissa()
	 * @model unsettable="true"
	 * @generated
	 */
	double getXAxisAbscissa();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMapConversion#getXAxisAbscissa <em>XAxis Abscissa</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>XAxis Abscissa</em>' attribute.
	 * @see #isSetXAxisAbscissa()
	 * @see #unsetXAxisAbscissa()
	 * @see #getXAxisAbscissa()
	 * @generated
	 */
	void setXAxisAbscissa(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcMapConversion#getXAxisAbscissa <em>XAxis Abscissa</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetXAxisAbscissa()
	 * @see #getXAxisAbscissa()
	 * @see #setXAxisAbscissa(double)
	 * @generated
	 */
	void unsetXAxisAbscissa();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcMapConversion#getXAxisAbscissa <em>XAxis Abscissa</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>XAxis Abscissa</em>' attribute is set.
	 * @see #unsetXAxisAbscissa()
	 * @see #getXAxisAbscissa()
	 * @see #setXAxisAbscissa(double)
	 * @generated
	 */
	boolean isSetXAxisAbscissa();

	/**
	 * Returns the value of the '<em><b>XAxis Abscissa As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XAxis Abscissa As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XAxis Abscissa As String</em>' attribute.
	 * @see #isSetXAxisAbscissaAsString()
	 * @see #unsetXAxisAbscissaAsString()
	 * @see #setXAxisAbscissaAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMapConversion_XAxisAbscissaAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getXAxisAbscissaAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMapConversion#getXAxisAbscissaAsString <em>XAxis Abscissa As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>XAxis Abscissa As String</em>' attribute.
	 * @see #isSetXAxisAbscissaAsString()
	 * @see #unsetXAxisAbscissaAsString()
	 * @see #getXAxisAbscissaAsString()
	 * @generated
	 */
	void setXAxisAbscissaAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcMapConversion#getXAxisAbscissaAsString <em>XAxis Abscissa As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetXAxisAbscissaAsString()
	 * @see #getXAxisAbscissaAsString()
	 * @see #setXAxisAbscissaAsString(String)
	 * @generated
	 */
	void unsetXAxisAbscissaAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcMapConversion#getXAxisAbscissaAsString <em>XAxis Abscissa As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>XAxis Abscissa As String</em>' attribute is set.
	 * @see #unsetXAxisAbscissaAsString()
	 * @see #getXAxisAbscissaAsString()
	 * @see #setXAxisAbscissaAsString(String)
	 * @generated
	 */
	boolean isSetXAxisAbscissaAsString();

	/**
	 * Returns the value of the '<em><b>XAxis Ordinate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XAxis Ordinate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XAxis Ordinate</em>' attribute.
	 * @see #isSetXAxisOrdinate()
	 * @see #unsetXAxisOrdinate()
	 * @see #setXAxisOrdinate(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMapConversion_XAxisOrdinate()
	 * @model unsettable="true"
	 * @generated
	 */
	double getXAxisOrdinate();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMapConversion#getXAxisOrdinate <em>XAxis Ordinate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>XAxis Ordinate</em>' attribute.
	 * @see #isSetXAxisOrdinate()
	 * @see #unsetXAxisOrdinate()
	 * @see #getXAxisOrdinate()
	 * @generated
	 */
	void setXAxisOrdinate(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcMapConversion#getXAxisOrdinate <em>XAxis Ordinate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetXAxisOrdinate()
	 * @see #getXAxisOrdinate()
	 * @see #setXAxisOrdinate(double)
	 * @generated
	 */
	void unsetXAxisOrdinate();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcMapConversion#getXAxisOrdinate <em>XAxis Ordinate</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>XAxis Ordinate</em>' attribute is set.
	 * @see #unsetXAxisOrdinate()
	 * @see #getXAxisOrdinate()
	 * @see #setXAxisOrdinate(double)
	 * @generated
	 */
	boolean isSetXAxisOrdinate();

	/**
	 * Returns the value of the '<em><b>XAxis Ordinate As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XAxis Ordinate As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XAxis Ordinate As String</em>' attribute.
	 * @see #isSetXAxisOrdinateAsString()
	 * @see #unsetXAxisOrdinateAsString()
	 * @see #setXAxisOrdinateAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMapConversion_XAxisOrdinateAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getXAxisOrdinateAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMapConversion#getXAxisOrdinateAsString <em>XAxis Ordinate As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>XAxis Ordinate As String</em>' attribute.
	 * @see #isSetXAxisOrdinateAsString()
	 * @see #unsetXAxisOrdinateAsString()
	 * @see #getXAxisOrdinateAsString()
	 * @generated
	 */
	void setXAxisOrdinateAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcMapConversion#getXAxisOrdinateAsString <em>XAxis Ordinate As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetXAxisOrdinateAsString()
	 * @see #getXAxisOrdinateAsString()
	 * @see #setXAxisOrdinateAsString(String)
	 * @generated
	 */
	void unsetXAxisOrdinateAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcMapConversion#getXAxisOrdinateAsString <em>XAxis Ordinate As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>XAxis Ordinate As String</em>' attribute is set.
	 * @see #unsetXAxisOrdinateAsString()
	 * @see #getXAxisOrdinateAsString()
	 * @see #setXAxisOrdinateAsString(String)
	 * @generated
	 */
	boolean isSetXAxisOrdinateAsString();

	/**
	 * Returns the value of the '<em><b>Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scale</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scale</em>' attribute.
	 * @see #isSetScale()
	 * @see #unsetScale()
	 * @see #setScale(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMapConversion_Scale()
	 * @model unsettable="true"
	 * @generated
	 */
	double getScale();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMapConversion#getScale <em>Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scale</em>' attribute.
	 * @see #isSetScale()
	 * @see #unsetScale()
	 * @see #getScale()
	 * @generated
	 */
	void setScale(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcMapConversion#getScale <em>Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetScale()
	 * @see #getScale()
	 * @see #setScale(double)
	 * @generated
	 */
	void unsetScale();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcMapConversion#getScale <em>Scale</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Scale</em>' attribute is set.
	 * @see #unsetScale()
	 * @see #getScale()
	 * @see #setScale(double)
	 * @generated
	 */
	boolean isSetScale();

	/**
	 * Returns the value of the '<em><b>Scale As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scale As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scale As String</em>' attribute.
	 * @see #isSetScaleAsString()
	 * @see #unsetScaleAsString()
	 * @see #setScaleAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcMapConversion_ScaleAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getScaleAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcMapConversion#getScaleAsString <em>Scale As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scale As String</em>' attribute.
	 * @see #isSetScaleAsString()
	 * @see #unsetScaleAsString()
	 * @see #getScaleAsString()
	 * @generated
	 */
	void setScaleAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcMapConversion#getScaleAsString <em>Scale As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetScaleAsString()
	 * @see #getScaleAsString()
	 * @see #setScaleAsString(String)
	 * @generated
	 */
	void unsetScaleAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcMapConversion#getScaleAsString <em>Scale As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Scale As String</em>' attribute is set.
	 * @see #unsetScaleAsString()
	 * @see #getScaleAsString()
	 * @see #setScaleAsString(String)
	 * @generated
	 */
	boolean isSetScaleAsString();

} // IfcMapConversion

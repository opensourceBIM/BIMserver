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
 * A representation of the model object '<em><b>Ifc Rectangular Trimmed Surface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRectangularTrimmedSurface#getBasisSurface <em>Basis Surface</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRectangularTrimmedSurface#getU1 <em>U1</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRectangularTrimmedSurface#getU1AsString <em>U1 As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRectangularTrimmedSurface#getV1 <em>V1</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRectangularTrimmedSurface#getV1AsString <em>V1 As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRectangularTrimmedSurface#getU2 <em>U2</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRectangularTrimmedSurface#getU2AsString <em>U2 As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRectangularTrimmedSurface#getV2 <em>V2</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRectangularTrimmedSurface#getV2AsString <em>V2 As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRectangularTrimmedSurface#getUsense <em>Usense</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRectangularTrimmedSurface#getVsense <em>Vsense</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRectangularTrimmedSurface#getDim <em>Dim</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRectangularTrimmedSurface()
 * @model
 * @generated
 */
public interface IfcRectangularTrimmedSurface extends IfcBoundedSurface {
	/**
	 * Returns the value of the '<em><b>Basis Surface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Basis Surface</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Basis Surface</em>' reference.
	 * @see #isSetBasisSurface()
	 * @see #unsetBasisSurface()
	 * @see #setBasisSurface(IfcSurface)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRectangularTrimmedSurface_BasisSurface()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcSurface getBasisSurface();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRectangularTrimmedSurface#getBasisSurface <em>Basis Surface</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Basis Surface</em>' reference.
	 * @see #isSetBasisSurface()
	 * @see #unsetBasisSurface()
	 * @see #getBasisSurface()
	 * @generated
	 */
	void setBasisSurface(IfcSurface value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRectangularTrimmedSurface#getBasisSurface <em>Basis Surface</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBasisSurface()
	 * @see #getBasisSurface()
	 * @see #setBasisSurface(IfcSurface)
	 * @generated
	 */
	void unsetBasisSurface();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRectangularTrimmedSurface#getBasisSurface <em>Basis Surface</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Basis Surface</em>' reference is set.
	 * @see #unsetBasisSurface()
	 * @see #getBasisSurface()
	 * @see #setBasisSurface(IfcSurface)
	 * @generated
	 */
	boolean isSetBasisSurface();

	/**
	 * Returns the value of the '<em><b>U1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>U1</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>U1</em>' attribute.
	 * @see #isSetU1()
	 * @see #unsetU1()
	 * @see #setU1(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRectangularTrimmedSurface_U1()
	 * @model unsettable="true"
	 * @generated
	 */
	double getU1();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRectangularTrimmedSurface#getU1 <em>U1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>U1</em>' attribute.
	 * @see #isSetU1()
	 * @see #unsetU1()
	 * @see #getU1()
	 * @generated
	 */
	void setU1(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRectangularTrimmedSurface#getU1 <em>U1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetU1()
	 * @see #getU1()
	 * @see #setU1(double)
	 * @generated
	 */
	void unsetU1();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRectangularTrimmedSurface#getU1 <em>U1</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>U1</em>' attribute is set.
	 * @see #unsetU1()
	 * @see #getU1()
	 * @see #setU1(double)
	 * @generated
	 */
	boolean isSetU1();

	/**
	 * Returns the value of the '<em><b>U1 As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>U1 As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>U1 As String</em>' attribute.
	 * @see #isSetU1AsString()
	 * @see #unsetU1AsString()
	 * @see #setU1AsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRectangularTrimmedSurface_U1AsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getU1AsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRectangularTrimmedSurface#getU1AsString <em>U1 As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>U1 As String</em>' attribute.
	 * @see #isSetU1AsString()
	 * @see #unsetU1AsString()
	 * @see #getU1AsString()
	 * @generated
	 */
	void setU1AsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRectangularTrimmedSurface#getU1AsString <em>U1 As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetU1AsString()
	 * @see #getU1AsString()
	 * @see #setU1AsString(String)
	 * @generated
	 */
	void unsetU1AsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRectangularTrimmedSurface#getU1AsString <em>U1 As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>U1 As String</em>' attribute is set.
	 * @see #unsetU1AsString()
	 * @see #getU1AsString()
	 * @see #setU1AsString(String)
	 * @generated
	 */
	boolean isSetU1AsString();

	/**
	 * Returns the value of the '<em><b>V1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>V1</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>V1</em>' attribute.
	 * @see #isSetV1()
	 * @see #unsetV1()
	 * @see #setV1(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRectangularTrimmedSurface_V1()
	 * @model unsettable="true"
	 * @generated
	 */
	double getV1();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRectangularTrimmedSurface#getV1 <em>V1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>V1</em>' attribute.
	 * @see #isSetV1()
	 * @see #unsetV1()
	 * @see #getV1()
	 * @generated
	 */
	void setV1(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRectangularTrimmedSurface#getV1 <em>V1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetV1()
	 * @see #getV1()
	 * @see #setV1(double)
	 * @generated
	 */
	void unsetV1();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRectangularTrimmedSurface#getV1 <em>V1</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>V1</em>' attribute is set.
	 * @see #unsetV1()
	 * @see #getV1()
	 * @see #setV1(double)
	 * @generated
	 */
	boolean isSetV1();

	/**
	 * Returns the value of the '<em><b>V1 As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>V1 As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>V1 As String</em>' attribute.
	 * @see #isSetV1AsString()
	 * @see #unsetV1AsString()
	 * @see #setV1AsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRectangularTrimmedSurface_V1AsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getV1AsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRectangularTrimmedSurface#getV1AsString <em>V1 As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>V1 As String</em>' attribute.
	 * @see #isSetV1AsString()
	 * @see #unsetV1AsString()
	 * @see #getV1AsString()
	 * @generated
	 */
	void setV1AsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRectangularTrimmedSurface#getV1AsString <em>V1 As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetV1AsString()
	 * @see #getV1AsString()
	 * @see #setV1AsString(String)
	 * @generated
	 */
	void unsetV1AsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRectangularTrimmedSurface#getV1AsString <em>V1 As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>V1 As String</em>' attribute is set.
	 * @see #unsetV1AsString()
	 * @see #getV1AsString()
	 * @see #setV1AsString(String)
	 * @generated
	 */
	boolean isSetV1AsString();

	/**
	 * Returns the value of the '<em><b>U2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>U2</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>U2</em>' attribute.
	 * @see #isSetU2()
	 * @see #unsetU2()
	 * @see #setU2(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRectangularTrimmedSurface_U2()
	 * @model unsettable="true"
	 * @generated
	 */
	double getU2();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRectangularTrimmedSurface#getU2 <em>U2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>U2</em>' attribute.
	 * @see #isSetU2()
	 * @see #unsetU2()
	 * @see #getU2()
	 * @generated
	 */
	void setU2(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRectangularTrimmedSurface#getU2 <em>U2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetU2()
	 * @see #getU2()
	 * @see #setU2(double)
	 * @generated
	 */
	void unsetU2();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRectangularTrimmedSurface#getU2 <em>U2</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>U2</em>' attribute is set.
	 * @see #unsetU2()
	 * @see #getU2()
	 * @see #setU2(double)
	 * @generated
	 */
	boolean isSetU2();

	/**
	 * Returns the value of the '<em><b>U2 As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>U2 As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>U2 As String</em>' attribute.
	 * @see #isSetU2AsString()
	 * @see #unsetU2AsString()
	 * @see #setU2AsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRectangularTrimmedSurface_U2AsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getU2AsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRectangularTrimmedSurface#getU2AsString <em>U2 As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>U2 As String</em>' attribute.
	 * @see #isSetU2AsString()
	 * @see #unsetU2AsString()
	 * @see #getU2AsString()
	 * @generated
	 */
	void setU2AsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRectangularTrimmedSurface#getU2AsString <em>U2 As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetU2AsString()
	 * @see #getU2AsString()
	 * @see #setU2AsString(String)
	 * @generated
	 */
	void unsetU2AsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRectangularTrimmedSurface#getU2AsString <em>U2 As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>U2 As String</em>' attribute is set.
	 * @see #unsetU2AsString()
	 * @see #getU2AsString()
	 * @see #setU2AsString(String)
	 * @generated
	 */
	boolean isSetU2AsString();

	/**
	 * Returns the value of the '<em><b>V2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>V2</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>V2</em>' attribute.
	 * @see #isSetV2()
	 * @see #unsetV2()
	 * @see #setV2(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRectangularTrimmedSurface_V2()
	 * @model unsettable="true"
	 * @generated
	 */
	double getV2();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRectangularTrimmedSurface#getV2 <em>V2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>V2</em>' attribute.
	 * @see #isSetV2()
	 * @see #unsetV2()
	 * @see #getV2()
	 * @generated
	 */
	void setV2(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRectangularTrimmedSurface#getV2 <em>V2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetV2()
	 * @see #getV2()
	 * @see #setV2(double)
	 * @generated
	 */
	void unsetV2();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRectangularTrimmedSurface#getV2 <em>V2</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>V2</em>' attribute is set.
	 * @see #unsetV2()
	 * @see #getV2()
	 * @see #setV2(double)
	 * @generated
	 */
	boolean isSetV2();

	/**
	 * Returns the value of the '<em><b>V2 As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>V2 As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>V2 As String</em>' attribute.
	 * @see #isSetV2AsString()
	 * @see #unsetV2AsString()
	 * @see #setV2AsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRectangularTrimmedSurface_V2AsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getV2AsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRectangularTrimmedSurface#getV2AsString <em>V2 As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>V2 As String</em>' attribute.
	 * @see #isSetV2AsString()
	 * @see #unsetV2AsString()
	 * @see #getV2AsString()
	 * @generated
	 */
	void setV2AsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRectangularTrimmedSurface#getV2AsString <em>V2 As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetV2AsString()
	 * @see #getV2AsString()
	 * @see #setV2AsString(String)
	 * @generated
	 */
	void unsetV2AsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRectangularTrimmedSurface#getV2AsString <em>V2 As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>V2 As String</em>' attribute is set.
	 * @see #unsetV2AsString()
	 * @see #getV2AsString()
	 * @see #setV2AsString(String)
	 * @generated
	 */
	boolean isSetV2AsString();

	/**
	 * Returns the value of the '<em><b>Usense</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.Tristate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Usense</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Usense</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.Tristate
	 * @see #isSetUsense()
	 * @see #unsetUsense()
	 * @see #setUsense(Tristate)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRectangularTrimmedSurface_Usense()
	 * @model unsettable="true"
	 * @generated
	 */
	Tristate getUsense();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRectangularTrimmedSurface#getUsense <em>Usense</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Usense</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.Tristate
	 * @see #isSetUsense()
	 * @see #unsetUsense()
	 * @see #getUsense()
	 * @generated
	 */
	void setUsense(Tristate value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRectangularTrimmedSurface#getUsense <em>Usense</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUsense()
	 * @see #getUsense()
	 * @see #setUsense(Tristate)
	 * @generated
	 */
	void unsetUsense();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRectangularTrimmedSurface#getUsense <em>Usense</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Usense</em>' attribute is set.
	 * @see #unsetUsense()
	 * @see #getUsense()
	 * @see #setUsense(Tristate)
	 * @generated
	 */
	boolean isSetUsense();

	/**
	 * Returns the value of the '<em><b>Vsense</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.Tristate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vsense</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vsense</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.Tristate
	 * @see #isSetVsense()
	 * @see #unsetVsense()
	 * @see #setVsense(Tristate)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRectangularTrimmedSurface_Vsense()
	 * @model unsettable="true"
	 * @generated
	 */
	Tristate getVsense();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRectangularTrimmedSurface#getVsense <em>Vsense</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vsense</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.Tristate
	 * @see #isSetVsense()
	 * @see #unsetVsense()
	 * @see #getVsense()
	 * @generated
	 */
	void setVsense(Tristate value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRectangularTrimmedSurface#getVsense <em>Vsense</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetVsense()
	 * @see #getVsense()
	 * @see #setVsense(Tristate)
	 * @generated
	 */
	void unsetVsense();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRectangularTrimmedSurface#getVsense <em>Vsense</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Vsense</em>' attribute is set.
	 * @see #unsetVsense()
	 * @see #getVsense()
	 * @see #setVsense(Tristate)
	 * @generated
	 */
	boolean isSetVsense();

	/**
	 * Returns the value of the '<em><b>Dim</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dim</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dim</em>' attribute.
	 * @see #isSetDim()
	 * @see #unsetDim()
	 * @see #setDim(int)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRectangularTrimmedSurface_Dim()
	 * @model unsettable="true" derived="true"
	 * @generated
	 */
	int getDim();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRectangularTrimmedSurface#getDim <em>Dim</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dim</em>' attribute.
	 * @see #isSetDim()
	 * @see #unsetDim()
	 * @see #getDim()
	 * @generated
	 */
	void setDim(int value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcRectangularTrimmedSurface#getDim <em>Dim</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDim()
	 * @see #getDim()
	 * @see #setDim(int)
	 * @generated
	 */
	void unsetDim();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcRectangularTrimmedSurface#getDim <em>Dim</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Dim</em>' attribute is set.
	 * @see #unsetDim()
	 * @see #getDim()
	 * @see #setDim(int)
	 * @generated
	 */
	boolean isSetDim();

} // IfcRectangularTrimmedSurface

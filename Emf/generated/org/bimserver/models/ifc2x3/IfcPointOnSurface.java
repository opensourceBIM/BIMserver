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
 * A representation of the model object '<em><b>Ifc Point On Surface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcPointOnSurface#getBasisSurface <em>Basis Surface</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcPointOnSurface#getPointParameterU <em>Point Parameter U</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcPointOnSurface#getPointParameterUAsString <em>Point Parameter UAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcPointOnSurface#getPointParameterV <em>Point Parameter V</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcPointOnSurface#getPointParameterVAsString <em>Point Parameter VAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcPointOnSurface#getDim <em>Dim</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPointOnSurface()
 * @model
 * @generated
 */
public interface IfcPointOnSurface extends IfcPoint {
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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPointOnSurface_BasisSurface()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcSurface getBasisSurface();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcPointOnSurface#getBasisSurface <em>Basis Surface</em>}' reference.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcPointOnSurface#getBasisSurface <em>Basis Surface</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBasisSurface()
	 * @see #getBasisSurface()
	 * @see #setBasisSurface(IfcSurface)
	 * @generated
	 */
	void unsetBasisSurface();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcPointOnSurface#getBasisSurface <em>Basis Surface</em>}' reference is set.
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
	 * Returns the value of the '<em><b>Point Parameter U</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Point Parameter U</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Point Parameter U</em>' attribute.
	 * @see #isSetPointParameterU()
	 * @see #unsetPointParameterU()
	 * @see #setPointParameterU(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPointOnSurface_PointParameterU()
	 * @model unsettable="true"
	 * @generated
	 */
	double getPointParameterU();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcPointOnSurface#getPointParameterU <em>Point Parameter U</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Point Parameter U</em>' attribute.
	 * @see #isSetPointParameterU()
	 * @see #unsetPointParameterU()
	 * @see #getPointParameterU()
	 * @generated
	 */
	void setPointParameterU(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcPointOnSurface#getPointParameterU <em>Point Parameter U</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPointParameterU()
	 * @see #getPointParameterU()
	 * @see #setPointParameterU(double)
	 * @generated
	 */
	void unsetPointParameterU();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcPointOnSurface#getPointParameterU <em>Point Parameter U</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Point Parameter U</em>' attribute is set.
	 * @see #unsetPointParameterU()
	 * @see #getPointParameterU()
	 * @see #setPointParameterU(double)
	 * @generated
	 */
	boolean isSetPointParameterU();

	/**
	 * Returns the value of the '<em><b>Point Parameter UAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Point Parameter UAs String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Point Parameter UAs String</em>' attribute.
	 * @see #isSetPointParameterUAsString()
	 * @see #unsetPointParameterUAsString()
	 * @see #setPointParameterUAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPointOnSurface_PointParameterUAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getPointParameterUAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcPointOnSurface#getPointParameterUAsString <em>Point Parameter UAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Point Parameter UAs String</em>' attribute.
	 * @see #isSetPointParameterUAsString()
	 * @see #unsetPointParameterUAsString()
	 * @see #getPointParameterUAsString()
	 * @generated
	 */
	void setPointParameterUAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcPointOnSurface#getPointParameterUAsString <em>Point Parameter UAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPointParameterUAsString()
	 * @see #getPointParameterUAsString()
	 * @see #setPointParameterUAsString(String)
	 * @generated
	 */
	void unsetPointParameterUAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcPointOnSurface#getPointParameterUAsString <em>Point Parameter UAs String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Point Parameter UAs String</em>' attribute is set.
	 * @see #unsetPointParameterUAsString()
	 * @see #getPointParameterUAsString()
	 * @see #setPointParameterUAsString(String)
	 * @generated
	 */
	boolean isSetPointParameterUAsString();

	/**
	 * Returns the value of the '<em><b>Point Parameter V</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Point Parameter V</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Point Parameter V</em>' attribute.
	 * @see #isSetPointParameterV()
	 * @see #unsetPointParameterV()
	 * @see #setPointParameterV(double)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPointOnSurface_PointParameterV()
	 * @model unsettable="true"
	 * @generated
	 */
	double getPointParameterV();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcPointOnSurface#getPointParameterV <em>Point Parameter V</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Point Parameter V</em>' attribute.
	 * @see #isSetPointParameterV()
	 * @see #unsetPointParameterV()
	 * @see #getPointParameterV()
	 * @generated
	 */
	void setPointParameterV(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcPointOnSurface#getPointParameterV <em>Point Parameter V</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPointParameterV()
	 * @see #getPointParameterV()
	 * @see #setPointParameterV(double)
	 * @generated
	 */
	void unsetPointParameterV();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcPointOnSurface#getPointParameterV <em>Point Parameter V</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Point Parameter V</em>' attribute is set.
	 * @see #unsetPointParameterV()
	 * @see #getPointParameterV()
	 * @see #setPointParameterV(double)
	 * @generated
	 */
	boolean isSetPointParameterV();

	/**
	 * Returns the value of the '<em><b>Point Parameter VAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Point Parameter VAs String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Point Parameter VAs String</em>' attribute.
	 * @see #isSetPointParameterVAsString()
	 * @see #unsetPointParameterVAsString()
	 * @see #setPointParameterVAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPointOnSurface_PointParameterVAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getPointParameterVAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcPointOnSurface#getPointParameterVAsString <em>Point Parameter VAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Point Parameter VAs String</em>' attribute.
	 * @see #isSetPointParameterVAsString()
	 * @see #unsetPointParameterVAsString()
	 * @see #getPointParameterVAsString()
	 * @generated
	 */
	void setPointParameterVAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcPointOnSurface#getPointParameterVAsString <em>Point Parameter VAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPointParameterVAsString()
	 * @see #getPointParameterVAsString()
	 * @see #setPointParameterVAsString(String)
	 * @generated
	 */
	void unsetPointParameterVAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcPointOnSurface#getPointParameterVAsString <em>Point Parameter VAs String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Point Parameter VAs String</em>' attribute is set.
	 * @see #unsetPointParameterVAsString()
	 * @see #getPointParameterVAsString()
	 * @see #setPointParameterVAsString(String)
	 * @generated
	 */
	boolean isSetPointParameterVAsString();

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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPointOnSurface_Dim()
	 * @model unsettable="true" derived="true"
	 * @generated
	 */
	int getDim();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcPointOnSurface#getDim <em>Dim</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcPointOnSurface#getDim <em>Dim</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDim()
	 * @see #getDim()
	 * @see #setDim(int)
	 * @generated
	 */
	void unsetDim();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcPointOnSurface#getDim <em>Dim</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Dim</em>' attribute is set.
	 * @see #unsetDim()
	 * @see #getDim()
	 * @see #setDim(int)
	 * @generated
	 */
	boolean isSetDim();

} // IfcPointOnSurface

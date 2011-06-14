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
 * A representation of the model object '<em><b>Ifc Slippage Connection Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSlippageConnectionCondition#getSlippageX <em>Slippage X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSlippageConnectionCondition#getSlippageXAsString <em>Slippage XAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSlippageConnectionCondition#getSlippageY <em>Slippage Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSlippageConnectionCondition#getSlippageYAsString <em>Slippage YAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSlippageConnectionCondition#getSlippageZ <em>Slippage Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSlippageConnectionCondition#getSlippageZAsString <em>Slippage ZAs String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSlippageConnectionCondition()
 * @model
 * @generated
 */
public interface IfcSlippageConnectionCondition extends IfcStructuralConnectionCondition
{
	/**
	 * Returns the value of the '<em><b>Slippage X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Slippage X</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Slippage X</em>' attribute.
	 * @see #isSetSlippageX()
	 * @see #unsetSlippageX()
	 * @see #setSlippageX(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSlippageConnectionCondition_SlippageX()
	 * @model unsettable="true"
	 * @generated
	 */
	float getSlippageX();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcSlippageConnectionCondition#getSlippageX <em>Slippage X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Slippage X</em>' attribute.
	 * @see #isSetSlippageX()
	 * @see #unsetSlippageX()
	 * @see #getSlippageX()
	 * @generated
	 */
	void setSlippageX(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcSlippageConnectionCondition#getSlippageX <em>Slippage X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSlippageX()
	 * @see #getSlippageX()
	 * @see #setSlippageX(float)
	 * @generated
	 */
	void unsetSlippageX();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcSlippageConnectionCondition#getSlippageX <em>Slippage X</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Slippage X</em>' attribute is set.
	 * @see #unsetSlippageX()
	 * @see #getSlippageX()
	 * @see #setSlippageX(float)
	 * @generated
	 */
	boolean isSetSlippageX();

	/**
	 * Returns the value of the '<em><b>Slippage XAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Slippage XAs String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Slippage XAs String</em>' attribute.
	 * @see #isSetSlippageXAsString()
	 * @see #unsetSlippageXAsString()
	 * @see #setSlippageXAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSlippageConnectionCondition_SlippageXAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getSlippageXAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcSlippageConnectionCondition#getSlippageXAsString <em>Slippage XAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Slippage XAs String</em>' attribute.
	 * @see #isSetSlippageXAsString()
	 * @see #unsetSlippageXAsString()
	 * @see #getSlippageXAsString()
	 * @generated
	 */
	void setSlippageXAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcSlippageConnectionCondition#getSlippageXAsString <em>Slippage XAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSlippageXAsString()
	 * @see #getSlippageXAsString()
	 * @see #setSlippageXAsString(String)
	 * @generated
	 */
	void unsetSlippageXAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcSlippageConnectionCondition#getSlippageXAsString <em>Slippage XAs String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Slippage XAs String</em>' attribute is set.
	 * @see #unsetSlippageXAsString()
	 * @see #getSlippageXAsString()
	 * @see #setSlippageXAsString(String)
	 * @generated
	 */
	boolean isSetSlippageXAsString();

	/**
	 * Returns the value of the '<em><b>Slippage Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Slippage Y</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Slippage Y</em>' attribute.
	 * @see #isSetSlippageY()
	 * @see #unsetSlippageY()
	 * @see #setSlippageY(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSlippageConnectionCondition_SlippageY()
	 * @model unsettable="true"
	 * @generated
	 */
	float getSlippageY();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcSlippageConnectionCondition#getSlippageY <em>Slippage Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Slippage Y</em>' attribute.
	 * @see #isSetSlippageY()
	 * @see #unsetSlippageY()
	 * @see #getSlippageY()
	 * @generated
	 */
	void setSlippageY(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcSlippageConnectionCondition#getSlippageY <em>Slippage Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSlippageY()
	 * @see #getSlippageY()
	 * @see #setSlippageY(float)
	 * @generated
	 */
	void unsetSlippageY();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcSlippageConnectionCondition#getSlippageY <em>Slippage Y</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Slippage Y</em>' attribute is set.
	 * @see #unsetSlippageY()
	 * @see #getSlippageY()
	 * @see #setSlippageY(float)
	 * @generated
	 */
	boolean isSetSlippageY();

	/**
	 * Returns the value of the '<em><b>Slippage YAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Slippage YAs String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Slippage YAs String</em>' attribute.
	 * @see #isSetSlippageYAsString()
	 * @see #unsetSlippageYAsString()
	 * @see #setSlippageYAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSlippageConnectionCondition_SlippageYAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getSlippageYAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcSlippageConnectionCondition#getSlippageYAsString <em>Slippage YAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Slippage YAs String</em>' attribute.
	 * @see #isSetSlippageYAsString()
	 * @see #unsetSlippageYAsString()
	 * @see #getSlippageYAsString()
	 * @generated
	 */
	void setSlippageYAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcSlippageConnectionCondition#getSlippageYAsString <em>Slippage YAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSlippageYAsString()
	 * @see #getSlippageYAsString()
	 * @see #setSlippageYAsString(String)
	 * @generated
	 */
	void unsetSlippageYAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcSlippageConnectionCondition#getSlippageYAsString <em>Slippage YAs String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Slippage YAs String</em>' attribute is set.
	 * @see #unsetSlippageYAsString()
	 * @see #getSlippageYAsString()
	 * @see #setSlippageYAsString(String)
	 * @generated
	 */
	boolean isSetSlippageYAsString();

	/**
	 * Returns the value of the '<em><b>Slippage Z</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Slippage Z</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Slippage Z</em>' attribute.
	 * @see #isSetSlippageZ()
	 * @see #unsetSlippageZ()
	 * @see #setSlippageZ(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSlippageConnectionCondition_SlippageZ()
	 * @model unsettable="true"
	 * @generated
	 */
	float getSlippageZ();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcSlippageConnectionCondition#getSlippageZ <em>Slippage Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Slippage Z</em>' attribute.
	 * @see #isSetSlippageZ()
	 * @see #unsetSlippageZ()
	 * @see #getSlippageZ()
	 * @generated
	 */
	void setSlippageZ(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcSlippageConnectionCondition#getSlippageZ <em>Slippage Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSlippageZ()
	 * @see #getSlippageZ()
	 * @see #setSlippageZ(float)
	 * @generated
	 */
	void unsetSlippageZ();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcSlippageConnectionCondition#getSlippageZ <em>Slippage Z</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Slippage Z</em>' attribute is set.
	 * @see #unsetSlippageZ()
	 * @see #getSlippageZ()
	 * @see #setSlippageZ(float)
	 * @generated
	 */
	boolean isSetSlippageZ();

	/**
	 * Returns the value of the '<em><b>Slippage ZAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Slippage ZAs String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Slippage ZAs String</em>' attribute.
	 * @see #isSetSlippageZAsString()
	 * @see #unsetSlippageZAsString()
	 * @see #setSlippageZAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSlippageConnectionCondition_SlippageZAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getSlippageZAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcSlippageConnectionCondition#getSlippageZAsString <em>Slippage ZAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Slippage ZAs String</em>' attribute.
	 * @see #isSetSlippageZAsString()
	 * @see #unsetSlippageZAsString()
	 * @see #getSlippageZAsString()
	 * @generated
	 */
	void setSlippageZAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcSlippageConnectionCondition#getSlippageZAsString <em>Slippage ZAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSlippageZAsString()
	 * @see #getSlippageZAsString()
	 * @see #setSlippageZAsString(String)
	 * @generated
	 */
	void unsetSlippageZAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcSlippageConnectionCondition#getSlippageZAsString <em>Slippage ZAs String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Slippage ZAs String</em>' attribute is set.
	 * @see #unsetSlippageZAsString()
	 * @see #getSlippageZAsString()
	 * @see #setSlippageZAsString(String)
	 * @generated
	 */
	boolean isSetSlippageZAsString();

} // IfcSlippageConnectionCondition

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
 * A representation of the model object '<em><b>Ifc Boundary Node Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeCondition#getLinearStiffnessX <em>Linear Stiffness X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeCondition#getLinearStiffnessXAsString <em>Linear Stiffness XAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeCondition#getLinearStiffnessY <em>Linear Stiffness Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeCondition#getLinearStiffnessYAsString <em>Linear Stiffness YAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeCondition#getLinearStiffnessZ <em>Linear Stiffness Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeCondition#getLinearStiffnessZAsString <em>Linear Stiffness ZAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeCondition#getRotationalStiffnessX <em>Rotational Stiffness X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeCondition#getRotationalStiffnessXAsString <em>Rotational Stiffness XAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeCondition#getRotationalStiffnessY <em>Rotational Stiffness Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeCondition#getRotationalStiffnessYAsString <em>Rotational Stiffness YAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeCondition#getRotationalStiffnessZ <em>Rotational Stiffness Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeCondition#getRotationalStiffnessZAsString <em>Rotational Stiffness ZAs String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBoundaryNodeCondition()
 * @model
 * @generated
 */
public interface IfcBoundaryNodeCondition extends IfcBoundaryCondition
{
	/**
	 * Returns the value of the '<em><b>Linear Stiffness X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Linear Stiffness X</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Linear Stiffness X</em>' attribute.
	 * @see #isSetLinearStiffnessX()
	 * @see #unsetLinearStiffnessX()
	 * @see #setLinearStiffnessX(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBoundaryNodeCondition_LinearStiffnessX()
	 * @model unsettable="true"
	 * @generated
	 */
	float getLinearStiffnessX();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeCondition#getLinearStiffnessX <em>Linear Stiffness X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Linear Stiffness X</em>' attribute.
	 * @see #isSetLinearStiffnessX()
	 * @see #unsetLinearStiffnessX()
	 * @see #getLinearStiffnessX()
	 * @generated
	 */
	void setLinearStiffnessX(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeCondition#getLinearStiffnessX <em>Linear Stiffness X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLinearStiffnessX()
	 * @see #getLinearStiffnessX()
	 * @see #setLinearStiffnessX(float)
	 * @generated
	 */
	void unsetLinearStiffnessX();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeCondition#getLinearStiffnessX <em>Linear Stiffness X</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Linear Stiffness X</em>' attribute is set.
	 * @see #unsetLinearStiffnessX()
	 * @see #getLinearStiffnessX()
	 * @see #setLinearStiffnessX(float)
	 * @generated
	 */
	boolean isSetLinearStiffnessX();

	/**
	 * Returns the value of the '<em><b>Linear Stiffness XAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Linear Stiffness XAs String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Linear Stiffness XAs String</em>' attribute.
	 * @see #isSetLinearStiffnessXAsString()
	 * @see #unsetLinearStiffnessXAsString()
	 * @see #setLinearStiffnessXAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBoundaryNodeCondition_LinearStiffnessXAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getLinearStiffnessXAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeCondition#getLinearStiffnessXAsString <em>Linear Stiffness XAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Linear Stiffness XAs String</em>' attribute.
	 * @see #isSetLinearStiffnessXAsString()
	 * @see #unsetLinearStiffnessXAsString()
	 * @see #getLinearStiffnessXAsString()
	 * @generated
	 */
	void setLinearStiffnessXAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeCondition#getLinearStiffnessXAsString <em>Linear Stiffness XAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLinearStiffnessXAsString()
	 * @see #getLinearStiffnessXAsString()
	 * @see #setLinearStiffnessXAsString(String)
	 * @generated
	 */
	void unsetLinearStiffnessXAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeCondition#getLinearStiffnessXAsString <em>Linear Stiffness XAs String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Linear Stiffness XAs String</em>' attribute is set.
	 * @see #unsetLinearStiffnessXAsString()
	 * @see #getLinearStiffnessXAsString()
	 * @see #setLinearStiffnessXAsString(String)
	 * @generated
	 */
	boolean isSetLinearStiffnessXAsString();

	/**
	 * Returns the value of the '<em><b>Linear Stiffness Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Linear Stiffness Y</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Linear Stiffness Y</em>' attribute.
	 * @see #isSetLinearStiffnessY()
	 * @see #unsetLinearStiffnessY()
	 * @see #setLinearStiffnessY(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBoundaryNodeCondition_LinearStiffnessY()
	 * @model unsettable="true"
	 * @generated
	 */
	float getLinearStiffnessY();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeCondition#getLinearStiffnessY <em>Linear Stiffness Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Linear Stiffness Y</em>' attribute.
	 * @see #isSetLinearStiffnessY()
	 * @see #unsetLinearStiffnessY()
	 * @see #getLinearStiffnessY()
	 * @generated
	 */
	void setLinearStiffnessY(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeCondition#getLinearStiffnessY <em>Linear Stiffness Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLinearStiffnessY()
	 * @see #getLinearStiffnessY()
	 * @see #setLinearStiffnessY(float)
	 * @generated
	 */
	void unsetLinearStiffnessY();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeCondition#getLinearStiffnessY <em>Linear Stiffness Y</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Linear Stiffness Y</em>' attribute is set.
	 * @see #unsetLinearStiffnessY()
	 * @see #getLinearStiffnessY()
	 * @see #setLinearStiffnessY(float)
	 * @generated
	 */
	boolean isSetLinearStiffnessY();

	/**
	 * Returns the value of the '<em><b>Linear Stiffness YAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Linear Stiffness YAs String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Linear Stiffness YAs String</em>' attribute.
	 * @see #isSetLinearStiffnessYAsString()
	 * @see #unsetLinearStiffnessYAsString()
	 * @see #setLinearStiffnessYAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBoundaryNodeCondition_LinearStiffnessYAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getLinearStiffnessYAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeCondition#getLinearStiffnessYAsString <em>Linear Stiffness YAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Linear Stiffness YAs String</em>' attribute.
	 * @see #isSetLinearStiffnessYAsString()
	 * @see #unsetLinearStiffnessYAsString()
	 * @see #getLinearStiffnessYAsString()
	 * @generated
	 */
	void setLinearStiffnessYAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeCondition#getLinearStiffnessYAsString <em>Linear Stiffness YAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLinearStiffnessYAsString()
	 * @see #getLinearStiffnessYAsString()
	 * @see #setLinearStiffnessYAsString(String)
	 * @generated
	 */
	void unsetLinearStiffnessYAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeCondition#getLinearStiffnessYAsString <em>Linear Stiffness YAs String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Linear Stiffness YAs String</em>' attribute is set.
	 * @see #unsetLinearStiffnessYAsString()
	 * @see #getLinearStiffnessYAsString()
	 * @see #setLinearStiffnessYAsString(String)
	 * @generated
	 */
	boolean isSetLinearStiffnessYAsString();

	/**
	 * Returns the value of the '<em><b>Linear Stiffness Z</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Linear Stiffness Z</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Linear Stiffness Z</em>' attribute.
	 * @see #isSetLinearStiffnessZ()
	 * @see #unsetLinearStiffnessZ()
	 * @see #setLinearStiffnessZ(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBoundaryNodeCondition_LinearStiffnessZ()
	 * @model unsettable="true"
	 * @generated
	 */
	float getLinearStiffnessZ();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeCondition#getLinearStiffnessZ <em>Linear Stiffness Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Linear Stiffness Z</em>' attribute.
	 * @see #isSetLinearStiffnessZ()
	 * @see #unsetLinearStiffnessZ()
	 * @see #getLinearStiffnessZ()
	 * @generated
	 */
	void setLinearStiffnessZ(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeCondition#getLinearStiffnessZ <em>Linear Stiffness Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLinearStiffnessZ()
	 * @see #getLinearStiffnessZ()
	 * @see #setLinearStiffnessZ(float)
	 * @generated
	 */
	void unsetLinearStiffnessZ();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeCondition#getLinearStiffnessZ <em>Linear Stiffness Z</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Linear Stiffness Z</em>' attribute is set.
	 * @see #unsetLinearStiffnessZ()
	 * @see #getLinearStiffnessZ()
	 * @see #setLinearStiffnessZ(float)
	 * @generated
	 */
	boolean isSetLinearStiffnessZ();

	/**
	 * Returns the value of the '<em><b>Linear Stiffness ZAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Linear Stiffness ZAs String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Linear Stiffness ZAs String</em>' attribute.
	 * @see #isSetLinearStiffnessZAsString()
	 * @see #unsetLinearStiffnessZAsString()
	 * @see #setLinearStiffnessZAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBoundaryNodeCondition_LinearStiffnessZAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getLinearStiffnessZAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeCondition#getLinearStiffnessZAsString <em>Linear Stiffness ZAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Linear Stiffness ZAs String</em>' attribute.
	 * @see #isSetLinearStiffnessZAsString()
	 * @see #unsetLinearStiffnessZAsString()
	 * @see #getLinearStiffnessZAsString()
	 * @generated
	 */
	void setLinearStiffnessZAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeCondition#getLinearStiffnessZAsString <em>Linear Stiffness ZAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLinearStiffnessZAsString()
	 * @see #getLinearStiffnessZAsString()
	 * @see #setLinearStiffnessZAsString(String)
	 * @generated
	 */
	void unsetLinearStiffnessZAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeCondition#getLinearStiffnessZAsString <em>Linear Stiffness ZAs String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Linear Stiffness ZAs String</em>' attribute is set.
	 * @see #unsetLinearStiffnessZAsString()
	 * @see #getLinearStiffnessZAsString()
	 * @see #setLinearStiffnessZAsString(String)
	 * @generated
	 */
	boolean isSetLinearStiffnessZAsString();

	/**
	 * Returns the value of the '<em><b>Rotational Stiffness X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rotational Stiffness X</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rotational Stiffness X</em>' attribute.
	 * @see #isSetRotationalStiffnessX()
	 * @see #unsetRotationalStiffnessX()
	 * @see #setRotationalStiffnessX(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBoundaryNodeCondition_RotationalStiffnessX()
	 * @model unsettable="true"
	 * @generated
	 */
	float getRotationalStiffnessX();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeCondition#getRotationalStiffnessX <em>Rotational Stiffness X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rotational Stiffness X</em>' attribute.
	 * @see #isSetRotationalStiffnessX()
	 * @see #unsetRotationalStiffnessX()
	 * @see #getRotationalStiffnessX()
	 * @generated
	 */
	void setRotationalStiffnessX(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeCondition#getRotationalStiffnessX <em>Rotational Stiffness X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRotationalStiffnessX()
	 * @see #getRotationalStiffnessX()
	 * @see #setRotationalStiffnessX(float)
	 * @generated
	 */
	void unsetRotationalStiffnessX();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeCondition#getRotationalStiffnessX <em>Rotational Stiffness X</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Rotational Stiffness X</em>' attribute is set.
	 * @see #unsetRotationalStiffnessX()
	 * @see #getRotationalStiffnessX()
	 * @see #setRotationalStiffnessX(float)
	 * @generated
	 */
	boolean isSetRotationalStiffnessX();

	/**
	 * Returns the value of the '<em><b>Rotational Stiffness XAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rotational Stiffness XAs String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rotational Stiffness XAs String</em>' attribute.
	 * @see #isSetRotationalStiffnessXAsString()
	 * @see #unsetRotationalStiffnessXAsString()
	 * @see #setRotationalStiffnessXAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBoundaryNodeCondition_RotationalStiffnessXAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getRotationalStiffnessXAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeCondition#getRotationalStiffnessXAsString <em>Rotational Stiffness XAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rotational Stiffness XAs String</em>' attribute.
	 * @see #isSetRotationalStiffnessXAsString()
	 * @see #unsetRotationalStiffnessXAsString()
	 * @see #getRotationalStiffnessXAsString()
	 * @generated
	 */
	void setRotationalStiffnessXAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeCondition#getRotationalStiffnessXAsString <em>Rotational Stiffness XAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRotationalStiffnessXAsString()
	 * @see #getRotationalStiffnessXAsString()
	 * @see #setRotationalStiffnessXAsString(String)
	 * @generated
	 */
	void unsetRotationalStiffnessXAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeCondition#getRotationalStiffnessXAsString <em>Rotational Stiffness XAs String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Rotational Stiffness XAs String</em>' attribute is set.
	 * @see #unsetRotationalStiffnessXAsString()
	 * @see #getRotationalStiffnessXAsString()
	 * @see #setRotationalStiffnessXAsString(String)
	 * @generated
	 */
	boolean isSetRotationalStiffnessXAsString();

	/**
	 * Returns the value of the '<em><b>Rotational Stiffness Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rotational Stiffness Y</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rotational Stiffness Y</em>' attribute.
	 * @see #isSetRotationalStiffnessY()
	 * @see #unsetRotationalStiffnessY()
	 * @see #setRotationalStiffnessY(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBoundaryNodeCondition_RotationalStiffnessY()
	 * @model unsettable="true"
	 * @generated
	 */
	float getRotationalStiffnessY();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeCondition#getRotationalStiffnessY <em>Rotational Stiffness Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rotational Stiffness Y</em>' attribute.
	 * @see #isSetRotationalStiffnessY()
	 * @see #unsetRotationalStiffnessY()
	 * @see #getRotationalStiffnessY()
	 * @generated
	 */
	void setRotationalStiffnessY(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeCondition#getRotationalStiffnessY <em>Rotational Stiffness Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRotationalStiffnessY()
	 * @see #getRotationalStiffnessY()
	 * @see #setRotationalStiffnessY(float)
	 * @generated
	 */
	void unsetRotationalStiffnessY();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeCondition#getRotationalStiffnessY <em>Rotational Stiffness Y</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Rotational Stiffness Y</em>' attribute is set.
	 * @see #unsetRotationalStiffnessY()
	 * @see #getRotationalStiffnessY()
	 * @see #setRotationalStiffnessY(float)
	 * @generated
	 */
	boolean isSetRotationalStiffnessY();

	/**
	 * Returns the value of the '<em><b>Rotational Stiffness YAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rotational Stiffness YAs String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rotational Stiffness YAs String</em>' attribute.
	 * @see #isSetRotationalStiffnessYAsString()
	 * @see #unsetRotationalStiffnessYAsString()
	 * @see #setRotationalStiffnessYAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBoundaryNodeCondition_RotationalStiffnessYAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getRotationalStiffnessYAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeCondition#getRotationalStiffnessYAsString <em>Rotational Stiffness YAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rotational Stiffness YAs String</em>' attribute.
	 * @see #isSetRotationalStiffnessYAsString()
	 * @see #unsetRotationalStiffnessYAsString()
	 * @see #getRotationalStiffnessYAsString()
	 * @generated
	 */
	void setRotationalStiffnessYAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeCondition#getRotationalStiffnessYAsString <em>Rotational Stiffness YAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRotationalStiffnessYAsString()
	 * @see #getRotationalStiffnessYAsString()
	 * @see #setRotationalStiffnessYAsString(String)
	 * @generated
	 */
	void unsetRotationalStiffnessYAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeCondition#getRotationalStiffnessYAsString <em>Rotational Stiffness YAs String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Rotational Stiffness YAs String</em>' attribute is set.
	 * @see #unsetRotationalStiffnessYAsString()
	 * @see #getRotationalStiffnessYAsString()
	 * @see #setRotationalStiffnessYAsString(String)
	 * @generated
	 */
	boolean isSetRotationalStiffnessYAsString();

	/**
	 * Returns the value of the '<em><b>Rotational Stiffness Z</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rotational Stiffness Z</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rotational Stiffness Z</em>' attribute.
	 * @see #isSetRotationalStiffnessZ()
	 * @see #unsetRotationalStiffnessZ()
	 * @see #setRotationalStiffnessZ(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBoundaryNodeCondition_RotationalStiffnessZ()
	 * @model unsettable="true"
	 * @generated
	 */
	float getRotationalStiffnessZ();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeCondition#getRotationalStiffnessZ <em>Rotational Stiffness Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rotational Stiffness Z</em>' attribute.
	 * @see #isSetRotationalStiffnessZ()
	 * @see #unsetRotationalStiffnessZ()
	 * @see #getRotationalStiffnessZ()
	 * @generated
	 */
	void setRotationalStiffnessZ(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeCondition#getRotationalStiffnessZ <em>Rotational Stiffness Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRotationalStiffnessZ()
	 * @see #getRotationalStiffnessZ()
	 * @see #setRotationalStiffnessZ(float)
	 * @generated
	 */
	void unsetRotationalStiffnessZ();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeCondition#getRotationalStiffnessZ <em>Rotational Stiffness Z</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Rotational Stiffness Z</em>' attribute is set.
	 * @see #unsetRotationalStiffnessZ()
	 * @see #getRotationalStiffnessZ()
	 * @see #setRotationalStiffnessZ(float)
	 * @generated
	 */
	boolean isSetRotationalStiffnessZ();

	/**
	 * Returns the value of the '<em><b>Rotational Stiffness ZAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rotational Stiffness ZAs String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rotational Stiffness ZAs String</em>' attribute.
	 * @see #isSetRotationalStiffnessZAsString()
	 * @see #unsetRotationalStiffnessZAsString()
	 * @see #setRotationalStiffnessZAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBoundaryNodeCondition_RotationalStiffnessZAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getRotationalStiffnessZAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeCondition#getRotationalStiffnessZAsString <em>Rotational Stiffness ZAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rotational Stiffness ZAs String</em>' attribute.
	 * @see #isSetRotationalStiffnessZAsString()
	 * @see #unsetRotationalStiffnessZAsString()
	 * @see #getRotationalStiffnessZAsString()
	 * @generated
	 */
	void setRotationalStiffnessZAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeCondition#getRotationalStiffnessZAsString <em>Rotational Stiffness ZAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRotationalStiffnessZAsString()
	 * @see #getRotationalStiffnessZAsString()
	 * @see #setRotationalStiffnessZAsString(String)
	 * @generated
	 */
	void unsetRotationalStiffnessZAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryNodeCondition#getRotationalStiffnessZAsString <em>Rotational Stiffness ZAs String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Rotational Stiffness ZAs String</em>' attribute is set.
	 * @see #unsetRotationalStiffnessZAsString()
	 * @see #getRotationalStiffnessZAsString()
	 * @see #setRotationalStiffnessZAsString(String)
	 * @generated
	 */
	boolean isSetRotationalStiffnessZAsString();

} // IfcBoundaryNodeCondition

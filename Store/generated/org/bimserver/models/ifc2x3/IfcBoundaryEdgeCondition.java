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
 * A representation of the model object '<em><b>Ifc Boundary Edge Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBoundaryEdgeCondition#getLinearStiffnessByLengthX <em>Linear Stiffness By Length X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBoundaryEdgeCondition#getLinearStiffnessByLengthXAsString <em>Linear Stiffness By Length XAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBoundaryEdgeCondition#getLinearStiffnessByLengthY <em>Linear Stiffness By Length Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBoundaryEdgeCondition#getLinearStiffnessByLengthYAsString <em>Linear Stiffness By Length YAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBoundaryEdgeCondition#getLinearStiffnessByLengthZ <em>Linear Stiffness By Length Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBoundaryEdgeCondition#getLinearStiffnessByLengthZAsString <em>Linear Stiffness By Length ZAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBoundaryEdgeCondition#getRotationalStiffnessByLengthX <em>Rotational Stiffness By Length X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBoundaryEdgeCondition#getRotationalStiffnessByLengthXAsString <em>Rotational Stiffness By Length XAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBoundaryEdgeCondition#getRotationalStiffnessByLengthY <em>Rotational Stiffness By Length Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBoundaryEdgeCondition#getRotationalStiffnessByLengthYAsString <em>Rotational Stiffness By Length YAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBoundaryEdgeCondition#getRotationalStiffnessByLengthZ <em>Rotational Stiffness By Length Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBoundaryEdgeCondition#getRotationalStiffnessByLengthZAsString <em>Rotational Stiffness By Length ZAs String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBoundaryEdgeCondition()
 * @model
 * @generated
 */
public interface IfcBoundaryEdgeCondition extends IfcBoundaryCondition
{
	/**
	 * Returns the value of the '<em><b>Linear Stiffness By Length X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Linear Stiffness By Length X</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Linear Stiffness By Length X</em>' attribute.
	 * @see #isSetLinearStiffnessByLengthX()
	 * @see #unsetLinearStiffnessByLengthX()
	 * @see #setLinearStiffnessByLengthX(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBoundaryEdgeCondition_LinearStiffnessByLengthX()
	 * @model unsettable="true"
	 * @generated
	 */
	float getLinearStiffnessByLengthX();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryEdgeCondition#getLinearStiffnessByLengthX <em>Linear Stiffness By Length X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Linear Stiffness By Length X</em>' attribute.
	 * @see #isSetLinearStiffnessByLengthX()
	 * @see #unsetLinearStiffnessByLengthX()
	 * @see #getLinearStiffnessByLengthX()
	 * @generated
	 */
	void setLinearStiffnessByLengthX(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryEdgeCondition#getLinearStiffnessByLengthX <em>Linear Stiffness By Length X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLinearStiffnessByLengthX()
	 * @see #getLinearStiffnessByLengthX()
	 * @see #setLinearStiffnessByLengthX(float)
	 * @generated
	 */
	void unsetLinearStiffnessByLengthX();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryEdgeCondition#getLinearStiffnessByLengthX <em>Linear Stiffness By Length X</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Linear Stiffness By Length X</em>' attribute is set.
	 * @see #unsetLinearStiffnessByLengthX()
	 * @see #getLinearStiffnessByLengthX()
	 * @see #setLinearStiffnessByLengthX(float)
	 * @generated
	 */
	boolean isSetLinearStiffnessByLengthX();

	/**
	 * Returns the value of the '<em><b>Linear Stiffness By Length XAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Linear Stiffness By Length XAs String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Linear Stiffness By Length XAs String</em>' attribute.
	 * @see #isSetLinearStiffnessByLengthXAsString()
	 * @see #unsetLinearStiffnessByLengthXAsString()
	 * @see #setLinearStiffnessByLengthXAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBoundaryEdgeCondition_LinearStiffnessByLengthXAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getLinearStiffnessByLengthXAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryEdgeCondition#getLinearStiffnessByLengthXAsString <em>Linear Stiffness By Length XAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Linear Stiffness By Length XAs String</em>' attribute.
	 * @see #isSetLinearStiffnessByLengthXAsString()
	 * @see #unsetLinearStiffnessByLengthXAsString()
	 * @see #getLinearStiffnessByLengthXAsString()
	 * @generated
	 */
	void setLinearStiffnessByLengthXAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryEdgeCondition#getLinearStiffnessByLengthXAsString <em>Linear Stiffness By Length XAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLinearStiffnessByLengthXAsString()
	 * @see #getLinearStiffnessByLengthXAsString()
	 * @see #setLinearStiffnessByLengthXAsString(String)
	 * @generated
	 */
	void unsetLinearStiffnessByLengthXAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryEdgeCondition#getLinearStiffnessByLengthXAsString <em>Linear Stiffness By Length XAs String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Linear Stiffness By Length XAs String</em>' attribute is set.
	 * @see #unsetLinearStiffnessByLengthXAsString()
	 * @see #getLinearStiffnessByLengthXAsString()
	 * @see #setLinearStiffnessByLengthXAsString(String)
	 * @generated
	 */
	boolean isSetLinearStiffnessByLengthXAsString();

	/**
	 * Returns the value of the '<em><b>Linear Stiffness By Length Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Linear Stiffness By Length Y</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Linear Stiffness By Length Y</em>' attribute.
	 * @see #isSetLinearStiffnessByLengthY()
	 * @see #unsetLinearStiffnessByLengthY()
	 * @see #setLinearStiffnessByLengthY(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBoundaryEdgeCondition_LinearStiffnessByLengthY()
	 * @model unsettable="true"
	 * @generated
	 */
	float getLinearStiffnessByLengthY();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryEdgeCondition#getLinearStiffnessByLengthY <em>Linear Stiffness By Length Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Linear Stiffness By Length Y</em>' attribute.
	 * @see #isSetLinearStiffnessByLengthY()
	 * @see #unsetLinearStiffnessByLengthY()
	 * @see #getLinearStiffnessByLengthY()
	 * @generated
	 */
	void setLinearStiffnessByLengthY(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryEdgeCondition#getLinearStiffnessByLengthY <em>Linear Stiffness By Length Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLinearStiffnessByLengthY()
	 * @see #getLinearStiffnessByLengthY()
	 * @see #setLinearStiffnessByLengthY(float)
	 * @generated
	 */
	void unsetLinearStiffnessByLengthY();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryEdgeCondition#getLinearStiffnessByLengthY <em>Linear Stiffness By Length Y</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Linear Stiffness By Length Y</em>' attribute is set.
	 * @see #unsetLinearStiffnessByLengthY()
	 * @see #getLinearStiffnessByLengthY()
	 * @see #setLinearStiffnessByLengthY(float)
	 * @generated
	 */
	boolean isSetLinearStiffnessByLengthY();

	/**
	 * Returns the value of the '<em><b>Linear Stiffness By Length YAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Linear Stiffness By Length YAs String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Linear Stiffness By Length YAs String</em>' attribute.
	 * @see #isSetLinearStiffnessByLengthYAsString()
	 * @see #unsetLinearStiffnessByLengthYAsString()
	 * @see #setLinearStiffnessByLengthYAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBoundaryEdgeCondition_LinearStiffnessByLengthYAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getLinearStiffnessByLengthYAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryEdgeCondition#getLinearStiffnessByLengthYAsString <em>Linear Stiffness By Length YAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Linear Stiffness By Length YAs String</em>' attribute.
	 * @see #isSetLinearStiffnessByLengthYAsString()
	 * @see #unsetLinearStiffnessByLengthYAsString()
	 * @see #getLinearStiffnessByLengthYAsString()
	 * @generated
	 */
	void setLinearStiffnessByLengthYAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryEdgeCondition#getLinearStiffnessByLengthYAsString <em>Linear Stiffness By Length YAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLinearStiffnessByLengthYAsString()
	 * @see #getLinearStiffnessByLengthYAsString()
	 * @see #setLinearStiffnessByLengthYAsString(String)
	 * @generated
	 */
	void unsetLinearStiffnessByLengthYAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryEdgeCondition#getLinearStiffnessByLengthYAsString <em>Linear Stiffness By Length YAs String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Linear Stiffness By Length YAs String</em>' attribute is set.
	 * @see #unsetLinearStiffnessByLengthYAsString()
	 * @see #getLinearStiffnessByLengthYAsString()
	 * @see #setLinearStiffnessByLengthYAsString(String)
	 * @generated
	 */
	boolean isSetLinearStiffnessByLengthYAsString();

	/**
	 * Returns the value of the '<em><b>Linear Stiffness By Length Z</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Linear Stiffness By Length Z</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Linear Stiffness By Length Z</em>' attribute.
	 * @see #isSetLinearStiffnessByLengthZ()
	 * @see #unsetLinearStiffnessByLengthZ()
	 * @see #setLinearStiffnessByLengthZ(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBoundaryEdgeCondition_LinearStiffnessByLengthZ()
	 * @model unsettable="true"
	 * @generated
	 */
	float getLinearStiffnessByLengthZ();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryEdgeCondition#getLinearStiffnessByLengthZ <em>Linear Stiffness By Length Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Linear Stiffness By Length Z</em>' attribute.
	 * @see #isSetLinearStiffnessByLengthZ()
	 * @see #unsetLinearStiffnessByLengthZ()
	 * @see #getLinearStiffnessByLengthZ()
	 * @generated
	 */
	void setLinearStiffnessByLengthZ(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryEdgeCondition#getLinearStiffnessByLengthZ <em>Linear Stiffness By Length Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLinearStiffnessByLengthZ()
	 * @see #getLinearStiffnessByLengthZ()
	 * @see #setLinearStiffnessByLengthZ(float)
	 * @generated
	 */
	void unsetLinearStiffnessByLengthZ();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryEdgeCondition#getLinearStiffnessByLengthZ <em>Linear Stiffness By Length Z</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Linear Stiffness By Length Z</em>' attribute is set.
	 * @see #unsetLinearStiffnessByLengthZ()
	 * @see #getLinearStiffnessByLengthZ()
	 * @see #setLinearStiffnessByLengthZ(float)
	 * @generated
	 */
	boolean isSetLinearStiffnessByLengthZ();

	/**
	 * Returns the value of the '<em><b>Linear Stiffness By Length ZAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Linear Stiffness By Length ZAs String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Linear Stiffness By Length ZAs String</em>' attribute.
	 * @see #isSetLinearStiffnessByLengthZAsString()
	 * @see #unsetLinearStiffnessByLengthZAsString()
	 * @see #setLinearStiffnessByLengthZAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBoundaryEdgeCondition_LinearStiffnessByLengthZAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getLinearStiffnessByLengthZAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryEdgeCondition#getLinearStiffnessByLengthZAsString <em>Linear Stiffness By Length ZAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Linear Stiffness By Length ZAs String</em>' attribute.
	 * @see #isSetLinearStiffnessByLengthZAsString()
	 * @see #unsetLinearStiffnessByLengthZAsString()
	 * @see #getLinearStiffnessByLengthZAsString()
	 * @generated
	 */
	void setLinearStiffnessByLengthZAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryEdgeCondition#getLinearStiffnessByLengthZAsString <em>Linear Stiffness By Length ZAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLinearStiffnessByLengthZAsString()
	 * @see #getLinearStiffnessByLengthZAsString()
	 * @see #setLinearStiffnessByLengthZAsString(String)
	 * @generated
	 */
	void unsetLinearStiffnessByLengthZAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryEdgeCondition#getLinearStiffnessByLengthZAsString <em>Linear Stiffness By Length ZAs String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Linear Stiffness By Length ZAs String</em>' attribute is set.
	 * @see #unsetLinearStiffnessByLengthZAsString()
	 * @see #getLinearStiffnessByLengthZAsString()
	 * @see #setLinearStiffnessByLengthZAsString(String)
	 * @generated
	 */
	boolean isSetLinearStiffnessByLengthZAsString();

	/**
	 * Returns the value of the '<em><b>Rotational Stiffness By Length X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rotational Stiffness By Length X</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rotational Stiffness By Length X</em>' attribute.
	 * @see #isSetRotationalStiffnessByLengthX()
	 * @see #unsetRotationalStiffnessByLengthX()
	 * @see #setRotationalStiffnessByLengthX(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBoundaryEdgeCondition_RotationalStiffnessByLengthX()
	 * @model unsettable="true"
	 * @generated
	 */
	float getRotationalStiffnessByLengthX();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryEdgeCondition#getRotationalStiffnessByLengthX <em>Rotational Stiffness By Length X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rotational Stiffness By Length X</em>' attribute.
	 * @see #isSetRotationalStiffnessByLengthX()
	 * @see #unsetRotationalStiffnessByLengthX()
	 * @see #getRotationalStiffnessByLengthX()
	 * @generated
	 */
	void setRotationalStiffnessByLengthX(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryEdgeCondition#getRotationalStiffnessByLengthX <em>Rotational Stiffness By Length X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRotationalStiffnessByLengthX()
	 * @see #getRotationalStiffnessByLengthX()
	 * @see #setRotationalStiffnessByLengthX(float)
	 * @generated
	 */
	void unsetRotationalStiffnessByLengthX();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryEdgeCondition#getRotationalStiffnessByLengthX <em>Rotational Stiffness By Length X</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Rotational Stiffness By Length X</em>' attribute is set.
	 * @see #unsetRotationalStiffnessByLengthX()
	 * @see #getRotationalStiffnessByLengthX()
	 * @see #setRotationalStiffnessByLengthX(float)
	 * @generated
	 */
	boolean isSetRotationalStiffnessByLengthX();

	/**
	 * Returns the value of the '<em><b>Rotational Stiffness By Length XAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rotational Stiffness By Length XAs String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rotational Stiffness By Length XAs String</em>' attribute.
	 * @see #isSetRotationalStiffnessByLengthXAsString()
	 * @see #unsetRotationalStiffnessByLengthXAsString()
	 * @see #setRotationalStiffnessByLengthXAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBoundaryEdgeCondition_RotationalStiffnessByLengthXAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getRotationalStiffnessByLengthXAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryEdgeCondition#getRotationalStiffnessByLengthXAsString <em>Rotational Stiffness By Length XAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rotational Stiffness By Length XAs String</em>' attribute.
	 * @see #isSetRotationalStiffnessByLengthXAsString()
	 * @see #unsetRotationalStiffnessByLengthXAsString()
	 * @see #getRotationalStiffnessByLengthXAsString()
	 * @generated
	 */
	void setRotationalStiffnessByLengthXAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryEdgeCondition#getRotationalStiffnessByLengthXAsString <em>Rotational Stiffness By Length XAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRotationalStiffnessByLengthXAsString()
	 * @see #getRotationalStiffnessByLengthXAsString()
	 * @see #setRotationalStiffnessByLengthXAsString(String)
	 * @generated
	 */
	void unsetRotationalStiffnessByLengthXAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryEdgeCondition#getRotationalStiffnessByLengthXAsString <em>Rotational Stiffness By Length XAs String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Rotational Stiffness By Length XAs String</em>' attribute is set.
	 * @see #unsetRotationalStiffnessByLengthXAsString()
	 * @see #getRotationalStiffnessByLengthXAsString()
	 * @see #setRotationalStiffnessByLengthXAsString(String)
	 * @generated
	 */
	boolean isSetRotationalStiffnessByLengthXAsString();

	/**
	 * Returns the value of the '<em><b>Rotational Stiffness By Length Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rotational Stiffness By Length Y</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rotational Stiffness By Length Y</em>' attribute.
	 * @see #isSetRotationalStiffnessByLengthY()
	 * @see #unsetRotationalStiffnessByLengthY()
	 * @see #setRotationalStiffnessByLengthY(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBoundaryEdgeCondition_RotationalStiffnessByLengthY()
	 * @model unsettable="true"
	 * @generated
	 */
	float getRotationalStiffnessByLengthY();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryEdgeCondition#getRotationalStiffnessByLengthY <em>Rotational Stiffness By Length Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rotational Stiffness By Length Y</em>' attribute.
	 * @see #isSetRotationalStiffnessByLengthY()
	 * @see #unsetRotationalStiffnessByLengthY()
	 * @see #getRotationalStiffnessByLengthY()
	 * @generated
	 */
	void setRotationalStiffnessByLengthY(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryEdgeCondition#getRotationalStiffnessByLengthY <em>Rotational Stiffness By Length Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRotationalStiffnessByLengthY()
	 * @see #getRotationalStiffnessByLengthY()
	 * @see #setRotationalStiffnessByLengthY(float)
	 * @generated
	 */
	void unsetRotationalStiffnessByLengthY();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryEdgeCondition#getRotationalStiffnessByLengthY <em>Rotational Stiffness By Length Y</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Rotational Stiffness By Length Y</em>' attribute is set.
	 * @see #unsetRotationalStiffnessByLengthY()
	 * @see #getRotationalStiffnessByLengthY()
	 * @see #setRotationalStiffnessByLengthY(float)
	 * @generated
	 */
	boolean isSetRotationalStiffnessByLengthY();

	/**
	 * Returns the value of the '<em><b>Rotational Stiffness By Length YAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rotational Stiffness By Length YAs String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rotational Stiffness By Length YAs String</em>' attribute.
	 * @see #isSetRotationalStiffnessByLengthYAsString()
	 * @see #unsetRotationalStiffnessByLengthYAsString()
	 * @see #setRotationalStiffnessByLengthYAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBoundaryEdgeCondition_RotationalStiffnessByLengthYAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getRotationalStiffnessByLengthYAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryEdgeCondition#getRotationalStiffnessByLengthYAsString <em>Rotational Stiffness By Length YAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rotational Stiffness By Length YAs String</em>' attribute.
	 * @see #isSetRotationalStiffnessByLengthYAsString()
	 * @see #unsetRotationalStiffnessByLengthYAsString()
	 * @see #getRotationalStiffnessByLengthYAsString()
	 * @generated
	 */
	void setRotationalStiffnessByLengthYAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryEdgeCondition#getRotationalStiffnessByLengthYAsString <em>Rotational Stiffness By Length YAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRotationalStiffnessByLengthYAsString()
	 * @see #getRotationalStiffnessByLengthYAsString()
	 * @see #setRotationalStiffnessByLengthYAsString(String)
	 * @generated
	 */
	void unsetRotationalStiffnessByLengthYAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryEdgeCondition#getRotationalStiffnessByLengthYAsString <em>Rotational Stiffness By Length YAs String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Rotational Stiffness By Length YAs String</em>' attribute is set.
	 * @see #unsetRotationalStiffnessByLengthYAsString()
	 * @see #getRotationalStiffnessByLengthYAsString()
	 * @see #setRotationalStiffnessByLengthYAsString(String)
	 * @generated
	 */
	boolean isSetRotationalStiffnessByLengthYAsString();

	/**
	 * Returns the value of the '<em><b>Rotational Stiffness By Length Z</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rotational Stiffness By Length Z</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rotational Stiffness By Length Z</em>' attribute.
	 * @see #isSetRotationalStiffnessByLengthZ()
	 * @see #unsetRotationalStiffnessByLengthZ()
	 * @see #setRotationalStiffnessByLengthZ(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBoundaryEdgeCondition_RotationalStiffnessByLengthZ()
	 * @model unsettable="true"
	 * @generated
	 */
	float getRotationalStiffnessByLengthZ();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryEdgeCondition#getRotationalStiffnessByLengthZ <em>Rotational Stiffness By Length Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rotational Stiffness By Length Z</em>' attribute.
	 * @see #isSetRotationalStiffnessByLengthZ()
	 * @see #unsetRotationalStiffnessByLengthZ()
	 * @see #getRotationalStiffnessByLengthZ()
	 * @generated
	 */
	void setRotationalStiffnessByLengthZ(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryEdgeCondition#getRotationalStiffnessByLengthZ <em>Rotational Stiffness By Length Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRotationalStiffnessByLengthZ()
	 * @see #getRotationalStiffnessByLengthZ()
	 * @see #setRotationalStiffnessByLengthZ(float)
	 * @generated
	 */
	void unsetRotationalStiffnessByLengthZ();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryEdgeCondition#getRotationalStiffnessByLengthZ <em>Rotational Stiffness By Length Z</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Rotational Stiffness By Length Z</em>' attribute is set.
	 * @see #unsetRotationalStiffnessByLengthZ()
	 * @see #getRotationalStiffnessByLengthZ()
	 * @see #setRotationalStiffnessByLengthZ(float)
	 * @generated
	 */
	boolean isSetRotationalStiffnessByLengthZ();

	/**
	 * Returns the value of the '<em><b>Rotational Stiffness By Length ZAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rotational Stiffness By Length ZAs String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rotational Stiffness By Length ZAs String</em>' attribute.
	 * @see #isSetRotationalStiffnessByLengthZAsString()
	 * @see #unsetRotationalStiffnessByLengthZAsString()
	 * @see #setRotationalStiffnessByLengthZAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBoundaryEdgeCondition_RotationalStiffnessByLengthZAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getRotationalStiffnessByLengthZAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryEdgeCondition#getRotationalStiffnessByLengthZAsString <em>Rotational Stiffness By Length ZAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rotational Stiffness By Length ZAs String</em>' attribute.
	 * @see #isSetRotationalStiffnessByLengthZAsString()
	 * @see #unsetRotationalStiffnessByLengthZAsString()
	 * @see #getRotationalStiffnessByLengthZAsString()
	 * @generated
	 */
	void setRotationalStiffnessByLengthZAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryEdgeCondition#getRotationalStiffnessByLengthZAsString <em>Rotational Stiffness By Length ZAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRotationalStiffnessByLengthZAsString()
	 * @see #getRotationalStiffnessByLengthZAsString()
	 * @see #setRotationalStiffnessByLengthZAsString(String)
	 * @generated
	 */
	void unsetRotationalStiffnessByLengthZAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryEdgeCondition#getRotationalStiffnessByLengthZAsString <em>Rotational Stiffness By Length ZAs String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Rotational Stiffness By Length ZAs String</em>' attribute is set.
	 * @see #unsetRotationalStiffnessByLengthZAsString()
	 * @see #getRotationalStiffnessByLengthZAsString()
	 * @see #setRotationalStiffnessByLengthZAsString(String)
	 * @generated
	 */
	boolean isSetRotationalStiffnessByLengthZAsString();

} // IfcBoundaryEdgeCondition

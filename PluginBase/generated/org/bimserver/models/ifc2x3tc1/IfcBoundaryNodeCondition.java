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
package org.bimserver.models.ifc2x3tc1;

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

public interface IfcBoundaryNodeCondition extends IfcBoundaryCondition {
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
	 * @see #setLinearStiffnessX(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcBoundaryNodeCondition_LinearStiffnessX()
	 * @model unsettable="true"
	 * @generated
	 */
	double getLinearStiffnessX();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcBoundaryNodeCondition#getLinearStiffnessX <em>Linear Stiffness X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Linear Stiffness X</em>' attribute.
	 * @see #isSetLinearStiffnessX()
	 * @see #unsetLinearStiffnessX()
	 * @see #getLinearStiffnessX()
	 * @generated
	 */
	void setLinearStiffnessX(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcBoundaryNodeCondition#getLinearStiffnessX <em>Linear Stiffness X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLinearStiffnessX()
	 * @see #getLinearStiffnessX()
	 * @see #setLinearStiffnessX(double)
	 * @generated
	 */
	void unsetLinearStiffnessX();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcBoundaryNodeCondition#getLinearStiffnessX <em>Linear Stiffness X</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Linear Stiffness X</em>' attribute is set.
	 * @see #unsetLinearStiffnessX()
	 * @see #getLinearStiffnessX()
	 * @see #setLinearStiffnessX(double)
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
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcBoundaryNodeCondition_LinearStiffnessXAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getLinearStiffnessXAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcBoundaryNodeCondition#getLinearStiffnessXAsString <em>Linear Stiffness XAs String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcBoundaryNodeCondition#getLinearStiffnessXAsString <em>Linear Stiffness XAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLinearStiffnessXAsString()
	 * @see #getLinearStiffnessXAsString()
	 * @see #setLinearStiffnessXAsString(String)
	 * @generated
	 */
	void unsetLinearStiffnessXAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcBoundaryNodeCondition#getLinearStiffnessXAsString <em>Linear Stiffness XAs String</em>}' attribute is set.
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
	 * @see #setLinearStiffnessY(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcBoundaryNodeCondition_LinearStiffnessY()
	 * @model unsettable="true"
	 * @generated
	 */
	double getLinearStiffnessY();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcBoundaryNodeCondition#getLinearStiffnessY <em>Linear Stiffness Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Linear Stiffness Y</em>' attribute.
	 * @see #isSetLinearStiffnessY()
	 * @see #unsetLinearStiffnessY()
	 * @see #getLinearStiffnessY()
	 * @generated
	 */
	void setLinearStiffnessY(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcBoundaryNodeCondition#getLinearStiffnessY <em>Linear Stiffness Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLinearStiffnessY()
	 * @see #getLinearStiffnessY()
	 * @see #setLinearStiffnessY(double)
	 * @generated
	 */
	void unsetLinearStiffnessY();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcBoundaryNodeCondition#getLinearStiffnessY <em>Linear Stiffness Y</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Linear Stiffness Y</em>' attribute is set.
	 * @see #unsetLinearStiffnessY()
	 * @see #getLinearStiffnessY()
	 * @see #setLinearStiffnessY(double)
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
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcBoundaryNodeCondition_LinearStiffnessYAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getLinearStiffnessYAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcBoundaryNodeCondition#getLinearStiffnessYAsString <em>Linear Stiffness YAs String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcBoundaryNodeCondition#getLinearStiffnessYAsString <em>Linear Stiffness YAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLinearStiffnessYAsString()
	 * @see #getLinearStiffnessYAsString()
	 * @see #setLinearStiffnessYAsString(String)
	 * @generated
	 */
	void unsetLinearStiffnessYAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcBoundaryNodeCondition#getLinearStiffnessYAsString <em>Linear Stiffness YAs String</em>}' attribute is set.
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
	 * @see #setLinearStiffnessZ(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcBoundaryNodeCondition_LinearStiffnessZ()
	 * @model unsettable="true"
	 * @generated
	 */
	double getLinearStiffnessZ();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcBoundaryNodeCondition#getLinearStiffnessZ <em>Linear Stiffness Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Linear Stiffness Z</em>' attribute.
	 * @see #isSetLinearStiffnessZ()
	 * @see #unsetLinearStiffnessZ()
	 * @see #getLinearStiffnessZ()
	 * @generated
	 */
	void setLinearStiffnessZ(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcBoundaryNodeCondition#getLinearStiffnessZ <em>Linear Stiffness Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLinearStiffnessZ()
	 * @see #getLinearStiffnessZ()
	 * @see #setLinearStiffnessZ(double)
	 * @generated
	 */
	void unsetLinearStiffnessZ();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcBoundaryNodeCondition#getLinearStiffnessZ <em>Linear Stiffness Z</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Linear Stiffness Z</em>' attribute is set.
	 * @see #unsetLinearStiffnessZ()
	 * @see #getLinearStiffnessZ()
	 * @see #setLinearStiffnessZ(double)
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
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcBoundaryNodeCondition_LinearStiffnessZAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getLinearStiffnessZAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcBoundaryNodeCondition#getLinearStiffnessZAsString <em>Linear Stiffness ZAs String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcBoundaryNodeCondition#getLinearStiffnessZAsString <em>Linear Stiffness ZAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLinearStiffnessZAsString()
	 * @see #getLinearStiffnessZAsString()
	 * @see #setLinearStiffnessZAsString(String)
	 * @generated
	 */
	void unsetLinearStiffnessZAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcBoundaryNodeCondition#getLinearStiffnessZAsString <em>Linear Stiffness ZAs String</em>}' attribute is set.
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
	 * @see #setRotationalStiffnessX(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcBoundaryNodeCondition_RotationalStiffnessX()
	 * @model unsettable="true"
	 * @generated
	 */
	double getRotationalStiffnessX();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcBoundaryNodeCondition#getRotationalStiffnessX <em>Rotational Stiffness X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rotational Stiffness X</em>' attribute.
	 * @see #isSetRotationalStiffnessX()
	 * @see #unsetRotationalStiffnessX()
	 * @see #getRotationalStiffnessX()
	 * @generated
	 */
	void setRotationalStiffnessX(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcBoundaryNodeCondition#getRotationalStiffnessX <em>Rotational Stiffness X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRotationalStiffnessX()
	 * @see #getRotationalStiffnessX()
	 * @see #setRotationalStiffnessX(double)
	 * @generated
	 */
	void unsetRotationalStiffnessX();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcBoundaryNodeCondition#getRotationalStiffnessX <em>Rotational Stiffness X</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Rotational Stiffness X</em>' attribute is set.
	 * @see #unsetRotationalStiffnessX()
	 * @see #getRotationalStiffnessX()
	 * @see #setRotationalStiffnessX(double)
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
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcBoundaryNodeCondition_RotationalStiffnessXAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getRotationalStiffnessXAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcBoundaryNodeCondition#getRotationalStiffnessXAsString <em>Rotational Stiffness XAs String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcBoundaryNodeCondition#getRotationalStiffnessXAsString <em>Rotational Stiffness XAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRotationalStiffnessXAsString()
	 * @see #getRotationalStiffnessXAsString()
	 * @see #setRotationalStiffnessXAsString(String)
	 * @generated
	 */
	void unsetRotationalStiffnessXAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcBoundaryNodeCondition#getRotationalStiffnessXAsString <em>Rotational Stiffness XAs String</em>}' attribute is set.
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
	 * @see #setRotationalStiffnessY(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcBoundaryNodeCondition_RotationalStiffnessY()
	 * @model unsettable="true"
	 * @generated
	 */
	double getRotationalStiffnessY();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcBoundaryNodeCondition#getRotationalStiffnessY <em>Rotational Stiffness Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rotational Stiffness Y</em>' attribute.
	 * @see #isSetRotationalStiffnessY()
	 * @see #unsetRotationalStiffnessY()
	 * @see #getRotationalStiffnessY()
	 * @generated
	 */
	void setRotationalStiffnessY(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcBoundaryNodeCondition#getRotationalStiffnessY <em>Rotational Stiffness Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRotationalStiffnessY()
	 * @see #getRotationalStiffnessY()
	 * @see #setRotationalStiffnessY(double)
	 * @generated
	 */
	void unsetRotationalStiffnessY();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcBoundaryNodeCondition#getRotationalStiffnessY <em>Rotational Stiffness Y</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Rotational Stiffness Y</em>' attribute is set.
	 * @see #unsetRotationalStiffnessY()
	 * @see #getRotationalStiffnessY()
	 * @see #setRotationalStiffnessY(double)
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
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcBoundaryNodeCondition_RotationalStiffnessYAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getRotationalStiffnessYAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcBoundaryNodeCondition#getRotationalStiffnessYAsString <em>Rotational Stiffness YAs String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcBoundaryNodeCondition#getRotationalStiffnessYAsString <em>Rotational Stiffness YAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRotationalStiffnessYAsString()
	 * @see #getRotationalStiffnessYAsString()
	 * @see #setRotationalStiffnessYAsString(String)
	 * @generated
	 */
	void unsetRotationalStiffnessYAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcBoundaryNodeCondition#getRotationalStiffnessYAsString <em>Rotational Stiffness YAs String</em>}' attribute is set.
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
	 * @see #setRotationalStiffnessZ(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcBoundaryNodeCondition_RotationalStiffnessZ()
	 * @model unsettable="true"
	 * @generated
	 */
	double getRotationalStiffnessZ();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcBoundaryNodeCondition#getRotationalStiffnessZ <em>Rotational Stiffness Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rotational Stiffness Z</em>' attribute.
	 * @see #isSetRotationalStiffnessZ()
	 * @see #unsetRotationalStiffnessZ()
	 * @see #getRotationalStiffnessZ()
	 * @generated
	 */
	void setRotationalStiffnessZ(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcBoundaryNodeCondition#getRotationalStiffnessZ <em>Rotational Stiffness Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRotationalStiffnessZ()
	 * @see #getRotationalStiffnessZ()
	 * @see #setRotationalStiffnessZ(double)
	 * @generated
	 */
	void unsetRotationalStiffnessZ();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcBoundaryNodeCondition#getRotationalStiffnessZ <em>Rotational Stiffness Z</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Rotational Stiffness Z</em>' attribute is set.
	 * @see #unsetRotationalStiffnessZ()
	 * @see #getRotationalStiffnessZ()
	 * @see #setRotationalStiffnessZ(double)
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
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcBoundaryNodeCondition_RotationalStiffnessZAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getRotationalStiffnessZAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcBoundaryNodeCondition#getRotationalStiffnessZAsString <em>Rotational Stiffness ZAs String</em>}' attribute.
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
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcBoundaryNodeCondition#getRotationalStiffnessZAsString <em>Rotational Stiffness ZAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRotationalStiffnessZAsString()
	 * @see #getRotationalStiffnessZAsString()
	 * @see #setRotationalStiffnessZAsString(String)
	 * @generated
	 */
	void unsetRotationalStiffnessZAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcBoundaryNodeCondition#getRotationalStiffnessZAsString <em>Rotational Stiffness ZAs String</em>}' attribute is set.
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

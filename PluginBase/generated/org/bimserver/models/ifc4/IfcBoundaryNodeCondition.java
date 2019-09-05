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

public interface IfcBoundaryNodeCondition extends IfcBoundaryCondition {
	/**
	 * Returns the value of the '<em><b>Translational Stiffness X</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Translational Stiffness X</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Translational Stiffness X</em>' reference.
	 * @see #isSetTranslationalStiffnessX()
	 * @see #unsetTranslationalStiffnessX()
	 * @see #setTranslationalStiffnessX(IfcTranslationalStiffnessSelect)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcBoundaryNodeCondition_TranslationalStiffnessX()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcTranslationalStiffnessSelect getTranslationalStiffnessX();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcBoundaryNodeCondition#getTranslationalStiffnessX <em>Translational Stiffness X</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Translational Stiffness X</em>' reference.
	 * @see #isSetTranslationalStiffnessX()
	 * @see #unsetTranslationalStiffnessX()
	 * @see #getTranslationalStiffnessX()
	 * @generated
	 */
	void setTranslationalStiffnessX(IfcTranslationalStiffnessSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcBoundaryNodeCondition#getTranslationalStiffnessX <em>Translational Stiffness X</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTranslationalStiffnessX()
	 * @see #getTranslationalStiffnessX()
	 * @see #setTranslationalStiffnessX(IfcTranslationalStiffnessSelect)
	 * @generated
	 */
	void unsetTranslationalStiffnessX();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcBoundaryNodeCondition#getTranslationalStiffnessX <em>Translational Stiffness X</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Translational Stiffness X</em>' reference is set.
	 * @see #unsetTranslationalStiffnessX()
	 * @see #getTranslationalStiffnessX()
	 * @see #setTranslationalStiffnessX(IfcTranslationalStiffnessSelect)
	 * @generated
	 */
	boolean isSetTranslationalStiffnessX();

	/**
	 * Returns the value of the '<em><b>Translational Stiffness Y</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Translational Stiffness Y</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Translational Stiffness Y</em>' reference.
	 * @see #isSetTranslationalStiffnessY()
	 * @see #unsetTranslationalStiffnessY()
	 * @see #setTranslationalStiffnessY(IfcTranslationalStiffnessSelect)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcBoundaryNodeCondition_TranslationalStiffnessY()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcTranslationalStiffnessSelect getTranslationalStiffnessY();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcBoundaryNodeCondition#getTranslationalStiffnessY <em>Translational Stiffness Y</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Translational Stiffness Y</em>' reference.
	 * @see #isSetTranslationalStiffnessY()
	 * @see #unsetTranslationalStiffnessY()
	 * @see #getTranslationalStiffnessY()
	 * @generated
	 */
	void setTranslationalStiffnessY(IfcTranslationalStiffnessSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcBoundaryNodeCondition#getTranslationalStiffnessY <em>Translational Stiffness Y</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTranslationalStiffnessY()
	 * @see #getTranslationalStiffnessY()
	 * @see #setTranslationalStiffnessY(IfcTranslationalStiffnessSelect)
	 * @generated
	 */
	void unsetTranslationalStiffnessY();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcBoundaryNodeCondition#getTranslationalStiffnessY <em>Translational Stiffness Y</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Translational Stiffness Y</em>' reference is set.
	 * @see #unsetTranslationalStiffnessY()
	 * @see #getTranslationalStiffnessY()
	 * @see #setTranslationalStiffnessY(IfcTranslationalStiffnessSelect)
	 * @generated
	 */
	boolean isSetTranslationalStiffnessY();

	/**
	 * Returns the value of the '<em><b>Translational Stiffness Z</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Translational Stiffness Z</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Translational Stiffness Z</em>' reference.
	 * @see #isSetTranslationalStiffnessZ()
	 * @see #unsetTranslationalStiffnessZ()
	 * @see #setTranslationalStiffnessZ(IfcTranslationalStiffnessSelect)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcBoundaryNodeCondition_TranslationalStiffnessZ()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcTranslationalStiffnessSelect getTranslationalStiffnessZ();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcBoundaryNodeCondition#getTranslationalStiffnessZ <em>Translational Stiffness Z</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Translational Stiffness Z</em>' reference.
	 * @see #isSetTranslationalStiffnessZ()
	 * @see #unsetTranslationalStiffnessZ()
	 * @see #getTranslationalStiffnessZ()
	 * @generated
	 */
	void setTranslationalStiffnessZ(IfcTranslationalStiffnessSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcBoundaryNodeCondition#getTranslationalStiffnessZ <em>Translational Stiffness Z</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTranslationalStiffnessZ()
	 * @see #getTranslationalStiffnessZ()
	 * @see #setTranslationalStiffnessZ(IfcTranslationalStiffnessSelect)
	 * @generated
	 */
	void unsetTranslationalStiffnessZ();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcBoundaryNodeCondition#getTranslationalStiffnessZ <em>Translational Stiffness Z</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Translational Stiffness Z</em>' reference is set.
	 * @see #unsetTranslationalStiffnessZ()
	 * @see #getTranslationalStiffnessZ()
	 * @see #setTranslationalStiffnessZ(IfcTranslationalStiffnessSelect)
	 * @generated
	 */
	boolean isSetTranslationalStiffnessZ();

	/**
	 * Returns the value of the '<em><b>Rotational Stiffness X</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rotational Stiffness X</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rotational Stiffness X</em>' reference.
	 * @see #isSetRotationalStiffnessX()
	 * @see #unsetRotationalStiffnessX()
	 * @see #setRotationalStiffnessX(IfcRotationalStiffnessSelect)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcBoundaryNodeCondition_RotationalStiffnessX()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcRotationalStiffnessSelect getRotationalStiffnessX();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcBoundaryNodeCondition#getRotationalStiffnessX <em>Rotational Stiffness X</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rotational Stiffness X</em>' reference.
	 * @see #isSetRotationalStiffnessX()
	 * @see #unsetRotationalStiffnessX()
	 * @see #getRotationalStiffnessX()
	 * @generated
	 */
	void setRotationalStiffnessX(IfcRotationalStiffnessSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcBoundaryNodeCondition#getRotationalStiffnessX <em>Rotational Stiffness X</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRotationalStiffnessX()
	 * @see #getRotationalStiffnessX()
	 * @see #setRotationalStiffnessX(IfcRotationalStiffnessSelect)
	 * @generated
	 */
	void unsetRotationalStiffnessX();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcBoundaryNodeCondition#getRotationalStiffnessX <em>Rotational Stiffness X</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Rotational Stiffness X</em>' reference is set.
	 * @see #unsetRotationalStiffnessX()
	 * @see #getRotationalStiffnessX()
	 * @see #setRotationalStiffnessX(IfcRotationalStiffnessSelect)
	 * @generated
	 */
	boolean isSetRotationalStiffnessX();

	/**
	 * Returns the value of the '<em><b>Rotational Stiffness Y</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rotational Stiffness Y</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rotational Stiffness Y</em>' reference.
	 * @see #isSetRotationalStiffnessY()
	 * @see #unsetRotationalStiffnessY()
	 * @see #setRotationalStiffnessY(IfcRotationalStiffnessSelect)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcBoundaryNodeCondition_RotationalStiffnessY()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcRotationalStiffnessSelect getRotationalStiffnessY();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcBoundaryNodeCondition#getRotationalStiffnessY <em>Rotational Stiffness Y</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rotational Stiffness Y</em>' reference.
	 * @see #isSetRotationalStiffnessY()
	 * @see #unsetRotationalStiffnessY()
	 * @see #getRotationalStiffnessY()
	 * @generated
	 */
	void setRotationalStiffnessY(IfcRotationalStiffnessSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcBoundaryNodeCondition#getRotationalStiffnessY <em>Rotational Stiffness Y</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRotationalStiffnessY()
	 * @see #getRotationalStiffnessY()
	 * @see #setRotationalStiffnessY(IfcRotationalStiffnessSelect)
	 * @generated
	 */
	void unsetRotationalStiffnessY();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcBoundaryNodeCondition#getRotationalStiffnessY <em>Rotational Stiffness Y</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Rotational Stiffness Y</em>' reference is set.
	 * @see #unsetRotationalStiffnessY()
	 * @see #getRotationalStiffnessY()
	 * @see #setRotationalStiffnessY(IfcRotationalStiffnessSelect)
	 * @generated
	 */
	boolean isSetRotationalStiffnessY();

	/**
	 * Returns the value of the '<em><b>Rotational Stiffness Z</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rotational Stiffness Z</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rotational Stiffness Z</em>' reference.
	 * @see #isSetRotationalStiffnessZ()
	 * @see #unsetRotationalStiffnessZ()
	 * @see #setRotationalStiffnessZ(IfcRotationalStiffnessSelect)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcBoundaryNodeCondition_RotationalStiffnessZ()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcRotationalStiffnessSelect getRotationalStiffnessZ();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcBoundaryNodeCondition#getRotationalStiffnessZ <em>Rotational Stiffness Z</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rotational Stiffness Z</em>' reference.
	 * @see #isSetRotationalStiffnessZ()
	 * @see #unsetRotationalStiffnessZ()
	 * @see #getRotationalStiffnessZ()
	 * @generated
	 */
	void setRotationalStiffnessZ(IfcRotationalStiffnessSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcBoundaryNodeCondition#getRotationalStiffnessZ <em>Rotational Stiffness Z</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRotationalStiffnessZ()
	 * @see #getRotationalStiffnessZ()
	 * @see #setRotationalStiffnessZ(IfcRotationalStiffnessSelect)
	 * @generated
	 */
	void unsetRotationalStiffnessZ();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcBoundaryNodeCondition#getRotationalStiffnessZ <em>Rotational Stiffness Z</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Rotational Stiffness Z</em>' reference is set.
	 * @see #unsetRotationalStiffnessZ()
	 * @see #getRotationalStiffnessZ()
	 * @see #setRotationalStiffnessZ(IfcRotationalStiffnessSelect)
	 * @generated
	 */
	boolean isSetRotationalStiffnessZ();

} // IfcBoundaryNodeCondition

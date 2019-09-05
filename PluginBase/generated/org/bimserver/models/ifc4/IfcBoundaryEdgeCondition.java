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

public interface IfcBoundaryEdgeCondition extends IfcBoundaryCondition {
	/**
	 * Returns the value of the '<em><b>Translational Stiffness By Length X</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Translational Stiffness By Length X</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Translational Stiffness By Length X</em>' reference.
	 * @see #isSetTranslationalStiffnessByLengthX()
	 * @see #unsetTranslationalStiffnessByLengthX()
	 * @see #setTranslationalStiffnessByLengthX(IfcModulusOfTranslationalSubgradeReactionSelect)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcBoundaryEdgeCondition_TranslationalStiffnessByLengthX()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcModulusOfTranslationalSubgradeReactionSelect getTranslationalStiffnessByLengthX();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcBoundaryEdgeCondition#getTranslationalStiffnessByLengthX <em>Translational Stiffness By Length X</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Translational Stiffness By Length X</em>' reference.
	 * @see #isSetTranslationalStiffnessByLengthX()
	 * @see #unsetTranslationalStiffnessByLengthX()
	 * @see #getTranslationalStiffnessByLengthX()
	 * @generated
	 */
	void setTranslationalStiffnessByLengthX(IfcModulusOfTranslationalSubgradeReactionSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcBoundaryEdgeCondition#getTranslationalStiffnessByLengthX <em>Translational Stiffness By Length X</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTranslationalStiffnessByLengthX()
	 * @see #getTranslationalStiffnessByLengthX()
	 * @see #setTranslationalStiffnessByLengthX(IfcModulusOfTranslationalSubgradeReactionSelect)
	 * @generated
	 */
	void unsetTranslationalStiffnessByLengthX();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcBoundaryEdgeCondition#getTranslationalStiffnessByLengthX <em>Translational Stiffness By Length X</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Translational Stiffness By Length X</em>' reference is set.
	 * @see #unsetTranslationalStiffnessByLengthX()
	 * @see #getTranslationalStiffnessByLengthX()
	 * @see #setTranslationalStiffnessByLengthX(IfcModulusOfTranslationalSubgradeReactionSelect)
	 * @generated
	 */
	boolean isSetTranslationalStiffnessByLengthX();

	/**
	 * Returns the value of the '<em><b>Translational Stiffness By Length Y</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Translational Stiffness By Length Y</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Translational Stiffness By Length Y</em>' reference.
	 * @see #isSetTranslationalStiffnessByLengthY()
	 * @see #unsetTranslationalStiffnessByLengthY()
	 * @see #setTranslationalStiffnessByLengthY(IfcModulusOfTranslationalSubgradeReactionSelect)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcBoundaryEdgeCondition_TranslationalStiffnessByLengthY()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcModulusOfTranslationalSubgradeReactionSelect getTranslationalStiffnessByLengthY();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcBoundaryEdgeCondition#getTranslationalStiffnessByLengthY <em>Translational Stiffness By Length Y</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Translational Stiffness By Length Y</em>' reference.
	 * @see #isSetTranslationalStiffnessByLengthY()
	 * @see #unsetTranslationalStiffnessByLengthY()
	 * @see #getTranslationalStiffnessByLengthY()
	 * @generated
	 */
	void setTranslationalStiffnessByLengthY(IfcModulusOfTranslationalSubgradeReactionSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcBoundaryEdgeCondition#getTranslationalStiffnessByLengthY <em>Translational Stiffness By Length Y</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTranslationalStiffnessByLengthY()
	 * @see #getTranslationalStiffnessByLengthY()
	 * @see #setTranslationalStiffnessByLengthY(IfcModulusOfTranslationalSubgradeReactionSelect)
	 * @generated
	 */
	void unsetTranslationalStiffnessByLengthY();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcBoundaryEdgeCondition#getTranslationalStiffnessByLengthY <em>Translational Stiffness By Length Y</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Translational Stiffness By Length Y</em>' reference is set.
	 * @see #unsetTranslationalStiffnessByLengthY()
	 * @see #getTranslationalStiffnessByLengthY()
	 * @see #setTranslationalStiffnessByLengthY(IfcModulusOfTranslationalSubgradeReactionSelect)
	 * @generated
	 */
	boolean isSetTranslationalStiffnessByLengthY();

	/**
	 * Returns the value of the '<em><b>Translational Stiffness By Length Z</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Translational Stiffness By Length Z</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Translational Stiffness By Length Z</em>' reference.
	 * @see #isSetTranslationalStiffnessByLengthZ()
	 * @see #unsetTranslationalStiffnessByLengthZ()
	 * @see #setTranslationalStiffnessByLengthZ(IfcModulusOfTranslationalSubgradeReactionSelect)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcBoundaryEdgeCondition_TranslationalStiffnessByLengthZ()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcModulusOfTranslationalSubgradeReactionSelect getTranslationalStiffnessByLengthZ();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcBoundaryEdgeCondition#getTranslationalStiffnessByLengthZ <em>Translational Stiffness By Length Z</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Translational Stiffness By Length Z</em>' reference.
	 * @see #isSetTranslationalStiffnessByLengthZ()
	 * @see #unsetTranslationalStiffnessByLengthZ()
	 * @see #getTranslationalStiffnessByLengthZ()
	 * @generated
	 */
	void setTranslationalStiffnessByLengthZ(IfcModulusOfTranslationalSubgradeReactionSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcBoundaryEdgeCondition#getTranslationalStiffnessByLengthZ <em>Translational Stiffness By Length Z</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTranslationalStiffnessByLengthZ()
	 * @see #getTranslationalStiffnessByLengthZ()
	 * @see #setTranslationalStiffnessByLengthZ(IfcModulusOfTranslationalSubgradeReactionSelect)
	 * @generated
	 */
	void unsetTranslationalStiffnessByLengthZ();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcBoundaryEdgeCondition#getTranslationalStiffnessByLengthZ <em>Translational Stiffness By Length Z</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Translational Stiffness By Length Z</em>' reference is set.
	 * @see #unsetTranslationalStiffnessByLengthZ()
	 * @see #getTranslationalStiffnessByLengthZ()
	 * @see #setTranslationalStiffnessByLengthZ(IfcModulusOfTranslationalSubgradeReactionSelect)
	 * @generated
	 */
	boolean isSetTranslationalStiffnessByLengthZ();

	/**
	 * Returns the value of the '<em><b>Rotational Stiffness By Length X</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rotational Stiffness By Length X</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rotational Stiffness By Length X</em>' reference.
	 * @see #isSetRotationalStiffnessByLengthX()
	 * @see #unsetRotationalStiffnessByLengthX()
	 * @see #setRotationalStiffnessByLengthX(IfcModulusOfRotationalSubgradeReactionSelect)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcBoundaryEdgeCondition_RotationalStiffnessByLengthX()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcModulusOfRotationalSubgradeReactionSelect getRotationalStiffnessByLengthX();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcBoundaryEdgeCondition#getRotationalStiffnessByLengthX <em>Rotational Stiffness By Length X</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rotational Stiffness By Length X</em>' reference.
	 * @see #isSetRotationalStiffnessByLengthX()
	 * @see #unsetRotationalStiffnessByLengthX()
	 * @see #getRotationalStiffnessByLengthX()
	 * @generated
	 */
	void setRotationalStiffnessByLengthX(IfcModulusOfRotationalSubgradeReactionSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcBoundaryEdgeCondition#getRotationalStiffnessByLengthX <em>Rotational Stiffness By Length X</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRotationalStiffnessByLengthX()
	 * @see #getRotationalStiffnessByLengthX()
	 * @see #setRotationalStiffnessByLengthX(IfcModulusOfRotationalSubgradeReactionSelect)
	 * @generated
	 */
	void unsetRotationalStiffnessByLengthX();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcBoundaryEdgeCondition#getRotationalStiffnessByLengthX <em>Rotational Stiffness By Length X</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Rotational Stiffness By Length X</em>' reference is set.
	 * @see #unsetRotationalStiffnessByLengthX()
	 * @see #getRotationalStiffnessByLengthX()
	 * @see #setRotationalStiffnessByLengthX(IfcModulusOfRotationalSubgradeReactionSelect)
	 * @generated
	 */
	boolean isSetRotationalStiffnessByLengthX();

	/**
	 * Returns the value of the '<em><b>Rotational Stiffness By Length Y</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rotational Stiffness By Length Y</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rotational Stiffness By Length Y</em>' reference.
	 * @see #isSetRotationalStiffnessByLengthY()
	 * @see #unsetRotationalStiffnessByLengthY()
	 * @see #setRotationalStiffnessByLengthY(IfcModulusOfRotationalSubgradeReactionSelect)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcBoundaryEdgeCondition_RotationalStiffnessByLengthY()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcModulusOfRotationalSubgradeReactionSelect getRotationalStiffnessByLengthY();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcBoundaryEdgeCondition#getRotationalStiffnessByLengthY <em>Rotational Stiffness By Length Y</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rotational Stiffness By Length Y</em>' reference.
	 * @see #isSetRotationalStiffnessByLengthY()
	 * @see #unsetRotationalStiffnessByLengthY()
	 * @see #getRotationalStiffnessByLengthY()
	 * @generated
	 */
	void setRotationalStiffnessByLengthY(IfcModulusOfRotationalSubgradeReactionSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcBoundaryEdgeCondition#getRotationalStiffnessByLengthY <em>Rotational Stiffness By Length Y</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRotationalStiffnessByLengthY()
	 * @see #getRotationalStiffnessByLengthY()
	 * @see #setRotationalStiffnessByLengthY(IfcModulusOfRotationalSubgradeReactionSelect)
	 * @generated
	 */
	void unsetRotationalStiffnessByLengthY();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcBoundaryEdgeCondition#getRotationalStiffnessByLengthY <em>Rotational Stiffness By Length Y</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Rotational Stiffness By Length Y</em>' reference is set.
	 * @see #unsetRotationalStiffnessByLengthY()
	 * @see #getRotationalStiffnessByLengthY()
	 * @see #setRotationalStiffnessByLengthY(IfcModulusOfRotationalSubgradeReactionSelect)
	 * @generated
	 */
	boolean isSetRotationalStiffnessByLengthY();

	/**
	 * Returns the value of the '<em><b>Rotational Stiffness By Length Z</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rotational Stiffness By Length Z</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rotational Stiffness By Length Z</em>' reference.
	 * @see #isSetRotationalStiffnessByLengthZ()
	 * @see #unsetRotationalStiffnessByLengthZ()
	 * @see #setRotationalStiffnessByLengthZ(IfcModulusOfRotationalSubgradeReactionSelect)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcBoundaryEdgeCondition_RotationalStiffnessByLengthZ()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcModulusOfRotationalSubgradeReactionSelect getRotationalStiffnessByLengthZ();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcBoundaryEdgeCondition#getRotationalStiffnessByLengthZ <em>Rotational Stiffness By Length Z</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rotational Stiffness By Length Z</em>' reference.
	 * @see #isSetRotationalStiffnessByLengthZ()
	 * @see #unsetRotationalStiffnessByLengthZ()
	 * @see #getRotationalStiffnessByLengthZ()
	 * @generated
	 */
	void setRotationalStiffnessByLengthZ(IfcModulusOfRotationalSubgradeReactionSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcBoundaryEdgeCondition#getRotationalStiffnessByLengthZ <em>Rotational Stiffness By Length Z</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRotationalStiffnessByLengthZ()
	 * @see #getRotationalStiffnessByLengthZ()
	 * @see #setRotationalStiffnessByLengthZ(IfcModulusOfRotationalSubgradeReactionSelect)
	 * @generated
	 */
	void unsetRotationalStiffnessByLengthZ();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcBoundaryEdgeCondition#getRotationalStiffnessByLengthZ <em>Rotational Stiffness By Length Z</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Rotational Stiffness By Length Z</em>' reference is set.
	 * @see #unsetRotationalStiffnessByLengthZ()
	 * @see #getRotationalStiffnessByLengthZ()
	 * @see #setRotationalStiffnessByLengthZ(IfcModulusOfRotationalSubgradeReactionSelect)
	 * @generated
	 */
	boolean isSetRotationalStiffnessByLengthZ();

} // IfcBoundaryEdgeCondition

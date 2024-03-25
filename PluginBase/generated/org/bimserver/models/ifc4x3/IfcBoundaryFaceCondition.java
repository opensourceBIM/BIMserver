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
 * A representation of the model object '<em><b>Ifc Boundary Face Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcBoundaryFaceCondition#getTranslationalStiffnessByAreaX <em>Translational Stiffness By Area X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcBoundaryFaceCondition#getTranslationalStiffnessByAreaY <em>Translational Stiffness By Area Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcBoundaryFaceCondition#getTranslationalStiffnessByAreaZ <em>Translational Stiffness By Area Z</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcBoundaryFaceCondition()
 * @model
 * @generated
 */
public interface IfcBoundaryFaceCondition extends IfcBoundaryCondition {
	/**
	 * Returns the value of the '<em><b>Translational Stiffness By Area X</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Translational Stiffness By Area X</em>' reference.
	 * @see #isSetTranslationalStiffnessByAreaX()
	 * @see #unsetTranslationalStiffnessByAreaX()
	 * @see #setTranslationalStiffnessByAreaX(IfcModulusOfSubgradeReactionSelect)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcBoundaryFaceCondition_TranslationalStiffnessByAreaX()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcModulusOfSubgradeReactionSelect getTranslationalStiffnessByAreaX();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcBoundaryFaceCondition#getTranslationalStiffnessByAreaX <em>Translational Stiffness By Area X</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Translational Stiffness By Area X</em>' reference.
	 * @see #isSetTranslationalStiffnessByAreaX()
	 * @see #unsetTranslationalStiffnessByAreaX()
	 * @see #getTranslationalStiffnessByAreaX()
	 * @generated
	 */
	void setTranslationalStiffnessByAreaX(IfcModulusOfSubgradeReactionSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcBoundaryFaceCondition#getTranslationalStiffnessByAreaX <em>Translational Stiffness By Area X</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTranslationalStiffnessByAreaX()
	 * @see #getTranslationalStiffnessByAreaX()
	 * @see #setTranslationalStiffnessByAreaX(IfcModulusOfSubgradeReactionSelect)
	 * @generated
	 */
	void unsetTranslationalStiffnessByAreaX();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcBoundaryFaceCondition#getTranslationalStiffnessByAreaX <em>Translational Stiffness By Area X</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Translational Stiffness By Area X</em>' reference is set.
	 * @see #unsetTranslationalStiffnessByAreaX()
	 * @see #getTranslationalStiffnessByAreaX()
	 * @see #setTranslationalStiffnessByAreaX(IfcModulusOfSubgradeReactionSelect)
	 * @generated
	 */
	boolean isSetTranslationalStiffnessByAreaX();

	/**
	 * Returns the value of the '<em><b>Translational Stiffness By Area Y</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Translational Stiffness By Area Y</em>' reference.
	 * @see #isSetTranslationalStiffnessByAreaY()
	 * @see #unsetTranslationalStiffnessByAreaY()
	 * @see #setTranslationalStiffnessByAreaY(IfcModulusOfSubgradeReactionSelect)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcBoundaryFaceCondition_TranslationalStiffnessByAreaY()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcModulusOfSubgradeReactionSelect getTranslationalStiffnessByAreaY();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcBoundaryFaceCondition#getTranslationalStiffnessByAreaY <em>Translational Stiffness By Area Y</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Translational Stiffness By Area Y</em>' reference.
	 * @see #isSetTranslationalStiffnessByAreaY()
	 * @see #unsetTranslationalStiffnessByAreaY()
	 * @see #getTranslationalStiffnessByAreaY()
	 * @generated
	 */
	void setTranslationalStiffnessByAreaY(IfcModulusOfSubgradeReactionSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcBoundaryFaceCondition#getTranslationalStiffnessByAreaY <em>Translational Stiffness By Area Y</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTranslationalStiffnessByAreaY()
	 * @see #getTranslationalStiffnessByAreaY()
	 * @see #setTranslationalStiffnessByAreaY(IfcModulusOfSubgradeReactionSelect)
	 * @generated
	 */
	void unsetTranslationalStiffnessByAreaY();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcBoundaryFaceCondition#getTranslationalStiffnessByAreaY <em>Translational Stiffness By Area Y</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Translational Stiffness By Area Y</em>' reference is set.
	 * @see #unsetTranslationalStiffnessByAreaY()
	 * @see #getTranslationalStiffnessByAreaY()
	 * @see #setTranslationalStiffnessByAreaY(IfcModulusOfSubgradeReactionSelect)
	 * @generated
	 */
	boolean isSetTranslationalStiffnessByAreaY();

	/**
	 * Returns the value of the '<em><b>Translational Stiffness By Area Z</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Translational Stiffness By Area Z</em>' reference.
	 * @see #isSetTranslationalStiffnessByAreaZ()
	 * @see #unsetTranslationalStiffnessByAreaZ()
	 * @see #setTranslationalStiffnessByAreaZ(IfcModulusOfSubgradeReactionSelect)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcBoundaryFaceCondition_TranslationalStiffnessByAreaZ()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcModulusOfSubgradeReactionSelect getTranslationalStiffnessByAreaZ();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcBoundaryFaceCondition#getTranslationalStiffnessByAreaZ <em>Translational Stiffness By Area Z</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Translational Stiffness By Area Z</em>' reference.
	 * @see #isSetTranslationalStiffnessByAreaZ()
	 * @see #unsetTranslationalStiffnessByAreaZ()
	 * @see #getTranslationalStiffnessByAreaZ()
	 * @generated
	 */
	void setTranslationalStiffnessByAreaZ(IfcModulusOfSubgradeReactionSelect value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcBoundaryFaceCondition#getTranslationalStiffnessByAreaZ <em>Translational Stiffness By Area Z</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTranslationalStiffnessByAreaZ()
	 * @see #getTranslationalStiffnessByAreaZ()
	 * @see #setTranslationalStiffnessByAreaZ(IfcModulusOfSubgradeReactionSelect)
	 * @generated
	 */
	void unsetTranslationalStiffnessByAreaZ();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcBoundaryFaceCondition#getTranslationalStiffnessByAreaZ <em>Translational Stiffness By Area Z</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Translational Stiffness By Area Z</em>' reference is set.
	 * @see #unsetTranslationalStiffnessByAreaZ()
	 * @see #getTranslationalStiffnessByAreaZ()
	 * @see #setTranslationalStiffnessByAreaZ(IfcModulusOfSubgradeReactionSelect)
	 * @generated
	 */
	boolean isSetTranslationalStiffnessByAreaZ();

} // IfcBoundaryFaceCondition

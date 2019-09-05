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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Surface Reinforcement Area</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcSurfaceReinforcementArea#getSurfaceReinforcement1 <em>Surface Reinforcement1</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcSurfaceReinforcementArea#getSurfaceReinforcement1AsString <em>Surface Reinforcement1 As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcSurfaceReinforcementArea#getSurfaceReinforcement2 <em>Surface Reinforcement2</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcSurfaceReinforcementArea#getSurfaceReinforcement2AsString <em>Surface Reinforcement2 As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcSurfaceReinforcementArea#getShearReinforcement <em>Shear Reinforcement</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcSurfaceReinforcementArea#getShearReinforcementAsString <em>Shear Reinforcement As String</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSurfaceReinforcementArea()
 * @model
 * @generated
 */
public interface IfcSurfaceReinforcementArea extends IfcStructuralLoadOrResult {
	/**
	 * Returns the value of the '<em><b>Surface Reinforcement1</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Double}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Surface Reinforcement1</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Surface Reinforcement1</em>' attribute list.
	 * @see #isSetSurfaceReinforcement1()
	 * @see #unsetSurfaceReinforcement1()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSurfaceReinforcementArea_SurfaceReinforcement1()
	 * @model unique="false" unsettable="true"
	 * @generated
	 */
	EList<Double> getSurfaceReinforcement1();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcSurfaceReinforcementArea#getSurfaceReinforcement1 <em>Surface Reinforcement1</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSurfaceReinforcement1()
	 * @see #getSurfaceReinforcement1()
	 * @generated
	 */
	void unsetSurfaceReinforcement1();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcSurfaceReinforcementArea#getSurfaceReinforcement1 <em>Surface Reinforcement1</em>}' attribute list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Surface Reinforcement1</em>' attribute list is set.
	 * @see #unsetSurfaceReinforcement1()
	 * @see #getSurfaceReinforcement1()
	 * @generated
	 */
	boolean isSetSurfaceReinforcement1();

	/**
	 * Returns the value of the '<em><b>Surface Reinforcement1 As String</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Surface Reinforcement1 As String</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Surface Reinforcement1 As String</em>' attribute list.
	 * @see #isSetSurfaceReinforcement1AsString()
	 * @see #unsetSurfaceReinforcement1AsString()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSurfaceReinforcementArea_SurfaceReinforcement1AsString()
	 * @model unique="false" unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	EList<String> getSurfaceReinforcement1AsString();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcSurfaceReinforcementArea#getSurfaceReinforcement1AsString <em>Surface Reinforcement1 As String</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSurfaceReinforcement1AsString()
	 * @see #getSurfaceReinforcement1AsString()
	 * @generated
	 */
	void unsetSurfaceReinforcement1AsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcSurfaceReinforcementArea#getSurfaceReinforcement1AsString <em>Surface Reinforcement1 As String</em>}' attribute list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Surface Reinforcement1 As String</em>' attribute list is set.
	 * @see #unsetSurfaceReinforcement1AsString()
	 * @see #getSurfaceReinforcement1AsString()
	 * @generated
	 */
	boolean isSetSurfaceReinforcement1AsString();

	/**
	 * Returns the value of the '<em><b>Surface Reinforcement2</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Double}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Surface Reinforcement2</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Surface Reinforcement2</em>' attribute list.
	 * @see #isSetSurfaceReinforcement2()
	 * @see #unsetSurfaceReinforcement2()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSurfaceReinforcementArea_SurfaceReinforcement2()
	 * @model unique="false" unsettable="true"
	 * @generated
	 */
	EList<Double> getSurfaceReinforcement2();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcSurfaceReinforcementArea#getSurfaceReinforcement2 <em>Surface Reinforcement2</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSurfaceReinforcement2()
	 * @see #getSurfaceReinforcement2()
	 * @generated
	 */
	void unsetSurfaceReinforcement2();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcSurfaceReinforcementArea#getSurfaceReinforcement2 <em>Surface Reinforcement2</em>}' attribute list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Surface Reinforcement2</em>' attribute list is set.
	 * @see #unsetSurfaceReinforcement2()
	 * @see #getSurfaceReinforcement2()
	 * @generated
	 */
	boolean isSetSurfaceReinforcement2();

	/**
	 * Returns the value of the '<em><b>Surface Reinforcement2 As String</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Surface Reinforcement2 As String</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Surface Reinforcement2 As String</em>' attribute list.
	 * @see #isSetSurfaceReinforcement2AsString()
	 * @see #unsetSurfaceReinforcement2AsString()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSurfaceReinforcementArea_SurfaceReinforcement2AsString()
	 * @model unique="false" unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	EList<String> getSurfaceReinforcement2AsString();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcSurfaceReinforcementArea#getSurfaceReinforcement2AsString <em>Surface Reinforcement2 As String</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSurfaceReinforcement2AsString()
	 * @see #getSurfaceReinforcement2AsString()
	 * @generated
	 */
	void unsetSurfaceReinforcement2AsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcSurfaceReinforcementArea#getSurfaceReinforcement2AsString <em>Surface Reinforcement2 As String</em>}' attribute list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Surface Reinforcement2 As String</em>' attribute list is set.
	 * @see #unsetSurfaceReinforcement2AsString()
	 * @see #getSurfaceReinforcement2AsString()
	 * @generated
	 */
	boolean isSetSurfaceReinforcement2AsString();

	/**
	 * Returns the value of the '<em><b>Shear Reinforcement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shear Reinforcement</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shear Reinforcement</em>' attribute.
	 * @see #isSetShearReinforcement()
	 * @see #unsetShearReinforcement()
	 * @see #setShearReinforcement(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSurfaceReinforcementArea_ShearReinforcement()
	 * @model unsettable="true"
	 * @generated
	 */
	double getShearReinforcement();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcSurfaceReinforcementArea#getShearReinforcement <em>Shear Reinforcement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shear Reinforcement</em>' attribute.
	 * @see #isSetShearReinforcement()
	 * @see #unsetShearReinforcement()
	 * @see #getShearReinforcement()
	 * @generated
	 */
	void setShearReinforcement(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcSurfaceReinforcementArea#getShearReinforcement <em>Shear Reinforcement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetShearReinforcement()
	 * @see #getShearReinforcement()
	 * @see #setShearReinforcement(double)
	 * @generated
	 */
	void unsetShearReinforcement();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcSurfaceReinforcementArea#getShearReinforcement <em>Shear Reinforcement</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Shear Reinforcement</em>' attribute is set.
	 * @see #unsetShearReinforcement()
	 * @see #getShearReinforcement()
	 * @see #setShearReinforcement(double)
	 * @generated
	 */
	boolean isSetShearReinforcement();

	/**
	 * Returns the value of the '<em><b>Shear Reinforcement As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shear Reinforcement As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shear Reinforcement As String</em>' attribute.
	 * @see #isSetShearReinforcementAsString()
	 * @see #unsetShearReinforcementAsString()
	 * @see #setShearReinforcementAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSurfaceReinforcementArea_ShearReinforcementAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getShearReinforcementAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcSurfaceReinforcementArea#getShearReinforcementAsString <em>Shear Reinforcement As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shear Reinforcement As String</em>' attribute.
	 * @see #isSetShearReinforcementAsString()
	 * @see #unsetShearReinforcementAsString()
	 * @see #getShearReinforcementAsString()
	 * @generated
	 */
	void setShearReinforcementAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcSurfaceReinforcementArea#getShearReinforcementAsString <em>Shear Reinforcement As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetShearReinforcementAsString()
	 * @see #getShearReinforcementAsString()
	 * @see #setShearReinforcementAsString(String)
	 * @generated
	 */
	void unsetShearReinforcementAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcSurfaceReinforcementArea#getShearReinforcementAsString <em>Shear Reinforcement As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Shear Reinforcement As String</em>' attribute is set.
	 * @see #unsetShearReinforcementAsString()
	 * @see #getShearReinforcementAsString()
	 * @see #setShearReinforcementAsString(String)
	 * @generated
	 */
	boolean isSetShearReinforcementAsString();

} // IfcSurfaceReinforcementArea

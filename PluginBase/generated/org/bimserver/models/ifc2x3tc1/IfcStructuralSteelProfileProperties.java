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

public interface IfcStructuralSteelProfileProperties extends IfcStructuralProfileProperties {
	/**
	 * Returns the value of the '<em><b>Shear Area Z</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shear Area Z</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shear Area Z</em>' attribute.
	 * @see #isSetShearAreaZ()
	 * @see #unsetShearAreaZ()
	 * @see #setShearAreaZ(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcStructuralSteelProfileProperties_ShearAreaZ()
	 * @model unsettable="true"
	 * @generated
	 */
	double getShearAreaZ();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralSteelProfileProperties#getShearAreaZ <em>Shear Area Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shear Area Z</em>' attribute.
	 * @see #isSetShearAreaZ()
	 * @see #unsetShearAreaZ()
	 * @see #getShearAreaZ()
	 * @generated
	 */
	void setShearAreaZ(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralSteelProfileProperties#getShearAreaZ <em>Shear Area Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetShearAreaZ()
	 * @see #getShearAreaZ()
	 * @see #setShearAreaZ(double)
	 * @generated
	 */
	void unsetShearAreaZ();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralSteelProfileProperties#getShearAreaZ <em>Shear Area Z</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Shear Area Z</em>' attribute is set.
	 * @see #unsetShearAreaZ()
	 * @see #getShearAreaZ()
	 * @see #setShearAreaZ(double)
	 * @generated
	 */
	boolean isSetShearAreaZ();

	/**
	 * Returns the value of the '<em><b>Shear Area ZAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shear Area ZAs String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shear Area ZAs String</em>' attribute.
	 * @see #isSetShearAreaZAsString()
	 * @see #unsetShearAreaZAsString()
	 * @see #setShearAreaZAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcStructuralSteelProfileProperties_ShearAreaZAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getShearAreaZAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralSteelProfileProperties#getShearAreaZAsString <em>Shear Area ZAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shear Area ZAs String</em>' attribute.
	 * @see #isSetShearAreaZAsString()
	 * @see #unsetShearAreaZAsString()
	 * @see #getShearAreaZAsString()
	 * @generated
	 */
	void setShearAreaZAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralSteelProfileProperties#getShearAreaZAsString <em>Shear Area ZAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetShearAreaZAsString()
	 * @see #getShearAreaZAsString()
	 * @see #setShearAreaZAsString(String)
	 * @generated
	 */
	void unsetShearAreaZAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralSteelProfileProperties#getShearAreaZAsString <em>Shear Area ZAs String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Shear Area ZAs String</em>' attribute is set.
	 * @see #unsetShearAreaZAsString()
	 * @see #getShearAreaZAsString()
	 * @see #setShearAreaZAsString(String)
	 * @generated
	 */
	boolean isSetShearAreaZAsString();

	/**
	 * Returns the value of the '<em><b>Shear Area Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shear Area Y</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shear Area Y</em>' attribute.
	 * @see #isSetShearAreaY()
	 * @see #unsetShearAreaY()
	 * @see #setShearAreaY(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcStructuralSteelProfileProperties_ShearAreaY()
	 * @model unsettable="true"
	 * @generated
	 */
	double getShearAreaY();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralSteelProfileProperties#getShearAreaY <em>Shear Area Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shear Area Y</em>' attribute.
	 * @see #isSetShearAreaY()
	 * @see #unsetShearAreaY()
	 * @see #getShearAreaY()
	 * @generated
	 */
	void setShearAreaY(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralSteelProfileProperties#getShearAreaY <em>Shear Area Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetShearAreaY()
	 * @see #getShearAreaY()
	 * @see #setShearAreaY(double)
	 * @generated
	 */
	void unsetShearAreaY();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralSteelProfileProperties#getShearAreaY <em>Shear Area Y</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Shear Area Y</em>' attribute is set.
	 * @see #unsetShearAreaY()
	 * @see #getShearAreaY()
	 * @see #setShearAreaY(double)
	 * @generated
	 */
	boolean isSetShearAreaY();

	/**
	 * Returns the value of the '<em><b>Shear Area YAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shear Area YAs String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shear Area YAs String</em>' attribute.
	 * @see #isSetShearAreaYAsString()
	 * @see #unsetShearAreaYAsString()
	 * @see #setShearAreaYAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcStructuralSteelProfileProperties_ShearAreaYAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getShearAreaYAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralSteelProfileProperties#getShearAreaYAsString <em>Shear Area YAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shear Area YAs String</em>' attribute.
	 * @see #isSetShearAreaYAsString()
	 * @see #unsetShearAreaYAsString()
	 * @see #getShearAreaYAsString()
	 * @generated
	 */
	void setShearAreaYAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralSteelProfileProperties#getShearAreaYAsString <em>Shear Area YAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetShearAreaYAsString()
	 * @see #getShearAreaYAsString()
	 * @see #setShearAreaYAsString(String)
	 * @generated
	 */
	void unsetShearAreaYAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralSteelProfileProperties#getShearAreaYAsString <em>Shear Area YAs String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Shear Area YAs String</em>' attribute is set.
	 * @see #unsetShearAreaYAsString()
	 * @see #getShearAreaYAsString()
	 * @see #setShearAreaYAsString(String)
	 * @generated
	 */
	boolean isSetShearAreaYAsString();

	/**
	 * Returns the value of the '<em><b>Plastic Shape Factor Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Plastic Shape Factor Y</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Plastic Shape Factor Y</em>' attribute.
	 * @see #isSetPlasticShapeFactorY()
	 * @see #unsetPlasticShapeFactorY()
	 * @see #setPlasticShapeFactorY(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcStructuralSteelProfileProperties_PlasticShapeFactorY()
	 * @model unsettable="true"
	 * @generated
	 */
	double getPlasticShapeFactorY();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralSteelProfileProperties#getPlasticShapeFactorY <em>Plastic Shape Factor Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Plastic Shape Factor Y</em>' attribute.
	 * @see #isSetPlasticShapeFactorY()
	 * @see #unsetPlasticShapeFactorY()
	 * @see #getPlasticShapeFactorY()
	 * @generated
	 */
	void setPlasticShapeFactorY(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralSteelProfileProperties#getPlasticShapeFactorY <em>Plastic Shape Factor Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPlasticShapeFactorY()
	 * @see #getPlasticShapeFactorY()
	 * @see #setPlasticShapeFactorY(double)
	 * @generated
	 */
	void unsetPlasticShapeFactorY();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralSteelProfileProperties#getPlasticShapeFactorY <em>Plastic Shape Factor Y</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Plastic Shape Factor Y</em>' attribute is set.
	 * @see #unsetPlasticShapeFactorY()
	 * @see #getPlasticShapeFactorY()
	 * @see #setPlasticShapeFactorY(double)
	 * @generated
	 */
	boolean isSetPlasticShapeFactorY();

	/**
	 * Returns the value of the '<em><b>Plastic Shape Factor YAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Plastic Shape Factor YAs String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Plastic Shape Factor YAs String</em>' attribute.
	 * @see #isSetPlasticShapeFactorYAsString()
	 * @see #unsetPlasticShapeFactorYAsString()
	 * @see #setPlasticShapeFactorYAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcStructuralSteelProfileProperties_PlasticShapeFactorYAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getPlasticShapeFactorYAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralSteelProfileProperties#getPlasticShapeFactorYAsString <em>Plastic Shape Factor YAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Plastic Shape Factor YAs String</em>' attribute.
	 * @see #isSetPlasticShapeFactorYAsString()
	 * @see #unsetPlasticShapeFactorYAsString()
	 * @see #getPlasticShapeFactorYAsString()
	 * @generated
	 */
	void setPlasticShapeFactorYAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralSteelProfileProperties#getPlasticShapeFactorYAsString <em>Plastic Shape Factor YAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPlasticShapeFactorYAsString()
	 * @see #getPlasticShapeFactorYAsString()
	 * @see #setPlasticShapeFactorYAsString(String)
	 * @generated
	 */
	void unsetPlasticShapeFactorYAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralSteelProfileProperties#getPlasticShapeFactorYAsString <em>Plastic Shape Factor YAs String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Plastic Shape Factor YAs String</em>' attribute is set.
	 * @see #unsetPlasticShapeFactorYAsString()
	 * @see #getPlasticShapeFactorYAsString()
	 * @see #setPlasticShapeFactorYAsString(String)
	 * @generated
	 */
	boolean isSetPlasticShapeFactorYAsString();

	/**
	 * Returns the value of the '<em><b>Plastic Shape Factor Z</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Plastic Shape Factor Z</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Plastic Shape Factor Z</em>' attribute.
	 * @see #isSetPlasticShapeFactorZ()
	 * @see #unsetPlasticShapeFactorZ()
	 * @see #setPlasticShapeFactorZ(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcStructuralSteelProfileProperties_PlasticShapeFactorZ()
	 * @model unsettable="true"
	 * @generated
	 */
	double getPlasticShapeFactorZ();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralSteelProfileProperties#getPlasticShapeFactorZ <em>Plastic Shape Factor Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Plastic Shape Factor Z</em>' attribute.
	 * @see #isSetPlasticShapeFactorZ()
	 * @see #unsetPlasticShapeFactorZ()
	 * @see #getPlasticShapeFactorZ()
	 * @generated
	 */
	void setPlasticShapeFactorZ(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralSteelProfileProperties#getPlasticShapeFactorZ <em>Plastic Shape Factor Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPlasticShapeFactorZ()
	 * @see #getPlasticShapeFactorZ()
	 * @see #setPlasticShapeFactorZ(double)
	 * @generated
	 */
	void unsetPlasticShapeFactorZ();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralSteelProfileProperties#getPlasticShapeFactorZ <em>Plastic Shape Factor Z</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Plastic Shape Factor Z</em>' attribute is set.
	 * @see #unsetPlasticShapeFactorZ()
	 * @see #getPlasticShapeFactorZ()
	 * @see #setPlasticShapeFactorZ(double)
	 * @generated
	 */
	boolean isSetPlasticShapeFactorZ();

	/**
	 * Returns the value of the '<em><b>Plastic Shape Factor ZAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Plastic Shape Factor ZAs String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Plastic Shape Factor ZAs String</em>' attribute.
	 * @see #isSetPlasticShapeFactorZAsString()
	 * @see #unsetPlasticShapeFactorZAsString()
	 * @see #setPlasticShapeFactorZAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcStructuralSteelProfileProperties_PlasticShapeFactorZAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getPlasticShapeFactorZAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralSteelProfileProperties#getPlasticShapeFactorZAsString <em>Plastic Shape Factor ZAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Plastic Shape Factor ZAs String</em>' attribute.
	 * @see #isSetPlasticShapeFactorZAsString()
	 * @see #unsetPlasticShapeFactorZAsString()
	 * @see #getPlasticShapeFactorZAsString()
	 * @generated
	 */
	void setPlasticShapeFactorZAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralSteelProfileProperties#getPlasticShapeFactorZAsString <em>Plastic Shape Factor ZAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPlasticShapeFactorZAsString()
	 * @see #getPlasticShapeFactorZAsString()
	 * @see #setPlasticShapeFactorZAsString(String)
	 * @generated
	 */
	void unsetPlasticShapeFactorZAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralSteelProfileProperties#getPlasticShapeFactorZAsString <em>Plastic Shape Factor ZAs String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Plastic Shape Factor ZAs String</em>' attribute is set.
	 * @see #unsetPlasticShapeFactorZAsString()
	 * @see #getPlasticShapeFactorZAsString()
	 * @see #setPlasticShapeFactorZAsString(String)
	 * @generated
	 */
	boolean isSetPlasticShapeFactorZAsString();

} // IfcStructuralSteelProfileProperties

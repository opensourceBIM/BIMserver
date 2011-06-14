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
 * A representation of the model object '<em><b>Ifc Boundary Face Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBoundaryFaceCondition#getLinearStiffnessByAreaX <em>Linear Stiffness By Area X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBoundaryFaceCondition#getLinearStiffnessByAreaXAsString <em>Linear Stiffness By Area XAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBoundaryFaceCondition#getLinearStiffnessByAreaY <em>Linear Stiffness By Area Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBoundaryFaceCondition#getLinearStiffnessByAreaYAsString <em>Linear Stiffness By Area YAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBoundaryFaceCondition#getLinearStiffnessByAreaZ <em>Linear Stiffness By Area Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcBoundaryFaceCondition#getLinearStiffnessByAreaZAsString <em>Linear Stiffness By Area ZAs String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBoundaryFaceCondition()
 * @model
 * @generated
 */
public interface IfcBoundaryFaceCondition extends IfcBoundaryCondition
{
	/**
	 * Returns the value of the '<em><b>Linear Stiffness By Area X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Linear Stiffness By Area X</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Linear Stiffness By Area X</em>' attribute.
	 * @see #isSetLinearStiffnessByAreaX()
	 * @see #unsetLinearStiffnessByAreaX()
	 * @see #setLinearStiffnessByAreaX(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBoundaryFaceCondition_LinearStiffnessByAreaX()
	 * @model unsettable="true"
	 * @generated
	 */
	float getLinearStiffnessByAreaX();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryFaceCondition#getLinearStiffnessByAreaX <em>Linear Stiffness By Area X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Linear Stiffness By Area X</em>' attribute.
	 * @see #isSetLinearStiffnessByAreaX()
	 * @see #unsetLinearStiffnessByAreaX()
	 * @see #getLinearStiffnessByAreaX()
	 * @generated
	 */
	void setLinearStiffnessByAreaX(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryFaceCondition#getLinearStiffnessByAreaX <em>Linear Stiffness By Area X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLinearStiffnessByAreaX()
	 * @see #getLinearStiffnessByAreaX()
	 * @see #setLinearStiffnessByAreaX(float)
	 * @generated
	 */
	void unsetLinearStiffnessByAreaX();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryFaceCondition#getLinearStiffnessByAreaX <em>Linear Stiffness By Area X</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Linear Stiffness By Area X</em>' attribute is set.
	 * @see #unsetLinearStiffnessByAreaX()
	 * @see #getLinearStiffnessByAreaX()
	 * @see #setLinearStiffnessByAreaX(float)
	 * @generated
	 */
	boolean isSetLinearStiffnessByAreaX();

	/**
	 * Returns the value of the '<em><b>Linear Stiffness By Area XAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Linear Stiffness By Area XAs String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Linear Stiffness By Area XAs String</em>' attribute.
	 * @see #isSetLinearStiffnessByAreaXAsString()
	 * @see #unsetLinearStiffnessByAreaXAsString()
	 * @see #setLinearStiffnessByAreaXAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBoundaryFaceCondition_LinearStiffnessByAreaXAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getLinearStiffnessByAreaXAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryFaceCondition#getLinearStiffnessByAreaXAsString <em>Linear Stiffness By Area XAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Linear Stiffness By Area XAs String</em>' attribute.
	 * @see #isSetLinearStiffnessByAreaXAsString()
	 * @see #unsetLinearStiffnessByAreaXAsString()
	 * @see #getLinearStiffnessByAreaXAsString()
	 * @generated
	 */
	void setLinearStiffnessByAreaXAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryFaceCondition#getLinearStiffnessByAreaXAsString <em>Linear Stiffness By Area XAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLinearStiffnessByAreaXAsString()
	 * @see #getLinearStiffnessByAreaXAsString()
	 * @see #setLinearStiffnessByAreaXAsString(String)
	 * @generated
	 */
	void unsetLinearStiffnessByAreaXAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryFaceCondition#getLinearStiffnessByAreaXAsString <em>Linear Stiffness By Area XAs String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Linear Stiffness By Area XAs String</em>' attribute is set.
	 * @see #unsetLinearStiffnessByAreaXAsString()
	 * @see #getLinearStiffnessByAreaXAsString()
	 * @see #setLinearStiffnessByAreaXAsString(String)
	 * @generated
	 */
	boolean isSetLinearStiffnessByAreaXAsString();

	/**
	 * Returns the value of the '<em><b>Linear Stiffness By Area Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Linear Stiffness By Area Y</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Linear Stiffness By Area Y</em>' attribute.
	 * @see #isSetLinearStiffnessByAreaY()
	 * @see #unsetLinearStiffnessByAreaY()
	 * @see #setLinearStiffnessByAreaY(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBoundaryFaceCondition_LinearStiffnessByAreaY()
	 * @model unsettable="true"
	 * @generated
	 */
	float getLinearStiffnessByAreaY();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryFaceCondition#getLinearStiffnessByAreaY <em>Linear Stiffness By Area Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Linear Stiffness By Area Y</em>' attribute.
	 * @see #isSetLinearStiffnessByAreaY()
	 * @see #unsetLinearStiffnessByAreaY()
	 * @see #getLinearStiffnessByAreaY()
	 * @generated
	 */
	void setLinearStiffnessByAreaY(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryFaceCondition#getLinearStiffnessByAreaY <em>Linear Stiffness By Area Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLinearStiffnessByAreaY()
	 * @see #getLinearStiffnessByAreaY()
	 * @see #setLinearStiffnessByAreaY(float)
	 * @generated
	 */
	void unsetLinearStiffnessByAreaY();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryFaceCondition#getLinearStiffnessByAreaY <em>Linear Stiffness By Area Y</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Linear Stiffness By Area Y</em>' attribute is set.
	 * @see #unsetLinearStiffnessByAreaY()
	 * @see #getLinearStiffnessByAreaY()
	 * @see #setLinearStiffnessByAreaY(float)
	 * @generated
	 */
	boolean isSetLinearStiffnessByAreaY();

	/**
	 * Returns the value of the '<em><b>Linear Stiffness By Area YAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Linear Stiffness By Area YAs String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Linear Stiffness By Area YAs String</em>' attribute.
	 * @see #isSetLinearStiffnessByAreaYAsString()
	 * @see #unsetLinearStiffnessByAreaYAsString()
	 * @see #setLinearStiffnessByAreaYAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBoundaryFaceCondition_LinearStiffnessByAreaYAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getLinearStiffnessByAreaYAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryFaceCondition#getLinearStiffnessByAreaYAsString <em>Linear Stiffness By Area YAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Linear Stiffness By Area YAs String</em>' attribute.
	 * @see #isSetLinearStiffnessByAreaYAsString()
	 * @see #unsetLinearStiffnessByAreaYAsString()
	 * @see #getLinearStiffnessByAreaYAsString()
	 * @generated
	 */
	void setLinearStiffnessByAreaYAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryFaceCondition#getLinearStiffnessByAreaYAsString <em>Linear Stiffness By Area YAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLinearStiffnessByAreaYAsString()
	 * @see #getLinearStiffnessByAreaYAsString()
	 * @see #setLinearStiffnessByAreaYAsString(String)
	 * @generated
	 */
	void unsetLinearStiffnessByAreaYAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryFaceCondition#getLinearStiffnessByAreaYAsString <em>Linear Stiffness By Area YAs String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Linear Stiffness By Area YAs String</em>' attribute is set.
	 * @see #unsetLinearStiffnessByAreaYAsString()
	 * @see #getLinearStiffnessByAreaYAsString()
	 * @see #setLinearStiffnessByAreaYAsString(String)
	 * @generated
	 */
	boolean isSetLinearStiffnessByAreaYAsString();

	/**
	 * Returns the value of the '<em><b>Linear Stiffness By Area Z</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Linear Stiffness By Area Z</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Linear Stiffness By Area Z</em>' attribute.
	 * @see #isSetLinearStiffnessByAreaZ()
	 * @see #unsetLinearStiffnessByAreaZ()
	 * @see #setLinearStiffnessByAreaZ(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBoundaryFaceCondition_LinearStiffnessByAreaZ()
	 * @model unsettable="true"
	 * @generated
	 */
	float getLinearStiffnessByAreaZ();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryFaceCondition#getLinearStiffnessByAreaZ <em>Linear Stiffness By Area Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Linear Stiffness By Area Z</em>' attribute.
	 * @see #isSetLinearStiffnessByAreaZ()
	 * @see #unsetLinearStiffnessByAreaZ()
	 * @see #getLinearStiffnessByAreaZ()
	 * @generated
	 */
	void setLinearStiffnessByAreaZ(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryFaceCondition#getLinearStiffnessByAreaZ <em>Linear Stiffness By Area Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLinearStiffnessByAreaZ()
	 * @see #getLinearStiffnessByAreaZ()
	 * @see #setLinearStiffnessByAreaZ(float)
	 * @generated
	 */
	void unsetLinearStiffnessByAreaZ();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryFaceCondition#getLinearStiffnessByAreaZ <em>Linear Stiffness By Area Z</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Linear Stiffness By Area Z</em>' attribute is set.
	 * @see #unsetLinearStiffnessByAreaZ()
	 * @see #getLinearStiffnessByAreaZ()
	 * @see #setLinearStiffnessByAreaZ(float)
	 * @generated
	 */
	boolean isSetLinearStiffnessByAreaZ();

	/**
	 * Returns the value of the '<em><b>Linear Stiffness By Area ZAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Linear Stiffness By Area ZAs String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Linear Stiffness By Area ZAs String</em>' attribute.
	 * @see #isSetLinearStiffnessByAreaZAsString()
	 * @see #unsetLinearStiffnessByAreaZAsString()
	 * @see #setLinearStiffnessByAreaZAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcBoundaryFaceCondition_LinearStiffnessByAreaZAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getLinearStiffnessByAreaZAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryFaceCondition#getLinearStiffnessByAreaZAsString <em>Linear Stiffness By Area ZAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Linear Stiffness By Area ZAs String</em>' attribute.
	 * @see #isSetLinearStiffnessByAreaZAsString()
	 * @see #unsetLinearStiffnessByAreaZAsString()
	 * @see #getLinearStiffnessByAreaZAsString()
	 * @generated
	 */
	void setLinearStiffnessByAreaZAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryFaceCondition#getLinearStiffnessByAreaZAsString <em>Linear Stiffness By Area ZAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLinearStiffnessByAreaZAsString()
	 * @see #getLinearStiffnessByAreaZAsString()
	 * @see #setLinearStiffnessByAreaZAsString(String)
	 * @generated
	 */
	void unsetLinearStiffnessByAreaZAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcBoundaryFaceCondition#getLinearStiffnessByAreaZAsString <em>Linear Stiffness By Area ZAs String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Linear Stiffness By Area ZAs String</em>' attribute is set.
	 * @see #unsetLinearStiffnessByAreaZAsString()
	 * @see #getLinearStiffnessByAreaZAsString()
	 * @see #setLinearStiffnessByAreaZAsString(String)
	 * @generated
	 */
	boolean isSetLinearStiffnessByAreaZAsString();

} // IfcBoundaryFaceCondition

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
 * A representation of the model object '<em><b>Ifc Structural Load Planar Force</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStructuralLoadPlanarForce#getPlanarForceX <em>Planar Force X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStructuralLoadPlanarForce#getPlanarForceXAsString <em>Planar Force XAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStructuralLoadPlanarForce#getPlanarForceY <em>Planar Force Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStructuralLoadPlanarForce#getPlanarForceYAsString <em>Planar Force YAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStructuralLoadPlanarForce#getPlanarForceZ <em>Planar Force Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStructuralLoadPlanarForce#getPlanarForceZAsString <em>Planar Force ZAs String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralLoadPlanarForce()
 * @model
 * @generated
 */
public interface IfcStructuralLoadPlanarForce extends IfcStructuralLoadStatic
{
	/**
	 * Returns the value of the '<em><b>Planar Force X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Planar Force X</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Planar Force X</em>' attribute.
	 * @see #isSetPlanarForceX()
	 * @see #unsetPlanarForceX()
	 * @see #setPlanarForceX(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralLoadPlanarForce_PlanarForceX()
	 * @model unsettable="true"
	 * @generated
	 */
	float getPlanarForceX();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadPlanarForce#getPlanarForceX <em>Planar Force X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Planar Force X</em>' attribute.
	 * @see #isSetPlanarForceX()
	 * @see #unsetPlanarForceX()
	 * @see #getPlanarForceX()
	 * @generated
	 */
	void setPlanarForceX(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadPlanarForce#getPlanarForceX <em>Planar Force X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPlanarForceX()
	 * @see #getPlanarForceX()
	 * @see #setPlanarForceX(float)
	 * @generated
	 */
	void unsetPlanarForceX();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadPlanarForce#getPlanarForceX <em>Planar Force X</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Planar Force X</em>' attribute is set.
	 * @see #unsetPlanarForceX()
	 * @see #getPlanarForceX()
	 * @see #setPlanarForceX(float)
	 * @generated
	 */
	boolean isSetPlanarForceX();

	/**
	 * Returns the value of the '<em><b>Planar Force XAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Planar Force XAs String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Planar Force XAs String</em>' attribute.
	 * @see #isSetPlanarForceXAsString()
	 * @see #unsetPlanarForceXAsString()
	 * @see #setPlanarForceXAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralLoadPlanarForce_PlanarForceXAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getPlanarForceXAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadPlanarForce#getPlanarForceXAsString <em>Planar Force XAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Planar Force XAs String</em>' attribute.
	 * @see #isSetPlanarForceXAsString()
	 * @see #unsetPlanarForceXAsString()
	 * @see #getPlanarForceXAsString()
	 * @generated
	 */
	void setPlanarForceXAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadPlanarForce#getPlanarForceXAsString <em>Planar Force XAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPlanarForceXAsString()
	 * @see #getPlanarForceXAsString()
	 * @see #setPlanarForceXAsString(String)
	 * @generated
	 */
	void unsetPlanarForceXAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadPlanarForce#getPlanarForceXAsString <em>Planar Force XAs String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Planar Force XAs String</em>' attribute is set.
	 * @see #unsetPlanarForceXAsString()
	 * @see #getPlanarForceXAsString()
	 * @see #setPlanarForceXAsString(String)
	 * @generated
	 */
	boolean isSetPlanarForceXAsString();

	/**
	 * Returns the value of the '<em><b>Planar Force Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Planar Force Y</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Planar Force Y</em>' attribute.
	 * @see #isSetPlanarForceY()
	 * @see #unsetPlanarForceY()
	 * @see #setPlanarForceY(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralLoadPlanarForce_PlanarForceY()
	 * @model unsettable="true"
	 * @generated
	 */
	float getPlanarForceY();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadPlanarForce#getPlanarForceY <em>Planar Force Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Planar Force Y</em>' attribute.
	 * @see #isSetPlanarForceY()
	 * @see #unsetPlanarForceY()
	 * @see #getPlanarForceY()
	 * @generated
	 */
	void setPlanarForceY(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadPlanarForce#getPlanarForceY <em>Planar Force Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPlanarForceY()
	 * @see #getPlanarForceY()
	 * @see #setPlanarForceY(float)
	 * @generated
	 */
	void unsetPlanarForceY();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadPlanarForce#getPlanarForceY <em>Planar Force Y</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Planar Force Y</em>' attribute is set.
	 * @see #unsetPlanarForceY()
	 * @see #getPlanarForceY()
	 * @see #setPlanarForceY(float)
	 * @generated
	 */
	boolean isSetPlanarForceY();

	/**
	 * Returns the value of the '<em><b>Planar Force YAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Planar Force YAs String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Planar Force YAs String</em>' attribute.
	 * @see #isSetPlanarForceYAsString()
	 * @see #unsetPlanarForceYAsString()
	 * @see #setPlanarForceYAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralLoadPlanarForce_PlanarForceYAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getPlanarForceYAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadPlanarForce#getPlanarForceYAsString <em>Planar Force YAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Planar Force YAs String</em>' attribute.
	 * @see #isSetPlanarForceYAsString()
	 * @see #unsetPlanarForceYAsString()
	 * @see #getPlanarForceYAsString()
	 * @generated
	 */
	void setPlanarForceYAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadPlanarForce#getPlanarForceYAsString <em>Planar Force YAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPlanarForceYAsString()
	 * @see #getPlanarForceYAsString()
	 * @see #setPlanarForceYAsString(String)
	 * @generated
	 */
	void unsetPlanarForceYAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadPlanarForce#getPlanarForceYAsString <em>Planar Force YAs String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Planar Force YAs String</em>' attribute is set.
	 * @see #unsetPlanarForceYAsString()
	 * @see #getPlanarForceYAsString()
	 * @see #setPlanarForceYAsString(String)
	 * @generated
	 */
	boolean isSetPlanarForceYAsString();

	/**
	 * Returns the value of the '<em><b>Planar Force Z</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Planar Force Z</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Planar Force Z</em>' attribute.
	 * @see #isSetPlanarForceZ()
	 * @see #unsetPlanarForceZ()
	 * @see #setPlanarForceZ(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralLoadPlanarForce_PlanarForceZ()
	 * @model unsettable="true"
	 * @generated
	 */
	float getPlanarForceZ();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadPlanarForce#getPlanarForceZ <em>Planar Force Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Planar Force Z</em>' attribute.
	 * @see #isSetPlanarForceZ()
	 * @see #unsetPlanarForceZ()
	 * @see #getPlanarForceZ()
	 * @generated
	 */
	void setPlanarForceZ(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadPlanarForce#getPlanarForceZ <em>Planar Force Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPlanarForceZ()
	 * @see #getPlanarForceZ()
	 * @see #setPlanarForceZ(float)
	 * @generated
	 */
	void unsetPlanarForceZ();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadPlanarForce#getPlanarForceZ <em>Planar Force Z</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Planar Force Z</em>' attribute is set.
	 * @see #unsetPlanarForceZ()
	 * @see #getPlanarForceZ()
	 * @see #setPlanarForceZ(float)
	 * @generated
	 */
	boolean isSetPlanarForceZ();

	/**
	 * Returns the value of the '<em><b>Planar Force ZAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Planar Force ZAs String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Planar Force ZAs String</em>' attribute.
	 * @see #isSetPlanarForceZAsString()
	 * @see #unsetPlanarForceZAsString()
	 * @see #setPlanarForceZAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralLoadPlanarForce_PlanarForceZAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getPlanarForceZAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadPlanarForce#getPlanarForceZAsString <em>Planar Force ZAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Planar Force ZAs String</em>' attribute.
	 * @see #isSetPlanarForceZAsString()
	 * @see #unsetPlanarForceZAsString()
	 * @see #getPlanarForceZAsString()
	 * @generated
	 */
	void setPlanarForceZAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadPlanarForce#getPlanarForceZAsString <em>Planar Force ZAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPlanarForceZAsString()
	 * @see #getPlanarForceZAsString()
	 * @see #setPlanarForceZAsString(String)
	 * @generated
	 */
	void unsetPlanarForceZAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadPlanarForce#getPlanarForceZAsString <em>Planar Force ZAs String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Planar Force ZAs String</em>' attribute is set.
	 * @see #unsetPlanarForceZAsString()
	 * @see #getPlanarForceZAsString()
	 * @see #setPlanarForceZAsString(String)
	 * @generated
	 */
	boolean isSetPlanarForceZAsString();

} // IfcStructuralLoadPlanarForce

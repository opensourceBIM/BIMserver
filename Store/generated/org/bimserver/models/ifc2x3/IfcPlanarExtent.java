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
 * A representation of the model object '<em><b>Ifc Planar Extent</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcPlanarExtent#getSizeInX <em>Size In X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcPlanarExtent#getSizeInXAsString <em>Size In XAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcPlanarExtent#getSizeInY <em>Size In Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcPlanarExtent#getSizeInYAsString <em>Size In YAs String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPlanarExtent()
 * @model
 * @generated
 */
public interface IfcPlanarExtent extends IfcGeometricRepresentationItem
{
	/**
	 * Returns the value of the '<em><b>Size In X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size In X</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size In X</em>' attribute.
	 * @see #setSizeInX(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPlanarExtent_SizeInX()
	 * @model
	 * @generated
	 */
	float getSizeInX();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcPlanarExtent#getSizeInX <em>Size In X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size In X</em>' attribute.
	 * @see #getSizeInX()
	 * @generated
	 */
	void setSizeInX(float value);

	/**
	 * Returns the value of the '<em><b>Size In XAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size In XAs String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size In XAs String</em>' attribute.
	 * @see #setSizeInXAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPlanarExtent_SizeInXAsString()
	 * @model
	 * @generated
	 */
	String getSizeInXAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcPlanarExtent#getSizeInXAsString <em>Size In XAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size In XAs String</em>' attribute.
	 * @see #getSizeInXAsString()
	 * @generated
	 */
	void setSizeInXAsString(String value);

	/**
	 * Returns the value of the '<em><b>Size In Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size In Y</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size In Y</em>' attribute.
	 * @see #setSizeInY(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPlanarExtent_SizeInY()
	 * @model
	 * @generated
	 */
	float getSizeInY();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcPlanarExtent#getSizeInY <em>Size In Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size In Y</em>' attribute.
	 * @see #getSizeInY()
	 * @generated
	 */
	void setSizeInY(float value);

	/**
	 * Returns the value of the '<em><b>Size In YAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size In YAs String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size In YAs String</em>' attribute.
	 * @see #setSizeInYAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcPlanarExtent_SizeInYAsString()
	 * @model
	 * @generated
	 */
	String getSizeInYAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcPlanarExtent#getSizeInYAsString <em>Size In YAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size In YAs String</em>' attribute.
	 * @see #getSizeInYAsString()
	 * @generated
	 */
	void setSizeInYAsString(String value);

} // IfcPlanarExtent

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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Composite Profile Def</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCompositeProfileDef#getProfiles <em>Profiles</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCompositeProfileDef#getLabel <em>Label</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCompositeProfileDef()
 * @model
 * @generated
 */
public interface IfcCompositeProfileDef extends IfcProfileDef
{
	/**
	 * Returns the value of the '<em><b>Profiles</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcProfileDef}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Profiles</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Profiles</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCompositeProfileDef_Profiles()
	 * @model
	 * @generated
	 */
	EList<IfcProfileDef> getProfiles();

	/**
	 * Returns the value of the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' attribute.
	 * @see #isSetLabel()
	 * @see #unsetLabel()
	 * @see #setLabel(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCompositeProfileDef_Label()
	 * @model unsettable="true"
	 * @generated
	 */
	String getLabel();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCompositeProfileDef#getLabel <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @see #isSetLabel()
	 * @see #unsetLabel()
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcCompositeProfileDef#getLabel <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLabel()
	 * @see #getLabel()
	 * @see #setLabel(String)
	 * @generated
	 */
	void unsetLabel();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcCompositeProfileDef#getLabel <em>Label</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Label</em>' attribute is set.
	 * @see #unsetLabel()
	 * @see #getLabel()
	 * @see #setLabel(String)
	 * @generated
	 */
	boolean isSetLabel();

} // IfcCompositeProfileDef

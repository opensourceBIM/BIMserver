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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Rel Defines By Template</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcRelDefinesByTemplate#getRelatedPropertySets <em>Related Property Sets</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcRelDefinesByTemplate#getRelatingTemplate <em>Relating Template</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcRelDefinesByTemplate()
 * @model
 * @generated
 */
public interface IfcRelDefinesByTemplate extends IfcRelDefines {
	/**
	 * Returns the value of the '<em><b>Related Property Sets</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4x3.IfcPropertySetDefinition}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4x3.IfcPropertySetDefinition#getIsDefinedBy <em>Is Defined By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related Property Sets</em>' reference list.
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcRelDefinesByTemplate_RelatedPropertySets()
	 * @see org.bimserver.models.ifc4x3.IfcPropertySetDefinition#getIsDefinedBy
	 * @model opposite="IsDefinedBy"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcPropertySetDefinition> getRelatedPropertySets();

	/**
	 * Returns the value of the '<em><b>Relating Template</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4x3.IfcPropertySetTemplate#getDefines <em>Defines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relating Template</em>' reference.
	 * @see #setRelatingTemplate(IfcPropertySetTemplate)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcRelDefinesByTemplate_RelatingTemplate()
	 * @see org.bimserver.models.ifc4x3.IfcPropertySetTemplate#getDefines
	 * @model opposite="Defines"
	 *        annotation="inverse"
	 * @generated
	 */
	IfcPropertySetTemplate getRelatingTemplate();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcRelDefinesByTemplate#getRelatingTemplate <em>Relating Template</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relating Template</em>' reference.
	 * @see #getRelatingTemplate()
	 * @generated
	 */
	void setRelatingTemplate(IfcPropertySetTemplate value);

} // IfcRelDefinesByTemplate

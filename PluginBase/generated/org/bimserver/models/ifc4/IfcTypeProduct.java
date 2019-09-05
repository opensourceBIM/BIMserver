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
 * A representation of the model object '<em><b>Ifc Type Product</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcTypeProduct#getRepresentationMaps <em>Representation Maps</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcTypeProduct#getTag <em>Tag</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcTypeProduct#getReferencedBy <em>Referenced By</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTypeProduct()
 * @model
 * @generated
 */
public interface IfcTypeProduct extends IfcTypeObject, IfcProductSelect {
	/**
	 * Returns the value of the '<em><b>Representation Maps</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcRepresentationMap}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Representation Maps</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Representation Maps</em>' reference list.
	 * @see #isSetRepresentationMaps()
	 * @see #unsetRepresentationMaps()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTypeProduct_RepresentationMaps()
	 * @model unsettable="true"
	 * @generated
	 */
	EList<IfcRepresentationMap> getRepresentationMaps();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcTypeProduct#getRepresentationMaps <em>Representation Maps</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRepresentationMaps()
	 * @see #getRepresentationMaps()
	 * @generated
	 */
	void unsetRepresentationMaps();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcTypeProduct#getRepresentationMaps <em>Representation Maps</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Representation Maps</em>' reference list is set.
	 * @see #unsetRepresentationMaps()
	 * @see #getRepresentationMaps()
	 * @generated
	 */
	boolean isSetRepresentationMaps();

	/**
	 * Returns the value of the '<em><b>Tag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tag</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tag</em>' attribute.
	 * @see #isSetTag()
	 * @see #unsetTag()
	 * @see #setTag(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTypeProduct_Tag()
	 * @model unsettable="true"
	 * @generated
	 */
	String getTag();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTypeProduct#getTag <em>Tag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tag</em>' attribute.
	 * @see #isSetTag()
	 * @see #unsetTag()
	 * @see #getTag()
	 * @generated
	 */
	void setTag(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcTypeProduct#getTag <em>Tag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTag()
	 * @see #getTag()
	 * @see #setTag(String)
	 * @generated
	 */
	void unsetTag();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcTypeProduct#getTag <em>Tag</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Tag</em>' attribute is set.
	 * @see #unsetTag()
	 * @see #getTag()
	 * @see #setTag(String)
	 * @generated
	 */
	boolean isSetTag();

	/**
	 * Returns the value of the '<em><b>Referenced By</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcRelAssignsToProduct}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referenced By</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced By</em>' reference list.
	 * @see #isSetReferencedBy()
	 * @see #unsetReferencedBy()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTypeProduct_ReferencedBy()
	 * @model unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcRelAssignsToProduct> getReferencedBy();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcTypeProduct#getReferencedBy <em>Referenced By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetReferencedBy()
	 * @see #getReferencedBy()
	 * @generated
	 */
	void unsetReferencedBy();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcTypeProduct#getReferencedBy <em>Referenced By</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Referenced By</em>' reference list is set.
	 * @see #unsetReferencedBy()
	 * @see #getReferencedBy()
	 * @generated
	 */
	boolean isSetReferencedBy();

} // IfcTypeProduct

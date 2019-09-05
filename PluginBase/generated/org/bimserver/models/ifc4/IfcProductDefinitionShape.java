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
 * A representation of the model object '<em><b>Ifc Product Definition Shape</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcProductDefinitionShape#getShapeOfProduct <em>Shape Of Product</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcProductDefinitionShape#getHasShapeAspects <em>Has Shape Aspects</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcProductDefinitionShape()
 * @model
 * @generated
 */
public interface IfcProductDefinitionShape extends IfcProductRepresentation, IfcProductRepresentationSelect {
	/**
	 * Returns the value of the '<em><b>Shape Of Product</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcProduct}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shape Of Product</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shape Of Product</em>' reference list.
	 * @see #isSetShapeOfProduct()
	 * @see #unsetShapeOfProduct()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcProductDefinitionShape_ShapeOfProduct()
	 * @model unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcProduct> getShapeOfProduct();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcProductDefinitionShape#getShapeOfProduct <em>Shape Of Product</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetShapeOfProduct()
	 * @see #getShapeOfProduct()
	 * @generated
	 */
	void unsetShapeOfProduct();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcProductDefinitionShape#getShapeOfProduct <em>Shape Of Product</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Shape Of Product</em>' reference list is set.
	 * @see #unsetShapeOfProduct()
	 * @see #getShapeOfProduct()
	 * @generated
	 */
	boolean isSetShapeOfProduct();

	/**
	 * Returns the value of the '<em><b>Has Shape Aspects</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcShapeAspect}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Shape Aspects</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Shape Aspects</em>' reference list.
	 * @see #isSetHasShapeAspects()
	 * @see #unsetHasShapeAspects()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcProductDefinitionShape_HasShapeAspects()
	 * @model unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcShapeAspect> getHasShapeAspects();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcProductDefinitionShape#getHasShapeAspects <em>Has Shape Aspects</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetHasShapeAspects()
	 * @see #getHasShapeAspects()
	 * @generated
	 */
	void unsetHasShapeAspects();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcProductDefinitionShape#getHasShapeAspects <em>Has Shape Aspects</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Has Shape Aspects</em>' reference list is set.
	 * @see #unsetHasShapeAspects()
	 * @see #getHasShapeAspects()
	 * @generated
	 */
	boolean isSetHasShapeAspects();

} // IfcProductDefinitionShape

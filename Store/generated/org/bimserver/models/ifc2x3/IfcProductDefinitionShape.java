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
 * A representation of the model object '<em><b>Ifc Product Definition Shape</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcProductDefinitionShape#getShapeOfProduct <em>Shape Of Product</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcProductDefinitionShape#getHasShapeAspects <em>Has Shape Aspects</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcProductDefinitionShape()
 * @model
 * @generated
 */
public interface IfcProductDefinitionShape extends IfcProductRepresentation
{
	/**
	 * Returns the value of the '<em><b>Shape Of Product</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcProduct}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shape Of Product</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shape Of Product</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcProductDefinitionShape_ShapeOfProduct()
	 * @model upper="2"
	 * @generated
	 */
	EList<IfcProduct> getShapeOfProduct();

	/**
	 * Returns the value of the '<em><b>Has Shape Aspects</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcShapeAspect}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcShapeAspect#getPartOfProductDefinitionShape <em>Part Of Product Definition Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Shape Aspects</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Shape Aspects</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcProductDefinitionShape_HasShapeAspects()
	 * @see org.bimserver.models.ifc2x3.IfcShapeAspect#getPartOfProductDefinitionShape
	 * @model opposite="PartOfProductDefinitionShape"
	 * @generated
	 */
	EList<IfcShapeAspect> getHasShapeAspects();

} // IfcProductDefinitionShape

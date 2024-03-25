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

import org.bimserver.models.geometry.GeometryInfo;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Product</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcProduct#getObjectPlacement <em>Object Placement</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcProduct#getRepresentation <em>Representation</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcProduct#getReferencedBy <em>Referenced By</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcProduct#getPositionedRelativeTo <em>Positioned Relative To</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcProduct#getReferencedInStructures <em>Referenced In Structures</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcProduct#getGeometry <em>Geometry</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcProduct()
 * @model
 * @generated
 */
public interface IfcProduct extends IfcObject, IfcProductSelect, IfcSpatialReferenceSelect {
	/**
	 * Returns the value of the '<em><b>Object Placement</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4x3.IfcObjectPlacement#getPlacesObject <em>Places Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object Placement</em>' reference.
	 * @see #isSetObjectPlacement()
	 * @see #unsetObjectPlacement()
	 * @see #setObjectPlacement(IfcObjectPlacement)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcProduct_ObjectPlacement()
	 * @see org.bimserver.models.ifc4x3.IfcObjectPlacement#getPlacesObject
	 * @model opposite="PlacesObject" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	IfcObjectPlacement getObjectPlacement();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcProduct#getObjectPlacement <em>Object Placement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object Placement</em>' reference.
	 * @see #isSetObjectPlacement()
	 * @see #unsetObjectPlacement()
	 * @see #getObjectPlacement()
	 * @generated
	 */
	void setObjectPlacement(IfcObjectPlacement value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcProduct#getObjectPlacement <em>Object Placement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetObjectPlacement()
	 * @see #getObjectPlacement()
	 * @see #setObjectPlacement(IfcObjectPlacement)
	 * @generated
	 */
	void unsetObjectPlacement();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcProduct#getObjectPlacement <em>Object Placement</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Object Placement</em>' reference is set.
	 * @see #unsetObjectPlacement()
	 * @see #getObjectPlacement()
	 * @see #setObjectPlacement(IfcObjectPlacement)
	 * @generated
	 */
	boolean isSetObjectPlacement();

	/**
	 * Returns the value of the '<em><b>Representation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Representation</em>' reference.
	 * @see #isSetRepresentation()
	 * @see #unsetRepresentation()
	 * @see #setRepresentation(IfcProductRepresentation)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcProduct_Representation()
	 * @model unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	IfcProductRepresentation getRepresentation();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcProduct#getRepresentation <em>Representation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Representation</em>' reference.
	 * @see #isSetRepresentation()
	 * @see #unsetRepresentation()
	 * @see #getRepresentation()
	 * @generated
	 */
	void setRepresentation(IfcProductRepresentation value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcProduct#getRepresentation <em>Representation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRepresentation()
	 * @see #getRepresentation()
	 * @see #setRepresentation(IfcProductRepresentation)
	 * @generated
	 */
	void unsetRepresentation();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcProduct#getRepresentation <em>Representation</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Representation</em>' reference is set.
	 * @see #unsetRepresentation()
	 * @see #getRepresentation()
	 * @see #setRepresentation(IfcProductRepresentation)
	 * @generated
	 */
	boolean isSetRepresentation();

	/**
	 * Returns the value of the '<em><b>Referenced By</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4x3.IfcRelAssignsToProduct}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced By</em>' reference list.
	 * @see #isSetReferencedBy()
	 * @see #unsetReferencedBy()
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcProduct_ReferencedBy()
	 * @model unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcRelAssignsToProduct> getReferencedBy();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcProduct#getReferencedBy <em>Referenced By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetReferencedBy()
	 * @see #getReferencedBy()
	 * @generated
	 */
	void unsetReferencedBy();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcProduct#getReferencedBy <em>Referenced By</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Referenced By</em>' reference list is set.
	 * @see #unsetReferencedBy()
	 * @see #getReferencedBy()
	 * @generated
	 */
	boolean isSetReferencedBy();

	/**
	 * Returns the value of the '<em><b>Positioned Relative To</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4x3.IfcRelPositions}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4x3.IfcRelPositions#getRelatedProducts <em>Related Products</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Positioned Relative To</em>' reference list.
	 * @see #isSetPositionedRelativeTo()
	 * @see #unsetPositionedRelativeTo()
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcProduct_PositionedRelativeTo()
	 * @see org.bimserver.models.ifc4x3.IfcRelPositions#getRelatedProducts
	 * @model opposite="RelatedProducts" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcRelPositions> getPositionedRelativeTo();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcProduct#getPositionedRelativeTo <em>Positioned Relative To</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPositionedRelativeTo()
	 * @see #getPositionedRelativeTo()
	 * @generated
	 */
	void unsetPositionedRelativeTo();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcProduct#getPositionedRelativeTo <em>Positioned Relative To</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Positioned Relative To</em>' reference list is set.
	 * @see #unsetPositionedRelativeTo()
	 * @see #getPositionedRelativeTo()
	 * @generated
	 */
	boolean isSetPositionedRelativeTo();

	/**
	 * Returns the value of the '<em><b>Referenced In Structures</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4x3.IfcRelReferencedInSpatialStructure}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced In Structures</em>' reference list.
	 * @see #isSetReferencedInStructures()
	 * @see #unsetReferencedInStructures()
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcProduct_ReferencedInStructures()
	 * @model unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcRelReferencedInSpatialStructure> getReferencedInStructures();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcProduct#getReferencedInStructures <em>Referenced In Structures</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetReferencedInStructures()
	 * @see #getReferencedInStructures()
	 * @generated
	 */
	void unsetReferencedInStructures();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcProduct#getReferencedInStructures <em>Referenced In Structures</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Referenced In Structures</em>' reference list is set.
	 * @see #unsetReferencedInStructures()
	 * @see #getReferencedInStructures()
	 * @generated
	 */
	boolean isSetReferencedInStructures();

	/**
	 * Returns the value of the '<em><b>Geometry</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Geometry</em>' reference.
	 * @see #isSetGeometry()
	 * @see #unsetGeometry()
	 * @see #setGeometry(GeometryInfo)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcProduct_Geometry()
	 * @model unsettable="true"
	 * @generated
	 */
	GeometryInfo getGeometry();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcProduct#getGeometry <em>Geometry</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Geometry</em>' reference.
	 * @see #isSetGeometry()
	 * @see #unsetGeometry()
	 * @see #getGeometry()
	 * @generated
	 */
	void setGeometry(GeometryInfo value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcProduct#getGeometry <em>Geometry</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetGeometry()
	 * @see #getGeometry()
	 * @see #setGeometry(GeometryInfo)
	 * @generated
	 */
	void unsetGeometry();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcProduct#getGeometry <em>Geometry</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Geometry</em>' reference is set.
	 * @see #unsetGeometry()
	 * @see #getGeometry()
	 * @see #setGeometry(GeometryInfo)
	 * @generated
	 */
	boolean isSetGeometry();

} // IfcProduct

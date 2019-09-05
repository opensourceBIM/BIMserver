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
 * A representation of the model object '<em><b>Ifc Indexed Colour Map</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcIndexedColourMap#getMappedTo <em>Mapped To</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcIndexedColourMap#getOpacity <em>Opacity</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcIndexedColourMap#getOpacityAsString <em>Opacity As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcIndexedColourMap#getColours <em>Colours</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcIndexedColourMap#getColourIndex <em>Colour Index</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcIndexedColourMap()
 * @model
 * @generated
 */
public interface IfcIndexedColourMap extends IfcPresentationItem {
	/**
	 * Returns the value of the '<em><b>Mapped To</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcTessellatedFaceSet#getHasColours <em>Has Colours</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapped To</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapped To</em>' reference.
	 * @see #setMappedTo(IfcTessellatedFaceSet)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcIndexedColourMap_MappedTo()
	 * @see org.bimserver.models.ifc4.IfcTessellatedFaceSet#getHasColours
	 * @model opposite="HasColours"
	 *        annotation="inverse"
	 * @generated
	 */
	IfcTessellatedFaceSet getMappedTo();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcIndexedColourMap#getMappedTo <em>Mapped To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapped To</em>' reference.
	 * @see #getMappedTo()
	 * @generated
	 */
	void setMappedTo(IfcTessellatedFaceSet value);

	/**
	 * Returns the value of the '<em><b>Opacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Opacity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Opacity</em>' attribute.
	 * @see #isSetOpacity()
	 * @see #unsetOpacity()
	 * @see #setOpacity(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcIndexedColourMap_Opacity()
	 * @model unsettable="true"
	 * @generated
	 */
	double getOpacity();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcIndexedColourMap#getOpacity <em>Opacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Opacity</em>' attribute.
	 * @see #isSetOpacity()
	 * @see #unsetOpacity()
	 * @see #getOpacity()
	 * @generated
	 */
	void setOpacity(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcIndexedColourMap#getOpacity <em>Opacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetOpacity()
	 * @see #getOpacity()
	 * @see #setOpacity(double)
	 * @generated
	 */
	void unsetOpacity();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcIndexedColourMap#getOpacity <em>Opacity</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Opacity</em>' attribute is set.
	 * @see #unsetOpacity()
	 * @see #getOpacity()
	 * @see #setOpacity(double)
	 * @generated
	 */
	boolean isSetOpacity();

	/**
	 * Returns the value of the '<em><b>Opacity As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Opacity As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Opacity As String</em>' attribute.
	 * @see #isSetOpacityAsString()
	 * @see #unsetOpacityAsString()
	 * @see #setOpacityAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcIndexedColourMap_OpacityAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getOpacityAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcIndexedColourMap#getOpacityAsString <em>Opacity As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Opacity As String</em>' attribute.
	 * @see #isSetOpacityAsString()
	 * @see #unsetOpacityAsString()
	 * @see #getOpacityAsString()
	 * @generated
	 */
	void setOpacityAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcIndexedColourMap#getOpacityAsString <em>Opacity As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetOpacityAsString()
	 * @see #getOpacityAsString()
	 * @see #setOpacityAsString(String)
	 * @generated
	 */
	void unsetOpacityAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcIndexedColourMap#getOpacityAsString <em>Opacity As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Opacity As String</em>' attribute is set.
	 * @see #unsetOpacityAsString()
	 * @see #getOpacityAsString()
	 * @see #setOpacityAsString(String)
	 * @generated
	 */
	boolean isSetOpacityAsString();

	/**
	 * Returns the value of the '<em><b>Colours</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Colours</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Colours</em>' reference.
	 * @see #setColours(IfcColourRgbList)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcIndexedColourMap_Colours()
	 * @model
	 * @generated
	 */
	IfcColourRgbList getColours();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcIndexedColourMap#getColours <em>Colours</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Colours</em>' reference.
	 * @see #getColours()
	 * @generated
	 */
	void setColours(IfcColourRgbList value);

	/**
	 * Returns the value of the '<em><b>Colour Index</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Long}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Colour Index</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Colour Index</em>' attribute list.
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcIndexedColourMap_ColourIndex()
	 * @model unique="false"
	 * @generated
	 */
	EList<Long> getColourIndex();

} // IfcIndexedColourMap

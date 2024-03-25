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
 * A representation of the model object '<em><b>Ifc Rel Adheres To Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcRelAdheresToElement#getRelatingElement <em>Relating Element</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcRelAdheresToElement#getRelatedSurfaceFeatures <em>Related Surface Features</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcRelAdheresToElement()
 * @model
 * @generated
 */
public interface IfcRelAdheresToElement extends IfcRelDecomposes {
	/**
	 * Returns the value of the '<em><b>Relating Element</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4x3.IfcElement#getHasSurfaceFeatures <em>Has Surface Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relating Element</em>' reference.
	 * @see #setRelatingElement(IfcElement)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcRelAdheresToElement_RelatingElement()
	 * @see org.bimserver.models.ifc4x3.IfcElement#getHasSurfaceFeatures
	 * @model opposite="HasSurfaceFeatures"
	 *        annotation="inverse"
	 * @generated
	 */
	IfcElement getRelatingElement();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcRelAdheresToElement#getRelatingElement <em>Relating Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relating Element</em>' reference.
	 * @see #getRelatingElement()
	 * @generated
	 */
	void setRelatingElement(IfcElement value);

	/**
	 * Returns the value of the '<em><b>Related Surface Features</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4x3.IfcSurfaceFeature}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4x3.IfcSurfaceFeature#getAdheresToElement <em>Adheres To Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Related Surface Features</em>' reference list.
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcRelAdheresToElement_RelatedSurfaceFeatures()
	 * @see org.bimserver.models.ifc4x3.IfcSurfaceFeature#getAdheresToElement
	 * @model opposite="AdheresToElement"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcSurfaceFeature> getRelatedSurfaceFeatures();

} // IfcRelAdheresToElement

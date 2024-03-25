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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Surface Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcSurfaceFeature#getPredefinedType <em>Predefined Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.IfcSurfaceFeature#getAdheresToElement <em>Adheres To Element</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcSurfaceFeature()
 * @model
 * @generated
 */
public interface IfcSurfaceFeature extends IfcFeatureElement {
	/**
	 * Returns the value of the '<em><b>Predefined Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4x3.IfcSurfaceFeatureTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc4x3.IfcSurfaceFeatureTypeEnum
	 * @see #isSetPredefinedType()
	 * @see #unsetPredefinedType()
	 * @see #setPredefinedType(IfcSurfaceFeatureTypeEnum)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcSurfaceFeature_PredefinedType()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcSurfaceFeatureTypeEnum getPredefinedType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcSurfaceFeature#getPredefinedType <em>Predefined Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc4x3.IfcSurfaceFeatureTypeEnum
	 * @see #isSetPredefinedType()
	 * @see #unsetPredefinedType()
	 * @see #getPredefinedType()
	 * @generated
	 */
	void setPredefinedType(IfcSurfaceFeatureTypeEnum value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcSurfaceFeature#getPredefinedType <em>Predefined Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPredefinedType()
	 * @see #getPredefinedType()
	 * @see #setPredefinedType(IfcSurfaceFeatureTypeEnum)
	 * @generated
	 */
	void unsetPredefinedType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcSurfaceFeature#getPredefinedType <em>Predefined Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Predefined Type</em>' attribute is set.
	 * @see #unsetPredefinedType()
	 * @see #getPredefinedType()
	 * @see #setPredefinedType(IfcSurfaceFeatureTypeEnum)
	 * @generated
	 */
	boolean isSetPredefinedType();

	/**
	 * Returns the value of the '<em><b>Adheres To Element</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4x3.IfcRelAdheresToElement#getRelatedSurfaceFeatures <em>Related Surface Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Adheres To Element</em>' reference.
	 * @see #isSetAdheresToElement()
	 * @see #unsetAdheresToElement()
	 * @see #setAdheresToElement(IfcRelAdheresToElement)
	 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcSurfaceFeature_AdheresToElement()
	 * @see org.bimserver.models.ifc4x3.IfcRelAdheresToElement#getRelatedSurfaceFeatures
	 * @model opposite="RelatedSurfaceFeatures" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	IfcRelAdheresToElement getAdheresToElement();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4x3.IfcSurfaceFeature#getAdheresToElement <em>Adheres To Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Adheres To Element</em>' reference.
	 * @see #isSetAdheresToElement()
	 * @see #unsetAdheresToElement()
	 * @see #getAdheresToElement()
	 * @generated
	 */
	void setAdheresToElement(IfcRelAdheresToElement value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4x3.IfcSurfaceFeature#getAdheresToElement <em>Adheres To Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetAdheresToElement()
	 * @see #getAdheresToElement()
	 * @see #setAdheresToElement(IfcRelAdheresToElement)
	 * @generated
	 */
	void unsetAdheresToElement();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4x3.IfcSurfaceFeature#getAdheresToElement <em>Adheres To Element</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Adheres To Element</em>' reference is set.
	 * @see #unsetAdheresToElement()
	 * @see #getAdheresToElement()
	 * @see #setAdheresToElement(IfcRelAdheresToElement)
	 * @generated
	 */
	boolean isSetAdheresToElement();

} // IfcSurfaceFeature

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
 * A representation of the model object '<em><b>Ifc Space</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcSpace#getPredefinedType <em>Predefined Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcSpace#getElevationWithFlooring <em>Elevation With Flooring</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcSpace#getElevationWithFlooringAsString <em>Elevation With Flooring As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcSpace#getHasCoverings <em>Has Coverings</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcSpace#getBoundedBy <em>Bounded By</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSpace()
 * @model
 * @generated
 */
public interface IfcSpace extends IfcSpatialStructureElement, IfcSpaceBoundarySelect {
	/**
	 * Returns the value of the '<em><b>Predefined Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.IfcSpaceTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predefined Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcSpaceTypeEnum
	 * @see #isSetPredefinedType()
	 * @see #unsetPredefinedType()
	 * @see #setPredefinedType(IfcSpaceTypeEnum)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSpace_PredefinedType()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcSpaceTypeEnum getPredefinedType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcSpace#getPredefinedType <em>Predefined Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcSpaceTypeEnum
	 * @see #isSetPredefinedType()
	 * @see #unsetPredefinedType()
	 * @see #getPredefinedType()
	 * @generated
	 */
	void setPredefinedType(IfcSpaceTypeEnum value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcSpace#getPredefinedType <em>Predefined Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPredefinedType()
	 * @see #getPredefinedType()
	 * @see #setPredefinedType(IfcSpaceTypeEnum)
	 * @generated
	 */
	void unsetPredefinedType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcSpace#getPredefinedType <em>Predefined Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Predefined Type</em>' attribute is set.
	 * @see #unsetPredefinedType()
	 * @see #getPredefinedType()
	 * @see #setPredefinedType(IfcSpaceTypeEnum)
	 * @generated
	 */
	boolean isSetPredefinedType();

	/**
	 * Returns the value of the '<em><b>Elevation With Flooring</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elevation With Flooring</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elevation With Flooring</em>' attribute.
	 * @see #isSetElevationWithFlooring()
	 * @see #unsetElevationWithFlooring()
	 * @see #setElevationWithFlooring(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSpace_ElevationWithFlooring()
	 * @model unsettable="true"
	 * @generated
	 */
	double getElevationWithFlooring();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcSpace#getElevationWithFlooring <em>Elevation With Flooring</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Elevation With Flooring</em>' attribute.
	 * @see #isSetElevationWithFlooring()
	 * @see #unsetElevationWithFlooring()
	 * @see #getElevationWithFlooring()
	 * @generated
	 */
	void setElevationWithFlooring(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcSpace#getElevationWithFlooring <em>Elevation With Flooring</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetElevationWithFlooring()
	 * @see #getElevationWithFlooring()
	 * @see #setElevationWithFlooring(double)
	 * @generated
	 */
	void unsetElevationWithFlooring();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcSpace#getElevationWithFlooring <em>Elevation With Flooring</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Elevation With Flooring</em>' attribute is set.
	 * @see #unsetElevationWithFlooring()
	 * @see #getElevationWithFlooring()
	 * @see #setElevationWithFlooring(double)
	 * @generated
	 */
	boolean isSetElevationWithFlooring();

	/**
	 * Returns the value of the '<em><b>Elevation With Flooring As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elevation With Flooring As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elevation With Flooring As String</em>' attribute.
	 * @see #isSetElevationWithFlooringAsString()
	 * @see #unsetElevationWithFlooringAsString()
	 * @see #setElevationWithFlooringAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSpace_ElevationWithFlooringAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getElevationWithFlooringAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcSpace#getElevationWithFlooringAsString <em>Elevation With Flooring As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Elevation With Flooring As String</em>' attribute.
	 * @see #isSetElevationWithFlooringAsString()
	 * @see #unsetElevationWithFlooringAsString()
	 * @see #getElevationWithFlooringAsString()
	 * @generated
	 */
	void setElevationWithFlooringAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcSpace#getElevationWithFlooringAsString <em>Elevation With Flooring As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetElevationWithFlooringAsString()
	 * @see #getElevationWithFlooringAsString()
	 * @see #setElevationWithFlooringAsString(String)
	 * @generated
	 */
	void unsetElevationWithFlooringAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcSpace#getElevationWithFlooringAsString <em>Elevation With Flooring As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Elevation With Flooring As String</em>' attribute is set.
	 * @see #unsetElevationWithFlooringAsString()
	 * @see #getElevationWithFlooringAsString()
	 * @see #setElevationWithFlooringAsString(String)
	 * @generated
	 */
	boolean isSetElevationWithFlooringAsString();

	/**
	 * Returns the value of the '<em><b>Has Coverings</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcRelCoversSpaces}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcRelCoversSpaces#getRelatingSpace <em>Relating Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Coverings</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Coverings</em>' reference list.
	 * @see #isSetHasCoverings()
	 * @see #unsetHasCoverings()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSpace_HasCoverings()
	 * @see org.bimserver.models.ifc4.IfcRelCoversSpaces#getRelatingSpace
	 * @model opposite="RelatingSpace" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcRelCoversSpaces> getHasCoverings();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcSpace#getHasCoverings <em>Has Coverings</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetHasCoverings()
	 * @see #getHasCoverings()
	 * @generated
	 */
	void unsetHasCoverings();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcSpace#getHasCoverings <em>Has Coverings</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Has Coverings</em>' reference list is set.
	 * @see #unsetHasCoverings()
	 * @see #getHasCoverings()
	 * @generated
	 */
	boolean isSetHasCoverings();

	/**
	 * Returns the value of the '<em><b>Bounded By</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcRelSpaceBoundary}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bounded By</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bounded By</em>' reference list.
	 * @see #isSetBoundedBy()
	 * @see #unsetBoundedBy()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSpace_BoundedBy()
	 * @model unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcRelSpaceBoundary> getBoundedBy();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcSpace#getBoundedBy <em>Bounded By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBoundedBy()
	 * @see #getBoundedBy()
	 * @generated
	 */
	void unsetBoundedBy();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcSpace#getBoundedBy <em>Bounded By</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Bounded By</em>' reference list is set.
	 * @see #unsetBoundedBy()
	 * @see #getBoundedBy()
	 * @generated
	 */
	boolean isSetBoundedBy();

} // IfcSpace

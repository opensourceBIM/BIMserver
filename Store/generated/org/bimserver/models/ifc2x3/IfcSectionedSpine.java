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
 * A representation of the model object '<em><b>Ifc Sectioned Spine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSectionedSpine#getSpineCurve <em>Spine Curve</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSectionedSpine#getCrossSections <em>Cross Sections</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSectionedSpine#getCrossSectionPositions <em>Cross Section Positions</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSectionedSpine#getDim <em>Dim</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSectionedSpine()
 * @model
 * @generated
 */
public interface IfcSectionedSpine extends IfcGeometricRepresentationItem
{
	/**
	 * Returns the value of the '<em><b>Spine Curve</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Spine Curve</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Spine Curve</em>' reference.
	 * @see #setSpineCurve(IfcCompositeCurve)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSectionedSpine_SpineCurve()
	 * @model
	 * @generated
	 */
	IfcCompositeCurve getSpineCurve();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcSectionedSpine#getSpineCurve <em>Spine Curve</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Spine Curve</em>' reference.
	 * @see #getSpineCurve()
	 * @generated
	 */
	void setSpineCurve(IfcCompositeCurve value);

	/**
	 * Returns the value of the '<em><b>Cross Sections</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcProfileDef}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cross Sections</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cross Sections</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSectionedSpine_CrossSections()
	 * @model
	 * @generated
	 */
	EList<IfcProfileDef> getCrossSections();

	/**
	 * Returns the value of the '<em><b>Cross Section Positions</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcAxis2Placement3D}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cross Section Positions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cross Section Positions</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSectionedSpine_CrossSectionPositions()
	 * @model
	 * @generated
	 */
	EList<IfcAxis2Placement3D> getCrossSectionPositions();

	/**
	 * Returns the value of the '<em><b>Dim</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dim</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dim</em>' attribute.
	 * @see #setDim(int)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSectionedSpine_Dim()
	 * @model derived="true"
	 * @generated
	 */
	int getDim();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcSectionedSpine#getDim <em>Dim</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dim</em>' attribute.
	 * @see #getDim()
	 * @generated
	 */
	void setDim(int value);

} // IfcSectionedSpine

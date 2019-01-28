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
package org.bimserver.models.ifc2x3tc1;

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
 * A representation of the model object '<em><b>Ifc Structural Analysis Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcStructuralAnalysisModel#getPredefinedType <em>Predefined Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcStructuralAnalysisModel#getOrientationOf2DPlane <em>Orientation Of2 DPlane</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcStructuralAnalysisModel#getLoadedBy <em>Loaded By</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.IfcStructuralAnalysisModel#getHasResults <em>Has Results</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcStructuralAnalysisModel()
 * @model
 * @generated
 */
public interface IfcStructuralAnalysisModel extends IfcSystem {
	/**
	 * Returns the value of the '<em><b>Predefined Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3tc1.IfcAnalysisModelTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predefined Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.IfcAnalysisModelTypeEnum
	 * @see #setPredefinedType(IfcAnalysisModelTypeEnum)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcStructuralAnalysisModel_PredefinedType()
	 * @model
	 * @generated
	 */
	IfcAnalysisModelTypeEnum getPredefinedType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralAnalysisModel#getPredefinedType <em>Predefined Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.IfcAnalysisModelTypeEnum
	 * @see #getPredefinedType()
	 * @generated
	 */
	void setPredefinedType(IfcAnalysisModelTypeEnum value);

	/**
	 * Returns the value of the '<em><b>Orientation Of2 DPlane</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Orientation Of2 DPlane</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Orientation Of2 DPlane</em>' reference.
	 * @see #isSetOrientationOf2DPlane()
	 * @see #unsetOrientationOf2DPlane()
	 * @see #setOrientationOf2DPlane(IfcAxis2Placement3D)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcStructuralAnalysisModel_OrientationOf2DPlane()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcAxis2Placement3D getOrientationOf2DPlane();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralAnalysisModel#getOrientationOf2DPlane <em>Orientation Of2 DPlane</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Orientation Of2 DPlane</em>' reference.
	 * @see #isSetOrientationOf2DPlane()
	 * @see #unsetOrientationOf2DPlane()
	 * @see #getOrientationOf2DPlane()
	 * @generated
	 */
	void setOrientationOf2DPlane(IfcAxis2Placement3D value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralAnalysisModel#getOrientationOf2DPlane <em>Orientation Of2 DPlane</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetOrientationOf2DPlane()
	 * @see #getOrientationOf2DPlane()
	 * @see #setOrientationOf2DPlane(IfcAxis2Placement3D)
	 * @generated
	 */
	void unsetOrientationOf2DPlane();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralAnalysisModel#getOrientationOf2DPlane <em>Orientation Of2 DPlane</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Orientation Of2 DPlane</em>' reference is set.
	 * @see #unsetOrientationOf2DPlane()
	 * @see #getOrientationOf2DPlane()
	 * @see #setOrientationOf2DPlane(IfcAxis2Placement3D)
	 * @generated
	 */
	boolean isSetOrientationOf2DPlane();

	/**
	 * Returns the value of the '<em><b>Loaded By</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadGroup}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadGroup#getLoadGroupFor <em>Load Group For</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Loaded By</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loaded By</em>' reference list.
	 * @see #isSetLoadedBy()
	 * @see #unsetLoadedBy()
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcStructuralAnalysisModel_LoadedBy()
	 * @see org.bimserver.models.ifc2x3tc1.IfcStructuralLoadGroup#getLoadGroupFor
	 * @model opposite="LoadGroupFor" unsettable="true"
	 * @generated
	 */
	EList<IfcStructuralLoadGroup> getLoadedBy();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralAnalysisModel#getLoadedBy <em>Loaded By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLoadedBy()
	 * @see #getLoadedBy()
	 * @generated
	 */
	void unsetLoadedBy();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralAnalysisModel#getLoadedBy <em>Loaded By</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Loaded By</em>' reference list is set.
	 * @see #unsetLoadedBy()
	 * @see #getLoadedBy()
	 * @generated
	 */
	boolean isSetLoadedBy();

	/**
	 * Returns the value of the '<em><b>Has Results</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3tc1.IfcStructuralResultGroup}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralResultGroup#getResultGroupFor <em>Result Group For</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Results</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Results</em>' reference list.
	 * @see #isSetHasResults()
	 * @see #unsetHasResults()
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcStructuralAnalysisModel_HasResults()
	 * @see org.bimserver.models.ifc2x3tc1.IfcStructuralResultGroup#getResultGroupFor
	 * @model opposite="ResultGroupFor" unsettable="true"
	 * @generated
	 */
	EList<IfcStructuralResultGroup> getHasResults();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralAnalysisModel#getHasResults <em>Has Results</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetHasResults()
	 * @see #getHasResults()
	 * @generated
	 */
	void unsetHasResults();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralAnalysisModel#getHasResults <em>Has Results</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Has Results</em>' reference list is set.
	 * @see #unsetHasResults()
	 * @see #getHasResults()
	 * @generated
	 */
	boolean isSetHasResults();

} // IfcStructuralAnalysisModel

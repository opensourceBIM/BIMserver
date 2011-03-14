/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Face Based Surface Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcFaceBasedSurfaceModel#getFbsmFaces <em>Fbsm Faces</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcFaceBasedSurfaceModel#getDim <em>Dim</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcFaceBasedSurfaceModel()
 * @model
 * @generated
 */
public interface IfcFaceBasedSurfaceModel extends IfcGeometricRepresentationItem, IfcSurfaceOrFaceSurface {
	/**
	 * Returns the value of the '<em><b>Fbsm Faces</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcConnectedFaceSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fbsm Faces</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fbsm Faces</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcFaceBasedSurfaceModel_FbsmFaces()
	 * @model
	 * @generated
	 */
	EList<IfcConnectedFaceSet> getFbsmFaces();

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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcFaceBasedSurfaceModel_Dim()
	 * @model derived="true"
	 * @generated
	 */
	int getDim();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcFaceBasedSurfaceModel#getDim <em>Dim</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dim</em>' attribute.
	 * @see #getDim()
	 * @generated
	 */
	void setDim(int value);

} // IfcFaceBasedSurfaceModel

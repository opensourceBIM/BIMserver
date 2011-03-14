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
 * A representation of the model object '<em><b>Ifc Shell Based Surface Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcShellBasedSurfaceModel#getSbsmBoundary <em>Sbsm Boundary</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcShellBasedSurfaceModel#getDim <em>Dim</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcShellBasedSurfaceModel()
 * @model
 * @generated
 */
public interface IfcShellBasedSurfaceModel extends IfcGeometricRepresentationItem {
	/**
	 * Returns the value of the '<em><b>Sbsm Boundary</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcShell}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sbsm Boundary</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sbsm Boundary</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcShellBasedSurfaceModel_SbsmBoundary()
	 * @model
	 * @generated
	 */
	EList<IfcShell> getSbsmBoundary();

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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcShellBasedSurfaceModel_Dim()
	 * @model derived="true"
	 * @generated
	 */
	int getDim();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcShellBasedSurfaceModel#getDim <em>Dim</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dim</em>' attribute.
	 * @see #getDim()
	 * @generated
	 */
	void setDim(int value);

} // IfcShellBasedSurfaceModel

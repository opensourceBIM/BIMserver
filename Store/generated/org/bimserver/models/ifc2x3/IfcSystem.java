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
 * A representation of the model object '<em><b>Ifc System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSystem#getServicesBuildings <em>Services Buildings</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSystem()
 * @model
 * @generated
 */
public interface IfcSystem extends IfcGroup {
	/**
	 * Returns the value of the '<em><b>Services Buildings</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcRelServicesBuildings}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcRelServicesBuildings#getRelatingSystem <em>Relating System</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Services Buildings</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Services Buildings</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSystem_ServicesBuildings()
	 * @see org.bimserver.models.ifc2x3.IfcRelServicesBuildings#getRelatingSystem
	 * @model opposite="RelatingSystem" upper="2"
	 * @generated
	 */
	EList<IfcRelServicesBuildings> getServicesBuildings();

} // IfcSystem

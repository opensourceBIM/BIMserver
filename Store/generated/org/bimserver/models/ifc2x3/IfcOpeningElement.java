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
 * A representation of the model object '<em><b>Ifc Opening Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcOpeningElement#getHasFillings <em>Has Fillings</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcOpeningElement()
 * @model
 * @generated
 */
public interface IfcOpeningElement extends IfcFeatureElementSubtraction {
	/**
	 * Returns the value of the '<em><b>Has Fillings</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcRelFillsElement}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcRelFillsElement#getRelatingOpeningElement <em>Relating Opening Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Fillings</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Fillings</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcOpeningElement_HasFillings()
	 * @see org.bimserver.models.ifc2x3.IfcRelFillsElement#getRelatingOpeningElement
	 * @model opposite="RelatingOpeningElement"
	 * @generated
	 */
	EList<IfcRelFillsElement> getHasFillings();

} // IfcOpeningElement

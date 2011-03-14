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
 * A representation of the model object '<em><b>Ifc Complex Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcComplexProperty#getUsageName <em>Usage Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcComplexProperty#getHasProperties <em>Has Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcComplexProperty()
 * @model
 * @generated
 */
public interface IfcComplexProperty extends IfcProperty {
	/**
	 * Returns the value of the '<em><b>Usage Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Usage Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Usage Name</em>' attribute.
	 * @see #setUsageName(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcComplexProperty_UsageName()
	 * @model
	 * @generated
	 */
	String getUsageName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcComplexProperty#getUsageName <em>Usage Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Usage Name</em>' attribute.
	 * @see #getUsageName()
	 * @generated
	 */
	void setUsageName(String value);

	/**
	 * Returns the value of the '<em><b>Has Properties</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcProperty}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcProperty#getPartOfComplex <em>Part Of Complex</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Properties</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Properties</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcComplexProperty_HasProperties()
	 * @see org.bimserver.models.ifc2x3.IfcProperty#getPartOfComplex
	 * @model opposite="PartOfComplex"
	 * @generated
	 */
	EList<IfcProperty> getHasProperties();

} // IfcComplexProperty

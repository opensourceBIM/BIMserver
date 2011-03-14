/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc SI Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSIUnit#getPrefix <em>Prefix</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSIUnit#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSIUnit()
 * @model
 * @generated
 */
public interface IfcSIUnit extends IfcNamedUnit {
	/**
	 * Returns the value of the '<em><b>Prefix</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.IfcSIPrefix}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prefix</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prefix</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcSIPrefix
	 * @see #setPrefix(IfcSIPrefix)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSIUnit_Prefix()
	 * @model
	 * @generated
	 */
	IfcSIPrefix getPrefix();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcSIUnit#getPrefix <em>Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prefix</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcSIPrefix
	 * @see #getPrefix()
	 * @generated
	 */
	void setPrefix(IfcSIPrefix value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.IfcSIUnitName}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcSIUnitName
	 * @see #setName(IfcSIUnitName)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSIUnit_Name()
	 * @model
	 * @generated
	 */
	IfcSIUnitName getName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcSIUnit#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcSIUnitName
	 * @see #getName()
	 * @generated
	 */
	void setName(IfcSIUnitName value);

} // IfcSIUnit

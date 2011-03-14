/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Reinforcing Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcReinforcingElement#getSteelGrade <em>Steel Grade</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcReinforcingElement()
 * @model
 * @generated
 */
public interface IfcReinforcingElement extends IfcBuildingElementComponent {
	/**
	 * Returns the value of the '<em><b>Steel Grade</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Steel Grade</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Steel Grade</em>' attribute.
	 * @see #isSetSteelGrade()
	 * @see #unsetSteelGrade()
	 * @see #setSteelGrade(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcReinforcingElement_SteelGrade()
	 * @model unsettable="true"
	 * @generated
	 */
	String getSteelGrade();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcReinforcingElement#getSteelGrade <em>Steel Grade</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Steel Grade</em>' attribute.
	 * @see #isSetSteelGrade()
	 * @see #unsetSteelGrade()
	 * @see #getSteelGrade()
	 * @generated
	 */
	void setSteelGrade(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcReinforcingElement#getSteelGrade <em>Steel Grade</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSteelGrade()
	 * @see #getSteelGrade()
	 * @see #setSteelGrade(String)
	 * @generated
	 */
	void unsetSteelGrade();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcReinforcingElement#getSteelGrade <em>Steel Grade</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Steel Grade</em>' attribute is set.
	 * @see #unsetSteelGrade()
	 * @see #getSteelGrade()
	 * @see #setSteelGrade(String)
	 * @generated
	 */
	boolean isSetSteelGrade();

} // IfcReinforcingElement

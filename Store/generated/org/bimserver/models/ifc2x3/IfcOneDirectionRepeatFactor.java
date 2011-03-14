/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc One Direction Repeat Factor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcOneDirectionRepeatFactor#getRepeatFactor <em>Repeat Factor</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcOneDirectionRepeatFactor()
 * @model
 * @generated
 */
public interface IfcOneDirectionRepeatFactor extends IfcGeometricRepresentationItem, IfcHatchLineDistanceSelect {
	/**
	 * Returns the value of the '<em><b>Repeat Factor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repeat Factor</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repeat Factor</em>' reference.
	 * @see #setRepeatFactor(IfcVector)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcOneDirectionRepeatFactor_RepeatFactor()
	 * @model
	 * @generated
	 */
	IfcVector getRepeatFactor();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcOneDirectionRepeatFactor#getRepeatFactor <em>Repeat Factor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repeat Factor</em>' reference.
	 * @see #getRepeatFactor()
	 * @generated
	 */
	void setRepeatFactor(IfcVector value);

} // IfcOneDirectionRepeatFactor

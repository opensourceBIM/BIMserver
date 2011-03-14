/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;

import org.bimserver.emf.IdEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Coordinated Universal Time Offset</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCoordinatedUniversalTimeOffset#getHourOffset <em>Hour Offset</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCoordinatedUniversalTimeOffset#getMinuteOffset <em>Minute Offset</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcCoordinatedUniversalTimeOffset#getSense <em>Sense</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCoordinatedUniversalTimeOffset()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface IfcCoordinatedUniversalTimeOffset extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Hour Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hour Offset</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hour Offset</em>' attribute.
	 * @see #setHourOffset(int)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCoordinatedUniversalTimeOffset_HourOffset()
	 * @model
	 * @generated
	 */
	int getHourOffset();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCoordinatedUniversalTimeOffset#getHourOffset <em>Hour Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hour Offset</em>' attribute.
	 * @see #getHourOffset()
	 * @generated
	 */
	void setHourOffset(int value);

	/**
	 * Returns the value of the '<em><b>Minute Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Minute Offset</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Minute Offset</em>' attribute.
	 * @see #isSetMinuteOffset()
	 * @see #unsetMinuteOffset()
	 * @see #setMinuteOffset(int)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCoordinatedUniversalTimeOffset_MinuteOffset()
	 * @model unsettable="true"
	 * @generated
	 */
	int getMinuteOffset();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCoordinatedUniversalTimeOffset#getMinuteOffset <em>Minute Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minute Offset</em>' attribute.
	 * @see #isSetMinuteOffset()
	 * @see #unsetMinuteOffset()
	 * @see #getMinuteOffset()
	 * @generated
	 */
	void setMinuteOffset(int value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcCoordinatedUniversalTimeOffset#getMinuteOffset <em>Minute Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMinuteOffset()
	 * @see #getMinuteOffset()
	 * @see #setMinuteOffset(int)
	 * @generated
	 */
	void unsetMinuteOffset();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcCoordinatedUniversalTimeOffset#getMinuteOffset <em>Minute Offset</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Minute Offset</em>' attribute is set.
	 * @see #unsetMinuteOffset()
	 * @see #getMinuteOffset()
	 * @see #setMinuteOffset(int)
	 * @generated
	 */
	boolean isSetMinuteOffset();

	/**
	 * Returns the value of the '<em><b>Sense</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.IfcAheadOrBehind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sense</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sense</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcAheadOrBehind
	 * @see #setSense(IfcAheadOrBehind)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCoordinatedUniversalTimeOffset_Sense()
	 * @model
	 * @generated
	 */
	IfcAheadOrBehind getSense();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcCoordinatedUniversalTimeOffset#getSense <em>Sense</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sense</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcAheadOrBehind
	 * @see #getSense()
	 * @generated
	 */
	void setSense(IfcAheadOrBehind value);

} // IfcCoordinatedUniversalTimeOffset

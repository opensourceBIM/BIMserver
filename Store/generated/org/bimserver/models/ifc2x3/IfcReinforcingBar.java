/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Reinforcing Bar</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcReinforcingBar#getNominalDiameter <em>Nominal Diameter</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcReinforcingBar#getNominalDiameterAsString <em>Nominal Diameter As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcReinforcingBar#getCrossSectionArea <em>Cross Section Area</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcReinforcingBar#getCrossSectionAreaAsString <em>Cross Section Area As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcReinforcingBar#getBarLength <em>Bar Length</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcReinforcingBar#getBarLengthAsString <em>Bar Length As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcReinforcingBar#getBarRole <em>Bar Role</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcReinforcingBar#getBarSurface <em>Bar Surface</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcReinforcingBar()
 * @model
 * @generated
 */
public interface IfcReinforcingBar extends IfcReinforcingElement {
	/**
	 * Returns the value of the '<em><b>Nominal Diameter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nominal Diameter</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nominal Diameter</em>' attribute.
	 * @see #setNominalDiameter(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcReinforcingBar_NominalDiameter()
	 * @model
	 * @generated
	 */
	float getNominalDiameter();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcReinforcingBar#getNominalDiameter <em>Nominal Diameter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nominal Diameter</em>' attribute.
	 * @see #getNominalDiameter()
	 * @generated
	 */
	void setNominalDiameter(float value);

	/**
	 * Returns the value of the '<em><b>Nominal Diameter As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nominal Diameter As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nominal Diameter As String</em>' attribute.
	 * @see #setNominalDiameterAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcReinforcingBar_NominalDiameterAsString()
	 * @model
	 * @generated
	 */
	String getNominalDiameterAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcReinforcingBar#getNominalDiameterAsString <em>Nominal Diameter As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nominal Diameter As String</em>' attribute.
	 * @see #getNominalDiameterAsString()
	 * @generated
	 */
	void setNominalDiameterAsString(String value);

	/**
	 * Returns the value of the '<em><b>Cross Section Area</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cross Section Area</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cross Section Area</em>' attribute.
	 * @see #setCrossSectionArea(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcReinforcingBar_CrossSectionArea()
	 * @model
	 * @generated
	 */
	float getCrossSectionArea();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcReinforcingBar#getCrossSectionArea <em>Cross Section Area</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cross Section Area</em>' attribute.
	 * @see #getCrossSectionArea()
	 * @generated
	 */
	void setCrossSectionArea(float value);

	/**
	 * Returns the value of the '<em><b>Cross Section Area As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cross Section Area As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cross Section Area As String</em>' attribute.
	 * @see #setCrossSectionAreaAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcReinforcingBar_CrossSectionAreaAsString()
	 * @model
	 * @generated
	 */
	String getCrossSectionAreaAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcReinforcingBar#getCrossSectionAreaAsString <em>Cross Section Area As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cross Section Area As String</em>' attribute.
	 * @see #getCrossSectionAreaAsString()
	 * @generated
	 */
	void setCrossSectionAreaAsString(String value);

	/**
	 * Returns the value of the '<em><b>Bar Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bar Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bar Length</em>' attribute.
	 * @see #isSetBarLength()
	 * @see #unsetBarLength()
	 * @see #setBarLength(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcReinforcingBar_BarLength()
	 * @model unsettable="true"
	 * @generated
	 */
	float getBarLength();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcReinforcingBar#getBarLength <em>Bar Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bar Length</em>' attribute.
	 * @see #isSetBarLength()
	 * @see #unsetBarLength()
	 * @see #getBarLength()
	 * @generated
	 */
	void setBarLength(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcReinforcingBar#getBarLength <em>Bar Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBarLength()
	 * @see #getBarLength()
	 * @see #setBarLength(float)
	 * @generated
	 */
	void unsetBarLength();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcReinforcingBar#getBarLength <em>Bar Length</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Bar Length</em>' attribute is set.
	 * @see #unsetBarLength()
	 * @see #getBarLength()
	 * @see #setBarLength(float)
	 * @generated
	 */
	boolean isSetBarLength();

	/**
	 * Returns the value of the '<em><b>Bar Length As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bar Length As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bar Length As String</em>' attribute.
	 * @see #isSetBarLengthAsString()
	 * @see #unsetBarLengthAsString()
	 * @see #setBarLengthAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcReinforcingBar_BarLengthAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getBarLengthAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcReinforcingBar#getBarLengthAsString <em>Bar Length As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bar Length As String</em>' attribute.
	 * @see #isSetBarLengthAsString()
	 * @see #unsetBarLengthAsString()
	 * @see #getBarLengthAsString()
	 * @generated
	 */
	void setBarLengthAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcReinforcingBar#getBarLengthAsString <em>Bar Length As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBarLengthAsString()
	 * @see #getBarLengthAsString()
	 * @see #setBarLengthAsString(String)
	 * @generated
	 */
	void unsetBarLengthAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcReinforcingBar#getBarLengthAsString <em>Bar Length As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Bar Length As String</em>' attribute is set.
	 * @see #unsetBarLengthAsString()
	 * @see #getBarLengthAsString()
	 * @see #setBarLengthAsString(String)
	 * @generated
	 */
	boolean isSetBarLengthAsString();

	/**
	 * Returns the value of the '<em><b>Bar Role</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.IfcReinforcingBarRoleEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bar Role</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bar Role</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcReinforcingBarRoleEnum
	 * @see #setBarRole(IfcReinforcingBarRoleEnum)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcReinforcingBar_BarRole()
	 * @model
	 * @generated
	 */
	IfcReinforcingBarRoleEnum getBarRole();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcReinforcingBar#getBarRole <em>Bar Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bar Role</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcReinforcingBarRoleEnum
	 * @see #getBarRole()
	 * @generated
	 */
	void setBarRole(IfcReinforcingBarRoleEnum value);

	/**
	 * Returns the value of the '<em><b>Bar Surface</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3.IfcReinforcingBarSurfaceEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bar Surface</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bar Surface</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcReinforcingBarSurfaceEnum
	 * @see #setBarSurface(IfcReinforcingBarSurfaceEnum)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcReinforcingBar_BarSurface()
	 * @model
	 * @generated
	 */
	IfcReinforcingBarSurfaceEnum getBarSurface();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcReinforcingBar#getBarSurface <em>Bar Surface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bar Surface</em>' attribute.
	 * @see org.bimserver.models.ifc2x3.IfcReinforcingBarSurfaceEnum
	 * @see #getBarSurface()
	 * @generated
	 */
	void setBarSurface(IfcReinforcingBarSurfaceEnum value);

} // IfcReinforcingBar

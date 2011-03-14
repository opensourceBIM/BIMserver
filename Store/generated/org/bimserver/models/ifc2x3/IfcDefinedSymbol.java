/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Defined Symbol</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcDefinedSymbol#getDefinition <em>Definition</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcDefinedSymbol#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDefinedSymbol()
 * @model
 * @generated
 */
public interface IfcDefinedSymbol extends IfcGeometricRepresentationItem {
	/**
	 * Returns the value of the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Definition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Definition</em>' reference.
	 * @see #setDefinition(IfcDefinedSymbolSelect)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDefinedSymbol_Definition()
	 * @model
	 * @generated
	 */
	IfcDefinedSymbolSelect getDefinition();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcDefinedSymbol#getDefinition <em>Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Definition</em>' reference.
	 * @see #getDefinition()
	 * @generated
	 */
	void setDefinition(IfcDefinedSymbolSelect value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(IfcCartesianTransformationOperator2D)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDefinedSymbol_Target()
	 * @model
	 * @generated
	 */
	IfcCartesianTransformationOperator2D getTarget();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcDefinedSymbol#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(IfcCartesianTransformationOperator2D value);

} // IfcDefinedSymbol

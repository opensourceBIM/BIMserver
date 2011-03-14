/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Symbol Style</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcSymbolStyle#getStyleOfSymbol <em>Style Of Symbol</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSymbolStyle()
 * @model
 * @generated
 */
public interface IfcSymbolStyle extends IfcPresentationStyle, IfcPresentationStyleSelect {
	/**
	 * Returns the value of the '<em><b>Style Of Symbol</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Style Of Symbol</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Style Of Symbol</em>' reference.
	 * @see #setStyleOfSymbol(IfcSymbolStyleSelect)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSymbolStyle_StyleOfSymbol()
	 * @model
	 * @generated
	 */
	IfcSymbolStyleSelect getStyleOfSymbol();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcSymbolStyle#getStyleOfSymbol <em>Style Of Symbol</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Style Of Symbol</em>' reference.
	 * @see #getStyleOfSymbol()
	 * @generated
	 */
	void setStyleOfSymbol(IfcSymbolStyleSelect value);

} // IfcSymbolStyle

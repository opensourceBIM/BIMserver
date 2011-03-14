/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Fill Area Style Tile Symbol With Style</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcFillAreaStyleTileSymbolWithStyle#getSymbol <em>Symbol</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcFillAreaStyleTileSymbolWithStyle()
 * @model
 * @generated
 */
public interface IfcFillAreaStyleTileSymbolWithStyle extends IfcGeometricRepresentationItem, IfcFillAreaStyleTileShapeSelect {
	/**
	 * Returns the value of the '<em><b>Symbol</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Symbol</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Symbol</em>' reference.
	 * @see #setSymbol(IfcAnnotationSymbolOccurrence)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcFillAreaStyleTileSymbolWithStyle_Symbol()
	 * @model
	 * @generated
	 */
	IfcAnnotationSymbolOccurrence getSymbol();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcFillAreaStyleTileSymbolWithStyle#getSymbol <em>Symbol</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Symbol</em>' reference.
	 * @see #getSymbol()
	 * @generated
	 */
	void setSymbol(IfcAnnotationSymbolOccurrence value);

} // IfcFillAreaStyleTileSymbolWithStyle

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcAnnotationSymbolOccurrence;
import org.bimserver.models.ifc2x3.IfcFillAreaStyleTileSymbolWithStyle;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Fill Area Style Tile Symbol With Style</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcFillAreaStyleTileSymbolWithStyleImpl#getSymbol <em>Symbol</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcFillAreaStyleTileSymbolWithStyleImpl extends IfcGeometricRepresentationItemImpl implements IfcFillAreaStyleTileSymbolWithStyle {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcFillAreaStyleTileSymbolWithStyleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcFillAreaStyleTileSymbolWithStyle();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAnnotationSymbolOccurrence getSymbol() {
		return (IfcAnnotationSymbolOccurrence)eGet(Ifc2x3Package.eINSTANCE.getIfcFillAreaStyleTileSymbolWithStyle_Symbol(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSymbol(IfcAnnotationSymbolOccurrence newSymbol) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcFillAreaStyleTileSymbolWithStyle_Symbol(), newSymbol);
	}

} //IfcFillAreaStyleTileSymbolWithStyleImpl

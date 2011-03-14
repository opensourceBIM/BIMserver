/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcSymbolStyle;
import org.bimserver.models.ifc2x3.IfcSymbolStyleSelect;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Symbol Style</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSymbolStyleImpl#getStyleOfSymbol <em>Style Of Symbol</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcSymbolStyleImpl extends IfcPresentationStyleImpl implements IfcSymbolStyle {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcSymbolStyleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcSymbolStyle();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSymbolStyleSelect getStyleOfSymbol() {
		return (IfcSymbolStyleSelect)eGet(Ifc2x3Package.eINSTANCE.getIfcSymbolStyle_StyleOfSymbol(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStyleOfSymbol(IfcSymbolStyleSelect newStyleOfSymbol) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcSymbolStyle_StyleOfSymbol(), newStyleOfSymbol);
	}

} //IfcSymbolStyleImpl

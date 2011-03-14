/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcFillAreaStyle;
import org.bimserver.models.ifc2x3.IfcFillStyleSelect;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Fill Area Style</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcFillAreaStyleImpl#getFillStyles <em>Fill Styles</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcFillAreaStyleImpl extends IfcPresentationStyleImpl implements IfcFillAreaStyle {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcFillAreaStyleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcFillAreaStyle();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcFillStyleSelect> getFillStyles() {
		return (EList<IfcFillStyleSelect>)eGet(Ifc2x3Package.eINSTANCE.getIfcFillAreaStyle_FillStyles(), true);
	}

} //IfcFillAreaStyleImpl

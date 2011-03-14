/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcSurfaceSide;
import org.bimserver.models.ifc2x3.IfcSurfaceStyle;
import org.bimserver.models.ifc2x3.IfcSurfaceStyleElementSelect;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Surface Style</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSurfaceStyleImpl#getSide <em>Side</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSurfaceStyleImpl#getStyles <em>Styles</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcSurfaceStyleImpl extends IfcPresentationStyleImpl implements IfcSurfaceStyle {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcSurfaceStyleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcSurfaceStyle();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSurfaceSide getSide() {
		return (IfcSurfaceSide)eGet(Ifc2x3Package.eINSTANCE.getIfcSurfaceStyle_Side(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSide(IfcSurfaceSide newSide) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcSurfaceStyle_Side(), newSide);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcSurfaceStyleElementSelect> getStyles() {
		return (EList<IfcSurfaceStyleElementSelect>)eGet(Ifc2x3Package.eINSTANCE.getIfcSurfaceStyle_Styles(), true);
	}

} //IfcSurfaceStyleImpl

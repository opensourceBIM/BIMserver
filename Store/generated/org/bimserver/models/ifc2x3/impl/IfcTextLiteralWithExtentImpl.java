/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcPlanarExtent;
import org.bimserver.models.ifc2x3.IfcTextLiteralWithExtent;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Text Literal With Extent</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTextLiteralWithExtentImpl#getExtent <em>Extent</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTextLiteralWithExtentImpl#getBoxAlignment <em>Box Alignment</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcTextLiteralWithExtentImpl extends IfcTextLiteralImpl implements IfcTextLiteralWithExtent {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcTextLiteralWithExtentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcTextLiteralWithExtent();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPlanarExtent getExtent() {
		return (IfcPlanarExtent)eGet(Ifc2x3Package.eINSTANCE.getIfcTextLiteralWithExtent_Extent(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtent(IfcPlanarExtent newExtent) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcTextLiteralWithExtent_Extent(), newExtent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBoxAlignment() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcTextLiteralWithExtent_BoxAlignment(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBoxAlignment(String newBoxAlignment) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcTextLiteralWithExtent_BoxAlignment(), newBoxAlignment);
	}

} //IfcTextLiteralWithExtentImpl

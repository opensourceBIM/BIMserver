/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcBoundingBox;
import org.bimserver.models.ifc2x3.IfcBoxedHalfSpace;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Boxed Half Space</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBoxedHalfSpaceImpl#getEnclosure <em>Enclosure</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcBoxedHalfSpaceImpl extends IfcHalfSpaceSolidImpl implements IfcBoxedHalfSpace {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcBoxedHalfSpaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcBoxedHalfSpace();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcBoundingBox getEnclosure() {
		return (IfcBoundingBox)eGet(Ifc2x3Package.eINSTANCE.getIfcBoxedHalfSpace_Enclosure(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnclosure(IfcBoundingBox newEnclosure) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcBoxedHalfSpace_Enclosure(), newEnclosure);
	}

} //IfcBoxedHalfSpaceImpl

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcOneDirectionRepeatFactor;
import org.bimserver.models.ifc2x3.IfcVector;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc One Direction Repeat Factor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcOneDirectionRepeatFactorImpl#getRepeatFactor <em>Repeat Factor</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcOneDirectionRepeatFactorImpl extends IfcGeometricRepresentationItemImpl implements IfcOneDirectionRepeatFactor {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcOneDirectionRepeatFactorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcOneDirectionRepeatFactor();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcVector getRepeatFactor() {
		return (IfcVector)eGet(Ifc2x3Package.eINSTANCE.getIfcOneDirectionRepeatFactor_RepeatFactor(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepeatFactor(IfcVector newRepeatFactor) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcOneDirectionRepeatFactor_RepeatFactor(), newRepeatFactor);
	}

} //IfcOneDirectionRepeatFactorImpl
